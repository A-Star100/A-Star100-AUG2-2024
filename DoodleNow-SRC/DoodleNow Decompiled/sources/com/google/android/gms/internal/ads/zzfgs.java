package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfgs implements zzgea {
    final /* synthetic */ zzcgm zza;
    final /* synthetic */ zzcpk zzb;
    final /* synthetic */ zzfmt zzc;
    final /* synthetic */ zzefd zzd;

    zzfgs(zzcgm zzcgm, zzcpk zzcpk, zzfmt zzfmt, zzefd zzefd) {
        this.zza = zzcgm;
        this.zzb = zzcpk;
        this.zzc = zzfmt;
        this.zzd = zzefd;
    }

    public final void zza(Throwable th) {
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        String str = (String) obj;
        if (!this.zza.zzD().zzaj) {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzjR)).booleanValue() || this.zzb == null || !zzcpk.zzj(str)) {
                this.zzc.zzc(str, (zzflh) null);
            } else {
                this.zzb.zzi(str, this.zzc, zzay.zze());
            }
        } else {
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            String str2 = this.zza.zzP().zzb;
            int i = 2;
            if (!zzu.zzo().zzz(this.zza.getContext())) {
                if (!((Boolean) zzba.zzc().zza(zzbdz.zzgr)).booleanValue() || !this.zza.zzD().zzT) {
                    i = 1;
                }
            }
            this.zzd.zzd(new zzeff(currentTimeMillis, str2, str, i));
        }
    }
}
