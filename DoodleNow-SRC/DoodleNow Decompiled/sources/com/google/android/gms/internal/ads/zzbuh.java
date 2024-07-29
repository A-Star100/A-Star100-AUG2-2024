package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.offline.buffering.zza;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzbuh extends zzazp implements zzbui {
    public zzbuh() {
        super("com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    public static zzbui zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.offline.IOfflineUtils");
        return queryLocalInterface instanceof zzbui ? (zzbui) queryLocalInterface : new zzbug(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzazq.zzc(parcel);
                zze((Intent) zzazq.zza(parcel, Intent.CREATOR));
                break;
            case 2:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                zzazq.zzc(parcel);
                zzi(asInterface, readString, readString2);
                break;
            case 3:
                zzh();
                break;
            case 4:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                zzg(asInterface2);
                break;
            case 5:
                String[] createStringArray = parcel.createStringArray();
                int[] createIntArray = parcel.createIntArray();
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzazq.zzc(parcel);
                zzf(createStringArray, createIntArray, asInterface3);
                break;
            case 6:
                zzazq.zzc(parcel);
                zzj(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zza) zzazq.zza(parcel, zza.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
