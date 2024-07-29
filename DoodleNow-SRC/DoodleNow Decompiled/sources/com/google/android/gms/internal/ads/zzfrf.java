package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfrf extends zzazo implements IInterface {
    zzfrf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfrd zze(zzfrb zzfrb) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzfrb);
        Parcel zzdb = zzdb(1, zza);
        zzfrd zzfrd = (zzfrd) zzazq.zza(zzdb, zzfrd.CREATOR);
        zzdb.recycle();
        return zzfrd;
    }

    public final zzfrm zzf(zzfrk zzfrk) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzfrk);
        Parcel zzdb = zzdb(3, zza);
        zzfrm zzfrm = (zzfrm) zzazq.zza(zzdb, zzfrm.CREATOR);
        zzdb.recycle();
        return zzfrm;
    }

    public final void zzg(zzfqy zzfqy) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzfqy);
        zzdc(2, zza);
    }
}
