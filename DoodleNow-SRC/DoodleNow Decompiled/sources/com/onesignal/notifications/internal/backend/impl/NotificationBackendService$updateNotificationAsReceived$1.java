package com.onesignal.notifications.internal.backend.impl;

import com.onesignal.core.internal.device.IDeviceService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.backend.impl.NotificationBackendService", f = "NotificationBackendService.kt", i = {}, l = {24}, m = "updateNotificationAsReceived", n = {}, s = {})
/* compiled from: NotificationBackendService.kt */
final class NotificationBackendService$updateNotificationAsReceived$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationBackendService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationBackendService$updateNotificationAsReceived$1(NotificationBackendService notificationBackendService, Continuation<? super NotificationBackendService$updateNotificationAsReceived$1> continuation) {
        super(continuation);
        this.this$0 = notificationBackendService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateNotificationAsReceived((String) null, (String) null, (String) null, (IDeviceService.DeviceType) null, this);
    }
}
