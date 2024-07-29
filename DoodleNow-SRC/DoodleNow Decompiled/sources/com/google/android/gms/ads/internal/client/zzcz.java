package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzazp;
import com.google.android.gms.internal.ads.zzazq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzcz extends zzazp implements zzda {
    public zzcz() {
        super("com.google.android.gms.ads.internal.client.IOnAdInspectorClosedListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzazq.zzc(parcel);
        zze((zze) zzazq.zza(parcel, zze.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
