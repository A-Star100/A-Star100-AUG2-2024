package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzbb;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbwu extends zzazo implements zzbww {
    zzbwu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    public final void zze(zzbb zzbb) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, zzbb);
        zzdc(2, zza);
    }

    public final void zzf(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, parcelFileDescriptor);
        zzdc(1, zza);
    }

    public final void zzg(ParcelFileDescriptor parcelFileDescriptor, zzbxd zzbxd) throws RemoteException {
        Parcel zza = zza();
        zzazq.zzd(zza, parcelFileDescriptor);
        zzazq.zzd(zza, zzbxd);
        zzdc(3, zza);
    }
}
