package cs2114.ninjaassassin.entity.dynamic;

import java.util.Observable;
import java.util.Observer;
import android.graphics.PointF;
import android.util.Log;
import sofia.graphics.Color;
import sofia.graphics.Polygon;
import sofia.graphics.PolygonShape;

// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 *
 *  @author Andrew Peace (apeace)
 *  @version Dec 3, 2014
 */
public class FieldOfView extends PolygonShape implements Observer
{
    private float size;
    private Enemy enemy;
    // ----------------------------------------------------------
    /**
     * Create a new FieldOfView object.
     * @param enemy
     * @param size
     */
    public FieldOfView(Enemy enemy, float size) {
        super(getPolygon(enemy, size));
        this.setColor(Color.black);
        this.setFillColor(Color.red);
        this.setAlpha(128);
        //PointF point1 = new PointF((float) (enemy.getRangeOfView() * Math.sin(0.5 * enemy.getFieldOfView())), (float) (enemy.getRangeOfView() * Math.cos(0.5 * enemy.getFieldOfView())));
        //this.setPositionAnchor(point1);
        Log.i("FieldOfView", "The field of view constructor was called!");
        Log.i("FieldOfView", "The initial position is " + this.getPosition().toString());
        //this.setRotation(90);
        this.size = size;
        this.enemy = enemy;
    }

    private static Polygon getPolygon(Enemy enemy, float size) {
//        PointF point1 = new PointF(enemy.getLocation().getX() * size + size / 2, enemy.getLocation().getY() * size);
//        PointF point2 = new PointF((float)((enemy.getLocation().getX() * size + size / 2) + enemy.getRangeOfView() * Math.sin(0.5 * enemy.getFieldOfView())), (float)((enemy.getLocation().getY() * size) - enemy.getRangeOfView() * Math.cos(0.5 * enemy.getFieldOfView())));
//        PointF point3 = new PointF((float)((enemy.getLocation().getX() * size + size / 2) - enemy.getRangeOfView() * Math.sin(0.5 * enemy.getFieldOfView())), (float)((enemy.getLocation().getY() * size) - enemy.getRangeOfView() * Math.cos(0.5 * enemy.getFieldOfView())));
        PointF point1 = new PointF((float) (enemy.getRangeOfView() * Math.sin(0.5 * enemy.getFieldOfView())), (float) (enemy.getRangeOfView() * Math.cos(0.5 * enemy.getFieldOfView())));
        PointF point2 = new PointF((float) (2 * enemy.getRangeOfView() * Math.sin(0.5 * enemy.getFieldOfView())), 0);
        PointF point3 = new PointF(0, 0);
        Polygon polygon = new Polygon();
        polygon.add(point2);
        polygon.add(point1);
        polygon.add(point3);
        Log.i("FieldOfView", "Vertice 1: " + point1.toString());
        Log.i("FieldOfView", "Vertice 2: " + point2.toString());
        Log.i("FieldOfView", "Vertice 3: " + point3.toString());
        return polygon;
    }

    public void update(Observable observable, Object data)
    {
        this.setPosition(enemy.getLocation().getX() * size, enemy.getLocation().getY() * size - size);
    }
}
