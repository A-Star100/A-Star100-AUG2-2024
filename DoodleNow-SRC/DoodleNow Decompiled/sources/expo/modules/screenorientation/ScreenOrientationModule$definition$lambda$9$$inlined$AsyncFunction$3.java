package expo.modules.screenorientation;

import expo.modules.core.errors.InvalidArgumentException;
import expo.modules.screenorientation.enums.OrientationLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u00012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "R", "P0", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$6"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$3 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ ScreenOrientationModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$3(ScreenOrientationModule screenOrientationModule) {
        super(1);
        this.this$0 = screenOrientationModule;
    }

    public final Unit invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        OrientationLock orientationLock = objArr[0];
        try {
            this.this$0.getCurrentActivity().setRequestedOrientation(orientationLock.toPlatformInt$expo_screen_orientation_release());
            return Unit.INSTANCE;
        } catch (InvalidArgumentException e) {
            throw new InvalidOrientationLockException(orientationLock.getValue(), e);
        }
    }
}
