package cs2114.ninjaassassin.world;

import android.graphics.BitmapFactory;
import android.content.res.Resources;
import cs2114.ninjaassassin.R;
import android.graphics.Canvas;
import android.graphics.Bitmap;
import cs2114.ninjaassassin.entity.Entity;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// -------------------------------------------------------------------------
/**
 *  Class represents the current level.
 *
 *  @author Andrew Peace
 *  @version Nov 1, 2014
 */
public class Room implements Runnable
{
    private List<Entity> entities;
    private String[][] tileImages;
    private Bitmap[][] bitmaps;

    private Location playerExit;
    private Location playerStart;
    private Location targetStart;

    private HashMap<Entity, Location> enemyStartLocations;

    //private File file;
    private InputStream inputStream;

    private Resources resources;

    private Bitmap background;
    private Canvas canvas;

    // ----------------------------------------------------------
    /**
     * Create a new Room object.
     * @param is The input stream
     */
    public Room(InputStream is, Resources resources) {
        //this.file = file;
        inputStream = is;
        background = null;
        this.resources = resources;
        parseFile();
        createBackgroundImage();
    }

    // ----------------------------------------------------------
    /**
     * Returns the hashmap of enemies and their starting locations
     * @return enemyStartLocations Hashmap of entities and location
     */
    public HashMap<Entity, Location> getEnemyStartLocations()
    {
        return enemyStartLocations;
    }

    // ----------------------------------------------------------
    /**
     * Returns a list of all entities in the room
     * @return entities The Entities
     */
    public List<Entity> getEntities() {
        return entities;
    }

    // ----------------------------------------------------------
    /**
     * Returns the data file for the room
     * @return file The Data file
     */
    //public File getFile()
    // {
    //     return file;
    //}

    // ----------------------------------------------------------
    /**
     * Returns the location of the exit
     * @return exit The Exit
     */
    public Location getPlayerExit() {
        return playerExit;
    }

    // ----------------------------------------------------------
    /**
     * Returns the location where the player starts
     * @return playerStart The Starting Location
     */
    public Location getPlayerStart()
    {
        return playerStart;
    }

    // ----------------------------------------------------------
    /**
     * Returns the location where the target starts
     * @return targetStart The Target's Starting Location
     */
    public Location getTargetStart()
    {
        return targetStart;
    }

    // ----------------------------------------------------------
    /**
     * Returns the tiles of the room
     * @return tiles The tiles
     */
    public String[][] getTileImages()
    {
        return tileImages;
    }

    private void parseFile() {
        try
        {
            BufferedReader in = new BufferedReader
                (new InputStreamReader(inputStream));
            String str;
            int height = 0;
            int width = 0;
            ArrayList<String> tileList = new ArrayList<String>();
            while ((str = in.readLine()) != null) {
                height++;
                String[] chars = str.split(" ");
                width = chars.length;
                for (String string : chars) {
                    tileList.add("tile" + string);
                }
            }
            inputStream.close();
            in.close();
            tileImages = new String[height][width];
            bitmaps = new Bitmap[height][width];
            for (int x = 0; x < tileList.size(); x++) {
                tileImages[x / width][x % width] = tileList.get(x);
                if (tileList.get(x).equalsIgnoreCase("tile0")) {
                    bitmaps[x / width][x % width] = BitmapFactory.decodeResource(resources, R.drawable.tile0);
                }
                else if (tileList.get(x).equalsIgnoreCase("tile2")) {
                    bitmaps[x / width][x % width] = BitmapFactory.decodeResource(resources, R.drawable.tile2);
                }
                else if (tileList.get(x).equalsIgnoreCase("tile3")) {
                    bitmaps[x / width][x % width] = BitmapFactory.decodeResource(resources, R.drawable.tile3);
                }
                else if (tileList.get(x).equalsIgnoreCase("tile4")) {
                    bitmaps[x / width][x % width] = BitmapFactory.decodeResource(resources, R.drawable.tile4);
                }
                else if (tileList.get(x).equalsIgnoreCase("tile5")) {
                    bitmaps[x / width][x % width] = BitmapFactory.decodeResource(resources, R.drawable.tile5);
                }
                else if (tileList.get(x).equalsIgnoreCase("tile6")) {
                    bitmaps[x / width][x % width] = BitmapFactory.decodeResource(resources, R.drawable.tile6);
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public Bitmap combineImages(Bitmap c, Bitmap s) { // can add a 3rd parameter 'String loc' if you want to save the new image - left some code to do that at the bottom
        Bitmap cs = null;

        int width, height = 0;

        if(c.getWidth() > s.getWidth()) {
            width = c.getWidth() + s.getWidth();
            height = c.getHeight();
        } else {
            width = s.getWidth() + s.getWidth();
            height = c.getHeight();
        }

        cs = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas comboImage = new Canvas(cs);

        comboImage.drawBitmap(c, 0f, 0f, null);
        comboImage.drawBitmap(s, c.getWidth(), 0f, null);

        // this is an extra bit I added, just incase you want to save the new image somewhere and then return the location
        /*String tmpImg = String.valueOf(System.currentTimeMillis()) + ".png";

        OutputStream os = null;
        try {
          os = new FileOutputStream(loc + tmpImg);
          cs.compress(CompressFormat.PNG, 100, os);
        } catch(IOException e) {
          Log.e("combineImages", "problem combining images", e);
        }*/

        return cs;
    }

    private void createBackgroundImage() {
        int height = tileImages.length * 128;
        int width = tileImages[0].length * 128;
        background = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(background);
        //canvas.drawBitmap(bitmaps[19][0], 0, 0, null);
        //canvas.drawBitmap(bitmaps[19][0], 0, 128, null);
        for (int y = 0; y < tileImages.length; y++) {
            for (int x = 0; x < tileImages[y].length; x++) {
                canvas.drawBitmap(bitmaps[y][x], x * 128, y * 128, null);
            }
        }
    }

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * @return
     */
    public Bitmap getBackground() {
        /*Bitmap bitmap = Bitmap.createBitmap(64, 64, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.draw*/
        return background;
    }

    public void run()
    {
        // TODO Auto-generated method stub

    }

    public Canvas getCanvas()
    {
        return canvas;
    }
}
