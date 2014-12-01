package cs2114.ninjaassassin;

import cs2114.ninjaassassin.world.Room;
import cs2114.ninjaassassin.world.tile.Tile;
import cs2114.ninjaassassin.world.tile.TileType;
import java.io.IOException;
import sofia.app.ShapeScreen;
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
            float sideLength = getWidth() / room.getTileImages()[0].length;

            for (int y = 0; y < room.getTileImages().length; y++) {
                for (int x = 0; x < room.getTileImages()[y].length; x++) {
                    float left = x * sideLength;
                    float top = y * sideLength;
                    float right = left + sideLength;
                    float bottom = top + sideLength;
                    Tile tile = new Tile(room.getTileImages()[y][x], left, top, right, bottom, TileType.getTileType(room.getTileImages()[y][x]));
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
        //TODO
    }

    // ----------------------------------------------------------
    /**
     * Handles the onTouchMove event
     * @param x The x Coordinate
     * @param y The y Coordinate
     */
    public void onTouchMove(float x, float y) {
        //TODO
    }
}
