package cs2114.ninjaassassin.test;

import android.graphics.Color;
import cs2114.ninjaassassin.LevelSelectScreen;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Andrew Peace (apeace)
 *  @version Dec 3, 2014
 */
public class LevelSelectScreenTest extends student.AndroidTestCase<LevelSelectScreen>
{

 // ----------------------------------------------------------
    /**
     * Create a new NinjaAssasinScreenTest object.
     */
    public LevelSelectScreenTest()
    {
        super(LevelSelectScreen.class);
    }

    public void setUp()
    {
        // Nothing to do here
    }

    /**
     * Assert that the background is black
     */
    public void testInitialize() {
        assertEquals(Color.BLACK, getScreen().getWindow().getDecorView().getSolidColor());
    }

}
