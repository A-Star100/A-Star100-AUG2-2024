package com.revenuecat.purchases;

import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "storeProducts", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PostTransactionWithProductDetailsHelper.kt */
final class PostTransactionWithProductDetailsHelper$postTransactions$1$1 extends Lambda implements Function1<List<? extends StoreProduct>, Unit> {
    final /* synthetic */ boolean $allowSharingPlayStoreAccount;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ PostReceiptInitiationSource $initiationSource;
    final /* synthetic */ StoreTransaction $transaction;
    final /* synthetic */ Function2<StoreTransaction, PurchasesError, Unit> $transactionPostError;
    final /* synthetic */ Function2<StoreTransaction, CustomerInfo, Unit> $transactionPostSuccess;
    final /* synthetic */ PostTransactionWithProductDetailsHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PostTransactionWithProductDetailsHelper$postTransactions$1$1(StoreTransaction storeTransaction, PostTransactionWithProductDetailsHelper postTransactionWithProductDetailsHelper, boolean z, String str, PostReceiptInitiationSource postReceiptInitiationSource, Function2<? super StoreTransaction, ? super CustomerInfo, Unit> function2, Function2<? super StoreTransaction, ? super PurchasesError, Unit> function22) {
        super(1);
        this.$transaction = storeTransaction;
        this.this$0 = postTransactionWithProductDetailsHelper;
        this.$allowSharingPlayStoreAccount = z;
        this.$appUserID = str;
        this.$initiationSource = postReceiptInitiationSource;
        this.$transactionPostSuccess = function2;
        this.$transactionPostError = function22;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) (List) obj);
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.revenuecat.purchases.models.StoreProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.revenuecat.purchases.models.StoreProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.revenuecat.purchases.models.StoreProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: com.revenuecat.purchases.models.StoreProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.revenuecat.purchases.models.StoreProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: com.revenuecat.purchases.models.StoreProduct} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: com.revenuecat.purchases.models.StoreProduct} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(java.util.List<? extends com.revenuecat.purchases.models.StoreProduct> r12) {
        /*
            r11 = this;
            java.lang.String r0 = "storeProducts"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            com.revenuecat.purchases.models.StoreTransaction r0 = r11.$transaction
            com.revenuecat.purchases.ProductType r0 = r0.getType()
            com.revenuecat.purchases.ProductType r1 = com.revenuecat.purchases.ProductType.SUBS
            r2 = 0
            if (r0 != r1) goto L_0x005d
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            com.revenuecat.purchases.models.StoreTransaction r0 = r11.$transaction
            java.util.Iterator r12 = r12.iterator()
        L_0x0018:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r12.next()
            r3 = r1
            com.revenuecat.purchases.models.StoreProduct r3 = (com.revenuecat.purchases.models.StoreProduct) r3
            com.revenuecat.purchases.models.SubscriptionOptions r3 = r3.getSubscriptionOptions()
            if (r3 == 0) goto L_0x0018
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L_0x003b
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x003b
            goto L_0x0018
        L_0x003b:
            java.util.Iterator r3 = r3.iterator()
        L_0x003f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0018
            java.lang.Object r4 = r3.next()
            com.revenuecat.purchases.models.SubscriptionOption r4 = (com.revenuecat.purchases.models.SubscriptionOption) r4
            java.lang.String r4 = r4.getId()
            java.lang.String r5 = r0.getSubscriptionOptionId()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x003f
            r2 = r1
        L_0x005a:
            com.revenuecat.purchases.models.StoreProduct r2 = (com.revenuecat.purchases.models.StoreProduct) r2
            goto L_0x0087
        L_0x005d:
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            com.revenuecat.purchases.models.StoreTransaction r0 = r11.$transaction
            java.util.Iterator r12 = r12.iterator()
        L_0x0065:
            boolean r1 = r12.hasNext()
            if (r1 == 0) goto L_0x0085
            java.lang.Object r1 = r12.next()
            r3 = r1
            com.revenuecat.purchases.models.StoreProduct r3 = (com.revenuecat.purchases.models.StoreProduct) r3
            java.lang.String r3 = r3.getId()
            java.util.List r4 = r0.getProductIds()
            java.lang.Object r4 = kotlin.collections.CollectionsKt.firstOrNull(r4)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x0065
            r2 = r1
        L_0x0085:
            com.revenuecat.purchases.models.StoreProduct r2 = (com.revenuecat.purchases.models.StoreProduct) r2
        L_0x0087:
            r5 = r2
            com.revenuecat.purchases.PostTransactionWithProductDetailsHelper r12 = r11.this$0
            com.revenuecat.purchases.PostReceiptHelper r3 = r12.postReceiptHelper
            com.revenuecat.purchases.models.StoreTransaction r4 = r11.$transaction
            boolean r6 = r11.$allowSharingPlayStoreAccount
            java.lang.String r7 = r11.$appUserID
            com.revenuecat.purchases.PostReceiptInitiationSource r8 = r11.$initiationSource
            kotlin.jvm.functions.Function2<com.revenuecat.purchases.models.StoreTransaction, com.revenuecat.purchases.CustomerInfo, kotlin.Unit> r9 = r11.$transactionPostSuccess
            kotlin.jvm.functions.Function2<com.revenuecat.purchases.models.StoreTransaction, com.revenuecat.purchases.PurchasesError, kotlin.Unit> r10 = r11.$transactionPostError
            r3.postTransactionAndConsumeIfNeeded(r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.PostTransactionWithProductDetailsHelper$postTransactions$1$1.invoke(java.util.List):void");
    }
}
