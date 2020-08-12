package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ObjectAnimator objectAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = findViewById(R.id.button_start);
        imageView = findViewById(R.id.image_view);
        imageView.setImageResource(R.drawable.bag);

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnimetion();
            }
        });

        Button buttonPause = findViewById(R.id.button_pause);
        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(objectAnimator != null) {
                    if(objectAnimator.isRunning()) {
                        objectAnimator.pause();
                    }
                }
            }
        });

        final Button buttonResumed = findViewById(R.id.button_resumed);
        buttonResumed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(objectAnimator != null) {
                    if(objectAnimator.isPaused()){
                        objectAnimator.resume();
                    }
                }
            }

        });
    }

    private void setAnimetion(){
        PropertyValuesHolder vhX = PropertyValuesHolder.ofFloat(
                "translationX",
                0.0f,
                600.0f );

        PropertyValuesHolder vhY = PropertyValuesHolder.ofFloat(
                "translationY",
                0.0f,
                1200.0f );

        PropertyValuesHolder vhRotaion = PropertyValuesHolder.ofFloat(
                "rotation",
                0.0f,
                360.0f );

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(
                imageView,
                vhX ,
                vhY ,
                vhRotaion );

        objectAnimator.setDuration(3000);

        objectAnimator.addPauseListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationPause(Animator animation) {
                Log.d("debug", "onAnimationPause()");
            }

            @Override
            public void onAnimationResume(Animator animation) {
                Log.d("debug", "onAnimationResume()");

            }
        });

        objectAnimator.start();
    }
}