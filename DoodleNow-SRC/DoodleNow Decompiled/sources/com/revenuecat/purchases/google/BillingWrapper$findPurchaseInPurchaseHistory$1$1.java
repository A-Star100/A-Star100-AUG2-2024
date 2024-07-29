package com.revenuecat.purchases.google;

import com.android.billingclient.api.PurchaseHistoryRecord;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "purchasesList", "", "Lcom/android/billingclient/api/PurchaseHistoryRecord;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
final class BillingWrapper$findPurchaseInPurchaseHistory$1$1 extends Lambda implements Function1<List<? extends PurchaseHistoryRecord>, Unit> {
    final /* synthetic */ Function1<StoreTransaction, Unit> $onCompletion;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ String $productId;
    final /* synthetic */ ProductType $productType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingWrapper$findPurchaseInPurchaseHistory$1$1(ProductType productType, Function1<? super StoreTransaction, Unit> function1, String str, Function1<? super PurchasesError, Unit> function12) {
        super(1);
        this.$productType = productType;
        this.$onCompletion = function1;
        this.$productId = str;
        this.$onError = function12;
    }

    public final void invoke(List<? extends PurchaseHistoryRecord> list) {
        StoreTransaction storeTransaction;
        Object obj;
        Intrinsics.checkNotNullParameter(list, "purchasesList");
        String str = this.$productId;
        Iterator it = list.iterator();
        while (true) {
            storeTransaction = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((PurchaseHistoryRecord) obj).getProducts().contains(str)) {
                break;
            }
        }
        PurchaseHistoryRecord purchaseHistoryRecord = (PurchaseHistoryRecord) obj;
        if (purchaseHistoryRecord != null) {
            storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(purchaseHistoryRecord, this.$productType);
        }
        if (storeTransaction != null) {
            this.$onCompletion.invoke(storeTransaction);
            return;
        }
        String format = String.format(PurchaseStrings.NO_EXISTING_PURCHASE, Arrays.copyOf(new Object[]{this.$productId}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        this.$onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, format));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends PurchaseHistoryRecord>) (List) obj);
        return Unit.INSTANCE;
    }
}
