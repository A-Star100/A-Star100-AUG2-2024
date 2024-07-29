package com.google.android.gms.internal.p001authapi;

import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbaf  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
final class zbaf extends zbu {
    final /* synthetic */ TaskCompletionSource zba;

    zbaf(zbag zbag, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    public final void zbb(Status status, SavePasswordResult savePasswordResult) throws RemoteException {
        TaskUtil.setResultOrApiException(status, savePasswordResult, this.zba);
    }
}
