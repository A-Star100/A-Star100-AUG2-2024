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
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$getPageHeight$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PdfPageKt.kt */
final class PdfPageKt$getPageHeight$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ int $screenDpi;
    int label;
    final /* synthetic */ PdfPageKt this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PdfPageKt$getPageHeight$2(PdfPageKt pdfPageKt, int i, Continuation<? super PdfPageKt$getPageHeight$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfPageKt;
        this.$screenDpi = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfPageKt$getPageHeight$2(this.this$0, this.$screenDpi, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((PdfPageKt$getPageHeight$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxInt(this.this$0.getPage().getPageHeight(this.$screenDpi));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
