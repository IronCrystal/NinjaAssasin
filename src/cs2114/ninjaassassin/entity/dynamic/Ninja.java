package cs2114.ninjaassassin.entity.dynamic;

import cs2114.ninjaassassin.world.Location;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Elliott
 * @version Dec 1, 2014
 */

public class Ninja
    extends DynamicEntity
{

    // ----------------------------------------------------------
    /**
     * Create a new Ninja object.
     *
     * @param loc
     * @param imageName
     * @param size
     * @param speed
     * @param health
     * @param lethality
     */
    public Ninja(
        Location loc,
        String imageName,
        int size,
        float speed,
        float health,
        float lethality)
    {
        super(loc, speed, health, lethality);
    }


    // ----------------------------------------------------------
    @Override
    public void update()
    {
        // Working on this part
    }

}
