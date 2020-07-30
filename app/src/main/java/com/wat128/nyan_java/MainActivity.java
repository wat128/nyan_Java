package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.AudioAttributes;

import android.media.SoundPool;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}