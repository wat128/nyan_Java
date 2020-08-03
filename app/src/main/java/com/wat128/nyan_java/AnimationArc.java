package com.wat128.nyan_java;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public class AnimationArc extends Animation {

    private Arc arc;

    private float centerX;
    private float centerY;

    private float oldAngle;
    private float newAngle;

    AnimationArc(Arc arc, int newAngle) {
        this.oldAngle = arc.getAngle();
        this.newAngle = newAngle;
        this.arc = arc;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {

        float angle = oldAngle + ((newAngle - oldAngle) * interpolatedTime);

        arc.setAngle(angle);
        arc.requestLayout();
    }
}
