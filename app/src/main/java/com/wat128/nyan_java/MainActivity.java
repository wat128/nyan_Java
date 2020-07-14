package com.wat128.nyan_java;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] members = {
            "kina1",
            "kina2",
            "kina3",
            "kina4",
            "kina5",
            "kina6",
            "kina7",
            "kina8"
    };

    private List<Integer> imgList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(String members : members) {
            int imageId = getResources().getIdentifier(members, "drawable", getPackageName());
            imgList.add(imageId);
        }

        GridView gridView = findViewById(R.id.grid_view);

        GridAdapter gridAdapter = new GridAdapter(this.getApplicationContext(), R.layout.grid_items, imgList, members);

        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getApplication(), SubActivity.class);
        intent.putExtra("IMAGEID", imgList.get(position));
        startActivity(intent);
    }
}