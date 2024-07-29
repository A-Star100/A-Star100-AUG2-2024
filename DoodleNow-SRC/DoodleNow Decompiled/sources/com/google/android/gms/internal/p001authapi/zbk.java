package com.google.android.gms.internal.p001authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.AuthorizationRequest;

/* renamed from: com.google.android.gms.internal.auth-api.zbk  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public final class zbk extends zba implements IInterface {
    zbk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.identity.internal.IAuthorizationService");
    }

    public final void zbc(zbj zbj, AuthorizationRequest authorizationRequest) throws RemoteException {
        Parcel zba = zba();
        zbc.zbd(zba, zbj);
        zbc.zbc(zba, authorizationRequest);
        zbb(1, zba);
    }
}
