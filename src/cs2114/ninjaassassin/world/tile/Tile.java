package cs2114.ninjaassassin.world.tile;

import sofia.graphics.Color;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 *  Represents a tile in a room
 *
 *  @author Andrew Peace
 *  @version Nov 1, 2014
 */
public class Tile extends RectangleShape
{

    private TileType type;
    // ----------------------------------------------------------
    /**
     * Create a new Tile object.
     * @param image The tile's image
     * @param left The left position of the tile
     * @param top The top position of the tile
     * @param right The right position of the tile
     * @param bottom The bottom position of the tile
     * @param type The Tile Type
     */
    public Tile(String image, float left,
            float top, float right, float bottom, TileType type) {
        super(left, top, right, bottom);
        setStrokeWidth(0.0);
        this.setColor(Color.clear);
        setImage(image);
        this.setType(type);
    }

    // ----------------------------------------------------------
    /**
     * Returns the type of tile this is.
     * @return type The TileType
     */
    public TileType getType()
    {
        return type;
    }

    /**
     * Sets the type (TileType) of this tile.
     * @param type The tile type
     */
    public void setType(TileType type)
    {
        this.type = type;
    }
}