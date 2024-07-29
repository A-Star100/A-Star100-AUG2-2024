package io.invertase.googlemobileads;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.BaseAdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.admanager.AdManagerAdView;
import com.google.android.gms.ads.admanager.AppEventListener;
import io.invertase.googlemobileads.common.ReactNativeAdView;
import io.invertase.googlemobileads.common.SharedUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

public class ReactNativeGoogleMobileAdsBannerAdViewManager extends SimpleViewManager<ReactNativeAdView> {
    private static final String REACT_CLASS = "RNGoogleMobileAdsBannerView";
    private final int COMMAND_ID_LOAD = 2;
    private final int COMMAND_ID_RECORD_MANUAL_IMPRESSION = 1;
    private final String EVENT_AD_CLOSED = "onAdClosed";
    private final String EVENT_AD_FAILED_TO_LOAD = "onAdFailedToLoad";
    private final String EVENT_AD_LOADED = "onAdLoaded";
    private final String EVENT_AD_OPENED = "onAdOpened";
    private final String EVENT_APP_EVENT = "onAppEvent";
    private final String EVENT_PAID = "onPaid";
    private final String EVENT_SIZE_CHANGE = "onSizeChange";

    @Nonnull
    public String getName() {
        return REACT_CLASS;
    }

    @Nonnull
    public ReactNativeAdView createViewInstance(@Nonnull ThemedReactContext themedReactContext) {
        return new ReactNativeAdView(themedReactContext);
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        MapBuilder.Builder builder = MapBuilder.builder();
        builder.put(OnNativeEvent.EVENT_NAME, MapBuilder.of("registrationName", "onNativeEvent"));
        return builder.build();
    }

    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("recordManualImpression", 1, "load", 2);
    }

    public void receiveCommand(ReactNativeAdView reactNativeAdView, String str, @Nullable ReadableArray readableArray) {
        super.receiveCommand(reactNativeAdView, str, readableArray);
        int parseInt = Integer.parseInt(str);
        if (parseInt == 1) {
            BaseAdView adView = getAdView(reactNativeAdView);
            if (adView instanceof AdManagerAdView) {
                ((AdManagerAdView) adView).recordManualImpression();
            }
        } else if (parseInt == 2) {
            getAdView(reactNativeAdView).loadAd(reactNativeAdView.getRequest());
        }
    }

    @ReactProp(name = "unitId")
    public void setUnitId(ReactNativeAdView reactNativeAdView, String str) {
        reactNativeAdView.setUnitId(str);
        reactNativeAdView.setPropsChanged(true);
    }

    @ReactProp(name = "request")
    public void setRequest(ReactNativeAdView reactNativeAdView, String str) {
        try {
            reactNativeAdView.setRequest(ReactNativeGoogleMobileAdsCommon.buildAdRequest(SharedUtils.jsonObjectToWritableMap(new JSONObject(str))));
            reactNativeAdView.setPropsChanged(true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @ReactProp(name = "sizes")
    public void setSizes(ReactNativeAdView reactNativeAdView, ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        Iterator<Object> it = readableArray.toArrayList().iterator();
        while (it.hasNext()) {
            Object next = it.next();
            if (next instanceof String) {
                arrayList.add(ReactNativeGoogleMobileAdsCommon.getAdSize((String) next, reactNativeAdView));
            }
        }
        if (arrayList.size() > 0 && !arrayList.contains(AdSize.FLUID)) {
            AdSize adSize = (AdSize) arrayList.get(0);
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("width", (double) adSize.getWidth());
            createMap.putDouble("height", (double) adSize.getHeight());
            sendEvent(reactNativeAdView, "onSizeChange", createMap);
        }
        reactNativeAdView.setSizes(arrayList);
        reactNativeAdView.setPropsChanged(true);
    }

    @ReactProp(name = "manualImpressionsEnabled")
    public void setManualImpressionsEnabled(ReactNativeAdView reactNativeAdView, boolean z) {
        reactNativeAdView.setManualImpressionsEnabled(z);
        reactNativeAdView.setPropsChanged(true);
    }

    public void onAfterUpdateTransaction(ReactNativeAdView reactNativeAdView) {
        super.onAfterUpdateTransaction(reactNativeAdView);
        if (reactNativeAdView.getPropsChanged()) {
            requestAd(reactNativeAdView);
        }
        reactNativeAdView.setPropsChanged(false);
    }

    public void onDropViewInstance(ReactNativeAdView reactNativeAdView) {
        BaseAdView adView = getAdView(reactNativeAdView);
        if (adView != null) {
            adView.setAdListener((AdListener) null);
            if (adView instanceof AdManagerAdView) {
                ((AdManagerAdView) adView).setAppEventListener((AppEventListener) null);
            }
            adView.destroy();
            reactNativeAdView.removeView(adView);
        }
        super.onDropViewInstance(reactNativeAdView);
    }

    private BaseAdView initAdView(final ReactNativeAdView reactNativeAdView) {
        final BaseAdView baseAdView;
        BaseAdView adView = getAdView(reactNativeAdView);
        if (adView != null) {
            adView.setAdListener((AdListener) null);
            if (adView instanceof AdManagerAdView) {
                ((AdManagerAdView) adView).setAppEventListener((AppEventListener) null);
            }
            adView.destroy();
            reactNativeAdView.removeView(adView);
        }
        Activity currentActivity = ((ReactContext) reactNativeAdView.getContext()).getCurrentActivity();
        if (currentActivity == null) {
            return null;
        }
        if (ReactNativeGoogleMobileAdsCommon.isAdManagerUnit(reactNativeAdView.getUnitId())) {
            baseAdView = new AdManagerAdView(currentActivity);
        } else {
            baseAdView = new AdView(currentActivity);
        }
        baseAdView.setDescendantFocusability(393216);
        baseAdView.setOnPaidEventListener(new OnPaidEventListener() {
            public void onPaidEvent(AdValue adValue) {
                WritableMap createMap = Arguments.createMap();
                createMap.putDouble("value", ((double) adValue.getValueMicros()) * 1.0E-6d);
                createMap.putDouble("precision", (double) adValue.getPrecisionType());
                createMap.putString(b.a, adValue.getCurrencyCode());
                ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onPaid", createMap);
            }
        });
        baseAdView.setAdListener(new AdListener() {
            public void onAdLoaded() {
                int i;
                int i2;
                AdSize adSize = baseAdView.getAdSize();
                if (reactNativeAdView.getIsFluid()) {
                    i2 = reactNativeAdView.getWidth();
                    i = reactNativeAdView.getHeight();
                    baseAdView.addOnLayoutChangeListener(new ReactNativeGoogleMobileAdsBannerAdViewManager$2$$ExternalSyntheticLambda0(this, reactNativeAdView));
                } else {
                    int left = baseAdView.getLeft();
                    int top = baseAdView.getTop();
                    int widthInPixels = adSize.getWidthInPixels(reactNativeAdView.getContext());
                    int heightInPixels = adSize.getHeightInPixels(reactNativeAdView.getContext());
                    baseAdView.measure(widthInPixels, heightInPixels);
                    baseAdView.layout(left, top, left + widthInPixels, top + heightInPixels);
                    i = heightInPixels;
                    i2 = widthInPixels;
                }
                WritableMap createMap = Arguments.createMap();
                createMap.putDouble("width", (double) PixelUtil.toDIPFromPixel((float) i2));
                createMap.putDouble("height", (double) PixelUtil.toDIPFromPixel((float) i));
                ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onAdLoaded", createMap);
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void lambda$onAdLoaded$0(ReactNativeAdView reactNativeAdView, View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                WritableMap createMap = Arguments.createMap();
                createMap.putDouble("width", (double) PixelUtil.toDIPFromPixel((float) (i3 - i)));
                createMap.putDouble("height", (double) PixelUtil.toDIPFromPixel((float) (i4 - i2)));
                ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onSizeChange", createMap);
            }

            public void onAdFailedToLoad(LoadAdError loadAdError) {
                ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onAdFailedToLoad", ReactNativeGoogleMobileAdsCommon.errorCodeToMap(loadAdError.getCode()));
            }

            public void onAdOpened() {
                ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onAdOpened", (WritableMap) null);
            }

            public void onAdClosed() {
                ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onAdClosed", (WritableMap) null);
            }
        });
        if (baseAdView instanceof AdManagerAdView) {
            ((AdManagerAdView) baseAdView).setAppEventListener(new AppEventListener() {
                public void onAppEvent(String str, @Nullable String str2) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("name", str);
                    createMap.putString("data", str2);
                    ReactNativeGoogleMobileAdsBannerAdViewManager.this.sendEvent(reactNativeAdView, "onAppEvent", createMap);
                }
            });
        }
        reactNativeAdView.addView(baseAdView);
        return baseAdView;
    }

    @Nullable
    private BaseAdView getAdView(ViewGroup viewGroup) {
        return (BaseAdView) viewGroup.getChildAt(0);
    }

    private void requestAd(ReactNativeAdView reactNativeAdView) {
        BaseAdView initAdView;
        String unitId = reactNativeAdView.getUnitId();
        List<AdSize> sizes = reactNativeAdView.getSizes();
        AdRequest request = reactNativeAdView.getRequest();
        Boolean valueOf = Boolean.valueOf(reactNativeAdView.getManualImpressionsEnabled());
        if (sizes != null && unitId != null && request != null && valueOf != null && (initAdView = initAdView(reactNativeAdView)) != null) {
            initAdView.setAdUnitId(unitId);
            reactNativeAdView.setIsFluid(false);
            if (initAdView instanceof AdManagerAdView) {
                if (sizes.contains(AdSize.FLUID)) {
                    reactNativeAdView.setIsFluid(true);
                }
                AdManagerAdView adManagerAdView = (AdManagerAdView) initAdView;
                adManagerAdView.setAdSizes((AdSize[]) sizes.toArray(new AdSize[0]));
                if (valueOf.booleanValue()) {
                    adManagerAdView.setManualImpressionsEnabled(true);
                }
            } else {
                initAdView.setAdSize(sizes.get(0));
            }
            initAdView.loadAd(request);
        }
    }

    /* access modifiers changed from: private */
    public void sendEvent(ReactNativeAdView reactNativeAdView, String str, WritableMap writableMap) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", str);
        if (writableMap != null) {
            createMap.merge(writableMap);
        }
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag((ThemedReactContext) reactNativeAdView.getContext(), reactNativeAdView.getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new OnNativeEvent(reactNativeAdView.getId(), createMap));
        }
    }
}
