package com.revenuecat.purchases;

import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.strings.PurchaseStrings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJH\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0013H\u0002J>\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\f0\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/SyncPurchasesHelper;", "", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "customerInfoHelper", "Lcom/revenuecat/purchases/CustomerInfoHelper;", "postReceiptHelper", "Lcom/revenuecat/purchases/PostReceiptHelper;", "(Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/CustomerInfoHelper;Lcom/revenuecat/purchases/PostReceiptHelper;)V", "retrieveCustomerInfo", "", "appUserID", "", "appInBackground", "", "isRestore", "onSuccess", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/CustomerInfo;", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "syncPurchases", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SyncPurchasesHelper.kt */
public final class SyncPurchasesHelper {
    private final BillingAbstract billing;
    private final CustomerInfoHelper customerInfoHelper;
    private final IdentityManager identityManager;
    /* access modifiers changed from: private */
    public final PostReceiptHelper postReceiptHelper;

    public SyncPurchasesHelper(BillingAbstract billingAbstract, IdentityManager identityManager2, CustomerInfoHelper customerInfoHelper2, PostReceiptHelper postReceiptHelper2) {
        Intrinsics.checkNotNullParameter(billingAbstract, "billing");
        Intrinsics.checkNotNullParameter(identityManager2, "identityManager");
        Intrinsics.checkNotNullParameter(customerInfoHelper2, "customerInfoHelper");
        Intrinsics.checkNotNullParameter(postReceiptHelper2, "postReceiptHelper");
        this.billing = billingAbstract;
        this.identityManager = identityManager2;
        this.customerInfoHelper = customerInfoHelper2;
        this.postReceiptHelper = postReceiptHelper2;
    }

    public final void syncPurchases(boolean z, boolean z2, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        LogWrapperKt.log(LogIntent.DEBUG, PurchaseStrings.SYNCING_PURCHASES);
        String currentAppUserID = this.identityManager.getCurrentAppUserID();
        this.billing.queryAllPurchases(currentAppUserID, new SyncPurchasesHelper$syncPurchases$1(this, currentAppUserID, z2, z, function1, function12), new SyncPurchasesHelper$syncPurchases$2(function12));
    }

    /* access modifiers changed from: private */
    public final void retrieveCustomerInfo(String str, boolean z, boolean z2, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        this.customerInfoHelper.retrieveCustomerInfo(str, CacheFetchPolicy.CACHED_OR_FETCHED, z, z2, new SyncPurchasesHelper$retrieveCustomerInfo$1(function1, function12));
    }
}
