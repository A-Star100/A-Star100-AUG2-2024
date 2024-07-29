package io.invertase.googlemobileads;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nonnull;

public class ReactNativeGoogleMobileAdsPackage implements ReactPackage {
    public /* synthetic */ NativeModule getModule(String str, ReactApplicationContext reactApplicationContext) {
        return ReactPackage.CC.$default$getModule(this, str, reactApplicationContext);
    }

    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ReactNativeAppModule(reactApplicationContext));
        arrayList.add(new ReactNativeGoogleMobileAdsModule(reactApplicationContext));
        arrayList.add(new ReactNativeGoogleMobileAdsConsentModule(reactApplicationContext));
        arrayList.add(new ReactNativeGoogleMobileAdsAppOpenModule(reactApplicationContext));
        arrayList.add(new ReactNativeGoogleMobileAdsInterstitialModule(reactApplicationContext));
        arrayList.add(new ReactNativeGoogleMobileAdsRewardedModule(reactApplicationContext));
        arrayList.add(new ReactNativeGoogleMobileAdsRewardedInterstitialModule(reactApplicationContext));
        return arrayList;
    }

    @Nonnull
    public List<ViewManager> createViewManagers(@Nonnull ReactApplicationContext reactApplicationContext) {
        return Arrays.asList(new ViewManager[]{new ReactNativeGoogleMobileAdsBannerAdViewManager()});
    }
}
