package cs2114.ninjaassassin;

import cs2114.ninjaassassin.world.tile.Tile;
import sofia.app.ShapeScreen;
import java.io.IOException;
import cs2114.ninjaassassin.world.Room;
import sofia.app.Screen;
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
     * Roo
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
                    float left = x * (getWidth() / room.getTileImages()[y].length);
                    float top = y * (getHeight() / room.getTileImages().length);
                    float right = left + (getWidth() / room.getTileImages()[y].length);
                    float bottom = top + (getHeight() / room.getTileImages().length);
                    Tile tile = new Tile(room.getTileImages()[y][x], left, top, right, bottom);
                    add(tile);
                }
            }
        }
    }
}
