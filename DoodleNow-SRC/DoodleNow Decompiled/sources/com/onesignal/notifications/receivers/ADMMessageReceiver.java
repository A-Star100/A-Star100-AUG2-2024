package com.onesignal.notifications.receivers;

import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.services.ADMMessageHandler;
import com.onesignal.notifications.services.ADMMessageHandlerJob;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/onesignal/notifications/receivers/ADMMessageReceiver;", "Lcom/amazon/device/messaging/ADMMessageReceiver;", "()V", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ADMMessageReceiver.kt */
public final class ADMMessageReceiver extends com.amazon.device.messaging.ADMMessageReceiver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int JOB_ID = 123891;

    public ADMMessageReceiver() {
        super(ADMMessageHandler.class);
        boolean z;
        try {
            Class.forName("com.amazon.device.messaging.ADMMessageHandlerJobBase");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        if (z) {
            registerJobServiceClass(ADMMessageHandlerJob.class, JOB_ID);
        }
        Logging.debug$default("ADM latest available: " + z, (Throwable) null, 2, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/notifications/receivers/ADMMessageReceiver$Companion;", "", "()V", "JOB_ID", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ADMMessageReceiver.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
