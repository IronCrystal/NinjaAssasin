package cs2114.ninjaassassin;

import sofia.app.Screen;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Andrew Peace (apeace)
 *  @version Nov 3, 2014
 */
public class MainMenuScreen extends Screen
{

    public void initialize() {
        //TODO
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void playClicked() {
        presentScreen(LevelSelectScreen.class);
        finish();
    }
}
