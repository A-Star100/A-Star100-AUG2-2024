package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbhm extends zzazo implements zzbho {
    zzbhm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
    }

    public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(3, zza);
    }

    public final void zzc(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(1, zza);
    }

    public final void zzd() throws RemoteException {
        zzdc(2, zza());
    }
}
