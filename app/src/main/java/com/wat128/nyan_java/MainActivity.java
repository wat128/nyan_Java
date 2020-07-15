package com.wat128.nyan_java;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private DialogFragment dialogFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager = getSupportFragmentManager();

                dialogFragment = new AlertDialogFragment();

                dialogFragment.show(fragmentManager, "test alert dialog");
            }
        });
    }

    public void setTextView(final String message) {
        textView.setText(message);
    }

    public static class AlertDialogFragment extends DialogFragment {

        private String[] menulist = {"AAA", "BBB", "CCC"};

        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

            AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

            alert.setTitle("Test AlertDialog");
            alert.setItems(menulist, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if(which == 0){
                        setMessage(menulist[0]);
                    }
                    else if (which == 1) {
                        setMessage(menulist[1]);
                    }
                    else {
                        setMessage(menulist[2]);
                    }
                }
            });

            return alert.create();
        }

        private void setMessage(String message) {
            MainActivity mainActivity = (MainActivity)getActivity();
            if(mainActivity != null) {
                mainActivity.setTextView(message);
            }
        }
    }
}