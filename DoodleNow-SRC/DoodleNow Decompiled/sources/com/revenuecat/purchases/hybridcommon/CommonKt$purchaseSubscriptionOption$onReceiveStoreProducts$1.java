package com.revenuecat.purchases.hybridcommon;

import android.app.Activity;
import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import com.revenuecat.purchases.models.GoogleProrationMode;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "storeProducts", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: common.kt */
final class CommonKt$purchaseSubscriptionOption$onReceiveStoreProducts$1 extends Lambda implements Function1<List<? extends StoreProduct>, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Boolean $googleIsPersonalizedPrice;
    final /* synthetic */ String $googleOldProductId;
    final /* synthetic */ GoogleProrationMode $googleProrationMode;
    final /* synthetic */ OnResult $onResult;
    final /* synthetic */ String $optionIdentifier;
    final /* synthetic */ String $presentedOfferingIdentifier;
    final /* synthetic */ String $productIdentifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonKt$purchaseSubscriptionOption$onReceiveStoreProducts$1(Activity activity, String str, Boolean bool, OnResult onResult, String str2, String str3, String str4, GoogleProrationMode googleProrationMode) {
        super(1);
        this.$activity = activity;
        this.$googleOldProductId = str;
        this.$googleIsPersonalizedPrice = bool;
        this.$onResult = onResult;
        this.$productIdentifier = str2;
        this.$optionIdentifier = str3;
        this.$presentedOfferingIdentifier = str4;
        this.$googleProrationMode = googleProrationMode;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) (List) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(List<? extends StoreProduct> list) {
        String str;
        SubscriptionOption subscriptionOption;
        Object obj;
        Intrinsics.checkNotNullParameter(list, "storeProducts");
        String str2 = this.$presentedOfferingIdentifier;
        String str3 = this.$productIdentifier;
        String str4 = this.$optionIdentifier;
        Iterator it = list.iterator();
        while (true) {
            str = null;
            if (!it.hasNext()) {
                subscriptionOption = null;
                break;
            }
            StoreProduct storeProduct = (StoreProduct) it.next();
            SubscriptionOptions subscriptionOptions = CommonKt.applyOfferingIdentifier(storeProduct, str2).getSubscriptionOptions();
            if (subscriptionOptions != null) {
                Iterator it2 = subscriptionOptions.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    SubscriptionOption subscriptionOption2 = (SubscriptionOption) obj;
                    if (Intrinsics.areEqual((Object) storeProduct.getPurchasingData().getProductId(), (Object) str3) && Intrinsics.areEqual((Object) subscriptionOption2.getId(), (Object) str4)) {
                        break;
                    }
                }
                subscriptionOption = (SubscriptionOption) obj;
                continue;
            } else {
                subscriptionOption = null;
                continue;
            }
            if (subscriptionOption != null) {
                break;
            }
        }
        if (subscriptionOption != null) {
            PurchaseParams.Builder builder = new PurchaseParams.Builder(this.$activity, subscriptionOption);
            String str5 = this.$googleOldProductId;
            CharSequence charSequence = str5;
            if (charSequence != null && !StringsKt.isBlank(charSequence)) {
                str = str5;
            }
            if (str != null) {
                GoogleProrationMode googleProrationMode = this.$googleProrationMode;
                builder.oldProductId(str);
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
        this.$onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Couldn't find product " + this.$productIdentifier + AbstractJsonLexerKt.COLON + this.$optionIdentifier), (Map) null, 1, (Object) null));
    }
}
