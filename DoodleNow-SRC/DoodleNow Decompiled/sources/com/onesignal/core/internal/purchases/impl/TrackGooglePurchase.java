package com.onesignal.core.internal.purchases.impl;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.onesignal.core.internal.application.IApplicationLifecycleHandler;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.operations.IOperationRepo;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferencePlayerPurchasesKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.core.internal.startup.IStartableService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.user.internal.identity.IdentityModel;
import com.onesignal.user.internal.identity.IdentityModelStore;
import com.onesignal.user.internal.operations.PurchaseInfo;
import com.onesignal.user.internal.operations.TrackPurchaseOperation;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001'B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0002J8\u0010 \u001a\u00020\u001c2\u0016\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\"j\b\u0012\u0004\u0012\u00020\u001a`#2\u0016\u0010$\u001a\u0012\u0012\u0004\u0012\u00020\u001a0\"j\b\u0012\u0004\u0012\u00020\u001a`#H\u0002J\b\u0010%\u001a\u00020\u001cH\u0016J\b\u0010&\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackGooglePurchase;", "Lcom/onesignal/core/internal/startup/IStartableService;", "Lcom/onesignal/core/internal/application/IApplicationLifecycleHandler;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_prefs", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "_operationRepo", "Lcom/onesignal/core/internal/operations/IOperationRepo;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_identityModelStore", "Lcom/onesignal/user/internal/identity/IdentityModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/preferences/IPreferencesService;Lcom/onesignal/core/internal/operations/IOperationRepo;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/identity/IdentityModelStore;)V", "getPurchasesMethod", "Ljava/lang/reflect/Method;", "getSkuDetailsMethod", "isWaitingForPurchasesRequest", "", "mIInAppBillingService", "", "mServiceConn", "Landroid/content/ServiceConnection;", "newAsExisting", "purchaseTokens", "", "", "onFocus", "", "firedOnSubscribe", "onUnfocused", "queryBoughtItems", "sendPurchases", "skusToAdd", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "newPurchaseTokens", "start", "trackIAP", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TrackGooglePurchase.kt */
public final class TrackGooglePurchase implements IStartableService, IApplicationLifecycleHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static Class<?> iInAppBillingServiceClass;
    /* access modifiers changed from: private */
    public static int iapEnabled = -99;
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final IdentityModelStore _identityModelStore;
    private final IOperationRepo _operationRepo;
    private final IPreferencesService _prefs;
    private Method getPurchasesMethod;
    private Method getSkuDetailsMethod;
    private boolean isWaitingForPurchasesRequest;
    /* access modifiers changed from: private */
    public Object mIInAppBillingService;
    private ServiceConnection mServiceConn;
    private boolean newAsExisting = true;
    private final List<String> purchaseTokens = new ArrayList();

    public void onUnfocused() {
    }

    public TrackGooglePurchase(IApplicationService iApplicationService, IPreferencesService iPreferencesService, IOperationRepo iOperationRepo, ConfigModelStore configModelStore, IdentityModelStore identityModelStore) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iPreferencesService, "_prefs");
        Intrinsics.checkNotNullParameter(iOperationRepo, "_operationRepo");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(identityModelStore, "_identityModelStore");
        this._applicationService = iApplicationService;
        this._prefs = iPreferencesService;
        this._operationRepo = iOperationRepo;
        this._configModelStore = configModelStore;
        this._identityModelStore = identityModelStore;
    }

    public void start() {
        if (Companion.canTrack(this._applicationService.getAppContext())) {
            try {
                JSONArray jSONArray = new JSONArray(this._prefs.getString(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_PURCHASE_TOKENS, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                int length = jSONArray.length();
                boolean z = false;
                for (int i = 0; i < length; i++) {
                    this.purchaseTokens.add(jSONArray.get(i).toString());
                }
                if (jSONArray.length() == 0) {
                    z = true;
                }
                this.newAsExisting = z;
                if (z) {
                    Boolean bool = this._prefs.getBool(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_EXISTING_PURCHASES, true);
                    Intrinsics.checkNotNull(bool);
                    this.newAsExisting = bool.booleanValue();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this._applicationService.addApplicationLifecycleHandler(this);
            trackIAP();
        }
    }

    public void onFocus(boolean z) {
        trackIAP();
    }

    private final void trackIAP() {
        if (this.mServiceConn == null) {
            ServiceConnection trackGooglePurchase$trackIAP$serviceConn$1 = new TrackGooglePurchase$trackIAP$serviceConn$1(this);
            this.mServiceConn = trackGooglePurchase$trackIAP$serviceConn$1;
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            this._applicationService.getAppContext().getApplicationContext().bindService(intent, trackGooglePurchase$trackIAP$serviceConn$1, 1);
        } else if (this.mIInAppBillingService != null) {
            queryBoughtItems();
        }
    }

    /* access modifiers changed from: private */
    public final void queryBoughtItems() {
        if (!this.isWaitingForPurchasesRequest) {
            new Thread(new TrackGooglePurchase$$ExternalSyntheticLambda0(this)).start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: queryBoughtItems$lambda-0  reason: not valid java name */
    public static final void m1033queryBoughtItems$lambda0(TrackGooglePurchase trackGooglePurchase) {
        Intrinsics.checkNotNullParameter(trackGooglePurchase, "this$0");
        trackGooglePurchase.isWaitingForPurchasesRequest = true;
        try {
            if (trackGooglePurchase.getPurchasesMethod == null) {
                Method access$getGetPurchasesMethod = Companion.getGetPurchasesMethod(iInAppBillingServiceClass);
                trackGooglePurchase.getPurchasesMethod = access$getGetPurchasesMethod;
                Intrinsics.checkNotNull(access$getGetPurchasesMethod);
                access$getGetPurchasesMethod.setAccessible(true);
            }
            Method method = trackGooglePurchase.getPurchasesMethod;
            Intrinsics.checkNotNull(method);
            Object invoke = method.invoke(trackGooglePurchase.mIInAppBillingService, new Object[]{3, trackGooglePurchase._applicationService.getAppContext().getPackageName(), "inapp", null});
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type android.os.Bundle");
            Bundle bundle = (Bundle) invoke;
            if (bundle.getInt("RESPONSE_CODE") == 0) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                Intrinsics.checkNotNull(stringArrayList2);
                int size = stringArrayList2.size();
                for (int i = 0; i < size; i++) {
                    Intrinsics.checkNotNull(stringArrayList);
                    String str = stringArrayList.get(i);
                    String string = new JSONObject(stringArrayList2.get(i)).getString("purchaseToken");
                    if (!trackGooglePurchase.purchaseTokens.contains(string) && !arrayList2.contains(string)) {
                        arrayList2.add(string);
                        arrayList.add(str);
                    }
                }
                if (arrayList.size() > 0) {
                    trackGooglePurchase.sendPurchases(arrayList, arrayList2);
                } else if (stringArrayList2.size() == 0) {
                    trackGooglePurchase.newAsExisting = false;
                    trackGooglePurchase._prefs.saveBool(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_EXISTING_PURCHASES, false);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        trackGooglePurchase.isWaitingForPurchasesRequest = false;
    }

    private final void sendPurchases(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        try {
            if (this.getSkuDetailsMethod == null) {
                Method access$getGetSkuDetailsMethod = Companion.getGetSkuDetailsMethod(iInAppBillingServiceClass);
                this.getSkuDetailsMethod = access$getGetSkuDetailsMethod;
                Intrinsics.checkNotNull(access$getGetSkuDetailsMethod);
                access$getGetSkuDetailsMethod.setAccessible(true);
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            Method method = this.getSkuDetailsMethod;
            Intrinsics.checkNotNull(method);
            Object invoke = method.invoke(this.mIInAppBillingService, new Object[]{3, this._applicationService.getAppContext().getPackageName(), "inapp", bundle});
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type android.os.Bundle");
            Bundle bundle2 = (Bundle) invoke;
            if (bundle2.getInt("RESPONSE_CODE") == 0) {
                ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                Map linkedHashMap = new LinkedHashMap();
                Intrinsics.checkNotNull(stringArrayList);
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject = new JSONObject(it.next());
                    String string = jSONObject.getString("productId");
                    String string2 = jSONObject.getString("price_currency_code");
                    BigDecimal divide = new BigDecimal(jSONObject.getString("price_amount_micros")).divide(new BigDecimal(1000000));
                    Intrinsics.checkNotNullExpressionValue(divide, "price.divide(BigDecimal(1000000))");
                    Intrinsics.checkNotNullExpressionValue(string, "sku");
                    Intrinsics.checkNotNullExpressionValue(string2, "iso");
                    linkedHashMap.put(string, new PurchaseInfo(string, string2, divide));
                }
                List arrayList3 = new ArrayList();
                Iterator<String> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    String next = it2.next();
                    if (linkedHashMap.containsKey(next)) {
                        Object obj = linkedHashMap.get(next);
                        Intrinsics.checkNotNull(obj);
                        arrayList3.add(obj);
                    }
                }
                if (!arrayList3.isEmpty()) {
                    IOperationRepo.DefaultImpls.enqueue$default(this._operationRepo, new TrackPurchaseOperation(((ConfigModel) this._configModelStore.getModel()).getAppId(), ((IdentityModel) this._identityModelStore.getModel()).getOnesignalId(), this.newAsExisting, new BigDecimal(0), arrayList3), false, 2, (Object) null);
                    this.purchaseTokens.addAll(arrayList2);
                    this._prefs.saveString(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_PURCHASE_TOKENS, this.purchaseTokens.toString());
                    this._prefs.saveBool(PreferenceStores.PLAYER_PURCHASES, PreferencePlayerPurchasesKeys.PREFS_EXISTING_PURCHASES, true);
                    this.newAsExisting = false;
                    this.isWaitingForPurchasesRequest = false;
                }
            }
        } catch (Throwable th) {
            Logging.warn("Failed to track IAP purchases", th);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0002J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/onesignal/core/internal/purchases/impl/TrackGooglePurchase$Companion;", "", "()V", "iInAppBillingServiceClass", "Ljava/lang/Class;", "iapEnabled", "", "canTrack", "", "context", "Landroid/content/Context;", "getAsInterfaceMethod", "Ljava/lang/reflect/Method;", "clazz", "getGetPurchasesMethod", "getGetSkuDetailsMethod", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TrackGooglePurchase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean canTrack(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (TrackGooglePurchase.iapEnabled == -99) {
                TrackGooglePurchase.iapEnabled = context.checkCallingOrSelfPermission("com.android.vending.BILLING");
            }
            try {
                if (TrackGooglePurchase.iapEnabled == 0) {
                    TrackGooglePurchase.iInAppBillingServiceClass = Class.forName("com.android.vending.billing.IInAppBillingService");
                }
                if (TrackGooglePurchase.iapEnabled == 0) {
                    return true;
                }
                return false;
            } catch (Throwable unused) {
                TrackGooglePurchase.iapEnabled = 0;
                return false;
            }
        }

        /* access modifiers changed from: private */
        public final Method getAsInterfaceMethod(Class<?> cls) {
            Method[] methods = cls.getMethods();
            Intrinsics.checkNotNullExpressionValue(methods, "clazz.methods");
            for (Method method : methods) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && Intrinsics.areEqual((Object) parameterTypes[0], (Object) IBinder.class)) {
                    return method;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final Method getGetPurchasesMethod(Class<?> cls) {
            Intrinsics.checkNotNull(cls);
            Method[] methods = cls.getMethods();
            Intrinsics.checkNotNullExpressionValue(methods, "clazz!!.methods");
            for (Method method : methods) {
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 4 && Intrinsics.areEqual((Object) parameterTypes[0], (Object) Integer.TYPE) && Intrinsics.areEqual((Object) parameterTypes[1], (Object) String.class) && Intrinsics.areEqual((Object) parameterTypes[2], (Object) String.class) && Intrinsics.areEqual((Object) parameterTypes[3], (Object) String.class)) {
                    return method;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public final Method getGetSkuDetailsMethod(Class<?> cls) {
            Intrinsics.checkNotNull(cls);
            Method[] methods = cls.getMethods();
            Intrinsics.checkNotNullExpressionValue(methods, "clazz!!.methods");
            for (Method method : methods) {
                Class[] parameterTypes = method.getParameterTypes();
                Class<?> returnType = method.getReturnType();
                if (parameterTypes.length == 4 && Intrinsics.areEqual((Object) parameterTypes[0], (Object) Integer.TYPE) && Intrinsics.areEqual((Object) parameterTypes[1], (Object) String.class) && Intrinsics.areEqual((Object) parameterTypes[2], (Object) String.class) && Intrinsics.areEqual((Object) parameterTypes[3], (Object) Bundle.class) && Intrinsics.areEqual((Object) returnType, (Object) Bundle.class)) {
                    return method;
                }
            }
            return null;
        }
    }
}
