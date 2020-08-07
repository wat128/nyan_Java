package com.wat128.nyan_java;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReadContent extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.text_view);

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = null;
        StringBuilder sb = null;
        boolean flg = false;

        try{
            if(flg) {
                cursor = contentResolver.query(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        null,null,null,null);
            }
            else {
                cursor = contentResolver.query(
                        MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                        null,null,null,null);
            }

            if(cursor != null && cursor.moveToFirst()) {

                String str = String.format("MediaStore.Images = %s\n\n", cursor.getCount());

                sb = new StringBuilder(str);

                do {
                    sb.append("ID: ");
                    sb.append(cursor.getString(cursor.getColumnIndex(
                            MediaStore.Images.Media._ID)));
                    sb.append("\n");
                    sb.append("Title: ");
                    sb.append(cursor.getString(cursor.getColumnIndex(
                            MediaStore.Images.Media.TITLE)));
                    sb.append("\n");
                    sb.append("Path: ");
                    sb.append(cursor.getString(cursor.getColumnIndex(
                            MediaStore.Images.Media.DATA)));
                    sb.append("\n\n");
                } while(cursor.moveToNext());

                cursor.close();
            }

        } catch (Exception e) {
            e.printStackTrace();

            Toast toast = Toast.makeText(this,
                    "例外発生。パーミッション要確認", Toast.LENGTH_SHORT);
            toast.show();
        } finally {
            if(cursor != null)
                cursor.close();
        }
    }
}
