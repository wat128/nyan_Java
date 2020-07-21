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

public class MainActivity extends AppCompatActivity {

    private Timer timer;
    private Handler handler = new Handler();

    private TextView timerText;
    private long delay, period;
    private int count;

    private SimpleDateFormat dataFormat = new SimpleDateFormat("mm:ss.S", Locale.US);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        delay = 0;
        period = 100;

        timerText = findViewById(R.id.timer);
        timerText.setText(dataFormat.format(0));

        Button startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != timer){
                    timer.cancel();
                    timer = null;
                }

                timer = new Timer();
                count = 0;
                timerText.setText(dataFormat.format(0));

                timer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                ++count;
                                timerText.setText(dataFormat.format(count * period));
                            }
                        });
                    }
                }, delay, period);
            }
        });

        Button stopButton = findViewById(R.id.stop_button);
        stopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(null != timer){
                    timer.cancel();
                    timer = null;
                    timerText.setText(dataFormat.format(0));
                }
            }
        });
    }
}