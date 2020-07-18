package com.wat128.nyan_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private final int REQUEST_PERMISSION = 1000;

    private TextView textView;
    private EditText editText;
    private File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File path = getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
        String testfile ="testfile.txt";
        file = new File(path, testfile);

        if (Build.VERSION.SDK_INT >= 23)
            checkPermission();
        else
            setUpReadWriteExternalStorage();
    }

    private void setUpReadWriteExternalStorage(){

        textView = findViewById(R.id.text_view);
        editText = findViewById(R.id.edit_text);

        Button buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                if(isExternalStorageWritable()) {
                    String text = null;
                    String str = editText.getText().toString();

                    try(FileOutputStream fileOutputStream =
                                new FileOutputStream(file, true);
                        OutputStreamWriter outputStreamWriter =
                                new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
                        BufferedWriter bw =
                                new BufferedWriter(outputStreamWriter);
                    ) {

                        bw.write(str);
                        bw.flush();
                        text = "saved";

                    } catch (Exception e) {

                        text = "error: FileOutputStream";
                        e.printStackTrace();

                    }

                    textView.setText(text);
                }
            };
        });

        Button buttonRead = findViewById(R.id.button_read);
        buttonRead.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                String str = null;

                if(isExternalStorageReadable()) {

                    try(FileInputStream fileInputStream =
                                new FileInputStream(file);
                        InputStreamReader inputStreamReader =
                                new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
                        BufferedReader reader=
                                new BufferedReader(inputStreamReader); ) {

                        String lineBuffer;

                        while( (lineBuffer = reader.readLine()) != null ) {
                            str = lineBuffer ;
                        }

                    } catch (Exception e) {
                        str = "error: FileInputStream";
                        e.printStackTrace();
                    }
                }
                textView.setText(str);
            };
        });
    }

    public boolean isExternalStorageWritable() {

        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state));

    }

    public boolean isExternalStorageReadable() {

        String state = Environment.getExternalStorageState();
        return (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state));

    }

    public void checkPermission() {

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                PackageManager.PERMISSION_GRANTED){
            setUpReadWriteExternalStorage();
        } else {
            requestLocationPermission();
        }

    }

    private void requestLocationPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION);

        } else {
            Toast toast =
                    Toast.makeText(this, "アプリ実行に許可が必要です", Toast.LENGTH_SHORT);
            toast.show();

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,},
                    REQUEST_PERMISSION);
        }

    }

    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_PERMISSION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                setUpReadWriteExternalStorage();
            } else {
                Toast toast =
                        Toast.makeText(this, "何もできません", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
