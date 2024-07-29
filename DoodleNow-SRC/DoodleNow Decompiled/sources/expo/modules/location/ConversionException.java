package expo.modules.location;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B)\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/location/ConversionException;", "Lexpo/modules/kotlin/exception/CodedException;", "fromClass", "Ljava/lang/Class;", "toClass", "message", "", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/String;)V", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationExceptions.kt */
public final class ConversionException extends CodedException {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConversionException(Class cls, Class cls2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(cls, cls2, (i & 4) != 0 ? "" : str);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ConversionException(java.lang.Class<?> r3, java.lang.Class<?> r4, java.lang.String r5) {
        /*
            r2 = this;
            java.lang.String r0 = "fromClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "toClass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.Class r3 = r3.getClass()
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            java.lang.String r3 = r3.getSimpleName()
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getSimpleName()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Couldn't cast from "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r3 = " to "
            r0.append(r3)
            r0.append(r4)
            java.lang.String r3 = ": "
            r0.append(r3)
            r0.append(r5)
            java.lang.String r3 = r0.toString()
            r4 = 0
            r5 = 2
            r2.<init>(r3, r4, r5, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.ConversionException.<init>(java.lang.Class, java.lang.Class, java.lang.String):void");
    }
}
