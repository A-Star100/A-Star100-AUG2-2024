package com.revenuecat.purchases;

import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006Jt\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\"\b\u0002\u0010\u0012\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013j\u0004\u0018\u0001`\u00152\"\b\u0002\u0010\u0016\u001a\u001c\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\b\u0018\u00010\u0013j\u0004\u0018\u0001`\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;", "", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "postReceiptHelper", "Lcom/revenuecat/purchases/PostReceiptHelper;", "(Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/PostReceiptHelper;)V", "postTransactions", "", "transactions", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "allowSharingPlayStoreAccount", "", "appUserID", "", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "transactionPostSuccess", "Lkotlin/Function2;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lcom/revenuecat/purchases/SuccessfulPurchaseCallback;", "transactionPostError", "Lcom/revenuecat/purchases/PurchasesError;", "Lcom/revenuecat/purchases/ErrorPurchaseCallback;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostTransactionWithProductDetailsHelper.kt */
public final class PostTransactionWithProductDetailsHelper {
    private final BillingAbstract billing;
    /* access modifiers changed from: private */
    public final PostReceiptHelper postReceiptHelper;

    public PostTransactionWithProductDetailsHelper(BillingAbstract billingAbstract, PostReceiptHelper postReceiptHelper2) {
        Intrinsics.checkNotNullParameter(billingAbstract, "billing");
        Intrinsics.checkNotNullParameter(postReceiptHelper2, "postReceiptHelper");
        this.billing = billingAbstract;
        this.postReceiptHelper = postReceiptHelper2;
    }

    public static /* synthetic */ void postTransactions$default(PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, List list, boolean z, String str, PostReceiptInitiationSource postReceiptInitiationSource, Function2 function2, Function2 function22, int i, Object obj) {
        postTransactionWithProductDetailsHelper.postTransactions(list, z, str, postReceiptInitiationSource, (i & 16) != 0 ? null : function2, (i & 32) != 0 ? null : function22);
    }

    public final void postTransactions(List<StoreTransaction> list, boolean z, String str, PostReceiptInitiationSource postReceiptInitiationSource, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function2, Function2<? super StoreTransaction, ? super PurchasesError, Unit> function22) {
        List<StoreTransaction> list2 = list;
        Function2<? super StoreTransaction, ? super PurchasesError, Unit> function23 = function22;
        Intrinsics.checkNotNullParameter(list2, "transactions");
        Intrinsics.checkNotNullParameter(str, "appUserID");
        Intrinsics.checkNotNullParameter(postReceiptInitiationSource, "initiationSource");
        for (StoreTransaction storeTransaction : list2) {
            if (storeTransaction.getPurchaseState() != PurchaseState.PENDING) {
                boolean z2 = z;
                String str2 = str;
                PostReceiptInitiationSource postReceiptInitiationSource2 = postReceiptInitiationSource;
                Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function24 = function2;
                this.billing.queryProductDetailsAsync(storeTransaction.getType(), CollectionsKt.toSet(storeTransaction.getProductIds()), new PostTransactionWithProductDetailsHelper$postTransactions$1$1(storeTransaction, this, z2, str2, postReceiptInitiationSource2, function24, function22), new PostTransactionWithProductDetailsHelper$postTransactions$1$2(this, storeTransaction, z2, str2, postReceiptInitiationSource2, function24, function22));
            } else {
                if (function23 != null) {
                    PurchasesError purchasesError = new PurchasesError(PurchasesErrorCode.PaymentPendingError, (String) null, 2, (DefaultConstructorMarker) null);
                    LogUtilsKt.errorLog(purchasesError);
                    Unit unit = Unit.INSTANCE;
                    function23.invoke(storeTransaction, purchasesError);
                }
            }
            String str3 = str;
        }
    }
}
