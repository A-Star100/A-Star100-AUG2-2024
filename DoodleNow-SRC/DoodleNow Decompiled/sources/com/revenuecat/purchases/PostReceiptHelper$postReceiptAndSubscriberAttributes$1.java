package com.revenuecat.purchases;

import com.revenuecat.purchases.common.Backend;
import com.revenuecat.purchases.common.PostReceiptErrorHandlingBehavior;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData;
import com.revenuecat.purchases.subscriberattributes.BackendHelpersKt;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttribute;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u0002`\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "unsyncedSubscriberAttributesByKey", "", "", "Lcom/revenuecat/purchases/subscriberattributes/SubscriberAttribute;", "Lcom/revenuecat/purchases/subscriberattributes/caching/SubscriberAttributeMap;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostReceiptHelper.kt */
final class PostReceiptHelper$postReceiptAndSubscriberAttributes$1 extends Lambda implements Function1<Map<String, ? extends SubscriberAttribute>, Unit> {
    final /* synthetic */ String $appUserID;
    final /* synthetic */ PostReceiptInitiationSource $initiationSource;
    final /* synthetic */ boolean $isRestore;
    final /* synthetic */ String $marketplace;
    final /* synthetic */ Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit> $onError;
    final /* synthetic */ Function1<CustomerInfo, Unit> $onSuccess;
    final /* synthetic */ PaywallEvent $presentedPaywall;
    final /* synthetic */ String $purchaseToken;
    final /* synthetic */ ReceiptInfo $receiptInfo;
    final /* synthetic */ String $storeUserID;
    final /* synthetic */ PostReceiptHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostReceiptHelper$postReceiptAndSubscriberAttributes$1(PostReceiptHelper postReceiptHelper, String str, String str2, boolean z, ReceiptInfo receiptInfo, String str3, String str4, PostReceiptInitiationSource postReceiptInitiationSource, PaywallEvent paywallEvent, Function1<? super CustomerInfo, Unit> function1, Function3<? super PurchasesError, ? super PostReceiptErrorHandlingBehavior, ? super JSONObject, Unit> function3) {
        super(1);
        this.this$0 = postReceiptHelper;
        this.$purchaseToken = str;
        this.$appUserID = str2;
        this.$isRestore = z;
        this.$receiptInfo = receiptInfo;
        this.$storeUserID = str3;
        this.$marketplace = str4;
        this.$initiationSource = postReceiptInitiationSource;
        this.$presentedPaywall = paywallEvent;
        this.$onSuccess = function1;
        this.$onError = function3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, SubscriberAttribute>) (Map) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Map<String, SubscriberAttribute> map) {
        PaywallPostReceiptData paywallPostReceiptData;
        final Map<String, SubscriberAttribute> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "unsyncedSubscriberAttributesByKey");
        Backend access$getBackend$p = this.this$0.backend;
        String str = this.$purchaseToken;
        String str2 = this.$appUserID;
        boolean z = this.$isRestore;
        boolean z2 = !this.this$0.getFinishTransactions();
        Map<String, Map<String, Object>> backendMap = BackendHelpersKt.toBackendMap(map);
        ReceiptInfo receiptInfo = this.$receiptInfo;
        String str3 = this.$storeUserID;
        String str4 = this.$marketplace;
        PostReceiptInitiationSource postReceiptInitiationSource = this.$initiationSource;
        PaywallEvent paywallEvent = this.$presentedPaywall;
        if (paywallEvent != null) {
            paywallPostReceiptData = paywallEvent.toPaywallPostReceiptData$purchases_defaultsRelease();
        } else {
            paywallPostReceiptData = null;
        }
        final PostReceiptHelper postReceiptHelper = this.this$0;
        final String str5 = this.$appUserID;
        final Function1<CustomerInfo, Unit> function1 = this.$onSuccess;
        final PaywallEvent paywallEvent2 = this.$presentedPaywall;
        final PostReceiptHelper postReceiptHelper2 = this.this$0;
        final String str6 = this.$appUserID;
        final Map<String, SubscriberAttribute> map3 = map;
        PostReceiptInitiationSource postReceiptInitiationSource2 = postReceiptInitiationSource;
        final Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit> function3 = this.$onError;
        access$getBackend$p.postReceiptData(str, str2, z, z2, backendMap, receiptInfo, str3, str4, postReceiptInitiationSource2, paywallPostReceiptData, new Function2<CustomerInfo, JSONObject, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((CustomerInfo) obj, (JSONObject) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(CustomerInfo customerInfo, JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                Intrinsics.checkNotNullParameter(jSONObject, "responseBody");
                postReceiptHelper.offlineEntitlementsManager.resetOfflineCustomerInfoCache();
                postReceiptHelper.subscriberAttributesManager.markAsSynced(str5, map2, BackendHelpersKt.getAttributeErrors(jSONObject));
                postReceiptHelper.customerInfoUpdateHandler.cacheAndNotifyListeners(customerInfo);
                function1.invoke(customerInfo);
            }
        }, new Function3<PurchasesError, PostReceiptErrorHandlingBehavior, JSONObject, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((PurchasesError) obj, (PostReceiptErrorHandlingBehavior) obj2, (JSONObject) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError purchasesError, PostReceiptErrorHandlingBehavior postReceiptErrorHandlingBehavior, JSONObject jSONObject) {
                Intrinsics.checkNotNullParameter(purchasesError, "error");
                Intrinsics.checkNotNullParameter(postReceiptErrorHandlingBehavior, "errorHandlingBehavior");
                PaywallEvent paywallEvent = paywallEvent2;
                if (paywallEvent != null) {
                    postReceiptHelper2.paywallPresentedCache.cachePresentedPaywall(paywallEvent);
                }
                if (postReceiptErrorHandlingBehavior == PostReceiptErrorHandlingBehavior.SHOULD_BE_CONSUMED) {
                    postReceiptHelper2.subscriberAttributesManager.markAsSynced(str6, map3, BackendHelpersKt.getAttributeErrors(jSONObject));
                }
                function3.invoke(purchasesError, postReceiptErrorHandlingBehavior, jSONObject);
            }
        });
    }
}
