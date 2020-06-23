package com.wat128.nyan_java;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ActionMenuView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Locale;

import com.wat128.nyan_java.CustomImageView;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    private CustomImageView cImageView;
    private int preDx, preDy;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);

        cImageView = this.findViewById(R.id.image_view);
        cImageView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // x, y 位置取得
        int newDx = (int)event.getRawX();
        int newDy = (int)event.getRawY();

        switch(event.getAction()){
            case MotionEvent.ACTION_MOVE:
                v.performClick();

                int dx = cImageView.getLeft() + (newDx - preDx);
                int dy = cImageView.getTop() + (newDy - preDy);
                int imgW = dx + cImageView.getWidth();
                int imgH = dy + cImageView.getHeight();

                cImageView.layout(dx, dy, imgW, imgH);

                textView.setText("dx = " + dx + "\ndy = " + dy);

                break;
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_UP:
                break;
            default:
                break;
        }

        preDx = newDx;
        preDy = newDy;

        return true;
    }
}

