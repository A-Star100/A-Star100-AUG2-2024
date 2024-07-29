package com.revenuecat.purchases;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0006H\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0006J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/revenuecat/purchases/Offerings;", "", "current", "Lcom/revenuecat/purchases/Offering;", "all", "", "", "(Lcom/revenuecat/purchases/Offering;Ljava/util/Map;)V", "getAll", "()Ljava/util/Map;", "getCurrent", "()Lcom/revenuecat/purchases/Offering;", "component1", "component2", "copy", "equals", "", "other", "get", "identifier", "getOffering", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Offerings.kt */
public final class Offerings {
    private final Map<String, Offering> all;
    private final Offering current;

    public static /* synthetic */ Offerings copy$default(Offerings offerings, Offering offering, Map<String, Offering> map, int i, Object obj) {
        if ((i & 1) != 0) {
            offering = offerings.current;
        }
        if ((i & 2) != 0) {
            map = offerings.all;
        }
        return offerings.copy(offering, map);
    }

    public final Offering component1() {
        return this.current;
    }

    public final Map<String, Offering> component2() {
        return this.all;
    }

    public final Offerings copy(Offering offering, Map<String, Offering> map) {
        Intrinsics.checkNotNullParameter(map, TtmlNode.COMBINE_ALL);
        return new Offerings(offering, map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Offerings)) {
            return false;
        }
        Offerings offerings = (Offerings) obj;
        return Intrinsics.areEqual((Object) this.current, (Object) offerings.current) && Intrinsics.areEqual((Object) this.all, (Object) offerings.all);
    }

    public final Map<String, Offering> getAll() {
        return this.all;
    }

    public final Offering getCurrent() {
        return this.current;
    }

    public int hashCode() {
        Offering offering = this.current;
        return ((offering == null ? 0 : offering.hashCode()) * 31) + this.all.hashCode();
    }

    public String toString() {
        return "Offerings(current=" + this.current + ", all=" + this.all + ')';
    }

    public Offerings(Offering offering, Map<String, Offering> map) {
        Intrinsics.checkNotNullParameter(map, TtmlNode.COMBINE_ALL);
        this.current = offering;
        this.all = map;
    }

    public final Offering getOffering(String str) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        return this.all.get(str);
    }

    public final Offering get(String str) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        return getOffering(str);
    }
}
