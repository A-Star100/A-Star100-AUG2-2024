package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzbwp extends zzazp implements zzbwq {
    public zzbwp() {
        super("com.google.android.gms.ads.internal.request.IAdsService");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzbwt zzbwt = null;
        if (i == 1) {
            zzbwe zzbwe = (zzbwe) zzazq.zza(parcel, zzbwe.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbwt = queryLocalInterface instanceof zzbwt ? (zzbwt) queryLocalInterface : new zzbwr(readStrongBinder);
            }
            zzazq.zzc(parcel);
            zzf(zzbwe, zzbwt);
        } else if (i == 2) {
            zzbwe zzbwe2 = (zzbwe) zzazq.zza(parcel, zzbwe.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                if (queryLocalInterface2 instanceof zzbwt) {
                    zzbwt zzbwt2 = (zzbwt) queryLocalInterface2;
                }
            }
            zzazq.zzc(parcel);
        } else if (i != 3) {
            return false;
        } else {
            zzbwi zzbwi = (zzbwi) zzazq.zza(parcel, zzbwi.CREATOR);
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 != null) {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdsServiceResponseListener");
                zzbwt = queryLocalInterface3 instanceof zzbwt ? (zzbwt) queryLocalInterface3 : new zzbwr(readStrongBinder3);
            }
            zzazq.zzc(parcel);
            zze(zzbwi, zzbwt);
        }
        parcel2.writeNoException();
        return true;
    }
}
