package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.auth.api.identity.GetPhoneNumberHintIntentRequest;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* renamed from: com.google.android.gms.internal.auth-api.zbah  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@21.0.0 */
public final /* synthetic */ class zbah implements RemoteCall {
    public final /* synthetic */ zbaq zba;
    public final /* synthetic */ GetPhoneNumberHintIntentRequest zbb;

    public /* synthetic */ zbah(zbaq zbaq, GetPhoneNumberHintIntentRequest getPhoneNumberHintIntentRequest) {
        this.zba = zbaq;
        this.zbb = getPhoneNumberHintIntentRequest;
    }

    public final void accept(Object obj, Object obj2) {
        this.zba.zba(this.zbb, (zbar) obj, (TaskCompletionSource) obj2);
    }
}
