package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbxu extends zzazo implements zzbxw {
    zzbxu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public final void zze(zzbxq zzbxq) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbxq);
        zzdc(5, zza);
    }

    public final void zzf() throws RemoteException {
        zzdc(4, zza());
    }

    public final void zzg(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdc(7, zza);
    }

    public final void zzh() throws RemoteException {
        zzdc(6, zza());
    }

    public final void zzi() throws RemoteException {
        zzdc(1, zza());
    }

    public final void zzj() throws RemoteException {
        zzdc(2, zza());
    }

    public final void zzk() throws RemoteException {
        zzdc(8, zza());
    }

    public final void zzl() throws RemoteException {
        zzdc(3, zza());
    }
}
