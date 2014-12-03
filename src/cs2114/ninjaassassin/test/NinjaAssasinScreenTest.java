package cs2114.ninjaassassin.test;

import sofia.graphics.ShapeView;
import android.view.View;
import cs2114.ninjaassassin.NinjaAssassinScreen;

// -------------------------------------------------------------------------
/**
 * Contains test methods for the NinjaAssassinScreen class.
 *
 * @author Andrew Peace (apeace)
 * @author Elliott Fairhurst (edf203)
 * @version Nov 2, 2014
 */
public class NinjaAssasinScreenTest
    extends student.AndroidTestCase<NinjaAssassinScreen>
{

    /**
     * shapeView for use in testing
     */
    public ShapeView shapeView;


    // ----------------------------------------------------------
    /**
     * Create a new NinjaAssasinScreenTest object.
     */
    public NinjaAssasinScreenTest()
    {
        super(NinjaAssassinScreen.class);
    }


    /**
     * Sets up a new test case.
     */
    public void setUp()
    {
        // Nothing to do here
    }


    // ----------------------------------------------------------
    /**
     * Tests the touch down method
     */
    public void testTouchDown()
    {
        touchDown(shapeView, 2, 2);
        assertNull(getScreen().getRoom());
        // assertTrue(getScreen().getRoom().isTouchingDown());
    }
}
