package com.revenuecat.purchases.google.usecase;

import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\fHÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\bHÖ\u0001R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/QueryProductDetailsUseCaseParams;", "Lcom/revenuecat/purchases/google/usecase/UseCaseParams;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "productIds", "", "", "productType", "Lcom/revenuecat/purchases/ProductType;", "appInBackground", "", "(Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Ljava/util/Set;Lcom/revenuecat/purchases/ProductType;Z)V", "getAppInBackground", "()Z", "getDateProvider", "()Lcom/revenuecat/purchases/common/DateProvider;", "getDiagnosticsTrackerIfEnabled", "()Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "getProductIds", "()Ljava/util/Set;", "getProductType", "()Lcom/revenuecat/purchases/ProductType;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: QueryProductDetailsUseCase.kt */
public final class QueryProductDetailsUseCaseParams implements UseCaseParams {
    private final boolean appInBackground;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final Set<String> productIds;
    private final ProductType productType;

    public static /* synthetic */ QueryProductDetailsUseCaseParams copy$default(QueryProductDetailsUseCaseParams queryProductDetailsUseCaseParams, DateProvider dateProvider2, DiagnosticsTracker diagnosticsTracker, Set<String> set, ProductType productType2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dateProvider2 = queryProductDetailsUseCaseParams.dateProvider;
        }
        if ((i & 2) != 0) {
            diagnosticsTracker = queryProductDetailsUseCaseParams.diagnosticsTrackerIfEnabled;
        }
        DiagnosticsTracker diagnosticsTracker2 = diagnosticsTracker;
        if ((i & 4) != 0) {
            set = queryProductDetailsUseCaseParams.productIds;
        }
        Set<String> set2 = set;
        if ((i & 8) != 0) {
            productType2 = queryProductDetailsUseCaseParams.productType;
        }
        ProductType productType3 = productType2;
        if ((i & 16) != 0) {
            z = queryProductDetailsUseCaseParams.getAppInBackground();
        }
        return queryProductDetailsUseCaseParams.copy(dateProvider2, diagnosticsTracker2, set2, productType3, z);
    }

    public final DateProvider component1() {
        return this.dateProvider;
    }

    public final DiagnosticsTracker component2() {
        return this.diagnosticsTrackerIfEnabled;
    }

    public final Set<String> component3() {
        return this.productIds;
    }

    public final ProductType component4() {
        return this.productType;
    }

    public final boolean component5() {
        return getAppInBackground();
    }

    public final QueryProductDetailsUseCaseParams copy(DateProvider dateProvider2, DiagnosticsTracker diagnosticsTracker, Set<String> set, ProductType productType2, boolean z) {
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        Intrinsics.checkNotNullParameter(set, "productIds");
        Intrinsics.checkNotNullParameter(productType2, "productType");
        return new QueryProductDetailsUseCaseParams(dateProvider2, diagnosticsTracker, set, productType2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryProductDetailsUseCaseParams)) {
            return false;
        }
        QueryProductDetailsUseCaseParams queryProductDetailsUseCaseParams = (QueryProductDetailsUseCaseParams) obj;
        return Intrinsics.areEqual((Object) this.dateProvider, (Object) queryProductDetailsUseCaseParams.dateProvider) && Intrinsics.areEqual((Object) this.diagnosticsTrackerIfEnabled, (Object) queryProductDetailsUseCaseParams.diagnosticsTrackerIfEnabled) && Intrinsics.areEqual((Object) this.productIds, (Object) queryProductDetailsUseCaseParams.productIds) && this.productType == queryProductDetailsUseCaseParams.productType && getAppInBackground() == queryProductDetailsUseCaseParams.getAppInBackground();
    }

    public boolean getAppInBackground() {
        return this.appInBackground;
    }

    public final DateProvider getDateProvider() {
        return this.dateProvider;
    }

    public final DiagnosticsTracker getDiagnosticsTrackerIfEnabled() {
        return this.diagnosticsTrackerIfEnabled;
    }

    public final Set<String> getProductIds() {
        return this.productIds;
    }

    public final ProductType getProductType() {
        return this.productType;
    }

    public int hashCode() {
        int hashCode = this.dateProvider.hashCode() * 31;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        int hashCode2 = (((((hashCode + (diagnosticsTracker == null ? 0 : diagnosticsTracker.hashCode())) * 31) + this.productIds.hashCode()) * 31) + this.productType.hashCode()) * 31;
        boolean appInBackground2 = getAppInBackground();
        if (appInBackground2) {
            appInBackground2 = true;
        }
        return hashCode2 + (appInBackground2 ? 1 : 0);
    }

    public String toString() {
        return "QueryProductDetailsUseCaseParams(dateProvider=" + this.dateProvider + ", diagnosticsTrackerIfEnabled=" + this.diagnosticsTrackerIfEnabled + ", productIds=" + this.productIds + ", productType=" + this.productType + ", appInBackground=" + getAppInBackground() + ')';
    }

    public QueryProductDetailsUseCaseParams(DateProvider dateProvider2, DiagnosticsTracker diagnosticsTracker, Set<String> set, ProductType productType2, boolean z) {
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        Intrinsics.checkNotNullParameter(set, "productIds");
        Intrinsics.checkNotNullParameter(productType2, "productType");
        this.dateProvider = dateProvider2;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.productIds = set;
        this.productType = productType2;
        this.appInBackground = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueryProductDetailsUseCaseParams(DateProvider dateProvider2, DiagnosticsTracker diagnosticsTracker, Set set, ProductType productType2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultDateProvider() : dateProvider2, diagnosticsTracker, set, productType2, z);
    }
}
