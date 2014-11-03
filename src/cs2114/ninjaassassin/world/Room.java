package cs2114.ninjaassassin.world;

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

    private Location playerExit;
    private Location playerStart;
    private Location targetStart;

    private HashMap<Entity, Location> enemyStartLocations;

    //private File file;
    private InputStream inputStream;

    // ----------------------------------------------------------
    /**
     * Create a new Room object.
     * @param file The file representing the room data
     */
    public Room(InputStream is) {
        //this.file = file;
        inputStream = is;
        parseFile();
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
            for (int x = 0; x < tileList.size(); x++) {
                tileImages[x / width][x % width] = tileList.get(x);
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

    public void run()
    {
        // TODO Auto-generated method stub

    }
}
