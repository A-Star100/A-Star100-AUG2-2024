package com.google.android.gms.internal.ads;

import android.content.pm.PackageInfo;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzexs implements zzewr {
    private final Executor zza;
    private final String zzb;
    private final PackageInfo zzc;
    private final zzcay zzd;

    public zzexs(zzcay zzcay, Executor executor, String str, PackageInfo packageInfo, int i) {
        this.zzd = zzcay;
        this.zza = executor;
        this.zzb = str;
        this.zzc = packageInfo;
    }

    public final int zza() {
        return 41;
    }

    public final ListenableFuture zzb() {
        return zzgee.zzf(zzgee.zzm(zzgee.zzh(this.zzb), zzexq.zza, this.zza), Throwable.class, new zzexr(this), this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Throwable th) throws Exception {
        return zzgee.zzh(new zzext(this.zzb));
    }
}
