package cs2114.ninjaassassin.drawing;

import android.util.Log;
import android.content.Context;
import cs2114.ninjaassassin.world.Location;

public class TestEntity
{
    private Location loc;
    private EntityDrawing drawing;

    public TestEntity(Context context, Location loc) {
        this.loc = loc;
        this.drawing = new EntityDrawing(context, this);
    }

    public void update() {
        loc = loc.south();
        drawing.invalidate();
        drawing.setX(loc.getX());
        drawing.setY(loc.getY());
        Log.i("TestEntity", "x: " + loc.getX() + " y: " + loc.getY());
        //System.out.println("x: " + loc.getX() + " y: " + loc.getY());
    }
}