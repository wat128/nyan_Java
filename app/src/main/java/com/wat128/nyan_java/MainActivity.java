package com.wat128.nyan_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("debug", "onCreate()");

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("debug", "onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("debug", "onRestart()");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d("debug", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("debug", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("debug", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("debug", "onDestroy()");
    }
}

