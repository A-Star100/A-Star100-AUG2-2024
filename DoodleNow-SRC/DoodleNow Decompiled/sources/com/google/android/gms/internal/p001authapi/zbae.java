package com.google.android.gms.internal.p001authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbae  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
final class zbae extends zbs {
    final /* synthetic */ TaskCompletionSource zba;

    zbae(zbag zbag, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    public final void zbb(Status status, SaveAccountLinkingTokenResult saveAccountLinkingTokenResult) throws RemoteException {
        if (status.isSuccess()) {
            this.zba.setResult(saveAccountLinkingTokenResult);
        } else {
            this.zba.setException(ApiExceptionUtil.fromStatus(status));
        }
    }
}
