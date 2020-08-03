package com.wat128.nyan_java;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class TestAnimation extends Animation {

    private int currentPosition = 0;
    private int endPosition = 0;

    private MainActivity.TestView testView;

    TestAnimation(MainActivity.TestView testView, int pos) {
        currentPosition = testView.getPosition();
        endPosition = pos;
        this.testView = testView;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        int pp = (int)((endPosition - currentPosition) * interpolatedTime);

        testView.setPosition(pp);
        testView.requestLayout();
    }
}
