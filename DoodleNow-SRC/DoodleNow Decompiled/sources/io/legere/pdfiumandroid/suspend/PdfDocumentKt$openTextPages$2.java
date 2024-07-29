package io.legere.pdfiumandroid.suspend;

import io.legere.pdfiumandroid.PdfTextPage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "Lio/legere/pdfiumandroid/suspend/PdfTextPageKt;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfDocumentKt$openTextPages$2", f = "PdfDocumentKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PdfDocumentKt.kt */
final class PdfDocumentKt$openTextPages$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PdfTextPageKt>>, Object> {
    final /* synthetic */ int $fromIndex;
    final /* synthetic */ int $toIndex;
    int label;
    final /* synthetic */ PdfDocumentKt this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PdfDocumentKt$openTextPages$2(PdfDocumentKt pdfDocumentKt, int i, int i2, Continuation<? super PdfDocumentKt$openTextPages$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfDocumentKt;
        this.$fromIndex = i;
        this.$toIndex = i2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfDocumentKt$openTextPages$2(this.this$0, this.$fromIndex, this.$toIndex, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super List<PdfTextPageKt>> continuation) {
        return ((PdfDocumentKt$openTextPages$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Iterable<PdfTextPage> openTextPages = this.this$0.getDocument().openTextPages(this.$fromIndex, this.$toIndex);
            PdfDocumentKt pdfDocumentKt = this.this$0;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(openTextPages, 10));
            for (PdfTextPage pdfTextPageKt : openTextPages) {
                arrayList.add(new PdfTextPageKt(pdfTextPageKt, pdfDocumentKt.dispatcher));
            }
            return (List) arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
