package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbid extends zzazo implements zzbif {
    zzbid(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public final void zze(zzbhv zzbhv) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbhv);
        zzdc(1, zza);
    }
}
