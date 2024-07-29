package expo.modules.screenorientation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "R", "it", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$3"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$9 extends Lambda implements Function1<Object[], Integer> {
    final /* synthetic */ ScreenOrientationModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$9(ScreenOrientationModule screenOrientationModule) {
        super(1);
        this.this$0 = screenOrientationModule;
    }

    public final Integer invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "it");
        try {
            return Integer.valueOf(this.this$0.getCurrentActivity().getRequestedOrientation());
        } catch (Exception e) {
            throw new GetPlatformOrientationLockException(e);
        }
    }
}
