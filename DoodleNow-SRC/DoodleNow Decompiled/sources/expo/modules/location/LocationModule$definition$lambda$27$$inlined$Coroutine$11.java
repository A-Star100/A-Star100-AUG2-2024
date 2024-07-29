package expo.modules.location;

import expo.modules.location.records.ReverseGeocodeLocation;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\n¢\u0006\u0002\b\u0003¨\u0006\u0007"}, d2 = {"<anonymous>", "Lkotlin/reflect/KType;", "T", "invoke", "expo/modules/kotlin/types/AnyTypeKt$toAnyType$1", "expo/modules/kotlin/types/AnyTypeKt$toArgsArray$$inlined$toAnyType$1", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$$inlined$toArgsArray$default$1", "expo/modules/kotlin/functions/AsyncFunctionBuilderKt$Coroutine$$inlined$SuspendBody$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: AnyType.kt */
public final class LocationModule$definition$lambda$27$$inlined$Coroutine$11 extends Lambda implements Function0<KType> {
    public static final LocationModule$definition$lambda$27$$inlined$Coroutine$11 INSTANCE = new LocationModule$definition$lambda$27$$inlined$Coroutine$11();

    public LocationModule$definition$lambda$27$$inlined$Coroutine$11() {
        super(0);
    }

    public final KType invoke() {
        return Reflection.typeOf(ReverseGeocodeLocation.class);
    }
}
