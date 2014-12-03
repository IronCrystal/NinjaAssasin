package cs2114.ninjaassassin.drawing;

import android.util.Log;
import cs2114.ninjaassassin.entity.Entity;
import java.util.Observable;
import java.util.Observer;
import sofia.graphics.RectangleShape;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Andrew Peace (apeace)
 * @author Elliott Fairhurst (edf203)
 * @version Dec 1, 2014
 */
public class EntityDrawing
    extends RectangleShape
    implements Observer
{

    private Entity entity;
    private float  size;


    // ----------------------------------------------------------
    /**
     * Create a new EntityDrawing object.
     *
     * @param image
     *            The image file
     * @param size
     *            The size of the image
     * @param entity
     *            The entity it is observing
     */
    public EntityDrawing(String image, float size, Entity entity)
    {
        super(entity.getLocation().getX() * size, entity.getLocation().getY()
            * size, entity.getLocation().getX() * size + size, entity
            .getLocation().getY() * size + size);
        setImage(image);
        this.size = size;
        this.entity = entity;
        Log.i("EntityDrawing", "The starting location is : "
            + entity.getLocation().toString());
    }


    public void update(Observable observable, Object data)
    {
        if (observable.equals(entity))
        {
            Log.i("EntityDrawing", "The ninja updated its location!");
            // this.setLeftTop(entity.getLocation().getX() * size,
// entity.getLocation().getY() * size);
            this.setLeft(entity.getLocation().getX() * size);
            this.setTop(entity.getLocation().getY() * size);
            Log.i("EntityDrawing", "The ninja's location is ("
                + entity.getLocation().getX() + ", "
                + entity.getLocation().getY() + ")");
            Log.i("EntityDrawing", "The ninja is being displayed at "
                + this.getPosition().toString());
            // this.setPosition(loc.getX(), loc.getY());
        }
    }


    // ----------------------------------------------------------
    /**
     * Returns the entity attached to this drawing
     *
     * @return entity The Entity
     */
    public Entity getEntity()
    {
        return entity;
    }
}
