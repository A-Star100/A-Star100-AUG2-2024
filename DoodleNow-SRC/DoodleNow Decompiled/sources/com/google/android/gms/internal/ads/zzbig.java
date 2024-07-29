package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbig extends zzazo implements zzbii {
    zzbig(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    public final void zze(zzbhy zzbhy, String str) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbhy);
        zza.writeString(str);
        zzdc(1, zza);
    }
}
