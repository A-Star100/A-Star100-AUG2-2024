package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.client.zzdm;
import com.google.android.gms.ads.internal.client.zzdn;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbbp extends zzazo implements zzbbr {
    zzbbp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    public final zzbu zze() throws RemoteException {
        throw null;
    }

    public final zzdn zzf() throws RemoteException {
        Parcel zzdb = zzdb(5, zza());
        zzdn zzb = zzdm.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    public final void zzg(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzazq.zza;
        zza.writeInt(z ? 1 : 0);
        zzdc(6, zza);
    }

    public final void zzh(zzdg zzdg) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, zzdg);
        zzdc(7, zza);
    }

    public final void zzi(IObjectWrapper iObjectWrapper, zzbby zzbby) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbby);
        zzdc(4, zza);
    }
}
