package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u000e\u0010\u000b\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\fJ\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/revenuecat/purchases/DangerousSettings;", "", "autoSyncPurchases", "", "(Z)V", "customEntitlementComputation", "(ZZ)V", "getAutoSyncPurchases", "()Z", "getCustomEntitlementComputation$purchases_defaultsRelease", "component1", "component2", "component2$purchases_defaultsRelease", "copy", "equals", "other", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DangerousSettings.kt */
public final class DangerousSettings {
    private final boolean autoSyncPurchases;
    private final boolean customEntitlementComputation;

    public DangerousSettings() {
        this(false, false, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ DangerousSettings copy$default(DangerousSettings dangerousSettings, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dangerousSettings.autoSyncPurchases;
        }
        if ((i & 2) != 0) {
            z2 = dangerousSettings.customEntitlementComputation;
        }
        return dangerousSettings.copy(z, z2);
    }

    public final boolean component1() {
        return this.autoSyncPurchases;
    }

    public final boolean component2$purchases_defaultsRelease() {
        return this.customEntitlementComputation;
    }

    public final DangerousSettings copy(boolean z, boolean z2) {
        return new DangerousSettings(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DangerousSettings)) {
            return false;
        }
        DangerousSettings dangerousSettings = (DangerousSettings) obj;
        return this.autoSyncPurchases == dangerousSettings.autoSyncPurchases && this.customEntitlementComputation == dangerousSettings.customEntitlementComputation;
    }

    public final boolean getAutoSyncPurchases() {
        return this.autoSyncPurchases;
    }

    public final boolean getCustomEntitlementComputation$purchases_defaultsRelease() {
        return this.customEntitlementComputation;
    }

    public int hashCode() {
        boolean z = this.autoSyncPurchases;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.customEntitlementComputation;
        if (!z3) {
            z2 = z3;
        }
        return i + (z2 ? 1 : 0);
    }

    public String toString() {
        return "DangerousSettings(autoSyncPurchases=" + this.autoSyncPurchases + ", customEntitlementComputation=" + this.customEntitlementComputation + ')';
    }

    public DangerousSettings(boolean z, boolean z2) {
        this.autoSyncPurchases = z;
        this.customEntitlementComputation = z2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DangerousSettings(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? false : z2);
    }

    public DangerousSettings(boolean z) {
        this(z, false);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DangerousSettings(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }
}
