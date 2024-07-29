package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/revenuecat/purchases/common/BackendHelper$performRequest$1", "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "call", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "onCompletion", "", "result", "onError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BackendHelper.kt */
public final class BackendHelper$performRequest$1 extends Dispatcher.AsyncCall {
    final /* synthetic */ Map<String, Object> $body;
    final /* synthetic */ Endpoint $endpoint;
    final /* synthetic */ Function3<PurchasesError, Integer, JSONObject, Unit> $onCompleted;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ List<Pair<String, String>> $postFieldsToSign;
    final /* synthetic */ BackendHelper this$0;

    BackendHelper$performRequest$1(BackendHelper backendHelper, Endpoint endpoint, Map<String, ? extends Object> map, List<Pair<String, String>> list, Function1<? super PurchasesError, Unit> function1, Function3<? super PurchasesError, ? super Integer, ? super JSONObject, Unit> function3) {
        this.this$0 = backendHelper;
        this.$endpoint = endpoint;
        this.$body = map;
        this.$postFieldsToSign = list;
        this.$onError = function1;
        this.$onCompleted = function3;
    }

    public HTTPResult call() {
        return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), this.$endpoint, this.$body, this.$postFieldsToSign, this.this$0.getAuthenticationHeaders$purchases_defaultsRelease(), false, 32, (Object) null);
    }

    public void onError(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        this.$onError.invoke(purchasesError);
    }

    public void onCompletion(HTTPResult hTTPResult) {
        PurchasesError purchasesError;
        Intrinsics.checkNotNullParameter(hTTPResult, "result");
        if (!BackendHelperKt.isSuccessful(hTTPResult)) {
            purchasesError = ErrorsKt.toPurchasesError(hTTPResult);
            LogUtilsKt.errorLog(purchasesError);
        } else {
            purchasesError = null;
        }
        this.$onCompleted.invoke(purchasesError, Integer.valueOf(hTTPResult.getResponseCode()), hTTPResult.getBody());
    }
}
