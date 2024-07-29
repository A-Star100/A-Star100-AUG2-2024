package com.revenuecat.purchases.common;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.strings.OfferingStrings;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b \u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bH\u0007J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\bJ4\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J,\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0018\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\b2\u0006\u0010\u0011\u001a\u00020\u0006H$¨\u0006\u0016"}, d2 = {"Lcom/revenuecat/purchases/common/OfferingParser;", "", "()V", "createOffering", "Lcom/revenuecat/purchases/Offering;", "offeringJson", "Lorg/json/JSONObject;", "productsById", "", "", "", "Lcom/revenuecat/purchases/models/StoreProduct;", "createOfferings", "Lcom/revenuecat/purchases/Offerings;", "offeringsJson", "createPackage", "Lcom/revenuecat/purchases/Package;", "packageJson", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "findMatchingProduct", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingParser.kt */
public abstract class OfferingParser {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Json json = JsonKt.Json$default((Json) null, OfferingParser$Companion$json$1.INSTANCE, 1, (Object) null);

    /* access modifiers changed from: protected */
    public abstract StoreProduct findMatchingProduct(Map<String, ? extends List<? extends StoreProduct>> map, JSONObject jSONObject);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/common/OfferingParser$Companion;", "", "()V", "json", "Lkotlinx/serialization/json/Json;", "getJson$purchases_defaultsRelease$annotations", "getJson$purchases_defaultsRelease", "()Lkotlinx/serialization/json/Json;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OfferingParser.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getJson$purchases_defaultsRelease$annotations() {
        }

        private Companion() {
        }

        public final Json getJson$purchases_defaultsRelease() {
            return OfferingParser.json;
        }
    }

    public final Offerings createOfferings(JSONObject jSONObject, Map<String, ? extends List<? extends StoreProduct>> map) {
        Intrinsics.checkNotNullParameter(jSONObject, "offeringsJson");
        Intrinsics.checkNotNullParameter(map, "productsById");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(OfferingStrings.BUILDING_OFFERINGS, Arrays.copyOf(new Object[]{Integer.valueOf(map.size())}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        JSONArray jSONArray = jSONObject.getJSONArray("offerings");
        String string = jSONObject.getString("current_offering_id");
        Map linkedHashMap = new LinkedHashMap();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "offeringJson");
            Offering createOffering = createOffering(jSONObject2, map);
            if (createOffering != null) {
                linkedHashMap.put(createOffering.getIdentifier(), createOffering);
                if (createOffering.getAvailablePackages().isEmpty()) {
                    String format2 = String.format(OfferingStrings.OFFERING_EMPTY, Arrays.copyOf(new Object[]{createOffering.getIdentifier()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                    LogUtilsKt.warnLog(format2);
                }
            }
        }
        return new Offerings((Offering) linkedHashMap.get(string), linkedHashMap);
    }

    public final Offering createOffering(JSONObject jSONObject, Map<String, ? extends List<? extends StoreProduct>> map) {
        Map map2;
        PaywallData paywallData;
        PaywallData paywallData2;
        Intrinsics.checkNotNullParameter(jSONObject, "offeringJson");
        Intrinsics.checkNotNullParameter(map, "productsById");
        String string = jSONObject.getString("identifier");
        JSONObject optJSONObject = jSONObject.optJSONObject(TtmlNode.TAG_METADATA);
        if (optJSONObject == null || (map2 = JSONObjectExtensionsKt.toMap(optJSONObject, true)) == null) {
            map2 = MapsKt.emptyMap();
        }
        Map map3 = map2;
        JSONArray jSONArray = jSONObject.getJSONArray("packages");
        Intrinsics.checkNotNullExpressionValue(string, "offeringIdentifier");
        PresentedOfferingContext presentedOfferingContext = new PresentedOfferingContext(string);
        List arrayList = new ArrayList();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "packageJson");
            Package createPackage = createPackage(jSONObject2, map, presentedOfferingContext);
            if (createPackage != null) {
                arrayList.add(createPackage);
            }
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("paywall");
        if (optJSONObject2 != null) {
            try {
                StringFormat stringFormat = json;
                String jSONObject3 = optJSONObject2.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject3, "it.toString()");
                KSerializer<Object> serializer = SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(PaywallData.class));
                Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                paywallData2 = (PaywallData) stringFormat.decodeFromString(serializer, jSONObject3);
            } catch (Exception e) {
                LogUtilsKt.errorLog("Error deserializing paywall data", e);
                paywallData2 = null;
            }
            paywallData = paywallData2;
        } else {
            paywallData = null;
        }
        if (!(!arrayList.isEmpty())) {
            return null;
        }
        String string2 = jSONObject.getString(b.c);
        Intrinsics.checkNotNullExpressionValue(string2, "offeringJson.getString(\"description\")");
        return new Offering(string, string2, map3, arrayList, paywallData);
    }

    public final Package createPackage(JSONObject jSONObject, Map<String, ? extends List<? extends StoreProduct>> map, PresentedOfferingContext presentedOfferingContext) {
        Intrinsics.checkNotNullParameter(jSONObject, "packageJson");
        Intrinsics.checkNotNullParameter(map, "productsById");
        Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
        String string = jSONObject.getString("identifier");
        StoreProduct findMatchingProduct = findMatchingProduct(map, jSONObject);
        Intrinsics.checkNotNullExpressionValue(string, "packageIdentifier");
        PackageType access$toPackageType = OfferingParserKt.toPackageType(string);
        if (findMatchingProduct != null) {
            return new Package(string, access$toPackageType, findMatchingProduct.copyWithPresentedOfferingContext(presentedOfferingContext), presentedOfferingContext);
        }
        return null;
    }
}
