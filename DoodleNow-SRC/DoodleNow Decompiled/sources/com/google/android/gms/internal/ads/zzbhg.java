package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbhg extends zzazo implements zzbhi {
    zzbhg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public final IObjectWrapper zzb(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzdb = zzdb(2, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final void zzc() throws RemoteException {
        zzdc(4, zza());
    }

    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(7, zza);
    }

    public final void zzdv(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(1, zza);
    }

    public final void zzdw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(6, zza);
    }

    public final void zzdx(zzbhb zzbhb) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbhb);
        zzdc(8, zza);
    }

    public final void zzdy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(9, zza);
    }

    public final void zzdz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(3, zza);
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zza.writeInt(i);
        zzdc(5, zza);
    }
}
