package com.google.android.gms.internal.ads;

import com.onesignal.inAppMessages.internal.InAppMessageContent;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzfnb {
    HTML(InAppMessageContent.HTML),
    NATIVE("native"),
    JAVASCRIPT("javascript");
    
    private final String zze;

    private zzfnb(String str) {
        this.zze = str;
    }

    public final String toString() {
        return this.zze;
    }
}
