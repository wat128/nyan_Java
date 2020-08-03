package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private SensorManager sensorManager;
    private TextView textView;

    private int[] sensorList = {
            Sensor.TYPE_ACCELEROMETER,
            Sensor.TYPE_ACCELEROMETER_UNCALIBRATED,
            Sensor.TYPE_AMBIENT_TEMPERATURE,
            Sensor.TYPE_DEVICE_PRIVATE_BASE,
            Sensor.TYPE_GAME_ROTATION_VECTOR,
            //
            Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR,
            Sensor.TYPE_GRAVITY,
            Sensor.TYPE_GYROSCOPE,
            Sensor.TYPE_GYROSCOPE_UNCALIBRATED,
            Sensor.TYPE_HEART_BEAT,
            //
            Sensor.TYPE_HEART_RATE,
            Sensor.TYPE_LIGHT,
            Sensor.TYPE_LINEAR_ACCELERATION,
            Sensor.TYPE_LOW_LATENCY_OFFBODY_DETECT,
            Sensor.TYPE_MAGNETIC_FIELD,
            //
            Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED,
            Sensor.TYPE_MOTION_DETECT,
            Sensor.TYPE_POSE_6DOF,
            Sensor.TYPE_PRESSURE,
            Sensor.TYPE_PROXIMITY,
            //
            Sensor.TYPE_RELATIVE_HUMIDITY,
            Sensor.TYPE_ROTATION_VECTOR,
            Sensor.TYPE_SIGNIFICANT_MOTION,
            Sensor.TYPE_STATIONARY_DETECT,
            Sensor.TYPE_STEP_COUNTER,
            //
            Sensor.TYPE_STEP_DETECTOR
    };

    private String[] sensorNameList = {
            "ACCELEROMETER",
            "ACCELEROMETER_UNCALIBRATED",
            "AMBIENT_TEMPERATURE",
            "DEVICE_PRIVATE_BASE",
            "GAME_ROTATION_VECTOR",
            //
            "GEOMAGNETIC_ROTATION_VECTOR",
            "GRAVITY",
            "GYROSCOPE",
            "GYROSCOPE_UNCALIBRATED",
            "HEART_BEAT",
            //
            "HEART_RATE",
            "LIGHT",
            "LINEAR_ACCELERATION",
            "LOW_LATENCY_OFFBODY_DETECT",
            "MAGNETIC_FIELD",
            //
            "MAGNETIC_FIELD_UNCALIBRATED",
            "MOTION_DETECT",
            "POSE_6DOF",
            "PRESSURE",
            "PROXIMITY",
            //
            "RELATIVE_HUMIDITY",
            "ROTATION_VECTOR",
            "SIGNIFICANT_MOTION",
            "STATIONARY_DETECT",
            "STEP_COUNTER",
            //
            "STEP_DETECTOR",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        boolean flg = true;
        if(flg)
            checkSensors();
        else
            checkSensorsEach();
    }

    private void checkSensors() {
        List<Sensor> sensers = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuffer strListbuf = new StringBuffer("Sensor List:\n\n");
        int count = 0;

        for(Sensor sensor : sensers) {
            ++count;
            String str = String.format("%s: %s\n", String.valueOf(count + 1), sensor.getName());
            strListbuf.append(str);
        }

        textView.setText(strListbuf);
    }

    private void checkSensorsEach() {
        StringBuffer strbuf = new StringBuffer("Sensor List :\n\n");

        for(int i = 0; i < sensorList.length; ++i) {
            Sensor sensor = sensorManager.getDefaultSensor(sensorList[i]);

            if(sensor != null) {
                String strTmp = String.format("%s: %s 使用可能\n",
                        String.valueOf(i + 1), sensorNameList[i]);
                strbuf.append(strTmp);
            }
        }

        textView.setText(strbuf);
    }
}

