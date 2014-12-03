package cs2114.ninjaassassin.entity.dynamic;

import android.util.Log;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Stack;
import cs2114.ninjaassassin.queue.Queue;
import cs2114.ninjaassassin.world.tile.TileType;
import cs2114.ninjaassassin.world.tile.Tile;
import cs2114.ninjaassassin.world.Room;
import cs2114.ninjaassassin.entity.dynamic.DynamicEntity;
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

    private float           fieldOfView;
    private float           rangeOfView;
    private Location        targetLoc;
    private Queue<Location> patrolPath;
    private Mode            mode;
    private float           currentRotation;


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
        Room room)
    {
        super(loc, speed, health, lethality, room);
        this.fieldOfView = fieldOfView;
        this.rangeOfView = rangeOfView;
        mode = Mode.PATROL;
        patrolPath = new Queue<Location>();
        currentRotation = getLocation().getDirection();
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
        patrolPath.offer(wayPoint);
        setChanged();
        notifyObservers();
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
        // Under construction
        return null;
    }


    public void update()
    {
        // Set the target location:
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
            while (testLoc.getDistanceFrom(ninja.getLocation()) >= getSpeed())
            {
                currTile =
                    tiles[(int)Math.floor(testLoc.getY())][(int)Math
                        .floor(testLoc.getX())];
                if (currTile.getType() != TileType.PATH)
                {
                    lineOfSight = false;
                    break;
                }
                testLoc =
                    testLoc.move(
                        getSpeed(),
                        testLoc.getRelativeDirection(ninja.getLocation()));
            }
            // If there is a clear line of sight, target the ninja
            if (lineOfSight)
            {
                mode = Mode.PURSUIT;
                this.setTargetLoc(ninja.getLocation());
            }
        }
        // If the enemy cannot see the ninja,
        else
        {
            // If the enemy is in pursuit mode and has run out of target points,
            if (mode == Mode.PURSUIT && getLocation().equals(targetLoc)
                && currentRotation < (Math.PI * 2) - fieldOfView)
            {
                getLocation().setDirection(
                    getLocation().getDirection() + fieldOfView / 4);
                currentRotation += fieldOfView / 4;
            }
            else if (mode == Mode.PURSUIT
                && getLocation().isCloseTo(this, targetLoc)
                && currentRotation >= (Math.PI * 2) - fieldOfView)
            {
                mode = Mode.PATROL;
            }
            // If the enemy is in patrol mode,
            if (mode == Mode.PATROL)
            {
                if (patrolPath.isEmpty())
                {
                    HashMap<String, Location> map =
                        getRoom().getEnemyPatrolPoints();
                    ArrayList<String> keys =
                        new ArrayList<String>(map.keySet());
                    Collections.sort(keys);
                    for (String str : keys)
                    {
                        patrolPath.offer(map.get(str));
                    }
                    targetLoc = patrolPath.peek();
                    Log.i(
                        "Enemy",
                        "The number of locations added is " + keys.size());
                }
                // If a patrol waypoint is reached,
                else if (this.isCloseTo(targetLoc))
                {
                    // Target the next point and move the last one to the back
                    patrolPath.offer(patrolPath.poll());
                    setTargetLoc(patrolPath.peek());
                }
            }
        }
        // Once a target is selected, turn and move toward it
        this.getLocation().setDirection(
            this.getLocation().getRelativeDirection(targetLoc));
        if (this.canMoveTo(this.getLocation().move(
            this.getSpeed(),
            this.getLocation().getRelativeDirection(targetLoc))))
        {
            this.setLocation(this.getLocation().move(
                this.getSpeed(),
                getLocation().getRelativeDirection(targetLoc)));
        }
        setChanged();
        notifyObservers();
    }


    // -------------------------------------------------------------------------
    /**
     * Write a one-sentence summary of your class here. Follow it with
     * additional details about its purpose, what abstraction it represents, and
     * how to use it.
     *
     * @author Andrew Peace
     * @author Elliott Fairhurst
     * @version Dec 3, 2014
     */

    private static enum Mode
    {
        /**
         * The entity is pursuing another entity
         */
        PURSUIT,
        /**
         * The entity is moving along a predetermined path
         */
        PATROL;
    }

}
