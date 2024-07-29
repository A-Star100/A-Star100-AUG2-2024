package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public abstract class zzay extends zzb implements zzaz {
    public zzay() {
        super("com.google.android.gms.maps.internal.IOnMyLocationButtonClickListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        boolean zzb = zzb();
        parcel2.writeNoException();
        int i3 = zzc.zza;
        parcel2.writeInt(zzb ? 1 : 0);
        return true;
    }
}
