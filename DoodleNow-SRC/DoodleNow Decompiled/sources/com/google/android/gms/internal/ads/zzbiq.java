package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbiq extends zzazo implements zzbis {
    zzbiq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public final void zze(zzbjb zzbjb) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbjb);
        zzdc(1, zza);
    }
}
