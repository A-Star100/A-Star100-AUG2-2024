package com.onesignal.common.modeling;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "TModel", "Lcom/onesignal/common/modeling/Model;", "it", "Lcom/onesignal/common/modeling/IModelStoreChangeHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ModelStore.kt */
final class ModelStore$clear$2 extends Lambda implements Function1<IModelStoreChangeHandler<TModel>, Unit> {
    final /* synthetic */ TModel $item;
    final /* synthetic */ String $tag;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModelStore$clear$2(TModel tmodel, String str) {
        super(1);
        this.$item = tmodel;
        this.$tag = str;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IModelStoreChangeHandler) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IModelStoreChangeHandler<TModel> iModelStoreChangeHandler) {
        Intrinsics.checkNotNullParameter(iModelStoreChangeHandler, "it");
        iModelStoreChangeHandler.onModelRemoved(this.$item, this.$tag);
    }
}
