package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzazp;
import com.google.android.gms.internal.ads.zzazq;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzdf extends zzazp implements zzdg {
    public zzdf() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzdg zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        return queryLocalInterface instanceof zzdg ? (zzdg) queryLocalInterface : new zzde(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzazq.zzc(parcel);
            zze((zzs) zzazq.zza(parcel, zzs.CREATOR));
            parcel2.writeNoException();
        } else if (i != 2) {
            return false;
        } else {
            boolean zzf = zzf();
            parcel2.writeNoException();
            int i3 = zzazq.zza;
            parcel2.writeInt(zzf ? 1 : 0);
        }
        return true;
    }
}
