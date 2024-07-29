package com.amazon.device.iap.internal.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.internal.util.b;
import com.amazon.device.iap.internal.util.c;
import com.amazon.device.iap.model.Receipt;
import com.revenuecat.purchases.common.Constants;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PendingReceiptsManager */
public class d {
    /* access modifiers changed from: private */
    public static final String a = "d";
    /* access modifiers changed from: private */
    public static final String b;
    private static final String c;
    private static final String d = "LAST_CLEANING_TIME";
    /* access modifiers changed from: private */
    public static int e = 604800000;
    private static final d f = new d();

    public static d a() {
        return f;
    }

    static {
        StringBuilder sb = new StringBuilder();
        Class<d> cls = d.class;
        sb.append(cls.getName());
        sb.append("_PREFS");
        b = sb.toString();
        c = cls.getName() + "_CLEANER_PREFS";
    }

    public void a(String str, String str2, String str3, String str4) {
        String str5 = a;
        b.a(str5, "enter saveReceipt for receipt [" + str4 + "]");
        try {
            f.a(str2, "userId");
            f.a(str3, com.amazon.a.a.o.b.E);
            f.a(str4, "receiptString");
            Context b2 = com.amazon.device.iap.internal.d.e().b();
            f.a((Object) b2, "context");
            c cVar = new c(str2, str4, str, System.currentTimeMillis());
            SharedPreferences.Editor edit = b2.getSharedPreferences(b, 0).edit();
            edit.putString(str3, cVar.e());
            edit.commit();
        } catch (Throwable th) {
            String str6 = a;
            b.a(str6, "error in saving pending receipt:" + str + "/" + str4 + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + th.getMessage());
        }
        String str7 = a;
        b.a(str7, "leaving saveReceipt for receipt id [" + str3 + "]");
    }

