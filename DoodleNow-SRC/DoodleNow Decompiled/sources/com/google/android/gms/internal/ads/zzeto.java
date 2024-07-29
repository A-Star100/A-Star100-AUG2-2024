package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeto implements zzewr {
    private final Context zza;
    private final zzgep zzb;

    zzeto(zzgep zzgep, Context context) {
        this.zzb = zzgep;
        this.zza = context;
    }

    public final int zza() {
        return 57;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzetn(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzetp zzc() throws Exception {
        zzu.zzp();
        return new zzetp(zzt.zzs(this.zza));
    }
}
