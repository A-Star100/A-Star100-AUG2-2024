package com.revenuecat.purchases;

import com.revenuecat.purchases.common.AppConfig;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Delay;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.identity.IdentityManager;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.utils.Result;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJb\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0018\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u00122\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00192\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0019H\u0002JX\u0010\u001b\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00192\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0019H\u0002J@\u0010 \u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001d2\u0016\b\u0002\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00192\u0018\b\u0002\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/PostPendingTransactionsHelper;", "", "appConfig", "Lcom/revenuecat/purchases/common/AppConfig;", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "identityManager", "Lcom/revenuecat/purchases/identity/IdentityManager;", "postTransactionWithProductDetailsHelper", "Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;", "(Lcom/revenuecat/purchases/common/AppConfig;Lcom/revenuecat/purchases/common/caching/DeviceCache;Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/common/Dispatcher;Lcom/revenuecat/purchases/identity/IdentityManager;Lcom/revenuecat/purchases/PostTransactionWithProductDetailsHelper;)V", "callCompletionFromResults", "", "transactionsToSync", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "results", "Lcom/revenuecat/purchases/utils/Result;", "Lcom/revenuecat/purchases/CustomerInfo;", "Lcom/revenuecat/purchases/PurchasesError;", "onError", "Lkotlin/Function1;", "onSuccess", "postTransactionsWithCompletion", "allowSharingPlayStoreAccount", "", "appUserID", "", "syncPendingPurchaseQueue", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostPendingTransactionsHelper.kt */
public final class PostPendingTransactionsHelper {
    private final AppConfig appConfig;
    private final BillingAbstract billing;
    /* access modifiers changed from: private */
    public final DeviceCache deviceCache;
    private final Dispatcher dispatcher;
    private final IdentityManager identityManager;
    private final PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper;

    public PostPendingTransactionsHelper(AppConfig appConfig2, DeviceCache deviceCache2, BillingAbstract billingAbstract, Dispatcher dispatcher2, IdentityManager identityManager2, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper2) {
        Intrinsics.checkNotNullParameter(appConfig2, "appConfig");
        Intrinsics.checkNotNullParameter(deviceCache2, "deviceCache");
        Intrinsics.checkNotNullParameter(billingAbstract, "billing");
        Intrinsics.checkNotNullParameter(dispatcher2, "dispatcher");
        Intrinsics.checkNotNullParameter(identityManager2, "identityManager");
        Intrinsics.checkNotNullParameter(postTransactionWithProductDetailsHelper2, "postTransactionWithProductDetailsHelper");
        this.appConfig = appConfig2;
        this.deviceCache = deviceCache2;
        this.billing = billingAbstract;
        this.dispatcher = dispatcher2;
        this.identityManager = identityManager2;
        this.postTransactionWithProductDetailsHelper = postTransactionWithProductDetailsHelper2;
    }

    public static /* synthetic */ void syncPendingPurchaseQueue$default(PostPendingTransactionsHelper postPendingTransactionsHelper, boolean z, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        if ((i & 4) != 0) {
            function12 = null;
        }
        postPendingTransactionsHelper.syncPendingPurchaseQueue(z, function1, function12);
    }

