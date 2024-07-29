package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzw;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfcj implements zzfir {
    public final zzfdd zza;
    public final zzfdf zzb;
    public final zzl zzc;
    public final String zzd;
    public final Executor zze;
    public final zzw zzf;
    public final zzfig zzg;

    public zzfcj(zzfdd zzfdd, zzfdf zzfdf, zzl zzl, String str, Executor executor, zzw zzw, zzfig zzfig) {
        this.zza = zzfdd;
        this.zzb = zzfdf;
        this.zzc = zzl;
        this.zzd = str;
        this.zze = executor;
        this.zzf = zzw;
        this.zzg = zzfig;
    }

    public final zzfig zza() {
        return this.zzg;
    }

    public final Executor zzb() {
        return this.zze;
    }
}
