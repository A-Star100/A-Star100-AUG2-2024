package expo.modules.kotlin.views;

import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\u0006\b\u0001\u0010\u0004\u0018\u0001\"\u0006\b\u0002\u0010\u0005\u0018\u0001\"\b\b\u0003\u0010\u0006*\u00020\u00032\u0006\u0010\u0007\u001a\u0002H\u00022\u0006\u0010\b\u001a\u0002H\u0004H\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "ViewType", "Landroid/view/View;", "PropType", "CustomValueType", "T", "view", "prop", "invoke", "(Landroid/view/View;Ljava/lang/Object;)V"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: ViewDefinitionBuilder.kt */
public final class ViewDefinitionBuilder$PropGroup$1 extends Lambda implements Function2<ViewType, PropType, Unit> {
    final /* synthetic */ Function3<ViewType, CustomValueType, PropType, Unit> $body;
    final /* synthetic */ CustomValueType $value;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ViewDefinitionBuilder$PropGroup$1(Function3<? super ViewType, ? super CustomValueType, ? super PropType, Unit> function3, CustomValueType customvaluetype) {
        super(2);
        this.$body = function3;
        this.$value = customvaluetype;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((View) obj, obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ViewType viewtype, PropType proptype) {
        Intrinsics.checkNotNullParameter(viewtype, "view");
        this.$body.invoke(viewtype, this.$value, proptype);
    }
}
