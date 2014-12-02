package cs2114.ninjaassassin.entity.dynamic;

import cs2114.ninjaassassin.world.tile.TileType;
import cs2114.ninjaassassin.world.tile.Tile;
import android.graphics.RectF;
import sofia.graphics.Drawing;
import cs2114.ninjaassassin.entity.Entity;
import cs2114.ninjaassassin.world.Room;
import cs2114.ninjaassassin.graph.Graph;
import cs2114.ninjaassassin.entity.dynamic.DynamicEntity;
import java.util.*;
import cs2114.ninjaassassin.world.Location;

// -------------------------------------------------------------------------
/**
 * Class represents an enemy. Enemies are AI-driven active entities which patrol
 * the map on a predefined circuit until a user is spotted, at which point they
 * will path-find toward the player's last known location and from there, will
 * work their way randomly through the map until the player is spotted again.
 * Enemies are capable of ranged attacks.
 *
 * @author Elliott Fairhurst
 * @version Nov 1, 2014
 */

public class Enemy
    extends DynamicEntity
{

    private float                fieldOfView;
    private float                rangeOfView;
    private Location             targetLoc;
    private LinkedList<Location> wayPoints;
    private Stack<Location>      path;
    private Stack<Integer>       intPath;
    private double[]             distances;
    private Graph                graph;
    private String               mode;


    // ----------------------------------------------------------
    /**
     * Create a new Enemy object.
     *
     * @param loc
     *            The location of the entity
     * @param speed
     *            The speed of the entity
     * @param health
     *            The health of the entity
     * @param lethality
     *            The lethality of the entity
     * @param fieldOfView
     *            The field of view of the enemy in radians
     * @param rangeOfView
     *            The range of view of the enemy
     * @param graph
     *            The Graph of the accessible areas of the room
     * @param room
     *            The room in which the entity exists
     */
    public Enemy(
        Location loc,
        float speed,
        float health,
        float lethality,
        float fieldOfView,
        float rangeOfView,
        Graph graph,
        Room room)
    {
        super(loc, speed, health, lethality, room);
        this.fieldOfView = fieldOfView;
        this.rangeOfView = rangeOfView;
        this.graph = graph;
        mode = "patrol";
        wayPoints.add(loc); // Add the starting location to the patrol circuit
    }


    // ----------------------------------------------------------
    /**
     * Sets the location of the target, toward which the enemy will move.
     *
     * @param tLoc
     *            The location of the target
     */
    public void setTargetLoc(Location tLoc)
    {
        this.targetLoc = tLoc;
        setChanged();
        notifyObservers();
    }


    // ----------------------------------------------------------
    /**
     * Sets the field of view, which is the directional range within which an
     * enemy will begin pursuit and attack of a user.
     *
     * @param fOV
     *            The field of view in radians
     */
    public void setFieldOfView(float fOV)
    {
        this.fieldOfView = fOV;
        setChanged();
        notifyObservers();
    }


    // ----------------------------------------------------------
    /**
     * Sets the range of view, which is the distance within which an enemy will
     * begin pursuit and attack of a user.
     *
     * @param rOV
     *            The range of view
     */
    public void setRangeOfView(float rOV)
    {
        this.rangeOfView = rOV;
        setChanged();
        notifyObservers();
    }


    // ----------------------------------------------------------
    /**
     * Gets the location of the target, toward which the enemy will move.
     *
     * @return The location of the target
     */
    public Location getTargetLoc()
    {
        return targetLoc;
    }


    // ----------------------------------------------------------
    /**
     * Sets the field of view, which is the directional range within which an
     * enemy will begin pursuit and attack of a user.
     *
     * @return The field of view
     */
    public float getFieldOfView()
    {
        return fieldOfView;
    }


    // ----------------------------------------------------------
    /**
     * Gets the range of view, which is the distance within which an enemy will
     * begin pursuit and attack of a user.
     *
     * @return The range of view
     */
    public float getRangeOfView()
    {
        return rangeOfView;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param wayPoint
     */
    public void addWayPoint(Location wayPoint)
    {
        wayPoints.add(wayPoint);
        setChanged();
        notifyObservers();
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void patrol()
    {
        // Move toward next waypoint using pathFind
        // If the current location equals the current waypoint,
        // Set the waypoint equal to the next waypoint
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     *
     * @param target
     */
    public void pursue(DynamicEntity target)
    {
        // Move along the path found in findPath()
    }


    // ----------------------------------------------------------
    /**
     * Finds a path to the specified target location.
     *
     * @param target
     *            The target location to which to find a path
     * @return A stack of locations marking a path to the target
     */
    public Stack<Integer> findPath(int start, int[] pred, double[] dist)
    {
        int numV = graph.getNumV();
        HashSet<Integer> vMinusS = new HashSet<Integer>(numV);

        // Initialize V-S
        for (int i = 0; i < numV; i++)
        {
            if (i != start)
            {
                vMinusS.add(i);
            }
        }

        // Initialize pred and dist
        for (int v : vMinusS)
        {
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
        }

        // Main loop
        while (vMinusS.size() != 0)
        {
            // Find the value u in V-S with the smallest dist[u]
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int v : vMinusS)
            {
                if (dist[v] < minDist)
                {
                    minDist = dist[v];
                    u = v;
                }
            }

            // Remove u from vMinusS
            vMinusS.remove(u);

            // Update the distances
            for (int v : vMinusS)
            {
                if (graph.isEdge(u, v))
                {
                    double weight = graph.getEdge(u, v).getWeight();
                    if (dist[u] + weight < dist[v])
                    {
                        dist[v] = dist[u] + weight;
                        pred[v] = u;
                    }
                }
            }
        }
        intPath = new Stack<Integer>();
        for (int i = 0; i < pred.length; i++)
        {
            intPath.push(pred[i]);
        }
        setChanged();
        notifyObservers();
        return intPath;
    }


    public void update()
    {
        // If this enemy can see the ninja
        Ninja ninja = getRoom().getNinja();
        if ((ninja.getLocation().getDistanceFrom(this.getLocation()) <= rangeOfView)
            && (ninja.getLocation().getRelativeDirection(this.getLocation()) <= getLocation()
                .getDirection() + fieldOfView / 2)
            && (ninja.getLocation().getRelativeDirection(this.getLocation()) >= getLocation()
                .getDirection() - fieldOfView / 2))
        {
            // Verify clear line of sight
            Location testLoc = this.getLocation();
            Tile[][] tiles = getRoom().getTileMap();
            Tile currTile;
            boolean lineOfSight = true;
            while (testLoc.getDistanceFrom(ninja.getLocation()) > 0)
            {
                currTile =
                    tiles[Math.round(testLoc.getX())][Math
                        .round(testLoc.getY())];
                if (currTile.getType() == TileType.PATH)
                {
                    lineOfSight = false;
                    break;
                }
            }
            // If there is a clear line of sight, target the ninja
            if (lineOfSight)
            {
                mode = "pursuit";
                this.setTargetLoc(ninja.getLocation());
                // Path find
            }
        }
        // Turn toward the ninja
        this.getLocation().setDirection(
            this.getLocation().getRelativeDirection(targetLoc));
        this.setLocation(this.getLocation().move(
            this.getSpeed(),
            getLocation().getRelativeDirection(targetLoc)));
        setChanged();
        notifyObservers();

        // Check for ninja
        // If ninja is spotted,
        // Mode = pursuit
        // Set target location to ninja's position
        // Find path to target location and store in stack
        // Set target location to top of stack
        // If not,
        // If mode = patrol,
        // Set target location to next patrol location
        // Change viewing direction sinusoidally
        // If mode = pursuit,
        // If the stack is not empty,
        // Set target location to top of stack
        // If the stack is empty,
        // Rotate clockwise one unit
        // Counter += rotation unit size
        // If counter > 2*pi radians - field of view,
        // Set mode to patrol
        // Break
        // Move one unit toward the target location
    }
}
