package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzcao extends zzazp implements zzcap {
    public zzcao() {
        super("com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    public static zzcap zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalGenerator");
        return queryLocalInterface instanceof zzcap ? (zzcap) queryLocalInterface : new zzcan(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzcam zzcam = null;
        switch (i) {
            case 1:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzcat zzcat = (zzcat) zzazq.zza(parcel, zzcat.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.signals.ISignalCallback");
                    zzcam = queryLocalInterface instanceof zzcam ? (zzcam) queryLocalInterface : new zzcak(readStrongBinder);
                }
                zzazq.zzc(parcel);
                zzf(asInterface, zzcat, zzcam);
                parcel2.writeNoException();
                return true;
            case 2:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                zzk(asInterface2);
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, (IInterface) null);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, (IInterface) null);
                return true;
            case 5:
                ArrayList createTypedArrayList = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbve zzb = zzbvd.zzb(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                zzm(createTypedArrayList, asInterface3, zzb);
                parcel2.writeNoException();
                return true;
            case 6:
                ArrayList createTypedArrayList2 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbve zzb2 = zzbvd.zzb(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                zzl(createTypedArrayList2, asInterface4, zzb2);
                parcel2.writeNoException();
                return true;
            case 7:
                zzazq.zzc(parcel);
                zzg((zzbvn) zzazq.zza(parcel, zzbvn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 8:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                zzj(asInterface5);
                parcel2.writeNoException();
                return true;
            case 9:
                ArrayList createTypedArrayList3 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbve zzb3 = zzbvd.zzb(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                zzi(createTypedArrayList3, asInterface6, zzb3);
                parcel2.writeNoException();
                return true;
            case 10:
                ArrayList createTypedArrayList4 = parcel.createTypedArrayList(Uri.CREATOR);
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzbve zzb4 = zzbvd.zzb(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                zzh(createTypedArrayList4, asInterface7, zzb4);
                parcel2.writeNoException();
                return true;
            case 11:
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString = parcel.readString();
                IObjectWrapper asInterface10 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                IObjectWrapper zze = zze(asInterface8, asInterface9, readString, asInterface10);
                parcel2.writeNoException();
                zzazq.zzf(parcel2, zze);
                return true;
            default:
                return false;
        }
    }
}
