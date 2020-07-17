package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;

import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private String fileName = "test.txt";

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);
        Button buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                saveFile(fileName, text);
                if(text.length() == 0)
                    textView.setText(R.string.no_text);
                else
                    textView.setText(R.string.saved);
            }
        });

        Button buttonRead = findViewById(R.id.button_read);
        buttonRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = readFile(fileName);
                if(str != null)
                    textView.setText(str);
                else
                    textView.setText(R.string.read_error);
            }
        });
    }

    public void saveFile(String file, String str) {

        try(FileOutputStream fileOutputStream = openFileOutput(file, Context.MODE_PRIVATE)){
            fileOutputStream.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFile(String file) {
        String text = null;

        try (FileInputStream fileInputStream = openFileInput(file);
             BufferedReader reader= new BufferedReader(
                     new InputStreamReader(fileInputStream, StandardCharsets.UTF_8))) {

            String lineBuffer;
            while( (lineBuffer = reader.readLine()) != null ) {
                text = lineBuffer ;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

}