package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u001a\u001d\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a\u0015\u0010\r\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"awaitCustomerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "Lcom/revenuecat/purchases/Purchases;", "fetchPolicy", "Lcom/revenuecat/purchases/CacheFetchPolicy;", "(Lcom/revenuecat/purchases/Purchases;Lcom/revenuecat/purchases/CacheFetchPolicy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLogIn", "Lcom/revenuecat/purchases/data/LogInResult;", "appUserID", "", "(Lcom/revenuecat/purchases/Purchases;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitLogOut", "(Lcom/revenuecat/purchases/Purchases;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSyncPurchases", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: coroutinesExtensions.kt */
public final class CoroutinesExtensionsKt {
    public static /* synthetic */ Object awaitCustomerInfo$default(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Continuation continuation, int i, Object obj) throws PurchasesException {
        if ((i & 1) != 0) {
            cacheFetchPolicy = CacheFetchPolicy.Companion.m1086default();
        }
        return awaitCustomerInfo(purchases, cacheFetchPolicy, continuation);
    }

    public static final /* synthetic */ Object awaitCustomerInfo(Purchases purchases, CacheFetchPolicy cacheFetchPolicy, Continuation continuation) throws PurchasesException {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation continuation2 = safeContinuation;
        ListenerConversionsKt.getCustomerInfoWith(purchases, cacheFetchPolicy, new CoroutinesExtensionsKt$awaitCustomerInfo$2$2(continuation2), new CoroutinesExtensionsKt$awaitCustomerInfo$2$1(continuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final /* synthetic */ Object awaitLogIn(Purchases purchases, String str, Continuation continuation) throws PurchasesTransactionException {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation continuation2 = safeContinuation;
        ListenerConversionsKt.logInWith(purchases, str, new CoroutinesExtensionsKt$awaitLogIn$2$1(continuation2), new CoroutinesExtensionsKt$awaitLogIn$2$2(continuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final /* synthetic */ Object awaitLogOut(Purchases purchases, Continuation continuation) throws PurchasesTransactionException {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation continuation2 = safeContinuation;
        ListenerConversionsKt.logOutWith(purchases, new CoroutinesExtensionsKt$awaitLogOut$2$1(continuation2), new CoroutinesExtensionsKt$awaitLogOut$2$2(continuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    public static final /* synthetic */ Object awaitSyncPurchases(Purchases purchases, Continuation continuation) throws PurchasesException {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Continuation continuation2 = safeContinuation;
        ListenerConversionsKt.syncPurchasesWith(purchases, new CoroutinesExtensionsKt$awaitSyncPurchases$2$2(continuation2), new CoroutinesExtensionsKt$awaitSyncPurchases$2$1(continuation2));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }
}
