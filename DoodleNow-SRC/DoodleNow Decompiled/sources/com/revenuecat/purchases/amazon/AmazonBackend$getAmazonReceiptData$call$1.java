package com.revenuecat.purchases.amazon;

import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.networking.Endpoint;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBackend.kt */
final class AmazonBackend$getAmazonReceiptData$call$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ List<String> $cacheKey;
    final /* synthetic */ String $receiptId;
    final /* synthetic */ String $storeUserID;
    final /* synthetic */ AmazonBackend this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmazonBackend$getAmazonReceiptData$call$1(AmazonBackend amazonBackend, String str, String str2, List<String> list) {
        super(0);
        this.this$0 = amazonBackend;
        this.$storeUserID = str;
        this.$receiptId = str2;
        this.$cacheKey = list;
    }

    public final void invoke() {
        Delay delay = Delay.NONE;
        final AmazonBackend amazonBackend = this.this$0;
        final List<String> list = this.$cacheKey;
        final AmazonBackend amazonBackend2 = this.this$0;
        final List<String> list2 = this.$cacheKey;
        this.this$0.backendHelper.performRequest(new Endpoint.GetAmazonReceipt(this.$storeUserID, this.$receiptId), (Map<String, ? extends Object>) null, (List<Pair<String, String>>) null, delay, new Function1<PurchasesError, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError purchasesError) {
                List<Pair> remove;
                Intrinsics.checkNotNullParameter(purchasesError, "error");
                AmazonBackend amazonBackend = amazonBackend;
                List<String> list = list;
                synchronized (amazonBackend) {
                    remove = amazonBackend.getPostAmazonReceiptCallbacks().remove(list);
                }
                if (remove != null) {
                    for (Pair component2 : remove) {
                        ((Function1) component2.component2()).invoke(purchasesError);
                    }
                }
            }
        }, new Function3<PurchasesError, Integer, JSONObject, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((PurchasesError) obj, ((Number) obj2).intValue(), (JSONObject) obj3);
                return Unit.INSTANCE;
            }

            public final void invoke(PurchasesError purchasesError, int i, JSONObject jSONObject) {
                List<Pair> remove;
                Intrinsics.checkNotNullParameter(jSONObject, TtmlNode.TAG_BODY);
                AmazonBackend amazonBackend = amazonBackend2;
                List<String> list = list2;
                synchronized (amazonBackend) {
                    remove = amazonBackend.getPostAmazonReceiptCallbacks().remove(list);
                }
                if (remove != null) {
                    for (Pair pair : remove) {
                        Function1 function1 = (Function1) pair.component1();
                        Function1 function12 = (Function1) pair.component2();
                        if (purchasesError != null) {
                            function12.invoke(purchasesError);
                        } else {
                            function1.invoke(jSONObject);
                        }
                    }
                }
            }
        });
    }
}
