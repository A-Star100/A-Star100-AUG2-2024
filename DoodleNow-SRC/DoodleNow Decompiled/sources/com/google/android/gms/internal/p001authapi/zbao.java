package com.google.android.gms.internal.p001authapi;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbao  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
final class zbao extends zbq {
    final /* synthetic */ TaskCompletionSource zba;

    zbao(zbaq zbaq, TaskCompletionSource taskCompletionSource) {
        this.zba = taskCompletionSource;
    }

    public final void zbb(Status status, PendingIntent pendingIntent) throws RemoteException {
        TaskUtil.setResultOrApiException(status, pendingIntent, this.zba);
    }
}
