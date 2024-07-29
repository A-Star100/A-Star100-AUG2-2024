package com.facebook.fresco.vito.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "canvas", "Landroid/graphics/Canvas;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 176)
/* compiled from: ImageRenderer.kt */
public final class ImageRenderer$paintRenderCommand$1 extends Lambda implements Function1<Canvas, Unit> {
    final /* synthetic */ Paint $paint;
    final /* synthetic */ Shape $shape;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageRenderer$paintRenderCommand$1(Shape shape, Paint paint) {
        super(1);
        this.$shape = shape;
        this.$paint = paint;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Canvas) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.$shape.draw(canvas, this.$paint);
    }
}
