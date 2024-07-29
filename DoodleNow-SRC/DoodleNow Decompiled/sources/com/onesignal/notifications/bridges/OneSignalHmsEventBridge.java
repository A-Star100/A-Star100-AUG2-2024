package com.onesignal.notifications.bridges;

import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.push.RemoteMessage;
import com.onesignal.OneSignal;
import com.onesignal.common.JSONUtils;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J \u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/onesignal/notifications/bridges/OneSignalHmsEventBridge;", "", "()V", "HMS_SENT_TIME_KEY", "", "HMS_TTL_KEY", "firstToken", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onMessageReceived", "", "context", "Landroid/content/Context;", "message", "Lcom/huawei/hms/push/RemoteMessage;", "onNewToken", "token", "bundle", "Landroid/os/Bundle;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OneSignalHmsEventBridge.kt */
public final class OneSignalHmsEventBridge {
    public static final String HMS_SENT_TIME_KEY = "hms.sent_time";
    public static final String HMS_TTL_KEY = "hms.ttl";
    public static final OneSignalHmsEventBridge INSTANCE = new OneSignalHmsEventBridge();
    private static final AtomicBoolean firstToken = new AtomicBoolean(true);

    private OneSignalHmsEventBridge() {
    }

    public final void onNewToken(Context context, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "token");
        if (firstToken.compareAndSet(true, false)) {
            Logging.info$default("OneSignalHmsEventBridge onNewToken - HMS token: " + str + " Bundle: " + bundle, (Throwable) null, 2, (Object) null);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = OneSignal.INSTANCE.getServices().getService(IPushRegistratorCallback.class);
            ThreadUtilsKt.suspendifyOnThread$default(0, new OneSignalHmsEventBridge$onNewToken$1(objectRef, str, (Continuation<? super OneSignalHmsEventBridge$onNewToken$1>) null), 1, (Object) null);
            return;
        }
        Logging.info$default("OneSignalHmsEventBridge ignoring onNewToken - HMS token: " + str + " Bundle: " + bundle, (Throwable) null, 2, (Object) null);
    }

    @Deprecated(message = "")
    public final void onNewToken(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "token");
        onNewToken(context, str, (Bundle) null);
    }

    public final void onMessageReceived(Context context, RemoteMessage remoteMessage) {
        Bundle jsonStringToBundle;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(remoteMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        if (OneSignal.initWithContext(context)) {
            ITime iTime = (ITime) OneSignal.INSTANCE.getServices().getService(ITime.class);
            INotificationBundleProcessor iNotificationBundleProcessor = (INotificationBundleProcessor) OneSignal.INSTANCE.getServices().getService(INotificationBundleProcessor.class);
            String data = remoteMessage.getData();
            try {
                JSONObject jSONObject = new JSONObject(remoteMessage.getData());
                if (remoteMessage.getTtl() == 0) {
                    jSONObject.put("hms.ttl", 259200);
                } else {
                    jSONObject.put("hms.ttl", remoteMessage.getTtl());
                }
                if (remoteMessage.getSentTime() == 0) {
                    jSONObject.put("hms.sent_time", iTime.getCurrentTimeMillis());
                } else {
                    jSONObject.put("hms.sent_time", remoteMessage.getSentTime());
                }
                data = jSONObject.toString();
            } catch (JSONException unused) {
                Logging.error$default("OneSignalHmsEventBridge error when trying to create RemoteMessage data JSON", (Throwable) null, 2, (Object) null);
            }
            if (data != null && (jsonStringToBundle = JSONUtils.INSTANCE.jsonStringToBundle(data)) != null) {
                iNotificationBundleProcessor.processBundleFromReceiver(context, jsonStringToBundle);
            }
        }
    }
}
