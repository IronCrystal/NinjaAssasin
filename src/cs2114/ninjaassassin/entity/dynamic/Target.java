package cs2114.ninjaassassin.entity.dynamic;

import cs2114.ninjaassassin.world.Location;
import cs2114.ninjaassassin.world.Room;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Andrew Peace (apeace)
 *  @version Dec 3, 2014
 */
public class Target extends DynamicEntity
{

    // ----------------------------------------------------------
    /**
     * Create a new Target object.
     * @param loc The Location
     * @param speed The Speed
     * @param health The Health
     * @param lethality The Lethality
     * @param room The room
     */
    public Target(
        Location loc,
        float speed,
        float health,
        float lethality,
        Room room)
    {
        super(loc, speed, health, lethality, room);
    }

    @Override
    public void update()
    {
        if (this.isCloseTo(getRoom().getNinja())) {
            getRoom().setHasWon(true);
        }

    }
}
