package com.revenuecat.purchases.hybridcommon;

import com.revenuecat.purchases.Purchases;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010$\n\u0002\b\u001d\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0010\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u0005\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u0007\u001a\u00020\u00012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u000b\u001a\u00020\u00012\b\u0010\f\u001a\u0004\u0018\u00010\u0004\u001a\u001c\u0010\r\u001a\u00020\u00012\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u000f\u001a\u0010\u0010\u0010\u001a\u00020\u00012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u0012\u001a\u00020\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u0014\u001a\u00020\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u0016\u001a\u00020\u00012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u0018\u001a\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u001a\u001a\u00020\u00012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u001c\u001a\u00020\u00012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\u001e\u001a\u00020\u00012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010 \u001a\u00020\u00012\b\u0010!\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010\"\u001a\u00020\u00012\b\u0010#\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010$\u001a\u00020\u00012\b\u0010%\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010&\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010(\u001a\u00020\u00012\b\u0010)\u001a\u0004\u0018\u00010\u0004\u001a\u0010\u0010*\u001a\u00020\u00012\b\u0010+\u001a\u0004\u0018\u00010\u0004¨\u0006,"}, d2 = {"collectDeviceIdentifiers", "", "setAd", "ad", "", "setAdGroup", "adGroup", "setAdjustID", "adjustID", "setAirshipChannelID", "airshipChannelID", "setAppsflyerID", "appsflyerID", "setAttributes", "attributes", "", "setCampaign", "campaign", "setCleverTapID", "cleverTapID", "setCreative", "creative", "setDisplayName", "displayName", "setEmail", "email", "setFBAnonymousID", "fbAnonymousID", "setFirebaseAppInstanceID", "firebaseAppInstanceID", "setKeyword", "keyword", "setMediaSource", "mediaSource", "setMixpanelDistinctID", "mixpanelDistinctID", "setMparticleID", "mparticleID", "setOnesignalID", "onesignalID", "setPhoneNumber", "phoneNumber", "setPushToken", "fcmToken", "hybridcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: subscriberAttributes.kt */
public final class SubscriberAttributesKt {
    public static final void collectDeviceIdentifiers() {
        Purchases.Companion.getSharedInstance().collectDeviceIdentifiers();
    }

    public static final void setAdjustID(String str) {
        Purchases.Companion.getSharedInstance().setAdjustID(str);
    }

    public static final void setAppsflyerID(String str) {
        Purchases.Companion.getSharedInstance().setAppsflyerID(str);
    }

    public static final void setFBAnonymousID(String str) {
        Purchases.Companion.getSharedInstance().setFBAnonymousID(str);
    }

    public static final void setMparticleID(String str) {
        Purchases.Companion.getSharedInstance().setMparticleID(str);
    }

    public static final void setCleverTapID(String str) {
        Purchases.Companion.getSharedInstance().setCleverTapID(str);
    }

    public static final void setMixpanelDistinctID(String str) {
        Purchases.Companion.getSharedInstance().setMixpanelDistinctID(str);
    }

    public static final void setFirebaseAppInstanceID(String str) {
        Purchases.Companion.getSharedInstance().setFirebaseAppInstanceID(str);
    }

    public static final void setOnesignalID(String str) {
        Purchases.Companion.getSharedInstance().setOnesignalID(str);
    }

    public static final void setAirshipChannelID(String str) {
        Purchases.Companion.getSharedInstance().setAirshipChannelID(str);
    }

    public static final void setMediaSource(String str) {
        Purchases.Companion.getSharedInstance().setMediaSource(str);
    }

    public static final void setCampaign(String str) {
        Purchases.Companion.getSharedInstance().setCampaign(str);
    }

    public static final void setAdGroup(String str) {
        Purchases.Companion.getSharedInstance().setAdGroup(str);
    }

    public static final void setAd(String str) {
        Purchases.Companion.getSharedInstance().setAd(str);
    }

    public static final void setKeyword(String str) {
        Purchases.Companion.getSharedInstance().setKeyword(str);
    }

    public static final void setCreative(String str) {
        Purchases.Companion.getSharedInstance().setCreative(str);
    }

    public static final void setAttributes(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "attributes");
        Purchases.Companion.getSharedInstance().setAttributes(map);
    }

    public static final void setEmail(String str) {
        Purchases.Companion.getSharedInstance().setEmail(str);
    }

    public static final void setPhoneNumber(String str) {
        Purchases.Companion.getSharedInstance().setPhoneNumber(str);
    }

    public static final void setDisplayName(String str) {
        Purchases.Companion.getSharedInstance().setDisplayName(str);
    }

    public static final void setPushToken(String str) {
        Purchases.Companion.getSharedInstance().setPushToken(str);
    }
}
