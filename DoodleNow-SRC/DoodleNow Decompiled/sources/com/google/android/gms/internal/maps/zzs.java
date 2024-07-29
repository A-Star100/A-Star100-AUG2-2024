package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class zzs extends zza implements zzu {
    zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IIndoorBuildingDelegate");
    }

    public final int zzd() throws RemoteException {
        Parcel zzJ = zzJ(1, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    public final int zze() throws RemoteException {
        Parcel zzJ = zzJ(2, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    public final int zzf() throws RemoteException {
        Parcel zzJ = zzJ(6, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    public final List zzg() throws RemoteException {
        Parcel zzJ = zzJ(3, zza());
        ArrayList<IBinder> createBinderArrayList = zzJ.createBinderArrayList();
        zzJ.recycle();
        return createBinderArrayList;
    }

    public final boolean zzh(zzu zzu) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzu);
        Parcel zzJ = zzJ(5, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean zzi() throws RemoteException {
        Parcel zzJ = zzJ(4, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }
}
