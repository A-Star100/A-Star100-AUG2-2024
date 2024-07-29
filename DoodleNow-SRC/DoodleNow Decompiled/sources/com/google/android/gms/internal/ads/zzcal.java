package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzcal extends zzazp implements zzcam {
    public zzcal() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel.readString();
            parcel.readString();
            zzazq.zzc(parcel);
        } else if (i == 2) {
            String readString = parcel.readString();
            zzazq.zzc(parcel);
            zzb(readString);
        } else if (i != 3) {
            return false;
        } else {
            zzazq.zzc(parcel);
            zzc(parcel.readString(), parcel.readString(), (Bundle) zzazq.zza(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
