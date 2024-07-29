package com.revenuecat.purchases.google.usecase;

import com.revenuecat.purchases.PostReceiptInitiationSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/AcknowledgePurchaseUseCaseParams;", "Lcom/revenuecat/purchases/google/usecase/UseCaseParams;", "purchaseToken", "", "initiationSource", "Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "appInBackground", "", "(Ljava/lang/String;Lcom/revenuecat/purchases/PostReceiptInitiationSource;Z)V", "getAppInBackground", "()Z", "getInitiationSource", "()Lcom/revenuecat/purchases/PostReceiptInitiationSource;", "getPurchaseToken", "()Ljava/lang/String;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AcknowledgePurchaseUseCase.kt */
public final class AcknowledgePurchaseUseCaseParams implements UseCaseParams {
    private final boolean appInBackground;
    private final PostReceiptInitiationSource initiationSource;
    private final String purchaseToken;

    public boolean getAppInBackground() {
        return this.appInBackground;
    }

    public final PostReceiptInitiationSource getInitiationSource() {
        return this.initiationSource;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public AcknowledgePurchaseUseCaseParams(String str, PostReceiptInitiationSource postReceiptInitiationSource, boolean z) {
        Intrinsics.checkNotNullParameter(str, "purchaseToken");
        Intrinsics.checkNotNullParameter(postReceiptInitiationSource, "initiationSource");
        this.purchaseToken = str;
        this.initiationSource = postReceiptInitiationSource;
        this.appInBackground = z;
    }
}
