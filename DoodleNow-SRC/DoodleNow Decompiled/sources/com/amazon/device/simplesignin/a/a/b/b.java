package com.amazon.device.simplesignin.a.a.b;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.amazon.a.a.k.a;
import com.amazon.a.a.n.b.d;
import com.amazon.d.a.j;
import com.amazon.device.simplesignin.model.AccountLinkType;
import com.amazon.device.simplesignin.model.Link;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.request.LinkUserAccountRequest;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LinkUserAccountCommand */
public class b extends c {
    private static final String d = "SSI_LinkUserAccount";
    private static final String e = "1.0";
    /* access modifiers changed from: private */
    public static final String f = "b";
    @a
    protected com.amazon.a.a.n.b b;
    @a
    protected com.amazon.a.a.a.a c;

    b(a aVar, LinkUserAccountRequest linkUserAccountRequest) {
        super(aVar, d, "1.0");
        super.a(com.amazon.device.simplesignin.a.a.a.d, linkUserAccountRequest.getPartnerUserId());
        super.a(com.amazon.device.simplesignin.a.a.a.a, linkUserAccountRequest.getIdentityProviderName());
        super.a(com.amazon.device.simplesignin.a.a.a.e, linkUserAccountRequest.getUserLoginName());
        super.a(com.amazon.device.simplesignin.a.a.a.h, linkUserAccountRequest.getAccountLinkType().toString());
        if (AccountLinkType.AMAZON_MANAGED.equals(linkUserAccountRequest.getAccountLinkType())) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("token", linkUserAccountRequest.getLinkToken().getToken());
                jSONObject.put(com.amazon.device.simplesignin.a.a.a.A, linkUserAccountRequest.getLinkToken().getSchema());
                super.a(com.amazon.device.simplesignin.a.a.a.g, jSONObject.toString());
                super.a(com.amazon.device.simplesignin.a.a.a.f, linkUserAccountRequest.getLinkSigningKey());
            } catch (JSONException e2) {
                String str = f;
                com.amazon.device.simplesignin.a.d.a.b(str, "Unable to create linkToken json " + e2);
                throw new IllegalStateException("Unable to create linkToken json", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws RemoteException {
        Map b2 = jVar.b();
        if (b2.containsKey(com.amazon.device.simplesignin.a.a.a.i) && b2.get(com.amazon.device.simplesignin.a.a.a.i) != null) {
            a((Intent) b2.get(com.amazon.device.simplesignin.a.a.a.i));
            return true;
        } else if (!b2.containsKey(com.amazon.device.simplesignin.a.a.a.j) || b2.get(com.amazon.device.simplesignin.a.a.a.j) == null) {
            super.a(RequestStatus.FAILURE);
            return false;
        } else {
            String str = (String) b2.get(com.amazon.device.simplesignin.a.a.a.k);
            Link a = com.amazon.device.simplesignin.a.d.b.a((String) b2.get(com.amazon.device.simplesignin.a.a.a.j));
            if (a == null) {
                a(RequestStatus.FAILURE);
                return false;
            }
            super.a(RequestStatus.SUCCESSFUL, a, LinkUserAccountResponse.SuccessCode.valueOf(str));
            return true;
        }
    }

    private void a(final Intent intent) {
        this.b.b(d.FOREGROUND, new com.amazon.a.a.n.a() {
            public void a() {
                try {
                    Activity b2 = b.this.c.b();
                    if (b2 == null) {
                        b2 = b.this.c.a();
                    }
                    String p = b.f;
                    com.amazon.device.simplesignin.a.d.a.a(p, "Consent activity is about to start: " + b2);
                    b2.startActivity(intent);
                } catch (Exception e) {
                    String p2 = b.f;
                    com.amazon.device.simplesignin.a.d.a.a(p2, "Exception when starting consent activity: " + e);
                }
            }
        });
    }
}
