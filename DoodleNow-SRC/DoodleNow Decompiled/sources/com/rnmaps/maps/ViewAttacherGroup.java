package com.rnmaps.maps;

import android.content.Context;
import android.graphics.Rect;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewGroup;

public class ViewAttacherGroup extends ReactViewGroup {
    public boolean hasOverlappingRendering() {
        return false;
    }

    public ViewAttacherGroup(Context context) {
        super(context);
        setWillNotDraw(true);
        setVisibility(0);
        setAlpha(0.0f);
        setRemoveClippedSubviews(false);
        setClipBounds(new Rect(0, 0, 0, 0));
        setOverflow(ViewProps.HIDDEN);
    }
}
