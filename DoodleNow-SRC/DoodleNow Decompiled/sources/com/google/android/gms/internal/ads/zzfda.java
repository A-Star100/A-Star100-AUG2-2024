package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfda {
    private final zzfhw zza;
    private final zzcxx zzb;
    private final Executor zzc;
    /* access modifiers changed from: private */
    public zzfcz zzd;

    public zzfda(zzfhw zzfhw, zzcxx zzcxx, Executor executor) {
        this.zza = zzfhw;
        this.zzb = zzcxx;
        this.zzc = executor;
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzfig zze() {
        zzfgi zzg = this.zzb.zzg();
        return this.zza.zzc(zzg.zzd, zzg.zzf, zzg.zzj);
    }

    public final ListenableFuture zzc() {
        ListenableFuture listenableFuture;
        zzfcz zzfcz = this.zzd;
        if (zzfcz != null) {
            return zzgee.zzh(zzfcz);
        }
        if (!((Boolean) zzbfz.zza.zze()).booleanValue()) {
            zzfcz zzfcz2 = new zzfcz((zzbxd) null, zze(), (zzfcy) null);
            this.zzd = zzfcz2;
            listenableFuture = zzgee.zzh(zzfcz2);
        } else {
            Class<zzeal> cls = zzeal.class;
            listenableFuture = zzgee.zze(zzgee.zzm(zzgdv.zzu(this.zzb.zzb().zze(this.zza.zza())), new zzfcx(this), this.zzc), cls, new zzfcw(this), this.zzc);
        }
        return zzgee.zzm(listenableFuture, zzfcv.zza, this.zzc);
    }
}
