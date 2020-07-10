package com.wat128.nyan_java;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends FragmentActivity {

    private static final String[] texts = {
            "abc", "bcd", "cde", "def", "efg",
            "fgh", "ghi", "hij", "ijk", "jkl",
            "klm", "スクロールのテスト", "bbb", "ccc", "ddd",
            "eee", "fff", "ggg", "hhh", "iii"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("debug", "MainActivity.onCreate");

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this, R.layout.list);

        ListView listView = findViewById(R.id.listview);

        for(String str : texts) {
            arrayAdapter.add(str);
        }

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        String.format(Locale.US, "%sがTapされました", texts[position]),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }
}

