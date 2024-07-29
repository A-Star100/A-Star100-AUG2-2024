package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzewo implements zzewr {
    private final zzgep zza;
    private final Context zzb;

    zzewo(zzgep zzgep, Context context) {
        this.zza = zzgep;
        this.zzb = context;
    }

    public final int zza() {
        return 37;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzewm(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzewq zzc() throws Exception {
        zzbdq zzbdq = zzbdz.zzgi;
        Bundle zzb2 = zzad.zzb(this.zzb, (String) zzba.zzc().zza(zzbdq));
        if (zzb2.isEmpty()) {
            return null;
        }
        return new zzewn(zzb2);
    }
}
