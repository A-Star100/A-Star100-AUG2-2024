package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.paywalls.events.PaywallEventRequest;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/revenuecat/purchases/common/Backend$postPaywallEvents$call$1", "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "call", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "onCompletion", "", "result", "onError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Backend.kt */
public final class Backend$postPaywallEvents$call$1 extends Dispatcher.AsyncCall {
    final /* synthetic */ Map<String, Object> $body;
    final /* synthetic */ PaywallEventRequest $paywallEventRequest;
    final /* synthetic */ Backend this$0;

    Backend$postPaywallEvents$call$1(Backend backend, Map<String, ? extends Object> map, PaywallEventRequest paywallEventRequest) {
        this.this$0 = backend;
        this.$body = map;
        this.$paywallEventRequest = paywallEventRequest;
    }

    public HTTPResult call() {
        return HTTPClient.performRequest$default(this.this$0.httpClient, AppConfig.Companion.getPaywallEventsURL(), Endpoint.PostPaywallEvents.INSTANCE, this.$body, (List) null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, 32, (Object) null);
    }

    public void onError(PurchasesError purchasesError) {
        List<Pair> remove;
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        Backend backend = this.this$0;
        PaywallEventRequest paywallEventRequest = this.$paywallEventRequest;
        synchronized (backend) {
            remove = backend.getPaywallEventsCallbacks().remove(paywallEventRequest.getCacheKey());
        }
        if (remove != null) {
            for (Pair component2 : remove) {
                ((Function2) component2.component2()).invoke(purchasesError, true);
            }
        }
    }

    public void onCompletion(HTTPResult hTTPResult) {
        List<Pair> remove;
        Intrinsics.checkNotNullParameter(hTTPResult, "result");
        Backend backend = this.this$0;
        PaywallEventRequest paywallEventRequest = this.$paywallEventRequest;
        synchronized (backend) {
            remove = backend.getPaywallEventsCallbacks().remove(paywallEventRequest.getCacheKey());
        }
        if (remove != null) {
            for (Pair pair : remove) {
                Function0 function0 = (Function0) pair.component1();
                Function2 function2 = (Function2) pair.component2();
                if (BackendHelperKt.isSuccessful(hTTPResult)) {
                    function0.invoke();
                } else {
                    function2.invoke(ErrorsKt.toPurchasesError(hTTPResult), Boolean.valueOf(RCHTTPStatusCodes.INSTANCE.isSynced(hTTPResult.getResponseCode())));
                }
            }
        }
    }
}
