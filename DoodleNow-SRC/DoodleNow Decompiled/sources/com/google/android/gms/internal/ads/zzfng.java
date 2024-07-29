package com.google.android.gms.internal.ads;

import com.google.firebase.ktx.BuildConfig;
import io.invertase.googlemobileads.ReactNativeGoogleMobileAdsEvent;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzfng {
    DEFINED_BY_JAVASCRIPT("definedByJavaScript"),
    UNSPECIFIED(BuildConfig.VERSION_NAME),
    LOADED(ReactNativeGoogleMobileAdsEvent.GOOGLE_MOBILE_ADS_EVENT_LOADED),
    BEGIN_TO_RENDER("beginToRender"),
    ONE_PIXEL("onePixel"),
    VIEWABLE("viewable"),
    AUDIBLE("audible"),
    OTHER("other");
    
    private final String zzj;

    private zzfng(String str) {
        this.zzj = str;
    }

    public final String toString() {
        return this.zzj;
    }
}
