package com.reactnativegooglesignin;

import com.facebook.react.bridge.WritableMap;

public class PendingAuthRecovery {
    private final WritableMap userProperties;

    public WritableMap getUserProperties() {
        return this.userProperties;
    }

    public PendingAuthRecovery(WritableMap writableMap) {
        this.userProperties = writableMap;
    }
}
