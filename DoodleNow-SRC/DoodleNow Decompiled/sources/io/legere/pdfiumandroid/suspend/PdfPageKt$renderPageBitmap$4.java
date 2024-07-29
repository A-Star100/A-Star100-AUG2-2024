package io.legere.pdfiumandroid.suspend;

import android.graphics.Bitmap;
import android.graphics.Matrix;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$renderPageBitmap$4", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PdfPageKt.kt */
final class PdfPageKt$renderPageBitmap$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ RectF $clipRect;
    final /* synthetic */ Matrix $matrix;
    final /* synthetic */ boolean $renderAnnot;
    final /* synthetic */ boolean $textMask;
    int label;
    final /* synthetic */ PdfPageKt this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PdfPageKt$renderPageBitmap$4(PdfPageKt pdfPageKt, Bitmap bitmap, Matrix matrix, RectF rectF, boolean z, boolean z2, Continuation<? super PdfPageKt$renderPageBitmap$4> continuation) {
        super(2, continuation);
        this.this$0 = pdfPageKt;
        this.$bitmap = bitmap;
        this.$matrix = matrix;
        this.$clipRect = rectF;
        this.$renderAnnot = z;
        this.$textMask = z2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfPageKt$renderPageBitmap$4(this.this$0, this.$bitmap, this.$matrix, this.$clipRect, this.$renderAnnot, this.$textMask, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PdfPageKt$renderPageBitmap$4) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getPage().renderPageBitmap(this.$bitmap, this.$matrix, this.$clipRect, this.$renderAnnot, this.$textMask);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
