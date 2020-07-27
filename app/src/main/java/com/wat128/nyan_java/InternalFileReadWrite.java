package com.wat128.nyan_java;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class InternalFileReadWrite {

    private Context context;
    private String FILE_NAME = "log.txt";
    private StringBuffer stringBuffer;

    InternalFileReadWrite(Context context) {
        this.context = context;
    }

    void clearFile() {
        context.deleteFile(FILE_NAME);
        stringBuffer.setLength(0);
    }

    void writeFile() {

        stringBuffer = new StringBuffer();

        long currentTime = System.currentTimeMillis();
        SimpleDateFormat dataFormat = new SimpleDateFormat("hh:mm:ss", Locale.US);
        String cTime = dataFormat.format(currentTime);
        Log.d("debug", cTime);

        stringBuffer.append(cTime);
        stringBuffer.append(System.getProperty("line.separator"));

        try(FileOutputStream fileOutputStream = context.openFileOutput(FILE_NAME, Context.MODE_APPEND)){
            fileOutputStream.write(stringBuffer.toString().getBytes());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    String readFile() {
        stringBuffer = new StringBuffer();

        try(FileInputStream fileInputStream = context.openFileInput(FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream, StandardCharsets.UTF_8))
        ) {
            String lineBuffer;

            while( (lineBuffer = reader.readLine()) != null) {
                stringBuffer.append(lineBuffer);
                stringBuffer.append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }
}
