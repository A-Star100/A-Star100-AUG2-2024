package io.legere.pdfiumandroid.suspend;

import io.legere.pdfiumandroid.PdfDocument;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lio/legere/pdfiumandroid/PdfDocument$Bookmark;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$getTableOfContents$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PdfDocumentKt.kt */
final class PdfDocumentKt$getTableOfContents$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PdfDocument.Bookmark>>, Object> {
    int label;
    final /* synthetic */ PdfDocumentKt this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PdfDocumentKt$getTableOfContents$2(PdfDocumentKt pdfDocumentKt, Continuation<? super PdfDocumentKt$getTableOfContents$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfDocumentKt;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfDocumentKt$getTableOfContents$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PdfDocument.Bookmark>> continuation) {
        return ((PdfDocumentKt$getTableOfContents$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.getDocument().getTableOfContents();
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
