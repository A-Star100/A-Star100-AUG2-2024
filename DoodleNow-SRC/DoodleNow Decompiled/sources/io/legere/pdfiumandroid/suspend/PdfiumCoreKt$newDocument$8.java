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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lio/legere/pdfiumandroid/suspend/PdfDocumentKt;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfiumCoreKt$newDocument$8", f = "PdfiumCoreKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PdfiumCoreKt.kt */
final class PdfiumCoreKt$newDocument$8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PdfDocumentKt>, Object> {
    final /* synthetic */ byte[] $data;
    final /* synthetic */ String $password;
    int label;
    final /* synthetic */ PdfiumCoreKt this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PdfiumCoreKt$newDocument$8(PdfiumCoreKt pdfiumCoreKt, byte[] bArr, String str, Continuation<? super PdfiumCoreKt$newDocument$8> continuation) {
        super(2, continuation);
        this.this$0 = pdfiumCoreKt;
        this.$data = bArr;
        this.$password = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfiumCoreKt$newDocument$8(this.this$0, this.$data, this.$password, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PdfDocumentKt> continuation) {
        return ((PdfiumCoreKt$newDocument$8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return new PdfDocumentKt(this.this$0.coreInternal.newDocument(this.$data, this.$password), this.this$0.dispatcher);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
