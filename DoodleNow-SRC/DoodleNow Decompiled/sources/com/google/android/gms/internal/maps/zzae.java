package com.google.android.gms.internal.maps;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public final class zzae extends zza implements zzag {
    zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.maps.model.internal.IPolygonDelegate");
    }

    public final void zzA(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(13, zza);
    }

    public final boolean zzB(zzag zzag) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzag);
        Parcel zzJ = zzJ(19, zza);
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean zzC() throws RemoteException {
        Parcel zzJ = zzJ(22, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean zzD() throws RemoteException {
        Parcel zzJ = zzJ(18, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final boolean zzE() throws RemoteException {
        Parcel zzJ = zzJ(16, zza());
        boolean zzf = zzc.zzf(zzJ);
        zzJ.recycle();
        return zzf;
    }

    public final float zzd() throws RemoteException {
        Parcel zzJ = zzJ(8, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    public final float zze() throws RemoteException {
        Parcel zzJ = zzJ(14, zza());
        float readFloat = zzJ.readFloat();
        zzJ.recycle();
        return readFloat;
    }

    public final int zzf() throws RemoteException {
        Parcel zzJ = zzJ(12, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    public final int zzg() throws RemoteException {
        Parcel zzJ = zzJ(10, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    public final int zzh() throws RemoteException {
        Parcel zzJ = zzJ(24, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    public final int zzi() throws RemoteException {
        Parcel zzJ = zzJ(20, zza());
        int readInt = zzJ.readInt();
        zzJ.recycle();
        return readInt;
    }

    public final IObjectWrapper zzj() throws RemoteException {
        Parcel zzJ = zzJ(28, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzJ.readStrongBinder());
        zzJ.recycle();
        return asInterface;
    }

    public final String zzk() throws RemoteException {
        Parcel zzJ = zzJ(2, zza());
        String readString = zzJ.readString();
        zzJ.recycle();
        return readString;
    }

    public final List zzl() throws RemoteException {
        Parcel zzJ = zzJ(6, zza());
        ArrayList zzb = zzc.zzb(zzJ);
        zzJ.recycle();
        return zzb;
    }

    public final List zzm() throws RemoteException {
        Parcel zzJ = zzJ(4, zza());
        ArrayList<LatLng> createTypedArrayList = zzJ.createTypedArrayList(LatLng.CREATOR);
        zzJ.recycle();
        return createTypedArrayList;
    }

    public final List zzn() throws RemoteException {
        Parcel zzJ = zzJ(26, zza());
        ArrayList<PatternItem> createTypedArrayList = zzJ.createTypedArrayList(PatternItem.CREATOR);
        zzJ.recycle();
        return createTypedArrayList;
    }

    public final void zzo() throws RemoteException {
        zzc(1, zza());
    }

    public final void zzp(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(21, zza);
    }

    public final void zzq(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(11, zza);
    }

    public final void zzr(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(17, zza);
    }

    public final void zzs(List list) throws RemoteException {
        Parcel zza = zza();
        zza.writeList(list);
        zzc(5, zza);
    }

    public final void zzt(List list) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzc(3, zza);
    }

    public final void zzu(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(9, zza);
    }

    public final void zzv(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzc(23, zza);
    }

    public final void zzw(List list) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzc(25, zza);
    }

    public final void zzx(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzc(7, zza);
    }

    public final void zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, iObjectWrapper);
        zzc(27, zza);
    }

    public final void zzz(boolean z) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzc(15, zza);
    }
}
