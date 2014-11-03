package cs2114.ninjaassassin.entity.dynamic;

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

public abstract class Enemy
    extends DynamicEntity
{

    private float                fieldOfView;
    private float                rangeOfView;
    private Location             targetLoc;
    private LinkedList<Location> wayPoints;


    // ----------------------------------------------------------
    /**
     * Create a new Enemy object.
     *
     * @param loc
     *            The location of the entity
     * @param imageName
     *            The name of the entity's image
     * @param size
     *            The size of the entity
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
     */
    public Enemy(
        Location loc,
        String imageName,
        int size,
        float speed,
        float health,
        float lethality,
        float fieldOfView,
        float rangeOfView)
    {
        super(loc, imageName, size, speed, health, lethality);
        this.fieldOfView = fieldOfView;
        this.rangeOfView = rangeOfView;
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
        this.setTargetLoc(target.getLocation());
        // Stack<Location> path = findPath(targetLoc);
        // Move along the path
    }


    // ----------------------------------------------------------
    /**
     * Finds a path to the specified target location.
     *
     * @param target
     *            The target location to which to find a path
     * @return A stack of locations marking a path to the target
     */
    public Stack<Location> findPath(Location target)
    {
        // Move toward the target using the solve() method from MazeSolver
        // Return the stack of locations leading from the current location to
        // the target

        // TODO Adapt the solve() method from MazeSolver to fit this class
        return null;
    }
}
