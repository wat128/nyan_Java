package com.wat128.nyan_java;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> itemNames = new ArrayList<String>(Arrays.asList(names));
        List<Integer> itemImages = new ArrayList<Integer>(Arrays.asList(photos));

        ListView listView = findViewById(R.id.list_view);

        BaseAdapter adapter = new ListViewAdapter(this.getApplicationContext(), R.layout.list, itemNames, itemImages);

        listView.setAdapter(adapter);
    }
}

