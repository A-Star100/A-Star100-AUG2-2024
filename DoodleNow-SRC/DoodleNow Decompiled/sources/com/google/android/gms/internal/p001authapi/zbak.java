package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.GetSignInIntentRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbak  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public final /* synthetic */ class zbak implements RemoteCall {
    public final /* synthetic */ zbaq zba;
    public final /* synthetic */ GetSignInIntentRequest zbb;

    public /* synthetic */ zbak(zbaq zbaq, GetSignInIntentRequest getSignInIntentRequest) {
        this.zba = zbaq;
        this.zbb = getSignInIntentRequest;
    }

    public final void accept(Object obj, Object obj2) {
        ((zbw) ((zbar) obj).getService()).zbe(new zbao(this.zba, (TaskCompletionSource) obj2), (GetSignInIntentRequest) Preconditions.checkNotNull(this.zbb));
    }
}
