package com.amazon.device.iap.internal.a;

import android.content.Context;
import android.content.Intent;
import com.amazon.device.iap.internal.a.c.a;
import com.amazon.device.iap.internal.e;
import com.amazon.device.iap.internal.util.b;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import java.util.Set;

/* compiled from: KiwiRequestHandler */
public final class d implements e {
    private static final String a = "d";
    private static final String b = "response_type";
    private static final String c = "requestId";
    private static final String d = "purchase_response";

    public void a(RequestId requestId) {
        b.a(a, "sendGetUserData");
        new a(requestId).e();
    }

    public void a(RequestId requestId, String str) {
        b.a(a, "sendPurchaseRequest");
        new com.amazon.device.iap.internal.a.e.d(requestId, str).e();
    }

    public void a(RequestId requestId, Set<String> set) {
        b.a(a, "sendGetProductDataRequest");
        new com.amazon.device.iap.internal.a.a.d(requestId, set).e();
    }

    public void a(RequestId requestId, boolean z) {
        b.a(a, "sendGetPurchaseUpdates");
        new com.amazon.device.iap.internal.a.b.a(requestId, z).e();
    }

    public void a(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        b.a(a, "sendNotifyFulfillment");
        new com.amazon.device.iap.internal.a.d.a(requestId, str, fulfillmentResult).e();
    }

    public void a(Context context, Intent intent) {
        String str = a;
        b.a(str, "handleResponse");
        String stringExtra = intent.getStringExtra(b);
        if (stringExtra == null) {
            b.a(str, "Invalid response type: null");
            return;
        }
        b.a(str, "Found response type: " + stringExtra);
        if (d.equals(stringExtra)) {
            new com.amazon.device.iap.internal.a.f.d(RequestId.fromString(intent.getStringExtra("requestId"))).e();
        }
    }
}
