package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbb;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzbwv extends zzazp implements zzbww {
    public zzbwv() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzazq.zzc(parcel);
            zzf((ParcelFileDescriptor) zzazq.zza(parcel, ParcelFileDescriptor.CREATOR));
        } else if (i == 2) {
            zzazq.zzc(parcel);
            zze((zzbb) zzazq.zza(parcel, zzbb.CREATOR));
        } else if (i != 3) {
            return false;
        } else {
            zzazq.zzc(parcel);
            zzg((ParcelFileDescriptor) zzazq.zza(parcel, ParcelFileDescriptor.CREATOR), (zzbxd) zzazq.zza(parcel, zzbxd.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
