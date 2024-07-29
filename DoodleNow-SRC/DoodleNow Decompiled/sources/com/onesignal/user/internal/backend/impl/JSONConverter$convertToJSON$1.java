package com.onesignal.user.internal.backend.impl;

import com.onesignal.user.internal.backend.PurchaseObject;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", "it", "Lcom/onesignal/user/internal/backend/PurchaseObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: JSONConverter.kt */
final class JSONConverter$convertToJSON$1 extends Lambda implements Function1<PurchaseObject, JSONObject> {
    public static final JSONConverter$convertToJSON$1 INSTANCE = new JSONConverter$convertToJSON$1();

    JSONConverter$convertToJSON$1() {
        super(1);
    }

    public final JSONObject invoke(PurchaseObject purchaseObject) {
        Intrinsics.checkNotNullParameter(purchaseObject, "it");
        return new JSONObject().put("sku", purchaseObject.getSku()).put("iso", purchaseObject.getIso()).put("amount", purchaseObject.getAmount().toString());
    }
}
