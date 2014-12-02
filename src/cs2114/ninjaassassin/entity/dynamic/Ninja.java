package cs2114.ninjaassassin.entity.dynamic;

import cs2114.ninjaassassin.world.tile.TileType;
import cs2114.ninjaassassin.world.Room;
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
    private Location targetLoc;


    // ----------------------------------------------------------
    /**
     * Create a new Ninja object.
     *
     * @param loc
     *            The location of the ninja
     * @param speed
     *            The speed of the ninja (distance per update)
     * @param health
     *            The health of the ninja
     * @param lethality
     *            The lethality of the ninja
     * @param targetLoc
     *            The ninja's target location
     * @param room
     *            The room
     */
    public Ninja(
        Location loc,
        float speed,
        float health,
        float lethality,
        Room room)
    {
        super(loc, speed, health, lethality, room);
        this.targetLoc = loc;
    }


    // ----------------------------------------------------------
    /**
     * Sets the target location
     *
     * @param tLoc
     *            The target location
     */
    public void setTargetLoc(Location tLoc)
    {
        targetLoc = tLoc;
        setChanged();
        notifyObservers();
    }


    // ----------------------------------------------------------
    @Override
    public void update()
    {
        if (getRoom().isTouchingDown())
        {
            setTargetLoc(new Location(getRoom().getTouchX(), getRoom()
                .getTouchY(), 0));
            Location newLocation =
                getLocation().move(
                    getSpeed(),
                    getLocation().getRelativeDirection(targetLoc));
            if (tileAt(newLocation).getType() == TileType.PATH)
            {
                setLocation(newLocation);
            }
        }
    }
}
