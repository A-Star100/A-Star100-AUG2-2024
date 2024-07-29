package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzccd {
    private final zzcbw zza;
    /* access modifiers changed from: private */
    public final AtomicInteger zzb = new AtomicInteger(0);

    public zzccd() {
        zzcbw zzcbw = new zzcbw();
        this.zza = zzcbw;
        zzgee.zzr(zzcbw, new zzccb(this), zzcbr.zzf);
    }

    @Deprecated
    public final int zze() {
        return this.zzb.get();
    }

    @Deprecated
    public final void zzg() {
        this.zza.zzd(new Exception());
    }

    @Deprecated
    public final void zzh(Throwable th, String str) {
        this.zza.zzd(th);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzhI)).booleanValue()) {
            zzu.zzo().zzv(th, str);
        }
    }

    @Deprecated
    public final void zzi(Object obj) {
        this.zza.zzc(obj);
    }

    @Deprecated
    public final void zzj(zzcca zzcca, zzcby zzcby) {
        zzgee.zzr(this.zza, new zzccc(this, zzcca, zzcby), zzcbr.zzf);
    }
}
