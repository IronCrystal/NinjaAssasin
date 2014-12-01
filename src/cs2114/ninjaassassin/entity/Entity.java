package cs2114.ninjaassassin.entity;

import cs2114.ninjaassassin.world.Location;

// -------------------------------------------------------------------------
/**
 * Class represents entities in the room.
 *
 * @author Andrew Peace
 * @author Elliott Fairhurst
 * @version Nov 1, 2014
 */
public abstract class Entity
{
    private Location location;


    // ----------------------------------------------------------
    /**
     * Create a new Entity object with a location, an image, and a size.
     *
     * @param loc
     *            The location of the entity
     */
    public Entity(Location loc)
    {
        this.location = loc;
    }


    // ----------------------------------------------------------
    /**
     * Sets the location of the entity.
     *
     * @param loc
     *            The location of the entity.
     */
    public void setLocation(Location loc)
    {
        this.location = loc;
    }


    // ----------------------------------------------------------
    /**
     * Returns the location of the entity.
     *
     * @return The location of the entity
     */
    public Location getLocation()
    {
        return location;
    }

}
