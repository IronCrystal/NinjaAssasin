package cs2114.ninjaassassin.test;

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
        loc1 = new Location(2, 3, 0);
        loc2 = new Location(5, 2, 0);
    }
}
