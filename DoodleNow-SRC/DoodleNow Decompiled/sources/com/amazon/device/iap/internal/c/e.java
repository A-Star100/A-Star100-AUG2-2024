package com.amazon.device.iap.internal.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.d;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.internal.util.a;
import com.amazon.device.iap.internal.util.b;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Promotion;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataResponse;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SandboxRequestHandler */
public final class e implements com.amazon.device.iap.internal.e {
    /* access modifiers changed from: private */
    public static final String a = "e";
    private static final String b = "com.amazon.sdktestclient";
    private static final String c = "com.amazon.sdktestclient.command.CommandBroker";

    public void a(RequestId requestId) {
        b.a(a, "sendGetUserDataRequest");
        a(requestId.toString(), false, false);
    }

    private void a(String str, boolean z, boolean z2) {
        try {
            Context b2 = d.e().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, str);
            jSONObject.put("packageName", b2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            jSONObject.put(b.as, z);
            jSONObject.put(b.at, z2);
            bundle.putString("userInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.iap.appUserId");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            b2.startService(a2);
        } catch (JSONException unused) {
            b.b(a, "Error in sendGetUserDataRequest.");
        }
    }

    public void a(RequestId requestId, String str) {
        b.a(a, "sendPurchaseRequest");
        try {
            Context b2 = d.e().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sku", str);
            jSONObject.put(com.amazon.a.a.o.b.B, requestId.toString());
            jSONObject.put("packageName", b2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            bundle.putString("purchaseInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.iap.purchase");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            b2.startService(a2);
        } catch (JSONException unused) {
            b.b(a, "Error in sendPurchaseRequest.");
        }
    }

    public void a(RequestId requestId, Set<String> set) {
        b.a(a, "sendItemDataRequest");
        try {
            Context b2 = d.e().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray(set);
            jSONObject.put(com.amazon.a.a.o.b.B, requestId.toString());
            jSONObject.put("packageName", b2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.O, jSONArray);
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            bundle.putString("itemDataInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.iap.itemData");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            b2.startService(a2);
        } catch (JSONException unused) {
            b.b(a, "Error in sendItemDataRequest.");
        }
    }

    public void a(RequestId requestId, boolean z) {
        if (requestId == null) {
            requestId = new RequestId();
        }
        String str = a;
        b.a(str, "sendPurchaseUpdatesRequest/sendGetUserData first:" + requestId);
        a(requestId.toString(), true, z);
    }

    public void a(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        b.a(a, "sendNotifyPurchaseFulfilled");
        try {
            Context b2 = d.e().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, requestId.toString());
            jSONObject.put("packageName", b2.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.E, str);
            jSONObject.put("fulfillmentResult", fulfillmentResult);
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            bundle.putString("purchaseFulfilledInput", jSONObject.toString());
            Intent a2 = a("com.amazon.testclient.iap.purchaseFulfilled");
            a2.addFlags(268435456);
            a2.putExtras(bundle);
            b2.startService(a2);
        } catch (JSONException unused) {
            b.b(a, "Error in sendNotifyPurchaseFulfilled.");
        }
    }

    public void a(Context context, Intent intent) {
        b.a(a, "handleResponse");
        intent.setComponent(new ComponentName(b, c));
        try {
            String string = intent.getExtras().getString("responseType");
            if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchase")) {
                g(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.appUserId")) {
                e(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.itemData")) {
                c(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchaseUpdates")) {
                a(intent);
            }
        } catch (Exception e) {
            Log.e(a, "Error handling response.", e);
        }
    }

    private Intent a(String str) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(b, c));
        return intent;
    }

