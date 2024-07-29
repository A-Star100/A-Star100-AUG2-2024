package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfag implements zzewr {
    private final zzcbh zza;
    private final boolean zzb;
    private final boolean zzc;
    private final ScheduledExecutorService zzd;
    private final zzgep zze;
    private final String zzf;
    private final zzcaw zzg;

    zzfag(zzcbh zzcbh, boolean z, boolean z2, zzcaw zzcaw, zzgep zzgep, String str, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzcbh;
        this.zzb = z;
        this.zzc = z2;
        this.zzg = zzcaw;
        this.zze = zzgep;
        this.zzf = str;
        this.zzd = scheduledExecutorService;
    }

    public final int zza() {
        return 50;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzhk)).booleanValue() && this.zzc) {
            return zzgee.zzh((Object) null);
        }
        if (!this.zzb) {
            return zzgee.zzh((Object) null);
        }
        return zzgee.zze(zzgee.zzo(zzgee.zzm(zzgee.zzh((Object) null), zzfae.zza, this.zze), ((Long) zzbgg.zzc.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzd), Exception.class, new zzfaf(this), this.zze);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfah zzc(Exception exc) {
        this.zza.zzw(exc, "TrustlessTokenSignal");
        return null;
    }
}
