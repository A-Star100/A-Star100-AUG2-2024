package com.onesignal.inAppMessages.internal.lifecycle;

import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageClickResult;
import com.onesignal.inAppMessages.internal.InAppMessagePage;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0010"}, d2 = {"Lcom/onesignal/inAppMessages/internal/lifecycle/IInAppLifecycleEventHandler;", "", "onMessageActionOccurredOnMessage", "", "message", "Lcom/onesignal/inAppMessages/internal/InAppMessage;", "action", "Lcom/onesignal/inAppMessages/internal/InAppMessageClickResult;", "onMessageActionOccurredOnPreview", "onMessagePageChanged", "page", "Lcom/onesignal/inAppMessages/internal/InAppMessagePage;", "onMessageWasDismissed", "onMessageWasDisplayed", "onMessageWillDismiss", "onMessageWillDisplay", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IInAppLifecycleEventHandler.kt */
public interface IInAppLifecycleEventHandler {
    void onMessageActionOccurredOnMessage(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult);

    void onMessageActionOccurredOnPreview(InAppMessage inAppMessage, InAppMessageClickResult inAppMessageClickResult);

    void onMessagePageChanged(InAppMessage inAppMessage, InAppMessagePage inAppMessagePage);

    void onMessageWasDismissed(InAppMessage inAppMessage);

    void onMessageWasDisplayed(InAppMessage inAppMessage);

    void onMessageWillDismiss(InAppMessage inAppMessage);

    void onMessageWillDisplay(InAppMessage inAppMessage);
}
