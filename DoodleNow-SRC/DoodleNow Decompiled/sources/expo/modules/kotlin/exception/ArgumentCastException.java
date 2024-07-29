package expo.modules.kotlin.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/exception/ArgumentCastException;", "Lexpo/modules/kotlin/exception/DecoratedException;", "argDesiredType", "Lkotlin/reflect/KType;", "argIndex", "", "providedType", "", "cause", "Lexpo/modules/kotlin/exception/CodedException;", "(Lkotlin/reflect/KType;ILjava/lang/String;Lexpo/modules/kotlin/exception/CodedException;)V", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CodedException.kt */
public final class ArgumentCastException extends DecoratedException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ArgumentCastException(kotlin.reflect.KType r3, int r4, java.lang.String r5, expo.modules.kotlin.exception.CodedException r6) {
        /*
            r2 = this;
            java.lang.String r0 = "argDesiredType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "providedType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "cause"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            expo.modules.kotlin.exception.ArgumentCastException$Companion r0 = Companion
            int r4 = r4 + 1
            java.lang.String r4 = r0.formatOrdinalNumber(r4)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "The "
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = " argument cannot be cast to type "
            r0.append(r4)
            r0.append(r3)
            java.lang.String r3 = " (received "
            r0.append(r3)
            r0.append(r5)
            java.lang.String r3 = ")"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.exception.ArgumentCastException.<init>(kotlin.reflect.KType, int, java.lang.String, expo.modules.kotlin.exception.CodedException):void");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/exception/ArgumentCastException$Companion;", "", "()V", "formatOrdinalNumber", "", "number", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CodedException.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String formatOrdinalNumber(int i) {
            int i2 = i % 100;
            String str = "th";
            if (11 > i2 || i2 >= 14) {
                int i3 = i % 10;
                if (i3 == 1) {
                    str = "st";
                } else if (i3 == 2) {
                    str = "nd";
                } else if (i3 == 3) {
                    str = "rd";
                }
            }
            return i + str;
        }
    }
}
