package com.wat128.nyan_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

    private EditText editText;
    private String message;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.text_view);
        textView.setText(message);

        editText = findViewById(R.id.edit_text);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(editText.getText() != null) {
                    String str = message + editText.getText().toString();
                    intent.putExtra(MainActivity.EXTRA_MESSAGE, str);
                }

                editText.setText("");

                setResult(RESULT_OK, intent);

                finish();
            }
        });
    }
}
