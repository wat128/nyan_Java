package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        textView.setText(R.string.custom_button);

        Button customButton = findViewById(R.id.custom_button);

        customButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                ++count;
                String cnt = getString(R.string.tapped) + " " + String.valueOf(count);
                textView.setText(cnt);
            }
        });
    }
}
