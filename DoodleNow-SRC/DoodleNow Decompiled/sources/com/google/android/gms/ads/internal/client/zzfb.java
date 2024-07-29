package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbyq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final /* synthetic */ class zzfb implements Runnable {
    public final /* synthetic */ zzbyq zza;

    public /* synthetic */ zzfb(zzbyq zzbyq) {
        this.zza = zzbyq;
    }

    public final void run() {
        zzbyq zzbyq = this.zza;
        if (zzbyq != null) {
            try {
                zzbyq.zze(1);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
    }
}
