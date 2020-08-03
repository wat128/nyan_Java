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

    private Arc arc;
    private int endAngle = 0;
    final private int animationPeriod = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        endAngle = 88 * 360 / 100;

        arc = findViewById(R.id.arc);

        Button buttonStart = findViewById(R.id.button_start);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationArc animation = new AnimationArc(arc, endAngle);
                animation.setDuration(animationPeriod);
                arc.startAnimation(animation);
            }
        });

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationArc animation = new AnimationArc(arc, 0);
                animation.setDuration(0);
                arc.startAnimation(animation);
            }
        });
    }
}