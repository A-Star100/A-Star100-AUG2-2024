package androidx.camera.core;

import androidx.camera.core.RetryPolicy;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RetryPolicy$$ExternalSyntheticLambda0 implements RetryPolicy {
    public /* synthetic */ long getTimeoutInMillis() {
        return RetryPolicy.CC.$default$getTimeoutInMillis(this);
    }

    public final RetryPolicy.RetryConfig onRetryDecisionRequested(RetryPolicy.ExecutionState executionState) {
        return RetryPolicy.RetryConfig.NOT_RETRY;
    }
}
