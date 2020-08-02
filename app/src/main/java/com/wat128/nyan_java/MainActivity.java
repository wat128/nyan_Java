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

import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private MyView myView;

    private final Handler handler = new Handler();
    private Runnable runnable;
    boolean flg = false;
    int period = 50;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView label = this.findViewById(R.id.label);
        label.setText(R.string.text);

        myView = this.findViewById(R.id.my_view);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flg) {
                    flg = true;
                    moveCircle();
                }
                else {
                    stopTask();
                }
            }
        });
    }

    private void moveCircle() {
        pos = 450;
        runnable = new Runnable() {
            @Override
            public void run() {
                if(flg) {
                    pos += 10;
                    myView.setPosition(pos);
                    myView.invalidate();

                    if(pos > 1700) {
                        stopTask();
                        pos = 0;
                    }
                    handler.postDelayed(this, period);
                }
            }
        };

        handler.post(runnable);
    }

    private void stopTask() {
        handler.removeCallbacks(runnable);
        runnable = null;
        flg = false;
    }
}