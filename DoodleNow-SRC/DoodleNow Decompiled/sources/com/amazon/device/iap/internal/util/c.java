package com.amazon.device.iap.internal.util;

import com.amazon.a.a;
import com.amazon.a.a.o.b;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.a.e;
import com.amazon.device.iap.internal.a.f;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Receipt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ReceiptHelper */
public class c {
    private static final String a = "c";

    public static Receipt a(JSONObject jSONObject, String str, String str2) throws e, f, IllegalArgumentException {
        int i = AnonymousClass1.a[b(jSONObject).ordinal()];
        if (i == 1) {
            return c(jSONObject, str, str2);
        }
        if (i == 2) {
            return b(jSONObject, str, str2);
        }
        if (i != 3) {
            return e(jSONObject, str, str2);
        }
        return d(jSONObject, str, str2);
    }

    /* renamed from: com.amazon.device.iap.internal.util.c$1  reason: invalid class name */
    /* compiled from: ReceiptHelper */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.amazon.device.iap.internal.util.d[] r0 = com.amazon.device.iap.internal.util.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.amazon.device.iap.internal.util.d r1 = com.amazon.device.iap.internal.util.d.V1     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.amazon.device.iap.internal.util.d r1 = com.amazon.device.iap.internal.util.d.LEGACY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.amazon.device.iap.internal.util.d r1 = com.amazon.device.iap.internal.util.d.V2     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.amazon.device.iap.internal.util.d r1 = com.amazon.device.iap.internal.util.d.V3     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazon.device.iap.internal.util.c.AnonymousClass1.<clinit>():void");
        }
    }

    private static Receipt b(JSONObject jSONObject, String str, String str2) throws e, f {
        String optString = jSONObject.optString("signature");
        if (!com.amazon.a.a.o.f.a(optString)) {
            try {
                Receipt a2 = a(jSONObject);
                String str3 = str + "-" + a2.getReceiptId();
                boolean a3 = a.a(str3, optString);
                b.a(a, "stringToVerify/legacy:\n" + str3 + "\nsignature:\n" + optString);
                if (a3) {
                    return a2;
                }
                MetricsHelper.submitReceiptVerificationFailureMetrics(str2, str3, optString);
                throw new f(str2, str3, optString);
            } catch (JSONException e) {
                throw new e(str2, jSONObject.toString(), e);
            }
        } else {
            b.b(a, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", optString);
            throw new f(str2, (String) null, optString);
        }
    }

    private static Receipt a(JSONObject jSONObject) throws JSONException {
        String optString = jSONObject.optString("token");
        String string = jSONObject.getString("sku");
        ProductType valueOf = ProductType.valueOf(jSONObject.getString(b.k).toUpperCase());
        String optString2 = jSONObject.optString(b.P);
        Date date = null;
        Date b = a(optString2) ? null : b(optString2);
        String optString3 = jSONObject.optString(b.d);
        if (!a(optString3)) {
            date = b(optString3);
        }
        return new ReceiptBuilder().setReceiptId(optString).setSku(string).setProductType(valueOf).setPurchaseDate(b).setCancelDate(date).build();
    }

    private static Receipt c(JSONObject jSONObject, String str, String str2) throws e, f {
        String optString = jSONObject.optString(b.Z);
        String optString2 = jSONObject.optString("signature");
        Date date = null;
        if (!com.amazon.a.a.o.f.a(optString2)) {
            try {
                Receipt a2 = a(jSONObject);
                Object[] objArr = new Object[9];
                objArr[0] = PurchasingService.SDK_VERSION;
                objArr[1] = str;
                objArr[2] = optString;
                objArr[3] = a2.getProductType();
                objArr[4] = a2.getSku();
                objArr[5] = a2.getReceiptId();
                objArr[6] = str2;
                objArr[7] = ProductType.SUBSCRIPTION == a2.getProductType() ? a2.getPurchaseDate() : null;
                if (ProductType.SUBSCRIPTION == a2.getProductType()) {
                    date = a2.getCancelDate();
                }
                objArr[8] = date;
                String format = String.format("%s|%s|%s|%s|%s|%s|%s|%tQ|%tQ", objArr);
                String str3 = a;
                b.a(str3, "stringToVerify/v1:\n" + format + "\nsignature:\n" + optString2);
                if (a.a(format, optString2)) {
                    return a2;
                }
                MetricsHelper.submitReceiptVerificationFailureMetrics(str2, format, optString2);
                throw new f(str2, format, optString2);
            } catch (JSONException e) {
                throw new e(str2, jSONObject.toString(), e);
            }
        } else {
            String str4 = a;
            b.b(str4, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", optString2);
            throw new f(str2, (String) null, optString2);
        }
    }

    private static Receipt d(JSONObject jSONObject, String str, String str2) throws e, f {
        Date date;
        String optString = jSONObject.optString(b.Z);
        String optString2 = jSONObject.optString("signature");
        Date date2 = null;
        if (!com.amazon.a.a.o.f.a(optString2)) {
            try {
                String string = jSONObject.getString(b.E);
                String string2 = jSONObject.getString("sku");
                ProductType valueOf = ProductType.valueOf(jSONObject.getString(b.k).toUpperCase());
                String optString3 = jSONObject.optString(b.Q);
                if (a(optString3)) {
                    date = null;
                } else {
                    date = b(optString3);
                }
                String optString4 = jSONObject.optString(b.e);
                if (!a(optString4)) {
                    date2 = b(optString4);
                }
                Receipt build = new ReceiptBuilder().setReceiptId(string).setSku(string2).setProductType(valueOf).setPurchaseDate(date).setCancelDate(date2).build();
                String format = String.format("%s|%s|%s|%s|%s|%tQ|%tQ", new Object[]{str, optString, build.getProductType(), build.getSku(), build.getReceiptId(), build.getPurchaseDate(), build.getCancelDate()});
                b.a(a, "stringToVerify/v2:\n" + format + "\nsignature:\n" + optString2);
                if (a.a(format, optString2)) {
                    return build;
                }
                MetricsHelper.submitReceiptVerificationFailureMetrics(str2, format, optString2);
                throw new f(str2, format, optString2);
            } catch (JSONException e) {
                throw new e(str2, jSONObject.toString(), e);
            }
        } else {
            b.b(a, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", optString2);
            throw new f(str2, (String) null, optString2);
        }
    }

    private static Receipt e(JSONObject jSONObject, String str, String str2) throws e, f {
        Date date;
        String optString = jSONObject.optString(b.Z);
        String optString2 = jSONObject.optString("signature");
        Date date2 = null;
        if (!com.amazon.a.a.o.f.a(optString2)) {
            try {
                String string = jSONObject.getString(b.E);
                String string2 = jSONObject.getString("sku");
                String optString3 = jSONObject.optString(b.L, (String) null);
                String optString4 = jSONObject.optString(b.M, (String) null);
                ProductType valueOf = ProductType.valueOf(jSONObject.getString(b.k).toUpperCase());
                String optString5 = jSONObject.optString(b.Q);
                if (a(optString5)) {
                    date = null;
                } else {
                    date = b(optString5);
                }
                String optString6 = jSONObject.optString(b.e);
                Date b = a(optString6) ? null : b(optString6);
                String optString7 = jSONObject.optString(b.R);
                if (!a(optString7)) {
                    date2 = b(optString7);
                }
                Receipt build = new ReceiptBuilder().setReceiptId(string).setSku(string2).setProductType(valueOf).setPurchaseDate(date).setCancelDate(b).setDeferredDate(date2).setDeferredSku(optString4).setTermSku(optString3).build();
                String format = String.format("%s|%s|%s|%s|%s|%s|%s|%tQ|%tQ|%tQ", new Object[]{str, optString, build.getProductType(), build.getSku(), build.getReceiptId(), build.getDeferredSku(), build.getTermSku(), build.getPurchaseDate(), build.getCancelDate(), build.getDeferredDate()});
                b.a(a, "stringToVerify/v3:\n" + format + "\nsignature:\n" + optString2);
                if (a.a(format, optString2)) {
                    return build;
                }
                MetricsHelper.submitReceiptVerificationFailureMetrics(str2, format, optString2);
                throw new f(str2, format, optString2);
            } catch (JSONException e) {
                throw new e(str2, jSONObject.toString(), e);
            }
        } else {
            b.b(a, "a signature was not found in the receipt for request ID " + str2);
            MetricsHelper.submitReceiptVerificationFailureMetrics(str2, "NO Signature found", optString2);
            throw new f(str2, (String) null, optString2);
        }
    }

    protected static boolean a(String str) {
        return str == null || str.trim().length() == 0;
    }

    protected static Date b(String str) throws JSONException {
        try {
            Date parse = new SimpleDateFormat(b.ag).parse(str);
            if (0 == parse.getTime()) {
                return null;
            }
            return parse;
        } catch (ParseException e) {
            throw new JSONException(e.getMessage());
        }
    }

    private static d b(JSONObject jSONObject) {
        String optString = jSONObject.optString(b.Z);
        String optString2 = jSONObject.optString(b.E);
        String optString3 = jSONObject.optString(b.N);
        if (!com.amazon.a.a.o.f.a(optString3) && optString3.equals(d.V3.name())) {
            return d.V3;
        }
        if (!com.amazon.a.a.o.f.a(optString2)) {
            return d.V2;
        }
        if (com.amazon.a.a.o.f.a(optString)) {
            return d.LEGACY;
        }
        return d.V1;
    }

    protected static JSONObject a(Receipt receipt, String str) {
        JSONObject jSONObject = new JSONObject();
        if (receipt != null && !com.amazon.a.a.o.f.a(str)) {
            try {
                jSONObject.put(b.E, receipt.getReceiptId());
                jSONObject.put("sku", receipt.getSku());
                jSONObject.put(b.k, receipt.getProductType());
                jSONObject.put(b.Q, receipt.getPurchaseDate());
                jSONObject.put(b.d, receipt.getCancelDate());
                jSONObject.put("signature", str);
            } catch (JSONException unused) {
                String str2 = a;
                b.b(str2, "Failure during toJsonInternal: " + receipt + ", signature:" + str);
            }
        }
        return jSONObject;
    }

    public static String b(Receipt receipt, String str) {
        try {
            return a(receipt, str).toString(4);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static List<Receipt> a(String str, String str2, String str3) throws JSONException, e, f, IllegalArgumentException {
        if (str2 == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = new JSONArray(str2);
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                arrayList.add(a(jSONArray.getJSONObject(i), str, str3));
                i++;
            } catch (e e) {
                String str4 = a;
                b.b(str4, "fail to parse receipt, requestId:" + e.a());
                throw e;
            } catch (f e2) {
                String str5 = a;
                b.b(str5, "fail to verify receipt, requestId:" + e2.a());
                throw e2;
            } catch (Throwable th) {
                String str6 = a;
                b.b(str6, "fail to verify receipt, requestId:" + th.getMessage());
                throw th;
            }
        }
        return arrayList;
    }
}
