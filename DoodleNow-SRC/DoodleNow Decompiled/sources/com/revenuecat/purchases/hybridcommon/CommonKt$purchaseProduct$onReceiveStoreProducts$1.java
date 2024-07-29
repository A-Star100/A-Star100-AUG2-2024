package com.revenuecat.purchases.hybridcommon;

import android.app.Activity;
import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import com.revenuecat.purchases.models.GoogleProrationMode;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.GoogleStoreProductKt;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "storeProducts", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: common.kt */
final class CommonKt$purchaseProduct$onReceiveStoreProducts$1 extends Lambda implements Function1<List<? extends StoreProduct>, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $googleBasePlanId;
    final /* synthetic */ Boolean $googleIsPersonalizedPrice;
    final /* synthetic */ String $googleOldProductId;
    final /* synthetic */ GoogleProrationMode $googleProrationMode;
    final /* synthetic */ OnResult $onResult;
    final /* synthetic */ String $presentedOfferingIdentifier;
    final /* synthetic */ String $productIdentifier;
    final /* synthetic */ ProductType $productType;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonKt$purchaseProduct$onReceiveStoreProducts$1(String str, Activity activity, String str2, GoogleProrationMode googleProrationMode, Boolean bool, OnResult onResult, String str3, ProductType productType, String str4) {
        super(1);
        this.$presentedOfferingIdentifier = str;
        this.$activity = activity;
        this.$googleOldProductId = str2;
        this.$googleProrationMode = googleProrationMode;
        this.$googleIsPersonalizedPrice = bool;
        this.$onResult = onResult;
        this.$productIdentifier = str3;
        this.$productType = productType;
        this.$googleBasePlanId = str4;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends StoreProduct> list) {
        Object obj;
        Intrinsics.checkNotNullParameter(list, "storeProducts");
        String str = this.$productIdentifier;
        ProductType productType = this.$productType;
        String str2 = this.$googleBasePlanId;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            StoreProduct storeProduct = (StoreProduct) obj;
            boolean z = false;
            boolean z2 = Intrinsics.areEqual((Object) storeProduct.getId(), (Object) str) && storeProduct.getType() == productType;
            if (Intrinsics.areEqual((Object) storeProduct.getPurchasingData().getProductId(), (Object) str)) {
                GoogleStoreProduct googleProduct = GoogleStoreProductKt.getGoogleProduct(storeProduct);
                if (Intrinsics.areEqual((Object) googleProduct != null ? googleProduct.getBasePlanId() : null, (Object) str2) && storeProduct.getType() == productType) {
                    z = true;
                }
            }
            if (!z2) {
                if (z) {
                    break;
                }
            } else {
                break;
            }
        }
        StoreProduct storeProduct2 = (StoreProduct) obj;
        StoreProduct access$applyOfferingIdentifier = storeProduct2 != null ? CommonKt.applyOfferingIdentifier(storeProduct2, this.$presentedOfferingIdentifier) : null;
        if (access$applyOfferingIdentifier != null) {
            PurchaseParams.Builder builder = new PurchaseParams.Builder(this.$activity, access$applyOfferingIdentifier);
            String str3 = this.$googleOldProductId;
            if (str3 != null && (!StringsKt.isBlank(str3))) {
                builder.oldProductId(this.$googleOldProductId);
                GoogleProrationMode googleProrationMode = this.$googleProrationMode;
                if (googleProrationMode != null) {
                    builder.googleProrationMode(googleProrationMode);
                }
            }
            Boolean bool = this.$googleIsPersonalizedPrice;
            if (bool != null) {
                bool.booleanValue();
                builder.isPersonalizedPrice(bool.booleanValue());
            }
            ListenerConversionsCommonKt.purchaseWith(Purchases.Companion.getSharedInstance(), builder.build(), CommonKt.getPurchaseErrorFunction(this.$onResult), CommonKt.getPurchaseCompletedFunction(this.$onResult));
            return;
        }
        this.$onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Couldn't find product " + this.$productIdentifier), (Map) null, 1, (Object) null));
    }
}
