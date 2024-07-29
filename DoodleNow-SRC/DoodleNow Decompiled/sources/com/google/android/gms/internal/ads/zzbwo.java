package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbwo extends zzazo implements zzbwq {
    zzbwo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdsService");
    }

    public final void zze(zzbwi zzbwi, zzbwt zzbwt) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzbwi);
        zzazq.zzf(zza, zzbwt);
        zzdc(3, zza);
    }

    public final void zzf(zzbwe zzbwe, zzbwt zzbwt) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzbwe);
        zzazq.zzf(zza, zzbwt);
        zzdc(1, zza);
    }
}
