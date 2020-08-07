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
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private final int REQUEST_PERMISSION = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT >= 23)
            checkPermission();
        else
            readContentActivity();

    }

    public void checkPermission() {
        if(checkSelfPermission(
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {

            readContentActivity();

        }
        else {
            requestLocationPermission();
        }
    }

    private void requestLocationPermission() {

        if(shouldShowRequestPermissionRationale(
                Manifest.permission.READ_EXTERNAL_STORAGE)) {

            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION);

        }
        else {
            Toast toast = Toast.makeText(this, "許可されてません", Toast.LENGTH_SHORT);
            toast.show();

            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_PERMISSION);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_PERMISSION) {
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                readContentActivity();
            }
            else{
                Toast toast = Toast.makeText(this, "なにもできません", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    private void readContentActivity() {
        Intent intent = new Intent(getApplication(), ReadContent.class);
        startActivity(intent);
    }
}
