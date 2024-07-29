package com.onesignal.inAppMessages.internal.display.impl;

import com.onesignal.common.threading.ThreadUtilsKt;
import com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout;
import com.onesignal.inAppMessages.internal.display.impl.InAppMessageView;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/onesignal/inAppMessages/internal/display/impl/InAppMessageView$setUpDraggableLayout$1", "Lcom/onesignal/inAppMessages/internal/display/impl/DraggableRelativeLayout$DraggableListener;", "onDismiss", "", "onDragEnd", "onDragStart", "com.onesignal.inAppMessages"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: InAppMessageView.kt */
public final class InAppMessageView$setUpDraggableLayout$1 implements DraggableRelativeLayout.DraggableListener {
    final /* synthetic */ InAppMessageView this$0;

    InAppMessageView$setUpDraggableLayout$1(InAppMessageView inAppMessageView) {
        this.this$0 = inAppMessageView;
    }

    public void onDismiss() {
        if (this.this$0.messageController != null) {
            InAppMessageView.InAppMessageViewListener access$getMessageController$p = this.this$0.messageController;
            Intrinsics.checkNotNull(access$getMessageController$p);
            access$getMessageController$p.onMessageWillDismiss();
        }
        ThreadUtilsKt.suspendifyOnThread$default(0, new InAppMessageView$setUpDraggableLayout$1$onDismiss$1(this.this$0, (Continuation<? super InAppMessageView$setUpDraggableLayout$1$onDismiss$1>) null), 1, (Object) null);
    }

    public void onDragStart() {
        this.this$0.isDragging = true;
    }

    public void onDragEnd() {
        this.this$0.isDragging = false;
    }
}
