package com.mrousavy.camera.react;

import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CameraView$$ExternalSyntheticLambda1 implements View.OnTouchListener {
    public final /* synthetic */ ScaleGestureDetector f$0;

    public /* synthetic */ CameraView$$ExternalSyntheticLambda1(ScaleGestureDetector scaleGestureDetector) {
        this.f$0 = scaleGestureDetector;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return CameraView.updateZoomGesture$lambda$0(this.f$0, view, motionEvent);
    }
}
