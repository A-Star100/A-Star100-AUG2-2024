package io.legere.pdfiumandroid.suspend;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetText$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PdfTextPageKt.kt */
final class PdfTextPageKt$textPageGetText$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ int $length;
    final /* synthetic */ int $startIndex;
    int label;
    final /* synthetic */ PdfTextPageKt this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PdfTextPageKt$textPageGetText$2(PdfTextPageKt pdfTextPageKt, int i, int i2, Continuation<? super PdfTextPageKt$textPageGetText$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfTextPageKt;
        this.$startIndex = i;
        this.$length = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfTextPageKt$textPageGetText$2(this.this$0, this.$startIndex, this.$length, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((PdfTextPageKt$textPageGetText$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.getPage().textPageGetText(this.$startIndex, this.$length);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
