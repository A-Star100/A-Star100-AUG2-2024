package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class zzv extends zza implements zzx {
    zzv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorLevelDelegate");
    }

    public final int zzd() throws RemoteException {
        Parcel zzJ = zzJ(5, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    public final String zze() throws RemoteException {
        Parcel zzJ = zzJ(1, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    public final String zzf() throws RemoteException {
        Parcel zzJ = zzJ(2, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    public final void zzg() throws RemoteException {
        zzc(3, zza());
    }

    public final boolean zzh(zzx zzx) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzx);
        Parcel zzJ = zzJ(4, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }
}
