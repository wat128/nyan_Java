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
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends FragmentActivity implements DatePickerDialog.OnDateSetListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("debug", "MainActivity.onCreate");
        textView = findViewById(R.id.textView);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Log.d("debug", "MainActivity.onDateSet");
        String str = String.format(Locale.US, "%d%d%d", year, month+1, dayOfMonth);
        textView.setText(str);
    }

    public void showDatePickerDialog(View v) {
        Log.d("debug", "MainActivity.showDatePickerDialog");
        DialogFragment newFragment = new DataPick();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
}

