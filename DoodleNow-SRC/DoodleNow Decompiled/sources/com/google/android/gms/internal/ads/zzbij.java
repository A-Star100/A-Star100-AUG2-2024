package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbij extends zzazo implements zzbil {
    zzbij(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    public final void zze(zzbhy zzbhy) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbhy);
        zzdc(1, zza);
    }
}
