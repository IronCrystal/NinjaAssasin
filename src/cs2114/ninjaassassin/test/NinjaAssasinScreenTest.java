package cs2114.ninjaassassin.test;

import sofia.graphics.ShapeView;
import android.view.View;
import cs2114.ninjaassassin.NinjaAssassinScreen;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Andrew Peace
 * @version Nov 2, 2014
 */
public class NinjaAssasinScreenTest
    extends student.AndroidTestCase<NinjaAssassinScreen>
{

    public ShapeView shapeView;

    // ----------------------------------------------------------
    /**
     * Create a new NinjaAssasinScreenTest object.
     */
    public NinjaAssasinScreenTest()
    {
        super(NinjaAssassinScreen.class);
    }


    public void setUp()
    {
        // Nothing to do here
    }

    // ----------------------------------------------------------
    /**
     * Tests the touch down method
     */
    public void testTouchDown() {
        touchDown(shapeView, 2, 2);
        assertNull(getScreen().getRoom());
        //assertTrue(getScreen().getRoom().isTouchingDown());
    }
}
