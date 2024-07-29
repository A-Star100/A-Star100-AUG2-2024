package com.revenuecat.purchases;

import android.util.Pair;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.interfaces.ProductChangeCallback;
import com.revenuecat.purchases.interfaces.PurchaseCallback;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¨\u0006\n"}, d2 = {"com/revenuecat/purchases/PurchasesOrchestrator$getPurchasesUpdatedListener$1", "Lcom/revenuecat/purchases/common/BillingAbstract$PurchasesUpdatedListener;", "onPurchasesFailedToUpdate", "", "purchasesError", "Lcom/revenuecat/purchases/PurchasesError;", "onPurchasesUpdated", "purchases", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
public final class PurchasesOrchestrator$getPurchasesUpdatedListener$1 implements BillingAbstract.PurchasesUpdatedListener {
    final /* synthetic */ PurchasesOrchestrator this$0;

    PurchasesOrchestrator$getPurchasesUpdatedListener$1(PurchasesOrchestrator purchasesOrchestrator) {
        this.this$0 = purchasesOrchestrator;
    }

    public void onPurchasesUpdated(List<StoreTransaction> list) {
        Pair pair;
        Intrinsics.checkNotNullParameter(list, "purchases");
        PurchasesOrchestrator purchasesOrchestrator = this.this$0;
        synchronized (purchasesOrchestrator) {
            if (purchasesOrchestrator.getState$purchases_defaultsRelease().getDeprecatedProductChangeCallback() != null) {
                pair = purchasesOrchestrator.getProductChangeCompletedCallbacks(purchasesOrchestrator.getAndClearProductChangeCallback());
            } else {
                pair = purchasesOrchestrator.getPurchaseCompletedCallbacks();
            }
            Unit unit = Unit.INSTANCE;
        }
        this.this$0.postTransactionWithProductDetailsHelper.postTransactions(list, this.this$0.getAllowSharingPlayStoreAccount(), this.this$0.getAppUserID(), PostReceiptInitiationSource.PURCHASE, (Function2) pair.first, (Function2) pair.second);
    }

    public void onPurchasesFailedToUpdate(PurchasesError purchasesError) {
        Unit unit;
        Intrinsics.checkNotNullParameter(purchasesError, "purchasesError");
        PurchasesOrchestrator purchasesOrchestrator = this.this$0;
        synchronized (purchasesOrchestrator) {
            ProductChangeCallback access$getAndClearProductChangeCallback = purchasesOrchestrator.getAndClearProductChangeCallback();
            if (access$getAndClearProductChangeCallback != null) {
                purchasesOrchestrator.dispatch(access$getAndClearProductChangeCallback, purchasesError);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                for (PurchaseCallback access$dispatch : purchasesOrchestrator.getAndClearAllPurchaseCallbacks()) {
                    purchasesOrchestrator.dispatch(access$dispatch, purchasesError);
                }
            }
            Unit unit2 = Unit.INSTANCE;
        }
    }
}
