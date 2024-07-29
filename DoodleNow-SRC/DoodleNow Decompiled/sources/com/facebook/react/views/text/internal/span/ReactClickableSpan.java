package com.facebook.react.views.text.internal.span;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.view.ViewGroupClickEvent;

public class ReactClickableSpan extends ClickableSpan implements ReactSpan {
    private final int mReactTag;

    public int getReactTag() {
        return this.mReactTag;
    }

    public void updateDrawState(TextPaint textPaint) {
    }

    public ReactClickableSpan(int i) {
        this.mReactTag = i;
    }

    public void onClick(View view) {
        ReactContext reactContext = (ReactContext) view.getContext();
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, this.mReactTag);
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new ViewGroupClickEvent(UIManagerHelper.getSurfaceId((Context) reactContext), this.mReactTag));
        }
    }
}
