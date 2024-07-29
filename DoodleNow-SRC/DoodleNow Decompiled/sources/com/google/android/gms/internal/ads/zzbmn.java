package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzbmn extends zzazp implements zzbmo {
    public zzbmn() {
        super("com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzazq.zzc(parcel);
        zzb((ParcelFileDescriptor) zzazq.zza(parcel, ParcelFileDescriptor.CREATOR));
        return true;
    }
}
