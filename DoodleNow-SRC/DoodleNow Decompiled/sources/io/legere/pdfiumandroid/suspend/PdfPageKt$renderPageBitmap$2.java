package io.legere.pdfiumandroid.suspend;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PdfPageKt.kt */
final class PdfPageKt$renderPageBitmap$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ int $drawSizeX;
    final /* synthetic */ int $drawSizeY;
    final /* synthetic */ boolean $renderAnnot;
    final /* synthetic */ int $startX;
    final /* synthetic */ int $startY;
    final /* synthetic */ boolean $textMask;
    int label;
    final /* synthetic */ PdfPageKt this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PdfPageKt$renderPageBitmap$2(PdfPageKt pdfPageKt, Bitmap bitmap, int i, int i2, int i3, int i4, boolean z, boolean z2, Continuation<? super PdfPageKt$renderPageBitmap$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfPageKt;
        this.$bitmap = bitmap;
        this.$startX = i;
        this.$startY = i2;
        this.$drawSizeX = i3;
        this.$drawSizeY = i4;
        this.$renderAnnot = z;
        this.$textMask = z2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfPageKt$renderPageBitmap$2(this.this$0, this.$bitmap, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, this.$renderAnnot, this.$textMask, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PdfPageKt$renderPageBitmap$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getPage().renderPageBitmap(this.$bitmap, this.$startX, this.$startY, this.$drawSizeX, this.$drawSizeY, this.$renderAnnot, this.$textMask);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
