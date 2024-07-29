package com.amazon.device.drm.a.a;

import android.app.Application;
import android.os.RemoteException;
import com.amazon.a.a.h.c;
import com.amazon.a.a.n.a.a.f;
import com.amazon.a.a.n.a.a.i;
import com.amazon.a.a.n.a.h;
import com.amazon.a.a.o.b.b;
import com.amazon.a.b.g;
import com.amazon.d.a.j;
import com.amazon.device.drm.LicensingService;
import com.amazon.device.drm.model.LicenseResponse;
import com.bleplx.adapter.utils.Constants;

/* compiled from: GetLicenseCommand */
public class a extends h {
    private static final String c = "a";
    private static final String d = "get_license";
    private static final String e = "1.0";
    @com.amazon.a.a.k.a
    c b;
    @com.amazon.a.a.k.a
    private Application f;
    @com.amazon.a.a.k.a
    private b g;

    /* access modifiers changed from: protected */
    public boolean f() {
        return false;
    }

    public a(com.amazon.device.drm.a.b.b bVar) {
        super(bVar, d, "1.0", bVar.d().toString(), LicensingService.SDK_VERSION);
        b(false);
    }

    /* access modifiers changed from: protected */
    public boolean b(j jVar) throws RemoteException, com.amazon.a.a.d.b {
        String str = c;
        com.amazon.device.drm.a.e.b.a(str, "onResult: result = " + jVar);
        try {
            g gVar = new g(jVar.b());
            if (!a(gVar, a(gVar))) {
                return false;
            }
            com.amazon.device.drm.a.e.b.a(str, "License Verification was successful");
            this.b.a(new com.amazon.a.b.b.a());
            a(LicenseResponse.RequestStatus.LICENSED);
            return true;
        } catch (Exception unused) {
            com.amazon.device.drm.a.e.b.a(c, "License not returned by Appstore");
            a(LicenseResponse.RequestStatus.NOT_LICENSED);
            return false;
        }
    }

    private void a(LicenseResponse.RequestStatus requestStatus) {
        com.amazon.device.drm.a.b.b bVar = (com.amazon.device.drm.a.b.b) j();
        bVar.a().a((Object) new com.amazon.device.drm.a.c.a().a(bVar.d()).a(requestStatus).a());
    }

    private boolean a(g gVar, com.amazon.a.b.b bVar) {
        if (bVar == null) {
            return false;
        }
        try {
            com.amazon.device.drm.a.e.a.a(gVar, bVar, this.f);
            return true;
        } catch (com.amazon.a.b.a.a e2) {
            if (e2.d().a(com.amazon.a.b.h.EXPIRATION)) {
                com.amazon.device.drm.a.e.b.a(c, "License has expired");
                this.b.a(a((com.amazon.a.a.d.b) e2));
                a(LicenseResponse.RequestStatus.EXPIRED);
            } else {
                String str = c;
                com.amazon.device.drm.a.e.b.a(str, "License Verification failed" + e2.d());
                this.b.a(a((com.amazon.a.a.d.b) e2));
                a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
            }
            return false;
        }
    }

