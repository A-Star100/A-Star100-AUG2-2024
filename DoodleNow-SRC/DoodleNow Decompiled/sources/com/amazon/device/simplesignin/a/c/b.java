package com.amazon.device.simplesignin.a.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.amazon.device.simplesignin.ISimpleSignInResponseHandler;
import com.amazon.device.simplesignin.a.a.a;
import com.amazon.device.simplesignin.a.c;
import com.amazon.device.simplesignin.model.AccountLinkType;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import com.amazon.device.simplesignin.model.response.GetUserAndLinksResponse;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;
import com.amazon.device.simplesignin.model.response.ShowLoginSelectionResponse;
import com.amazon.device.simplesignin.model.response.UnlinkUserAccountResponse;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SandboxRequestHandler */
public class b implements com.amazon.device.simplesignin.a.b {
    /* access modifiers changed from: private */
    public static final String a = "b";
    private static final String b = "com.amazon.sdktestclient";
    private static final String c = "com.amazon.sdktestclient.command.CommandBroker";

    public void a(RequestId requestId, String str) {
        Log.i(a, "Handling getUserAndLinks sandbox request.");
        Context c2 = c.a().c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, requestId);
            jSONObject.put("packageName", c2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, "1.0.0");
            jSONObject.put(a.a, str);
            Bundle bundle = new Bundle();
            bundle.putString("getUserAndLinksInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.simplesignin.getUserAndLinks");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            c2.startService(a2);
        } catch (JSONException unused) {
            Log.e(a, "Error in preparing getUserAndLinksInput.");
        }
    }

    public void a(RequestId requestId, LinkUserAccountRequest linkUserAccountRequest) {
        Log.i(a, "Handling linkUserAccount sandbox request.");
        Context c2 = c.a().c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, requestId);
            jSONObject.put("packageName", c2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, "1.0.0");
            jSONObject.put(a.d, linkUserAccountRequest.getPartnerUserId());
            jSONObject.put(a.a, linkUserAccountRequest.getIdentityProviderName());
            jSONObject.put(a.e, linkUserAccountRequest.getUserLoginName());
            jSONObject.put(a.h, linkUserAccountRequest.getAccountLinkType());
            if (AccountLinkType.AMAZON_MANAGED.equals(linkUserAccountRequest.getAccountLinkType())) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("token", linkUserAccountRequest.getLinkToken().getToken());
                jSONObject2.put(a.A, linkUserAccountRequest.getLinkToken().getSchema());
                jSONObject.put(a.g, jSONObject2.toString());
                jSONObject.put(a.f, linkUserAccountRequest.getLinkSigningKey());
            }
            Bundle bundle = new Bundle();
            bundle.putString("linkUserAccountInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.simplesignin.linkUserAccount");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            c2.startService(a2);
        } catch (JSONException e) {
            Log.e(a, "Unable to create linkToken json");
            throw new IllegalStateException("Unable to create linkToken json", e);
        }
    }

    public void a(RequestId requestId, Map<String, String> map) {
        Log.i(a, "Handling showLoginSelection sandbox request.");
        Context c2 = c.a().c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, requestId);
            jSONObject.put("packageName", c2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, "1.0.0");
            Intent a2 = a("com.amazon.testclient.simplesignin.showLoginSelection");
            a2.putExtra("showLoginSelectionInput", jSONObject.toString());
            a2.putExtra(a.m, new HashMap(map));
            a2.addFlags(268435456);
            c2.startService(a2);
        } catch (JSONException e) {
            Log.e(a, "Unable to create showLoginSelection Input");
            throw new IllegalStateException("Unable to create showLoginSelection input json", e);
        }
    }

    public void b(RequestId requestId, String str) {
        Log.i(a, "Handling unlinkUserAccount sandbox request.");
        Context c2 = c.a().c();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, requestId);
            jSONObject.put("packageName", c2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, "1.0.0");
            jSONObject.put(a.a, str);
            Bundle bundle = new Bundle();
            bundle.putString("unlinkUserAccountInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.simplesignin.unlinkUserAccount");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            c2.startService(a2);
        } catch (JSONException e) {
            Log.e(a, "Error in preparing unlinkUserAccount.", e);
        }
    }

    public void a(Context context, Intent intent) {
        intent.setComponent(new ComponentName(b, c));
        try {
            String string = intent.getExtras().getString("responseType");
            if ("com.amazon.testclient.simplesignin.getUserAndLinks".equals(string)) {
                a((Object) a(intent));
            } else if ("com.amazon.testclient.simplesignin.linkUserAccount".equals(string)) {
                a((Object) b(intent));
            } else if ("com.amazon.testclient.simplesignin.showLoginSelection".equals(string)) {
                a((Object) c(intent));
            } else if ("com.amazon.testclient.simplesignin.unlinkUserAccount".equals(string)) {
                a((Object) d(intent));
            } else {
                Log.d(a, "Unknown response type received.");
            }
        } catch (Exception e) {
            Log.e(a, "Error handling response.", e);
        }
    }

    private GetUserAndLinksResponse a(Intent intent) {
        GetUserAndLinksResponse getUserAndLinksResponse = new GetUserAndLinksResponse();
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("getUserAndLinksOutput"));
            getUserAndLinksResponse.setRequestId(new RequestId(jSONObject.getString(com.amazon.a.a.o.b.B)));
            RequestStatus valueOf = RequestStatus.valueOf(jSONObject.getString("status"));
            getUserAndLinksResponse.setRequestStatus(valueOf);
            if (!RequestStatus.SUCCESSFUL.equals(valueOf)) {
                return getUserAndLinksResponse;
            }
            String string = jSONObject.getString(a.b);
            getUserAndLinksResponse.setAmazonUserId(string);
            getUserAndLinksResponse.setLinks(com.amazon.device.simplesignin.a.d.b.a(string, jSONObject.getString(a.c)));
            return getUserAndLinksResponse;
        } catch (JSONException e) {
            Log.e(a, "Exception while parsing GetUserAndLinks response", e);
        }
    }

    private LinkUserAccountResponse b(Intent intent) {
        LinkUserAccountResponse linkUserAccountResponse = new LinkUserAccountResponse();
        try {
            String stringExtra = intent.getStringExtra("linkUserAccountOutput");
            String str = a;
            Log.i(str, "SimpleSignInService : linkUserAccountOutput " + stringExtra);
            JSONObject jSONObject = new JSONObject(stringExtra);
            linkUserAccountResponse.setRequestId(new RequestId(jSONObject.getString(com.amazon.a.a.o.b.B)));
            RequestStatus valueOf = RequestStatus.valueOf(jSONObject.getString("status"));
            linkUserAccountResponse.setRequestStatus(valueOf);
            if (!RequestStatus.SUCCESSFUL.equals(valueOf)) {
                return linkUserAccountResponse;
            }
            String string = jSONObject.getString(a.k);
            if (!LinkUserAccountResponse.SuccessCode.ConsentDenied.equals(LinkUserAccountResponse.SuccessCode.valueOf(string))) {
                linkUserAccountResponse.setLink(com.amazon.device.simplesignin.a.d.b.a(jSONObject.getString(a.j)));
            }
            linkUserAccountResponse.setSuccessCode(LinkUserAccountResponse.SuccessCode.valueOf(string));
            return linkUserAccountResponse;
        } catch (JSONException e) {
            Log.e(a, "Exception while parsing LinkUserAccount response", e);
        }
    }

    private ShowLoginSelectionResponse c(Intent intent) {
        ShowLoginSelectionResponse showLoginSelectionResponse = new ShowLoginSelectionResponse();
        try {
            String stringExtra = intent.getStringExtra("showLoginSelectionOutput");
            String str = a;
            Log.i(str, "SimpleSignInService : loginSelectionOutput " + stringExtra);
            JSONObject jSONObject = new JSONObject(stringExtra);
            showLoginSelectionResponse.setRequestId(new RequestId(jSONObject.getString(com.amazon.a.a.o.b.B)));
            RequestStatus valueOf = RequestStatus.valueOf(jSONObject.getString("status"));
            showLoginSelectionResponse.setRequestStatus(valueOf);
            if (!RequestStatus.SUCCESSFUL.equals(valueOf)) {
                return showLoginSelectionResponse;
            }
            if (!ShowLoginSelectionResponse.UserSelection.LoginSelected.name().equals(jSONObject.getString(a.o))) {
                showLoginSelectionResponse.setUserSelection(ShowLoginSelectionResponse.UserSelection.ManualSignIn);
                return showLoginSelectionResponse;
            }
            String string = jSONObject.getString(a.p);
            if (string != null) {
                showLoginSelectionResponse.setUserSelection(ShowLoginSelectionResponse.UserSelection.LoginSelected);
                showLoginSelectionResponse.setLinkId(string);
            }
            return showLoginSelectionResponse;
        } catch (JSONException e) {
            Log.e(a, "Exception while parsing LinkUserAccount response", e);
            showLoginSelectionResponse.setUserSelection(ShowLoginSelectionResponse.UserSelection.ManualSignIn);
        }
    }

    private UnlinkUserAccountResponse d(Intent intent) {
        UnlinkUserAccountResponse unlinkUserAccountResponse = new UnlinkUserAccountResponse();
        try {
            String stringExtra = intent.getStringExtra("unlinkUserAccountOutput");
            String str = a;
            Log.i(str, "SimpleSignInService : unlinkUserAccountOutput " + stringExtra);
            JSONObject jSONObject = new JSONObject(stringExtra);
            unlinkUserAccountResponse.setRequestId(new RequestId(jSONObject.getString(com.amazon.a.a.o.b.B)));
            RequestStatus valueOf = RequestStatus.valueOf(jSONObject.getString("status"));
            unlinkUserAccountResponse.setRequestStatus(valueOf);
            RequestStatus.SUCCESSFUL.equals(valueOf);
            return unlinkUserAccountResponse;
        } catch (JSONException e) {
            Log.e(a, "Exception while parsing UnlinkUserAccount response", e);
            return unlinkUserAccountResponse;
        }
    }

    private Intent a(String str) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(b, c));
        return intent;
    }

    private void a(final Object obj) {
        Context c2 = c.a().c();
        final ISimpleSignInResponseHandler d = c.a().d();
        if (c2 == null || obj == null) {
            String str = a;
            Log.i(str, "ISimpleSignInResponseHandler is not set. Dropping response: " + obj);
            return;
        }
        new Handler(c2.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    Object obj = obj;
                    if (obj instanceof GetUserAndLinksResponse) {
                        d.onGetUserAndLinksResponse((GetUserAndLinksResponse) obj);
                    } else if (obj instanceof LinkUserAccountResponse) {
                        d.onLinkUserAccountResponse((LinkUserAccountResponse) obj);
                    } else if (obj instanceof ShowLoginSelectionResponse) {
                        d.onShowLoginSelectionResponse((ShowLoginSelectionResponse) obj);
                    } else if (obj instanceof UnlinkUserAccountResponse) {
                        d.onUnlinkUserAccountResponse((UnlinkUserAccountResponse) obj);
                    } else {
                        String a2 = b.a;
                        Log.e(a2, "Unknown response type:" + obj.getClass().getName());
                    }
                } catch (Exception e) {
                    String a3 = b.a;
                    Log.e(a3, "Error in sendResponse: " + e);
                }
            }
        });
    }
}
