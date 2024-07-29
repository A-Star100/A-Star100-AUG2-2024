package io.invertase.googlemobileads;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import androidx.core.os.EnvironmentCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.admanager.AdManagerAdRequest;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import io.invertase.googlemobileads.common.ReactNativeEventEmitter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Nullable;

public class ReactNativeGoogleMobileAdsCommon {
    static AdSize getAdSizeForAdaptiveBanner(String str, ViewGroup viewGroup) {
        try {
            Display defaultDisplay = ((Activity) Objects.requireNonNull(((ReactContext) viewGroup.getContext()).getCurrentActivity())).getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i = (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
            if ("INLINE_ADAPTIVE_BANNER".equals(str)) {
                return AdSize.getCurrentOrientationInlineAdaptiveBannerAdSize(viewGroup.getContext(), i);
            }
            return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(viewGroup.getContext(), i);
        } catch (Exception unused) {
            return AdSize.BANNER;
        }
    }

    static AdSize getAdSize(String str, ViewGroup viewGroup) {
        if (str.matches("ADAPTIVE_BANNER|ANCHORED_ADAPTIVE_BANNER|INLINE_ADAPTIVE_BANNER")) {
            return getAdSizeForAdaptiveBanner(str, viewGroup);
        }
        return stringToAdSize(str);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.ads.AdSize stringToAdSize(java.lang.String r6) {
        /*
            java.lang.String r0 = "([0-9]+)x([0-9]+)"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r6)
            boolean r1 = r0.find()
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0028
            java.lang.String r6 = r0.group(r3)
            int r6 = java.lang.Integer.parseInt(r6)
            java.lang.String r0 = r0.group(r2)
            int r0 = java.lang.Integer.parseInt(r0)
            com.google.android.gms.ads.AdSize r1 = new com.google.android.gms.ads.AdSize
            r1.<init>(r6, r0)
            return r1
        L_0x0028:
            java.lang.String r6 = r6.toUpperCase()
            int r0 = r6.hashCode()
            r1 = 5
            r4 = 4
            r5 = 3
            switch(r0) {
                case -1966536496: goto L_0x0073;
                case -1008851236: goto L_0x0069;
                case -96588539: goto L_0x005f;
                case -14796567: goto L_0x0055;
                case 66994602: goto L_0x004b;
                case 446888797: goto L_0x0041;
                case 1951953708: goto L_0x0037;
                default: goto L_0x0036;
            }
        L_0x0036:
            goto L_0x007d
        L_0x0037:
            java.lang.String r0 = "BANNER"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x007d
            r6 = 7
            goto L_0x007e
        L_0x0041:
            java.lang.String r0 = "LEADERBOARD"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x007d
            r6 = r1
            goto L_0x007e
        L_0x004b:
            java.lang.String r0 = "FLUID"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x007d
            r6 = 0
            goto L_0x007e
        L_0x0055:
            java.lang.String r0 = "WIDE_SKYSCRAPER"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x007d
            r6 = r3
            goto L_0x007e
        L_0x005f:
            java.lang.String r0 = "MEDIUM_RECTANGLE"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x007d
            r6 = r5
            goto L_0x007e
        L_0x0069:
            java.lang.String r0 = "FULL_BANNER"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x007d
            r6 = r4
            goto L_0x007e
        L_0x0073:
            java.lang.String r0 = "LARGE_BANNER"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L_0x007d
            r6 = r2
            goto L_0x007e
        L_0x007d:
            r6 = -1
        L_0x007e:
            if (r6 == 0) goto L_0x009c
            if (r6 == r3) goto L_0x0099
            if (r6 == r2) goto L_0x0096
            if (r6 == r5) goto L_0x0093
            if (r6 == r4) goto L_0x0090
            if (r6 == r1) goto L_0x008d
            com.google.android.gms.ads.AdSize r6 = com.google.android.gms.ads.AdSize.BANNER
            return r6
        L_0x008d:
            com.google.android.gms.ads.AdSize r6 = com.google.android.gms.ads.AdSize.LEADERBOARD
            return r6
        L_0x0090:
            com.google.android.gms.ads.AdSize r6 = com.google.android.gms.ads.AdSize.FULL_BANNER
            return r6
        L_0x0093:
            com.google.android.gms.ads.AdSize r6 = com.google.android.gms.ads.AdSize.MEDIUM_RECTANGLE
            return r6
        L_0x0096:
            com.google.android.gms.ads.AdSize r6 = com.google.android.gms.ads.AdSize.LARGE_BANNER
            return r6
        L_0x0099:
            com.google.android.gms.ads.AdSize r6 = com.google.android.gms.ads.AdSize.WIDE_SKYSCRAPER
            return r6
        L_0x009c:
            com.google.android.gms.ads.AdSize r6 = com.google.android.gms.ads.AdSize.FLUID
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsCommon.stringToAdSize(java.lang.String):com.google.android.gms.ads.AdSize");
    }

    static WritableMap errorCodeToMap(int i) {
        WritableMap createMap = Arguments.createMap();
        if (i == 0) {
            createMap.putString("code", "error-code-internal-error");
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "Something happened internally; for instance, an invalid response was received from the ad server.");
        } else if (i == 1) {
            createMap.putString("code", "error-code-invalid-request");
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "The ad request was invalid; for instance, the ad unit ID was incorrect.");
        } else if (i == 2) {
            createMap.putString("code", "error-code-network-error");
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "The ad request was unsuccessful due to network connectivity.");
        } else if (i == 3) {
            createMap.putString("code", "error-code-no-fill");
            createMap.putString(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, "The ad request was successful, but no ad was returned due to lack of ad inventory.");
        }
        return createMap;
    }

    public static AdManagerAdRequest buildAdRequest(ReadableMap readableMap) {
        AdManagerAdRequest.Builder builder = new AdManagerAdRequest.Builder();
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("requestNonPersonalizedAdsOnly") && readableMap.getBoolean("requestNonPersonalizedAdsOnly")) {
            bundle.putString("npa", "1");
        }
        if (readableMap.hasKey("networkExtras")) {
            for (Map.Entry next : readableMap.getMap("networkExtras").toHashMap().entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
        }
        builder.addNetworkExtrasBundle(AdMobAdapter.class, bundle);
        if (readableMap.hasKey("keywords")) {
            Iterator<Object> it = ((ReadableArray) Objects.requireNonNull(readableMap.getArray("keywords"))).toArrayList().iterator();
            while (it.hasNext()) {
                builder.addKeyword((String) it.next());
            }
        }
        if (readableMap.hasKey("contentUrl")) {
            builder.setContentUrl((String) Objects.requireNonNull(readableMap.getString("contentUrl")));
        }
        if (readableMap.hasKey("requestAgent")) {
            builder.setRequestAgent((String) Objects.requireNonNull(readableMap.getString("requestAgent")));
        }
        if (readableMap.hasKey("customTargeting")) {
            for (Map.Entry next2 : readableMap.getMap("customTargeting").toHashMap().entrySet()) {
                String str = (String) next2.getKey();
                Object value = next2.getValue();
                if (value instanceof String) {
                    builder.addCustomTargeting(str, (String) value);
                } else {
                    builder.addCustomTargeting(str, (List<String>) (ArrayList) value);
                }
            }
        }
        if (readableMap.hasKey("publisherProvidedId")) {
            builder.setPublisherProvidedId((String) Objects.requireNonNull(readableMap.getString("publisherProvidedId")));
        }
        return builder.build();
    }

    public static void sendAdEvent(String str, int i, String str2, String str3, @Nullable WritableMap writableMap) {
        ReactNativeEventEmitter sharedInstance = ReactNativeEventEmitter.getSharedInstance();
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", str2);
        if (writableMap != null) {
            createMap.putMap("error", writableMap);
        }
        sharedInstance.sendEvent(new ReactNativeGoogleMobileAdsEvent(str, i, str3, createMap));
    }

    public static void sendAdEvent(String str, int i, String str2, String str3, @Nullable WritableMap writableMap, @Nullable WritableMap writableMap2) {
        ReactNativeEventEmitter sharedInstance = ReactNativeEventEmitter.getSharedInstance();
        WritableMap createMap = Arguments.createMap();
        createMap.putString("type", str2);
        if (writableMap != null) {
            createMap.putMap("error", writableMap);
        }
        if (writableMap2 != null) {
            createMap.putMap("data", writableMap2);
        }
        sharedInstance.sendEvent(new ReactNativeGoogleMobileAdsEvent(str, i, str3, createMap));
    }

    public static String[] getCodeAndMessageFromAdError(AdError adError) {
        String str;
        String message = adError.getMessage();
        int code = adError.getCode();
        if (code == 0) {
            str = "internal-error";
        } else if (code == 1) {
            str = "invalid-request";
        } else if (code == 2) {
            str = "network-error";
        } else if (code != 3) {
            switch (code) {
                case 8:
                    str = "app-id-missing";
                    break;
                case 9:
                    str = "mediation-no-fill";
                    break;
                case 10:
                    str = "request-id-mismatch";
                    break;
                case 11:
                    str = "invalid-ad-string";
                    break;
                default:
                    str = EnvironmentCompat.MEDIA_UNKNOWN;
                    break;
            }
        } else {
            str = "no-fill";
        }
        return new String[]{str, message};
    }

    public static boolean isAdManagerUnit(String str) {
        if (str == null) {
            return false;
        }
        return str.startsWith("/");
    }
}
