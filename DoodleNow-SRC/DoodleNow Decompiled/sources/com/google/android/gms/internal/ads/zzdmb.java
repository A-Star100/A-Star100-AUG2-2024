package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdmb implements zzbky {
    public final /* synthetic */ zzdmc zza;
    public final /* synthetic */ zzbiy zzb;

    public /* synthetic */ zzdmb(zzdmc zzdmc, zzbiy zzbiy) {
        this.zza = zzdmc;
        this.zzb = zzbiy;
    }

    public final void zza(Object obj, Map map) {
        zzdmc zzdmc = this.zza;
        try {
            zzdmc.zzb = Long.valueOf(Long.parseLong((String) map.get("timestamp")));
        } catch (NumberFormatException unused) {
            zzm.zzg("Failed to call parse unconfirmedClickTimestamp.");
        }
        zzbiy zzbiy = this.zzb;
        zzdmc.zza = (String) map.get("id");
        String str = (String) map.get("asset_id");
        if (zzbiy == null) {
            zzm.zze("Received unconfirmed click but UnconfirmedClickListener is null.");
            return;
        }
        try {
            zzbiy.zzf(str);
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
