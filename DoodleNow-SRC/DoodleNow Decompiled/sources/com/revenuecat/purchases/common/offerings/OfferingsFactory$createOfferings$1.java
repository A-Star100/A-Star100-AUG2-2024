package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.SerializationException;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "productsById", "", "", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingsFactory.kt */
final class OfferingsFactory$createOfferings$1 extends Lambda implements Function1<Map<String, ? extends List<? extends StoreProduct>>, Unit> {
    final /* synthetic */ Set<String> $allRequestedProductIdentifiers;
    final /* synthetic */ JSONObject $offeringsJSON;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;
    final /* synthetic */ Function1<Offerings, Unit> $onSuccess;
    final /* synthetic */ OfferingsFactory this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfferingsFactory$createOfferings$1(OfferingsFactory offeringsFactory, Set<String> set, JSONObject jSONObject, Function1<? super PurchasesError, Unit> function1, Function1<? super Offerings, Unit> function12) {
        super(1);
        this.this$0 = offeringsFactory;
        this.$allRequestedProductIdentifiers = set;
        this.$offeringsJSON = jSONObject;
        this.$onError = function1;
        this.$onSuccess = function12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, ? extends List<? extends StoreProduct>>) (Map) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Map<String, ? extends List<? extends StoreProduct>> map) {
        Intrinsics.checkNotNullParameter(map, "productsById");
        try {
            Unit unused = this.this$0.logMissingProducts(this.$allRequestedProductIdentifiers, map);
            Offerings createOfferings = this.this$0.offeringParser.createOfferings(this.$offeringsJSON, map);
            if (createOfferings.getAll().isEmpty()) {
                this.$onError.invoke(new PurchasesError(PurchasesErrorCode.ConfigurationError, OfferingStrings.CONFIGURATION_ERROR_PRODUCTS_NOT_FOUND));
                return;
            }
            String format = String.format(OfferingStrings.CREATED_OFFERINGS, Arrays.copyOf(new Object[]{createOfferings}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.verboseLog(format);
            this.$onSuccess.invoke(createOfferings);
        } catch (Exception e) {
            if (!(e instanceof JSONException) && !(e instanceof SerializationException)) {
                throw e;
            }
            LogIntent logIntent = LogIntent.RC_ERROR;
            String format2 = String.format(OfferingStrings.JSON_EXCEPTION_ERROR, Arrays.copyOf(new Object[]{e.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
            LogWrapperKt.log(logIntent, format2);
            this.$onError.invoke(new PurchasesError(PurchasesErrorCode.UnexpectedBackendResponseError, e.getLocalizedMessage()));
        }
    }
}
