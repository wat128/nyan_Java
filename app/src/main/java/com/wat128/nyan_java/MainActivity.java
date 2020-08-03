package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private StringBuffer info = new StringBuffer("Test onTouchEvent\n\n");
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.delete(0, info.length());
                textView.setText(info);
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                info.append("ACTION_DOWN\n");
                info.append("Pressure");
                info.append(event.getPressure());
                info.append("\n");
                info.append("x1 : ");
                info.append(event.getX());
                info.append("\n");
                info.append("y1 : ");
                info.append(event.getY());
                info.append("\n");

                break;

            case MotionEvent.ACTION_UP:

                info.append("ACTION_UP\n");
                info.append("x2 : ");
                info.append(event.getX());
                info.append("\n");
                info.append("y2 : ");
                info.append(event.getY());
                info.append("\n");
                long eventDuration2 = event.getEventTime() - event.getDownTime();
                info.append("duration : ");
                info.append(eventDuration2);
                info.append(" msec\n\n");

                break;
            case MotionEvent.ACTION_MOVE:

                info.append("ACTION_MOVE\n");

                break;
            case MotionEvent.ACTION_CANCEL:

                info.append("ACTION.CANCEL\n");

                break;
            default:
                break;
        }

        textView.setText(info);

        return false;
    }
}