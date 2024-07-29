package com.amazon.device.simplesignin.a.a;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import com.amazon.a.a.n.a.h;
import com.amazon.device.simplesignin.ISimpleSignInResponseHandler;
import com.amazon.device.simplesignin.a.d.a;
import com.amazon.device.simplesignin.model.RequestStatus;
import com.amazon.device.simplesignin.model.response.GetUserAndLinksResponse;
import com.amazon.device.simplesignin.model.response.LinkUserAccountResponse;
import com.amazon.device.simplesignin.model.response.ShowLoginSelectionResponse;
import com.amazon.device.simplesignin.model.response.UnlinkUserAccountResponse;

/* compiled from: SSIKiwiCommandBase */
public abstract class c extends h {
    /* access modifiers changed from: private */
    public static final String b = "c";

    /* access modifiers changed from: protected */
    public abstract void a(RequestStatus requestStatus);

    public c(d dVar, String str, String str2) {
        super(dVar, str, str2, dVar.e().toString(), "1.0.0");
        super.b(false);
    }

    public void b(com.amazon.d.a.h hVar) {
        try {
            String g = hVar.g();
            if (a.B.equals(g)) {
                a(RequestStatus.NOT_SUPPORTED);
            } else if (a.E.equals(g)) {
                a(RequestStatus.NOT_AVAILABLE);
            } else if (a.C.equals(g)) {
                a(RequestStatus.DUPLICATE_REQUEST);
            } else if (a.D.equals(g)) {
                a(RequestStatus.FEATURE_TURNED_OFF);
            } else if (a.F.equals(g)) {
                a(RequestStatus.RETRYABLE_FAILURE);
            } else if (a.G.equals(g)) {
                a(RequestStatus.INVALID_LINK_SIGNING_KEY_ENCRYPTION);
            } else {
                if (a.H.equals(g)) {
                    a(RequestStatus.INVALID_LINK_SIGNING_KEY);
                    return;
                }
                a(RequestStatus.FAILURE);
            }
        } catch (RemoteException unused) {
            a.b(b, "Exception while fetching reason for failure");
        }
    }

    /* access modifiers changed from: protected */
    public void a(final Object obj) {
        if (obj != null) {
            String str = b;
            a.a(str, "Response type received: " + obj.getClass().getSimpleName());
            Context c = com.amazon.device.simplesignin.a.c.a().c();
            final ISimpleSignInResponseHandler d = com.amazon.device.simplesignin.a.c.a().d();
            if (c == null || d == null) {
                a.a(str, "Dropping the response as context of response handler is null.");
                return;
            }
            new Handler(c.getMainLooper()).post(new Runnable() {
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
                            String o = c.b;
                            a.b(o, "Unknown response type:" + obj.getClass().getName());
                        }
                    } catch (Exception e) {
                        String o2 = c.b;
                        a.b(o2, "Error in sending response to callback: " + e);
                    }
                }
            });
            return;
        }
        throw new NullPointerException("response is marked non-null but is null");
    }
}
