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
     */
    public Tile(String image, float left,
            float top, float right, float bottom) {
        super(left, top, right, bottom);
        setImage(image);
    }
}