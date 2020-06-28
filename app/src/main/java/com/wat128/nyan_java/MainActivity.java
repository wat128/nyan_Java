package com.wat128.nyan_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private CheckBox[] checkBoxs = new CheckBox[2];
    private String[] str = {"未チェックです", "チェックされた", "チェックされていない"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxs[0] = findViewById(R.id.checkbox1);
        checkBoxs[0].setChecked(false);
        checkBoxs[0].setText(str[0]);

        checkBoxs[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = checkBoxs[0].isChecked();
                if(check)
                    checkBoxs[0].setText(str[1]);
                else
                    checkBoxs[0].setText(str[2]);
            }
        });

        checkBoxs[1] = findViewById(R.id.checkbox2);
        checkBoxs[1].setChecked(false);
        checkBoxs[1].setText(str[0]);

        checkBoxs[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean check = checkBoxs[1].isChecked();
                if(check)
                    checkBoxs[1].setText(str[1]);
                else
                    checkBoxs[1].setText(str[2]);
            }
        });

    }
}

