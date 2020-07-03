package com.wat128.nyan_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // the key constant
    public static final String EXTRA_MESSAGE = "com.wat128.nyan_java.MESSAGE";

    private TextView textView;
    static final int RESULT_SUBACTIVITY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        final EditText editText = findViewById(R.id.edit_text);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), SubActivity.class);
                if(editText.getText() != null) {
                    String str = editText.getText().toString();
                    intent.putExtra(EXTRA_MESSAGE, str);
                }
                startActivityForResult(intent, RESULT_SUBACTIVITY);

                editText.setText("");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK && requestCode == RESULT_SUBACTIVITY && null != data) {
            String res = data.getStringExtra(MainActivity.EXTRA_MESSAGE);
            textView.setText(res);
        }
    }
}

