package cs2114.ninjaassassin.world.tile;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Elliott Fairhurst
 * @version Nov 2, 2014
 */

public enum TileType
{
    /**
     * Represents and obstacle
     */
    WALL,
    /**
     * Represents an area in which a dynamic entity can move
     */
    PATH,
    /**
     * Represents a tile outside the map
     */
    INVALID_TILE,
    /**
     * Represents a path tile not yet explored by the path finder
     */
    UNEXPLORED,
    /**
     * Represents a failed path for the path finder
     */
    FAILED_PATH,
    /**
     * Represents the current path of the path finder
     */
    CURRENT_PATH;

    // ----------------------------------------------------------
    /**
     * Returns the tile's type whether it is a path or a wall
     * @param imageName The image name
     * @return type The tile type
     */
    public static TileType getTileType(String imageName) {
        if (imageName.equalsIgnoreCase("tile0")) {
            return PATH;
        }
        return WALL;
    }
}
