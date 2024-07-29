package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbia extends zzazo implements zzbic {
    zzbia(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public final void zze(zzbht zzbht) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbht);
        zzdc(1, zza);
    }
}
