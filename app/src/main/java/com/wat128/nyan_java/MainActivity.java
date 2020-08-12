package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;
import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity implements Animator.AnimatorListener {

    private ImageView imageView;

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
        objectAnimator.addListener(this);
        objectAnimator.start();
    }

    @Override
    public void onAnimationStart(Animator animation) {
        Log.d("debug","onAnimationStart()");
    }

    @Override
    public void onAnimationCancel(Animator animation) {
        Log.d("debug","onAnimationCancel()");
    }

    @Override
    public void onAnimationEnd(Animator animation) {
        Log.d("debug","onAnimationEnd()");
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
        Log.d("debug","onAnimationRepeat()");
    }
}