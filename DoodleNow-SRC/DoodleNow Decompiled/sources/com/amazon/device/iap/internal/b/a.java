package com.amazon.device.iap.internal.b;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.d;
import com.amazon.device.iap.internal.util.b;
import com.revenuecat.purchases.common.Constants;

/* compiled from: EntitlementTracker */
public class a {
    private static a a = new a();
    private static final String b = "a";
    private static final String c = (a.class.getName() + "_PREFS_");

    public static a a() {
        return a;
    }

    public void a(String str, String str2, String str3) {
        String str4 = b;
        b.a(str4, "enter saveEntitlementRecord for v1 Entitlement [" + str2 + "/" + str3 + "], user [" + str + "]");
        try {
            f.a(str, "userId");
            f.a(str2, com.amazon.a.a.o.b.E);
            f.a(str3, "sku");
            Context b2 = d.e().b();
            f.a((Object) b2, "context");
            SharedPreferences.Editor edit = b2.getSharedPreferences(c + str, 0).edit();
            edit.putString(str3, str2);
            edit.commit();
        } catch (Throwable th) {
            String str5 = b;
            b.a(str5, "error in saving v1 Entitlement:" + str2 + "/" + str3 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + th.getMessage());
        }
        String str6 = b;
        b.a(str6, "leaving saveEntitlementRecord for v1 Entitlement [" + str2 + "/" + str3 + "], user [" + str + "]");
    }

    public String a(String str, String str2) {
        String str3 = b;
        b.a(str3, "enter getReceiptIdFromSku for sku [" + str2 + "], user [" + str + "]");
        String str4 = null;
        try {
            f.a(str, "userId");
            f.a(str2, "sku");
            Context b2 = d.e().b();
            f.a((Object) b2, "context");
            str4 = b2.getSharedPreferences(c + str, 0).getString(str2, (String) null);
        } catch (Throwable th) {
            String str5 = b;
            b.a(str5, "error in saving v1 Entitlement:" + str2 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + th.getMessage());
        }
        String str6 = b;
        b.a(str6, "leaving saveEntitlementRecord for sku [" + str2 + "], user [" + str + "]");
        return str4;
    }
}
