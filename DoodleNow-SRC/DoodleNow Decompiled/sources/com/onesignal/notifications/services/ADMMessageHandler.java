package com.onesignal.notifications.services;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.amazon.device.messaging.ADMMessageHandlerBase;
import com.onesignal.OneSignal;
import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0014J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH\u0014J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\tH\u0014¨\u0006\u000e"}, d2 = {"Lcom/onesignal/notifications/services/ADMMessageHandler;", "Lcom/amazon/device/messaging/ADMMessageHandlerBase;", "()V", "onMessage", "", "intent", "Landroid/content/Intent;", "onRegistered", "newRegistrationId", "", "onRegistrationError", "error", "onUnregistered", "info", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ADMMessageHandler.kt */
public final class ADMMessageHandler extends ADMMessageHandlerBase {
    public ADMMessageHandler() {
        super("ADMMessageHandler");
    }

    /* access modifiers changed from: protected */
    public void onMessage(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context");
        if (OneSignal.initWithContext(applicationContext)) {
            Bundle extras = intent.getExtras();
            Intrinsics.checkNotNull(extras);
            ((INotificationBundleProcessor) OneSignal.INSTANCE.getServices().getService(INotificationBundleProcessor.class)).processBundleFromReceiver(applicationContext, extras);
        }
    }

    /* access modifiers changed from: protected */
    public void onRegistered(String str) {
        Intrinsics.checkNotNullParameter(str, "newRegistrationId");
        Logging.info$default("ADM registration ID: " + str, (Throwable) null, 2, (Object) null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = OneSignal.INSTANCE.getServices().getService(IPushRegistratorCallback.class);
        ThreadUtilsKt.suspendifyOnThread$default(0, new ADMMessageHandler$onRegistered$1(objectRef, str, (Continuation<? super ADMMessageHandler$onRegistered$1>) null), 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onRegistrationError(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Logging.error$default("ADM:onRegistrationError: " + str, (Throwable) null, 2, (Object) null);
        if (Intrinsics.areEqual((Object) "INVALID_SENDER", (Object) str)) {
            Logging.error$default("Please double check that you have a matching package name (NOTE: Case Sensitive), api_key.txt, and the apk was signed with the same Keystore and Alias.", (Throwable) null, 2, (Object) null);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = OneSignal.INSTANCE.getServices().getService(IPushRegistratorCallback.class);
        ThreadUtilsKt.suspendifyOnThread$default(0, new ADMMessageHandler$onRegistrationError$1(objectRef, (Continuation<? super ADMMessageHandler$onRegistrationError$1>) null), 1, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onUnregistered(String str) {
        Intrinsics.checkNotNullParameter(str, "info");
        Logging.info$default("ADM:onUnregistered: " + str, (Throwable) null, 2, (Object) null);
    }
}
