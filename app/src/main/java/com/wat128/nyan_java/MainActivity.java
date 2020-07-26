package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private AlarmManager am;
    private PendingIntent pending;
    private int requestCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = this.findViewById(R.id.button_start);
        buttonStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.add(Calendar.SECOND, 10);

                Intent intent = new Intent(getApplicationContext(), AlarmNotification.class);
                intent.putExtra("RequestCode",requestCode);

                pending = PendingIntent.getBroadcast(
                        getApplicationContext(),requestCode, intent, 0);

                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                if (am != null) {
                    am.setExact(AlarmManager.RTC_WAKEUP,
                            calendar.getTimeInMillis(), pending);

                    Toast.makeText(getApplicationContext(), "alarm start", Toast.LENGTH_SHORT).show();

                    Log.d("debug", "start");
                }
            }
        });

        Button buttonCancel = findViewById(R.id.button_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent indent = new Intent(getApplicationContext(), AlarmNotification.class);
                PendingIntent pending = PendingIntent.getBroadcast(getApplicationContext(), requestCode, indent, 0);

                AlarmManager am = (AlarmManager)MainActivity.this.getSystemService(ALARM_SERVICE);
                if (am != null) {
                    am.cancel(pending);
                    Toast.makeText(getApplicationContext(), "alarm cancel", Toast.LENGTH_SHORT).show();
                    Log.d("debug", "cancel");
                }else{
                    Log.d("debug", "null");
                }
            }
        });
    }
}