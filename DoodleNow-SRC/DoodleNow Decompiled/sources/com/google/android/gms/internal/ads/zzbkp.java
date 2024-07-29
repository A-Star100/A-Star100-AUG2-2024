package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbkp implements zzbky {
    zzbkp() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        if (zzcgm.zzJ() != null) {
            zzcgm.zzJ().zza();
        }
        zzm zzL = zzcgm.zzL();
        if (zzL != null) {
            zzL.zzb();
            return;
        }
        zzm zzM = zzcgm.zzM();
        if (zzM != null) {
            zzM.zzb();
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
