package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdow implements Runnable {
    public final /* synthetic */ zzdoy zza;

    public /* synthetic */ zzdow(zzdoy zzdoy) {
        this.zza = zzdoy;
    }

    public final void run() {
        try {
            this.zza.zzd();
        } catch (RemoteException e) {
            zzm.zzl("#007 Could not call remote method.", e);
        }
    }
}
