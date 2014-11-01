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
     *            The direction of the position
     */
    public Location(float x, float y, float direction)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
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

}
