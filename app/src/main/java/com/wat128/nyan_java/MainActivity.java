package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.media.AudioAttributes;

import android.media.SoundPool;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ScrollView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyView myView = new MyView(this);
        setContentView(myView);
    }

    class MyView extends View {
        Paint paint;
        Path path;

        final float StrokeWidth1 = 20.0f;
        final float StrokeWidth2 = 40.0f;
        float dp;

        public MyView(Context context) {
            super(context);
            paint = new Paint();
            path = new Path();

            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);

            dp = getResources().getDisplayMetrics().density;
            Log.d("debug", "fdp = " + dp);
        }

        @Override
        protected void onDraw(Canvas canvas) {

            canvas.drawColor(Color.argb(255, 0, 0, 125));

            float xc = getWidth() / 2;
            float yc = getHeight() / 2;

            // Circle
            paint.setColor(Color.argb(255,125,125,255));
            paint.setStrokeWidth(StrokeWidth1);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(xc - 15*dp, yc - 55*dp, xc / 2, paint);

            // Rect
            paint.setColor(Color.argb(255,255,0,255));
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawRect(xc - 30*dp, yc - 50*dp, xc + 120*dp, yc + 100*dp, paint);

            // Line
            paint.setStrokeWidth(StrokeWidth1);
            paint.setColor(Color.argb(255,0,255,0));
            canvas.drawLine(xc + 20*dp, yc - 30*dp, xc - 70*dp, yc + 70*dp, paint);

            // Triangle
            float tx1 = 230*dp;
            float ty1 = 370*dp;
            float tx2 = 100*dp;
            float ty2 = 500*dp;
            float tx3 = 350*dp;
            float ty3 = 500*dp;

            paint.setStrokeWidth(10);
            paint.setColor(Color.WHITE);
            path.moveTo(tx1, ty1);
            path.lineTo(tx2, ty2);
            path.lineTo(tx3, ty3);
            path.lineTo(tx1, ty1);
            canvas.drawPath(path, paint);


        }
    }
}