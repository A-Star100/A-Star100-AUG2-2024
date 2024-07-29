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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$openTextPage$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PdfPageKt.kt */
final class PdfPageKt$openTextPage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PdfTextPageKt>, Object> {
    int label;
    final /* synthetic */ PdfPageKt this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PdfPageKt$openTextPage$2(PdfPageKt pdfPageKt, Continuation<? super PdfPageKt$openTextPage$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfPageKt;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfPageKt$openTextPage$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PdfTextPageKt> continuation) {
        return ((PdfPageKt$openTextPage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new PdfTextPageKt(this.this$0.getPage().openTextPage(), this.this$0.dispatcher);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
