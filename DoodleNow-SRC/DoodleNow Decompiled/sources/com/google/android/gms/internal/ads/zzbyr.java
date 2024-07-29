package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbyr extends zzazo implements IInterface {
    zzbyr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    public final void zze(zzbyg zzbyg, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbyg);
        zza.writeString(str);
        zza.writeString(str2);
        zzdc(2, zza);
    }
}
