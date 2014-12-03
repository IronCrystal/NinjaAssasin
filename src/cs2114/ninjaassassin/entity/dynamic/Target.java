package cs2114.ninjaassassin.entity.dynamic;

import cs2114.ninjaassassin.world.Location;
import cs2114.ninjaassassin.world.Room;

// -------------------------------------------------------------------------
/**
 * Represents the target character in NinjaAssassin.
 *
 * @author Andrew Peace (apeace)
 * @author Elliott Fairhurst (edf203)
 * @version Dec 3, 2014
 */
public class Target
    extends DynamicEntity
{

    // ----------------------------------------------------------
    /**
     * Create a new Target object.
     *
     * @param loc
     *            The Location
     * @param speed
     *            The Speed
     * @param health
     *            The Health
     * @param lethality
     *            The Lethality
     * @param room
     *            The room
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
        if (this.isCloseTo(getRoom().getNinja()))
        {
            getRoom().setHasWon(true);
        }

    }
}
