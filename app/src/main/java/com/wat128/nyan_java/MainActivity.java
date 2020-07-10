package com.wat128.nyan_java;

import androidx.fragment.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
        Log.d("debug", "MainActivity.onCreate");

        ListView listView = new ListView(this);
        setContentView(listView);

        // simple_list_item_1は、デフォルトで用意されているレイアウトファイルのID
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<>(this, R.layout.list, texts);

        listView.setAdapter(arrayAdapter);
    }
}

