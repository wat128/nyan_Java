package com.wat128.nyan_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;

    private final int REQUEST_PERMISSION = 1000;

    private String fileName = "image3.jpeg";
    private File file;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File path = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        file = new File(path, fileName);

        textView = findViewById(R.id.text_view);
        String str = "image file: "+fileName;
        textView.setText(str);

        imageView = findViewById(R.id.image_view);


        if(Build.VERSION.SDK_INT >= 23)
            checkPermission();
        else
            setUpWriteExternalStorage();

    }

    private void setUpWriteExternalStorage(){
        Button buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                try(
                    InputStream inputStream =
                            getResources().getAssets().open(fileName);
                    FileOutputStream output =
                            new FileOutputStream(file)) {

                    int DEFAULT_BUFFER_SIZE = 10240 * 4;
                    byte[] buf = new byte[DEFAULT_BUFFER_SIZE];
                    int len;

                    while((len=inputStream.read(buf))!=-1){
                        output.write(buf,0,len);
                    }
                    output.flush();

                    textView.setText(R.string.saved);

                } catch (IOException e) {
                    e.printStackTrace();
                    textView.setText(R.string.error);
                }

            }
        });

        Button buttonRead = findViewById(R.id.button_read);
        buttonRead.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {

                try(InputStream inputStream0 =
                            new FileInputStream(file) ) {

                    Bitmap bitmap = BitmapFactory.decodeStream(inputStream0);
                    imageView.setImageBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void checkPermission() {

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_GRANTED){
            setUpWriteExternalStorage();
        }
        else{
            requestLocationPermission();
        }

    }

    private void requestLocationPermission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_PERMISSION);
        } else {
            Toast toast = Toast.makeText(this, "許可してください", Toast.LENGTH_SHORT);
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
                setUpWriteExternalStorage();
            } else {
                Toast toast = Toast.makeText(this, "何もできません", Toast.LENGTH_SHORT);
                toast.show();
            }
        }

    }
}
