package com.revenuecat.purchases;

import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a5\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\n*\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u001d\u0010\f\u001a\u00020\r*\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00020\u0012*\u00020\u0003H@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"awaitGetProducts", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "Lcom/revenuecat/purchases/Purchases;", "productIds", "", "type", "Lcom/revenuecat/purchases/ProductType;", "(Lcom/revenuecat/purchases/Purchases;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitOfferings", "Lcom/revenuecat/purchases/Offerings;", "(Lcom/revenuecat/purchases/Purchases;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitPurchase", "Lcom/revenuecat/purchases/PurchaseResult;", "purchaseParams", "Lcom/revenuecat/purchases/PurchaseParams;", "(Lcom/revenuecat/purchases/Purchases;Lcom/revenuecat/purchases/PurchaseParams;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitRestore", "Lcom/revenuecat/purchases/CustomerInfo;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoroutinesExtensionsCommon.kt */
public final class CoroutinesExtensionsCommonKt {
    public static final /* synthetic */ Object awaitOfferings(Purchases purchases, Continuation continuation) throws PurchasesException {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation continuation2 = safeContinuation;
        ListenerConversionsCommonKt.getOfferingsWith(purchases, new CoroutinesExtensionsCommonKt$awaitOfferings$2$2(continuation2), new CoroutinesExtensionsCommonKt$awaitOfferings$2$1(continuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final /* synthetic */ Object awaitPurchase(Purchases purchases, PurchaseParams purchaseParams, Continuation continuation) throws PurchasesTransactionException {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation continuation2 = safeContinuation;
        purchases.purchase(purchaseParams, ListenerConversionsCommonKt.purchaseCompletedCallback(new CoroutinesExtensionsCommonKt$awaitPurchase$2$1(continuation2), new CoroutinesExtensionsCommonKt$awaitPurchase$2$2(continuation2)));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static /* synthetic */ Object awaitGetProducts$default(Purchases purchases, List list, ProductType productType, Continuation continuation, int i, Object obj) throws PurchasesTransactionException {
        if ((i & 2) != 0) {
            productType = null;
        }
        return awaitGetProducts(purchases, list, productType, continuation);
    }

    public static final /* synthetic */ Object awaitGetProducts(Purchases purchases, List list, ProductType productType, Continuation continuation) throws PurchasesTransactionException {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation continuation2 = safeContinuation;
        ListenerConversionsCommonKt.getProductsWith(purchases, list, productType, new CoroutinesExtensionsCommonKt$awaitGetProducts$2$2(continuation2), new CoroutinesExtensionsCommonKt$awaitGetProducts$2$1(continuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final /* synthetic */ Object awaitRestore(Purchases purchases, Continuation continuation) throws PurchasesTransactionException {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation continuation2 = safeContinuation;
        ListenerConversionsCommonKt.restorePurchasesWith(purchases, new CoroutinesExtensionsCommonKt$awaitRestore$2$1(continuation2), new CoroutinesExtensionsCommonKt$awaitRestore$2$2(continuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
