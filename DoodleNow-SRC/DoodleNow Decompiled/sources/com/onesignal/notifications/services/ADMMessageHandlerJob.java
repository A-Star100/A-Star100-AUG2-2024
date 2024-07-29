package com.onesignal.notifications.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerJobBase;
import com.onesignal.OneSignal;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u001c\u0010\f\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0014J\u001c\u0010\u000e\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH\u0014¨\u0006\u0010"}, d2 = {"Lcom/onesignal/notifications/services/ADMMessageHandlerJob;", "Lcom/amazon/device/messaging/ADMMessageHandlerJobBase;", "()V", "onMessage", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "onRegistered", "newRegistrationId", "", "onRegistrationError", "error", "onUnregistered", "registrationId", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ADMMessageHandlerJob.kt */
public final class ADMMessageHandlerJob extends ADMMessageHandlerJobBase {
    /* access modifiers changed from: protected */
    public void onMessage(Context context, Intent intent) {
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            if (OneSignal.initWithContext(applicationContext)) {
                INotificationBundleProcessor iNotificationBundleProcessor = (INotificationBundleProcessor) OneSignal.INSTANCE.getServices().getService(INotificationBundleProcessor.class);
                Bundle extras = intent != null ? intent.getExtras() : null;
                Intrinsics.checkNotNull(extras);
                iNotificationBundleProcessor.processBundleFromReceiver(context, extras);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRegistered(Context context, String str) {
        Logging.info$default("ADM registration ID: " + str, (Throwable) null, 2, (Object) null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = OneSignal.INSTANCE.getServices().getService(IPushRegistratorCallback.class);
        ThreadUtilsKt.suspendifyOnThread$default(0, new ADMMessageHandlerJob$onRegistered$1(objectRef, str, (Continuation<? super ADMMessageHandlerJob$onRegistered$1>) null), 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onUnregistered(Context context, String str) {
        Logging.info$default("ADM:onUnregistered: " + str, (Throwable) null, 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onRegistrationError(Context context, String str) {
        Logging.error$default("ADM:onRegistrationError: " + str, (Throwable) null, 2, (Object) null);
        if (Intrinsics.areEqual((Object) "INVALID_SENDER", (Object) str)) {
            Logging.error$default("Please double check that you have a matching package name (NOTE: Case Sensitive), api_key.txt, and the apk was signed with the same Keystore and Alias.", (Throwable) null, 2, (Object) null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = OneSignal.INSTANCE.getServices().getService(IPushRegistratorCallback.class);
        ThreadUtilsKt.suspendifyOnThread$default(0, new ADMMessageHandlerJob$onRegistrationError$1(objectRef, (Continuation<? super ADMMessageHandlerJob$onRegistrationError$1>) null), 1, (Object) null);
    }
}
