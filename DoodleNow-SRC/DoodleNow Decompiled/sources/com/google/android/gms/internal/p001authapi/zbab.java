package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbab  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public final /* synthetic */ class zbab implements RemoteCall {
    public final /* synthetic */ zbag zba;
    public final /* synthetic */ SaveAccountLinkingTokenRequest zbb;

    public /* synthetic */ zbab(zbag zbag, SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        this.zba = zbag;
        this.zbb = saveAccountLinkingTokenRequest;
    }

    public final void accept(Object obj, Object obj2) {
        ((zbn) ((zbh) obj).getService()).zbc(new zbae(this.zba, (TaskCompletionSource) obj2), (SaveAccountLinkingTokenRequest) Preconditions.checkNotNull(this.zbb));
    }
}
