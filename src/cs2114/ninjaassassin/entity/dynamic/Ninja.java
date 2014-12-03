package cs2114.ninjaassassin.entity.dynamic;

import cs2114.ninjaassassin.world.tile.TileType;
import android.util.Log;
import cs2114.ninjaassassin.world.Location;
import cs2114.ninjaassassin.world.Room;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Andrew Peace
 * @author Elliott Fairhurst
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
            /*double deltaX = targetLoc.getX() - getLocation().getX();
            double deltaY = targetLoc.getY() - getLocation().getY();

            // now you know how much far they are
            double coeff = 0.01; //this coefficient can be tweaked to decice how much near the two points will be after the update.. 0.5 = 50% of the previous distance
            Location newLoc = new Location((float) (getLocation().getX() + coeff*deltaX), (float) (getLocation().getY() + coeff*deltaY), 0f);
            Log.i("Ninja", "Setting the location from " + getLocation().toString() + " to " + newLoc.toString());
            setLocation(newLoc);*/
            Location newLocation =
                getLocation().move(
                    getSpeed(),
                    getLocation().getRelativeDirection(targetLoc));
            Log.i("Ninja", "The relative Direction is: " + getLocation().getRelativeDirection(targetLoc) + " which is " + Math.toDegrees(getLocation().getRelativeDirection(targetLoc)) + " degrees");
            Log.i("Ninja", "It is attempting to move toward: " + newLocation.toString());
            if (canMoveTo(newLocation))
            {
                setLocation(newLocation);
            }
            else { //Try a direction pi/6 above and below to try to move around obstacles
                Location newLocation2 =
                    getLocation().move(
                        getSpeed(),
                        (float) (getLocation().getRelativeDirection(targetLoc) + (Math.PI/3)));
                if (canMoveTo(newLocation2))
                {
                    setLocation(newLocation2);
                }
                else {
                    Location newLocation3 =
                        getLocation().move(
                            getSpeed(),
                            (float) (getLocation().getRelativeDirection(targetLoc) - (Math.PI/3)));
                    if (canMoveTo(newLocation3))
                    {
                        setLocation(newLocation3);
                    }
                }
            }
        }
    }
}
