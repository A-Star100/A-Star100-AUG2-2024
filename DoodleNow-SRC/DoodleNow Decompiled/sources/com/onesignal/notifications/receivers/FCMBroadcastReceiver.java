package com.onesignal.notifications.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.firebase.messaging.Constants;
import com.onesignal.OneSignal;
import com.onesignal.notifications.internal.bundle.INotificationBundleProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002¨\u0006\f"}, d2 = {"Lcom/onesignal/notifications/receivers/FCMBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "setAbort", "setSuccessfulResultCode", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FCMBroadcastReceiver.kt */
public final class FCMBroadcastReceiver extends BroadcastReceiver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FCM_RECEIVE_ACTION = "com.google.android.c2dm.intent.RECEIVE";
    private static final String FCM_TYPE = "gcm";
    private static final String MESSAGE_TYPE_EXTRA_KEY = "message_type";

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Bundle extras = intent.getExtras();
        if (extras != null && !Intrinsics.areEqual((Object) "google.com/iid", (Object) extras.getString(Constants.MessagePayloadKeys.FROM))) {
            Context applicationContext = context.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
            if (OneSignal.initWithContext(applicationContext)) {
                INotificationBundleProcessor iNotificationBundleProcessor = (INotificationBundleProcessor) OneSignal.INSTANCE.getServices().getService(INotificationBundleProcessor.class);
                if (!Companion.isFCMMessage(intent)) {
                    setSuccessfulResultCode();
                    return;
                }
                INotificationBundleProcessor.ProcessedBundleResult processBundleFromReceiver = iNotificationBundleProcessor.processBundleFromReceiver(context, extras);
                Intrinsics.checkNotNull(processBundleFromReceiver);
                if (processBundleFromReceiver.isWorkManagerProcessing()) {
                    setAbort();
                } else {
                    setSuccessfulResultCode();
                }
            }
        }
    }

    private final void setSuccessfulResultCode() {
        if (isOrderedBroadcast()) {
            setResultCode(-1);
        }
    }

    private final void setAbort() {
        if (isOrderedBroadcast()) {
            abortBroadcast();
            setResultCode(-1);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/onesignal/notifications/receivers/FCMBroadcastReceiver$Companion;", "", "()V", "FCM_RECEIVE_ACTION", "", "FCM_TYPE", "MESSAGE_TYPE_EXTRA_KEY", "isFCMMessage", "", "intent", "Landroid/content/Intent;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FCMBroadcastReceiver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final boolean isFCMMessage(Intent intent) {
            if (!Intrinsics.areEqual((Object) FCMBroadcastReceiver.FCM_RECEIVE_ACTION, (Object) intent.getAction())) {
                return false;
            }
            String stringExtra = intent.getStringExtra("message_type");
            if (stringExtra == null || Intrinsics.areEqual((Object) "gcm", (Object) stringExtra)) {
                return true;
            }
            return false;
        }
    }
}
