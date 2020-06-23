package com.wat128.nyan_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.image);

        int imgW = bitmap1.getWidth();
        int imgH = bitmap1.getHeight();

        Matrix matrix = new Matrix();

        matrix.setRotate(90, imgW / 2, imgH / 2);

        Bitmap bitmap2 = Bitmap.createBitmap(bitmap1, 0, 0, imgW, imgH, matrix, true);

        imageView.setImageBitmap(bitmap2);
    }
}

