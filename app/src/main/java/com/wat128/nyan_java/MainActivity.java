package com.wat128.nyan_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2020, 7, 18);

        long timeMillis1 = calendar1.getTimeInMillis();
        long currentTimeMillis = System.currentTimeMillis();
        long diff = timeMillis1 - currentTimeMillis;

        // msec -> second -> minute -> hour -> day
        diff = diff / 1000;
        diff = diff / 60;
        diff = diff / 60;
        diff = diff / 24;

        TextView textView = findViewById(R.id.text_view);
        textView.setText(String.valueOf(diff) + " 日");
    }
}