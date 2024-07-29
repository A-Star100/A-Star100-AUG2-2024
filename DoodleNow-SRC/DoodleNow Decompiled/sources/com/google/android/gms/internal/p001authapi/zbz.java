package com.google.android.gms.internal.p001authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.AuthorizationResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbz  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
final class zbz extends zbi {
    final /* synthetic */ TaskCompletionSource zba;

    zbz(zbaa zbaa, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    public final void zbb(Status status, AuthorizationResult authorizationResult) throws RemoteException {
        if (status.isSuccess()) {
            this.zba.setResult(authorizationResult);
        } else {
            this.zba.setException(ApiExceptionUtil.fromStatus(status));
        }
    }
}
