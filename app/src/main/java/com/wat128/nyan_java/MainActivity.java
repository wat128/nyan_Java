package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private TransitionDrawable transitionDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageView =findViewById(R.id.image_view);
        transitionDrawable = (TransitionDrawable)imageView.getBackground();
        transitionDrawable.setCrossFadeEnabled(true);

        Button buttonStart = findViewById(R.id.button_start);
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionDrawable.startTransition(3000);
            }
        });

        Button buttonReserve = findViewById(R.id.button_reverse);
        buttonReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionDrawable.reverseTransition(1000);
            }
        });

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transitionDrawable.resetTransition();
            }
        });
    }
}