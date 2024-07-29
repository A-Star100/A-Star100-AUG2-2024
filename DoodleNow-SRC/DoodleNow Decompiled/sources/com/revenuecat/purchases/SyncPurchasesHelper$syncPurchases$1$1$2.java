package com.revenuecat.purchases;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SyncPurchasesHelper.kt */
final class SyncPurchasesHelper$syncPurchases$1$1$2 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ boolean $appInBackground;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ List<PurchasesError> $errors;
    final /* synthetic */ boolean $isRestore;
    final /* synthetic */ StoreTransaction $lastPurchase;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<CustomerInfo, Unit> $onSuccess;
    final /* synthetic */ StoreTransaction $purchase;
    final /* synthetic */ SyncPurchasesHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SyncPurchasesHelper$syncPurchases$1$1$2(StoreTransaction storeTransaction, List<PurchasesError> list, StoreTransaction storeTransaction2, SyncPurchasesHelper syncPurchasesHelper, String str, boolean z, boolean z2, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        super(1);
        this.$purchase = storeTransaction;
        this.$errors = list;
        this.$lastPurchase = storeTransaction2;
        this.this$0 = syncPurchasesHelper;
        this.$appUserID = str;
        this.$appInBackground = z;
        this.$isRestore = z2;
        this.$onSuccess = function1;
        this.$onError = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        LogIntent logIntent = LogIntent.RC_ERROR;
        String format = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR_DETAILS, Arrays.copyOf(new Object[]{this.$purchase, purchasesError}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.$errors.add(purchasesError);
        SyncPurchasesHelper$syncPurchases$1.invoke$handleLastPurchase(this.$errors, this.this$0, this.$appUserID, this.$appInBackground, this.$isRestore, this.$onSuccess, this.$onError, this.$purchase, this.$lastPurchase);
    }
}
