package com.google.android.gms.internal.auth;

import androidx.camera.video.AudioStats;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.10 */
public enum zzhp {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzef.zzb),
    ENUM((String) null),
    MESSAGE((String) null);
    
    private final Object zzk;

    private zzhp(Object obj) {
        this.zzk = obj;
    }
}
