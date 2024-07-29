package com.reactnativegooglesignin;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNGoogleSigninModule$$ExternalSyntheticLambda2 implements OnCompleteListener {
    public final /* synthetic */ RNGoogleSigninModule f$0;

    public /* synthetic */ RNGoogleSigninModule$$ExternalSyntheticLambda2(RNGoogleSigninModule rNGoogleSigninModule) {
        this.f$0 = rNGoogleSigninModule;
    }

    public final void onComplete(Task task) {
        this.f$0.lambda$signInSilently$0(task);
    }
}
