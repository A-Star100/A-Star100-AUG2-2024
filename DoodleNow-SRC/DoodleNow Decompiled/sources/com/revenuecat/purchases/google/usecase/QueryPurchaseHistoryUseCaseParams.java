package com.revenuecat.purchases.google.usecase;

import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/QueryPurchaseHistoryUseCaseParams;", "Lcom/revenuecat/purchases/google/usecase/UseCaseParams;", "dateProvider", "Lcom/revenuecat/purchases/common/DateProvider;", "diagnosticsTrackerIfEnabled", "Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "productType", "", "appInBackground", "", "(Lcom/revenuecat/purchases/common/DateProvider;Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;Ljava/lang/String;Z)V", "getAppInBackground", "()Z", "getDateProvider", "()Lcom/revenuecat/purchases/common/DateProvider;", "getDiagnosticsTrackerIfEnabled", "()Lcom/revenuecat/purchases/common/diagnostics/DiagnosticsTracker;", "getProductType", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: QueryPurchaseHistoryUseCase.kt */
public final class QueryPurchaseHistoryUseCaseParams implements UseCaseParams {
    private final boolean appInBackground;
    private final DateProvider dateProvider;
    private final DiagnosticsTracker diagnosticsTrackerIfEnabled;
    private final String productType;

    public static /* synthetic */ QueryPurchaseHistoryUseCaseParams copy$default(QueryPurchaseHistoryUseCaseParams queryPurchaseHistoryUseCaseParams, DateProvider dateProvider2, DiagnosticsTracker diagnosticsTracker, String str, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            dateProvider2 = queryPurchaseHistoryUseCaseParams.dateProvider;
        }
        if ((i & 2) != 0) {
            diagnosticsTracker = queryPurchaseHistoryUseCaseParams.diagnosticsTrackerIfEnabled;
        }
        if ((i & 4) != 0) {
            str = queryPurchaseHistoryUseCaseParams.productType;
        }
        if ((i & 8) != 0) {
            z = queryPurchaseHistoryUseCaseParams.getAppInBackground();
        }
        return queryPurchaseHistoryUseCaseParams.copy(dateProvider2, diagnosticsTracker, str, z);
    }

    public final DateProvider component1() {
        return this.dateProvider;
    }

    public final DiagnosticsTracker component2() {
        return this.diagnosticsTrackerIfEnabled;
    }

    public final String component3() {
        return this.productType;
    }

    public final boolean component4() {
        return getAppInBackground();
    }

    public final QueryPurchaseHistoryUseCaseParams copy(DateProvider dateProvider2, DiagnosticsTracker diagnosticsTracker, String str, boolean z) {
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        Intrinsics.checkNotNullParameter(str, "productType");
        return new QueryPurchaseHistoryUseCaseParams(dateProvider2, diagnosticsTracker, str, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QueryPurchaseHistoryUseCaseParams)) {
            return false;
        }
        QueryPurchaseHistoryUseCaseParams queryPurchaseHistoryUseCaseParams = (QueryPurchaseHistoryUseCaseParams) obj;
        return Intrinsics.areEqual((Object) this.dateProvider, (Object) queryPurchaseHistoryUseCaseParams.dateProvider) && Intrinsics.areEqual((Object) this.diagnosticsTrackerIfEnabled, (Object) queryPurchaseHistoryUseCaseParams.diagnosticsTrackerIfEnabled) && Intrinsics.areEqual((Object) this.productType, (Object) queryPurchaseHistoryUseCaseParams.productType) && getAppInBackground() == queryPurchaseHistoryUseCaseParams.getAppInBackground();
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

    public final String getProductType() {
        return this.productType;
    }

    public int hashCode() {
        int hashCode = this.dateProvider.hashCode() * 31;
        DiagnosticsTracker diagnosticsTracker = this.diagnosticsTrackerIfEnabled;
        int hashCode2 = (((hashCode + (diagnosticsTracker == null ? 0 : diagnosticsTracker.hashCode())) * 31) + this.productType.hashCode()) * 31;
        boolean appInBackground2 = getAppInBackground();
        if (appInBackground2) {
            appInBackground2 = true;
        }
        return hashCode2 + (appInBackground2 ? 1 : 0);
    }

    public String toString() {
        return "QueryPurchaseHistoryUseCaseParams(dateProvider=" + this.dateProvider + ", diagnosticsTrackerIfEnabled=" + this.diagnosticsTrackerIfEnabled + ", productType=" + this.productType + ", appInBackground=" + getAppInBackground() + ')';
    }

    public QueryPurchaseHistoryUseCaseParams(DateProvider dateProvider2, DiagnosticsTracker diagnosticsTracker, String str, boolean z) {
        Intrinsics.checkNotNullParameter(dateProvider2, "dateProvider");
        Intrinsics.checkNotNullParameter(str, "productType");
        this.dateProvider = dateProvider2;
        this.diagnosticsTrackerIfEnabled = diagnosticsTracker;
        this.productType = str;
        this.appInBackground = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueryPurchaseHistoryUseCaseParams(DateProvider dateProvider2, DiagnosticsTracker diagnosticsTracker, String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new DefaultDateProvider() : dateProvider2, diagnosticsTracker, str, z);
    }
}
