package com.revenuecat.purchases;

import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.ReceiptInfo;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "allPurchases", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: SyncPurchasesHelper.kt */
final class SyncPurchasesHelper$syncPurchases$1 extends Lambda implements Function1<List<? extends StoreTransaction>, Unit> {
    final /* synthetic */ boolean $appInBackground;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ boolean $isRestore;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<CustomerInfo, Unit> $onSuccess;
    final /* synthetic */ SyncPurchasesHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SyncPurchasesHelper$syncPurchases$1(SyncPurchasesHelper syncPurchasesHelper, String str, boolean z, boolean z2, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        super(1);
        this.this$0 = syncPurchasesHelper;
        this.$appUserID = str;
        this.$appInBackground = z;
        this.$isRestore = z2;
        this.$onSuccess = function1;
        this.$onError = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<StoreTransaction>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<StoreTransaction> list) {
        List<StoreTransaction> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "allPurchases");
        if (!list2.isEmpty()) {
            StoreTransaction storeTransaction = (StoreTransaction) CollectionsKt.last(list);
            List arrayList = new ArrayList();
            SyncPurchasesHelper syncPurchasesHelper = this.this$0;
            boolean z = this.$isRestore;
            String str = this.$appUserID;
            boolean z2 = this.$appInBackground;
            Function1<CustomerInfo, Unit> function1 = this.$onSuccess;
            Function1<PurchasesError, Unit> function12 = this.$onError;
            for (StoreTransaction storeTransaction2 : list2) {
                ReceiptInfo receiptInfo = new ReceiptInfo(storeTransaction2.getProductIds(), (PresentedOfferingContext) null, (String) null, (StoreProduct) null, (Double) null, (String) null, (ReplacementMode) null, WebSocketProtocol.PAYLOAD_SHORT, (DefaultConstructorMarker) null);
                PostReceiptHelper access$getPostReceiptHelper$p = syncPurchasesHelper.postReceiptHelper;
                String purchaseToken = storeTransaction2.getPurchaseToken();
                String storeUserID = storeTransaction2.getStoreUserID();
                String marketplace = storeTransaction2.getMarketplace();
                PostReceiptInitiationSource postReceiptInitiationSource = PostReceiptInitiationSource.RESTORE;
                StoreTransaction storeTransaction3 = storeTransaction2;
                SyncPurchasesHelper syncPurchasesHelper2 = syncPurchasesHelper;
                String str2 = str;
                Function1<PurchasesError, Unit> function13 = function12;
                boolean z3 = z2;
                Function1<CustomerInfo, Unit> function14 = function1;
                boolean z4 = z;
                boolean z5 = z2;
                Function1<CustomerInfo, Unit> function15 = function14;
                String str3 = str;
                Function1<PurchasesError, Unit> function16 = function13;
                Function1 syncPurchasesHelper$syncPurchases$1$1$1 = new SyncPurchasesHelper$syncPurchases$1$1$1(storeTransaction3, storeTransaction, arrayList, syncPurchasesHelper2, str2, z3, z4, function15, function16);
                String str4 = str3;
                access$getPostReceiptHelper$p.postTokenWithoutConsuming(purchaseToken, storeUserID, receiptInfo, z, str4, marketplace, postReceiptInitiationSource, syncPurchasesHelper$syncPurchases$1$1$1, new SyncPurchasesHelper$syncPurchases$1$1$2(storeTransaction3, arrayList, storeTransaction, syncPurchasesHelper2, str4, z5, z4, function15, function16));
                function12 = function13;
                function1 = function14;
                z2 = z5;
                str = str3;
            }
            return;
        }
        this.this$0.retrieveCustomerInfo(this.$appUserID, this.$appInBackground, this.$isRestore, this.$onSuccess, this.$onError);
    }

    /* access modifiers changed from: private */
    public static final void invoke$handleLastPurchase(List<PurchasesError> list, SyncPurchasesHelper syncPurchasesHelper, String str, boolean z, boolean z2, Function1<? super CustomerInfo, Unit> function1, Function1<? super PurchasesError, Unit> function12, StoreTransaction storeTransaction, StoreTransaction storeTransaction2) {
        if (!Intrinsics.areEqual((Object) storeTransaction, (Object) storeTransaction2)) {
            return;
        }
        if (list.isEmpty()) {
            LogUtilsKt.debugLog(PurchaseStrings.SYNCED_PURCHASES_SUCCESSFULLY);
            syncPurchasesHelper.retrieveCustomerInfo(str, z, z2, function1, function12);
            return;
        }
        String format = String.format(PurchaseStrings.SYNCING_PURCHASES_ERROR, Arrays.copyOf(new Object[]{list}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogUtilsKt.errorLog$default(format, (Throwable) null, 2, (Object) null);
        function12.invoke(CollectionsKt.first(list));
    }
}
