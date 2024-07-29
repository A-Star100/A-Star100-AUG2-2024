package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzbsj extends zzazp implements zzbsk {
    public zzbsj() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zzg();
        } else if (i == 3) {
            String readString = parcel.readString();
            zzazq.zzc(parcel);
            zze(readString);
        } else if (i != 4) {
            return false;
        } else {
            zzazq.zzc(parcel);
            zzf((zze) zzazq.zza(parcel, zze.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
