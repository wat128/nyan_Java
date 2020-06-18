package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

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

import java.lang.reflect.Type;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ConstraintLayout layout = new ConstraintLayout(this);

        layout.setLayoutParams(new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT));

        TextView textView = new TextView(this);
        int viewId = View.generateViewId();
        textView.setId(viewId);
        textView.setText("Hello World");
        textView.setTextColor(Color.rgb(0x0, 0x0, 0xaa));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 50);
        layout.addView(textView);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(layout);

        constraintSet.constrainHeight(textView.getId(), ConstraintSet.WRAP_CONTENT);
        constraintSet.constrainWidth(textView.getId(), ConstraintSet.WRAP_CONTENT);

        constraintSet.connect(
                textView.getId(),
                ConstraintSet.BOTTOM,
                ConstraintSet.PARENT_ID,
                ConstraintSet.BOTTOM,
                0);

        constraintSet.connect(
                textView.getId(),
                ConstraintSet.LEFT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.LEFT,
                0);

        constraintSet.connect(
                textView.getId(),
                ConstraintSet.RIGHT,
                ConstraintSet.PARENT_ID,
                ConstraintSet.RIGHT,
                0);

        constraintSet.connect(
                textView.getId(),
                ConstraintSet.TOP,
                ConstraintSet.PARENT_ID,
                ConstraintSet.TOP,
                0);

        constraintSet.applyTo(layout);
        setContentView(layout);

    }
}

