package com.revenuecat.purchases;

import com.facebook.hermes.intl.Constants;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0015\u0010/\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u000bHÆ\u0003JO\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0012\u00106\u001a\u0004\u0018\u00010\t2\u0006\u00107\u001a\u000208H\u0002J\u0011\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\u0003H\u0002J\u0016\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u0003J\u000e\u0010>\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\r\u001a\u0004\u0018\u00010\t8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\t8FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0011\u001a\u0004\b\u0017\u0010\u000fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u0004\u0018\u00010\t8FX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001c\u0010\u000fR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u001d\u0010!\u001a\u0004\u0018\u00010\t8FX\u0002¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b\"\u0010\u000fR\u001d\u0010$\u001a\u0004\u0018\u00010\t8FX\u0002¢\u0006\f\n\u0004\b&\u0010\u0011\u001a\u0004\b%\u0010\u000fR\u001d\u0010'\u001a\u0004\u0018\u00010\t8FX\u0002¢\u0006\f\n\u0004\b)\u0010\u0011\u001a\u0004\b(\u0010\u000fR\u001d\u0010*\u001a\u0004\u0018\u00010\t8FX\u0002¢\u0006\f\n\u0004\b,\u0010\u0011\u001a\u0004\b+\u0010\u000f¨\u0006B"}, d2 = {"Lcom/revenuecat/purchases/Offering;", "", "identifier", "", "serverDescription", "metadata", "", "availablePackages", "", "Lcom/revenuecat/purchases/Package;", "paywall", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lcom/revenuecat/purchases/paywalls/PaywallData;)V", "annual", "getAnnual", "()Lcom/revenuecat/purchases/Package;", "annual$delegate", "Lkotlin/Lazy;", "getAvailablePackages", "()Ljava/util/List;", "getIdentifier", "()Ljava/lang/String;", "lifetime", "getLifetime", "lifetime$delegate", "getMetadata", "()Ljava/util/Map;", "monthly", "getMonthly", "monthly$delegate", "getPaywall", "()Lcom/revenuecat/purchases/paywalls/PaywallData;", "getServerDescription", "sixMonth", "getSixMonth", "sixMonth$delegate", "threeMonth", "getThreeMonth", "threeMonth$delegate", "twoMonth", "getTwoMonth", "twoMonth$delegate", "weekly", "getWeekly", "weekly$delegate", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "findPackage", "packageType", "Lcom/revenuecat/purchases/PackageType;", "get", "s", "getMetadataString", "key", "default", "getPackage", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Offering.kt */
public final class Offering {
    private final Lazy annual$delegate;
    private final List<Package> availablePackages;
    private final String identifier;
    private final Lazy lifetime$delegate;
    private final Map<String, Object> metadata;
    private final Lazy monthly$delegate;
    private final PaywallData paywall;
    private final String serverDescription;
    private final Lazy sixMonth$delegate;
    private final Lazy threeMonth$delegate;
    private final Lazy twoMonth$delegate;
    private final Lazy weekly$delegate;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Offering(String str, String str2, Map<String, ? extends Object> map, List<Package> list) {
        this(str, str2, map, list, (PaywallData) null, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(str2, "serverDescription");
        Intrinsics.checkNotNullParameter(map, TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullParameter(list, "availablePackages");
    }

    public static /* synthetic */ Offering copy$default(Offering offering, String str, String str2, Map<String, Object> map, List<Package> list, PaywallData paywallData, int i, Object obj) {
        if ((i & 1) != 0) {
            str = offering.identifier;
        }
        if ((i & 2) != 0) {
            str2 = offering.serverDescription;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            map = offering.metadata;
        }
        Map<String, Object> map2 = map;
        if ((i & 8) != 0) {
            list = offering.availablePackages;
        }
        List<Package> list2 = list;
        if ((i & 16) != 0) {
            paywallData = offering.paywall;
        }
        return offering.copy(str, str3, map2, list2, paywallData);
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component2() {
        return this.serverDescription;
    }

    public final Map<String, Object> component3() {
        return this.metadata;
    }

    public final List<Package> component4() {
        return this.availablePackages;
    }

    public final PaywallData component5() {
        return this.paywall;
    }

    public final Offering copy(String str, String str2, Map<String, ? extends Object> map, List<Package> list, PaywallData paywallData) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(str2, "serverDescription");
        Intrinsics.checkNotNullParameter(map, TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullParameter(list, "availablePackages");
        return new Offering(str, str2, map, list, paywallData);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Offering)) {
            return false;
        }
        Offering offering = (Offering) obj;
        return Intrinsics.areEqual((Object) this.identifier, (Object) offering.identifier) && Intrinsics.areEqual((Object) this.serverDescription, (Object) offering.serverDescription) && Intrinsics.areEqual((Object) this.metadata, (Object) offering.metadata) && Intrinsics.areEqual((Object) this.availablePackages, (Object) offering.availablePackages) && Intrinsics.areEqual((Object) this.paywall, (Object) offering.paywall);
    }

    public final List<Package> getAvailablePackages() {
        return this.availablePackages;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final PaywallData getPaywall() {
        return this.paywall;
    }

    public final String getServerDescription() {
        return this.serverDescription;
    }

    public int hashCode() {
        int hashCode = ((((((this.identifier.hashCode() * 31) + this.serverDescription.hashCode()) * 31) + this.metadata.hashCode()) * 31) + this.availablePackages.hashCode()) * 31;
        PaywallData paywallData = this.paywall;
        return hashCode + (paywallData == null ? 0 : paywallData.hashCode());
    }

    public String toString() {
        return "Offering(identifier=" + this.identifier + ", serverDescription=" + this.serverDescription + ", metadata=" + this.metadata + ", availablePackages=" + this.availablePackages + ", paywall=" + this.paywall + ')';
    }

    public Offering(String str, String str2, Map<String, ? extends Object> map, List<Package> list, PaywallData paywallData) {
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(str2, "serverDescription");
        Intrinsics.checkNotNullParameter(map, TtmlNode.TAG_METADATA);
        Intrinsics.checkNotNullParameter(list, "availablePackages");
        this.identifier = str;
        this.serverDescription = str2;
        this.metadata = map;
        this.availablePackages = list;
        this.paywall = paywallData;
        this.lifetime$delegate = LazyKt.lazy(new Offering$lifetime$2(this));
        this.annual$delegate = LazyKt.lazy(new Offering$annual$2(this));
        this.sixMonth$delegate = LazyKt.lazy(new Offering$sixMonth$2(this));
        this.threeMonth$delegate = LazyKt.lazy(new Offering$threeMonth$2(this));
        this.twoMonth$delegate = LazyKt.lazy(new Offering$twoMonth$2(this));
        this.monthly$delegate = LazyKt.lazy(new Offering$monthly$2(this));
        this.weekly$delegate = LazyKt.lazy(new Offering$weekly$2(this));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Offering(String str, String str2, Map map, List list, PaywallData paywallData, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, map, list, (i & 16) != 0 ? null : paywallData);
    }

    public final Package getLifetime() {
        return (Package) this.lifetime$delegate.getValue();
    }

    public final Package getAnnual() {
        return (Package) this.annual$delegate.getValue();
    }

    public final Package getSixMonth() {
        return (Package) this.sixMonth$delegate.getValue();
    }

    public final Package getThreeMonth() {
        return (Package) this.threeMonth$delegate.getValue();
    }

    public final Package getTwoMonth() {
        return (Package) this.twoMonth$delegate.getValue();
    }

    public final Package getMonthly() {
        return (Package) this.monthly$delegate.getValue();
    }

    public final Package getWeekly() {
        return (Package) this.weekly$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Package findPackage(PackageType packageType) {
        Object obj;
        Iterator it = this.availablePackages.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((Package) obj).getIdentifier(), (Object) packageType.getIdentifier())) {
                break;
            }
        }
        return (Package) obj;
    }

    public final Package get(String str) {
        Intrinsics.checkNotNullParameter(str, "s");
        return getPackage(str);
    }

    public final Package getPackage(String str) throws NoSuchElementException {
        Intrinsics.checkNotNullParameter(str, "identifier");
        for (Package packageR : this.availablePackages) {
            if (Intrinsics.areEqual((Object) packageR.getIdentifier(), (Object) str)) {
                return packageR;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final String getMetadataString(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, SubscriberAttributeKt.JSON_NAME_KEY);
        Intrinsics.checkNotNullParameter(str2, Constants.COLLATION_DEFAULT);
        Object obj = this.metadata.get(str);
        String str3 = obj instanceof String ? (String) obj : null;
        return str3 == null ? str2 : str3;
    }
}
