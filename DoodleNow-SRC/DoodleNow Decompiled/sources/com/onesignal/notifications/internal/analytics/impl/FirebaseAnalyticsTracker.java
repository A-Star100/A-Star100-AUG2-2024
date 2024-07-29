package com.onesignal.notifications.internal.analytics.impl;

import android.content.Context;
import android.os.Bundle;
import com.google.firebase.messaging.Constants;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.preferences.PreferenceStores;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.analytics.IAnalyticsTracker;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\n\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016J\u0018\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/onesignal/notifications/internal/analytics/impl/FirebaseAnalyticsTracker;", "Lcom/onesignal/notifications/internal/analytics/IAnalyticsTracker;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/time/ITime;)V", "isEnabled", "", "()Z", "lastOpenedTime", "Ljava/util/concurrent/atomic/AtomicLong;", "lastReceivedNotificationCampaign", "", "lastReceivedNotificationId", "lastReceivedTime", "mFirebaseAnalyticsInstance", "", "getFirebaseAnalyticsInstance", "trackInfluenceOpenEvent", "", "trackOpenedEvent", "notificationId", "campaign", "trackReceivedEvent", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FirebaseAnalyticsTracker.kt */
public final class FirebaseAnalyticsTracker implements IAnalyticsTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EVENT_NOTIFICATION_INFLUENCE_OPEN = "os_notification_influence_open";
    private static final String EVENT_NOTIFICATION_OPENED = "os_notification_opened";
    private static final String EVENT_NOTIFICATION_RECEIVED = "os_notification_received";
    /* access modifiers changed from: private */
    public static Class<?> firebaseAnalyticsClass;
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final ITime _time;
    private AtomicLong lastOpenedTime;
    private String lastReceivedNotificationCampaign;
    private String lastReceivedNotificationId;
    private AtomicLong lastReceivedTime;
    private Object mFirebaseAnalyticsInstance;

    public FirebaseAnalyticsTracker(IApplicationService iApplicationService, ConfigModelStore configModelStore, ITime iTime) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        this._applicationService = iApplicationService;
        this._configModelStore = configModelStore;
        this._time = iTime;
    }

    private final boolean isEnabled() {
        return ((ConfigModel) this._configModelStore.getModel()).getFirebaseAnalytics();
    }

    public void trackInfluenceOpenEvent() {
        if (isEnabled() && this.lastReceivedTime != null && this.lastReceivedNotificationId != null) {
            long currentTimeMillis = this._time.getCurrentTimeMillis();
            AtomicLong atomicLong = this.lastReceivedTime;
            Intrinsics.checkNotNull(atomicLong);
            if (currentTimeMillis - atomicLong.get() <= 120000) {
                AtomicLong atomicLong2 = this.lastOpenedTime;
                if (atomicLong2 != null) {
                    Intrinsics.checkNotNull(atomicLong2);
                    if (currentTimeMillis - atomicLong2.get() < 30000) {
                        return;
                    }
                }
                try {
                    Object firebaseAnalyticsInstance = getFirebaseAnalyticsInstance();
                    Method access$getTrackMethod = Companion.getTrackMethod(firebaseAnalyticsClass);
                    Bundle bundle = new Bundle();
                    bundle.putString("source", PreferenceStores.ONESIGNAL);
                    bundle.putString(Constants.ScionAnalytics.PARAM_MEDIUM, OneSignalDbContract.NotificationTable.TABLE_NAME);
                    String str = this.lastReceivedNotificationId;
                    Intrinsics.checkNotNull(str);
                    bundle.putString("notification_id", str);
                    String str2 = this.lastReceivedNotificationCampaign;
                    Intrinsics.checkNotNull(str2);
                    bundle.putString(Constants.ScionAnalytics.PARAM_CAMPAIGN, str2);
                    Intrinsics.checkNotNull(access$getTrackMethod);
                    access$getTrackMethod.invoke(firebaseAnalyticsInstance, new Object[]{EVENT_NOTIFICATION_INFLUENCE_OPEN, bundle});
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }

    public void trackOpenedEvent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "notificationId");
        Intrinsics.checkNotNullParameter(str2, Constants.ScionAnalytics.PARAM_CAMPAIGN);
        if (isEnabled()) {
            if (this.lastOpenedTime == null) {
                this.lastOpenedTime = new AtomicLong();
            }
            AtomicLong atomicLong = this.lastOpenedTime;
            Intrinsics.checkNotNull(atomicLong);
            atomicLong.set(this._time.getCurrentTimeMillis());
            try {
                Object firebaseAnalyticsInstance = getFirebaseAnalyticsInstance();
                Method access$getTrackMethod = Companion.getTrackMethod(firebaseAnalyticsClass);
                Bundle bundle = new Bundle();
                bundle.putString("source", PreferenceStores.ONESIGNAL);
                bundle.putString(Constants.ScionAnalytics.PARAM_MEDIUM, OneSignalDbContract.NotificationTable.TABLE_NAME);
                bundle.putString("notification_id", str);
                bundle.putString(Constants.ScionAnalytics.PARAM_CAMPAIGN, str2);
                Intrinsics.checkNotNull(access$getTrackMethod);
                access$getTrackMethod.invoke(firebaseAnalyticsInstance, new Object[]{EVENT_NOTIFICATION_OPENED, bundle});
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void trackReceivedEvent(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "notificationId");
        Intrinsics.checkNotNullParameter(str2, Constants.ScionAnalytics.PARAM_CAMPAIGN);
        if (isEnabled()) {
            try {
                Object firebaseAnalyticsInstance = getFirebaseAnalyticsInstance();
                Method access$getTrackMethod = Companion.getTrackMethod(firebaseAnalyticsClass);
                Bundle bundle = new Bundle();
                bundle.putString("source", PreferenceStores.ONESIGNAL);
                bundle.putString(Constants.ScionAnalytics.PARAM_MEDIUM, OneSignalDbContract.NotificationTable.TABLE_NAME);
                bundle.putString("notification_id", str);
                bundle.putString(Constants.ScionAnalytics.PARAM_CAMPAIGN, str2);
                Intrinsics.checkNotNull(access$getTrackMethod);
                access$getTrackMethod.invoke(firebaseAnalyticsInstance, new Object[]{EVENT_NOTIFICATION_RECEIVED, bundle});
                if (this.lastReceivedTime == null) {
                    this.lastReceivedTime = new AtomicLong();
                }
                AtomicLong atomicLong = this.lastReceivedTime;
                Intrinsics.checkNotNull(atomicLong);
                atomicLong.set(this._time.getCurrentTimeMillis());
                this.lastReceivedNotificationId = str;
                this.lastReceivedNotificationCampaign = str2;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private final Object getFirebaseAnalyticsInstance() {
        if (this.mFirebaseAnalyticsInstance == null) {
            Method access$getInstanceMethod = Companion.getInstanceMethod(firebaseAnalyticsClass);
            try {
                Intrinsics.checkNotNull(access$getInstanceMethod);
                this.mFirebaseAnalyticsInstance = access$getInstanceMethod.invoke((Object) null, new Object[]{this._applicationService.getAppContext()});
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return this.mFirebaseAnalyticsInstance;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0002J\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/onesignal/notifications/internal/analytics/impl/FirebaseAnalyticsTracker$Companion;", "", "()V", "EVENT_NOTIFICATION_INFLUENCE_OPEN", "", "EVENT_NOTIFICATION_OPENED", "EVENT_NOTIFICATION_RECEIVED", "firebaseAnalyticsClass", "Ljava/lang/Class;", "canTrack", "", "getInstanceMethod", "Ljava/lang/reflect/Method;", "clazz", "getTrackMethod", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FirebaseAnalyticsTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean canTrack() {
            try {
                FirebaseAnalyticsTracker.firebaseAnalyticsClass = Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
                return true;
            } catch (ClassNotFoundException unused) {
                return false;
            }
        }

        /* access modifiers changed from: private */
        public final Method getTrackMethod(Class<?> cls) {
            try {
                Intrinsics.checkNotNull(cls);
                return cls.getMethod("logEvent", new Class[]{String.class, Bundle.class});
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                Method method = null;
                return null;
            }
        }

        /* access modifiers changed from: private */
        public final Method getInstanceMethod(Class<?> cls) {
            try {
                Intrinsics.checkNotNull(cls);
                return cls.getMethod("getInstance", new Class[]{Context.class});
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
                Method method = null;
                return null;
            }
        }
    }
}
