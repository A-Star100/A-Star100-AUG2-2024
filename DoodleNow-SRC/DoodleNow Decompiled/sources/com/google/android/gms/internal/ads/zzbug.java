package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.offline.buffering.zza;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbug extends zzazo implements zzbui {
    zzbug(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public final void zze(Intent intent) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, intent);
        zzdc(1, zza);
    }

    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeStringArray(strArr);
        zza.writeIntArray(iArr);
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(5, zza);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(4, zza);
    }

    public final void zzh() throws RemoteException {
        zzdc(3, zza());
    }

    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        throw null;
    }

    public final void zzj(IObjectWrapper iObjectWrapper, zza zza) throws RemoteException {
        Parcel zza2 = zza();
        zzazq.zzf(zza2, iObjectWrapper);
        zzazq.zzd(zza2, zza);
        zzdc(6, zza2);
    }
}