    private void e() {
        b.a(a, "enter old receipts cleanup! ");
        final Context b2 = com.amazon.device.iap.internal.d.e().b();
        f.a((Object) b2, "context");
        a(System.currentTimeMillis());
        new Handler().post(new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|19) */
            /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
                r4 = com.amazon.device.iap.internal.b.d.b();
                com.amazon.device.iap.internal.util.b.a(r4, "house keeping - try remove Receipt:" + r3 + " since it's invalid ");
                r9.b.a(r3);
             */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x006a */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r9 = this;
                    java.lang.String r0 = "house keeping - try remove Receipt:"
                    java.lang.String r1 = com.amazon.device.iap.internal.b.d.a     // Catch:{ all -> 0x008b }
                    java.lang.String r2 = "perform house keeping! "
                    com.amazon.device.iap.internal.util.b.a(r1, r2)     // Catch:{ all -> 0x008b }
                    android.content.Context r1 = r0     // Catch:{ all -> 0x008b }
                    java.lang.String r2 = com.amazon.device.iap.internal.b.d.b     // Catch:{ all -> 0x008b }
                    r3 = 0
                    android.content.SharedPreferences r1 = r1.getSharedPreferences(r2, r3)     // Catch:{ all -> 0x008b }
                    java.util.Map r2 = r1.getAll()     // Catch:{ all -> 0x008b }
                    java.util.Set r2 = r2.keySet()     // Catch:{ all -> 0x008b }
                    java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x008b }
                L_0x0022:
                    boolean r3 = r2.hasNext()     // Catch:{ all -> 0x008b }
                    if (r3 == 0) goto L_0x00a1
                    java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x008b }
                    java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x008b }
                    r4 = 0
                    java.lang.String r4 = r1.getString(r3, r4)     // Catch:{ b -> 0x006a }
                    com.amazon.device.iap.internal.b.c r4 = com.amazon.device.iap.internal.b.c.a(r4)     // Catch:{ b -> 0x006a }
                    long r5 = java.lang.System.currentTimeMillis()     // Catch:{ b -> 0x006a }
                    long r7 = r4.d()     // Catch:{ b -> 0x006a }
                    long r5 = r5 - r7
                    int r4 = com.amazon.device.iap.internal.b.d.e     // Catch:{ b -> 0x006a }
                    long r7 = (long) r4     // Catch:{ b -> 0x006a }
                    int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                    if (r4 <= 0) goto L_0x0022
                    java.lang.String r4 = com.amazon.device.iap.internal.b.d.a     // Catch:{ b -> 0x006a }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ b -> 0x006a }
                    r5.<init>()     // Catch:{ b -> 0x006a }
                    r5.append(r0)     // Catch:{ b -> 0x006a }
                    r5.append(r3)     // Catch:{ b -> 0x006a }
                    java.lang.String r6 = " since it's too old"
                    r5.append(r6)     // Catch:{ b -> 0x006a }
                    java.lang.String r5 = r5.toString()     // Catch:{ b -> 0x006a }
                    com.amazon.device.iap.internal.util.b.a(r4, r5)     // Catch:{ b -> 0x006a }
                    com.amazon.device.iap.internal.b.d r4 = com.amazon.device.iap.internal.b.d.this     // Catch:{ b -> 0x006a }
                    r4.a((java.lang.String) r3)     // Catch:{ b -> 0x006a }
                    goto L_0x0022
                L_0x006a:
                    java.lang.String r4 = com.amazon.device.iap.internal.b.d.a     // Catch:{ all -> 0x008b }
                    java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
                    r5.<init>()     // Catch:{ all -> 0x008b }
                    r5.append(r0)     // Catch:{ all -> 0x008b }
                    r5.append(r3)     // Catch:{ all -> 0x008b }
                    java.lang.String r6 = " since it's invalid "
                    r5.append(r6)     // Catch:{ all -> 0x008b }
                    java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x008b }
                    com.amazon.device.iap.internal.util.b.a(r4, r5)     // Catch:{ all -> 0x008b }
                    com.amazon.device.iap.internal.b.d r4 = com.amazon.device.iap.internal.b.d.this     // Catch:{ all -> 0x008b }
                    r4.a((java.lang.String) r3)     // Catch:{ all -> 0x008b }
                    goto L_0x0022
                L_0x008b:
                    r0 = move-exception
                    java.lang.String r1 = com.amazon.device.iap.internal.b.d.a
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    java.lang.String r3 = "Error in running cleaning job:"
                    r2.<init>(r3)
                    r2.append(r0)
                    java.lang.String r0 = r2.toString()
                    com.amazon.device.iap.internal.util.b.a(r1, r0)
                L_0x00a1:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.amazon.device.iap.internal.b.d.AnonymousClass1.run():void");
            }
        });
    }

    public void a(String str) {
        String str2 = a;
        b.a(str2, "enter removeReceipt for receipt[" + str + "]");
        Context b2 = com.amazon.device.iap.internal.d.e().b();
        f.a((Object) b2, "context");
        SharedPreferences.Editor edit = b2.getSharedPreferences(b, 0).edit();
        edit.remove(str);
        edit.commit();
        b.a(str2, "leave removeReceipt for receipt[" + str + "]");
    }

    private long f() {
        Context b2 = com.amazon.device.iap.internal.d.e().b();
        f.a((Object) b2, "context");
        long currentTimeMillis = System.currentTimeMillis();
        long j = b2.getSharedPreferences(c, 0).getLong(d, 0);
        if (j != 0) {
            return j;
        }
        a(currentTimeMillis);
        return currentTimeMillis;
    }

    private void a(long j) {
        Context b2 = com.amazon.device.iap.internal.d.e().b();
        f.a((Object) b2, "context");
        SharedPreferences.Editor edit = b2.getSharedPreferences(c, 0).edit();
        edit.putLong(d, j);
        edit.commit();
    }

    public Set<Receipt> b(String str) {
        Context b2 = com.amazon.device.iap.internal.d.e().b();
        f.a((Object) b2, "context");
        String str2 = a;
        b.a(str2, "enter getLocalReceipts for user[" + str + "]");
        HashSet hashSet = new HashSet();
        if (!f.a(str)) {
            Map<String, ?> all = b2.getSharedPreferences(b, 0).getAll();
            for (String next : all.keySet()) {
                String str3 = (String) all.get(next);
                try {
                    c a2 = c.a(str3);
                    hashSet.add(c.a(new JSONObject(a2.c()), str, a2.b()));
                } catch (com.amazon.device.iap.internal.a.f unused) {
                    a(next);
                    String str4 = a;
                    b.b(str4, "failed to verify signature:[" + str3 + "]");
                } catch (JSONException unused2) {
                    a(next);
                    String str5 = a;
                    b.b(str5, "failed to convert string to JSON object:[" + str3 + "]");
                } catch (Throwable unused3) {
                    String str6 = a;
                    b.b(str6, "failed to load the receipt from SharedPreference:[" + str3 + "]");
                }
            }
            String str7 = a;
            b.a(str7, "leaving getLocalReceipts for user[" + str + "], " + hashSet.size() + " local receipts found.");
            if (System.currentTimeMillis() - f() > ((long) e)) {
                e();
            }
            return hashSet;
        }
        b.b(str2, "empty UserId: " + str);
        throw new RuntimeException("Invalid UserId:" + str);
    }

    public String c(String str) {
        Context b2 = com.amazon.device.iap.internal.d.e().b();
        f.a((Object) b2, "context");
        if (!f.a(str)) {
            String string = b2.getSharedPreferences(b, 0).getString(str, (String) null);
            if (string != null) {
                try {
                    return c.a(string).b();
                } catch (b unused) {
                }
            }
            return null;
        }
        String str2 = a;
        b.b(str2, "empty receiptId: " + str);
        throw new RuntimeException("Invalid ReceiptId:" + str);
    }
}
