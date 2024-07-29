package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbbs extends zzazo implements zzbbu {
    zzbbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public final void zzb(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzdc(2, zza);
    }

    public final void zzc(zze zze) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zze);
        zzdc(3, zza);
    }

    public final void zzd(zzbbr zzbbr) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbbr);
        zzdc(1, zza);
    }
}
