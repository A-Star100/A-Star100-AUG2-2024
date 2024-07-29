package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzftx extends zzazo implements zzftz {
    zzftx(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    public final void zze(Bundle bundle, zzfub zzfub) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, bundle);
        zzazq.zzf(zza, zzfub);
        zzdd(2, zza);
    }

    public final void zzf(String str, Bundle bundle, zzfub zzfub) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzazq.zzd(zza, bundle);
        zzazq.zzf(zza, zzfub);
        zzdd(1, zza);
    }

    public final void zzg(Bundle bundle, zzfub zzfub) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, bundle);
        zzazq.zzf(zza, zzfub);
        zzdd(3, zza);
    }
}
