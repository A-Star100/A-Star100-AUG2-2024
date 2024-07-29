package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.strings.CustomerInfoStrings;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "purchasedProducts", "", "Lcom/revenuecat/purchases/common/offlineentitlements/PurchasedProduct;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfflineCustomerInfoCalculator.kt */
final class OfflineCustomerInfoCalculator$computeOfflineCustomerInfo$1 extends Lambda implements Function1<List<? extends PurchasedProduct>, Unit> {
    final /* synthetic */ String $appUserID;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<CustomerInfo, Unit> $onSuccess;
    final /* synthetic */ OfflineCustomerInfoCalculator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfflineCustomerInfoCalculator$computeOfflineCustomerInfo$1(Function1<? super PurchasesError, Unit> function1, OfflineCustomerInfoCalculator offlineCustomerInfoCalculator, String str, Function1<? super CustomerInfo, Unit> function12) {
        super(1);
        this.$onError = function1;
        this.this$0 = offlineCustomerInfoCalculator;
        this.$appUserID = str;
        this.$onSuccess = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<PurchasedProduct>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<PurchasedProduct> list) {
        Intrinsics.checkNotNullParameter(list, "purchasedProducts");
        Iterable<PurchasedProduct> iterable = list;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (PurchasedProduct storeTransaction : iterable) {
                if (storeTransaction.getStoreTransaction().getType() == ProductType.INAPP) {
                    PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.UnsupportedError, OfflineEntitlementsStrings.OFFLINE_ENTITLEMENTS_UNSUPPORTED_INAPP_PURCHASES);
                    String format = String.format(CustomerInfoStrings.COMPUTING_OFFLINE_CUSTOMER_INFO_FAILED, Arrays.copyOf(new Object[]{purchasesError}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                    LogUtilsKt.errorLog$default(format, (Throwable) null, 2, (Object) null);
                    this.$onError.invoke(purchasesError);
                    return;
                }
            }
        }
        this.$onSuccess.invoke(this.this$0.buildCustomerInfoUsingListOfPurchases(this.$appUserID, list));
    }
}
