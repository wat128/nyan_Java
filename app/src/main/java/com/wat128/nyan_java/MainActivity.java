package com.wat128.nyan_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Locale;

public class MainActivity extends FragmentActivity {

    private NumberPicker numberPicker0, numberPicker1, numberPicker2, numberPicker3, numberPicker4;
    private TextView textView;
    private String[] figures = new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("debug", "MainActivity.onCreate");

        textView = findViewById(R.id.text_view);

        setNumPickerId();

        Button pickerButton = findViewById(R.id.button1);

        setNumPickerValue();

        pickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setFigures();

                String str = String.format("%s%s%s.%s%s", figures[0], figures[1],  figures[2], figures[3], figures[4]);
                Float fig = Float.parseFloat(str);

                textView.setText(String.valueOf(fig));
            }
        });

    }

    // 冗長ではあるがPickerの学習を優先する
    private void setNumPickerId() {

        numberPicker0 = findViewById(R.id.numPicker0);
        numberPicker1 = findViewById(R.id.numPicker1);
        numberPicker2 = findViewById(R.id.numPicker2);
        numberPicker3 = findViewById(R.id.numPicker3);
        numberPicker4 = findViewById(R.id.numPicker4);

    }

    // 冗長ではあるがPickerの学習を優先する
    private void setNumPickerValue() {

        numberPicker0.setMaxValue(9);
        numberPicker0.setMinValue(0);

        numberPicker1.setMaxValue(9);
        numberPicker1.setMinValue(0);

        numberPicker2.setMaxValue(9);
        numberPicker2.setMinValue(0);

        numberPicker3.setMaxValue(9);
        numberPicker3.setMinValue(0);

        numberPicker4.setMaxValue(9);
        numberPicker4.setMinValue(0);
    }

    // 冗長ではあるがPickerの学習を優先する
    private void setFigures() {

        figures[0] = String.valueOf(numberPicker0.getValue());
        figures[1] = String.valueOf(numberPicker1.getValue());
        figures[2] = String.valueOf(numberPicker2.getValue());
        figures[3] = String.valueOf(numberPicker3.getValue());
        figures[4] = String.valueOf(numberPicker4.getValue());

    }
}

