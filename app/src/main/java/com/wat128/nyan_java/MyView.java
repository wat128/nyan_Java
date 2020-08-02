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
    private Boolean viewflg;
    private Bitmap bmp;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        viewflg = true;
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.image);
    }

    public void showCanvas(boolean flg) {
        viewflg = flg;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.d("TestView", "onDraw()");
        canvas.drawColor(Color.argb(255, 0, 0, 125));
        if(viewflg) {
            canvas.drawBitmap(bmp, 80, 200, paint);
        }
        else {
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            paint.setStrokeWidth(5);
            paint.setTextSize(100);
            paint.setColor(Color.argb(255,255,255,0));
            canvas.drawText("Kina",120,600, paint);
        }

        // Circle
        paint.setColor(Color.argb(255,255,0,255));
        paint.setStrokeWidth(30);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);

        canvas.drawCircle(130, 150,100, paint);

        // Circle2
        paint.setStrokeWidth(30);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(130,150,50, paint);

    }
}
