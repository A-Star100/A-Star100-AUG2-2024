package kotlin;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\u00012\n\u0010\t\u001a\u00020\u0001\"\u00020\u0006H\b¢\u0006\u0004\b\n\u0010\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"UShortArray", "Lkotlin/UShortArray;", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/UShort;", "(ILkotlin/jvm/functions/Function1;)[S", "ushortArrayOf", "elements", "ushortArrayOf-rL5Bavg", "([S)[S", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: UShortArray.kt */
public final class UShortArrayKt {
    /* renamed from: ushortArrayOf-rL5Bavg  reason: not valid java name */
    private static final short[] m1580ushortArrayOfrL5Bavg(short... sArr) {
        Intrinsics.checkNotNullParameter(sArr, "elements");
        return sArr;
    }

    private static final short[] UShortArray(int i, Function1<? super Integer, UShort> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        short[] sArr = new short[i];
        for (int i2 = 0; i2 < i; i2++) {
            sArr[i2] = function1.invoke(Integer.valueOf(i2)).m1561unboximpl();
        }
        return UShortArray.m1564constructorimpl(sArr);
    }
}
