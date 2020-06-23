package com.wat128.nyan_java;

import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

import java.util.jar.Attributes;

public class CustomImageView extends AppCompatImageView {

    public CustomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }
}
