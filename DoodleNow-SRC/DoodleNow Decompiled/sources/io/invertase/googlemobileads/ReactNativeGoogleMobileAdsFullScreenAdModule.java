package io.invertase.googlemobileads;

import android.app.Activity;
import android.util.SparseArray;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import io.invertase.googlemobileads.common.ReactNativeModule;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\"B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\n\u001a\u00020\u0006H&J\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J.\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H&J4\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J&\u0010\u001e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020!R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsFullScreenAdModule;", "T", "Lio/invertase/googlemobileads/common/ReactNativeModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "moduleName", "", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/String;)V", "adArray", "Landroid/util/SparseArray;", "getAdEventName", "load", "", "requestId", "", "adUnitId", "adRequestOptions", "Lcom/facebook/react/bridge/ReadableMap;", "loadAd", "activity", "Landroid/app/Activity;", "adRequest", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "adLoadCallback", "Lcom/google/android/gms/ads/AdLoadCallback;", "sendAdEvent", "type", "error", "Lcom/facebook/react/bridge/WritableMap;", "data", "show", "showOptions", "promise", "Lcom/facebook/react/bridge/Promise;", "ReactNativeGoogleMobileAdsAdLoadCallback", "react-native-google-mobile-ads_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReactNativeGoogleMobileAdsFullScreenAdModule.kt */
public abstract class ReactNativeGoogleMobileAdsFullScreenAdModule<T> extends ReactNativeModule {
    /* access modifiers changed from: private */
    public final SparseArray<T> adArray = new SparseArray<>();

    public abstract String getAdEventName();

    public abstract void loadAd(Activity activity, String str, AdManagerAdRequest adManagerAdRequest, AdLoadCallback<T> adLoadCallback);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactNativeGoogleMobileAdsFullScreenAdModule(ReactApplicationContext reactApplicationContext, String str) {
        super(reactApplicationContext, str);
        Intrinsics.checkNotNullParameter(str, "moduleName");
    }

    /* access modifiers changed from: private */
    public final void sendAdEvent(String str, int i, String str2, WritableMap writableMap, WritableMap writableMap2) {
        ReactNativeGoogleMobileAdsCommon.sendAdEvent(getAdEventName(), i, str, str2, writableMap, writableMap2);
    }

