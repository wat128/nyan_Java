package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private boolean flag = false;
    private Button button;
    private LinearLayout.LayoutParams buttonLayoutParams;
    private float scale;
    private int buttonWidth;
    private int margins;

    int mParent = LinearLayout.LayoutParams.MATCH_PARENT;
    int wContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // リニアレイアウトの設定
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setLayoutParams(new LinearLayout.LayoutParams(mParent, mParent));
        layout.setGravity(Gravity.CENTER);
        setContentView(layout);

        // テキスト設定
        textView = new TextView(this);
        textView.setText(R.string.hello);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 30);
        textView.setTextColor(Color.rgb(0x0, 0x0, 0x0));

        LinearLayout.LayoutParams textLayoutParams = new LinearLayout.LayoutParams(wContent, wContent);

        textView.setLayoutParams(textLayoutParams);

        layout.addView(textView);

        // ボタンの設定
        button = new Button(this);
        button.setText(R.string.button);

        scale = getResources().getDisplayMetrics().density;
        buttonWidth = (int)(150 * scale);
        margins = (int)(20 * scale);
        buttonLayoutParams = new LinearLayout.LayoutParams(buttonWidth, wContent);
        buttonLayoutParams.setMargins(margins, margins, margins, margins);

        button.setLayoutParams(buttonLayoutParams);
        layout.addView(button);

        // リスナーをボタンに登録
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    textView.setText(R.string.hello);
                    mode1();
                    flag = false;
                } else {
                    textView.setText(R.string.world);
                    mode2();
                    flag = true;
                }
            }
        });


    }

    private void mode1() {
        buttonWidth = (int)(150 * scale);

        buttonLayoutParams = new LinearLayout.LayoutParams(buttonWidth, wContent);
        buttonLayoutParams.setMargins(margins, margins, margins, margins);
        button.setLayoutParams(buttonLayoutParams);
    }

    private void mode2() {
        buttonWidth = (int)(250 * scale);
        int buttonHeight = (int)(100 * scale);

        buttonLayoutParams = new LinearLayout.LayoutParams(buttonWidth, buttonHeight);
        buttonLayoutParams.setMargins((int)(5*scale), (int)(50*scale), (int)(50*scale), (int)(20*scale));
        button.setLayoutParams(buttonLayoutParams);
    }
}
