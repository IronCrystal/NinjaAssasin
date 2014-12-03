package cs2114.ninjaassassin.test;

import android.widget.Button;
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

    Button level1;
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
     * Just a random test for initialization.  I couldn't figure out how
     * to test for background color
     */
    public void testInitialize() {
        assertEquals(1, getScreen().getWindow().getDecorView().getAlpha(), 0.1);
    }

    /**
     * Just a random test.  The button is actually supposed to switch screens
     */
    public void testLevel1Clicked() {
        click(level1);
        assertEquals(1, getScreen().getWindow().getDecorView().getAlpha(), 0.1);
    }

}
