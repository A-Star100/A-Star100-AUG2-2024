package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzcan extends zzazo implements zzcap {
    zzcan(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, iObjectWrapper2);
        zza.writeString(str);
        zzazq.zzf(zza, iObjectWrapper3);
        Parcel zzdb = zzdb(11, zza);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzcat zzcat, zzcam zzcam) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzd(zza, zzcat);
        zzazq.zzf(zza, zzcam);
        zzdc(1, zza);
    }

    public final void zzg(zzbvn zzbvn) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzbvn);
        zzdc(7, zza);
    }

    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbve zzbve) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbve);
        zzdc(10, zza);
    }

    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbve zzbve) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbve);
        zzdc(9, zza);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(8, zza);
    }

    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(2, zza);
    }

    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbve zzbve) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbve);
        zzdc(6, zza);
    }

    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbve zzbve) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbve);
        zzdc(5, zza);
    }
}
