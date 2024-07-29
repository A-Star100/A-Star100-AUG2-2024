package com.google.android.gms.internal.p001authapi;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.api.Status;

/* renamed from: com.google.android.gms.internal.auth-api.zbs  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public abstract class zbs extends zbb implements zbt {
    public zbs() {
        super("com.google.android.gms.auth.api.identity.internal.ISaveAccountLinkingTokenCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zbc.zbb(parcel);
        zbb((Status) zbc.zba(parcel, Status.CREATOR), (SaveAccountLinkingTokenResult) zbc.zba(parcel, SaveAccountLinkingTokenResult.CREATOR));
        return true;
    }
}
