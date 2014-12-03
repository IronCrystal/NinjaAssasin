package cs2114.ninjaassassin;

import android.widget.Toast;
import android.content.Context;
import cs2114.ninjaassassin.entity.dynamic.Target;
import sofia.graphics.Color;
import android.graphics.PointF;
import android.util.Log;
import android.widget.TextView;
import cs2114.ninjaassassin.drawing.EntityDrawing;
import cs2114.ninjaassassin.entity.Entity;
import cs2114.ninjaassassin.entity.dynamic.Enemy;
import cs2114.ninjaassassin.entity.dynamic.FieldOfView;
import cs2114.ninjaassassin.entity.dynamic.Ninja;
import cs2114.ninjaassassin.world.Room;
import cs2114.ninjaassassin.world.tile.Tile;
import cs2114.ninjaassassin.world.tile.TileType;
import java.io.IOException;
import sofia.app.ShapeScreen;
import sofia.graphics.OvalShape;
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

    /**
     * Header text box
     */
    public TextView header;

    /**
     * Size of the images
     */
    private float sideLength = 0;

    private int level;

    // ----------------------------------------------------------
    /**
     * Initializes the level
     * @param level the level
     */
    public void initialize(int level) {
        this.level = level;
        try
        {
            Log.i("Screen", "level" + level);
            room = new Room(getResources().getAssets().open("level" + level));
            header.setText(room.getName());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        if (room != null) {
            sideLength = getWidth() / room.getTileImages()[0].length;

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



            //Create all entities
            for (Entity entity : room.getEntities()) {
                if (entity instanceof Enemy) {
                    Enemy enemy = (Enemy) entity;
                    EntityDrawing i = new EntityDrawing("enemy", sideLength, enemy);
                    enemy.addObserver(i);
                    add(i);
                    FieldOfView view = new FieldOfView(enemy, sideLength);
                    enemy.addObserver(view);
                    add(view);
                }
                else if (entity instanceof Target) {
                    Target target = (Target) entity;
                    EntityDrawing i = new EntityDrawing("target", sideLength, target);
                    target.addObserver(i);
                    add(i);
                }
            }

          //Create ninja
            ninja = room.getNinja();
            Log.i("Screen", "The starting location is : " + ninja.getLocation().toString());
            EntityDrawing image = new EntityDrawing("ninja", sideLength, ninja);
            ninja.addObserver(image);
            add(image);
        }
        else {
            Log.e("Screen", "ROOM IS NULL");
        }
    }

    // ----------------------------------------------------------
    /**
     * Returns the room object
     * @return room The Room
     */
    public Room getRoom() {
        return room;
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
            room.setTouchX(x / sideLength);
            room.setTouchY(y / sideLength);
            if (room.getHasWon()) {
                Context context = getApplicationContext();
                CharSequence text = "You beat level " + level;
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                presentScreen(LevelSelectScreen.class);
                finish();
            }
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
            room.setTouchX(x / sideLength);
            room.setTouchY(y / sideLength);
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
            room.setTouchX(x / sideLength);
            room.setTouchY(y / sideLength);
        }
    }
}
