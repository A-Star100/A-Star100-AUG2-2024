package com.onesignal.user.internal.backend.impl;

import com.amplitude.api.Constants;
import com.facebook.react.uimanager.ViewProps;
import com.onesignal.common.JSONObjectExtensionsKt;
import com.onesignal.user.internal.backend.SubscriptionObject;
import com.onesignal.user.internal.backend.SubscriptionObjectType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/onesignal/user/internal/backend/SubscriptionObject;", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: JSONConverter.kt */
final class JSONConverter$convertToCreateUserResponse$respSubscriptions$1 extends Lambda implements Function1<JSONObject, SubscriptionObject> {
    public static final JSONConverter$convertToCreateUserResponse$respSubscriptions$1 INSTANCE = new JSONConverter$convertToCreateUserResponse$respSubscriptions$1();

    JSONConverter$convertToCreateUserResponse$respSubscriptions$1() {
        super(1);
    }

    public final SubscriptionObject invoke(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        Intrinsics.checkNotNullParameter(jSONObject2, "it");
        SubscriptionObjectType.Companion companion = SubscriptionObjectType.Companion;
        String string = jSONObject2.getString("type");
        Intrinsics.checkNotNullExpressionValue(string, "it.getString(\"type\")");
        SubscriptionObjectType fromString = companion.fromString(string);
        if (fromString != null) {
            return new SubscriptionObject(jSONObject2.getString("id"), fromString, JSONObjectExtensionsKt.safeString(jSONObject2, "token"), JSONObjectExtensionsKt.safeBool(jSONObject2, ViewProps.ENABLED), JSONObjectExtensionsKt.safeInt(jSONObject2, "notification_types"), JSONObjectExtensionsKt.safeString(jSONObject2, "sdk"), JSONObjectExtensionsKt.safeString(jSONObject2, Constants.AMP_TRACKING_OPTION_DEVICE_MODEL), JSONObjectExtensionsKt.safeString(jSONObject2, "device_os"), JSONObjectExtensionsKt.safeBool(jSONObject2, "rooted"), JSONObjectExtensionsKt.safeInt(jSONObject2, "net_type"), JSONObjectExtensionsKt.safeString(jSONObject2, Constants.AMP_TRACKING_OPTION_CARRIER), JSONObjectExtensionsKt.safeString(jSONObject2, "app_version"));
        }
        return null;
    }
}
