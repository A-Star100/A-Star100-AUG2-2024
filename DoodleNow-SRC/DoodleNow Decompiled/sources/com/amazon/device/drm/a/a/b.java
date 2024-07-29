package com.amazon.device.drm.a.a;

import com.amazon.a.a.n.a.h;
import com.amazon.device.drm.a.c.a;
import com.amazon.device.drm.model.LicenseResponse;
import com.amazon.device.drm.model.RequestId;

/* compiled from: GetLicenseRequest */
public final class b extends com.amazon.device.drm.a.b.b {
    private static final String c = "b";

    public b(RequestId requestId) {
        super(requestId);
        a((h) new a(this));
    }

    public void b() {
        a((Object) (LicenseResponse) a().b());
    }

    public void c() {
        LicenseResponse licenseResponse = (LicenseResponse) a().b();
        if (licenseResponse == null) {
            licenseResponse = new a().a(d()).a(LicenseResponse.RequestStatus.UNKNOWN_ERROR).a();
        }
        String str = c;
        com.amazon.device.drm.a.e.b.b(str, "LicenseRequest failed with error: " + licenseResponse.getRequestStatus());
        a((Object) licenseResponse);
    }
}
