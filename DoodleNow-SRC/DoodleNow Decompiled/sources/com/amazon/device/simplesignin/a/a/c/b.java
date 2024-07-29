package com.amazon.device.simplesignin.a.a.c;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import com.amazon.a.a.k.a;
import com.amazon.d.a.j;
import com.amazon.device.simplesignin.a.a.c;
import com.amazon.device.simplesignin.a.a.d;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.ShowLoginSelectionResponse;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ShowLoginSelectionCommand */
public class b extends c {
    /* access modifiers changed from: private */
    public static final String d = "a";
    private static final String e = "SSI_ShowLoginSelection";
    private static final String f = "1.0";
    @a
    protected com.amazon.a.a.n.b b;
    @a
    protected com.amazon.a.a.a.a c;
    private final Map<String, String> g;

    static {
        Class<a> cls = a.class;
    }

    b(a aVar, Map<String, String> map) {
        super(aVar, e, "1.0");
        this.g = map;
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws RemoteException {
        Map b2 = jVar.b();
        if (!b2.containsKey(com.amazon.device.simplesignin.a.a.a.n)) {
            a(RequestStatus.FAILURE);
            return false;
        }
        Intent intent = (Intent) b2.get(com.amazon.device.simplesignin.a.a.a.n);
        if (intent == null) {
            a(RequestStatus.FAILURE);
            return false;
        }
        intent.putExtra(com.amazon.device.simplesignin.a.a.a.m, new HashMap(this.g));
        a(intent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(RequestStatus requestStatus) {
        ShowLoginSelectionResponse showLoginSelectionResponse = new ShowLoginSelectionResponse();
        showLoginSelectionResponse.setRequestId(((d) j()).e());
        if (RequestStatus.INVALID_LINK_SIGNING_KEY_ENCRYPTION.equals(requestStatus) || RequestStatus.INVALID_LINK_SIGNING_KEY.equals(requestStatus)) {
            showLoginSelectionResponse.setRequestStatus(RequestStatus.FAILURE);
            return;
        }
        showLoginSelectionResponse.setRequestStatus(requestStatus);
        super.a((Object) showLoginSelectionResponse);
    }

    private void a(final Intent intent) {
        this.b.b(com.amazon.a.a.n.b.d.FOREGROUND, new com.amazon.a.a.n.a() {
            public void a() {
                try {
                    Activity b2 = b.this.c.b();
                    if (b2 == null) {
                        b2 = b.this.c.a();
                    }
                    com.amazon.device.simplesignin.a.d.a.a(b.d, "ShowLoginSelection activity initiated through startActivity");
                    b2.startActivity(intent);
                } catch (Exception e) {
                    String p = b.d;
                    com.amazon.device.simplesignin.a.d.a.a(p, "Exception when starting show login selection activity: " + e);
                }
            }
        });
    }
}
