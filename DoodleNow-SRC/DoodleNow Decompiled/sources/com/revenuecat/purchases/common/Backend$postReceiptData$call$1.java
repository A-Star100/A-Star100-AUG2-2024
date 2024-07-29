package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/revenuecat/purchases/common/Backend$postReceiptData$call$1", "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "call", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "onCompletion", "", "result", "onError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Backend.kt */
public final class Backend$postReceiptData$call$1 extends Dispatcher.AsyncCall {
    final /* synthetic */ Map<String, Object> $body;
    final /* synthetic */ List<String> $cacheKey;
    final /* synthetic */ Map<String, String> $extraHeaders;
    final /* synthetic */ List<Pair<String, String>> $postFieldsToSign;
    final /* synthetic */ Backend this$0;

    Backend$postReceiptData$call$1(Backend backend, Map<String, ? extends Object> map, List<Pair<String, String>> list, Map<String, String> map2, List<String> list2) {
        this.this$0 = backend;
        this.$body = map;
        this.$postFieldsToSign = list;
        this.$extraHeaders = map2;
        this.$cacheKey = list2;
    }

    public HTTPResult call() {
        return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), Endpoint.PostReceipt.INSTANCE, this.$body, this.$postFieldsToSign, MapsKt.plus(this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), this.$extraHeaders), false, 32, (Object) null);
    }

    public void onCompletion(HTTPResult hTTPResult) {
        List<Pair> remove;
        Intrinsics.checkNotNullParameter(hTTPResult, "result");
        Backend backend = this.this$0;
        List<String> list = this.$cacheKey;
        synchronized (backend) {
            remove = backend.getPostReceiptCallbacks().remove(list);
        }
        if (remove != null) {
            Backend backend2 = this.this$0;
            for (Pair pair : remove) {
                Function2 function2 = (Function2) pair.component1();
                Function3 function3 = (Function3) pair.component2();
                try {
                    if (BackendHelperKt.isSuccessful(hTTPResult)) {
                        function2.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(hTTPResult), hTTPResult.getBody());
                    } else {
                        PurchasesError purchasesError = ErrorsKt.toPurchasesError(hTTPResult);
                        LogUtilsKt.errorLog(purchasesError);
                        function3.invoke(purchasesError, backend2.determinePostReceiptErrorHandlingBehavior(hTTPResult.getResponseCode(), purchasesError), hTTPResult.getBody());
                    }
                } catch (JSONException e) {
                    PurchasesError purchasesError2 = ErrorsKt.toPurchasesError((Exception) e);
                    LogUtilsKt.errorLog(purchasesError2);
                    function3.invoke(purchasesError2, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
                }
            }
        }
    }

    public void onError(PurchasesError purchasesError) {
        List<Pair> remove;
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        Backend backend = this.this$0;
        List<String> list = this.$cacheKey;
        synchronized (backend) {
            remove = backend.getPostReceiptCallbacks().remove(list);
        }
        if (remove != null) {
            for (Pair component2 : remove) {
                ((Function3) component2.component2()).invoke(purchasesError, PostReceiptErrorHandlingBehavior.SHOULD_NOT_CONSUME, null);
            }
        }
    }
}
