package com.google.android.gms.internal.play_billing;

import androidx.camera.video.AudioStats;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public enum zzhu {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzdw.zzb),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzk;

    private zzhu(Object obj) {
        this.zzk = obj;
    }
}
