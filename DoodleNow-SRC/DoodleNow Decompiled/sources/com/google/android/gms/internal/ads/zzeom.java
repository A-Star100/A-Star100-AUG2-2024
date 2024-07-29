package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeom implements zzcyt {
    public final /* synthetic */ zzeoa zza;
    public final /* synthetic */ zzbnr zzb;

    public /* synthetic */ zzeom(zzeoa zzeoa, zzbnr zzbnr) {
        this.zza = zzeoa;
        this.zzb = zzbnr;
    }

    public final void zzdB(zze zze) {
        this.zza.zzdB(zze);
        zzbnr zzbnr = this.zzb;
        if (zzbnr != null) {
            try {
                zzbnr.zzf(zze);
            } catch (RemoteException e) {
                zzm.zzl("#007 Could not call remote method.", e);
            }
        }
        if (zzbnr != null) {
            try {
                zzbnr.zze(zze.zza);
            } catch (RemoteException e2) {
                zzm.zzl("#007 Could not call remote method.", e2);
            }
        }
    }
}
