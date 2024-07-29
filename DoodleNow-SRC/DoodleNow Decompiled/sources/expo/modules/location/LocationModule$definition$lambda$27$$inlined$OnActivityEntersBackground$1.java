package expo.modules.location;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "expo/modules/kotlin/modules/ModuleDefinitionBuilder$OnActivityEntersBackground$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ModuleDefinitionBuilder.kt */
public final class LocationModule$definition$lambda$27$$inlined$OnActivityEntersBackground$1 extends Lambda implements Function0<Unit> {
    public LocationModule$definition$lambda$27$$inlined$OnActivityEntersBackground$1() {
        super(0);
    }

    public final void invoke() {
        AppForegroundedSingleton.INSTANCE.setForegrounded(false);
    }
}
