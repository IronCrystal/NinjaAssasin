package cs2114.ninjaassassin.drawing;

import android.util.Log;
import android.graphics.Paint;
import android.graphics.Canvas;
import android.content.Context;
import android.view.View;

public class EntityDrawing extends View {

    private TestEntity entity;

    public EntityDrawing(Context context, TestEntity entity)
    {
        super(context);
        this.entity = entity;
    }

    @Override
    public void onDraw(Canvas canvas) {
        Log.i("EntityDrawing", "This view is enabled: " + this.isEnabled());
        Log.i("EntityDrawing", "The entityDrawing was drawn!");
        canvas.drawRect(0, 0, getRight(), getBottom(), new Paint());
    }
}
