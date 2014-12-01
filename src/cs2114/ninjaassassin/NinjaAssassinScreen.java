package cs2114.ninjaassassin;

import cs2114.ninjaassassin.world.tile.TileType;
import android.graphics.Canvas;
import sofia.graphics.ShapeView;
import sofia.app.Screen;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
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
    //public ImageView levelBackground;
    //public ShapeView shapeView;

    public void initialize() {
        try
        {
            room = new Room(getResources().getAssets().open("level1"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //shapeView.draw(room.getCanvas());
        //shapeView.setBackgroundColor(sofia.graphics.Color.white);
        //levelBackground.setImageBitmap(room.getBackground());
        //levelBackground.setBackgroundColor(Color.WHITE);
        //levelBackground.draw(room.getCanvas());
        //levelBackground.setBackgroundColor(Color.GREEN);
        //levelBackground.setImageDrawable(new BitmapDrawable(getResources(), room.getBackground()));
        if (room != null) {
            float sideLength = getWidth() / room.getTileImages()[0].length;
            /*Tile tile1 = new Tile(room.getTileImages()[0][0], 0, 0, sideLength, sideLength, TileType.getTileType(room.getTileImages()[0][0]));
            add(tile1);
            Tile tile2 = new Tile(room.getTileImages()[1][0], 0, sideLength, sideLength, sideLength * 2, TileType.getTileType(room.getTileImages()[0][0]));
            add(tile2);*/
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
        //processTouch(x, y);
    }

    // ----------------------------------------------------------
    /**
     * Handles the onTouchMove event
     * @param x The x Coordinate
     * @param y The y Coordinate
     */
    public void onTouchMove(float x, float y) {
        //processTouch(x, y);
    }

    /**
     * Processes the data when the screen is touched.
     */
    /*private void processTouch(float x, float y) {
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
    }*/
}
