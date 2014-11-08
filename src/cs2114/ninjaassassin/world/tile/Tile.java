package cs2114.ninjaassassin.world.tile;

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
    // ----------------------------------------------------------
    /**
     * Create a new Tile object.
     * @param image The tile's image
     * @param left The left position of the tile
     * @param top The top position of the tile
     * @param right The right position of the tile
     * @param bottom The bottom position of the tile
     */
    public Tile(String image, float left,
            float top, float right, float bottom) {
        super(left, top, right, bottom);
        setStrokeWidth(0.0);
        setImage(image);
    }
}