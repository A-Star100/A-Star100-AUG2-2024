package com.reactnativegooglesignin;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.Event;

public class SigninButtonEvent extends Event<SigninButtonEvent> {
    public static final String EVENT_NAME = "topPress";

    public String getEventName() {
        return EVENT_NAME;
    }

    public SigninButtonEvent(int i, int i2) {
        super(i, i2);
    }

    /* access modifiers changed from: protected */
    public WritableMap getEventData() {
        return Arguments.createMap();
    }
}
