package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbes extends zzazo implements zzbeu {
    zzbes(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    public final void zze(zzber zzber) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzber);
        zzdc(1, zza);
    }
}
