package com.revenuecat.purchases.amazon;

import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.amazon.listener.PurchaseUpdatesResponseListener;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "connectionError", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBilling.kt */
final class AmazonBilling$queryPurchases$1 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ boolean $filterOnlyActivePurchases;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<Map<String, StoreTransaction>, Unit> $onSuccess;
    final /* synthetic */ AmazonBilling this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmazonBilling$queryPurchases$1(AmazonBilling amazonBilling, Function1<? super PurchasesError, Unit> function1, boolean z, Function1<? super Map<String, StoreTransaction>, Unit> function12) {
        super(1);
        this.this$0 = amazonBilling;
        this.$onError = function1;
        this.$filterOnlyActivePurchases = z;
        this.$onSuccess = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        if (purchasesError == null) {
            PurchaseUpdatesResponseListener access$getPurchaseUpdatesHandler$p = this.this$0.purchaseUpdatesHandler;
            final boolean z = this.$filterOnlyActivePurchases;
            final Function1<Map<String, StoreTransaction>, Unit> function1 = this.$onSuccess;
            final AmazonBilling amazonBilling = this.this$0;
            final Function1<PurchasesError, Unit> function12 = this.$onError;
            access$getPurchaseUpdatesHandler$p.queryPurchases(new Function2<List<? extends Receipt>, UserData, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((List<Receipt>) (List) obj, (UserData) obj2);
                    return Unit.INSTANCE;
                }

                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.util.Collection} */
                /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: java.util.List<com.amazon.device.iap.model.Receipt>} */
                /* JADX WARNING: Multi-variable type inference failed */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void invoke(java.util.List<com.amazon.device.iap.model.Receipt> r10, com.amazon.device.iap.model.UserData r11) {
                    /*
                        r9 = this;
                        java.lang.String r0 = "receipts"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
                        java.lang.String r0 = "userData"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
                        boolean r0 = r1
                        if (r0 == 0) goto L_0x0049
                        java.lang.Iterable r10 = (java.lang.Iterable) r10
                        com.revenuecat.purchases.amazon.AmazonBilling r0 = r3
                        java.util.ArrayList r1 = new java.util.ArrayList
                        r1.<init>()
                        java.util.Collection r1 = (java.util.Collection) r1
                        java.util.Iterator r10 = r10.iterator()
                    L_0x001d:
                        boolean r2 = r10.hasNext()
                        if (r2 == 0) goto L_0x0046
                        java.lang.Object r2 = r10.next()
                        r3 = r2
                        com.amazon.device.iap.model.Receipt r3 = (com.amazon.device.iap.model.Receipt) r3
                        java.util.Date r4 = r3.getCancelDate()
                        if (r4 == 0) goto L_0x0042
                        java.util.Date r3 = r3.getCancelDate()
                        com.revenuecat.purchases.common.DateProvider r4 = r0.dateProvider
                        java.util.Date r4 = r4.getNow()
                        int r3 = r3.compareTo(r4)
                        if (r3 <= 0) goto L_0x001d
                    L_0x0042:
                        r1.add(r2)
                        goto L_0x001d
                    L_0x0046:
                        r10 = r1
                        java.util.List r10 = (java.util.List) r10
                    L_0x0049:
                        boolean r0 = r10.isEmpty()
                        if (r0 == 0) goto L_0x0059
                        kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, com.revenuecat.purchases.models.StoreTransaction>, kotlin.Unit> r10 = r2
                        java.util.Map r11 = kotlin.collections.MapsKt.emptyMap()
                        r10.invoke(r11)
                        return
                    L_0x0059:
                        com.revenuecat.purchases.amazon.AmazonBilling r6 = r3
                        java.lang.String r7 = r11.getUserId()
                        java.lang.String r0 = "userData.userId"
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
                        com.revenuecat.purchases.amazon.AmazonBilling$queryPurchases$1$1$1 r8 = new com.revenuecat.purchases.amazon.AmazonBilling$queryPurchases$1$1$1
                        com.revenuecat.purchases.amazon.AmazonBilling r1 = r3
                        kotlin.jvm.functions.Function1<com.revenuecat.purchases.PurchasesError, kotlin.Unit> r2 = r4
                        kotlin.jvm.functions.Function1<java.util.Map<java.lang.String, com.revenuecat.purchases.models.StoreTransaction>, kotlin.Unit> r5 = r2
                        r0 = r8
                        r3 = r10
                        r4 = r11
                        r0.<init>(r1, r2, r3, r4, r5)
                        kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8
                        r6.getMissingSkusForReceipts(r7, r10, r8)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.AmazonBilling$queryPurchases$1.AnonymousClass1.invoke(java.util.List, com.amazon.device.iap.model.UserData):void");
                }
            }, this.$onError);
            return;
        }
        this.$onError.invoke(purchasesError);
    }
}
