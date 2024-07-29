package com.onesignal.rnonesignalandroid;

import android.content.Context;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.onesignal.Continue;
import com.onesignal.ContinueResult;
import com.onesignal.OneSignal;
import com.onesignal.common.OneSignalWrapper;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.debug.LogLevel;
import com.onesignal.inAppMessages.IInAppMessageClickEvent;
import com.onesignal.inAppMessages.IInAppMessageClickListener;
import com.onesignal.inAppMessages.IInAppMessageDidDismissEvent;
import com.onesignal.inAppMessages.IInAppMessageDidDisplayEvent;
import com.onesignal.inAppMessages.IInAppMessageLifecycleListener;
import com.onesignal.inAppMessages.IInAppMessageWillDismissEvent;
import com.onesignal.inAppMessages.IInAppMessageWillDisplayEvent;
import com.onesignal.notifications.IDisplayableNotification;
import com.onesignal.notifications.INotificationClickEvent;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationWillDisplayEvent;
import com.onesignal.notifications.IPermissionObserver;
import com.onesignal.user.state.IUserStateObserver;
import com.onesignal.user.state.UserChangedState;
import com.onesignal.user.subscriptions.IPushSubscriptionObserver;
import com.onesignal.user.subscriptions.PushSubscriptionChangedState;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public class RNOneSignal extends ReactContextBaseJavaModule implements IPushSubscriptionObserver, IPermissionObserver, IUserStateObserver, LifecycleEventListener, INotificationLifecycleListener {
    private boolean hasAddedInAppMessageClickListener = false;
    private boolean hasAddedInAppMessageLifecycleListener = false;
    private boolean hasAddedNotificationClickListener = false;
    private boolean hasAddedNotificationForegroundListener = false;
    private boolean hasSetPermissionObserver = false;
    private boolean hasSetPushSubscriptionObserver = false;
    private boolean hasSetUserStateObserver = false;
    private ReactApplicationContext mReactApplicationContext;
    private ReactContext mReactContext;
    private HashMap<String, INotificationWillDisplayEvent> notificationWillDisplayCache;
    private boolean oneSignalInitDone;
    private HashMap<String, INotificationWillDisplayEvent> preventDefaultCache;
    private IInAppMessageClickListener rnInAppClickListener = new IInAppMessageClickListener() {
        public void onClick(IInAppMessageClickEvent iInAppMessageClickEvent) {
            try {
                RNOneSignal.this.sendEvent("OneSignal-inAppMessageClicked", RNUtils.convertHashMapToWritableMap(RNUtils.convertInAppMessageClickEventToMap(iInAppMessageClickEvent)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
    private IInAppMessageLifecycleListener rnInAppLifecycleListener = new IInAppMessageLifecycleListener() {
        public void onWillDisplay(IInAppMessageWillDisplayEvent iInAppMessageWillDisplayEvent) {
            try {
                RNOneSignal.this.sendEvent("OneSignal-inAppMessageWillDisplay", RNUtils.convertHashMapToWritableMap(RNUtils.convertInAppMessageWillDisplayEventToMap(iInAppMessageWillDisplayEvent)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void onDidDisplay(IInAppMessageDidDisplayEvent iInAppMessageDidDisplayEvent) {
            try {
                RNOneSignal.this.sendEvent("OneSignal-inAppMessageDidDisplay", RNUtils.convertHashMapToWritableMap(RNUtils.convertInAppMessageDidDisplayEventToMap(iInAppMessageDidDisplayEvent)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void onWillDismiss(IInAppMessageWillDismissEvent iInAppMessageWillDismissEvent) {
            try {
                RNOneSignal.this.sendEvent("OneSignal-inAppMessageWillDismiss", RNUtils.convertHashMapToWritableMap(RNUtils.convertInAppMessageWillDismissEventToMap(iInAppMessageWillDismissEvent)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void onDidDismiss(IInAppMessageDidDismissEvent iInAppMessageDidDismissEvent) {
            try {
                RNOneSignal.this.sendEvent("OneSignal-inAppMessageDidDismiss", RNUtils.convertHashMapToWritableMap(RNUtils.convertInAppMessageDidDismissEventToMap(iInAppMessageDidDismissEvent)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
    private INotificationClickListener rnNotificationClickListener = new INotificationClickListener() {
        public void onClick(INotificationClickEvent iNotificationClickEvent) {
            try {
                RNOneSignal.this.sendEvent("OneSignal-notificationClicked", RNUtils.convertHashMapToWritableMap(RNUtils.convertNotificationClickEventToMap(iNotificationClickEvent)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    @ReactMethod
    public void addListener(String str) {
    }

    public String getName() {
        return PreferenceStores.ONESIGNAL;
    }

    public void onHostPause() {
    }

    public void onHostResume() {
    }

    @ReactMethod
    public void removeListeners(int i) {
    }

    private void removeObservers() {
        removePermissionObserver();
        removePushSubscriptionObserver();
        removeUserStateObserver();
    }

    private void removeHandlers() {
        if (!this.oneSignalInitDone) {
            Log.i(PreferenceStores.ONESIGNAL, "OneSignal React-Native SDK not initialized yet. Could not remove handlers.");
            return;
        }
        OneSignal.getInAppMessages().removeClickListener(this.rnInAppClickListener);
        this.hasAddedInAppMessageClickListener = false;
        OneSignal.getInAppMessages().removeLifecycleListener(this.rnInAppLifecycleListener);
        this.hasAddedInAppMessageLifecycleListener = false;
        OneSignal.getNotifications().removeClickListener(this.rnNotificationClickListener);
        this.hasAddedNotificationClickListener = false;
        OneSignal.getNotifications().removeForegroundLifecycleListener(this);
        this.hasAddedNotificationForegroundListener = false;
    }

    /* access modifiers changed from: private */
    public void sendEvent(String str, Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) this.mReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
    }

    public RNOneSignal(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        this.mReactContext = reactApplicationContext;
        reactApplicationContext.addLifecycleEventListener(this);
        this.notificationWillDisplayCache = new HashMap<>();
        this.preventDefaultCache = new HashMap<>();
    }

    public void onHostDestroy() {
        removeHandlers();
        removeObservers();
    }

    public void onCatalystInstanceDestroy() {
        removeHandlers();
        removeObservers();
    }

    @ReactMethod
    public void initialize(String str) {
        Context currentActivity = this.mReactApplicationContext.getCurrentActivity();
        OneSignalWrapper.setSdkType("reactnative");
        OneSignalWrapper.setSdkVersion("050201");
        if (this.oneSignalInitDone) {
            Log.e(PreferenceStores.ONESIGNAL, "Already initialized the OneSignal React-Native SDK");
            return;
        }
        this.oneSignalInitDone = true;
        if (currentActivity == null) {
            currentActivity = this.mReactApplicationContext.getApplicationContext();
        }
        OneSignal.initWithContext(currentActivity, str);
    }

    @ReactMethod
    public void setPrivacyConsentGiven(Boolean bool) {
        OneSignal.setConsentGiven(bool.booleanValue());
    }

    @ReactMethod
    public void setPrivacyConsentRequired(Boolean bool) {
        OneSignal.setConsentRequired(bool.booleanValue());
    }

    @ReactMethod
    public void setLogLevel(int i) {
        OneSignal.getDebug().setLogLevel(LogLevel.fromInt(i));
    }

    @ReactMethod
    public void setAlertLevel(int i) {
        OneSignal.getDebug().setAlertLevel(LogLevel.fromInt(i));
    }

    @ReactMethod
    public void addInAppMessageClickListener() {
        if (!this.hasAddedInAppMessageClickListener) {
            OneSignal.getInAppMessages().addClickListener(this.rnInAppClickListener);
            this.hasAddedInAppMessageClickListener = true;
        }
    }

    @ReactMethod
    public void addInAppMessagesLifecycleListener() {
        if (!this.hasAddedInAppMessageLifecycleListener) {
            OneSignal.getInAppMessages().addLifecycleListener(this.rnInAppLifecycleListener);
            this.hasAddedInAppMessageLifecycleListener = true;
        }
    }

    @ReactMethod
    public void getPaused(Promise promise) {
        promise.resolve(Boolean.valueOf(OneSignal.getInAppMessages().getPaused()));
    }

    @ReactMethod
    public void paused(Boolean bool) {
        OneSignal.getInAppMessages().setPaused(bool.booleanValue());
    }

    @ReactMethod
    public void addTrigger(String str, String str2) {
        OneSignal.getInAppMessages().addTrigger(str, str2);
    }

    @ReactMethod
    public void addTriggers(ReadableMap readableMap) {
        OneSignal.getInAppMessages().addTriggers(RNUtils.convertReadableMapIntoStringMap(readableMap));
    }

    @ReactMethod
    public void removeTrigger(String str) {
        OneSignal.getInAppMessages().removeTrigger(str);
    }

    @ReactMethod
    public void removeTriggers(ReadableArray readableArray) {
        OneSignal.getInAppMessages().removeTriggers(RNUtils.convertReadableArrayIntoStringCollection(readableArray));
    }

    @ReactMethod
    public void clearTriggers() {
        OneSignal.getInAppMessages().clearTriggers();
    }

    @ReactMethod
    public void requestLocationPermission() {
        OneSignal.getLocation().requestPermission(Continue.none());
    }

    @ReactMethod
    public void isLocationShared(Promise promise) {
        promise.resolve(Boolean.valueOf(OneSignal.getLocation().isShared()));
    }

    @ReactMethod
    public void setLocationShared(Boolean bool) {
        OneSignal.getLocation().setShared(bool.booleanValue());
    }

    @ReactMethod
    public void addNotificationClickListener() {
        if (!this.hasAddedNotificationClickListener) {
            OneSignal.getNotifications().addClickListener(this.rnNotificationClickListener);
            this.hasAddedNotificationClickListener = true;
        }
    }

    @ReactMethod
    public void addNotificationForegroundLifecycleListener() {
        if (!this.hasAddedNotificationForegroundListener) {
            OneSignal.getNotifications().addForegroundLifecycleListener(this);
            this.hasAddedNotificationForegroundListener = true;
        }
    }

    public void onWillDisplay(INotificationWillDisplayEvent iNotificationWillDisplayEvent) {
        if (!this.hasAddedNotificationForegroundListener) {
            iNotificationWillDisplayEvent.getNotification().display();
        }
        IDisplayableNotification notification = iNotificationWillDisplayEvent.getNotification();
        String notificationId = notification.getNotificationId();
        this.notificationWillDisplayCache.put(notificationId, iNotificationWillDisplayEvent);
        iNotificationWillDisplayEvent.preventDefault();
        try {
            sendEvent("OneSignal-notificationWillDisplayInForeground", RNUtils.convertHashMapToWritableMap(RNUtils.convertNotificationToMap(notification)));
            try {
                synchronized (iNotificationWillDisplayEvent) {
                    while (this.preventDefaultCache.containsKey(notificationId)) {
                        iNotificationWillDisplayEvent.wait();
                    }
                }
            } catch (InterruptedException e) {
                Log.e("InterruptedException" + e.toString(), (String) null);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    @ReactMethod
    private void displayNotification(String str) {
        INotificationWillDisplayEvent iNotificationWillDisplayEvent = this.notificationWillDisplayCache.get(str);
        if (iNotificationWillDisplayEvent == null) {
            Log.e("Could not find onWillDisplayNotification event for notification with id: " + str, (String) null);
            return;
        }
        iNotificationWillDisplayEvent.getNotification().display();
    }

    @ReactMethod
    private void preventDefault(String str) {
        INotificationWillDisplayEvent iNotificationWillDisplayEvent = this.notificationWillDisplayCache.get(str);
        if (iNotificationWillDisplayEvent == null) {
            Log.e("Could not find onWillDisplayNotification event for notification with id: " + str, (String) null);
            return;
        }
        iNotificationWillDisplayEvent.preventDefault();
        this.preventDefaultCache.put(str, iNotificationWillDisplayEvent);
    }

    @ReactMethod
    public void addPermissionObserver() {
        if (!this.hasSetPermissionObserver) {
            OneSignal.getNotifications().addPermissionObserver(this);
            this.hasSetPermissionObserver = true;
        }
    }

    @ReactMethod
    public void removePermissionObserver() {
        if (this.hasSetPermissionObserver) {
            OneSignal.getNotifications().removePermissionObserver(this);
            this.hasSetPermissionObserver = false;
        }
    }

    public void onNotificationPermissionChange(boolean z) {
        try {
            sendEvent("OneSignal-permissionChanged", RNUtils.convertHashMapToWritableMap(RNUtils.convertPermissionToMap(z)));
            Log.i(PreferenceStores.ONESIGNAL, "sending permission change event");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void requestNotificationPermission(boolean z, Promise promise) {
        if (OneSignal.getNotifications().getPermission()) {
            promise.resolve(true);
        } else {
            OneSignal.getNotifications().requestPermission(z, Continue.with(new RNOneSignal$$ExternalSyntheticLambda0(promise)));
        }
    }

    static /* synthetic */ void lambda$requestNotificationPermission$0(Promise promise, ContinueResult continueResult) {
        if (continueResult.isSuccess()) {
            promise.resolve(continueResult.getData());
        } else {
            promise.reject(continueResult.getThrowable().getMessage());
        }
    }

    @ReactMethod
    public void hasNotificationPermission(Promise promise) {
        promise.resolve(Boolean.valueOf(OneSignal.getNotifications().getPermission()));
    }

    @ReactMethod
    public void permissionNative(Promise promise) {
        if (OneSignal.getNotifications().getPermission()) {
            promise.resolve(2);
        } else {
            promise.resolve(1);
        }
    }

    @ReactMethod
    public void canRequestNotificationPermission(Promise promise) {
        promise.resolve(Boolean.valueOf(OneSignal.getNotifications().getCanRequestPermission()));
    }

    @ReactMethod
    public void clearAllNotifications() {
        OneSignal.getNotifications().clearAllNotifications();
    }

    @ReactMethod
    public void removeNotification(int i) {
        OneSignal.getNotifications().removeNotification(i);
    }

    @ReactMethod
    public void removeGroupedNotifications(String str) {
        OneSignal.getNotifications().removeGroupedNotifications(str);
    }

    @ReactMethod
    public void getPushSubscriptionId(Promise promise) {
        String id = OneSignal.getUser().getPushSubscription().getId();
        if (id == null || id.isEmpty()) {
            promise.resolve((Object) null);
        } else {
            promise.resolve(id);
        }
    }

    @ReactMethod
    public void getPushSubscriptionToken(Promise promise) {
        String token = OneSignal.getUser().getPushSubscription().getToken();
        if (token == null || token.isEmpty()) {
            promise.resolve((Object) null);
        } else {
            promise.resolve(token);
        }
    }

    @ReactMethod
    public void getOptedIn(Promise promise) {
        promise.resolve(Boolean.valueOf(OneSignal.getUser().getPushSubscription().getOptedIn()));
    }

    @ReactMethod
    public void optIn() {
        OneSignal.getUser().getPushSubscription().optIn();
    }

    @ReactMethod
    public void optOut() {
        OneSignal.getUser().getPushSubscription().optOut();
    }

    @ReactMethod
    public void addPushSubscriptionObserver() {
        if (!this.hasSetPushSubscriptionObserver) {
            OneSignal.getUser().getPushSubscription().addObserver(this);
            this.hasSetPushSubscriptionObserver = true;
        }
    }

    public void onPushSubscriptionChange(PushSubscriptionChangedState pushSubscriptionChangedState) {
        try {
            sendEvent("OneSignal-subscriptionChanged", RNUtils.convertHashMapToWritableMap(RNUtils.convertPushSubscriptionChangedStateToMap(pushSubscriptionChangedState)));
            Log.i(PreferenceStores.ONESIGNAL, "sending subscription change event");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void removePushSubscriptionObserver() {
        if (this.hasSetPushSubscriptionObserver) {
            OneSignal.getUser().getPushSubscription().removeObserver(this);
            this.hasSetPushSubscriptionObserver = false;
        }
    }

    @ReactMethod
    public void addOutcome(String str) {
        OneSignal.getSession().addOutcome(str);
    }

    @ReactMethod
    public void addUniqueOutcome(String str) {
        OneSignal.getSession().addUniqueOutcome(str);
    }

    @ReactMethod
    public void addOutcomeWithValue(String str, float f) {
        OneSignal.getSession().addOutcomeWithValue(str, f);
    }

    @ReactMethod
    public void login(String str) {
        OneSignal.login(str);
    }

    @ReactMethod
    public void logout() {
        OneSignal.logout();
    }

    @ReactMethod
    public void setLanguage(String str) {
        OneSignal.getUser().setLanguage(str);
    }

    @ReactMethod
    public void addTag(String str, String str2) {
        OneSignal.getUser().addTag(str, str2);
    }

    @ReactMethod
    public void removeTag(String str) {
        OneSignal.getUser().removeTag(str);
    }

    @ReactMethod
    public void addTags(ReadableMap readableMap) {
        OneSignal.getUser().addTags(RNUtils.convertReadableMapIntoStringMap(readableMap));
    }

    @ReactMethod
    public void removeTags(ReadableArray readableArray) {
        OneSignal.getUser().removeTags(RNUtils.convertReadableArrayIntoStringCollection(readableArray));
    }

    @ReactMethod
    public void getTags(Promise promise) {
        Map<String, String> tags = OneSignal.getUser().getTags();
        WritableMap createMap = Arguments.createMap();
        for (Map.Entry next : tags.entrySet()) {
            createMap.putString((String) next.getKey(), (String) next.getValue());
        }
        promise.resolve(createMap);
    }

    @ReactMethod
    public void addEmail(String str, Promise promise) {
        try {
            OneSignal.getUser().addEmail(str);
            promise.resolve((Object) null);
        } catch (Throwable th) {
            promise.reject(th.getMessage());
        }
    }

    @ReactMethod
    public void removeEmail(String str, Promise promise) {
        try {
            OneSignal.getUser().removeEmail(str);
            promise.resolve((Object) null);
        } catch (Throwable th) {
            promise.reject(th.getMessage());
        }
    }

    @ReactMethod
    public void addSms(String str, Promise promise) {
        try {
            OneSignal.getUser().addSms(str);
            promise.resolve((Object) null);
        } catch (Throwable th) {
            promise.reject(th.getMessage());
        }
    }

    @ReactMethod
    public void removeSms(String str, Promise promise) {
        try {
            OneSignal.getUser().removeSms(str);
            promise.resolve((Object) null);
        } catch (Throwable th) {
            promise.reject(th.getMessage());
        }
    }

    @ReactMethod
    public void addAlias(String str, String str2) {
        OneSignal.getUser().addAlias(str, str2);
    }

    @ReactMethod
    public void removeAlias(String str) {
        OneSignal.getUser().removeAlias(str);
    }

    @ReactMethod
    public void addAliases(ReadableMap readableMap) {
        OneSignal.getUser().addAliases(RNUtils.convertReadableMapIntoStringMap(readableMap));
    }

    @ReactMethod
    public void removeAliases(ReadableArray readableArray) {
        OneSignal.getUser().removeAliases(RNUtils.convertReadableArrayIntoStringCollection(readableArray));
    }

    @ReactMethod
    public void getOnesignalId(Promise promise) {
        String onesignalId = OneSignal.getUser().getOnesignalId();
        if (onesignalId.isEmpty()) {
            onesignalId = null;
        }
        promise.resolve(onesignalId);
    }

    @ReactMethod
    public void getExternalId(Promise promise) {
        String externalId = OneSignal.getUser().getExternalId();
        if (externalId.isEmpty()) {
            externalId = null;
        }
        promise.resolve(externalId);
    }

    @ReactMethod
    public void addUserStateObserver() {
        if (!this.hasSetUserStateObserver) {
            OneSignal.getUser().addObserver(this);
            this.hasSetUserStateObserver = true;
        }
    }

    public void onUserStateChange(UserChangedState userChangedState) {
        try {
            sendEvent("OneSignal-userStateChanged", RNUtils.convertHashMapToWritableMap(RNUtils.convertUserChangedStateToMap(userChangedState)));
            Log.i(PreferenceStores.ONESIGNAL, "sending user state change event");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void removeUserStateObserver() {
        if (this.hasSetUserStateObserver) {
            OneSignal.getUser().removeObserver(this);
            this.hasSetUserStateObserver = false;
        }
    }
}
