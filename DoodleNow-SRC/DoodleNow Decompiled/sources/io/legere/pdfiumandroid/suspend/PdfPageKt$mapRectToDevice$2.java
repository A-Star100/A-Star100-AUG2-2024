package io.legere.pdfiumandroid.suspend;

import android.graphics.Rect;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/graphics/Rect;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "io.legere.pdfiumandroid.suspend.PdfPageKt$mapRectToDevice$2", f = "PdfPageKt.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PdfPageKt.kt */
final class PdfPageKt$mapRectToDevice$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Rect>, Object> {
    final /* synthetic */ RectF $coords;
    final /* synthetic */ int $rotate;
    final /* synthetic */ int $sizeX;
    final /* synthetic */ int $sizeY;
    final /* synthetic */ int $startX;
    final /* synthetic */ int $startY;
    int label;
    final /* synthetic */ PdfPageKt this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PdfPageKt$mapRectToDevice$2(PdfPageKt pdfPageKt, int i, int i2, int i3, int i4, int i5, RectF rectF, Continuation<? super PdfPageKt$mapRectToDevice$2> continuation) {
        super(2, continuation);
        this.this$0 = pdfPageKt;
        this.$startX = i;
        this.$startY = i2;
        this.$sizeX = i3;
        this.$sizeY = i4;
        this.$rotate = i5;
        this.$coords = rectF;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PdfPageKt$mapRectToDevice$2(this.this$0, this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Rect> continuation) {
        return ((PdfPageKt$mapRectToDevice$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return this.this$0.getPage().mapRectToDevice(this.$startX, this.$startY, this.$sizeX, this.$sizeY, this.$rotate, this.$coords);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
