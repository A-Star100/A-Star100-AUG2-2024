package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbwk extends zzazo implements zzbwm {
    zzbwk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final void zze(zzbxd zzbxd, zzbww zzbww) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzbxd);
        zzazq.zzf(zza, zzbww);
        zzdc(6, zza);
    }

    public final void zzf(zzbxd zzbxd, zzbww zzbww) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzbxd);
        zzazq.zzf(zza, zzbww);
        zzdc(5, zza);
    }

    public final void zzg(zzbxd zzbxd, zzbww zzbww) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzbxd);
        zzazq.zzf(zza, zzbww);
        zzdc(4, zza);
    }

    public final void zzh(String str, zzbww zzbww) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzazq.zzf(zza, zzbww);
        zzdc(7, zza);
    }
}
