package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzfua extends zzazp implements zzfub {
    public zzfua() {
        super("com.google.android.play.core.lmd.protocol.ILmdOverlayServiceListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zzdF(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzazq.zzc(parcel);
        zzb((Bundle) zzazq.zza(parcel, Bundle.CREATOR));
        return true;
    }
}
