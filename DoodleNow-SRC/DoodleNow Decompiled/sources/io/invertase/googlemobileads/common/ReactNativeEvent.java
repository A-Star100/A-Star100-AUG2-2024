package io.invertase.googlemobileads.common;

import com.facebook.react.bridge.WritableMap;
import io.invertase.googlemobileads.interfaces.NativeEvent;

public class ReactNativeEvent implements NativeEvent {
    private WritableMap eventBody;
    private String eventName;

    public WritableMap getEventBody() {
        return this.eventBody;
    }

    public String getEventName() {
        return this.eventName;
    }

    public ReactNativeEvent(String str, WritableMap writableMap) {
        this.eventName = str;
        this.eventBody = writableMap;
    }
}
