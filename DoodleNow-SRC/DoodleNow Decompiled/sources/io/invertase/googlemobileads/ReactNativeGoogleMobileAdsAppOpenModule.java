package io.invertase.googlemobileads;

import android.app.Activity;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.google.android.gms.ads.AdLoadCallback;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.google.android.gms.ads.appopen.AppOpenAd;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001aB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J(\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u000bH\u0016J.\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0019H\u0016¨\u0006\u001b"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsAppOpenModule;", "Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsFullScreenAdModule;", "Lcom/google/android/gms/ads/appopen/AppOpenAd;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "appOpenLoad", "", "requestId", "", "adUnitId", "", "adRequestOptions", "Lcom/facebook/react/bridge/ReadableMap;", "appOpenShow", "showOptions", "promise", "Lcom/facebook/react/bridge/Promise;", "getAdEventName", "loadAd", "activity", "Landroid/app/Activity;", "adRequest", "Lcom/google/android/gms/ads/admanager/AdManagerAdRequest;", "adLoadCallback", "Lcom/google/android/gms/ads/AdLoadCallback;", "Companion", "react-native-google-mobile-ads_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReactNativeGoogleMobileAdsAppOpenModule.kt */
public final class ReactNativeGoogleMobileAdsAppOpenModule extends ReactNativeGoogleMobileAdsFullScreenAdModule<AppOpenAd> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NAME = "RNGoogleMobileAdsAppOpenModule";

    public String getAdEventName() {
        return ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_APP_OPEN;
    }

    public ReactNativeGoogleMobileAdsAppOpenModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, NAME);
    }

    @ReactMethod
    public final void appOpenLoad(int i, String str, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(readableMap, "adRequestOptions");
        load(i, str, readableMap);
    }

    @ReactMethod
    public final void appOpenShow(int i, String str, ReadableMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(readableMap, "showOptions");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        show(i, str, readableMap, promise);
    }

    public void loadAd(Activity activity, String str, AdManagerAdRequest adManagerAdRequest, AdLoadCallback<AppOpenAd> adLoadCallback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "adUnitId");
        Intrinsics.checkNotNullParameter(adManagerAdRequest, "adRequest");
        Intrinsics.checkNotNullParameter(adLoadCallback, "adLoadCallback");
        AppOpenAd.load(activity, str, adManagerAdRequest, new ReactNativeGoogleMobileAdsAppOpenModule$loadAd$1(adLoadCallback));
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lio/invertase/googlemobileads/ReactNativeGoogleMobileAdsAppOpenModule$Companion;", "", "()V", "NAME", "", "react-native-google-mobile-ads_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ReactNativeGoogleMobileAdsAppOpenModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
