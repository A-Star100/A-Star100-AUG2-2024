package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfdh implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;
    private final zzhjm zzc;

    public zzfdh(zzhjm zzhjm, zzhjm zzhjm2, zzhjm zzhjm3) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
        this.zzc = zzhjm3;
    }

    /* renamed from: zza */
    public final zzfde zzb() {
        zzcbb zzcbb;
        Context context = (Context) this.zza.zzb();
        zzfhs zzfhs = (zzfhs) this.zzb.zzb();
        zzfik zzfik = (zzfik) this.zzc.zzb();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgu)).booleanValue()) {
            zzcbb = zzu.zzo().zzi().zzg();
        } else {
            zzcbb = zzu.zzo().zzi().zzh();
        }
        boolean z = false;
        if (zzcbb != null && zzcbb.zzh()) {
            z = true;
        }
        if (((Integer) zzba.zzc().zza(zzbdz.zzgw)).intValue() > 0) {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzgt)).booleanValue() || z) {
                zzfij zza2 = zzfik.zza(zzfia.Rewarded, context, zzfhs, new zzfci(new zzfcf()));
                return new zzfck(new zzfcu(new zzfct()), new zzfcq(zza2.zza, zzcbr.zza), zza2.zzb, zza2.zza.zza().zzf, zzcbr.zza);
            }
        }
        return new zzfct();
    }
}
