package com.facebook.react.animated;

import androidx.camera.video.AudioStats;
import com.amazon.device.iap.internal.c.b;
import com.facebook.react.bridge.ReadableMap;

class ValueAnimatedNode extends AnimatedNode {
    double mOffset = AudioStats.AUDIO_AMPLITUDE_NONE;
    double mValue = Double.NaN;
    private AnimatedNodeValueListener mValueListener;

    public void extractOffset() {
        this.mOffset += this.mValue;
        this.mValue = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public void flattenOffset() {
        this.mValue += this.mOffset;
        this.mOffset = AudioStats.AUDIO_AMPLITUDE_NONE;
    }

    public Object getAnimatedObject() {
        return null;
    }

    public void setValueListener(AnimatedNodeValueListener animatedNodeValueListener) {
        this.mValueListener = animatedNodeValueListener;
    }

    public ValueAnimatedNode() {
    }

    public ValueAnimatedNode(ReadableMap readableMap) {
        this.mValue = readableMap.getDouble("value");
        this.mOffset = readableMap.getDouble(b.ar);
    }

    public double getValue() {
        if (Double.isNaN(this.mOffset + this.mValue)) {
            update();
        }
        return this.mOffset + this.mValue;
    }

    public void onValueUpdate() {
        AnimatedNodeValueListener animatedNodeValueListener = this.mValueListener;
        if (animatedNodeValueListener != null) {
            animatedNodeValueListener.onValueUpdate(getValue());
        }
    }

    public String prettyPrint() {
        return "ValueAnimatedNode[" + this.mTag + "]: value: " + this.mValue + " offset: " + this.mOffset;
    }
}
