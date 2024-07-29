package com.revenuecat.purchases.common;

import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "stream", "Ljava/util/stream/Stream;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: FileHelper.kt */
final class FileHelper$removeFirstLinesFromFile$1 extends Lambda implements Function1<Stream<String>, Unit> {
    final /* synthetic */ int $numberOfLinesToRemove;
    final /* synthetic */ StringBuilder $textToAppend;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FileHelper$removeFirstLinesFromFile$1(int i, StringBuilder sb) {
        super(1);
        this.$numberOfLinesToRemove = i;
        this.$textToAppend = sb;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Stream<String>) PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(obj));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(obj);
    }

    public final void invoke(Stream<String> stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        Stream m = stream.skip((long) this.$numberOfLinesToRemove);
        final StringBuilder sb = this.$textToAppend;
        m.forEach(new FileHelper$removeFirstLinesFromFile$1$$ExternalSyntheticLambda3(new Function1<String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                StringBuilder sb = sb;
                sb.append(str);
                sb.append("\n");
            }
        }));
    }
}
