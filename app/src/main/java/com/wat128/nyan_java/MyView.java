package com.wat128.nyan_java;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Picture;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

    Paint paint;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawColor(Color.argb(255, 0, 0, 125));


        // Circle
        paint.setColor(Color.argb(255,125,125,255));
        paint.setStrokeWidth(30);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(450,450,100, paint);

        // Rect
        paint.setColor(Color.argb(255,255,0,255));
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(480,480,850,880, paint);

        // Line
        paint.setStrokeWidth(15);
        paint.setColor(Color.argb(255,0,255,0));
        canvas.drawLine(350,850,750,630, paint);

    }
}
