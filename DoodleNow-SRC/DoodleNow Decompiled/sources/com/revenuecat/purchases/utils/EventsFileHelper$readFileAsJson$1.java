package com.revenuecat.purchases.utils;

import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "T", "Lcom/revenuecat/purchases/utils/Event;", "stream", "Ljava/util/stream/Stream;", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: EventsFileHelper.kt */
final class EventsFileHelper$readFileAsJson$1 extends Lambda implements Function1<Stream<String>, Unit> {
    final /* synthetic */ Function1<Stream<JSONObject>, Unit> $streamBlock;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventsFileHelper$readFileAsJson$1(Function1<? super Stream<JSONObject>, Unit> function1) {
        super(1);
        this.$streamBlock = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Stream<String>) PathTreeWalk$$ExternalSyntheticApiModelOutline0.m(obj));
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final JSONObject invoke$lambda$0(Function1 function1, Object obj) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        return (JSONObject) function1.invoke(obj);
    }

    public final void invoke(Stream<String> stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        Function1<Stream<JSONObject>, Unit> function1 = this.$streamBlock;
        Stream m = stream.map(new EventsFileHelper$readFileAsJson$1$$ExternalSyntheticLambda0(AnonymousClass1.INSTANCE));
        Intrinsics.checkNotNullExpressionValue(m, "stream.map { JSONObject(it) }");
        function1.invoke(m);
    }
}
