package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzac;
import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public abstract class zzae extends zzb implements zzaf {
    public zzae() {
        super("com.google.android.gms.maps.internal.IOnInfoWindowCloseListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzad zzb = zzac.zzb(parcel.readStrongBinder());
        zzc.zzc(parcel);
        zzb(zzb);
        parcel2.writeNoException();
        return true;
    }
}
