package com.wat128.nyan_java;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences dataStore;
    private EditText editText;
    private TextView textWrite, textRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataStore = getSharedPreferences("DataStore", MODE_PRIVATE);

        editText = findViewById(R.id.edit_text);
        textRead = findViewById(R.id.text_read);
        textWrite = findViewById(R.id.text_write);

        Button buttonWrite = findViewById(R.id.button_write);
        buttonWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                textWrite.setText(text);

                SharedPreferences.Editor editor = dataStore.edit();
                editor.putString("input", text);
                editor.apply();
            }
        });

        Button buttonRead = findViewById(R.id.button_read);
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = dataStore.getString("input", "Nothing");
                if(!str.equals("Nothing")){
                    textRead.setText(str);
                }
            }
        });
    }

}