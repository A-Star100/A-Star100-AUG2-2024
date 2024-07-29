package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzdp;
import com.google.android.gms.ads.internal.client.zzdq;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbqz extends zzazo implements IInterface {
    zzbqz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
    }

    public final double zze() throws RemoteException {
        Parcel zzdb = zzdb(7, zza());
        double readDouble = zzdb.readDouble();
        zzdb.recycle();
        return readDouble;
    }

    public final Bundle zzf() throws RemoteException {
        Parcel zzdb = zzdb(15, zza());
        Bundle bundle = (Bundle) zzazq.zza(zzdb, Bundle.CREATOR);
        zzdb.recycle();
        return bundle;
    }

    public final zzdq zzg() throws RemoteException {
        Parcel zzdb = zzdb(17, zza());
        zzdq zzb = zzdp.zzb(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzb;
    }

    public final zzbgx zzh() throws RemoteException {
        Parcel zzdb = zzdb(19, zza());
        zzbgx zzj = zzbgw.zzj(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzj;
    }

    public final zzbhe zzi() throws RemoteException {
        Parcel zzdb = zzdb(5, zza());
        zzbhe zzg = zzbhd.zzg(zzdb.readStrongBinder());
        zzdb.recycle();
        return zzg;
    }

    public final IObjectWrapper zzj() throws RemoteException {
        Parcel zzdb = zzdb(18, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzk() throws RemoteException {
        Parcel zzdb = zzdb(20, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzl() throws RemoteException {
        Parcel zzdb = zzdb(21, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzdb.readStrongBinder());
        zzdb.recycle();
        return asInterface;
    }

    public final String zzm() throws RemoteException {
        Parcel zzdb = zzdb(4, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzn() throws RemoteException {
        Parcel zzdb = zzdb(6, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzo() throws RemoteException {
        Parcel zzdb = zzdb(2, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzp() throws RemoteException {
        Parcel zzdb = zzdb(9, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final String zzq() throws RemoteException {
        Parcel zzdb = zzdb(8, zza());
        String readString = zzdb.readString();
        zzdb.recycle();
        return readString;
    }

    public final List zzr() throws RemoteException {
        Parcel zzdb = zzdb(3, zza());
        ArrayList zzb = zzazq.zzb(zzdb);
        zzdb.recycle();
        return zzb;
    }

    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(11, zza);
    }

    public final void zzt() throws RemoteException {
        zzdc(10, zza());
    }

    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(12, zza);
    }

    public final void zzv(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzazq.zzf(zza, iObjectWrapper2);
        zzazq.zzf(zza, iObjectWrapper3);
        zzdc(22, zza);
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzf(zza, iObjectWrapper);
        zzdc(16, zza);
    }

    public final boolean zzx() throws RemoteException {
        Parcel zzdb = zzdb(14, zza());
        boolean zzg = zzazq.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }

    public final boolean zzy() throws RemoteException {
        Parcel zzdb = zzdb(13, zza());
        boolean zzg = zzazq.zzg(zzdb);
        zzdb.recycle();
        return zzg;
    }
}
