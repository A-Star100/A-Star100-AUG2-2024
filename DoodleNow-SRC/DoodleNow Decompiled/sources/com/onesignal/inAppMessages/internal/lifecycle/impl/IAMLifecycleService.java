package com.onesignal.inAppMessages.internal.lifecycle.impl;

import com.onesignal.common.events.EventProducer;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageClickResult;
import com.onesignal.inAppMessages.internal.InAppMessagePage;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleEventHandler;
import com.onesignal.inAppMessages.internal.lifecycle.IInAppLifecycleService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\u0013"}, d2 = {"Lcom/onesignal/inAppMessages/internal/lifecycle/impl/IAMLifecycleService;", "Lcom/onesignal/common/events/EventProducer;", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleEventHandler;", "Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleService;", "()V", "messageActionOccurredOnMessage", "", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "action", "Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;", "messageActionOccurredOnPreview", "messagePageChanged", "page", "Lcom/onesignal/inAppMessages/internal/InAppMessagePage;", "messageWasDismissed", "messageWasDisplayed", "messageWillDismiss", "messageWillDisplay", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IAMLifecycleService.kt */
public final class IAMLifecycleService extends EventProducer<IInAppLifecycleEventHandler> implements IInAppLifecycleService {
    public void messageWillDisplay(InAppMessage inAppMessage) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        fire(new IAMLifecycleService$messageWillDisplay$1(inAppMessage));
    }

    public void messageWasDisplayed(InAppMessage inAppMessage) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        fire(new IAMLifecycleService$messageWasDisplayed$1(inAppMessage));
    }

    public void messageActionOccurredOnPreview(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        Intrinsics.checkNotNullParameter(inAppMessageClickResult, "action");
        fire(new IAMLifecycleService$messageActionOccurredOnPreview$1(inAppMessage, inAppMessageClickResult));
    }

    public void messageActionOccurredOnMessage(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        Intrinsics.checkNotNullParameter(inAppMessageClickResult, "action");
        fire(new IAMLifecycleService$messageActionOccurredOnMessage$1(inAppMessage, inAppMessageClickResult));
    }

    public void messagePageChanged(InAppMessage inAppMessage, InAppMessagePage inAppMessagePage) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        Intrinsics.checkNotNullParameter(inAppMessagePage, "page");
        fire(new IAMLifecycleService$messagePageChanged$1(inAppMessage, inAppMessagePage));
    }

    public void messageWillDismiss(InAppMessage inAppMessage) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        fire(new IAMLifecycleService$messageWillDismiss$1(inAppMessage));
    }

    public void messageWasDismissed(InAppMessage inAppMessage) {
        Intrinsics.checkNotNullParameter(inAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        fire(new IAMLifecycleService$messageWasDismissed$1(inAppMessage));
    }
}
