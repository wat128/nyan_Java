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
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    private boolean showCanvas;
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView label = this.findViewById(R.id.label);
        label.setText(R.string.text);

        Log.d("MainActivity", "onCreate()");
        myView = this.findViewById(R.id.my_view);
        myView.showCanvas(true);
        showCanvas = true;

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("debug", "button on click");
                if(showCanvas) {
                    myView.showCanvas(false);
                    showCanvas = false;
                    Log.d("debug", "showCanvas = false");
                } else {
                    myView.showCanvas(true);
                    showCanvas = true;
                    Log.d("debug", "showCanvas = true");
                }
            }
        });
    }
}