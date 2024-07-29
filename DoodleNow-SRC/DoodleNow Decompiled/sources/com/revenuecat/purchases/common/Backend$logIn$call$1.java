package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.networking.Endpoint;
import com.revenuecat.purchases.common.networking.HTTPResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/revenuecat/purchases/common/Backend$logIn$call$1", "Lcom/revenuecat/purchases/common/Dispatcher$AsyncCall;", "call", "Lcom/revenuecat/purchases/common/networking/HTTPResult;", "onCompletion", "", "result", "onError", "error", "Lcom/revenuecat/purchases/PurchasesError;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Backend.kt */
public final class Backend$logIn$call$1 extends Dispatcher.AsyncCall {
    final /* synthetic */ String $appUserID;
    final /* synthetic */ List<String> $cacheKey;
    final /* synthetic */ String $newAppUserID;
    final /* synthetic */ Backend this$0;

    Backend$logIn$call$1(String str, String str2, Backend backend, List<String> list) {
        this.$appUserID = str;
        this.$newAppUserID = str2;
        this.this$0 = backend;
        this.$cacheKey = list;
    }

    public HTTPResult call() {
        return HTTPClient.performRequest$default(this.this$0.httpClient, this.this$0.appConfig.getBaseURL(), Endpoint.LogIn.INSTANCE, MapsKt.mapOf(TuplesKt.to(Backend.APP_USER_ID, this.$appUserID), TuplesKt.to(Backend.NEW_APP_USER_ID, this.$newAppUserID)), CollectionsKt.listOf(TuplesKt.to(Backend.APP_USER_ID, this.$appUserID), TuplesKt.to(Backend.NEW_APP_USER_ID, this.$newAppUserID)), this.this$0.backendHelper.getAuthenticationHeaders$purchases_defaultsRelease(), false, 32, (Object) null);
    }

    public void onError(PurchasesError purchasesError) {
        List<Pair> remove;
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        Backend backend = this.this$0;
        List<String> list = this.$cacheKey;
        synchronized (backend) {
            remove = backend.getIdentifyCallbacks().remove(list);
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
        if (BackendHelperKt.isSuccessful(hTTPResult)) {
            Backend backend = this.this$0;
            List<String> list = this.$cacheKey;
            synchronized (backend) {
                remove = backend.getIdentifyCallbacks().remove(list);
            }
            if (remove != null) {
                for (Pair pair : remove) {
                    Function2 function2 = (Function2) pair.component1();
                    Function1 function1 = (Function1) pair.component2();
                    boolean z = hTTPResult.getResponseCode() == 201;
                    if (hTTPResult.getBody().length() > 0) {
                        function2.invoke(CustomerInfoFactory.INSTANCE.buildCustomerInfo(hTTPResult), Boolean.valueOf(z));
                    } else {
                        PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnknownError, (String) null, 2, (DefaultConstructorMarker) null);
                        LogUtilsKt.errorLog(purchasesError);
                        function1.invoke(purchasesError);
                    }
                }
                return;
            }
            return;
        }
        PurchasesError purchasesError2 = ErrorsKt.toPurchasesError(hTTPResult);
        LogUtilsKt.errorLog(purchasesError2);
        onError(purchasesError2);
    }
}
