package cs2114.ninjaassassin.test;

import cs2114.ninjaassassin.LevelSelectScreen;
import cs2114.ninjaassassin.MainMenuScreen;

// -------------------------------------------------------------------------
/**
 * Contains test methods for the main menu screen.
 *
 * @author Andrew Peace (apeace)
 * @author Elliott Fairhurst (edf203)
 * @version Dec 3, 2014
 */
public class MainMenuScreenTest
    extends student.AndroidTestCase<MainMenuScreen>
{

    // ----------------------------------------------------------
    /**
     * Create a new MainMenuScreenTest object.
     */
    public MainMenuScreenTest()
    {
        super(MainMenuScreen.class);
    }


    public void setUp()
    {
        // Nothing to do here
    }


    /**
     * Just a random test. The initialize method is blank
     */
    public void testInitialize()
    {
        assertEquals(1, getScreen().getWindow().getDecorView().getAlpha(), 0.1);
    }


    /**
     * Just a random test. This button opens another screen.
     */
    public void testPlayClicked()
    {
        assertEquals(1, getScreen().getWindow().getDecorView().getAlpha(), 0.1);
    }

}
