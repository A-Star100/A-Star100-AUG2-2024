package io.legere.pdfiumandroid.suspend;

import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/graphics/RectF;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfTextPageKt$textPageGetCharBox$2", f = "PdfTextPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PdfTextPageKt.kt */
final class PdfTextPageKt$textPageGetCharBox$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RectF>, Object> {
    final /* synthetic */ int $index;
    int label;
    final /* synthetic */ PdfTextPageKt this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PdfTextPageKt$textPageGetCharBox$2(PdfTextPageKt pdfTextPageKt, int i, Continuation<? super PdfTextPageKt$textPageGetCharBox$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfTextPageKt;
        this.$index = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfTextPageKt$textPageGetCharBox$2(this.this$0, this.$index, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RectF> continuation) {
        return ((PdfTextPageKt$textPageGetCharBox$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.getPage().textPageGetCharBox(this.$index);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
