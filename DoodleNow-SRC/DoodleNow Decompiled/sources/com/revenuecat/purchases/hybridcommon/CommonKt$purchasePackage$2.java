package com.revenuecat.purchases.hybridcommon;

import android.app.Activity;
import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchaseParams;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.hybridcommon.mappers.PurchasesErrorKt;
import com.revenuecat.purchases.models.GoogleProrationMode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "offerings", "Lcom/revenuecat/purchases/Offerings;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: common.kt */
final class CommonKt$purchasePackage$2 extends Lambda implements Function1<Offerings, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ Boolean $googleIsPersonalizedPrice;
    final /* synthetic */ String $googleOldProductId;
    final /* synthetic */ GoogleProrationMode $googleProrationMode;
    final /* synthetic */ String $offeringIdentifier;
    final /* synthetic */ OnResult $onResult;
    final /* synthetic */ String $packageIdentifier;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonKt$purchasePackage$2(String str, Activity activity, String str2, GoogleProrationMode googleProrationMode, Boolean bool, OnResult onResult, String str3) {
        super(1);
        this.$offeringIdentifier = str;
        this.$activity = activity;
        this.$googleOldProductId = str2;
        this.$googleProrationMode = googleProrationMode;
        this.$googleIsPersonalizedPrice = bool;
        this.$onResult = onResult;
        this.$packageIdentifier = str3;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Offerings) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Offerings offerings) {
        Package packageR;
        List<Package> availablePackages;
        Object obj;
        Intrinsics.checkNotNullParameter(offerings, "offerings");
        Offering offering = offerings.get(this.$offeringIdentifier);
        if (offering == null || (availablePackages = offering.getAvailablePackages()) == null) {
            packageR = null;
        } else {
            String str = this.$packageIdentifier;
            Iterator it = availablePackages.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (StringsKt.equals(((Package) obj).getIdentifier(), str, true)) {
                    break;
                }
            }
            packageR = (Package) obj;
        }
        if (packageR != null) {
            PurchaseParams.Builder builder = new PurchaseParams.Builder(this.$activity, packageR);
            String str2 = this.$googleOldProductId;
            if (str2 != null && (true ^ StringsKt.isBlank(str2))) {
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
        this.$onResult.onError(PurchasesErrorKt.map$default(new PurchasesError(PurchasesErrorCode.ProductNotAvailableForPurchaseError, "Couldn't find product for package " + this.$packageIdentifier), (Map) null, 1, (Object) null));
    }
}
