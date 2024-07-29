package com.onesignal.core.internal.http.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.json.JSONObject;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.core.internal.http.impl.HttpClient", f = "HttpClient.kt", i = {0}, l = {267}, m = "makeRequestIODispatcher", n = {"retVal"}, s = {"L$0"})
/* compiled from: HttpClient.kt */
final class HttpClient$makeRequestIODispatcher$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpClient$makeRequestIODispatcher$1(HttpClient httpClient, Continuation<? super HttpClient$makeRequestIODispatcher$1> continuation) {
        super(continuation);
        this.this$0 = httpClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.makeRequestIODispatcher((String) null, (String) null, (JSONObject) null, 0, (String) null, this);
    }
}
