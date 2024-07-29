package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbmp extends zzazo implements IInterface {
    zzbmp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzbmj zzbmj, zzbmo zzbmo) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzbmj);
        zzazq.zzf(zza, zzbmo);
        zzdd(2, zza);
    }
}
