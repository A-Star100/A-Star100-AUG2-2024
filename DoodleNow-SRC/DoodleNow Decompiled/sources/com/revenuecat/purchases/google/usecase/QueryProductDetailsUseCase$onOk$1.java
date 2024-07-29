package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.ProductDetails;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/android/billingclient/api/ProductDetails;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: QueryProductDetailsUseCase.kt */
final class QueryProductDetailsUseCase$onOk$1 extends Lambda implements Function1<ProductDetails, CharSequence> {
    public static final QueryProductDetailsUseCase$onOk$1 INSTANCE = new QueryProductDetailsUseCase$onOk$1();

    QueryProductDetailsUseCase$onOk$1() {
        super(1);
    }

    public final CharSequence invoke(ProductDetails productDetails) {
        Intrinsics.checkNotNullParameter(productDetails, "it");
        String productDetails2 = productDetails.toString();
        Intrinsics.checkNotNullExpressionValue(productDetails2, "it.toString()");
        return productDetails2;
    }
}
