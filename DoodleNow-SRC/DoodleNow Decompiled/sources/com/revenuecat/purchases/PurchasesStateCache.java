package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/PurchasesStateCache;", "Lcom/revenuecat/purchases/PurchasesStateProvider;", "purchasesState", "Lcom/revenuecat/purchases/PurchasesState;", "(Lcom/revenuecat/purchases/PurchasesState;)V", "getPurchasesState", "()Lcom/revenuecat/purchases/PurchasesState;", "setPurchasesState", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesStateCache.kt */
public final class PurchasesStateCache implements PurchasesStateProvider {
    private PurchasesState purchasesState;

    public static /* synthetic */ PurchasesStateCache copy$default(PurchasesStateCache purchasesStateCache, PurchasesState purchasesState2, int i, Object obj) {
        if ((i & 1) != 0) {
            purchasesState2 = purchasesStateCache.getPurchasesState();
        }
        return purchasesStateCache.copy(purchasesState2);
    }

    public final PurchasesState component1() {
        return getPurchasesState();
    }

    public final PurchasesStateCache copy(PurchasesState purchasesState2) {
        Intrinsics.checkNotNullParameter(purchasesState2, "purchasesState");
        return new PurchasesStateCache(purchasesState2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PurchasesStateCache) && Intrinsics.areEqual((Object) getPurchasesState(), (Object) ((PurchasesStateCache) obj).getPurchasesState());
    }

    public int hashCode() {
        return getPurchasesState().hashCode();
    }

    public String toString() {
        return "PurchasesStateCache(purchasesState=" + getPurchasesState() + ')';
    }

    public PurchasesStateCache(PurchasesState purchasesState2) {
        Intrinsics.checkNotNullParameter(purchasesState2, "purchasesState");
        this.purchasesState = purchasesState2;
    }

    public synchronized PurchasesState getPurchasesState() {
        return this.purchasesState;
    }

    public synchronized void setPurchasesState(PurchasesState purchasesState2) {
        Intrinsics.checkNotNullParameter(purchasesState2, "<set-?>");
        this.purchasesState = purchasesState2;
    }
}
