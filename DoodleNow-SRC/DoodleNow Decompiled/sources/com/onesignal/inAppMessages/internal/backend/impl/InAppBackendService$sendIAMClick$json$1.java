package com.onesignal.inAppMessages.internal.backend.impl;

import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/onesignal/inAppMessages/internal/backend/impl/InAppBackendService$sendIAMClick$json$1", "Lorg/json/JSONObject;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppBackendService.kt */
public final class InAppBackendService$sendIAMClick$json$1 extends JSONObject {
    InAppBackendService$sendIAMClick$json$1(String str, InAppBackendService inAppBackendService, String str2, String str3, String str4, boolean z) {
        put("app_id", str);
        put("device_type", inAppBackendService._deviceService.getDeviceType().getValue());
        put("player_id", str2);
        put("click_id", str3);
        put("variant_id", str4);
        if (z) {
            put("first_click", true);
        }
    }
}
