package cs2114.ninjaassassin.test;

import java.io.InputStream;
import cs2114.ninjaassassin.world.Room;
import cs2114.ninjaassassin.entity.dynamic.Enemy;
import cs2114.ninjaassassin.entity.dynamic.DynamicEntity;
import cs2114.ninjaassassin.world.Location;

// -------------------------------------------------------------------------
/**
 * Contains test methods for the Location class.
 *
 * @author Andrew Peace (apeace)
 * @author Elliott Fairhurst (edf203)
 * @version Nov 2, 2014
 */
public class LocationTest
    extends student.TestCase
{
    private Location      loc1;
    private Location      loc2;
    private DynamicEntity ent;
    private Room          room;


    // ----------------------------------------------------------
    /**
     * Create a new LocationTest object.
     */
    public LocationTest()
    {
        // Empty constructor. Initialization is handled in setUp().
    }


    /**
     * Sets up a new test case.
     */
    public void setUp()
    {
        loc1 = new Location(0, 0, 0);
        loc2 = new Location(3, 4, 0);
        ent = new Enemy(loc1, 2, 1, 1, (float)Math.PI / 4, 5, null);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testGetDirection()
    {
        assertTrue(loc1.getDirection() - 0 < 0.0001);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testGetDistanceFrom()
    {
        assertTrue(loc1.getDistanceFrom(loc2) - 5 < 0.0001);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testGetRelativeDirection()
    {
        loc2.setY(0);
        assertTrue(loc1.getRelativeDirection(loc2) < 0.00001);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testGetX()
    {
        assertTrue(loc1.getX() < 0.0001);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testGetY()
    {
        assertTrue(loc1.getY() < 0.0001);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testIsCloseTo()
    {
        loc2.setX(1);
        loc2.setY(0);
        assertTrue(ent.isCloseTo(loc2));
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testMove()
    {
        assertTrue(loc1.move(1, 0).getX() - 1 < 0.0001);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testPointToward()
    {
        loc2.setX(2);
        loc2.setY(2);
        loc1.pointToward(loc2);
        assertTrue(loc1.getDirection() - Math.PI / 4 < 0.0001);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testSetDirection()
    {
        loc1.setDirection((float)Math.PI);
        assertTrue(loc1.getDirection() - Math.PI < 0.0001);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testSetX()
    {
        loc2.setX(2);
        assertTrue(loc2.getX() - 2 < 0.0001);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testSetY()
    {
        loc2.setY(2);
        assertTrue(loc2.getY() - 2 < 0.0001);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void testToString()
    {
        assertEquals(loc1.toString(), "(0, 0)");
    }
}
