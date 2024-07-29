package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.PowerManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzmn {
    private final PowerManager zza;

    public zzmn(Context context) {
        this.zza = (PowerManager) context.getApplicationContext().getSystemService("power");
    }
}