    public final void syncPendingPurchaseQueue(boolean z, Function1<? super PurchasesError, Unit> function1, Function1<? super CustomerInfo, Unit> function12) {
        if (!this.appConfig.getDangerousSettings().getAutoSyncPurchases()) {
            LogWrapperKt.log(LogIntent.DEBUG, PurchaseStrings.SKIPPING_AUTOMATIC_SYNC);
            if (function12 != null) {
                function12.invoke(null);
                return;
            }
            return;
        }
        LogWrapperKt.log(LogIntent.DEBUG, PurchaseStrings.UPDATING_PENDING_PURCHASE_QUEUE);
        Dispatcher.enqueue$default(this.dispatcher, new PostPendingTransactionsHelper$$ExternalSyntheticLambda0(this, this.identityManager.getCurrentAppUserID(), z, function1, function12), (Delay) null, 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void syncPendingPurchaseQueue$lambda$0(PostPendingTransactionsHelper postPendingTransactionsHelper, String str, boolean z, Function1 function1, Function1 function12) {
        Intrinsics.checkNotNullParameter(postPendingTransactionsHelper, "this$0");
        Intrinsics.checkNotNullParameter(str, "$appUserID");
        postPendingTransactionsHelper.billing.queryPurchases(str, new PostPendingTransactionsHelper$syncPendingPurchaseQueue$1$1(postPendingTransactionsHelper, z, str, function1, function12), new PostPendingTransactionsHelper$syncPendingPurchaseQueue$1$2(function1));
    }

    static /* synthetic */ void postTransactionsWithCompletion$default(PostPendingTransactionsHelper postPendingTransactionsHelper, List list, boolean z, String str, Function1 function1, Function1 function12, int i, Object obj) {
        postPendingTransactionsHelper.postTransactionsWithCompletion(list, z, str, (i & 8) != 0 ? null : function1, (i & 16) != 0 ? null : function12);
    }

    /* access modifiers changed from: private */
    public final void postTransactionsWithCompletion(List<StoreTransaction> list, boolean z, String str, Function1<? super PurchasesError, Unit> function1, Function1<? super CustomerInfo, Unit> function12) {
        Function1<? super CustomerInfo, Unit> function13 = function12;
        if (list.isEmpty()) {
            LogWrapperKt.log(LogIntent.DEBUG, PurchaseStrings.NO_PENDING_PURCHASES_TO_SYNC);
            if (function13 != null) {
                function13.invoke(null);
            }
            return;
        }
        PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper2 = this.postTransactionWithProductDetailsHelper;
        PostReceiptInitiationSource postReceiptInitiationSource = PostReceiptInitiationSource.UNSYNCED_ACTIVE_PURCHASES;
        List arrayList = new ArrayList();
        List<StoreTransaction> list2 = list;
        Function1<? super PurchasesError, Unit> function14 = function1;
        Function1<? super CustomerInfo, Unit> function15 = function12;
        Function2 postPendingTransactionsHelper$postTransactionsWithCompletion$1 = new PostPendingTransactionsHelper$postTransactionsWithCompletion$1(arrayList, this, list2, function14, function15);
        postTransactionWithProductDetailsHelper2.postTransactions(list, z, str, postReceiptInitiationSource, postPendingTransactionsHelper$postTransactionsWithCompletion$1, new PostPendingTransactionsHelper$postTransactionsWithCompletion$2(arrayList, this, list2, function14, function15));
    }

    static /* synthetic */ void callCompletionFromResults$default(PostPendingTransactionsHelper postPendingTransactionsHelper, List list, List list2, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = null;
        }
        if ((i & 8) != 0) {
            function12 = null;
        }
        postPendingTransactionsHelper.callCompletionFromResults(list, list2, function1, function12);
    }

    /* access modifiers changed from: private */
    public final void callCompletionFromResults(List<StoreTransaction> list, List<? extends Result<CustomerInfo, PurchasesError>> list2, Function1<? super PurchasesError, Unit> function1, Function1<? super CustomerInfo, Unit> function12) {
        if (list.size() == list2.size()) {
            int i = 0;
            for (Object next : list2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Result result = (Result) next;
                if (!(result instanceof Result.Error)) {
                    if (i == list2.size() - 1 && function12 != null) {
                        Intrinsics.checkNotNull(result, "null cannot be cast to non-null type com.revenuecat.purchases.utils.Result.Success<com.revenuecat.purchases.CustomerInfo>");
                        function12.invoke(((Result.Success) result).getValue());
                    }
                    i = i2;
                } else if (function1 != null) {
                    function1.invoke(((Result.Error) result).getValue());
                    return;
                } else {
                    return;
                }
            }
        }
    }
}
