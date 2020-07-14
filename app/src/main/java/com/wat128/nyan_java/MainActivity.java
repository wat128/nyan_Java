package com.wat128.nyan_java;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private IconList icons;
    private List<Integer> iconList = new ArrayList<>();
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        icons = new IconList();
        for(int i = 0; i < icons.maxNum(); ++i) {
            iconList.add(icons.getIcon(i));
        }

        GridView gridView = findViewById(R.id.grid_view);

        GridAdapter adapter = new GridAdapter(this.getApplicationContext(), R.layout.grid_items, iconList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(this);

        textView = (TextView)findViewById(R.id.text_view);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        textView.setText(icons.getName(position));
    }
}