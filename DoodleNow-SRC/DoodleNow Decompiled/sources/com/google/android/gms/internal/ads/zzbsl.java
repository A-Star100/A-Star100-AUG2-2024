package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbsl extends zzazo implements zzbsn {
    zzbsl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final zzdq zze() throws RemoteException {
        Parcel zzdb = zzdb(5, zza());
        zzdq zzb = zzdp.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    public final zzbtc zzf() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        zzbtc zzbtc = (zzbtc) zzazq.zza(zzdb, zzbtc.CREATOR);
        zzdb.recycle();
        return zzbtc;
    }

    public final zzbtc zzg() throws RemoteException {
        Parcel zzdb = zzdb(3, zza());
        zzbtc zzbtc = (zzbtc) zzazq.zza(zzdb, zzbtc.CREATOR);
        zzdb.recycle();
        return zzbtc;
    }

    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzq zzq, zzbsq zzbsq) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzazq.zzd(zza, bundle);
        zzazq.zzd(zza, bundle2);
        zzazq.zzd(zza, zzq);
        zzazq.zzf(zza, zzbsq);
        zzdc(1, zza);
    }

    public final void zzi(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbry zzbry, zzbqu zzbqu) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzazq.zzd(zza, zzl);
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbry);
        zzazq.zzf(zza, zzbqu);
        zzdc(23, zza);
    }

    public final void zzj(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsb zzbsb, zzbqu zzbqu, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzazq.zzd(zza, zzl);
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbsb);
        zzazq.zzf(zza, zzbqu);
        zzazq.zzd(zza, zzq);
        zzdc(13, zza);
    }

    public final void zzk(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsb zzbsb, zzbqu zzbqu, zzq zzq) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzazq.zzd(zza, zzl);
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbsb);
        zzazq.zzf(zza, zzbqu);
        zzazq.zzd(zza, zzq);
        zzdc(21, zza);
    }

    public final void zzl(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbse zzbse, zzbqu zzbqu) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzazq.zzd(zza, zzl);
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbse);
        zzazq.zzf(zza, zzbqu);
        zzdc(14, zza);
    }

    public final void zzm(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsh zzbsh, zzbqu zzbqu) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzazq.zzd(zza, zzl);
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbsh);
        zzazq.zzf(zza, zzbqu);
        zzdc(18, zza);
    }

    public final void zzn(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsh zzbsh, zzbqu zzbqu, zzbgt zzbgt) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzazq.zzd(zza, zzl);
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbsh);
        zzazq.zzf(zza, zzbqu);
        zzazq.zzd(zza, zzbgt);
        zzdc(22, zza);
    }

    public final void zzo(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsk zzbsk, zzbqu zzbqu) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzazq.zzd(zza, zzl);
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbsk);
        zzazq.zzf(zza, zzbqu);
        zzdc(20, zza);
    }

    public final void zzp(String str, String str2, zzl zzl, IObjectWrapper iObjectWrapper, zzbsk zzbsk, zzbqu zzbqu) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzazq.zzd(zza, zzl);
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, zzbsk);
        zzazq.zzf(zza, zzbqu);
        zzdc(16, zza);
    }

    public final void zzq(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzdc(19, zza);
    }

    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(24, zza);
        boolean zzg = zzazq.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(15, zza);
        boolean zzg = zzazq.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        Parcel zzdb = zzdb(17, zza);
        boolean zzg = zzazq.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
