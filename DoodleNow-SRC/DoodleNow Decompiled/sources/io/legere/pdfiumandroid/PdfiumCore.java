package io.legere.pdfiumandroid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.Surface;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.util.AlreadyClosedBehavior;
import io.legere.pdfiumandroid.util.Config;
import io.legere.pdfiumandroid.util.InitLock;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 Y2\u00020\u0001:\u0001YB\u001b\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0007J\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\nH\u0007J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0007J\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0007J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0007J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\nH\u0007J\u0018\u0010\u001f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\nH\u0007J\u0018\u0010 \u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0007J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u00192\u0006\u0010\r\u001a\u00020\u000eH\u0007JP\u0010#\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0007JH\u0010-\u001a\u00020.2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010/\u001a\u00020\u001cH\u0007JH\u00100\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\n2\u0006\u0010/\u001a\u00020.H\u0007J\u0013\u00101\u001a\u0004\u0018\u00010\u001c2\u0006\u00102\u001a\u000203H J\u001b\u00104\u001a\u0002032\u0006\u00105\u001a\u00020\n2\b\u00106\u001a\u0004\u0018\u000107H J\u001d\u00108\u001a\u0002032\b\u00109\u001a\u0004\u0018\u00010:2\b\u00106\u001a\u0004\u0018\u000107H J\u000e\u0010;\u001a\u00020\u000e2\u0006\u00105\u001a\u00020<J\u0018\u0010;\u001a\u00020\u000e2\u0006\u0010=\u001a\u00020<2\b\u00106\u001a\u0004\u0018\u000107J\u0010\u0010;\u001a\u00020\u000e2\b\u00109\u001a\u0004\u0018\u00010:J\u001a\u0010;\u001a\u00020\u000e2\b\u00109\u001a\u0004\u0018\u00010:2\b\u00106\u001a\u0004\u0018\u000107J\u0018\u0010>\u001a\u0002032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0007J+\u0010>\u001a\b\u0012\u0004\u0012\u0002030?2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010@\u001a\u00020\n2\u0006\u0010A\u001a\u00020\nH\u0007¢\u0006\u0002\u0010BJ\u0018\u0010C\u001a\u0002032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0007JL\u0010D\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\n2\b\b\u0002\u0010I\u001a\u00020JH\u0007JL\u0010K\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\n2\b\b\u0002\u0010I\u001a\u00020JH\u0007JV\u0010K\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\n2\u0006\u0010G\u001a\u00020\n2\u0006\u0010H\u001a\u00020\n2\b\b\u0002\u0010I\u001a\u00020J2\b\b\u0002\u0010N\u001a\u00020JH\u0007J\u0018\u0010O\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\nH\u0007J(\u0010P\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010Q\u001a\u00020\n2\u0006\u0010R\u001a\u00020\nH\u0007J*\u0010S\u001a\u0004\u0018\u0001072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\nH\u0007J\"\u0010V\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0007J*\u0010W\u001a\u0004\u0018\u0001072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010X\u001a\u00020\n2\u0006\u0010R\u001a\u00020\nH\u0007R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lio/legere/pdfiumandroid/PdfiumCore;", "", "context", "Landroid/content/Context;", "config", "Lio/legere/pdfiumandroid/util/Config;", "(Landroid/content/Context;Lio/legere/pdfiumandroid/util/Config;)V", "getConfig", "()Lio/legere/pdfiumandroid/util/Config;", "mCurrentDpi", "", "closeDocument", "", "pdfDocument", "Lio/legere/pdfiumandroid/PdfDocument;", "closePage", "pageIndex", "closeTextPage", "getDocumentMeta", "Lio/legere/pdfiumandroid/PdfDocument$Meta;", "getPageCount", "getPageHeight", "index", "getPageHeightPoint", "getPageLinks", "", "Lio/legere/pdfiumandroid/PdfDocument$Link;", "getPageMediaBox", "Landroid/graphics/RectF;", "getPageSize", "Lio/legere/pdfiumandroid/util/Size;", "getPageWidth", "getPageWidthPoint", "getTableOfContents", "Lio/legere/pdfiumandroid/PdfDocument$Bookmark;", "mapPageCoordsToDevice", "Landroid/graphics/Point;", "startX", "startY", "sizeX", "sizeY", "rotate", "pageX", "", "pageY", "mapRectToDevice", "Landroid/graphics/Rect;", "coords", "mapRectToPage", "nativeGetLinkRect", "linkPtr", "", "nativeOpenDocument", "fd", "password", "", "nativeOpenMemDocument", "data", "", "newDocument", "Landroid/os/ParcelFileDescriptor;", "parcelFileDescriptor", "openPage", "", "fromIndex", "toIndex", "(Lio/legere/pdfiumandroid/PdfDocument;II)[Ljava/lang/Long;", "openTextPage", "renderPage", "surface", "Landroid/view/Surface;", "drawSizeX", "drawSizeY", "renderAnnot", "", "renderPageBitmap", "bitmap", "Landroid/graphics/Bitmap;", "textMask", "textPageCountChars", "textPageCountRects", "startIndex", "count", "textPageGetBoundedText", "sourceRect", "size", "textPageGetRect", "textPageGetText", "start", "Companion", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PdfiumCore.kt */
public final class PdfiumCore {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG;
    /* access modifiers changed from: private */
    public static final InitLock isReady = new InitLock();
    /* access modifiers changed from: private */
    public static final Object lock = new Object();
    private final Config config;
    private final int mCurrentDpi;

