package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzazo;
import com.google.android.gms.internal.ads.zzazq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzde extends zzazo implements zzdg {
    zzde(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public final void zze(zzs zzs) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzs);
        zzdc(1, zza);
    }

    public final boolean zzf() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        boolean zzg = zzazq.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
