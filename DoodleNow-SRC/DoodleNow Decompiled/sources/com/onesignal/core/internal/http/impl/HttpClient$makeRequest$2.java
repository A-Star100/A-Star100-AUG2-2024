package com.onesignal.core.internal.http.impl;

import com.onesignal.core.internal.http.HttpResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/onesignal/core/internal/http/HttpResponse;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.core.internal.http.impl.HttpClient$makeRequest$2", f = "HttpClient.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HttpClient.kt */
final class HttpClient$makeRequest$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponse>, Object> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ JSONObject $jsonBody;
    final /* synthetic */ String $method;
    final /* synthetic */ int $timeout;
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ HttpClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpClient$makeRequest$2(HttpClient httpClient, String str, String str2, JSONObject jSONObject, int i, String str3, Continuation<? super HttpClient$makeRequest$2> continuation) {
        super(2, continuation);
        this.this$0 = httpClient;
        this.$url = str;
        this.$method = str2;
        this.$jsonBody = jSONObject;
        this.$timeout = i;
        this.$cacheKey = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HttpClient$makeRequest$2(this.this$0, this.$url, this.$method, this.$jsonBody, this.$timeout, this.$cacheKey, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponse> continuation) {
        return ((HttpClient$makeRequest$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HttpClient httpClient = this.this$0;
            String str = this.$url;
            this.label = 1;
            obj = httpClient.makeRequestIODispatcher(str, this.$method, this.$jsonBody, this.$timeout, this.$cacheKey, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
