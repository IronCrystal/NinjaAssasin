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
    extends RectangleShape
{
    private Location location;
    private int      size;

    public Entity(Location loc, String imageName, int size)
    {
        this.location = loc;
        this.size = size;

        setImage(imageName);
    }

    public void setLocation(Location loc)
    {
        this.location = loc;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public Location getLocation()
    {
        return location;
    }

    public int getSize()
    {
        return size;
    }
}
