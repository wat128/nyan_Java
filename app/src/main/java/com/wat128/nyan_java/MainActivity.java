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
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TranslateAnimation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.carlos);

        Button button_rotate = findViewById(R.id.button);
        button_rotate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startTranslate();
            }
        });
    }

    private void startTranslate() {

        int type = 0;

        if(type == 0) {
            animation = new TranslateAnimation(
                    Animation.ABSOLUTE, 0.0f,
                    Animation.ABSOLUTE, 500.0f,
                    Animation.ABSOLUTE, 0.0f,
                    Animation.ABSOLUTE, 1200.f);
        }
        else if(type == 1) {
            animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.9f,
                    Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 1.8f);
        }
        else if(type == 2) {
            animation = new TranslateAnimation(
                    Animation.RELATIVE_TO_PARENT, 0.0f,
                    Animation.RELATIVE_TO_PARENT, 0.4f,
                    Animation.RELATIVE_TO_PARENT, 0.0f,
                    Animation.RELATIVE_TO_PARENT, 0.6f);
        }

        animation.setDuration(2000);
        animation.setRepeatCount(0);
        animation.setFillAfter(true);

        imageView.startAnimation(animation);
    }
}