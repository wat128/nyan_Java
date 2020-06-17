package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String str1, str2;
    private boolean flg = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boolean addSrc = true;

        // set linearLayout
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        int mParent = LinearLayout.LayoutParams.MATCH_PARENT;
        int wContent = LinearLayout.LayoutParams.WRAP_CONTENT;

        layout.setLayoutParams(new LinearLayout.LayoutParams(mParent, wContent));

        // set center and color to layout
        layout.setGravity(Gravity.CENTER);
        layout.setBackgroundColor(Color.parseColor("#ffdfcf"));
        setContentView(layout);

        // set TextView
        textView = new TextView(this);
        str1 = "Image Button";
        str2 = "Tapped";
        textView.setText(str1);

        LinearLayout.LayoutParams textViewLayoutParams = new LinearLayout.LayoutParams(wContent, wContent);
        textView.setLayoutParams(textViewLayoutParams);

        textView.setTextColor(Color.rgb(0xff, 0x0, 0x0));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);

        int margin10 = 10 * TypedValue.COMPLEX_UNIT_DIP;
        textViewLayoutParams.setMargins(margin10, margin10, margin10, margin10);

        layout.addView(textView);

        // set Button
        ImageButton imageButton = new ImageButton(this);

        //int dp400 = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 400, getResources().getDisplayMetrics());
        //int dp267 = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 267, getResources().getDisplayMetrics());

        LinearLayout.LayoutParams buttonLayoutParams = new LinearLayout.LayoutParams(wContent, wContent);

        buttonLayoutParams.setMargins(margin10, margin10, margin10, margin10);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        Drawable drawable = new BitmapDrawable(getResources(), bitmap);

        if(addSrc) {
            imageButton.setImageBitmap(bitmap);
            imageButton.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imageButton.setBackgroundColor(Color.parseColor("#000000"));
        } else {
            imageButton.setBackground(drawable);
        }

        imageButton.setLayoutParams(buttonLayoutParams);
        layout.addView(imageButton);

        // set Listener to Button
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flg){
                    textView.setText(str2);
                    flg = false;
                } else {
                    textView.setText(str1);
                    flg = true;
                }
            }
        });

    }
}
