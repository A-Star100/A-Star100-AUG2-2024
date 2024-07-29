package com.learnium.RNDeviceInfo;

import androidx.core.os.EnvironmentCompat;

public enum DeviceType {
    HANDSET("Handset"),
    TABLET("Tablet"),
    TV("Tv"),
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN);
    
    private final String value;

    public String getValue() {
        return this.value;
    }

    private DeviceType(String str) {
        this.value = str;
    }
}
