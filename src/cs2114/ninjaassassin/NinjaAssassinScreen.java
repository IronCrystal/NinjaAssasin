package cs2114.ninjaassassin;

import cs2114.ninjaassassin.world.tile.Tile;
import sofia.app.ShapeScreen;
import java.io.IOException;
import cs2114.ninjaassassin.world.Room;
// -------------------------------------------------------------------------
/**
 *  Represents the screen used in the NinjaAssasin app
 *
 *  @author Andrew Peace
 *  @version Nov 1, 2014
 */
public class NinjaAssassinScreen extends ShapeScreen
{
    /**
     * Room
     */
    Room room;
    public void initialize() {
        try
        {
            room = new Room(getResources().getAssets().open("level1"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        if (room != null) {
            for (int y = 0; y < room.getTileImages().length; y++) {
                for (int x = 0; x < room.getTileImages()[y].length; x++) {
                    float left = x * (getWidth() / room.getTileImages()[y].length) + 1;
                    float top = y * (getHeight() / room.getTileImages().length) + 1;
                    float right = left + (getWidth() / room.getTileImages()[y].length);
                    float bottom = top + (getHeight() / room.getTileImages().length);
                    Tile tile = new Tile(room.getTileImages()[y][x], left, top, right, bottom);
                    add(tile);
                }
            }
        }
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param x
     * @param y
     */
    public void onTouchDown(float x, float y) {
        processTouch(x, y);
    }

    // ----------------------------------------------------------
    /**
     * Handles the onTouchMove event
     * @param x The x Coordinate
     * @param y The y Coordinate
     */
    public void onTouchMove(float x, float y) {
        processTouch(x, y);
    }

    /**
     * Processes the data when the screen is touched.
     */
    private void processTouch(float x, float y) {
        Tile tile;
        tile = getShapes().locatedAt(x, y).withClass(Tile.class).front();
        if (tile != null) {
            tile.animate(1000).rotation(360).alpha(0).removeWhenComplete()
            .play();
        }
        if (this.getShapes().isEmpty()) {
            presentScreen(MainMenuScreen.class);
            finish();
        }
    }
}
