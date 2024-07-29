package io.invertase.googlemobileads;

import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import io.invertase.googlemobileads.common.ReactNativeModule;
import java.util.Map;

public class ReactNativeGoogleMobileAdsModule extends ReactNativeModule {
    private static final String SERVICE = "RNGoogleMobileAdsModule";

    ReactNativeGoogleMobileAdsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.gms.ads.RequestConfiguration buildRequestConfiguration(com.facebook.react.bridge.ReadableMap r11) {
        /*
            r10 = this;
            com.google.android.gms.ads.RequestConfiguration$Builder r0 = new com.google.android.gms.ads.RequestConfiguration$Builder
            r0.<init>()
            java.lang.String r1 = "testDeviceIdentifiers"
            boolean r2 = r11.hasKey(r1)
            if (r2 == 0) goto L_0x0045
            com.facebook.react.bridge.ReadableArray r1 = r11.getArray(r1)
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            com.facebook.react.bridge.ReadableArray r1 = (com.facebook.react.bridge.ReadableArray) r1
            java.util.ArrayList r1 = r1.toArrayList()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0024:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0042
            java.lang.Object r3 = r1.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "EMULATOR"
            boolean r4 = r3.equals(r4)
            if (r4 == 0) goto L_0x003e
            java.lang.String r3 = "B3EEABB8EE11C2BE770B684D95219ECB"
            r2.add(r3)
            goto L_0x0024
        L_0x003e:
            r2.add(r3)
            goto L_0x0024
        L_0x0042:
            r0.setTestDeviceIds(r2)
        L_0x0045:
            java.lang.String r1 = "maxAdContentRating"
            boolean r2 = r11.hasKey(r1)
            r3 = 1
            r4 = 0
            r5 = -1
            if (r2 == 0) goto L_0x00a4
            java.lang.String r1 = r11.getString(r1)
            java.lang.Object r1 = java.util.Objects.requireNonNull(r1)
            java.lang.String r1 = (java.lang.String) r1
            r1.hashCode()
            int r2 = r1.hashCode()
            java.lang.String r6 = "PG"
            java.lang.String r7 = "MA"
            java.lang.String r8 = "T"
            java.lang.String r9 = "G"
            switch(r2) {
                case 71: goto L_0x0089;
                case 84: goto L_0x0080;
                case 2452: goto L_0x0077;
                case 2551: goto L_0x006e;
                default: goto L_0x006c;
            }
        L_0x006c:
            r1 = r5
            goto L_0x0091
        L_0x006e:
            boolean r1 = r1.equals(r6)
            if (r1 != 0) goto L_0x0075
            goto L_0x006c
        L_0x0075:
            r1 = 3
            goto L_0x0091
        L_0x0077:
            boolean r1 = r1.equals(r7)
            if (r1 != 0) goto L_0x007e
            goto L_0x006c
        L_0x007e:
            r1 = 2
            goto L_0x0091
        L_0x0080:
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x0087
            goto L_0x006c
        L_0x0087:
            r1 = r3
            goto L_0x0091
        L_0x0089:
            boolean r1 = r1.equals(r9)
            if (r1 != 0) goto L_0x0090
            goto L_0x006c
        L_0x0090:
            r1 = r4
        L_0x0091:
            switch(r1) {
                case 0: goto L_0x00a1;
                case 1: goto L_0x009d;
                case 2: goto L_0x0099;
                case 3: goto L_0x0095;
                default: goto L_0x0094;
            }
        L_0x0094:
            goto L_0x00a4
        L_0x0095:
            r0.setMaxAdContentRating(r6)
            goto L_0x00a4
        L_0x0099:
            r0.setMaxAdContentRating(r7)
            goto L_0x00a4
        L_0x009d:
            r0.setMaxAdContentRating(r8)
            goto L_0x00a4
        L_0x00a1:
            r0.setMaxAdContentRating(r9)
        L_0x00a4:
            java.lang.String r1 = "tagForChildDirectedTreatment"
            boolean r2 = r11.hasKey(r1)
            if (r2 == 0) goto L_0x00ba
            boolean r1 = r11.getBoolean(r1)
            if (r1 == 0) goto L_0x00b6
            r0.setTagForChildDirectedTreatment(r3)
            goto L_0x00bd
        L_0x00b6:
            r0.setTagForChildDirectedTreatment(r4)
            goto L_0x00bd
        L_0x00ba:
            r0.setTagForChildDirectedTreatment(r5)
        L_0x00bd:
            java.lang.String r1 = "tagForUnderAgeOfConsent"
            boolean r2 = r11.hasKey(r1)
            if (r2 == 0) goto L_0x00d3
            boolean r11 = r11.getBoolean(r1)
            if (r11 == 0) goto L_0x00cf
            r0.setTagForUnderAgeOfConsent(r3)
            goto L_0x00d6
        L_0x00cf:
            r0.setTagForUnderAgeOfConsent(r4)
            goto L_0x00d6
        L_0x00d3:
            r0.setTagForUnderAgeOfConsent(r5)
        L_0x00d6:
            com.google.android.gms.ads.RequestConfiguration r11 = r0.build()
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsModule.buildRequestConfiguration(com.facebook.react.bridge.ReadableMap):com.google.android.gms.ads.RequestConfiguration");
    }

    @ReactMethod
    public void initialize(final Promise promise) {
        MobileAds.initialize(getApplicationContext(), new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
                WritableArray createArray = Arguments.createArray();
                for (Map.Entry next : initializationStatus.getAdapterStatusMap().entrySet()) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("name", (String) next.getKey());
                    createMap.putInt("state", ((AdapterStatus) next.getValue()).getInitializationState().ordinal());
                    createMap.putString(b.c, ((AdapterStatus) next.getValue()).getDescription());
                    createArray.pushMap(createMap);
                }
                promise.resolve(createArray);
            }
        });
    }

    @ReactMethod
    public void setRequestConfiguration(ReadableMap readableMap, Promise promise) {
        MobileAds.setRequestConfiguration(buildRequestConfiguration(readableMap));
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void openAdInspector(Promise promise) {
        if (getCurrentActivity() == null) {
            rejectPromiseWithCodeAndMessage(promise, "null-activity", "Ad Inspector attempted to open but the current Activity was null.");
        } else {
            getCurrentActivity().runOnUiThread(new ReactNativeGoogleMobileAdsModule$$ExternalSyntheticLambda0(this, promise));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$openAdInspector$0(final Promise promise) {
        MobileAds.openAdInspector(getApplicationContext(), new OnAdInspectorClosedListener() {
            public void onAdInspectorClosed(AdInspectorError adInspectorError) {
                if (adInspectorError != null) {
                    int code = adInspectorError.getCode();
                    ReactNativeModule.rejectPromiseWithCodeAndMessage(promise, code != 0 ? code != 1 ? code != 2 ? code != 3 ? "" : "ALREADY_OPEN" : "NOT_IN_TEST_MODE" : "FAILED_TO_LOAD" : "INTERNAL_ERROR", adInspectorError.getMessage());
                    return;
                }
                promise.resolve((Object) null);
            }
        });
    }

    @ReactMethod
    public void openDebugMenu(String str) {
        if (getCurrentActivity() != null) {
            getCurrentActivity().runOnUiThread(new ReactNativeGoogleMobileAdsModule$$ExternalSyntheticLambda1(this, str));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$openDebugMenu$1(String str) {
        MobileAds.openDebugMenu(getCurrentActivity(), str);
    }
}
