package com.revenuecat.purchases.common;

import java.io.BufferedReader;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "bufferedReader", "Ljava/io/BufferedReader;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: FileHelper.kt */
final class FileHelper$readFilePerLines$1 extends Lambda implements Function1<BufferedReader, Unit> {
    final /* synthetic */ Function1<Stream<String>, Unit> $streamBlock;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileHelper$readFilePerLines$1(Function1<? super Stream<String>, Unit> function1) {
        super(1);
        this.$streamBlock = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BufferedReader) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, "bufferedReader");
        Function1<Stream<String>, Unit> function1 = this.$streamBlock;
        Stream m = bufferedReader.lines();
        Intrinsics.checkNotNullExpressionValue(m, "bufferedReader.lines()");
        function1.invoke(m);
    }
}
