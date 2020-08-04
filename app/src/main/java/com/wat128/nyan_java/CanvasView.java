package com.wat128.nyan_java;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CanvasView extends View {

    private Paint paint;
    private Bitmap bmp;
    private float xPos, yPos, preX, preY;

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();

        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.bag);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(Color.argb(125,0,0,255));

        canvas.drawBitmap(
                bmp,
                (int)(getWidth() / 2 + xPos),
                (int)(getHeight() / 2 + yPos),
                paint);
    }

    public void setPosition(float xp, float yp) {
        final float dT = 0.8f;

        final float ax = -xp * 2;
        final float ay = yp * 2;

        xPos += preX * dT + ax * dT * dT;
        preX += ax * dT;

        yPos += preY * dT + ay * dT * dT;
        preY += ay * dT;

        invalidate();

    }
}
