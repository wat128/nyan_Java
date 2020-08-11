package com.wat128.nyan_java;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.carlos);

        Button buttonFadeOut = findViewById(R.id.button_fadeout);
        buttonFadeOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fadeout();
            }
        });

        Button buttonFadeIn = (Button)findViewById(R.id.button_fadein);
        buttonFadeIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                fadein();
            }
        });
    }

    private void fadeout(){
        AlphaAnimation animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }

    private void fadein(){
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        imageView.startAnimation(animation);
    }
}