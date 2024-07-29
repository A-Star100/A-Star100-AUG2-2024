package com.onesignal.core.internal.application.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.core.internal.application.impl.ApplicationService", f = "ApplicationService.kt", i = {}, l = {309}, m = "waitUntilActivityReady", n = {}, s = {})
/* compiled from: ApplicationService.kt */
final class ApplicationService$waitUntilActivityReady$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ApplicationService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ApplicationService$waitUntilActivityReady$1(ApplicationService applicationService, Continuation<? super ApplicationService$waitUntilActivityReady$1> continuation) {
        super(continuation);
        this.this$0 = applicationService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.waitUntilActivityReady(this);
    }
}
