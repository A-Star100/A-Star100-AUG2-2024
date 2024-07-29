package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbgn extends zzazo implements IInterface {
    zzbgn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzbvz zzbvz) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzbvz);
        zzdc(1, zza);
    }
}
