package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzazo;
import com.google.android.gms.internal.ads.zzazq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzdr extends zzazo implements zzdt {
    zzdr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IVideoLifecycleCallbacks");
    }

    public final void zze() throws RemoteException {
        zzdc(4, zza());
    }

    public final void zzf(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzazq.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(5, zza);
    }

    public final void zzg() throws RemoteException {
        zzdc(3, zza());
    }

    public final void zzh() throws RemoteException {
        zzdc(2, zza());
    }

    public final void zzi() throws RemoteException {
        zzdc(1, zza());
    }
}
