package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ6\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\n0\u000eJ\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0002JP\u0010\u0015\u001a\u00020\n2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132$\u0010\u0017\u001a \u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018\u0012\u0004\u0012\u00020\n0\u000e2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000eH\u0002J7\u0010\u001b\u001a\u0004\u0018\u00010\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0018\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00190\u0018H\u0002¢\u0006\u0002\u0010\u001eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/revenuecat/purchases/common/offerings/OfferingsFactory;", "", "billing", "Lcom/revenuecat/purchases/common/BillingAbstract;", "offeringParser", "Lcom/revenuecat/purchases/common/OfferingParser;", "dispatcher", "Lcom/revenuecat/purchases/common/Dispatcher;", "(Lcom/revenuecat/purchases/common/BillingAbstract;Lcom/revenuecat/purchases/common/OfferingParser;Lcom/revenuecat/purchases/common/Dispatcher;)V", "createOfferings", "", "offeringsJSON", "Lorg/json/JSONObject;", "onError", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "onSuccess", "Lcom/revenuecat/purchases/Offerings;", "extractProductIdentifiers", "", "", "getStoreProductsById", "productIds", "onCompleted", "", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "logMissingProducts", "allProductIdsInOfferings", "storeProductByID", "(Ljava/util/Set;Ljava/util/Map;)Lkotlin/Unit;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingsFactory.kt */
public final class OfferingsFactory {
    /* access modifiers changed from: private */
    public final BillingAbstract billing;
    /* access modifiers changed from: private */
    public final Dispatcher dispatcher;
    /* access modifiers changed from: private */
    public final OfferingParser offeringParser;

    public OfferingsFactory(BillingAbstract billingAbstract, OfferingParser offeringParser2, Dispatcher dispatcher2) {
        Intrinsics.checkNotNullParameter(billingAbstract, "billing");
        Intrinsics.checkNotNullParameter(offeringParser2, "offeringParser");
        Intrinsics.checkNotNullParameter(dispatcher2, "dispatcher");
        this.billing = billingAbstract;
        this.offeringParser = offeringParser2;
        this.dispatcher = dispatcher2;
    }

    public final void createOfferings(JSONObject jSONObject, Function1<? super PurchasesError, Unit> function1, Function1<? super Offerings, Unit> function12) {
        Intrinsics.checkNotNullParameter(jSONObject, "offeringsJSON");
        Intrinsics.checkNotNullParameter(function1, "onError");
        Intrinsics.checkNotNullParameter(function12, "onSuccess");
        try {
            Set<String> extractProductIdentifiers = extractProductIdentifiers(jSONObject);
            if (extractProductIdentifiers.isEmpty()) {
                function1.invoke(new PurchasesError(PurchasesErrorCode.ConfigurationError, OfferingStrings.CONFIGURATION_ERROR_NO_PRODUCTS_FOR_OFFERINGS));
            } else {
                getStoreProductsById(extractProductIdentifiers, new OfferingsFactory$createOfferings$1(this, extractProductIdentifiers, jSONObject, function1, function12), new OfferingsFactory$createOfferings$2(function1));
            }
        } catch (JSONException e) {
            LogIntent logIntent = LogIntent.RC_ERROR;
            String format = String.format(OfferingStrings.JSON_EXCEPTION_ERROR, Arrays.copyOf(new Object[]{e.getLocalizedMessage()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            function1.invoke(new PurchasesError(PurchasesErrorCode.UnexpectedBackendResponseError, e.getLocalizedMessage()));
        }
    }

    private final Set<String> extractProductIdentifiers(JSONObject jSONObject) {
        JSONArray jSONArray = jSONObject.getJSONArray("offerings");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONArray jSONArray2 = jSONArray.getJSONObject(i).getJSONArray("packages");
            int length2 = jSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                String optString = jSONArray2.getJSONObject(i2).optString("platform_product_identifier");
                Intrinsics.checkNotNullExpressionValue(optString, "it");
                if (!(!StringsKt.isBlank(optString))) {
                    optString = null;
                }
                if (optString != null) {
                    linkedHashSet.add(optString);
                }
            }
        }
        return linkedHashSet;
    }

    private final void getStoreProductsById(Set<String> set, Function1<? super Map<String, ? extends List<? extends StoreProduct>>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        this.billing.queryProductDetailsAsync(ProductType.SUBS, set, new OfferingsFactory$getStoreProductsById$1(this, set, function1, function12), new OfferingsFactory$getStoreProductsById$2(function12));
    }

    /* access modifiers changed from: private */
    public final Unit logMissingProducts(Set<String> set, Map<String, ? extends List<? extends StoreProduct>> map) {
        Collection arrayList = new ArrayList();
        for (Object next : set) {
            if (!map.containsKey((String) next)) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (!(!list.isEmpty())) {
            list = null;
        }
        if (list == null) {
            return null;
        }
        LogIntent logIntent = LogIntent.GOOGLE_WARNING;
        String format = String.format(OfferingStrings.CANNOT_FIND_PRODUCT_CONFIGURATION_ERROR, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(list, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        return Unit.INSTANCE;
    }
}
