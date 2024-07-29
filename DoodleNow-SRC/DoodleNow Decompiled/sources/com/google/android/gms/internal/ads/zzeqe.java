package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeqe {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private zzeqd zzb;

    /* access modifiers changed from: package-private */
    public final zzeqd zza() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(zzeqd zzeqd) {
        this.zzb = zzeqd;
    }

    public final void zzc(boolean z) {
        this.zza.set(true);
    }

    public final boolean zzd() {
        return this.zza.get();
    }
}
