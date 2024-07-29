package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbcl extends zzazo implements IInterface {
    zzbcl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzbcj zzbcj) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzbcj);
        Parcel zzdb = zzdb(3, zza);
        long readLong = zzdb.readLong();
        zzdb.recycle();
        return readLong;
    }

    public final zzbcg zzf(zzbcj zzbcj) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzbcj);
        Parcel zzdb = zzdb(1, zza);
        zzbcg zzbcg = (zzbcg) zzazq.zza(zzdb, zzbcg.CREATOR);
        zzdb.recycle();
        return zzbcg;
    }

    public final zzbcg zzg(zzbcj zzbcj) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzbcj);
        Parcel zzdb = zzdb(2, zza);
        zzbcg zzbcg = (zzbcg) zzazq.zza(zzdb, zzbcg.CREATOR);
        zzdb.recycle();
        return zzbcg;
    }
}
