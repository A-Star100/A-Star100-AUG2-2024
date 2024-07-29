package expo.modules.kotlin.functions;

import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a^\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u00012\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062-\b\b\u0010\b\u001a'\u0012\u001d\u0012\u001b\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\u0006¢\u0006\f\b\u000b\u0012\b\b\u0003\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00020\tH\bø\u0001\u0000¢\u0006\u0002\u0010\r\u0002\u0007\n\u0005\b20\u0001¨\u0006\u000e"}, d2 = {"createAsyncFunctionComponent", "Lexpo/modules/kotlin/functions/AsyncFunction;", "T", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "body", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "args", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;Lkotlin/jvm/functions/Function1;)Lexpo/modules/kotlin/functions/AsyncFunction;", "expo-modules-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: AsyncFunctionComponent.kt */
public final class AsyncFunctionComponentKt {
    public static final /* synthetic */ <T> AsyncFunction createAsyncFunctionComponent(String str, AnyType[] anyTypeArr, Function1<? super Object[], ? extends T> function1) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(anyTypeArr, "desiredArgsTypes");
        Intrinsics.checkNotNullParameter(function1, TtmlNode.TAG_BODY);
        Intrinsics.reifiedOperationMarker(3, "T");
        Intrinsics.reifiedOperationMarker(4, "T");
        Class<Object> cls = Object.class;
        Class cls2 = cls;
        if (Intrinsics.areEqual((Object) cls, (Object) Integer.TYPE)) {
            return new IntAsyncFunctionComponent(str, anyTypeArr, function1);
        }
        if (Intrinsics.areEqual((Object) cls, (Object) Boolean.TYPE)) {
            return new BoolAsyncFunctionComponent(str, anyTypeArr, function1);
        }
        if (Intrinsics.areEqual((Object) cls, (Object) Double.TYPE)) {
            return new DoubleAsyncFunctionComponent(str, anyTypeArr, function1);
        }
        if (Intrinsics.areEqual((Object) cls, (Object) Float.TYPE)) {
            return new FloatAsyncFunctionComponent(str, anyTypeArr, function1);
        }
        if (Intrinsics.areEqual((Object) cls, (Object) String.class)) {
            return new StringAsyncFunctionComponent(str, anyTypeArr, function1);
        }
        return new AsyncFunctionComponent(str, anyTypeArr, function1);
    }
}
