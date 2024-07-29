package com.revenuecat.purchases.amazon;

import com.amazon.device.iap.model.UserData;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.amazon.listener.ProductDataResponseListener;
import com.revenuecat.purchases.amazon.listener.UserDataResponseListener;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "connectionError", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBilling.kt */
final class AmazonBilling$queryProductDetailsAsync$1 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<List<? extends StoreProduct>, Unit> $onReceive;
    final /* synthetic */ Set<String> $productIds;
    final /* synthetic */ AmazonBilling this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmazonBilling$queryProductDetailsAsync$1(AmazonBilling amazonBilling, Function1<? super PurchasesError, Unit> function1, Set<String> set, Function1<? super List<? extends StoreProduct>, Unit> function12) {
        super(1);
        this.this$0 = amazonBilling;
        this.$onError = function1;
        this.$productIds = set;
        this.$onReceive = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        if (purchasesError == null) {
            UserDataResponseListener access$getUserDataHandler$p = this.this$0.userDataHandler;
            final AmazonBilling amazonBilling = this.this$0;
            final Set<String> set = this.$productIds;
            final Function1<List<? extends StoreProduct>, Unit> function1 = this.$onReceive;
            final Function1<PurchasesError, Unit> function12 = this.$onError;
            access$getUserDataHandler$p.getUserData(new Function1<UserData, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((UserData) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(UserData userData) {
                    Intrinsics.checkNotNullParameter(userData, "userData");
                    ProductDataResponseListener access$getProductDataHandler$p = amazonBilling.productDataHandler;
                    Set<String> set = set;
                    String marketplace = userData.getMarketplace();
                    Intrinsics.checkNotNullExpressionValue(marketplace, "userData.marketplace");
                    access$getProductDataHandler$p.getProductData(set, marketplace, function1, function12);
                }
            }, this.$onError);
            return;
        }
        this.$onError.invoke(purchasesError);
    }
}