    /* access modifiers changed from: protected */
    public void a(final Object obj) {
        f.a(obj, "response");
        Context b2 = d.e().b();
        final PurchasingListener a2 = d.e().a();
        if (b2 == null || a2 == null) {
            String str = a;
            b.a(str, "PurchasingListener is not set. Dropping response: " + obj);
            return;
        }
        new Handler(b2.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    Object obj = obj;
                    if (obj instanceof ProductDataResponse) {
                        a2.onProductDataResponse((ProductDataResponse) obj);
                    } else if (obj instanceof UserDataResponse) {
                        a2.onUserDataResponse((UserDataResponse) obj);
                    } else if (obj instanceof PurchaseUpdatesResponse) {
                        a2.onPurchaseUpdatesResponse((PurchaseUpdatesResponse) obj);
                    } else if (obj instanceof PurchaseResponse) {
                        a2.onPurchaseResponse((PurchaseResponse) obj);
                    } else {
                        String a2 = e.a;
                        b.b(a2, "Unknown response type:" + obj.getClass().getName());
                    }
                } catch (Exception e) {
                    String a3 = e.a;
                    b.b(a3, "Error in sendResponse: " + e);
                }
            }
        });
    }

    private void a(Intent intent) throws JSONException {
        PurchaseUpdatesResponse b2 = b(intent);
        if (b2.getRequestStatus() == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
            String optString = new JSONObject(intent.getStringExtra("purchaseUpdatesOutput")).optString(b.ar);
            String str = a;
            Log.i(str, "Offset for PurchaseUpdatesResponse:" + optString);
            a.a(b2.getUserData().getUserId(), optString);
        }
        a((Object) b2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v9, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: boolean} */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:19|20|21|22|23|41|24|17) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x006a */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.amazon.device.iap.model.PurchaseUpdatesResponse b(android.content.Intent r11) {
        /*
            r10 = this;
            com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r0 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.FAILED
            r1 = 0
            r2 = 0
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x0093 }
            java.lang.String r4 = "purchaseUpdatesOutput"
            java.lang.String r11 = r11.getStringExtra(r4)     // Catch:{ Exception -> 0x0093 }
            r3.<init>(r11)     // Catch:{ Exception -> 0x0093 }
            java.lang.String r11 = "requestId"
            java.lang.String r11 = r3.optString(r11)     // Catch:{ Exception -> 0x0093 }
            com.amazon.device.iap.model.RequestId r11 = com.amazon.device.iap.model.RequestId.fromString(r11)     // Catch:{ Exception -> 0x0093 }
            java.lang.String r4 = "status"
            java.lang.String r4 = r3.optString(r4)     // Catch:{ Exception -> 0x008e }
            com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r0 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.valueOf(r4)     // Catch:{ Exception -> 0x008e }
            java.lang.String r4 = "isMore"
            boolean r4 = r3.optBoolean(r4)     // Catch:{ Exception -> 0x008e }
            java.lang.String r5 = "userId"
            java.lang.String r5 = r3.optString(r5)     // Catch:{ Exception -> 0x0088 }
            java.lang.String r6 = "marketplace"
            java.lang.String r6 = r3.optString(r6)     // Catch:{ Exception -> 0x0088 }
            com.amazon.device.iap.internal.model.UserDataBuilder r7 = new com.amazon.device.iap.internal.model.UserDataBuilder     // Catch:{ Exception -> 0x0088 }
            r7.<init>()     // Catch:{ Exception -> 0x0088 }
            com.amazon.device.iap.internal.model.UserDataBuilder r5 = r7.setUserId(r5)     // Catch:{ Exception -> 0x0088 }
            com.amazon.device.iap.internal.model.UserDataBuilder r5 = r5.setMarketplace(r6)     // Catch:{ Exception -> 0x0088 }
            com.amazon.device.iap.model.UserData r5 = r5.build()     // Catch:{ Exception -> 0x0088 }
            com.amazon.device.iap.model.PurchaseUpdatesResponse$RequestStatus r6 = com.amazon.device.iap.model.PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL     // Catch:{ Exception -> 0x0085 }
            if (r0 != r6) goto L_0x00a1
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0085 }
            r6.<init>()     // Catch:{ Exception -> 0x0085 }
            java.lang.String r1 = "receipts"
            org.json.JSONArray r1 = r3.optJSONArray(r1)     // Catch:{ Exception -> 0x0083 }
            if (r1 == 0) goto L_0x00a0
        L_0x0058:
            int r3 = r1.length()     // Catch:{ Exception -> 0x0083 }
            if (r2 >= r3) goto L_0x00a0
            org.json.JSONObject r3 = r1.optJSONObject(r2)     // Catch:{ Exception -> 0x0083 }
            com.amazon.device.iap.model.Receipt r7 = r10.a((org.json.JSONObject) r3)     // Catch:{ Exception -> 0x006a }
            r6.add(r7)     // Catch:{ Exception -> 0x006a }
            goto L_0x0080
        L_0x006a:
            java.lang.String r7 = a     // Catch:{ Exception -> 0x0083 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0083 }
            r8.<init>()     // Catch:{ Exception -> 0x0083 }
            java.lang.String r9 = "Failed to parse receipt from json:"
            r8.append(r9)     // Catch:{ Exception -> 0x0083 }
            r8.append(r3)     // Catch:{ Exception -> 0x0083 }
            java.lang.String r3 = r8.toString()     // Catch:{ Exception -> 0x0083 }
            android.util.Log.e(r7, r3)     // Catch:{ Exception -> 0x0083 }
        L_0x0080:
            int r2 = r2 + 1
            goto L_0x0058
        L_0x0083:
            r1 = move-exception
            goto L_0x008c
        L_0x0085:
            r2 = move-exception
            r6 = r1
            goto L_0x008b
        L_0x0088:
            r2 = move-exception
            r5 = r1
            r6 = r5
        L_0x008b:
            r1 = r2
        L_0x008c:
            r2 = r4
            goto L_0x0098
        L_0x008e:
            r3 = move-exception
            r5 = r1
            r6 = r5
            r1 = r3
            goto L_0x0098
        L_0x0093:
            r11 = move-exception
            r5 = r1
            r6 = r5
            r1 = r11
            r11 = r6
        L_0x0098:
            java.lang.String r3 = a
            java.lang.String r4 = "Error parsing purchase updates output"
            android.util.Log.e(r3, r4, r1)
            r4 = r2
        L_0x00a0:
            r1 = r6
        L_0x00a1:
            com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder r2 = new com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder
            r2.<init>()
            com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder r11 = r2.setRequestId(r11)
            com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder r11 = r11.setRequestStatus(r0)
            com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder r11 = r11.setUserData(r5)
            com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder r11 = r11.setReceipts(r1)
            com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder r11 = r11.setHasMore(r4)
            com.amazon.device.iap.model.PurchaseUpdatesResponse r11 = r11.build()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazon.device.iap.internal.c.e.b(android.content.Intent):com.amazon.device.iap.model.PurchaseUpdatesResponse");
    }

    private void c(Intent intent) {
        a((Object) d(intent));
    }

    private ProductDataResponse d(Intent intent) {
        RequestId requestId;
        HashMap hashMap;
        LinkedHashSet linkedHashSet;
        Exception e;
        ProductDataResponse.RequestStatus requestStatus = ProductDataResponse.RequestStatus.FAILED;
        LinkedHashSet linkedHashSet2 = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("itemDataOutput"));
            requestId = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.B));
            try {
                requestStatus = ProductDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                if (requestStatus != ProductDataResponse.RequestStatus.FAILED) {
                    linkedHashSet = new LinkedHashSet();
                    try {
                        hashMap = new HashMap();
                        try {
                            JSONArray optJSONArray = jSONObject.optJSONArray("unavailableSkus");
                            if (optJSONArray != null) {
                                for (int i = 0; i < optJSONArray.length(); i++) {
                                    linkedHashSet.add(optJSONArray.getString(i));
                                }
                            }
                            JSONObject optJSONObject = jSONObject.optJSONObject("items");
                            if (optJSONObject != null) {
                                Iterator<String> keys = optJSONObject.keys();
                                while (keys.hasNext()) {
                                    String next = keys.next();
                                    hashMap.put(next, a(next, optJSONObject.optJSONObject(next)));
                                }
                            }
                        } catch (Exception e2) {
                            e = e2;
                            Log.e(a, "Error parsing item data output", e);
                            linkedHashSet2 = linkedHashSet;
                            return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
                        }
                    } catch (Exception e3) {
                        e = e3;
                        hashMap = null;
                        e = e;
                        Log.e(a, "Error parsing item data output", e);
                        linkedHashSet2 = linkedHashSet;
                        return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
                    }
                    linkedHashSet2 = linkedHashSet;
                    return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
                }
                hashMap = null;
                return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
            } catch (Exception e4) {
                e = e4;
                linkedHashSet = null;
                hashMap = null;
                e = e;
                Log.e(a, "Error parsing item data output", e);
                linkedHashSet2 = linkedHashSet;
                return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
            }
        } catch (Exception e5) {
            linkedHashSet = null;
            hashMap = null;
            e = e5;
            requestId = null;
            Log.e(a, "Error parsing item data output", e);
            linkedHashSet2 = linkedHashSet;
            return new ProductDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setProductData(hashMap).setUnavailableSkus(linkedHashSet2).build();
        }
    }

    private Product a(String str, JSONObject jSONObject) throws JSONException {
        String str2;
        ProductType valueOf = ProductType.valueOf(jSONObject.optString(com.amazon.a.a.o.b.k));
        JSONObject optJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.y);
        List<Promotion> list = null;
        if (optJSONObject == null || optJSONObject == JSONObject.NULL) {
            str2 = null;
        } else {
            Currency instance = Currency.getInstance(optJSONObject.optString(com.amazon.a.a.o.b.a));
            str2 = instance.getSymbol() + optJSONObject.optString("value");
        }
        String optString = jSONObject.optString("title");
        String optString2 = jSONObject.optString(com.amazon.a.a.o.b.c);
        String optString3 = jSONObject.optString("smallIconUrl");
        int optInt = jSONObject.optInt(com.amazon.a.a.o.b.T, 0);
        String string = jSONObject.isNull("term") ? null : jSONObject.getString("term");
        String string2 = jSONObject.isNull(com.amazon.a.a.o.b.p) ? null : jSONObject.getString(com.amazon.a.a.o.b.p);
        if (!jSONObject.isNull(com.amazon.a.a.o.b.q)) {
            list = a.a(jSONObject);
        }
        return new ProductBuilder().setSku(str).setProductType(valueOf).setDescription(optString2).setPrice(str2).setSmallIconUrl(optString3).setTitle(optString).setCoinsRewardAmount(optInt).setSubscriptionPeriod(string).setFreeTrialPeriod(string2).setPromotions(list).build();
    }

    private void e(Intent intent) {
        JSONObject jSONObject;
        UserDataResponse f = f(intent);
        RequestId requestId = f.getRequestId();
        String stringExtra = intent.getStringExtra("userInput");
        try {
            jSONObject = new JSONObject(stringExtra);
        } catch (JSONException e) {
            String str = a;
            Log.e(str, "Unable to parse request data: " + stringExtra, e);
            jSONObject = null;
        }
        if (requestId == null || jSONObject == null) {
            a((Object) f);
        } else if (!jSONObject.optBoolean(b.as, false)) {
            a((Object) f);
        } else if (f.getUserData() == null || f.a(f.getUserData().getUserId())) {
            String str2 = a;
            Log.e(str2, "No Userid found in userDataResponse" + f);
            a((Object) new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).setUserData(f.getUserData()).setReceipts(new ArrayList()).setHasMore(false).build());
        } else {
            String str3 = a;
            Log.i(str3, "sendGetPurchaseUpdates with user id" + f.getUserData().getUserId());
            a(requestId.toString(), f.getUserData().getUserId(), jSONObject.optBoolean(b.at, true));
        }
    }

    private void a(String str, String str2, boolean z) {
        try {
            Context b2 = d.e().b();
            String a2 = a.a(str2);
            String str3 = a;
            Log.i(str3, "send PurchaseUpdates with user id:" + str2 + ";reset flag:" + z + ", local cursor:" + a2 + ", parsed from old requestId:" + str);
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.B, str.toString());
            if (z) {
                a2 = null;
            }
            jSONObject.put(b.ar, a2);
            jSONObject.put(com.amazon.a.a.o.b.I, PurchasingService.SDK_VERSION);
            jSONObject.put("packageName", b2.getPackageName());
            bundle.putString("purchaseUpdatesInput", jSONObject.toString());
            Intent a3 = a("com.amazon.testclient.iap.purchaseUpdates");
            a3.addFlags(268435456);
            a3.putExtras(bundle);
            b2.startService(a3);
        } catch (JSONException unused) {
            b.b(a, "Error in sendPurchaseUpdatesRequest.");
        }
    }

    private UserDataResponse f(Intent intent) {
        RequestId requestId;
        UserDataResponse.RequestStatus requestStatus = UserDataResponse.RequestStatus.FAILED;
        UserData userData = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("userOutput"));
            requestId = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.B));
            try {
                requestStatus = UserDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                if (requestStatus == UserDataResponse.RequestStatus.SUCCESSFUL) {
                    userData = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.m)).build();
                }
            } catch (Exception e) {
                e = e;
                Log.e(a, "Error parsing userid output", e);
                return new UserDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).build();
            }
        } catch (Exception e2) {
            e = e2;
            requestId = null;
            Log.e(a, "Error parsing userid output", e);
            return new UserDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).build();
        }
        return new UserDataResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).build();
    }

    private void g(Intent intent) {
        a((Object) h(intent));
    }

    private PurchaseResponse h(Intent intent) {
        RequestId requestId;
        UserData userData;
        PurchaseResponse.RequestStatus requestStatus = PurchaseResponse.RequestStatus.FAILED;
        Receipt receipt = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("purchaseOutput"));
            requestId = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.B));
            try {
                userData = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.m)).build();
            } catch (Exception e) {
                e = e;
                userData = null;
                Log.e(a, "Error parsing purchase output", e);
                return new PurchaseResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipt(receipt).build();
            }
            try {
                requestStatus = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.optString("purchaseStatus"));
                JSONObject optJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.D);
                if (optJSONObject != null) {
                    receipt = a(optJSONObject);
                }
            } catch (Exception e2) {
                e = e2;
                Log.e(a, "Error parsing purchase output", e);
                return new PurchaseResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipt(receipt).build();
            }
        } catch (Exception e3) {
            e = e3;
            requestId = null;
            userData = null;
            Log.e(a, "Error parsing purchase output", e);
            return new PurchaseResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipt(receipt).build();
        }
        return new PurchaseResponseBuilder().setRequestId(requestId).setRequestStatus(requestStatus).setUserData(userData).setReceipt(receipt).build();
    }

    private Receipt a(JSONObject jSONObject) throws ParseException {
        String optString = jSONObject.optString(com.amazon.a.a.o.b.E);
        String optString2 = jSONObject.optString("sku");
        ProductType valueOf = ProductType.valueOf(jSONObject.optString(com.amazon.a.a.o.b.k));
        Date parse = b.aq.parse(jSONObject.optString(com.amazon.a.a.o.b.Q));
        String optString3 = jSONObject.optString(com.amazon.a.a.o.b.e);
        Date parse2 = (optString3 == null || optString3.length() == 0) ? null : b.aq.parse(optString3);
        String optString4 = jSONObject.optString(com.amazon.a.a.o.b.R);
        return new ReceiptBuilder().setReceiptId(optString).setSku(optString2).setProductType(valueOf).setPurchaseDate(parse).setCancelDate(parse2).setDeferredSku(jSONObject.optString(com.amazon.a.a.o.b.M, (String) null)).setDeferredDate((optString4 == null || optString4.length() == 0) ? null : b.aq.parse(optString4)).setTermSku(jSONObject.optString(com.amazon.a.a.o.b.L, (String) null)).build();
    }
}
