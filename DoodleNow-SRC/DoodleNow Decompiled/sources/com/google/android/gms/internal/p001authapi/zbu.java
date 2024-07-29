package com.google.android.gms.internal.p001authapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbu  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public abstract class zbu extends zbb implements zbv {
    public zbu() {
        super("com.google.android.gms.auth.api.identity.internal.ISavePasswordCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zbc.zbb(parcel);
        zbb((Status) zbc.zba(parcel, Status.CREATOR), (SavePasswordResult) zbc.zba(parcel, SavePasswordResult.CREATOR));
        return true;
    }
}
