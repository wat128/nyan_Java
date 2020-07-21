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

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;
    private CountUpTimerTask timerTask;
    private Handler handler = new Handler();

    private TextView timerText;
    private long count, delay, period;
    private String zero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        delay = 0;
        period = 100;
        zero = getString(R.string.zero);

        timerText = findViewById(R.id.timer);
        timerText.setText(zero);

        Button startButton = findViewById(R.id.start_button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != timer){
                    timer.cancel();
                    timer = null;
                }

                timer = new Timer();
                timerTask = new CountUpTimerTask();
                timer.schedule(timerTask, delay, period);
                count = 0;
                timerText.setText(zero);

            }
        });

        Button stopButton = findViewById(R.id.stop_button);
        stopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(null != timer){
                    timer.cancel();
                    timer = null;
                    timerText.setText(zero);
                }
            }
        });
    }

    class CountUpTimerTask extends TimerTask {
        @Override
        public void run() {
            handler.post(new Runnable() {
                public void run() {
                    count++;
                    long mm = count*100 / 1000 / 60;
                    long ss = count*100 / 1000 % 60;
                    long ms = (count*100 - ss * 1000 - mm * 1000 * 60)/100;

                    timerText.setText(
                            String.format(Locale.US, "%1$02d:%2$02d.%3$01d", mm, ss, ms));
                }
            });
        }
    }
}