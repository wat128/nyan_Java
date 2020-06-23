package com.wat128.nyan_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap bitmap;
    private int imgW, imgH;
    private Matrix matrix;
    private int degree = 0, counter = 0;
    private float ratio = 1.0f;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);

        imgW = bitmap.getWidth();
        imgH = bitmap.getHeight();

        matrix = new Matrix();

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageRotation();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageResize();
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageFlip();
            }
        });
    }

    private void imageRotation() {
        degree += 90;
        if(degree > 360) degree = 90;

        matrix.setRotate(degree, (float)imgW / 2, (float)imgH / 2);

        Bitmap bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, imgW, imgH, matrix, true);

        imageView.setImageBitmap(bitmap2);
    }

    private void imageResize() {
        if(counter < 4) {
            ratio -= 0.1f;
        }
        else if(counter < 8) {
            ratio += 0.2f;
        }
        else {
            counter = 0;
            ratio = 1.0f;
        }

        Log.d("debug", "counter="+counter);
        Log.d("debug", "ratio="+ratio);

        matrix.preScale(ratio, ratio);

        Bitmap bitmap3 = Bitmap.createBitmap(bitmap, 0, 0, imgW, imgH, matrix, true);

        Drawable drawable = new BitmapDrawable(getResources(), bitmap3);

        imageView.setImageDrawable(drawable);

        counter++;
    }

    private void imageFlip() {
        matrix.preScale(1.0f, 1.0f);

        matrix.preScale(-1.0f, 1.0f);

        Bitmap bitmap4 = Bitmap.createBitmap(bitmap, 0,0, imgW, imgH, matrix,true);

        Drawable drawable = new BitmapDrawable(getResources(), bitmap4);
        imageView.setImageDrawable(drawable);
    }

    private int getScreenWidth() {
        WindowManager windowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
        if(windowManager != null) {
            Display display = windowManager.getDefaultDisplay();
            Point pointSize = new Point();
            display.getSize(pointSize);

            return pointSize.x;
        }
        return 0;
    }
}

