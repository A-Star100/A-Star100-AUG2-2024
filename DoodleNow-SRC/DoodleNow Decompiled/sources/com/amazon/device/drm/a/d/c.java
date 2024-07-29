package com.amazon.device.drm.a.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.amazon.a.a.o.f;
import com.amazon.device.drm.LicensingListener;
import com.amazon.device.drm.LicensingService;
import com.amazon.device.drm.a.c.a;
import com.amazon.device.drm.a.d;
import com.amazon.device.drm.a.e.b;
import com.amazon.device.drm.model.LicenseResponse;
import com.amazon.device.drm.model.RequestId;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SandboxRequestHandler */
public class c implements com.amazon.device.drm.a.c {
    /* access modifiers changed from: private */
    public static final String a = "c";
    private static final String b = "com.amazon.sdktestclient";
    private static final String c = "com.amazon.sdktestclient.command.CommandBroker";

    public void a(RequestId requestId) {
        b.a(a, "sendGetLicenseRequest");
        try {
            Context c2 = d.d().c();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, requestId);
            jSONObject.put("packageName", c2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, LicensingService.SDK_VERSION);
            bundle.putString("getLicenseInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.drm.getLicense");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            c2.startService(a2);
        } catch (JSONException unused) {
            b.b(a, "Error in sendGetUserDataRequest.");
        }
    }

    private Intent a(String str) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(b, c));
        return intent;
    }

    public void a(Context context, Intent intent) {
        b.a(a, "handleResponse");
        intent.setComponent(new ComponentName(b, c));
        try {
            if (intent.getExtras().getString("responseType").equalsIgnoreCase("com.amazon.testclient.drm.getLicense")) {
                a((Object) a(intent));
            }
        } catch (Exception e) {
            Log.e(a, "Error handling response.", e);
        }
    }

    private LicenseResponse a(Intent intent) {
        RequestId requestId;
        LicenseResponse.RequestStatus requestStatus = LicenseResponse.RequestStatus.UNKNOWN_ERROR;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("getLicenseOutput"));
            requestStatus = LicenseResponse.RequestStatus.valueOf(jSONObject.optString("status"));
            requestId = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.B));
        } catch (Exception e) {
            Log.e(a, "Error parsing getLicense response", e);
            requestId = null;
        }
        return new a().a(requestId).a(requestStatus).a();
    }

    /* access modifiers changed from: protected */
    public void a(final Object obj) {
        f.a(obj, "response");
        Context c2 = d.d().c();
        final LicensingListener b2 = d.d().b();
        if (c2 == null || b2 == null) {
            String str = a;
            b.a(str, "LicensingListener is not set. Dropping response: " + obj);
            return;
        }
        new Handler(c2.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    Object obj = obj;
                    if (obj instanceof LicenseResponse) {
                        b2.onLicenseCommandResponse((LicenseResponse) obj);
                        return;
                    }
                    String a2 = c.a;
                    b.b(a2, "Unknown response type:" + obj.getClass().getName());
                } catch (Exception e) {
                    String a3 = c.a;
                    b.b(a3, "Error in sendResponse: " + e);
                }
            }
        });
    }
}
