package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioAttributes;

import android.media.SoundPool;
import android.os.Bundle;

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

        float StrokeWidth = 20.0f;

        public MyView(Context context) {
            super(context);
            paint = new Paint();
        }

        @Override
        protected void onDraw(Canvas canvas) {

            paint.setColor(Color.argb(255,255,0,255));
            paint.setStrokeWidth(StrokeWidth);
            paint.setStyle(Paint.Style.STROKE);

            canvas.drawRect(300,300,600,600,paint);
        }
    }
}