package com.wat128.nyan_java;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String[] names = {
            "kina1",
            "kina2",
            "kina3",
            "kina4",
            "kina5",
            "kina6",
            "kina7",
            "kina8"
    };

    private static final Integer[] photos = {
            R.drawable.kina1,
            R.drawable.kina2,
            R.drawable.kina3,
            R.drawable.kina4,
            R.drawable.kina5,
            R.drawable.kina6,
            R.drawable.kina7,
            R.drawable.kina8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager rLayoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(rLayoutManager);

        List itemNames = new ArrayList<>(Arrays.asList(names));
        List itemImages = new ArrayList<>(Arrays.asList(photos));

        List itemEmails = new ArrayList<>();

        for(Object s : itemNames){
            String str = String.format(Locale.ENGLISH, "%s@gmail.com", s);
            itemEmails.add(str);
        }

        RecyclerView.Adapter rAdapter = new MyAdapter(itemImages, itemNames, itemEmails);
        recyclerView.setAdapter(rAdapter);

    }
}