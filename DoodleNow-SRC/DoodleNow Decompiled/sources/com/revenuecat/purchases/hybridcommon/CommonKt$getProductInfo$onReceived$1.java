package com.revenuecat.purchases.hybridcommon;

import com.revenuecat.purchases.hybridcommon.mappers.StoreProductMapperKt;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: common.kt */
final class CommonKt$getProductInfo$onReceived$1 extends Lambda implements Function1<List<? extends StoreProduct>, Unit> {
    final /* synthetic */ OnResultList $onResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonKt$getProductInfo$onReceived$1(OnResultList onResultList) {
        super(1);
        this.$onResult = onResultList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends StoreProduct> list) {
        Intrinsics.checkNotNullParameter(list, "it");
        this.$onResult.onReceived(StoreProductMapperKt.map(list));
    }
}
