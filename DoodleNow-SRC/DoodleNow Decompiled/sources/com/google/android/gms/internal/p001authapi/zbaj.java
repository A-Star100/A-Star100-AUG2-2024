package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbaj  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public final /* synthetic */ class zbaj implements RemoteCall {
    public final /* synthetic */ zbaq zba;
    public final /* synthetic */ BeginSignInRequest zbb;

    public /* synthetic */ zbaj(zbaq zbaq, BeginSignInRequest beginSignInRequest) {
        this.zba = zbaq;
        this.zbb = beginSignInRequest;
    }

    public final void accept(Object obj, Object obj2) {
        ((zbw) ((zbar) obj).getService()).zbc(new zbam(this.zba, (TaskCompletionSource) obj2), (BeginSignInRequest) Preconditions.checkNotNull(this.zbb));
    }
}
