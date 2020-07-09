package com.wat128.nyan_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Locale;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("debug", "MainActivity.onCreate");

        int MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT;
        int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;

        RelativeLayout layout = new RelativeLayout(this);
        layout.setLayoutParams(new RelativeLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT));

        HorizontalScrollView scrollView = new HorizontalScrollView(this);
        scrollView.setLayoutParams(new HorizontalScrollView.LayoutParams(MATCH_PARENT, MATCH_PARENT));

        ImageView imageView = new ImageView(this);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image2);
        imageView.setImageBitmap(bitmap);

        imageView.setLayoutParams(new RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        scrollView.addView(imageView);
        setContentView(scrollView);


/* // サンプルみないで記述したコード
        final int matchParent = ViewGroup.LayoutParams.MATCH_PARENT;
        final int wrapContent = ViewGroup.LayoutParams.WRAP_CONTENT;

        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this);
        horizontalScrollView.setLayoutParams(new HorizontalScrollView.LayoutParams(wrapContent, matchParent));

        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.image2);
        imageView.setLayoutParams(new LinearLayout.LayoutParams(wrapContent, wrapContent));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        horizontalScrollView.addView(imageView);
        setContentView(horizontalScrollView);
*/ // サンプルみないで記述したコード

    }
}

