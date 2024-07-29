package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class zzak extends zza implements zzam {
    zzak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.ITileOverlayDelegate");
    }

    public final float zzd() throws RemoteException {
        Parcel zzJ = zzJ(13, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    public final float zze() throws RemoteException {
        Parcel zzJ = zzJ(5, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    public final int zzf() throws RemoteException {
        Parcel zzJ = zzJ(9, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    public final String zzg() throws RemoteException {
        Parcel zzJ = zzJ(3, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    public final void zzh() throws RemoteException {
        zzc(2, zza());
    }

    public final void zzi() throws RemoteException {
        zzc(1, zza());
    }

    public final void zzj(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(10, zza);
    }

    public final void zzk(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(12, zza);
    }

    public final void zzl(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(6, zza);
    }

    public final void zzm(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(4, zza);
    }

    public final boolean zzn(zzam zzam) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzam);
        Parcel zzJ = zzJ(8, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean zzo() throws RemoteException {
        Parcel zzJ = zzJ(11, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean zzp() throws RemoteException {
        Parcel zzJ = zzJ(7, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }
}
