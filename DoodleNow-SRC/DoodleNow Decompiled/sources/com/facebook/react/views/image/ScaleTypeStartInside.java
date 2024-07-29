package com.facebook.react.views.image;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.facebook.drawee.drawable.ScalingUtils;

class ScaleTypeStartInside extends ScalingUtils.AbstractScaleType {
    public static final ScalingUtils.ScaleType INSTANCE = new ScaleTypeStartInside();

    public String toString() {
        return "start_inside";
    }

    ScaleTypeStartInside() {
    }

    public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
        float min = Math.min(Math.min(f3, f4), 1.0f);
        matrix.setScale(min, min);
        matrix.postTranslate((float) Math.round((float) rect.left), (float) Math.round((float) rect.top));
    }
}
