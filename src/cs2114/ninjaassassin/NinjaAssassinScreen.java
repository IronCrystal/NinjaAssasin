package cs2114.ninjaassassin;

import android.util.Log;
import cs2114.ninjaassassin.drawing.EntityDrawing;
import cs2114.ninjaassassin.world.Location;
import cs2114.ninjaassassin.entity.dynamic.Ninja;
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
    /**
     * Character object
     */
    Ninja ninja;

    // ----------------------------------------------------------
    /**
     * Initializes the level
     * @param level the level
     */
    public void initialize(int level) {
        try
        {
            Log.i("Screen", "level" + level);
            room = new Room(getResources().getAssets().open("level" + level));
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
                    room.getTileMap()[y][x] = tile;
                    add(tile);
                }
            }

            //Create test ninja
            ninja = room.getNinja();
            Log.i("Screen", "The starting location is : " + ninja.getLocation().toString());
            EntityDrawing image = new EntityDrawing("ninja", sideLength, ninja);
            ninja.addObserver(image);
            add(image);
        }
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param x
     * @param y
     */
    public void onTouchDown(float x, float y) {
        if (room != null) {
            room.setTouchingDown(true);
            room.setTouchX(x);
            room.setTouchY(y);
        }
    }

    // ----------------------------------------------------------
    /**
     * Handles the onTouchMove event
     * @param x The x Coordinate
     * @param y The y Coordinate
     */
    public void onTouchMove(float x, float y) {
        if (room != null) {
            room.setTouchingDown(true);
            room.setTouchX(x);
            room.setTouchY(y);
        }
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @param x
     * @param y
     */
    public void onTouchUp(float x, float y) {
        if (room != null) {
            room.setTouchingDown(false);
            room.setTouchX(x);
            room.setTouchY(y);
        }
    }
}
