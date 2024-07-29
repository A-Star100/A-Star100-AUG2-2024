package io.invertase.googlemobileads.interfaces;

import com.facebook.react.bridge.WritableMap;

public interface NativeError {
    String getErrorCode();

    String getErrorMessage();

    WritableMap getUserInfo();
}
