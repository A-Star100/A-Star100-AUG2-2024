package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbac  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public final /* synthetic */ class zbac implements RemoteCall {
    public final /* synthetic */ zbag zba;
    public final /* synthetic */ SavePasswordRequest zbb;

    public /* synthetic */ zbac(zbag zbag, SavePasswordRequest savePasswordRequest) {
        this.zba = zbag;
        this.zbb = savePasswordRequest;
    }

    public final void accept(Object obj, Object obj2) {
        ((zbn) ((zbh) obj).getService()).zbd(new zbaf(this.zba, (TaskCompletionSource) obj2), (SavePasswordRequest) Preconditions.checkNotNull(this.zbb));
    }
}
