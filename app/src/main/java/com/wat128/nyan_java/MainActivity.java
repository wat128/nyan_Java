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
import android.media.Image;
import android.nfc.TagLostException;
import android.os.Bundle;
import android.util.Log;
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

    private ImageView imageView;
    private TextView textView;
    private DialogFragment dialogFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        imageView = findViewById(R.id.image_view);

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

    public void setSelection(final String str) {
        textView.setText(str);
        if(str.equals("bag clicked"))
            imageView.setImageResource(R.drawable.bag);
        else
            imageView.setImageResource(R.drawable.ic_launcher_foreground);
    }

    public static class AlertDialogFragment extends DialogFragment {

        AlertDialog dialog;
        AlertDialog.Builder alert;
        View alertView;

        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

            alert = new AlertDialog.Builder(getActivity());
            alert.setTitle("Custom AlertDialog");

            if(getActivity() != null)
                alertView = getActivity().getLayoutInflater().inflate(R.layout.alert_layout, null);

            ImageView bag = alertView.findViewById(R.id.bag);
            bag.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("debug", "bag clicked");
                    setMessage("bag clicked");
                    getDialog().dismiss();
                }
            });

            ImageView mrAndroid = alertView.findViewById(R.id.mr_android);
            mrAndroid.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("debug", "Mr.Android clicked");
                    setMessage("Mr.Android clicked");
                    getDialog().dismiss();
                }
            });

            alert.setView(alertView);

            dialog = alert.create();
            dialog.show();

            return dialog;

        }

        private void setMessage(String message) {
            MainActivity mainActivity = (MainActivity)getActivity();
            if(mainActivity != null) {
                mainActivity.setSelection(message);
            }
        }
    }
}