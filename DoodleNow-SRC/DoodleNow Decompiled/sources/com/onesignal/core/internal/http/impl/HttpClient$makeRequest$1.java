package com.onesignal.core.internal.http.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.json.JSONObject;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.core.internal.http.impl.HttpClient", f = "HttpClient.kt", i = {0, 0, 0, 0, 0, 0, 1}, l = {93, 96}, m = "makeRequest", n = {"this", "url", "method", "jsonBody", "cacheKey", "timeout", "url"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "L$0"})
/* compiled from: HttpClient.kt */
final class HttpClient$makeRequest$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpClient$makeRequest$1(HttpClient httpClient, Continuation<? super HttpClient$makeRequest$1> continuation) {
        super(continuation);
        this.this$0 = httpClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.makeRequest((String) null, (String) null, (JSONObject) null, 0, (String) null, this);
    }
}
