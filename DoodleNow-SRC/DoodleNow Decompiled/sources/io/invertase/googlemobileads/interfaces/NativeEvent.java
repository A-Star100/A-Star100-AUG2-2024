package io.invertase.googlemobileads.interfaces;

import com.facebook.react.bridge.WritableMap;

public interface NativeEvent {
    WritableMap getEventBody();

    String getEventName();
}
