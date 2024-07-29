package com.reactnativecommunity.slider;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.TouchesHelper;

public class ReactSlidingCompleteEvent extends Event<ReactSlidingCompleteEvent> {
    public static final String EVENT_NAME = "onRNCSliderSlidingComplete";
    private final double mValue;

    public boolean canCoalesce() {
        return false;
    }

    public short getCoalescingKey() {
        return 0;
    }

    public String getEventName() {
        return EVENT_NAME;
    }

    public double getValue() {
        return this.mValue;
    }

    public ReactSlidingCompleteEvent(int i, double d) {
        super(i);
        this.mValue = d;
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return serializeEventData();
    }

    private WritableMap serializeEventData() {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt(TouchesHelper.TARGET_KEY, getViewTag());
        createMap.putDouble("value", getValue());
        return createMap;
    }
}
