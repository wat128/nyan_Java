package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);

        Button[] button = new Button[5];

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        layout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        layout.setGravity(Gravity.CENTER);
        layout.setBackgroundColor(Color.rgb(0xdd, 0xff, 0xee));

        setContentView(layout);

        float dp = getResources().getDisplayMetrics().density;
        int buttonWidth = (int)(250 * dp);
        int margins = (int)(10 * dp);

        textView = new TextView(this);
        String str = "TextView";
        textView.setText(str);
        textView.setTextColor(0xff000000);
        textView.setTextSize(10*dp);
        layout.addView(textView, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT));

        for(int i = 0; i < button.length; ++i){
            button[i] = new Button(this);
            // set Tag
            button[i].setTag(String.valueOf(i));
            button[i].setText(String.format(Locale.US, "Button %d", i));

            LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(buttonWidth, ViewGroup.LayoutParams.WRAP_CONTENT);
            buttonLayoutParams.setMargins(margins, margins, margins, margins);

            button[i].setLayoutParams(buttonLayoutParams);
            layout.addView(button[i]);

            button[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    textView.setText(String.format(Locale.US, "button: %s", v.getTag().toString()));
                }
            });
        }
    }
}

