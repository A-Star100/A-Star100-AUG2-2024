package com.onesignal.notifications.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationsManager;
import com.onesignal.notifications.IPermissionObserver;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\nH\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0019\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/onesignal/notifications/internal/MisconfiguredNotificationsManager;", "Lcom/onesignal/notifications/INotificationsManager;", "()V", "canRequestPermission", "", "getCanRequestPermission", "()Z", "permission", "getPermission", "addClickListener", "", "listener", "Lcom/onesignal/notifications/INotificationClickListener;", "addForegroundLifecycleListener", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "addPermissionObserver", "observer", "Lcom/onesignal/notifications/IPermissionObserver;", "clearAllNotifications", "removeClickListener", "removeForegroundLifecycleListener", "removeGroupedNotifications", "group", "", "removeNotification", "id", "", "removePermissionObserver", "requestPermission", "fallbackToSettings", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: MisconfiguredNotificationsManager.kt */
public final class MisconfiguredNotificationsManager implements INotificationsManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final Exception EXCEPTION = new Exception("Must include gradle module com.onesignal:Notification in order to use this functionality!");

    public boolean getPermission() {
        throw EXCEPTION;
    }

    public boolean getCanRequestPermission() {
        throw EXCEPTION;
    }

    public Object requestPermission(boolean z, Continuation<? super Boolean> continuation) {
        throw EXCEPTION;
    }

    public Void removeNotification(int i) {
        throw EXCEPTION;
    }

    public Void removeGroupedNotifications(String str) {
        Intrinsics.checkNotNullParameter(str, "group");
        throw EXCEPTION;
    }

    public Void clearAllNotifications() {
        throw EXCEPTION;
    }

    public Void addPermissionObserver(IPermissionObserver iPermissionObserver) {
        Intrinsics.checkNotNullParameter(iPermissionObserver, "observer");
        throw EXCEPTION;
    }

    public Void removePermissionObserver(IPermissionObserver iPermissionObserver) {
        Intrinsics.checkNotNullParameter(iPermissionObserver, "observer");
        throw EXCEPTION;
    }

    public Void addForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        throw EXCEPTION;
    }

    public Void removeForegroundLifecycleListener(INotificationLifecycleListener iNotificationLifecycleListener) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        throw EXCEPTION;
    }

    public Void addClickListener(INotificationClickListener iNotificationClickListener) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        throw EXCEPTION;
    }

    public Void removeClickListener(INotificationClickListener iNotificationClickListener) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        throw EXCEPTION;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/notifications/internal/MisconfiguredNotificationsManager$Companion;", "", "()V", "EXCEPTION", "Ljava/lang/Exception;", "Lkotlin/Exception;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: MisconfiguredNotificationsManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
