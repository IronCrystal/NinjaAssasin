package cs2114.ninjaassassin.test;

import cs2114.ninjaassassin.LevelSelectScreen;
import cs2114.ninjaassassin.MainMenuScreen;

public class MainMenuScreenTest extends student.AndroidTestCase<MainMenuScreen>
{

    public MainMenuScreenTest()
    {
        super(MainMenuScreen.class);
    }

    public void setUp()
    {
        // Nothing to do here
    }

    /**
     * Just a random test.  The initialize method is blank
     */
    public void testInitialize() {
        assertEquals(1, getScreen().getWindow().getDecorView().getAlpha(), 0.1);
    }

    /**
     * Just a random test.  This button opens another screen.
     */
    public void testPlayClicked() {
        assertEquals(1, getScreen().getWindow().getDecorView().getAlpha(), 0.1);
    }

}
