package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbai  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public final /* synthetic */ class zbai implements RemoteCall {
    public final /* synthetic */ zbaq zba;

    public /* synthetic */ zbai(zbaq zbaq) {
        this.zba = zbaq;
    }

    public final void accept(Object obj, Object obj2) {
        this.zba.zbb((zbar) obj, (TaskCompletionSource) obj2);
    }
}
