package com.onesignal.notifications.internal.receivereceipt.impl;

import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.notifications.internal.backend.INotificationBackendService;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J)\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/onesignal/notifications/internal/receivereceipt/impl/ReceiveReceiptProcessor;", "Lcom/onesignal/notifications/internal/receivereceipt/IReceiveReceiptProcessor;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_backend", "Lcom/onesignal/notifications/internal/backend/INotificationBackendService;", "(Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/notifications/internal/backend/INotificationBackendService;)V", "sendReceiveReceipt", "", "appId", "", "subscriptionId", "notificationId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReceiveReceiptProcessor.kt */
public final class ReceiveReceiptProcessor implements IReceiveReceiptProcessor {
    private final INotificationBackendService _backend;
    private final IDeviceService _deviceService;

    public ReceiveReceiptProcessor(IDeviceService iDeviceService, INotificationBackendService iNotificationBackendService) {
        Intrinsics.checkNotNullParameter(iDeviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(iNotificationBackendService, "_backend");
        this._deviceService = iDeviceService;
        this._backend = iNotificationBackendService;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object sendReceiveReceipt(java.lang.String r8, java.lang.String r9, java.lang.String r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor$sendReceiveReceipt$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor$sendReceiveReceipt$1 r0 = (com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor$sendReceiveReceipt$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor$sendReceiveReceipt$1 r0 = new com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor$sendReceiveReceipt$1
            r0.<init>(r7, r11)
        L_0x0019:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ BackendException -> 0x002b }
            goto L_0x006f
        L_0x002b:
            r8 = move-exception
            goto L_0x004c
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r11)
            com.onesignal.core.internal.device.IDeviceService r11 = r7._deviceService
            com.onesignal.core.internal.device.IDeviceService$DeviceType r5 = r11.getDeviceType()
            com.onesignal.notifications.internal.backend.INotificationBackendService r1 = r7._backend     // Catch:{ BackendException -> 0x002b }
            r6.label = r2     // Catch:{ BackendException -> 0x002b }
            r2 = r8
            r3 = r10
            r4 = r9
            java.lang.Object r8 = r1.updateNotificationAsReceived(r2, r3, r4, r5, r6)     // Catch:{ BackendException -> 0x002b }
            if (r8 != r0) goto L_0x006f
            return r0
        L_0x004c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r10 = "Receive receipt failed with statusCode: "
            r9.<init>(r10)
            int r10 = r8.getStatusCode()
            r9.append(r10)
            java.lang.String r10 = " response: "
            r9.append(r10)
            java.lang.String r8 = r8.getResponse()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r9 = 2
            r10 = 0
            com.onesignal.debug.internal.logging.Logging.error$default(r8, r10, r9, r10)
        L_0x006f:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptProcessor.sendReceiveReceipt(java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
