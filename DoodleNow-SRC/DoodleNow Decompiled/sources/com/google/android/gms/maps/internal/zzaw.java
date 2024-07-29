package com.google.android.gms.maps.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzac;
import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.internal.maps.zzb;
import com.google.android.gms.internal.maps.zzc;

/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
public abstract class zzaw extends zzb implements zzax {
    public zzaw() {
        super("com.google.android.gms.maps.internal.IOnMarkerDragListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzad zzb = zzac.zzb(parcel.readStrongBinder());
            zzc.zzc(parcel);
            zzd(zzb);
        } else if (i == 2) {
            zzad zzb2 = zzac.zzb(parcel.readStrongBinder());
            zzc.zzc(parcel);
            zzb(zzb2);
        } else if (i != 3) {
            return false;
        } else {
            zzad zzb3 = zzac.zzb(parcel.readStrongBinder());
            zzc.zzc(parcel);
            zzc(zzb3);
        }
        parcel2.writeNoException();
        return true;
    }
}
