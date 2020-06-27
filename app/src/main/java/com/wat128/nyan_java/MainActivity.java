package com.wat128.nyan_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

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
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private SeekBar[] seekBars = new SeekBar[4];
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        layout.setGravity(Gravity.CENTER);

        layout.setBackgroundColor(Color.rgb(220, 255, 220));
        setContentView(layout);

        float dp = getResources().getDisplayMetrics().density;
        int margins = (int)(20 * dp);
        int seekBarHeight = (int)(50 * dp);

        textView = new TextView(this);

        LinearLayout.LayoutParams textViewLayoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        textViewLayoutParams.setMargins(margins, margins, margins, margins);

        textView.setLayoutParams(textViewLayoutParams);
        layout.addView(textView);
        String str = String.valueOf(0)+" %";
        textView.setText(str);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

        for(int i = 0; i < seekBars.length; ++i) {
            seekBars[i] = new SeekBar(this);

            LinearLayout.LayoutParams seekBarLayoutParams = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    seekBarHeight);
            seekBarLayoutParams.setMargins(margins, margins, margins, margins);

            seekBars[i].setLayoutParams(seekBarLayoutParams);
            layout.addView(seekBars[i]);

            seekBars[i].setProgress(0);
            seekBars[i].setMax(100);
            seekBars[i].setBackgroundColor(Color.rgb(191, 191, 191));

            if(i == 0) {}
            else if(i == 1) {
                Drawable icon = ResourcesCompat.getDrawable(getResources(),R.drawable.ic_launcher_foreground, null);
                seekBars[i].setThumb(icon);
            }
            else if(i == 2) {
                ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
                shapeDrawable.getPaint().setColor(Color.BLUE);
                shapeDrawable.setIntrinsicWidth(30 * (int)dp);
                shapeDrawable.setIntrinsicHeight(50 * (int)dp);
                seekBars[i].setThumb(shapeDrawable);
            }
            else if(i == 3) {
                Drawable icon = ResourcesCompat.getDrawable(getResources(), R.drawable.custom_progress, null);
                seekBars[i].setProgressDrawable(icon);
            }

            seekBars[i].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    String str = String.valueOf(progress) + " %";
                    textView.setText(str);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
        }

    }
}

