package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdwe implements Runnable {
    public final /* synthetic */ zzdwk zza;
    public final /* synthetic */ zzbnd zzb;

    public /* synthetic */ zzdwe(zzdwk zzdwk, zzbnd zzbnd) {
        this.zza = zzdwk;
        this.zzb = zzbnd;
    }

    public final void run() {
        zzdwk zzdwk = this.zza;
        try {
            this.zzb.zzb(zzdwk.zzg());
        } catch (RemoteException e) {
            zzm.zzh("", e);
        }
    }
}
