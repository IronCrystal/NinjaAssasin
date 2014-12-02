package cs2114.ninjaassassin;

import android.graphics.Color;
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
public class LevelSelectScreen extends Screen
{
    public void initialize() {
        getWindow().getDecorView().setBackgroundColor(Color.BLACK);
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void level1Clicked() {
        presentScreen(NinjaAssassinScreen.class, 1);
        finish();
    }
}
