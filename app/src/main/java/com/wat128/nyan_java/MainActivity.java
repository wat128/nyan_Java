package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;
import android.media.AudioAttributes;

import android.media.SoundPool;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private SoundPool soundPool;
    private int soundOne, soundTwo;
    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build();

        soundPool = new SoundPool.Builder()
                .setAudioAttributes(audioAttributes)
                .setMaxStreams(2)
                .build();

        soundOne = soundPool.load(this, R.raw.one, 1);
        soundTwo = soundPool.load(this, R.raw.two, 1);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                Log.d("debug","sampleId="+sampleId);
                Log.d("debug","status="+status);
            }
        });

        button1 = findViewById(R.id.button_start);
        button2 = findViewById(R.id.button_clear);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(soundOne, 1.0f, 1.0f, 0, 0, 1);

                RotateAnimation buttonRotation = new RotateAnimation(0, 360, button1.getWidth()/2, button1.getHeight()/2);
                buttonRotation.setDuration(2000);
                button1.startAnimation(buttonRotation);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                soundPool.play(soundTwo, 1.0f, 1.0f, 1, 0, 1);

                RotateAnimation buttonRotation = new RotateAnimation(0, 360, button2.getWidth()/2, button2.getHeight()/2);
                buttonRotation.setDuration(2000);
                button2.startAnimation(buttonRotation);
            }
        });
    }
}