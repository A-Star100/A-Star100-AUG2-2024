package io.legere.pdfiumandroid.suspend;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import io.legere.pdfiumandroid.LoggerInterface;
import io.legere.pdfiumandroid.PdfiumCore;
import io.legere.pdfiumandroid.util.AlreadyClosedBehavior;
import io.legere.pdfiumandroid.util.Config;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@¢\u0006\u0002\u0010\rJ \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH@¢\u0006\u0002\u0010\u0010J\u0018\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H@¢\u0006\u0002\u0010\u0013J\"\u0010\t\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH@¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/legere/pdfiumandroid/suspend/PdfiumCoreKt;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "config", "Lio/legere/pdfiumandroid/util/Config;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lio/legere/pdfiumandroid/util/Config;)V", "coreInternal", "Lio/legere/pdfiumandroid/PdfiumCore;", "newDocument", "Lio/legere/pdfiumandroid/suspend/PdfDocumentKt;", "fd", "Landroid/os/ParcelFileDescriptor;", "(Landroid/os/ParcelFileDescriptor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "password", "", "(Landroid/os/ParcelFileDescriptor;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "data", "", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "([BLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PdfiumCoreKt.kt */
public final class PdfiumCoreKt {
    /* access modifiers changed from: private */
    public final PdfiumCore coreInternal;
    /* access modifiers changed from: private */
    public final CoroutineDispatcher dispatcher;

    public PdfiumCoreKt(CoroutineDispatcher coroutineDispatcher, Config config) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(config, "config");
        this.dispatcher = coroutineDispatcher;
        this.coreInternal = new PdfiumCore((Context) null, config, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PdfiumCoreKt(CoroutineDispatcher coroutineDispatcher, Config config, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(coroutineDispatcher, (i & 2) != 0 ? new Config((LoggerInterface) null, (AlreadyClosedBehavior) null, 3, (DefaultConstructorMarker) null) : config);
    }

    public final Object newDocument(ParcelFileDescriptor parcelFileDescriptor, Continuation<? super PdfDocumentKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfiumCoreKt$newDocument$2(this, parcelFileDescriptor, (Continuation<? super PdfiumCoreKt$newDocument$2>) null), continuation);
    }

    public final Object newDocument(ParcelFileDescriptor parcelFileDescriptor, String str, Continuation<? super PdfDocumentKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfiumCoreKt$newDocument$4(this, parcelFileDescriptor, str, (Continuation<? super PdfiumCoreKt$newDocument$4>) null), continuation);
    }

    public final Object newDocument(byte[] bArr, Continuation<? super PdfDocumentKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfiumCoreKt$newDocument$6(this, bArr, (Continuation<? super PdfiumCoreKt$newDocument$6>) null), continuation);
    }

    public final Object newDocument(byte[] bArr, String str, Continuation<? super PdfDocumentKt> continuation) {
        return BuildersKt.withContext(this.dispatcher, new PdfiumCoreKt$newDocument$8(this, bArr, str, (Continuation<? super PdfiumCoreKt$newDocument$8>) null), continuation);
    }
}
