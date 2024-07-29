package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.IInAppMessageLifecycleListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/inAppMessages/IInAppMessageLifecycleListener;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessagesManager.kt */
final class InAppMessagesManager$onMessageWasDisplayed$1 extends Lambda implements Function1<IInAppMessageLifecycleListener, Unit> {
    final /* synthetic */ InAppMessage $message;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessagesManager$onMessageWasDisplayed$1(InAppMessage inAppMessage) {
        super(1);
        this.$message = inAppMessage;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IInAppMessageLifecycleListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IInAppMessageLifecycleListener iInAppMessageLifecycleListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageLifecycleListener, "it");
        iInAppMessageLifecycleListener.onDidDisplay(new InAppMessageLifecycleEvent(this.$message));
    }
}
