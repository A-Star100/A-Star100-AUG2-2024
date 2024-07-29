package com.facebook.react.views.text.internal.span;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

public class CustomLetterSpacingSpan extends MetricAffectingSpan implements ReactSpan {
    private final float mLetterSpacing;

    public float getSpacing() {
        return this.mLetterSpacing;
    }

    public CustomLetterSpacingSpan(float f) {
        this.mLetterSpacing = f;
    }

    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
    }

    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }

    private void apply(TextPaint textPaint) {
        if (!Float.isNaN(this.mLetterSpacing)) {
            textPaint.setLetterSpacing(this.mLetterSpacing);
        }
    }
}
