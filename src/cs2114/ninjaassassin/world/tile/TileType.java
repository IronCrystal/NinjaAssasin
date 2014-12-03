package cs2114.ninjaassassin.world.tile;

// -------------------------------------------------------------------------
/**
 * Represents possible types of tiles in a room.
 *
 * @author Andrew Peace (apeace)
 * @author Elliott Fairhurst (edf203)
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
    INVALID_TILE;

    // ----------------------------------------------------------
    /**
     * Returns the tile's type whether it is a path or a wall
     *
     * @param imageName
     *            The image name
     * @return type The tile type
     */
    public static TileType getTileType(String imageName)
    {
        if (imageName.equalsIgnoreCase("tile0"))
        {
            return PATH;
        }
        return WALL;
    }
}
