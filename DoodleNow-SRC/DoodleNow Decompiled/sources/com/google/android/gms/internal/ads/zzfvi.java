package com.google.android.gms.internal.ads;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzfvi implements IBinder.DeathRecipient {
    public final /* synthetic */ zzfvr zza;

    public /* synthetic */ zzfvi(zzfvr zzfvr) {
        this.zza = zzfvr;
    }

    public final void binderDied() {
        zzfvr.zzj(this.zza);
    }
}
