package io.legere.pdfiumandroid.suspend;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetCharIndexAtPos$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PdfTextPageKt.kt */
final class PdfTextPageKt$textPageGetCharIndexAtPos$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ double $x;
    final /* synthetic */ double $xTolerance;
    final /* synthetic */ double $y;
    final /* synthetic */ double $yTolerance;
    int label;
    final /* synthetic */ PdfTextPageKt this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PdfTextPageKt$textPageGetCharIndexAtPos$2(PdfTextPageKt pdfTextPageKt, double d, double d2, double d3, double d4, Continuation<? super PdfTextPageKt$textPageGetCharIndexAtPos$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfTextPageKt;
        this.$x = d;
        this.$y = d2;
        this.$xTolerance = d3;
        this.$yTolerance = d4;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfTextPageKt$textPageGetCharIndexAtPos$2(this.this$0, this.$x, this.$y, this.$xTolerance, this.$yTolerance, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((PdfTextPageKt$textPageGetCharIndexAtPos$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(this.this$0.getPage().textPageGetCharIndexAtPos(this.$x, this.$y, this.$xTolerance, this.$yTolerance));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
