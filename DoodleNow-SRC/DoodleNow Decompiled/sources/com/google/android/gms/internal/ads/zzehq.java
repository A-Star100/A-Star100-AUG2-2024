package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdq;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzehq implements zzctt {
    public final /* synthetic */ zzegm zza;

    public /* synthetic */ zzehq(zzegm zzegm) {
        this.zza = zzegm;
    }

    public final zzdq zza() {
        try {
            return ((zzbsn) this.zza.zzb).zze();
        } catch (RemoteException e) {
            throw new zzfgp(e);
        }
    }
}
