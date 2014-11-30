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
    private LinkedList<Location> path;


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
        // Assign to every node a tentative distance value: set it to zero for
        // our initial node and to infinity for all other nodes.

        // Mark all nodes unvisited. Set the initial node as current. Create a
        // set of the unvisited nodes called the unvisited set consisting of
        // all the nodes.

        // For the current node, consider all of its unvisited neighbors and
        // calculate their tentative distances. Compare the newly calculated
        // tentative distance to the current assigned value and assign the
        // smaller one. For example, if the current node A is marked with a
        // distance of 6, and the edge connecting it with a neighbor B has
        // length 2, then the distance to B (through A) will be 6 + 2 = 8. If
        // B was previously marked with a distance greater than 8 then change
        // it to 8. Otherwise, keep the current value.

        // When we are done considering all of the neighbors of the current
        // node, mark the current node as visited and remove it from the
        // unvisited set. A visited node will never be checked again.

        // If the destination node has been marked visited (when planning a
        // route between two specific nodes) or if the smallest tentative
        // distance among the nodes in the unvisited set is infinity (when
        // planning a complete traversal; occurs when there is no connection
        // between the initial node and remaining unvisited nodes), then stop.
        // The algorithm has finished.

        // Select the unvisited node that is marked with the smallest
        // tentative distance, and set it as the new "current node" then go
        // back to step 3.
        return null;
    }
}
