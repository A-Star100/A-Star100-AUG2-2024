package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class zzab extends zza implements zzad {
    zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IMarkerDelegate");
    }

    public final void zzA(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(5, zza);
    }

    public final void zzB(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(14, zza);
    }

    public final void zzC(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(27, zza);
    }

    public final void zzD() throws RemoteException {
        zzc(11, zza());
    }

    public final boolean zzE(zzad zzad) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzad);
        Parcel zzJ = zzJ(16, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean zzF() throws RemoteException {
        Parcel zzJ = zzJ(10, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean zzG() throws RemoteException {
        Parcel zzJ = zzJ(21, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean zzH() throws RemoteException {
        Parcel zzJ = zzJ(13, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean zzI() throws RemoteException {
        Parcel zzJ = zzJ(15, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final float zzd() throws RemoteException {
        Parcel zzJ = zzJ(26, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    public final float zze() throws RemoteException {
        Parcel zzJ = zzJ(23, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    public final float zzf() throws RemoteException {
        Parcel zzJ = zzJ(28, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    public final int zzg() throws RemoteException {
        Parcel zzJ = zzJ(17, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    public final IObjectWrapper zzh() throws RemoteException {
        Parcel zzJ = zzJ(34, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzi() throws RemoteException {
        Parcel zzJ = zzJ(30, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    public final LatLng zzj() throws RemoteException {
        Parcel zzJ = zzJ(4, zza());
        LatLng latLng = (LatLng) zzc.zza(zzJ, LatLng.CREATOR);
        zzJ.recycle();
        return latLng;
    }

    public final String zzk() throws RemoteException {
        Parcel zzJ = zzJ(2, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    public final String zzl() throws RemoteException {
        Parcel zzJ = zzJ(8, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    public final String zzm() throws RemoteException {
        Parcel zzJ = zzJ(6, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    public final void zzn() throws RemoteException {
        zzc(12, zza());
    }

    public final void zzo() throws RemoteException {
        zzc(1, zza());
    }

    public final void zzp(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(25, zza);
    }

    public final void zzq(float f, float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zza.writeFloat(f2);
        zzc(19, zza);
    }

    public final void zzr(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(9, zza);
    }

    public final void zzs(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(20, zza);
    }

    public final void zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(18, zza);
    }

    public final void zzu(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(33, zza);
    }

    public final void zzv(float f, float f2) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zza.writeFloat(f2);
        zzc(24, zza);
    }

    public final void zzw(LatLng latLng) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, latLng);
        zzc(3, zza);
    }

    public final void zzx(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(22, zza);
    }

    public final void zzy(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc(7, zza);
    }

    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(29, zza);
    }
}
