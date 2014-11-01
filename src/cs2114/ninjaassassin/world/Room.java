package cs2114.ninjaassassin.world;

import cs2114.ninjaassassin.world.tile.Tile;
import cs2114.ninjaassassin.entity.Entity;
import java.util.HashMap;
import java.io.File;
import java.util.List;

// -------------------------------------------------------------------------
/**
 *  Class represents the current level.
 *
 *  @author Andrew Peace
 *  @version Nov 1, 2014
 */
public class Room
{
    private List<Entity> entities;
    private Tile[][] tiles;

    private Location playerExit;
    private Location playerStart;
    private Location targetStart;

    private HashMap<Entity, Location> enemyStartLocations;

    private File file;

    // ----------------------------------------------------------
    /**
     * Create a new Room object.
     * @param file The file representing the room data
     */
    public Room(File file) {
        this.file = file;
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
    public File getFile()
    {
        return file;
    }

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
    public Tile[][] getTiles()
    {
        return tiles;
    }

    private void parseFile() {
        //TODO
    }
}
