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

    private void parseFile() {
        //TODO
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
     * Returns the location of the exit
     * @return exit The Exit
     */
    public Location getPlayerExit() {
        return playerExit;
    }

    public Tile[][] getTiles()
    {
        return tiles;
    }

    public Location getPlayerStart()
    {
        return playerStart;
    }

    public Location getTargetStart()
    {
        return targetStart;
    }

    public HashMap<Entity, Location> getEnemyStartLocations()
    {
        return enemyStartLocations;
    }

    public File getFile()
    {
        return file;
    }
}
