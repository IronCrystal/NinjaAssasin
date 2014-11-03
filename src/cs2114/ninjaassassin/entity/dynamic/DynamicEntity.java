package cs2114.ninjaassassin.entity.dynamic;

import cs2114.ninjaassassin.world.Location;
import cs2114.ninjaassassin.entity.Entity;

// -------------------------------------------------------------------------
/**
 *  Class represents a dynamic entity.  A dynamic entity is anything that has
 *  intelligence.  If it moves, it's dynamic.
 *
 *  @author Andrew Peace
 *  @version Nov 1, 2014
 */
public abstract class DynamicEntity extends Entity
{

    public DynamicEntity(Location loc, String imageName, int size)
    {
        super(loc, imageName, size);
        // TODO Auto-generated constructor stub
    }

}
