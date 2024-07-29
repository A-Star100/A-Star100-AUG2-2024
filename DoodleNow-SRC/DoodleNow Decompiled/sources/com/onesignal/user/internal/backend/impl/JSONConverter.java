package com.onesignal.user.internal.backend.impl;

import com.amplitude.api.Constants;
import com.facebook.react.uimanager.ViewProps;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.user.internal.backend.CreateUserResponse;
import com.onesignal.user.internal.backend.PropertiesDeltasObject;
import com.onesignal.user.internal.backend.PropertiesObject;
import com.onesignal.user.internal.backend.SubscriptionObject;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u0007\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u0010¨\u0006\u0011"}, d2 = {"Lcom/onesignal/user/internal/backend/impl/JSONConverter;", "", "()V", "convertToCreateUserResponse", "Lcom/onesignal/user/internal/backend/CreateUserResponse;", "jsonObject", "Lorg/json/JSONObject;", "convertToJSON", "propertiesDeltas", "Lcom/onesignal/user/internal/backend/PropertiesDeltasObject;", "properties", "Lcom/onesignal/user/internal/backend/PropertiesObject;", "subscription", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "Lorg/json/JSONArray;", "subscriptions", "", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: JSONConverter.kt */
public final class JSONConverter {
    public static final JSONConverter INSTANCE = new JSONConverter();

    private JSONConverter() {
    }

    public final CreateUserResponse convertToCreateUserResponse(JSONObject jSONObject) {
        Map map;
        Map map2;
        JSONObject safeJSONObject;
        Map<String, Object> map3;
        Map<String, Object> map4;
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        JSONObject safeJSONObject2 = JSONObjectExtensionsKt.safeJSONObject(jSONObject, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        if (safeJSONObject2 == null || (map4 = JSONObjectExtensionsKt.toMap(safeJSONObject2)) == null) {
            map = MapsKt.emptyMap();
        } else {
            map = new LinkedHashMap(MapsKt.mapCapacity(map4.size()));
            for (Map.Entry entry : map4.entrySet()) {
                map.put(entry.getKey(), String.valueOf(entry.getValue()));
            }
        }
        JSONObject safeJSONObject3 = JSONObjectExtensionsKt.safeJSONObject(jSONObject, DiagnosticsEntry.Event.PROPERTIES_KEY);
        Double d = null;
        if (safeJSONObject3 == null || (safeJSONObject = JSONObjectExtensionsKt.safeJSONObject(safeJSONObject3, "tags")) == null || (map3 = JSONObjectExtensionsKt.toMap(safeJSONObject)) == null) {
            map2 = null;
        } else {
            Map linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map3.size()));
            for (Map.Entry entry2 : map3.entrySet()) {
                linkedHashMap.put(entry2.getKey(), String.valueOf(entry2.getValue()));
            }
            map2 = linkedHashMap;
        }
        String safeString = safeJSONObject3 != null ? JSONObjectExtensionsKt.safeString(safeJSONObject3, Constants.AMP_TRACKING_OPTION_LANGUAGE) : null;
        String safeString2 = safeJSONObject3 != null ? JSONObjectExtensionsKt.safeString(safeJSONObject3, "timezone_id") : null;
        String safeString3 = safeJSONObject3 != null ? JSONObjectExtensionsKt.safeString(safeJSONObject3, Constants.AMP_TRACKING_OPTION_COUNTRY) : null;
        Double safeDouble = safeJSONObject3 != null ? JSONObjectExtensionsKt.safeDouble(safeJSONObject3, "lat") : null;
        if (safeJSONObject3 != null) {
            d = JSONObjectExtensionsKt.safeDouble(safeJSONObject3, "long");
        }
        return new CreateUserResponse(map, new PropertiesObject(map2, safeString, safeString2, safeString3, safeDouble, d), JSONObjectExtensionsKt.expandJSONArray(jSONObject, "subscriptions", JSONConverter$convertToCreateUserResponse$respSubscriptions$1.INSTANCE));
    }

    public final JSONObject convertToJSON(PropertiesObject propertiesObject) {
        Intrinsics.checkNotNullParameter(propertiesObject, DiagnosticsEntry.Event.PROPERTIES_KEY);
        return JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putMap(new JSONObject(), "tags", propertiesObject.getTags()), Constants.AMP_TRACKING_OPTION_LANGUAGE, propertiesObject.getLanguage()), "timezone_id", propertiesObject.getTimezoneId()), "lat", propertiesObject.getLatitude()), "long", propertiesObject.getLongitude()), Constants.AMP_TRACKING_OPTION_COUNTRY, propertiesObject.getCountry());
    }

    public final JSONObject convertToJSON(PropertiesDeltasObject propertiesDeltasObject) {
        Intrinsics.checkNotNullParameter(propertiesDeltasObject, "propertiesDeltas");
        JSONObject putSafe = JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(new JSONObject(), "session_time", propertiesDeltasObject.getSessionTime()), "session_count", propertiesDeltasObject.getSessionCount());
        BigDecimal amountSpent = propertiesDeltasObject.getAmountSpent();
        return JSONObjectExtensionsKt.putJSONArray(JSONObjectExtensionsKt.putSafe(putSafe, "amount_spent", amountSpent != null ? amountSpent.toString() : null), "purchases", propertiesDeltasObject.getPurchases(), JSONConverter$convertToJSON$1.INSTANCE);
    }

    public final JSONArray convertToJSON(List<SubscriptionObject> list) {
        Intrinsics.checkNotNullParameter(list, "subscriptions");
        JSONArray jSONArray = new JSONArray();
        for (SubscriptionObject convertToJSON : list) {
            jSONArray.put(convertToJSON(convertToJSON));
        }
        return jSONArray;
    }

    public final JSONObject convertToJSON(SubscriptionObject subscriptionObject) {
        Intrinsics.checkNotNullParameter(subscriptionObject, "subscription");
        JSONObject putSafe = JSONObjectExtensionsKt.putSafe(new JSONObject(), "id", subscriptionObject.getId());
        SubscriptionObjectType type = subscriptionObject.getType();
        return JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(JSONObjectExtensionsKt.putSafe(putSafe, "type", type != null ? type.getValue() : null), "token", subscriptionObject.getToken()), ViewProps.ENABLED, subscriptionObject.getEnabled()), "notification_types", subscriptionObject.getNotificationTypes()), "sdk", subscriptionObject.getSdk()), Constants.AMP_TRACKING_OPTION_DEVICE_MODEL, subscriptionObject.getDeviceModel()), "device_os", subscriptionObject.getDeviceOS()), "rooted", subscriptionObject.getRooted()), "net_type", subscriptionObject.getNetType()), Constants.AMP_TRACKING_OPTION_CARRIER, subscriptionObject.getCarrier()), "app_version", subscriptionObject.getAppVersion());
    }
}
