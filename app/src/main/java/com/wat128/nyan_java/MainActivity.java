package com.wat128.nyan_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private static final String[] spinnerItems = {
            "Select", "Image", "Image2"};

    private static final String[] spinnerImages = {
            "transparent", "image", "image2"};

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.image_view);

        Spinner spinner = findViewById(R.id.spinner);

        TestAdapter adapter = new TestAdapter(this.getApplicationContext(),
                R.layout.list, spinnerItems, spinnerImages);

        spinner.setAdapter(adapter);

        // リスナーを登録
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //　アイテムが選択された時
            public void onItemSelected(AdapterView<?> parent,
                                       View viw, int position, long id) {

                imageView.setImageResource(getResources().
                        getIdentifier(spinnerImages[position],
                                "drawable", getPackageName()));
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}

