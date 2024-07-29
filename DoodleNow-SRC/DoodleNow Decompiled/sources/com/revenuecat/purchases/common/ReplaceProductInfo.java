package com.revenuecat.purchases.common;

import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/revenuecat/purchases/common/ReplaceProductInfo;", "", "oldPurchase", "Lcom/revenuecat/purchases/models/StoreTransaction;", "replacementMode", "Lcom/revenuecat/purchases/ReplacementMode;", "(Lcom/revenuecat/purchases/models/StoreTransaction;Lcom/revenuecat/purchases/ReplacementMode;)V", "getOldPurchase", "()Lcom/revenuecat/purchases/models/StoreTransaction;", "getReplacementMode", "()Lcom/revenuecat/purchases/ReplacementMode;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReplaceProductInfo.kt */
public final class ReplaceProductInfo {
    private final StoreTransaction oldPurchase;
    private final ReplacementMode replacementMode;

    public static /* synthetic */ ReplaceProductInfo copy$default(ReplaceProductInfo replaceProductInfo, StoreTransaction storeTransaction, ReplacementMode replacementMode2, int i, Object obj) {
        if ((i & 1) != 0) {
            storeTransaction = replaceProductInfo.oldPurchase;
        }
        if ((i & 2) != 0) {
            replacementMode2 = replaceProductInfo.replacementMode;
        }
        return replaceProductInfo.copy(storeTransaction, replacementMode2);
    }

    public final StoreTransaction component1() {
        return this.oldPurchase;
    }

    public final ReplacementMode component2() {
        return this.replacementMode;
    }

    public final ReplaceProductInfo copy(StoreTransaction storeTransaction, ReplacementMode replacementMode2) {
        Intrinsics.checkNotNullParameter(storeTransaction, "oldPurchase");
        return new ReplaceProductInfo(storeTransaction, replacementMode2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReplaceProductInfo)) {
            return false;
        }
        ReplaceProductInfo replaceProductInfo = (ReplaceProductInfo) obj;
        return Intrinsics.areEqual((Object) this.oldPurchase, (Object) replaceProductInfo.oldPurchase) && Intrinsics.areEqual((Object) this.replacementMode, (Object) replaceProductInfo.replacementMode);
    }

    public final StoreTransaction getOldPurchase() {
        return this.oldPurchase;
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public int hashCode() {
        int hashCode = this.oldPurchase.hashCode() * 31;
        ReplacementMode replacementMode2 = this.replacementMode;
        return hashCode + (replacementMode2 == null ? 0 : replacementMode2.hashCode());
    }

    public String toString() {
        return "ReplaceProductInfo(oldPurchase=" + this.oldPurchase + ", replacementMode=" + this.replacementMode + ')';
    }

    public ReplaceProductInfo(StoreTransaction storeTransaction, ReplacementMode replacementMode2) {
        Intrinsics.checkNotNullParameter(storeTransaction, "oldPurchase");
        this.oldPurchase = storeTransaction;
        this.replacementMode = replacementMode2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReplaceProductInfo(StoreTransaction storeTransaction, ReplacementMode replacementMode2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeTransaction, (i & 2) != 0 ? null : replacementMode2);
    }
}
