package com.wat128.nyan_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        MyApp myApp = (MyApp)this.getApplication();
        String str = myApp.getTestString();

        TextView textViewSub = findViewById(R.id.textvieww_sub);
        textViewSub.setText(str);

    }
}
