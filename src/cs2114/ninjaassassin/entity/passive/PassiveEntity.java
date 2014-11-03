package cs2114.ninjaassassin.entity.passive;

import cs2114.ninjaassassin.world.Location;
import cs2114.ninjaassassin.entity.Entity;

// -------------------------------------------------------------------------
/**
 *  Class represents a passive entity.  A passive entity is an entity in the
 *  room which does nothing.  Instances include walls or powerups.
 *
 *  @author Andrew Peace
 *  @version Nov 1, 2014
 */
public abstract class PassiveEntity extends Entity
{

    public PassiveEntity(Location loc, String imageName, int size)
    {
        super(loc, imageName, size);
        // TODO Auto-generated constructor stub
    }

}
