package com.amazon.device.simplesignin.a;

import android.content.Context;
import android.content.Intent;
import com.amazon.a.a;
import com.amazon.a.a.o.f;
import com.amazon.device.simplesignin.ISimpleSignInResponseHandler;
import com.amazon.device.simplesignin.model.AccountLinkType;
import com.amazon.device.simplesignin.model.RequestId;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import java.util.Map;

/* compiled from: SimpleSignInManager */
public class c {
    private static String a = "c";
    private static final c b = new c();
    private static final IllegalStateException c = new IllegalStateException(String.format("%s. %s", new Object[]{"Simple Sign-In SDK not initialized", "To initialize and register responseHandler, call SimpleSignInService.registerResponseHandler()"}));
    private Context d;
    private ISimpleSignInResponseHandler e;
    private b f;

    public static c a() {
        return b;
    }

    private boolean f() {
        return this.d != null;
    }

    public Context c() {
        return this.d;
    }

    public ISimpleSignInResponseHandler d() {
        return this.e;
    }

    public b e() {
        return this.f;
    }

    private c() {
    }

    public void a(Context context, ISimpleSignInResponseHandler iSimpleSignInResponseHandler) {
        a.a(context.getApplicationContext());
        this.d = context;
        this.e = iSimpleSignInResponseHandler;
        this.f = a.a().a(context);
    }

    public String b() {
        if (!f()) {
            com.amazon.device.simplesignin.a.d.a.b(a, "Application context not initialized, SDK mode is unknown.");
            return com.amazon.device.simplesignin.a.b.a.UNKNOWN.name();
        } else if (a.a().b(this.d)) {
            return com.amazon.device.simplesignin.a.b.a.SANDBOX.name();
        } else {
            return com.amazon.device.simplesignin.a.b.a.PRODUCTION.name();
        }
    }

    public RequestId a(String str) {
        g();
        f.a(str, com.amazon.device.simplesignin.a.a.a.u);
        RequestId requestId = new RequestId();
        this.f.a(requestId, str);
        return requestId;
    }

    public RequestId a(LinkUserAccountRequest linkUserAccountRequest) {
        g();
        b(linkUserAccountRequest);
        RequestId requestId = new RequestId();
        this.f.a(requestId, linkUserAccountRequest);
        return requestId;
    }

    public RequestId a(Map<String, String> map) {
        g();
        if (!map.isEmpty()) {
            RequestId requestId = new RequestId();
            this.f.a(requestId, map);
            return requestId;
        }
        throw new IllegalArgumentException("loginNames must not be empty");
    }

    public RequestId b(String str) {
        g();
        f.a(str, com.amazon.device.simplesignin.a.a.a.u);
        RequestId requestId = new RequestId();
        this.f.b(requestId, str);
        return requestId;
    }

    private void g() {
        if (!f()) {
            com.amazon.device.simplesignin.a.d.a.b(a, "Simple Sign-In SDK not initialized.");
            throw c;
        }
    }

    private void b(LinkUserAccountRequest linkUserAccountRequest) {
        f.a(linkUserAccountRequest.getPartnerUserId(), com.amazon.device.simplesignin.a.a.a.v);
        f.a(linkUserAccountRequest.getIdentityProviderName(), com.amazon.device.simplesignin.a.a.a.u);
        f.a(linkUserAccountRequest.getUserLoginName(), "userLoginName");
        f.a((Object) linkUserAccountRequest.getAccountLinkType(), "accountLinkType");
        if (AccountLinkType.AMAZON_MANAGED.equals(linkUserAccountRequest.getAccountLinkType())) {
            f.a((Object) linkUserAccountRequest.getLinkToken(), "linkToken");
            f.a(linkUserAccountRequest.getLinkToken().getToken(), "linkToken.token");
            f.a(linkUserAccountRequest.getLinkToken().getSchema(), "linkToken.schema");
            f.a(linkUserAccountRequest.getLinkSigningKey(), "linkSigningKey");
        }
    }

    public void a(Context context, Intent intent) {
        this.f.a(context, intent);
    }
}