    private com.amazon.a.b.b a(g gVar) {
        try {
            return com.amazon.device.drm.a.e.a.a(gVar, this.g.a());
        } catch (com.amazon.a.a.o.b.a.c e2) {
            com.amazon.device.drm.a.e.b.a(c, "Unable to decode the license with the public key provided by the developer");
            a(LicenseResponse.RequestStatus.ERROR_INVALID_LICENSING_KEYS);
            this.b.a(a((com.amazon.a.a.d.b) e2));
            return null;
        } catch (com.amazon.a.a.o.b.a.b e3) {
            com.amazon.device.drm.a.e.b.a(c, "Unable to parse the license returned by Appstore Client");
            a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
            this.b.a(a((com.amazon.a.a.d.b) e3));
            return null;
        } catch (com.amazon.a.a.o.b.a.a e4) {
            com.amazon.device.drm.a.e.b.a(c, "Unable to load the public key from the apk");
            a(LicenseResponse.RequestStatus.ERROR_INVALID_LICENSING_KEYS);
            this.b.a(a((com.amazon.a.a.d.b) e4));
            return null;
        } catch (Exception unused) {
            com.amazon.device.drm.a.e.b.a(c, "Content License returned from Appstore is not in proper format");
            a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void b(com.amazon.d.a.h hVar) {
        String str;
        try {
            str = hVar.g();
            try {
                com.amazon.a.a.n.a.g valueOf = com.amazon.a.a.n.a.g.valueOf(str);
                switch (AnonymousClass1.a[valueOf.ordinal()]) {
                    case 1:
                        com.amazon.device.drm.a.e.b.a(c, String.format("License has expired: %s", new Object[]{valueOf.name()}));
                        a(LicenseResponse.RequestStatus.EXPIRED);
                        return;
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        com.amazon.device.drm.a.e.b.a(c, String.format("Customer is not licensed to use the Application: %s", new Object[]{valueOf.name()}));
                        a(LicenseResponse.RequestStatus.NOT_LICENSED);
                        return;
                    case 10:
                    case 11:
                        com.amazon.device.drm.a.e.b.a(c, String.format("Unable to verify Device info: %s", new Object[]{valueOf.name()}));
                        a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
                        return;
                    case 12:
                    case 13:
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                        com.amazon.device.drm.a.e.b.a(c, String.format("Unable to verify Application metadata: %s", new Object[]{valueOf.name()}));
                        a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
                        return;
                    default:
                        com.amazon.device.drm.a.e.b.a(c, "No valid failure reason found. Defaulting to UNKNOWN_ERROR");
                        a(LicenseResponse.RequestStatus.UNKNOWN_ERROR);
                        return;
                }
            } catch (Exception unused) {
                String str2 = c;
                com.amazon.device.drm.a.e.b.a(str2, "Unknown Reason of failure" + str);
                this.b.a(a((com.amazon.a.a.d.b) new i(d)));
            }
        } catch (Exception unused2) {
            str = Constants.BluetoothState.UNKNOWN;
            String str22 = c;
            com.amazon.device.drm.a.e.b.a(str22, "Unknown Reason of failure" + str);
            this.b.a(a((com.amazon.a.a.d.b) new i(d)));
        }
    }

    /* renamed from: com.amazon.device.drm.a.a.a$1  reason: invalid class name */
    /* compiled from: GetLicenseCommand */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|36) */
        /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.amazon.a.a.n.a.g[] r0 = com.amazon.a.a.n.a.g.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.CLA_LICENSE_EXPIRED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.SLA_NO_LICENSE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.CLA_NOT_ENTITLED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.CLA_NOT_LOGGED_IN     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.SLA_NO_CUSTOMER_ID     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.CLA_LICENSE_INVALID     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.CLA_NO_VALID_LICENSE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.VLA_NOT_LOGGED_IN     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.VLIA_NOT_LOGGED_IN     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.CLA_NO_DEVICE_ID     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.SLA_NO_DEVICE_ID     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.CLA_NO_CONTENT_ID     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.CSA_INVALID_CHECKSUM     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.CSA_INVALID_SIGNATURE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.CSA_NO_CONTENT_METADATA     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.CSA_CONTENT_MD_PKG_NAME_MISMATCH     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.amazon.a.a.n.a.g r1 = com.amazon.a.a.n.a.g.CLA_NULL_LOCKER_RESPONSE     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazon.device.drm.a.a.a.AnonymousClass1.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public void c(com.amazon.a.a.d.b bVar) {
        String str;
        String a = bVar.a();
        if (f.a.equals(a)) {
            String b2 = bVar.b();
            switch (b2.hashCode()) {
                case -1023164887:
                    if (b2.equals("INVALID_CONTENT_ID")) {
                        com.amazon.device.drm.a.e.b.a(c, "Unable to verify Application metadata");
                        a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
                        return;
                    }
                    break;
                case 375605247:
                    str = "NO_INTERNET";
                    break;
                case 433141802:
                    str = "UNKNOWN";
                    break;
                case 2056521148:
                    str = "INTERNAL_SERVICE_ERROR";
                    break;
            }
            boolean equals = b2.equals(str);
            com.amazon.device.drm.a.e.b.a(c, "No valid failure reason found. Defaulting to UNKNOWN_ERROR");
            a(LicenseResponse.RequestStatus.UNKNOWN_ERROR);
        } else if (com.amazon.a.a.n.a.a.a.a.equals(a)) {
            com.amazon.device.drm.a.e.b.a(c, "AuthToken verification failed");
            a(LicenseResponse.RequestStatus.ERROR_VERIFICATION);
        } else if (com.amazon.a.a.o.b.a.a.a.equals(a)) {
            com.amazon.device.drm.a.e.b.a(c, "Unable to load the public key from the apk");
            a(LicenseResponse.RequestStatus.ERROR_INVALID_LICENSING_KEYS);
        }
    }
}
