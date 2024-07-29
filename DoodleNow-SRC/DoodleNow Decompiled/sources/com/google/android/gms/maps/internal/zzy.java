package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;
import com.google.android.gms.internal.maps.zzq;
import com.google.android.gms.internal.maps.zzr;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public abstract class zzy extends zzb implements zzz {
    public zzy() {
        super("com.google.android.gms.maps.internal.IOnGroundOverlayClickListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzr zzb = zzq.zzb(parcel.readStrongBinder());
        zzc.zzc(parcel);
        zzb(zzb);
        parcel2.writeNoException();
        return true;
    }
}
