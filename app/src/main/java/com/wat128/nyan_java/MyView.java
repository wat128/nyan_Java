package com.wat128.nyan_java;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class MyView extends View {

    private Paint paint;
    private Bitmap bmp;

    public MyView(Context context) {
        super(context);
        paint = new Paint();
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.image);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = 10000;
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("TestView", "onDraw()");
        canvas.drawColor(Color.argb(255, 0, 0, 125));

        canvas.drawBitmap(bmp, 50, 300, paint);

        // Circle
        paint.setColor(Color.argb(255,255,0,255));
        paint.setStrokeWidth(30);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(130, 550,100, paint);

        // Circle2
        paint.setStrokeWidth(30);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(130,550,50, paint);

    }
}
