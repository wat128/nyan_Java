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

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private BaseAdapter adapter;
    private List<String> itemNames;
    private List<Integer> itemImages;
    private int tappedPosition = 0;

    private static final String[] scenes = {
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

        itemNames = new ArrayList<>(Arrays.asList(scenes));
        itemImages = new ArrayList<>(Arrays.asList(photos));

        ListView listView = findViewById(R.id.list_view);

        adapter = new ListViewAdapter(this.getApplicationContext(), R.layout.list, itemNames, itemImages);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String item = itemNames.get(position);
        setPosition(position);
        alertCheck(item);
    }

    private void setPosition(final int position) {
        tappedPosition = position;
    }

    private int getPosition() {
        return tappedPosition;
    }

    private void alertCheck(String item) {
        String[] alertMenu = {"上に移動", "下に移動", "削除", "cancel"};

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(item);
        alert.setItems(alertMenu, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (which == 0) {        // 上に移動
                    moveAbove();
                } else if (which == 1) {   // 下に移動
                    moveBelow();
                } else if (which == 2) {   // アイテムの削除
                    deleteCheck();
                } else {                  // cancel
                    Log.d("debug", "cancel");
                }

            }
        });
        alert.show();
    }

    private void deleteCheck() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("削除");
        alertDialogBuilder.setMessage("本当に削除しますか?");

        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        deleteItem();
                    }
                });

        alertDialogBuilder.setNeutralButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        alertDialogBuilder.setCancelable(true);

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }

    private void moveAbove() {
        int position = getPosition();

        if (position > 0) {
            String str = itemNames.get(position - 1);
            itemNames.set(position - 1, itemNames.get(position));
            itemNames.set(position, str);

            int tmp = itemImages.get(position - 1);
            itemImages.set(position - 1, itemImages.get(position));
            itemImages.set(position, tmp);
        } else {
            Log.d("debug", "error : moveAbove()");
        }

        adapter.notifyDataSetChanged();

    }

    private void moveBelow() {
        int position = getPosition();
        if(position < itemNames.size() - 1) {
            String str = itemNames.get(position + 1);
            itemNames.set(position + 1, itemNames.get(position));
            itemNames.set(position, str);

            int tmp = itemImages.get(position + 1);
            itemImages.set(position + 1, itemImages.get(position));
            itemImages.set(position, tmp);
        } else {
            Log.d("debug", "error : moveBelow()");
        }

        adapter.notifyDataSetChanged();
    }

    private void deleteItem() {
        int position = getPosition();

        itemNames.remove(position);
        itemImages.remove(position);

        adapter.notifyDataSetChanged();
    }
}

