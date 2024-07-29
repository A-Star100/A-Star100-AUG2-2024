package com.revenuecat.purchases.common;

import com.revenuecat.purchases.LogHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: logUtils.kt */
/* synthetic */ class LogUtilsKt$warnLog$1 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    LogUtilsKt$warnLog$1(Object obj) {
        super(2, obj, LogHandler.class, "w", "w(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (String) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "p0");
        Intrinsics.checkNotNullParameter(str2, "p1");
        ((LogHandler) this.receiver).w(str, str2);
    }
}
