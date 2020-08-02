package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private boolean showCanvas;
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView label = this.findViewById(R.id.label);
        label.setText(R.string.text);

        myView = this.findViewById(R.id.my_view);
        myView.showCanvas(true);

        showCanvas = true;

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(showCanvas) {
                    myView.showCanvas(false);
                    showCanvas = false;
                }
                else {
                    myView.showCanvas(true);
                    showCanvas = true;
                }
            }
        });
    }
}