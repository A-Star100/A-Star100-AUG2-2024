package io.invertase.googlemobileads;

import android.app.Activity;
import android.preference.PreferenceManager;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;
import io.invertase.googlemobileads.common.ReactNativeModule;
import javax.annotation.Nonnull;

public class ReactNativeGoogleMobileAdsConsentModule extends ReactNativeModule {
    private static final String TAG = "RNGoogleMobileAdsConsentModule";
    private ConsentInformation consentInformation;

    private String getConsentStatusString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "UNKNOWN" : "OBTAINED" : "REQUIRED" : "NOT_REQUIRED";
    }

    public ReactNativeGoogleMobileAdsConsentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
        this.consentInformation = UserMessagingPlatform.getConsentInformation(reactApplicationContext);
    }

    /* renamed from: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$ump$ConsentInformation$PrivacyOptionsRequirementStatus;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.google.android.ump.ConsentInformation$PrivacyOptionsRequirementStatus[] r0 = com.google.android.ump.ConsentInformation.PrivacyOptionsRequirementStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$android$ump$ConsentInformation$PrivacyOptionsRequirementStatus = r0
                com.google.android.ump.ConsentInformation$PrivacyOptionsRequirementStatus r1 = com.google.android.ump.ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$android$ump$ConsentInformation$PrivacyOptionsRequirementStatus     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.android.ump.ConsentInformation$PrivacyOptionsRequirementStatus r1 = com.google.android.ump.ConsentInformation.PrivacyOptionsRequirementStatus.NOT_REQUIRED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$android$ump$ConsentInformation$PrivacyOptionsRequirementStatus     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.android.ump.ConsentInformation$PrivacyOptionsRequirementStatus r1 = com.google.android.ump.ConsentInformation.PrivacyOptionsRequirementStatus.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.invertase.googlemobileads.ReactNativeGoogleMobileAdsConsentModule.AnonymousClass1.<clinit>():void");
        }
    }

    private String getPrivacyOptionsRequirementStatusString(ConsentInformation.PrivacyOptionsRequirementStatus privacyOptionsRequirementStatus) {
        int i = AnonymousClass1.$SwitchMap$com$google$android$ump$ConsentInformation$PrivacyOptionsRequirementStatus[privacyOptionsRequirementStatus.ordinal()];
        if (i != 1) {
            return i != 2 ? "UNKNOWN" : "NOT_REQUIRED";
        }
        return "REQUIRED";
    }

    private WritableMap getConsentInformation() {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("status", getConsentStatusString(this.consentInformation.getConsentStatus()));
        createMap.putBoolean("canRequestAds", this.consentInformation.canRequestAds());
        createMap.putString("privacyOptionsRequirementStatus", getPrivacyOptionsRequirementStatusString(this.consentInformation.getPrivacyOptionsRequirementStatus()));
        createMap.putBoolean("isConsentFormAvailable", this.consentInformation.isConsentFormAvailable());
        return createMap;
    }

    @ReactMethod
    public void requestInfoUpdate(@Nonnull ReadableMap readableMap, Promise promise) {
        try {
            ConsentRequestParameters.Builder builder = new ConsentRequestParameters.Builder();
            ConsentDebugSettings.Builder builder2 = new ConsentDebugSettings.Builder(getApplicationContext());
            if (readableMap.hasKey("testDeviceIdentifiers")) {
                ReadableArray array = readableMap.getArray("testDeviceIdentifiers");
                for (int i = 0; i < array.size(); i++) {
                    builder2.addTestDeviceHashedId(array.getString(i));
                }
            }
            if (readableMap.hasKey("debugGeography")) {
                builder2.setDebugGeography(readableMap.getInt("debugGeography"));
            }
            builder.setConsentDebugSettings(builder2.build());
            if (readableMap.hasKey("tagForUnderAgeOfConsent")) {
                builder.setTagForUnderAgeOfConsent(readableMap.getBoolean("tagForUnderAgeOfConsent"));
            }
            ConsentRequestParameters build = builder.build();
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                rejectPromiseWithCodeAndMessage(promise, "null-activity", "Attempted to request a consent info update but the current Activity was null.");
            } else {
                this.consentInformation.requestConsentInfoUpdate(currentActivity, build, new ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda0(this, promise), new ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda1(promise));
            }
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-update-failed", e.toString());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$requestInfoUpdate$0(Promise promise) {
        promise.resolve(getConsentInformation());
    }

    @ReactMethod
    public void showForm(Promise promise) {
        try {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                rejectPromiseWithCodeAndMessage(promise, "null-activity", "Consent form attempted to show but the current Activity was null.");
            } else {
                currentActivity.runOnUiThread(new ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda4(this, currentActivity, promise));
            }
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-form-error", e.toString());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showForm$5(Activity activity, Promise promise) {
        UserMessagingPlatform.loadConsentForm(getReactApplicationContext(), new ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda2(this, activity, promise), new ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda3(promise));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showForm$3(Activity activity, Promise promise, ConsentForm consentForm) {
        consentForm.show(activity, new ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda5(this, promise));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showForm$2(Promise promise, FormError formError) {
        if (formError != null) {
            rejectPromiseWithCodeAndMessage(promise, "consent-form-error", formError.getMessage());
        } else {
            promise.resolve(getConsentInformation());
        }
    }

    @ReactMethod
    public void showPrivacyOptionsForm(Promise promise) {
        try {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                rejectPromiseWithCodeAndMessage(promise, "null-activity", "Privacy options form attempted to show but the current Activity was null.");
            } else {
                currentActivity.runOnUiThread(new ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda8(this, currentActivity, promise));
            }
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-form-error", e.toString());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showPrivacyOptionsForm$7(Activity activity, Promise promise) {
        UserMessagingPlatform.showPrivacyOptionsForm(activity, new ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda7(this, promise));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$showPrivacyOptionsForm$6(Promise promise, FormError formError) {
        if (formError != null) {
            rejectPromiseWithCodeAndMessage(promise, "privacy-options-form-error", formError.getMessage());
        } else {
            promise.resolve(getConsentInformation());
        }
    }

    @ReactMethod
    public void loadAndShowConsentFormIfRequired(Promise promise) {
        try {
            Activity currentActivity = getCurrentActivity();
            if (currentActivity == null) {
                rejectPromiseWithCodeAndMessage(promise, "null-activity", "Consent form attempted to load and show if required but the current Activity was null.");
            } else {
                currentActivity.runOnUiThread(new ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda6(this, currentActivity, promise));
            }
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-form-error", e.toString());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAndShowConsentFormIfRequired$9(Activity activity, Promise promise) {
        UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity, new ReactNativeGoogleMobileAdsConsentModule$$ExternalSyntheticLambda9(this, promise));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$loadAndShowConsentFormIfRequired$8(Promise promise, FormError formError) {
        if (formError != null) {
            rejectPromiseWithCodeAndMessage(promise, "consent-form-error", formError.getMessage());
        } else {
            promise.resolve(getConsentInformation());
        }
    }

    @ReactMethod
    public void getConsentInfo(Promise promise) {
        promise.resolve(getConsentInformation());
    }

    @ReactMethod
    public void reset() {
        this.consentInformation.reset();
    }

    @ReactMethod
    public void getTCString(Promise promise) {
        try {
            promise.resolve(PreferenceManager.getDefaultSharedPreferences(getReactApplicationContext()).getString("IABTCF_TCString", (String) null));
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-string-error", e.toString());
        }
    }

    @ReactMethod
    public void getGdprApplies(Promise promise) {
        try {
            boolean z = false;
            if (PreferenceManager.getDefaultSharedPreferences(getReactApplicationContext()).getInt("IABTCF_gdprApplies", 0) == 1) {
                z = true;
            }
            promise.resolve(Boolean.valueOf(z));
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-string-error", e.toString());
        }
    }

    @ReactMethod
    public void getPurposeConsents(Promise promise) {
        try {
            promise.resolve(PreferenceManager.getDefaultSharedPreferences(getReactApplicationContext()).getString("IABTCF_PurposeConsents", ""));
        } catch (Exception e) {
            rejectPromiseWithCodeAndMessage(promise, "consent-string-error", e.toString());
        }
    }
}
