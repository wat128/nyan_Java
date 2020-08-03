package com.wat128.nyan_java;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class Arc extends View {

    private final Paint paint;
    private RectF rect;

    private static final int AngleTarget = 270;
    private float angle = 10;

    public Arc(Context context, AttributeSet attrs) {
        super(context,attrs);

        int strokeWidth = 60;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeWidth);
        paint.setColor(Color.argb(255,0,0,255));

        rect = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawColor(Color.argb(64,0,0,255));

        float x = getWidth() / 2;
        float y = getHeight() / 2;
        float radius = getWidth() / 4;

        rect.set(x - radius, y - radius, x + radius, y + radius);

        canvas.drawArc(rect, AngleTarget, angle, false, paint);
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }
}