    public PdfiumCore() {
        this((Context) null, (Config) null, 3, (DefaultConstructorMarker) null);
    }

    private final native RectF nativeGetLinkRect(long j);

    private final native long nativeOpenDocument(int i, String str);

    private final native long nativeOpenMemDocument(byte[] bArr, String str);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use page.close()", replaceWith = @ReplaceWith(expression = "page.close()", imports = {}))
    public final void closePage(PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use textPage.close()", replaceWith = @ReplaceWith(expression = "textPage.close()", imports = {}))
    public final void closeTextPage(PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
    }

    public final Config getConfig() {
        return this.config;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfDocument.openPage()", replaceWith = @ReplaceWith(expression = "pdfDocument.openPage(pageIndex)", imports = {}))
    public final long openPage(PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return (long) i;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfDocument.openTextPage()", replaceWith = @ReplaceWith(expression = "pdfDocument.openTextPage(pageIndex)", imports = {}))
    public final long openTextPage(PdfDocument pdfDocument, int i) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return (long) i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x002c, code lost:
        r3 = (r3 = r3.getResources()).getDisplayMetrics();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PdfiumCore(android.content.Context r3, io.legere.pdfiumandroid.util.Config r4) {
        /*
            r2 = this;
            java.lang.String r0 = "config"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r2.<init>()
            r2.config = r4
            io.legere.pdfiumandroid.util.ConfigKt.setPdfiumConfig(r4)
            io.legere.pdfiumandroid.Logger r0 = io.legere.pdfiumandroid.Logger.INSTANCE
            io.legere.pdfiumandroid.LoggerInterface r4 = r4.getLogger()
            r0.setLogger(r4)
            io.legere.pdfiumandroid.Logger r4 = io.legere.pdfiumandroid.Logger.INSTANCE
            java.lang.String r0 = TAG
            java.lang.String r1 = "TAG"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.String r1 = "Starting PdfiumAndroid "
            r4.d(r0, r1)
            if (r3 == 0) goto L_0x0035
            android.content.res.Resources r3 = r3.getResources()
            if (r3 == 0) goto L_0x0035
            android.util.DisplayMetrics r3 = r3.getDisplayMetrics()
            if (r3 == 0) goto L_0x0035
            int r3 = r3.densityDpi
            goto L_0x0036
        L_0x0035:
            r3 = -1
        L_0x0036:
            r2.mCurrentDpi = r3
            io.legere.pdfiumandroid.util.InitLock r3 = isReady
            r3.waitForReady()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.<init>(android.content.Context, io.legere.pdfiumandroid.util.Config):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PdfiumCore(Context context, Config config2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : context, (i & 2) != 0 ? new Config((LoggerInterface) null, (AlreadyClosedBehavior) null, 3, (DefaultConstructorMarker) null) : config2);
    }

    public final PdfDocument newDocument(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        Intrinsics.checkNotNullParameter(parcelFileDescriptor, "fd");
        return newDocument(parcelFileDescriptor, (String) null);
    }

    public final PdfDocument newDocument(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        PdfDocument pdfDocument;
        Intrinsics.checkNotNullParameter(parcelFileDescriptor, "parcelFileDescriptor");
        synchronized (lock) {
            pdfDocument = new PdfDocument(nativeOpenDocument(parcelFileDescriptor.getFd(), str));
            pdfDocument.setParcelFileDescriptor(parcelFileDescriptor);
        }
        return pdfDocument;
    }

    public final PdfDocument newDocument(byte[] bArr) throws IOException {
        return newDocument(bArr, (String) null);
    }

    public final PdfDocument newDocument(byte[] bArr, String str) throws IOException {
        PdfDocument pdfDocument;
        synchronized (lock) {
            pdfDocument = new PdfDocument(nativeOpenMemDocument(bArr, str));
            pdfDocument.setParcelFileDescriptor((ParcelFileDescriptor) null);
        }
        return pdfDocument;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfDocument.getPageCount()", replaceWith = @ReplaceWith(expression = "pdfDocument.getPageCount()", imports = {}))
    public final void getPageCount(PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        pdfDocument.getPageCount();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfDocument.closeDocument()", replaceWith = @ReplaceWith(expression = "pdfDocument.close()", imports = {}))
    public final void closeDocument(PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        pdfDocument.close();
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfDocument.getTableOfContents()", replaceWith = @ReplaceWith(expression = "pdfDocument.getTableOfContents()", imports = {}))
    public final List<PdfDocument.Bookmark> getTableOfContents(PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return pdfDocument.getTableOfContents();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use Page.getPageMediaBox()", replaceWith = @kotlin.ReplaceWith(expression = "page.getPageMediaBox()", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.RectF getPageMediaBox(io.legere.pdfiumandroid.PdfDocument r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            io.legere.pdfiumandroid.PdfPage r2 = r2.openPage(r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            io.legere.pdfiumandroid.PdfPage r3 = (io.legere.pdfiumandroid.PdfPage) r3     // Catch:{ all -> 0x0017 }
            android.graphics.RectF r3 = r3.getPageMediaBox()     // Catch:{ all -> 0x0017 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            return r3
        L_0x0017:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.getPageMediaBox(io.legere.pdfiumandroid.PdfDocument, int):android.graphics.RectF");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002d, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0030, code lost:
        throw r0;
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use textPage.textPageCountChars()", replaceWith = @kotlin.ReplaceWith(expression = "textPage.textPageCountChars()", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int textPageCountChars(io.legere.pdfiumandroid.PdfDocument r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            io.legere.pdfiumandroid.PdfPage r3 = r3.openPage(r4)
            java.io.Closeable r3 = (java.io.Closeable) r3
            r4 = r3
            io.legere.pdfiumandroid.PdfPage r4 = (io.legere.pdfiumandroid.PdfPage) r4     // Catch:{ all -> 0x002a }
            io.legere.pdfiumandroid.PdfTextPage r4 = r4.openTextPage()     // Catch:{ all -> 0x002a }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x002a }
            r0 = r4
            io.legere.pdfiumandroid.PdfTextPage r0 = (io.legere.pdfiumandroid.PdfTextPage) r0     // Catch:{ all -> 0x0023 }
            int r0 = r0.textPageCountChars()     // Catch:{ all -> 0x0023 }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r4, r1)     // Catch:{ all -> 0x002a }
            kotlin.io.CloseableKt.closeFinally(r3, r1)
            return r0
        L_0x0023:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r4, r0)     // Catch:{ all -> 0x002a }
            throw r1     // Catch:{ all -> 0x002a }
        L_0x002a:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x002c }
        L_0x002c:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.textPageCountChars(io.legere.pdfiumandroid.PdfDocument, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002d, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0030, code lost:
        throw r4;
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use textPage.textPageGetText(start, count)", replaceWith = @kotlin.ReplaceWith(expression = "textPage.textPageGetText(start, count)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String textPageGetText(io.legere.pdfiumandroid.PdfDocument r2, int r3, int r4, int r5) {
        /*
            r1 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            io.legere.pdfiumandroid.PdfPage r2 = r2.openPage(r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            io.legere.pdfiumandroid.PdfPage r3 = (io.legere.pdfiumandroid.PdfPage) r3     // Catch:{ all -> 0x002a }
            io.legere.pdfiumandroid.PdfTextPage r3 = r3.openTextPage()     // Catch:{ all -> 0x002a }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x002a }
            r0 = r3
            io.legere.pdfiumandroid.PdfTextPage r0 = (io.legere.pdfiumandroid.PdfTextPage) r0     // Catch:{ all -> 0x0023 }
            java.lang.String r4 = r0.textPageGetText(r4, r5)     // Catch:{ all -> 0x0023 }
            r5 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r5)     // Catch:{ all -> 0x002a }
            kotlin.io.CloseableKt.closeFinally(r2, r5)
            return r4
        L_0x0023:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)     // Catch:{ all -> 0x002a }
            throw r5     // Catch:{ all -> 0x002a }
        L_0x002a:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002c }
        L_0x002c:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.textPageGetText(io.legere.pdfiumandroid.PdfDocument, int, int, int):java.lang.String");
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use pdfDocument.getDocumentMeta()", replaceWith = @ReplaceWith(expression = "pdfDocument.getDocumentMeta()", imports = {}))
    public final PdfDocument.Meta getDocumentMeta(PdfDocument pdfDocument) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return pdfDocument.getDocumentMeta();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use PdfPage.getPageWidthPoint()", replaceWith = @kotlin.ReplaceWith(expression = "page.getPageWidthPoint()", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getPageWidthPoint(io.legere.pdfiumandroid.PdfDocument r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            io.legere.pdfiumandroid.PdfPage r2 = r2.openPage(r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            io.legere.pdfiumandroid.PdfPage r3 = (io.legere.pdfiumandroid.PdfPage) r3     // Catch:{ all -> 0x0017 }
            int r3 = r3.getPageWidthPoint()     // Catch:{ all -> 0x0017 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            return r3
        L_0x0017:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.getPageWidthPoint(io.legere.pdfiumandroid.PdfDocument, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use PdfPage.getPageHeightPoint()", replaceWith = @kotlin.ReplaceWith(expression = "page.getPageHeightPoint()", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getPageHeightPoint(io.legere.pdfiumandroid.PdfDocument r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            io.legere.pdfiumandroid.PdfPage r2 = r2.openPage(r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            io.legere.pdfiumandroid.PdfPage r3 = (io.legere.pdfiumandroid.PdfPage) r3     // Catch:{ all -> 0x0017 }
            int r3 = r3.getPageHeightPoint()     // Catch:{ all -> 0x0017 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            return r3
        L_0x0017:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.getPageHeightPoint(io.legere.pdfiumandroid.PdfDocument, int):int");
    }

    public static /* synthetic */ void renderPageBitmap$default(PdfiumCore pdfiumCore, PdfDocument pdfDocument, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, int i6, Object obj) {
        int i7 = i6;
        pdfiumCore.renderPageBitmap(pdfDocument, bitmap, i, i2, i3, i4, i5, (i7 & 128) != 0 ? false : z, (i7 & 256) != 0 ? false : z2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.renderPageBitmap(bitmap, startX, startY, drawSizeX, drawSizeY, screenDpi, renderAnnot, textMask)", replaceWith = @ReplaceWith(expression = "page.renderPageBitmap(bitmap, startX, startY, drawSizeX, drawSizeY, screenDpi, renderAnnot, textMask)", imports = {}))
    public final void renderPageBitmap(PdfDocument pdfDocument, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2) {
        Throwable th;
        PdfDocument pdfDocument2 = pdfDocument;
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        int i6 = i;
        Closeable openPage = pdfDocument.openPage(i);
        try {
            ((PdfPage) openPage).renderPageBitmap(bitmap, i2, i3, i4, i5, z, z2);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(openPage, (Throwable) null);
        } catch (Throwable th2) {
            Throwable th3 = th2;
            CloseableKt.closeFinally(openPage, th);
            throw th3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002d, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0030, code lost:
        throw r4;
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use PdfPage.textPageGetRect(index)", replaceWith = @kotlin.ReplaceWith(expression = "page.textPageGetRect(index)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.RectF textPageGetRect(io.legere.pdfiumandroid.PdfDocument r2, int r3, int r4) {
        /*
            r1 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            io.legere.pdfiumandroid.PdfPage r2 = r2.openPage(r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            io.legere.pdfiumandroid.PdfPage r3 = (io.legere.pdfiumandroid.PdfPage) r3     // Catch:{ all -> 0x002a }
            io.legere.pdfiumandroid.PdfTextPage r3 = r3.openTextPage()     // Catch:{ all -> 0x002a }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x002a }
            r0 = r3
            io.legere.pdfiumandroid.PdfTextPage r0 = (io.legere.pdfiumandroid.PdfTextPage) r0     // Catch:{ all -> 0x0023 }
            android.graphics.RectF r4 = r0.textPageGetRect(r4)     // Catch:{ all -> 0x0023 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r0)     // Catch:{ all -> 0x002a }
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            return r4
        L_0x0023:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)     // Catch:{ all -> 0x002a }
            throw r0     // Catch:{ all -> 0x002a }
        L_0x002a:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002c }
        L_0x002c:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.textPageGetRect(io.legere.pdfiumandroid.PdfDocument, int, int):android.graphics.RectF");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002e, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0031, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0032, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0035, code lost:
        throw r4;
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use PdfPage.textPageGetBoundedText(sourceRect, size)", replaceWith = @kotlin.ReplaceWith(expression = "page.textPageGetBoundedText(sourceRect, size)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String textPageGetBoundedText(io.legere.pdfiumandroid.PdfDocument r2, int r3, android.graphics.RectF r4, int r5) {
        /*
            r1 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "sourceRect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            io.legere.pdfiumandroid.PdfPage r2 = r2.openPage(r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            io.legere.pdfiumandroid.PdfPage r3 = (io.legere.pdfiumandroid.PdfPage) r3     // Catch:{ all -> 0x002f }
            io.legere.pdfiumandroid.PdfTextPage r3 = r3.openTextPage()     // Catch:{ all -> 0x002f }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x002f }
            r0 = r3
            io.legere.pdfiumandroid.PdfTextPage r0 = (io.legere.pdfiumandroid.PdfTextPage) r0     // Catch:{ all -> 0x0028 }
            java.lang.String r4 = r0.textPageGetBoundedText(r4, r5)     // Catch:{ all -> 0x0028 }
            r5 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r5)     // Catch:{ all -> 0x002f }
            kotlin.io.CloseableKt.closeFinally(r2, r5)
            return r4
        L_0x0028:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x002a }
        L_0x002a:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)     // Catch:{ all -> 0x002f }
            throw r5     // Catch:{ all -> 0x002f }
        L_0x002f:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0031 }
        L_0x0031:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.textPageGetBoundedText(io.legere.pdfiumandroid.PdfDocument, int, android.graphics.RectF, int):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r9);
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use PdfPage.mapRectToPage(startX, startY, sizeX, sizeY, rotate, coords)", replaceWith = @kotlin.ReplaceWith(expression = "page.mapRectToPage(startX, startY, sizeX, sizeY, rotate, coords)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.RectF mapRectToPage(io.legere.pdfiumandroid.PdfDocument r8, int r9, int r10, int r11, int r12, int r13, int r14, android.graphics.Rect r15) {
        /*
            r7 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "coords"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            io.legere.pdfiumandroid.PdfPage r8 = r8.openPage(r9)
            java.io.Closeable r8 = (java.io.Closeable) r8
            r0 = r8
            io.legere.pdfiumandroid.PdfPage r0 = (io.legere.pdfiumandroid.PdfPage) r0     // Catch:{ all -> 0x0022 }
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            android.graphics.RectF r9 = r0.mapRectToPage(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0022 }
            r10 = 0
            kotlin.io.CloseableKt.closeFinally(r8, r10)
            return r9
        L_0x0022:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r10 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.mapRectToPage(io.legere.pdfiumandroid.PdfDocument, int, int, int, int, int, int, android.graphics.Rect):android.graphics.RectF");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0029, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002d, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0030, code lost:
        throw r4;
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use PdfTextPage.textPageCountRects(startIndex, count)", replaceWith = @kotlin.ReplaceWith(expression = "textPage.textPageCountRects(startIndex, count)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int textPageCountRects(io.legere.pdfiumandroid.PdfDocument r2, int r3, int r4, int r5) {
        /*
            r1 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            io.legere.pdfiumandroid.PdfPage r2 = r2.openPage(r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            io.legere.pdfiumandroid.PdfPage r3 = (io.legere.pdfiumandroid.PdfPage) r3     // Catch:{ all -> 0x002a }
            io.legere.pdfiumandroid.PdfTextPage r3 = r3.openTextPage()     // Catch:{ all -> 0x002a }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x002a }
            r0 = r3
            io.legere.pdfiumandroid.PdfTextPage r0 = (io.legere.pdfiumandroid.PdfTextPage) r0     // Catch:{ all -> 0x0023 }
            int r4 = r0.textPageCountRects(r4, r5)     // Catch:{ all -> 0x0023 }
            r5 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r5)     // Catch:{ all -> 0x002a }
            kotlin.io.CloseableKt.closeFinally(r2, r5)
            return r4
        L_0x0023:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0025 }
        L_0x0025:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)     // Catch:{ all -> 0x002a }
            throw r5     // Catch:{ all -> 0x002a }
        L_0x002a:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x002c }
        L_0x002c:
            r4 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.textPageCountRects(io.legere.pdfiumandroid.PdfDocument, int, int, int):int");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use PdfDocument.openPage(fromIndex, toIndex)", replaceWith = @ReplaceWith(expression = "pdfDocument.openPage(fromIndex, toIndex)", imports = {}))
    public final Long[] openPage(PdfDocument pdfDocument, int i, int i2) {
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        return (Long[]) CollectionsKt.toList(new LongRange((long) i, (long) i2)).toArray(new Long[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use PdfPage.getPageWidth()", replaceWith = @kotlin.ReplaceWith(expression = "page.getPageWidth()", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getPageWidth(io.legere.pdfiumandroid.PdfDocument r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            io.legere.pdfiumandroid.PdfPage r2 = r2.openPage(r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            io.legere.pdfiumandroid.PdfPage r3 = (io.legere.pdfiumandroid.PdfPage) r3     // Catch:{ all -> 0x0019 }
            int r0 = r1.mCurrentDpi     // Catch:{ all -> 0x0019 }
            int r3 = r3.getPageWidth(r0)     // Catch:{ all -> 0x0019 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            return r3
        L_0x0019:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001b }
        L_0x001b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.getPageWidth(io.legere.pdfiumandroid.PdfDocument, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use PdfPage.getPageHeight()", replaceWith = @kotlin.ReplaceWith(expression = "page.getPageHeight()", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getPageHeight(io.legere.pdfiumandroid.PdfDocument r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            io.legere.pdfiumandroid.PdfPage r2 = r2.openPage(r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            io.legere.pdfiumandroid.PdfPage r3 = (io.legere.pdfiumandroid.PdfPage) r3     // Catch:{ all -> 0x0019 }
            int r0 = r1.mCurrentDpi     // Catch:{ all -> 0x0019 }
            int r3 = r3.getPageHeight(r0)     // Catch:{ all -> 0x0019 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            return r3
        L_0x0019:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001b }
        L_0x001b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.getPageHeight(io.legere.pdfiumandroid.PdfDocument, int):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use PdfPage.getPageSize()", replaceWith = @kotlin.ReplaceWith(expression = "page.getPageSize()", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final io.legere.pdfiumandroid.util.Size getPageSize(io.legere.pdfiumandroid.PdfDocument r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            io.legere.pdfiumandroid.PdfPage r2 = r2.openPage(r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            io.legere.pdfiumandroid.PdfPage r3 = (io.legere.pdfiumandroid.PdfPage) r3     // Catch:{ all -> 0x0019 }
            int r0 = r1.mCurrentDpi     // Catch:{ all -> 0x0019 }
            io.legere.pdfiumandroid.util.Size r3 = r3.getPageSize(r0)     // Catch:{ all -> 0x0019 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            return r3
        L_0x0019:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001b }
        L_0x001b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.getPageSize(io.legere.pdfiumandroid.PdfDocument, int):io.legere.pdfiumandroid.util.Size");
    }

    public static /* synthetic */ void renderPage$default(PdfiumCore pdfiumCore, PdfDocument pdfDocument, Surface surface, int i, int i2, int i3, int i4, int i5, boolean z, int i6, Object obj) {
        pdfiumCore.renderPage(pdfDocument, surface, i, i2, i3, i4, i5, (i6 & 128) != 0 ? false : z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r9);
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use PdfPage.renderPage(surface, startX, startY, drawSizeX, drawSizeY)", replaceWith = @kotlin.ReplaceWith(expression = "page.renderPage(surface, startX, startY, drawSizeX, drawSizeY)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void renderPage(io.legere.pdfiumandroid.PdfDocument r8, android.view.Surface r9, int r10, int r11, int r12, int r13, int r14, boolean r15) {
        /*
            r7 = this;
            java.lang.String r15 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r15)
            io.legere.pdfiumandroid.PdfPage r8 = r8.openPage(r10)
            java.io.Closeable r8 = (java.io.Closeable) r8
            r0 = r8
            io.legere.pdfiumandroid.PdfPage r0 = (io.legere.pdfiumandroid.PdfPage) r0     // Catch:{ all -> 0x001e }
            r6 = 0
            r1 = r9
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r0.renderPage(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x001e }
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001e }
            r9 = 0
            kotlin.io.CloseableKt.closeFinally(r8, r9)
            return
        L_0x001e:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r10 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.renderPage(io.legere.pdfiumandroid.PdfDocument, android.view.Surface, int, int, int, int, int, boolean):void");
    }

    public static /* synthetic */ void renderPageBitmap$default(PdfiumCore pdfiumCore, PdfDocument pdfDocument, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z, int i6, Object obj) {
        pdfiumCore.renderPageBitmap(pdfDocument, bitmap, i, i2, i3, i4, i5, (i6 & 128) != 0 ? false : z);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.renderPageBitmap(bitmap, startX, startY, drawSizeX, drawSizeY)", replaceWith = @ReplaceWith(expression = "page.renderPageBitmap(bitmap, startX, startY, drawSizeX, drawSizeY)", imports = {}))
    public final void renderPageBitmap(PdfDocument pdfDocument, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z) {
        Throwable th;
        PdfDocument pdfDocument2 = pdfDocument;
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        int i6 = i;
        Closeable openPage = pdfDocument.openPage(i);
        try {
            PdfPage.renderPageBitmap$default((PdfPage) openPage, bitmap, i2, i3, i4, i5, z, false, 64, (Object) null);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(openPage, (Throwable) null);
        } catch (Throwable th2) {
            Throwable th3 = th2;
            CloseableKt.closeFinally(openPage, th);
            throw th3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r3);
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use PdfPage.getPageLinks()", replaceWith = @kotlin.ReplaceWith(expression = "page.getPageLinks()", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<io.legere.pdfiumandroid.PdfDocument.Link> getPageLinks(io.legere.pdfiumandroid.PdfDocument r2, int r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            io.legere.pdfiumandroid.PdfPage r2 = r2.openPage(r3)
            java.io.Closeable r2 = (java.io.Closeable) r2
            r3 = r2
            io.legere.pdfiumandroid.PdfPage r3 = (io.legere.pdfiumandroid.PdfPage) r3     // Catch:{ all -> 0x0017 }
            java.util.List r3 = r3.getPageLinks()     // Catch:{ all -> 0x0017 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            return r3
        L_0x0017:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.getPageLinks(io.legere.pdfiumandroid.PdfDocument, int):java.util.List");
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use PdfPage.mapPageCoordsToDevice(startX, startY, sizeX, sizeY, rotate, pageX, pageY)", replaceWith = @ReplaceWith(expression = "page.mapPageCoordsToDevice(startX, startY, sizeX, sizeY, rotate, pageX, pageY)", imports = {}))
    public final Point mapPageCoordsToDevice(PdfDocument pdfDocument, int i, int i2, int i3, int i4, int i5, int i6, double d, double d2) {
        Throwable th;
        PdfDocument pdfDocument2 = pdfDocument;
        Intrinsics.checkNotNullParameter(pdfDocument, "pdfDocument");
        Closeable openPage = pdfDocument.openPage(i);
        try {
            Point mapPageCoordsToDevice = ((PdfPage) openPage).mapPageCoordsToDevice(i2, i3, i4, i5, i6, d, d2);
            CloseableKt.closeFinally(openPage, (Throwable) null);
            return mapPageCoordsToDevice;
        } catch (Throwable th2) {
            Throwable th3 = th2;
            CloseableKt.closeFinally(openPage, th);
            throw th3;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
        throw r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r9);
     */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.WARNING, message = "Use PdfPage.mapRectToDevice(startX, startY, sizeX, sizeY, rotate, coords)", replaceWith = @kotlin.ReplaceWith(expression = "page.mapRectToDevice(startX, startY, sizeX, sizeY, rotate, coords)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.graphics.Rect mapRectToDevice(io.legere.pdfiumandroid.PdfDocument r8, int r9, int r10, int r11, int r12, int r13, int r14, android.graphics.RectF r15) {
        /*
            r7 = this;
            java.lang.String r0 = "pdfDocument"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "coords"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            io.legere.pdfiumandroid.PdfPage r8 = r8.openPage(r9)
            java.io.Closeable r8 = (java.io.Closeable) r8
            r0 = r8
            io.legere.pdfiumandroid.PdfPage r0 = (io.legere.pdfiumandroid.PdfPage) r0     // Catch:{ all -> 0x0022 }
            r1 = r10
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            android.graphics.Rect r9 = r0.mapRectToDevice(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0022 }
            r10 = 0
            kotlin.io.CloseableKt.closeFinally(r8, r10)
            return r9
        L_0x0022:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0024 }
        L_0x0024:
            r10 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: io.legere.pdfiumandroid.PdfiumCore.mapRectToDevice(io.legere.pdfiumandroid.PdfDocument, int, int, int, int, int, int, android.graphics.RectF):android.graphics.Rect");
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\bR\u0011\u0010\t\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lio/legere/pdfiumandroid/PdfiumCore$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "isReady", "Lio/legere/pdfiumandroid/util/InitLock;", "()Lio/legere/pdfiumandroid/util/InitLock;", "lock", "getLock", "()Ljava/lang/Object;", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PdfiumCore.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Object getLock() {
            return PdfiumCore.lock;
        }

        public final InitLock isReady() {
            return PdfiumCore.isReady;
        }
    }

    static {
        String name = PdfiumCore.class.getName();
        TAG = name;
        Log.d(name, "init");
        new Thread(new PdfiumCore$$ExternalSyntheticLambda0()).start();
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$28() {
        String str = TAG;
        Log.d(str, "init thread start");
        synchronized (lock) {
            Log.d(str, "init in lock");
            try {
                System.loadLibrary("absl.cr");
                System.loadLibrary("c++_chrome.cr");
                System.loadLibrary("chrome_zlib.cr");
                System.loadLibrary("icuuc.cr");
                System.loadLibrary("partition_alloc.cr");
                System.loadLibrary("pdfium.cr");
                System.loadLibrary("pdfiumandroid");
                isReady.markReady();
            } catch (UnsatisfiedLinkError e) {
                Logger logger = Logger.INSTANCE;
                String str2 = TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                logger.e(str2, e, "Native libraries failed to load");
            }
            Log.d(TAG, "init in lock");
            Unit unit = Unit.INSTANCE;
        }
    }
}
