package com.amazon.device.drm.a.b;

import android.content.Context;
import android.os.Handler;
import com.amazon.a.a.j.a;
import com.amazon.a.a.n.a.h;
import com.amazon.a.a.o.f;
import com.amazon.device.drm.LicensingListener;
import com.amazon.device.drm.a.d;
import com.amazon.device.drm.model.LicenseResponse;
import com.amazon.device.drm.model.RequestId;

/* compiled from: KiwiRequest */
public class b extends a {
    /* access modifiers changed from: private */
    public static final String c = "b";
    private final RequestId d;

    public void b() {
    }

    public void c() {
    }

    public RequestId d() {
        return this.d;
    }

    public b(RequestId requestId) {
        this.d = requestId;
    }

    /* access modifiers changed from: protected */
    public void a(h hVar) {
        this.b = hVar;
    }

    /* access modifiers changed from: protected */
    public void a(final Object obj) {
        f.a(obj, "response");
        Context c2 = d.d().c();
        final LicensingListener b = d.d().b();
        if (c2 == null || b == null) {
            String str = c;
            com.amazon.device.drm.a.e.b.a(str, "LicensingListener is not set. Dropping response: " + obj);
            return;
        }
        new Handler(c2.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    Object obj = obj;
                    if (obj instanceof LicenseResponse) {
                        b.onLicenseCommandResponse((LicenseResponse) obj);
                        return;
                    }
                    String f = b.c;
                    com.amazon.device.drm.a.e.b.b(f, "Unknown response type:" + obj.getClass().getName());
                } catch (Throwable th) {
                    String f2 = b.c;
                    com.amazon.device.drm.a.e.b.b(f2, "Error in sendResponse: " + th);
                }
            }
        });
    }

    public com.amazon.a.a.j.b a() {
        return this.a;
    }

    public void e() {
        if (this.b != null) {
            this.b.l();
        } else {
            b();
        }
    }
}
