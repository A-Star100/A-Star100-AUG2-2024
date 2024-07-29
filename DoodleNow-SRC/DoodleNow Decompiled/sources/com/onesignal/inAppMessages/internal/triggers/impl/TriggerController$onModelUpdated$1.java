package com.onesignal.inAppMessages.internal.triggers.impl;

import com.onesignal.inAppMessages.internal.triggers.ITriggerHandler;
import com.onesignal.inAppMessages.internal.triggers.TriggerModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/inAppMessages/internal/triggers/ITriggerHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: TriggerController.kt */
final class TriggerController$onModelUpdated$1 extends Lambda implements Function1<ITriggerHandler, Unit> {
    final /* synthetic */ TriggerModel $model;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TriggerController$onModelUpdated$1(TriggerModel triggerModel) {
        super(1);
        this.$model = triggerModel;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ITriggerHandler) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ITriggerHandler iTriggerHandler) {
        Intrinsics.checkNotNullParameter(iTriggerHandler, "it");
        iTriggerHandler.onTriggerChanged(this.$model.getKey());
    }
}
