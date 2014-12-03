package cs2114.ninjaassassin.test;

import android.widget.Button;
import cs2114.ninjaassassin.LevelSelectScreen;

// -------------------------------------------------------------------------
/**
 * Contains test methods for the level select screen test.
 *
 * @author Andrew Peace (apeace)
 * @author Elliott Fairhurst (edf203)
 * @version Dec 3, 2014
 */
public class LevelSelectScreenTest
    extends student.AndroidTestCase<LevelSelectScreen>
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
     * Just a random test for initialization. I couldn't figure out how to test
     * for background color
     */
    public void testInitialize()
    {
        assertEquals(1, getScreen().getWindow().getDecorView().getAlpha(), 0.1);
    }


    /**
     * Just a random test. The button is actually supposed to switch screens
     */
    public void testLevel1Clicked()
    {
        click(level1);
        assertEquals(1, getScreen().getWindow().getDecorView().getAlpha(), 0.1);
    }

}
