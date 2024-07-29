package com.onesignal.inAppMessages.internal.display.impl;

import com.onesignal.inAppMessages.internal.display.impl.InAppMessageView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/onesignal/inAppMessages/internal/display/impl/WebViewManager$createNewInAppMessageView$1", "Lcom/onesignal/inAppMessages/internal/display/impl/InAppMessageView$InAppMessageViewListener;", "onMessageWasDismissed", "", "onMessageWasDisplayed", "onMessageWillDismiss", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WebViewManager.kt */
public final class WebViewManager$createNewInAppMessageView$1 implements InAppMessageView.InAppMessageViewListener {
    final /* synthetic */ WebViewManager $self;
    final /* synthetic */ WebViewManager this$0;

    WebViewManager$createNewInAppMessageView$1(WebViewManager webViewManager, WebViewManager webViewManager2) {
        this.this$0 = webViewManager;
        this.$self = webViewManager2;
    }

    public void onMessageWasDisplayed() {
        this.this$0._lifecycle.messageWasDisplayed(this.this$0.message);
    }

    public void onMessageWillDismiss() {
        this.this$0._lifecycle.messageWillDismiss(this.this$0.message);
    }

    public void onMessageWasDismissed() {
        this.this$0._lifecycle.messageWasDismissed(this.this$0.message);
        this.this$0._applicationService.removeActivityLifecycleHandler(this.$self);
    }
}
