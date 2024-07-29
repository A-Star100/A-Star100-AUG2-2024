package com.revenuecat.purchases;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/PurchasesException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "error", "Lcom/revenuecat/purchases/PurchasesError;", "(Lcom/revenuecat/purchases/PurchasesError;)V", "code", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "getCode", "()Lcom/revenuecat/purchases/PurchasesErrorCode;", "getError", "()Lcom/revenuecat/purchases/PurchasesError;", "message", "", "getMessage", "()Ljava/lang/String;", "underlyingErrorMessage", "getUnderlyingErrorMessage", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesException.kt */
public class PurchasesException extends Exception {
    private final PurchasesError error;

    public final PurchasesError getError() {
        return this.error;
    }

    public PurchasesException(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        this.error = purchasesError;
    }

    public final PurchasesErrorCode getCode() {
        return this.error.getCode();
    }

    public final String getUnderlyingErrorMessage() {
        return this.error.getUnderlyingErrorMessage();
    }

    public String getMessage() {
        return this.error.getMessage();
    }
}
