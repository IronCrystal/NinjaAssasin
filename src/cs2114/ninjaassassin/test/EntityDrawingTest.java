package cs2114.ninjaassassin.test;

import cs2114.ninjaassassin.drawing.EntityDrawing;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Andrew Peace (apeace)
 *  @version Dec 3, 2014
 */
public class EntityDrawingTest extends student.TestCase
{
    /**
     * EntityDrawing variable
     */
    EntityDrawing draw;

    public void setUp() {
        draw = new EntityDrawing("ninja", 10, null);
    }

    // ----------------------------------------------------------
    /**
     * Tests the constructor of the entity drawing class
     */
    public void testConstructor() {
        assertNull(draw.getEntity());
    }

    // ----------------------------------------------------------
    /**
     * Tests the update method of the drawing
     */
    public void testUpdate() {
        assertNull(draw.getEntity());
    }
}