    public final void load(int i, String str, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(readableMap, "adRequestOptions");
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("code", "null-activity");
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "Ad attempted to load but the current Activity was null.");
            sendAdEvent("error", i, str, createMap, (WritableMap) null);
            return;
        }
        currentActivity.runOnUiThread(new ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda1(this, currentActivity, str, ReactNativeGoogleMobileAdsCommon.buildAdRequest(readableMap), new ReactNativeGoogleMobileAdsAdLoadCallback(this, i, str, readableMap)));
    }

    /* access modifiers changed from: private */
    public static final void load$lambda$0(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, Activity activity, String str, AdManagerAdRequest adManagerAdRequest, ReactNativeGoogleMobileAdsAdLoadCallback reactNativeGoogleMobileAdsAdLoadCallback) {
        Intrinsics.checkNotNullParameter(reactNativeGoogleMobileAdsFullScreenAdModule, "this$0");
        Intrinsics.checkNotNullParameter(str, "$adUnitId");
        Intrinsics.checkNotNullParameter(reactNativeGoogleMobileAdsAdLoadCallback, "$adLoadCallback");
        Intrinsics.checkNotNull(adManagerAdRequest);
        reactNativeGoogleMobileAdsFullScreenAdModule.loadAd(activity, str, adManagerAdRequest, reactNativeGoogleMobileAdsAdLoadCallback);
    }

    public final void show(int i, String str, ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(readableMap, "showOptions");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            ReactNativeModule.rejectPromiseWithCodeAndMessage(promise, "null-activity", "Ad attempted to show but the current Activity was null.");
        } else {
            currentActivity.runOnUiThread(new ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda2(this, i, readableMap, currentActivity, promise, str));
        }
    }

    /* access modifiers changed from: private */
    public static final void show$lambda$2(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, int i, ReadableMap readableMap, Activity activity, Promise promise, String str) {
        Intrinsics.checkNotNullParameter(reactNativeGoogleMobileAdsFullScreenAdModule, "this$0");
        Intrinsics.checkNotNullParameter(readableMap, "$showOptions");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        Intrinsics.checkNotNullParameter(str, "$adUnitId");
        ReactNativeGoogleMobileAdsAdHelper reactNativeGoogleMobileAdsAdHelper = new ReactNativeGoogleMobileAdsAdHelper(reactNativeGoogleMobileAdsFullScreenAdModule.adArray.get(i));
        reactNativeGoogleMobileAdsAdHelper.setImmersiveMode(readableMap.hasKey("immersiveModeEnabled") ? readableMap.getBoolean("immersiveModeEnabled") : false);
        reactNativeGoogleMobileAdsAdHelper.show(activity, new ReactNativeGoogleMobileAdsFullScreenAdModule$$ExternalSyntheticLambda0(reactNativeGoogleMobileAdsFullScreenAdModule, i, str));
        promise.resolve((Object) null);
    }

    /* access modifiers changed from: private */
    public static final void show$lambda$2$lambda$1(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, int i, String str, RewardItem rewardItem) {
        Intrinsics.checkNotNullParameter(reactNativeGoogleMobileAdsFullScreenAdModule, "this$0");
        Intrinsics.checkNotNullParameter(str, "$adUnitId");
        Intrinsics.checkNotNullParameter(rewardItem, "rewardItem");
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", rewardItem.getType());
        createMap.putInt("amount", rewardItem.getAmount());
        reactNativeGoogleMobileAdsFullScreenAdModule.sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_REWARDED_EARNED_REWARD, i, str, (WritableMap) null, createMap);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\b\u00028\u0000H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b9¨\u0006\u0010"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback;", "Lcom/google/android/gms/ads/AdLoadCallback;", "requestId", "", "adUnitId", "", "adRequestOptions", "Lcom/facebook/react/bridge/ReadableMap;", "(Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsFullScreenAdModule;ILjava/lang/String;Lcom/facebook/react/bridge/ReadableMap;)V", "onAdFailedToLoad", "", "loadAdError", "Lcom/google/android/gms/ads/LoadAdError;", "onAdLoaded", "ad", "(Ljava/lang/Object;)V", "react-native-google-mobile-ads_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ReactNativeGoogleMobileAdsFullScreenAdModule.kt */
    public final class ReactNativeGoogleMobileAdsAdLoadCallback extends AdLoadCallback<T> {
        private final ReadableMap adRequestOptions;
        /* access modifiers changed from: private */
        public final String adUnitId;
        /* access modifiers changed from: private */
        public final int requestId;
        final /* synthetic */ ReactNativeGoogleMobileAdsFullScreenAdModule<T> this$0;

        public ReactNativeGoogleMobileAdsAdLoadCallback(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, int i, String str, ReadableMap readableMap) {
            Intrinsics.checkNotNullParameter(str, "adUnitId");
            Intrinsics.checkNotNullParameter(readableMap, "adRequestOptions");
            this.this$0 = reactNativeGoogleMobileAdsFullScreenAdModule;
            this.requestId = i;
            this.adUnitId = str;
            this.adRequestOptions = readableMap;
        }

        /* JADX WARNING: Removed duplicated region for block: B:32:0x009c A[Catch:{ Exception -> 0x00c8 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onAdLoaded(T r9) {
            /*
                r8 = this;
                java.lang.String r0 = "ad"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                io.invertase.googlemobileads.ReactNativeGoogleMobileAdsAdHelper r0 = new io.invertase.googlemobileads.ReactNativeGoogleMobileAdsAdHelper     // Catch:{ Exception -> 0x00c8 }
                r0.<init>(r9)     // Catch:{ Exception -> 0x00c8 }
                java.lang.String r1 = "loaded"
                io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule<T> r2 = r8.this$0     // Catch:{ Exception -> 0x00c8 }
                io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$$ExternalSyntheticLambda0 r3 = new io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$$ExternalSyntheticLambda0     // Catch:{ Exception -> 0x00c8 }
                r3.<init>(r2, r8)     // Catch:{ Exception -> 0x00c8 }
                boolean r2 = r9 instanceof com.google.android.gms.ads.admanager.AdManagerInterstitialAd     // Catch:{ Exception -> 0x00c8 }
                if (r2 == 0) goto L_0x001e
                r2 = r9
                com.google.android.gms.ads.admanager.AdManagerInterstitialAd r2 = (com.google.android.gms.ads.admanager.AdManagerInterstitialAd) r2     // Catch:{ Exception -> 0x00c8 }
                r2.setOnPaidEventListener(r3)     // Catch:{ Exception -> 0x00c8 }
                goto L_0x003e
            L_0x001e:
                boolean r2 = r9 instanceof com.google.android.gms.ads.appopen.AppOpenAd     // Catch:{ Exception -> 0x00c8 }
                if (r2 == 0) goto L_0x0029
                r2 = r9
                com.google.android.gms.ads.appopen.AppOpenAd r2 = (com.google.android.gms.ads.appopen.AppOpenAd) r2     // Catch:{ Exception -> 0x00c8 }
                r2.setOnPaidEventListener(r3)     // Catch:{ Exception -> 0x00c8 }
                goto L_0x003e
            L_0x0029:
                boolean r2 = r9 instanceof com.google.android.gms.ads.rewarded.RewardedAd     // Catch:{ Exception -> 0x00c8 }
                if (r2 == 0) goto L_0x0034
                r2 = r9
                com.google.android.gms.ads.rewarded.RewardedAd r2 = (com.google.android.gms.ads.rewarded.RewardedAd) r2     // Catch:{ Exception -> 0x00c8 }
                r2.setOnPaidEventListener(r3)     // Catch:{ Exception -> 0x00c8 }
                goto L_0x003e
            L_0x0034:
                boolean r2 = r9 instanceof com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd     // Catch:{ Exception -> 0x00c8 }
                if (r2 == 0) goto L_0x003e
                r2 = r9
                com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd r2 = (com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd) r2     // Catch:{ Exception -> 0x00c8 }
                r2.setOnPaidEventListener(r3)     // Catch:{ Exception -> 0x00c8 }
            L_0x003e:
                boolean r2 = r9 instanceof com.google.android.gms.ads.rewarded.RewardedAd     // Catch:{ Exception -> 0x00c8 }
                if (r2 != 0) goto L_0x004a
                boolean r2 = r9 instanceof com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAd     // Catch:{ Exception -> 0x00c8 }
                if (r2 == 0) goto L_0x0047
                goto L_0x004a
            L_0x0047:
                r2 = 0
                r5 = r2
                goto L_0x0098
            L_0x004a:
                java.lang.String r1 = "rewarded_loaded"
                com.google.android.gms.ads.rewarded.RewardItem r2 = r0.getRewardItem()     // Catch:{ Exception -> 0x00c8 }
                com.facebook.react.bridge.WritableMap r3 = com.facebook.react.bridge.Arguments.createMap()     // Catch:{ Exception -> 0x00c8 }
                java.lang.String r4 = "type"
                java.lang.String r5 = r2.getType()     // Catch:{ Exception -> 0x00c8 }
                r3.putString(r4, r5)     // Catch:{ Exception -> 0x00c8 }
                java.lang.String r4 = "amount"
                int r2 = r2.getAmount()     // Catch:{ Exception -> 0x00c8 }
                r3.putInt(r4, r2)     // Catch:{ Exception -> 0x00c8 }
                com.facebook.react.bridge.ReadableMap r2 = r8.adRequestOptions     // Catch:{ Exception -> 0x00c8 }
                java.lang.String r4 = "serverSideVerificationOptions"
                com.facebook.react.bridge.ReadableMap r2 = r2.getMap(r4)     // Catch:{ Exception -> 0x00c8 }
                if (r2 == 0) goto L_0x0097
                com.google.android.gms.ads.rewarded.ServerSideVerificationOptions$Builder r4 = new com.google.android.gms.ads.rewarded.ServerSideVerificationOptions$Builder     // Catch:{ Exception -> 0x00c8 }
                r4.<init>()     // Catch:{ Exception -> 0x00c8 }
                java.lang.String r5 = "userId"
                java.lang.String r5 = r2.getString(r5)     // Catch:{ Exception -> 0x00c8 }
                if (r5 == 0) goto L_0x0080
                r4.setUserId(r5)     // Catch:{ Exception -> 0x00c8 }
            L_0x0080:
                java.lang.String r5 = "customData"
                java.lang.String r2 = r2.getString(r5)     // Catch:{ Exception -> 0x00c8 }
                if (r2 == 0) goto L_0x008b
                r4.setCustomData(r2)     // Catch:{ Exception -> 0x00c8 }
            L_0x008b:
                com.google.android.gms.ads.rewarded.ServerSideVerificationOptions r2 = r4.build()     // Catch:{ Exception -> 0x00c8 }
                java.lang.String r4 = "build(...)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch:{ Exception -> 0x00c8 }
                r0.setServerSideVerificationOptions(r2)     // Catch:{ Exception -> 0x00c8 }
            L_0x0097:
                r5 = r3
            L_0x0098:
                boolean r2 = r9 instanceof com.google.android.gms.ads.admanager.AdManagerInterstitialAd     // Catch:{ Exception -> 0x00c8 }
                if (r2 == 0) goto L_0x00a6
                io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule<T> r2 = r8.this$0     // Catch:{ Exception -> 0x00c8 }
                io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$$ExternalSyntheticLambda1 r3 = new io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$$ExternalSyntheticLambda1     // Catch:{ Exception -> 0x00c8 }
                r3.<init>(r2, r8)     // Catch:{ Exception -> 0x00c8 }
                r0.setAppEventListener(r3)     // Catch:{ Exception -> 0x00c8 }
            L_0x00a6:
                io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$onAdLoaded$fullScreenContentCallback$1 r2 = new io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule$ReactNativeGoogleMobileAdsAdLoadCallback$onAdLoaded$fullScreenContentCallback$1     // Catch:{ Exception -> 0x00c8 }
                io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule<T> r3 = r8.this$0     // Catch:{ Exception -> 0x00c8 }
                r2.<init>(r3, r8)     // Catch:{ Exception -> 0x00c8 }
                com.google.android.gms.ads.FullScreenContentCallback r2 = (com.google.android.gms.ads.FullScreenContentCallback) r2     // Catch:{ Exception -> 0x00c8 }
                r0.setFullScreenContentCallback(r2)     // Catch:{ Exception -> 0x00c8 }
                io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule<T> r0 = r8.this$0     // Catch:{ Exception -> 0x00c8 }
                android.util.SparseArray r0 = r0.adArray     // Catch:{ Exception -> 0x00c8 }
                int r2 = r8.requestId     // Catch:{ Exception -> 0x00c8 }
                r0.put(r2, r9)     // Catch:{ Exception -> 0x00c8 }
                io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule<T> r0 = r8.this$0     // Catch:{ Exception -> 0x00c8 }
                int r2 = r8.requestId     // Catch:{ Exception -> 0x00c8 }
                java.lang.String r3 = r8.adUnitId     // Catch:{ Exception -> 0x00c8 }
                r4 = 0
                r0.sendAdEvent(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x00c8 }
                goto L_0x00f6
            L_0x00c8:
                r9 = move-exception
                java.lang.String r0 = "Unknown error on load"
                java.lang.String r1 = "RNGoogleMobileAds"
                android.util.Log.w(r1, r0)
                r0 = r9
                java.lang.Throwable r0 = (java.lang.Throwable) r0
                android.util.Log.w(r1, r0)
                com.facebook.react.bridge.WritableMap r6 = com.facebook.react.bridge.Arguments.createMap()
                java.lang.String r0 = "code"
                java.lang.String r1 = "internal"
                r6.putString(r0, r1)
                java.lang.String r0 = "message"
                java.lang.String r9 = r9.getMessage()
                r6.putString(r0, r9)
                io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule<T> r2 = r8.this$0
                java.lang.String r3 = "error"
                int r4 = r8.requestId
                java.lang.String r5 = r8.adUnitId
                r7 = 0
                r2.sendAdEvent(r3, r4, r5, r6, r7)
            L_0x00f6:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsFullScreenAdModule.ReactNativeGoogleMobileAdsAdLoadCallback.onAdLoaded(java.lang.Object):void");
        }

        /* access modifiers changed from: private */
        public static final void onAdLoaded$lambda$0(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, ReactNativeGoogleMobileAdsAdLoadCallback reactNativeGoogleMobileAdsAdLoadCallback, AdValue adValue) {
            Intrinsics.checkNotNullParameter(reactNativeGoogleMobileAdsFullScreenAdModule, "this$0");
            Intrinsics.checkNotNullParameter(reactNativeGoogleMobileAdsAdLoadCallback, "this$1");
            Intrinsics.checkNotNullParameter(adValue, "adValue");
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("value", ((double) adValue.getValueMicros()) * 1.0E-6d);
            createMap.putDouble("precision", ((double) adValue.getPrecisionType()) * 1.0d);
            createMap.putString(b.a, adValue.getCurrencyCode());
            reactNativeGoogleMobileAdsFullScreenAdModule.sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_PAID, reactNativeGoogleMobileAdsAdLoadCallback.requestId, reactNativeGoogleMobileAdsAdLoadCallback.adUnitId, (WritableMap) null, createMap);
        }

        /* access modifiers changed from: private */
        public static final void onAdLoaded$lambda$4(ReactNativeGoogleMobileAdsFullScreenAdModule reactNativeGoogleMobileAdsFullScreenAdModule, ReactNativeGoogleMobileAdsAdLoadCallback reactNativeGoogleMobileAdsAdLoadCallback, String str, String str2) {
            Intrinsics.checkNotNullParameter(reactNativeGoogleMobileAdsFullScreenAdModule, "this$0");
            Intrinsics.checkNotNullParameter(reactNativeGoogleMobileAdsAdLoadCallback, "this$1");
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(str2, "eventData");
            WritableMap createMap = Arguments.createMap();
            createMap.putString("name", str);
            createMap.putString("data", str2);
            reactNativeGoogleMobileAdsFullScreenAdModule.sendAdEvent(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_APP_EVENT, reactNativeGoogleMobileAdsAdLoadCallback.requestId, reactNativeGoogleMobileAdsAdLoadCallback.adUnitId, (WritableMap) null, createMap);
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            Intrinsics.checkNotNullParameter(loadAdError, "loadAdError");
            WritableMap createMap = Arguments.createMap();
            String[] codeAndMessageFromAdError = ReactNativeGoogleMobileAdsCommon.getCodeAndMessageFromAdError(loadAdError);
            createMap.putString("code", codeAndMessageFromAdError[0]);
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, codeAndMessageFromAdError[1]);
            this.this$0.sendAdEvent("error", this.requestId, this.adUnitId, createMap, (WritableMap) null);
        }
    }
}
