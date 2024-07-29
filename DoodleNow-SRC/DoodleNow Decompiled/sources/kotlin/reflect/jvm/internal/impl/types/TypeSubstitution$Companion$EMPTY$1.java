package kotlin.reflect.jvm.internal.impl.types;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeSubstitution.kt */
public final class TypeSubstitution$Companion$EMPTY$1 extends TypeSubstitution {
    public Void get(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, SubscriberAttributeKt.JSON_NAME_KEY);
        return null;
    }

    public boolean isEmpty() {
        return true;
    }

    public String toString() {
        return "Empty TypeSubstitution";
    }

    TypeSubstitution$Companion$EMPTY$1() {
    }
}
