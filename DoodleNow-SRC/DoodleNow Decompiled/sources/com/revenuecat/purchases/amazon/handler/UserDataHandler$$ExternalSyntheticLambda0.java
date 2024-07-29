package com.revenuecat.purchases.amazon.handler;

import com.amazon.device.iap.model.RequestId;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class UserDataHandler$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ UserDataHandler f$0;
    public final /* synthetic */ RequestId f$1;

    public /* synthetic */ UserDataHandler$$ExternalSyntheticLambda0(UserDataHandler userDataHandler, RequestId requestId) {
        this.f$0 = userDataHandler;
        this.f$1 = requestId;
    }

    public final void run() {
        UserDataHandler.addTimeoutToUserDataRequest$lambda$5(this.f$0, this.f$1);
    }
}
