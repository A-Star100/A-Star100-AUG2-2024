package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzil {
    private final Context zza;
    private final zzij zzb;

    public zzil(Context context, Handler handler, zzik zzik) {
        this.zza = context.getApplicationContext();
        this.zzb = new zzij(this, handler, zzik);
    }
}
