package com.wat128.nyan_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaSession2Service;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.w3c.dom.Text;

import java.io.FileDescriptor;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {

    private static final int RESULT_PICK_IMAGEFILE = 1001;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        imageView = findViewById(R.id.image_view);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("*/*");

                startActivityForResult(intent, RESULT_PICK_IMAGEFILE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == RESULT_PICK_IMAGEFILE && resultCode == Activity.RESULT_OK) {

            if(data.getData() != null) {

                ParcelFileDescriptor pfDesctiptor = null;
                try{
                    Uri uri = data.getData();

                    textView.setText(String.format(Locale.US, "Uri: %s",uri.toString()));

                    pfDesctiptor = getContentResolver().openFileDescriptor(uri, "r");
                    if(pfDesctiptor != null) {
                        FileDescriptor fileDescriptor = pfDesctiptor.getFileDescriptor();
                        Bitmap bmp = BitmapFactory.decodeFileDescriptor(fileDescriptor);
                        pfDesctiptor.close();
                        imageView.setImageBitmap(bmp);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                } finally {
                    try{
                        if(pfDesctiptor != null) {
                            pfDesctiptor.close();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}