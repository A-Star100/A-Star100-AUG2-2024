package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzelo implements zzegl {
    private final zzems zza;
    private final zzdry zzb;

    zzelo(zzems zzems, zzdry zzdry) {
        this.zza = zzems;
        this.zzb = zzdry;
    }

    public final zzegm zza(String str, JSONObject jSONObject) throws zzfgp {
        zzbsn zzbsn;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzbE)).booleanValue()) {
            try {
                zzbsn = this.zzb.zzb(str);
            } catch (RemoteException e) {
                zzm.zzh("Coundn't create RTB adapter: ", e);
                zzbsn = null;
            }
        } else {
            zzbsn = this.zza.zza(str);
        }
        if (zzbsn == null) {
            return null;
        }
        return new zzegm(zzbsn, new zzeif(), str);
    }
}
