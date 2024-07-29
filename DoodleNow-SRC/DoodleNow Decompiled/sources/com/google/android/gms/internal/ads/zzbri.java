package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzbri implements InitializationCompleteCallback {
    final /* synthetic */ zzbna zza;

    zzbri(zzbrp zzbrp, zzbna zzbna) {
        this.zza = zzbna;
    }

    public final void onInitializationFailed(String str) {
        try {
            this.zza.zze(str);
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }

    public final void onInitializationSucceeded() {
        try {
            this.zza.zzf();
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }
}
