package com.revenuecat.purchases.models;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<no name provided>", "", "part", "", "invoke", "(Ljava/lang/String;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: Period.kt */
final class PeriodKt$toPeriod$1$toInt$1 extends Lambda implements Function1<String, Integer> {
    public static final PeriodKt$toPeriod$1$toInt$1 INSTANCE = new PeriodKt$toPeriod$1$toInt$1();

    PeriodKt$toPeriod$1$toInt$1() {
        super(1);
    }

    public final Integer invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "part");
        Integer intOrNull = StringsKt.toIntOrNull(StringsKt.dropLast(str, 1));
        return Integer.valueOf(intOrNull != null ? intOrNull.intValue() : 0);
    }
}
