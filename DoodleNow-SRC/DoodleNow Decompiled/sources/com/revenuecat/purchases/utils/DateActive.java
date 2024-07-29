package com.revenuecat.purchases.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/revenuecat/purchases/utils/DateActive;", "", "isActive", "", "inGracePeriod", "(ZZ)V", "getInGracePeriod", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DateHelper.kt */
public final class DateActive {
    private final boolean inGracePeriod;
    private final boolean isActive;

    public static /* synthetic */ DateActive copy$default(DateActive dateActive, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = dateActive.isActive;
        }
        if ((i & 2) != 0) {
            z2 = dateActive.inGracePeriod;
        }
        return dateActive.copy(z, z2);
    }

    public final boolean component1() {
        return this.isActive;
    }

    public final boolean component2() {
        return this.inGracePeriod;
    }

    public final DateActive copy(boolean z, boolean z2) {
        return new DateActive(z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DateActive)) {
            return false;
        }
        DateActive dateActive = (DateActive) obj;
        return this.isActive == dateActive.isActive && this.inGracePeriod == dateActive.inGracePeriod;
    }

    public final boolean getInGracePeriod() {
        return this.inGracePeriod;
    }

    public int hashCode() {
        boolean z = this.isActive;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.inGracePeriod;
        if (!z3) {
            z2 = z3;
        }
        return i + (z2 ? 1 : 0);
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public String toString() {
        return "DateActive(isActive=" + this.isActive + ", inGracePeriod=" + this.inGracePeriod + ')';
    }

    public DateActive(boolean z, boolean z2) {
        this.isActive = z;
        this.inGracePeriod = z2;
    }
}
