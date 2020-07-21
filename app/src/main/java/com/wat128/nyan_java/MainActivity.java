package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements Runnable, View.OnClickListener {

    private long startTime;

    private TextView timerText;
    private Button startButton;

    private final Handler handler = new Handler();
    private volatile boolean stopRun = false;

    private SimpleDateFormat dataFormat = new SimpleDateFormat("mm:ss.SS", Locale.JAPAN);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerText = findViewById(R.id.timer);
        timerText.setText(dataFormat.format(0));

        startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(this);

        Button stopButton = findViewById(R.id.stop_button);
        stopButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Thread thread;

        if(v == startButton) {
            stopRun = false;
            thread = new Thread(this);
            thread.start();

            startTime = System.currentTimeMillis();
        } else {
            stopRun = true;
            timerText.setText(dataFormat.format(0));
        }
    }

    @Override
    public void run() {
        int period = 10;

        while(!stopRun) {

            try {
                Thread.sleep(period);
            } catch (InterruptedException e) {
                e.printStackTrace();
                stopRun = true;
            }

            handler.post(new Runnable() {
                @Override
                public void run() {
                    long endTime = System.currentTimeMillis();
                    long diffTime = endTime - startTime;

                    timerText.setText(dataFormat.format(diffTime));
                }
            });
        }
    }
}