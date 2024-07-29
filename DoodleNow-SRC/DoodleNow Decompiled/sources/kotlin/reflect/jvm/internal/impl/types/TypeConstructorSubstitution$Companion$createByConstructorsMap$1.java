package kotlin.reflect.jvm.internal.impl.types;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeSubstitution.kt */
public final class TypeConstructorSubstitution$Companion$createByConstructorsMap$1 extends TypeConstructorSubstitution {
    final /* synthetic */ boolean $approximateCapturedTypes;
    final /* synthetic */ Map<TypeConstructor, TypeProjection> $map;

    public boolean approximateCapturedTypes() {
        return this.$approximateCapturedTypes;
    }

    TypeConstructorSubstitution$Companion$createByConstructorsMap$1(Map<TypeConstructor, ? extends TypeProjection> map, boolean z) {
        this.$map = map;
        this.$approximateCapturedTypes = z;
    }

    public TypeProjection get(TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, SubscriberAttributeKt.JSON_NAME_KEY);
        return this.$map.get(typeConstructor);
    }

    public boolean isEmpty() {
        return this.$map.isEmpty();
    }
}
