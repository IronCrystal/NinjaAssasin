package cs2114.ninjaassassin.world;

// -------------------------------------------------------------------------
/**
 * Class represents an (x, y) coordinate in a room with a direction.
 *
 * @author Andrew Peace
 * @author Elliott Fairhurst
 * @version Nov 1, 2014
 */
public class Location
{
    private float x;
    private float y;
    private float direction;


    // ----------------------------------------------------------
    /**
     * Create a new Location object with a horizontal and vertical position and
     * a direction.
     *
     * @param x
     *            The horizontal position of the location
     * @param y
     *            The vertical position of the location
     * @param direction
     *            The direction of the position in radians
     */
    public Location(float x, float y, float direction)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }


    // ----------------------------------------------------------
    /**
     * Create a new Location object with integer values for horizontal position,
     * vertical position, and direction.
     *
     * @param x
     *            The integer horizontal position of the location
     * @param y
     *            The integer vertical position of the location
     * @param direction
     *            The integer direction of the location in radians
     */
    public Location(int x, int y, int direction)
    {
        new Location((float)x, (float)y, (float)direction);
    }


    // ----------------------------------------------------------
    /**
     * Sets the horizontal position of the location.
     *
     * @param x
     *            The horizontal position of the location.
     */
    public void setX(float x)
    {
        this.x = x;
    }


    // ----------------------------------------------------------
    /**
     * Sets the vertical position of the location.
     *
     * @param y
     *            The vertical position of the location.
     */
    public void setY(float y)
    {
        this.y = y;
    }


    // ----------------------------------------------------------
    /**
     * Return a new location one space to the north.
     *
     * @return A new location one space to the north
     */
    public Location north()
    {
        return new Location(x, y - 1, direction);
    }


    // ----------------------------------------------------------
    /**
     * Return a new location one space to the south.
     *
     * @return A new location one space to the south
     */
    public Location south()
    {
        return new Location(x, y + 1, direction);
    }


    // ----------------------------------------------------------
    /**
     * Return a new location one space to the east.
     *
     * @return A new location one space to the east
     */
    public Location east()
    {
        return new Location(x + 1, y, direction);
    }


    // ----------------------------------------------------------
    /**
     * Return a new location one space to the west.
     *
     * @return A new location one space to the west
     */
    public Location west()
    {
        return new Location(x - 1, y, direction);
    }


    // ----------------------------------------------------------
    /**
     * Move a given distance in a given direction
     *
     * @param distance
     *            The distance to move
     * @param dir
     *            The direction in which to move
     * @return A new location that is the given distance in the given direction
     *         from this location
     */
    public Location move(float distance, float dir)
    {
        return new Location(
            (float)(x + distance * Math.cos(dir)),
            (float)(y + distance * Math.sin(dir)),
            direction);
    }


    // ----------------------------------------------------------
    /**
     * Sets the direction position of the location.
     *
     * @param direction
     *            The direction of the location.
     */
    public void setDirection(float direction)
    {
        this.direction = direction;
    }


    // ----------------------------------------------------------
    /**
     * Gets the horizontal position of the location.
     *
     * @return The horizontal position of the location.
     */
    public float getX()
    {
        return x;
    }


    // ----------------------------------------------------------
    /**
     * Gets the vertical position of the location.
     *
     * @return The vertical position of the location.
     */
    public float getY()
    {
        return y;
    }


    // ----------------------------------------------------------
    /**
     * Gets the direction of the location.
     *
     * @return The direction of the location.
     */
    public float getDirection()
    {
        return direction;
    }


    // ----------------------------------------------------------
    /**
     * Calculates the relative direction from this location to a given location.
     *
     * @param loc
     *            The other location
     * @return The direction of the other location from this location
     */
    public float getRelativeDirection(Location loc)
    {
        return (float)Math.atan((loc.getY() - y) / (loc.getX() - x));
    }


    // ----------------------------------------------------------
    /**
     * Sets the direction to point toward a given location.
     *
     * @param loc
     *            The location toward which to point
     */
    public void pointToward(Location loc)
    {
        setDirection(getRelativeDirection(loc));
    }


    // ----------------------------------------------------------
    /**
     * Gets the distance from this location to a given location.
     *
     * @param loc
     *            The other location
     * @return The distance between this location and the other
     */
    public float getDistanceFrom(Location loc)
    {
        return (float)Math.sqrt(Math.pow((double)x - (double)loc.getX(), 2)
            + Math.pow((double)y - (double)loc.getY(), 2));
    }

}
