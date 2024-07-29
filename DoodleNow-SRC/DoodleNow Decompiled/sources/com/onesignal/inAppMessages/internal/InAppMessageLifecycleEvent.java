package com.onesignal.inAppMessages.internal;

import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import com.onesignal.inAppMessages.IInAppMessage;
import com.onesignal.inAppMessages.IInAppMessageDidDismissEvent;
import com.onesignal.inAppMessages.IInAppMessageDidDisplayEvent;
import com.onesignal.inAppMessages.IInAppMessageWillDismissEvent;
import com.onesignal.inAppMessages.IInAppMessageWillDisplayEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/onesignal/inAppMessages/internal/InAppMessageLifecycleEvent;", "Lcom/onesignal/inAppMessages/IInAppMessageWillDisplayEvent;", "Lcom/onesignal/inAppMessages/IInAppMessageWillDismissEvent;", "Lcom/onesignal/inAppMessages/IInAppMessageDidDisplayEvent;", "Lcom/onesignal/inAppMessages/IInAppMessageDidDismissEvent;", "message", "Lcom/onesignal/inAppMessages/IInAppMessage;", "(Lcom/onesignal/inAppMessages/IInAppMessage;)V", "getMessage", "()Lcom/onesignal/inAppMessages/IInAppMessage;", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessageLifecycleEvent.kt */
public class InAppMessageLifecycleEvent implements IInAppMessageWillDisplayEvent, IInAppMessageWillDismissEvent, IInAppMessageDidDisplayEvent, IInAppMessageDidDismissEvent {
    private final IInAppMessage message;

    public IInAppMessage getMessage() {
        return this.message;
    }

    public InAppMessageLifecycleEvent(IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE);
        this.message = iInAppMessage;
    }
}
