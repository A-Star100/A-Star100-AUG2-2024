package com.reactnativegooglesignin;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNGoogleSigninModule$$ExternalSyntheticLambda3 implements OnCompleteListener {
    public final /* synthetic */ RNGoogleSigninModule f$0;
    public final /* synthetic */ Promise f$1;

    public /* synthetic */ RNGoogleSigninModule$$ExternalSyntheticLambda3(RNGoogleSigninModule rNGoogleSigninModule, Promise promise) {
        this.f$0 = rNGoogleSigninModule;
        this.f$1 = promise;
    }

    public final void onComplete(Task task) {
        this.f$0.lambda$signOut$3(this.f$1, task);
    }
}
