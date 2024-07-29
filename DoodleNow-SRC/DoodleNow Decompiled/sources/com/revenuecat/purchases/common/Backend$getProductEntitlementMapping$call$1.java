package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/revenuecat/purchases/common/Backend$getProductEntitlementMapping$call$1", "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "call", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "onCompletion", "", "result", "onError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Backend.kt */
public final class Backend$getProductEntitlementMapping$call$1 extends Dispatcher.AsyncCall {
    final /* synthetic */ Endpoint.GetProductEntitlementMapping $endpoint;
    final /* synthetic */ String $path;
    final /* synthetic */ Backend this$0;

    Backend$getProductEntitlementMapping$call$1(Backend backend, Endpoint.GetProductEntitlementMapping getProductEntitlementMapping, String str) {
        this.this$0 = backend;
        this.$endpoint = getProductEntitlementMapping;
        this.$path = str;
    }

    public HTTPResult call() {
        return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), this.$endpoint, (Map) null, (List) null, this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, 32, (Object) null);
    }

    public void onError(PurchasesError purchasesError) {
        List<Pair> remove;
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        Backend backend = this.this$0;
        String str = this.$path;
        synchronized (backend) {
            remove = backend.getProductEntitlementCallbacks().remove(str);
        }
        if (remove != null) {
            for (Pair component2 : remove) {
                ((Function1) component2.component2()).invoke(purchasesError);
            }
        }
    }

    public void onCompletion(HTTPResult hTTPResult) {
        List<Pair> remove;
        Intrinsics.checkNotNullParameter(hTTPResult, "result");
        Backend backend = this.this$0;
        String str = this.$path;
        synchronized (backend) {
            remove = backend.getProductEntitlementCallbacks().remove(str);
        }
        if (remove != null) {
            for (Pair pair : remove) {
                Function1 function1 = (Function1) pair.component1();
                Function1 function12 = (Function1) pair.component2();
                if (BackendHelperKt.isSuccessful(hTTPResult)) {
                    try {
                        function1.invoke(ProductEntitlementMapping.Companion.fromJson(hTTPResult.getBody()));
                    } catch (JSONException e) {
                        PurchasesError purchasesError = ErrorsKt.toPurchasesError((Exception) e);
                        LogUtilsKt.errorLog(purchasesError);
                        function12.invoke(purchasesError);
                    }
                } else {
                    PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(hTTPResult);
                    LogUtilsKt.errorLog(purchasesError2);
                    function12.invoke(purchasesError2);
                }
            }
        }
    }
}
