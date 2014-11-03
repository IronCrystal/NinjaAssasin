package cs2114.ninjaassassin.entity;

import cs2114.ninjaassassin.world.Location;
import sofia.graphics.*;

// -------------------------------------------------------------------------
/**
 * Class represents entities in the room.
 *
 * @author Andrew Peace
 * @author Elliott Fairhurst
 * @version Nov 1, 2014
 */
public abstract class Entity
    extends FillableShape
{
    private Location location;
    private int      size;


    // ----------------------------------------------------------
    /**
     * Create a new Entity object with a location, an image, and a size.
     *
     * @param loc
     *            The location of the entity
     * @param imageName
     *            The name of the image of the entity
     * @param size
     *            The size of the entity
     */
    public Entity(Location loc, String imageName, int size)
    {
        this.location = loc;
        this.size = size;

        setImage(imageName);
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
     * Sets the size of the entity.
     *
     * @param size
     *            The size of the entity
     */
    public void setSize(int size)
    {
        this.size = size;
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


    // ----------------------------------------------------------
    /**
     * Returns the size of the entity.
     *
     * @return The size of the entity
     */
    public int getSize()
    {
        return size;
    }
}
