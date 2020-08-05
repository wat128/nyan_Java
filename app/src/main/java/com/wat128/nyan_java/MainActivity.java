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

import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity
        implements SensorEventListener, View.OnClickListener {

    private SensorManager sensorManager;
    private Sensor accel;
    private TextView textView;

    private LineChart mChart;
    private String[] labels = new String[]{
            "linear_accelerationX",
            "linear_accelerationY",
            "linear_accelerationZ"};
    private int[] colors = new int[]{
            Color.BLUE,
            Color.GRAY,
            Color.MAGENTA};

    private boolean lineardata = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        textView = findViewById(R.id.text_view);

        mChart = findViewById(R.id.chart);
        mChart.setData(new LineData());
        mChart.getDescription().setEnabled(false);
        mChart.setDrawGridBackground(true);
        mChart.getAxisRight().setEnabled(false);

        Button buttonStart = findViewById(R.id.button_start);
        buttonStart.setOnClickListener(this);

        Button buttonStop = findViewById(R.id.button_stop);
        buttonStop.setOnClickListener(this);

        Button buttonChange = findViewById(R.id.button_change);
        buttonChange.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_start:
                sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_NORMAL);
                break;
            case R.id.button_stop:
                sensorManager.unregisterListener(this);
                break;
            case R.id.button_change:
                if (lineardata)
                    lineardata = false;
                else
                    lineardata = true;
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float[] gravity = new float[3];
        float[] linear_acceleration = new float[3];
        final float alpha = 0.6f;

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            gravity[0] = alpha * gravity[0] + (1 - alpha) * event.values[0];
            gravity[1] = alpha * gravity[1] + (1 - alpha) * event.values[1];
            gravity[2] = alpha * gravity[2] + (1 - alpha) * event.values[2];

            linear_acceleration[0] = event.values[0] - gravity[0];
            linear_acceleration[1] = event.values[1] - gravity[1];
            linear_acceleration[2] = event.values[2] - gravity[2];

            String accelero;

            if (!lineardata) {
                accelero = String.format(Locale.US,
                        "X: %.3f\nY: %.3f\nZ: %.3f",
                        event.values[0], event.values[1], event.values[2]);
            } else {
                accelero = String.format(Locale.US,
                        "X: %.3f\nY: %.3f\nZ: %.3f",
                        gravity[0], gravity[1], gravity[2]);
            }

            textView.setText(accelero);

            LineData data = mChart.getLineData();

            if (data != null) {
                for (int i = 0; i < 3; i++) {
                    ILineDataSet set3 = data.getDataSetByIndex(i);
                    if (set3 == null) {
                        LineDataSet set = new LineDataSet(null, labels[i]);
                        set.setLineWidth(2.0f);
                        set.setColor(colors[i]);
                        // liner line
                        set.setDrawCircles(false);
                        // no values on the chart
                        set.setDrawValues(false);
                        set3 = set;
                        data.addDataSet(set3);
                    }

                    // data update
                    if (!lineardata) {
                        data.addEntry(new Entry(set3.getEntryCount(), event.values[i]), i);
                    } else {
                        data.addEntry(new Entry(set3.getEntryCount(), linear_acceleration[i]), i);
                    }

                    data.notifyDataChanged();
                }

                mChart.notifyDataSetChanged(); // 表示の更新のために変更を通知する
                mChart.setVisibleXRangeMaximum(50); // 表示の幅を決定する
                mChart.moveViewToX(data.getEntryCount()); // 最新のデータまで表示を移動させる
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
