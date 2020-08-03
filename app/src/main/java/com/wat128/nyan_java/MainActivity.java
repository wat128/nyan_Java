package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int yval = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TestView testView = new TestView(this);
        setContentView(testView);

        int endPostion = 1000;
        TestAnimation testAnimation = new TestAnimation(testView, endPostion);
        testAnimation.setDuration(5000);
        testView.startAnimation(testAnimation);
    }

    public class TestView extends View {

        Paint paint = new Paint();

        public TestView(Context context) {
            super(context);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            paint.setColor(Color.argb(255,125,125,125));
            canvas.drawRect(400,100+yval, 600,300+yval, paint);

        }

        public int getPosition() {
            return yval;
        }

        public void setPosition(int pos) {
            yval = pos;
        }
    }
}