package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.AuthorizationRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbx  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public final /* synthetic */ class zbx implements RemoteCall {
    public final /* synthetic */ zbaa zba;
    public final /* synthetic */ AuthorizationRequest zbb;

    public /* synthetic */ zbx(zbaa zbaa, AuthorizationRequest authorizationRequest) {
        this.zba = zbaa;
        this.zbb = authorizationRequest;
    }

    public final void accept(Object obj, Object obj2) {
        ((zbk) ((zbg) obj).getService()).zbc(new zbz(this.zba, (TaskCompletionSource) obj2), (AuthorizationRequest) Preconditions.checkNotNull(this.zbb));
    }
}
