package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdos {
    private final Executor zza;
    private final zzcqr zzb;
    private final zzdgh zzc;
    private final zzcpk zzd;

    zzdos(Executor executor, zzcqr zzcqr, zzdgh zzdgh, zzcpk zzcpk) {
        this.zza = executor;
        this.zzc = zzdgh;
        this.zzb = zzcqr;
        this.zzd = zzcpk;
    }

    public final void zza(zzcgm zzcgm) {
        if (zzcgm != null) {
            this.zzc.zza(zzcgm.zzF());
            this.zzc.zzo(new zzdoo(zzcgm), this.zza);
            this.zzc.zzo(new zzdop(zzcgm), this.zza);
            this.zzc.zzo(this.zzb, this.zza);
            this.zzb.zzf(zzcgm);
            zzcic zzN = zzcgm.zzN();
            if (((Boolean) zzba.zzc().zza(zzbdz.zzjT)).booleanValue() && zzN != null) {
                zzN.zzJ(this.zzd);
                zzN.zzK(this.zzd, (zzefd) null, (zzduh) null);
            }
            zzcgm.zzae("/trackActiveViewUnit", new zzdoq(this));
            zzcgm.zzae("/untrackActiveViewUnit", new zzdor(this));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcgm zzcgm, Map map) {
        this.zzb.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzcgm zzcgm, Map map) {
        this.zzb.zza();
    }
}
