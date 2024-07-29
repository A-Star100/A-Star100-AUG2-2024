package com.onesignal.rnonesignalandroid;

import com.facebook.react.bridge.Promise;
import com.onesignal.ContinueResult;
import java.util.function.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNOneSignal$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ RNOneSignal$$ExternalSyntheticLambda0(Promise promise) {
        this.f$0 = promise;
    }

    public final void accept(Object obj) {
        RNOneSignal.lambda$requestNotificationPermission$0(this.f$0, (ContinueResult) obj);
    }
}
