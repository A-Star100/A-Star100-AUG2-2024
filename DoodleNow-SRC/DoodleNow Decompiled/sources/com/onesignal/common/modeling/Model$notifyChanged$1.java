package com.onesignal.common.modeling;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/common/modeling/IModelChangedHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Model.kt */
final class Model$notifyChanged$1 extends Lambda implements Function1<IModelChangedHandler, Unit> {
    final /* synthetic */ ModelChangedArgs $changeArgs;
    final /* synthetic */ String $tag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Model$notifyChanged$1(ModelChangedArgs modelChangedArgs, String str) {
        super(1);
        this.$changeArgs = modelChangedArgs;
        this.$tag = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IModelChangedHandler) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IModelChangedHandler iModelChangedHandler) {
        Intrinsics.checkNotNullParameter(iModelChangedHandler, "it");
        iModelChangedHandler.onChanged(this.$changeArgs, this.$tag);
    }
}
