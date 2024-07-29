package io.legere.pdfiumandroid;

import android.graphics.RectF;
import androidx.camera.video.AudioStats;
import io.legere.pdfiumandroid.PdfDocument;
import io.legere.pdfiumandroid.util.ConfigKt;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000e\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u000b\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\b\u0002\u0018\u0000 F2\u00020\u0001:\u0001FB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0005J\u0011\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0006\u001a\u00020\u0007H J\u0019\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0005H J\u0011\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0007H J!\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H J9\u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(H J\u0019\u0010)\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0005H J1\u0010,\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0019H J\u0019\u00101\u001a\u00020*2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0005H J)\u00103\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u00104\u001a\u00020(H J)\u00105\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u00104\u001a\u000206H J\u0019\u00107\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u0005H J\u0006\u00108\u001a\u00020\u0005J\u0016\u00109\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005J\u0018\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u0005J\u0010\u0010?\u001a\u0004\u0018\u00010=2\u0006\u0010+\u001a\u00020\u0005J&\u0010@\u001a\u00020\u00052\u0006\u0010-\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0019J\u0010\u0010A\u001a\u0004\u0018\u00010=2\u0006\u00102\u001a\u00020\u0005J\u0018\u0010B\u001a\u0004\u0018\u00010;2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005J\u0018\u0010C\u001a\u0004\u0018\u00010;2\u0006\u0010 \u001a\u00020\u00052\u0006\u0010>\u001a\u00020\u0005J\u000e\u0010D\u001a\u00020E2\u0006\u0010+\u001a\u00020\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006G"}, d2 = {"Lio/legere/pdfiumandroid/PdfTextPage;", "Ljava/io/Closeable;", "doc", "Lio/legere/pdfiumandroid/PdfDocument;", "pageIndex", "", "pagePtr", "", "pageMap", "", "Lio/legere/pdfiumandroid/PdfDocument$PageCount;", "(Lio/legere/pdfiumandroid/PdfDocument;IJLjava/util/Map;)V", "getDoc", "()Lio/legere/pdfiumandroid/PdfDocument;", "isClosed", "", "getPageIndex", "()I", "getPageMap", "()Ljava/util/Map;", "getPagePtr", "()J", "close", "", "getFontSize", "", "charIndex", "nativeCloseTextPage", "nativeGetFontSize", "nativeTextCountChars", "textPagePtr", "nativeTextCountRects", "startIndex", "count", "nativeTextGetBoundedText", "left", "top", "right", "bottom", "arr", "", "nativeTextGetCharBox", "", "index", "nativeTextGetCharIndexAtPos", "x", "y", "xTolerance", "yTolerance", "nativeTextGetRect", "rectIndex", "nativeTextGetText", "result", "nativeTextGetTextByteArray", "", "nativeTextGetUnicode", "textPageCountChars", "textPageCountRects", "textPageGetBoundedText", "", "rect", "Landroid/graphics/RectF;", "length", "textPageGetCharBox", "textPageGetCharIndexAtPos", "textPageGetRect", "textPageGetText", "textPageGetTextLegacy", "textPageGetUnicode", "", "Companion", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PdfTextPage.kt */
public final class PdfTextPage implements Closeable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = PdfTextPage.class.getName();
    private final PdfDocument doc;
    private boolean isClosed;
    private final int pageIndex;
    private final Map<Integer, PdfDocument.PageCount> pageMap;
    private final long pagePtr;

    private final native void nativeCloseTextPage(long j);

    private final native double nativeGetFontSize(long j, int i);

    private final native int nativeTextCountChars(long j);

    private final native int nativeTextCountRects(long j, int i, int i2);

    private final native int nativeTextGetBoundedText(long j, double d, double d2, double d3, double d4, short[] sArr);

    private final native double[] nativeTextGetCharBox(long j, int i);

    private final native int nativeTextGetCharIndexAtPos(long j, double d, double d2, double d3, double d4);

    private final native double[] nativeTextGetRect(long j, int i);

    private final native int nativeTextGetText(long j, int i, int i2, short[] sArr);

    private final native int nativeTextGetTextByteArray(long j, int i, int i2, byte[] bArr);

    private final native int nativeTextGetUnicode(long j, int i);

    public final PdfDocument getDoc() {
        return this.doc;
    }

    public final int getPageIndex() {
        return this.pageIndex;
    }

    public final Map<Integer, PdfDocument.PageCount> getPageMap() {
        return this.pageMap;
    }

    public final long getPagePtr() {
        return this.pagePtr;
    }

    public PdfTextPage(PdfDocument pdfDocument, int i, long j, Map<Integer, PdfDocument.PageCount> map) {
        Intrinsics.checkNotNullParameter(pdfDocument, "doc");
        Intrinsics.checkNotNullParameter(map, "pageMap");
        this.doc = pdfDocument;
        this.pageIndex = i;
        this.pagePtr = j;
        this.pageMap = map;
    }

    public final int textPageCountChars() {
        int nativeTextCountChars;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            nativeTextCountChars = nativeTextCountChars(this.pagePtr);
        }
        return nativeTextCountChars;
    }

    public final String textPageGetTextLegacy(int i, int i2) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                short[] sArr = new short[(i2 + 1)];
                int nativeTextGetText = nativeTextGetText(this.pagePtr, i, i2, sArr);
                if (nativeTextGetText <= 0) {
                    return "";
                }
                int i3 = nativeTextGetText - 1;
                byte[] bArr = new byte[(i3 * 2)];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                for (int i4 = 0; i4 < i3; i4++) {
                    wrap.putShort(sArr[i4]);
                }
                Charset charset = StandardCharsets.UTF_16LE;
                Intrinsics.checkNotNullExpressionValue(charset, "UTF_16LE");
                String str = new String(bArr, charset);
                return str;
            } catch (NullPointerException e) {
                Logger logger = Logger.INSTANCE;
                String str2 = TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                logger.e(str2, e, "mContext may be null");
                return null;
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String str3 = TAG;
                Intrinsics.checkNotNullExpressionValue(str3, "TAG");
                logger2.e(str3, e2, "Exception throw from native");
                return null;
            }
        }
    }

    public final String textPageGetText(int i, int i2) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                byte[] bArr = new byte[(i2 * 2)];
                if (nativeTextGetTextByteArray(this.pagePtr, i, i2, bArr) <= 0) {
                    return "";
                }
                Charset charset = StandardCharsets.UTF_16LE;
                Intrinsics.checkNotNullExpressionValue(charset, "UTF_16LE");
                String str = new String(bArr, charset);
                return str;
            } catch (NullPointerException e) {
                Logger logger = Logger.INSTANCE;
                String str2 = TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                logger.e(str2, e, "mContext may be null");
                return null;
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String str3 = TAG;
                Intrinsics.checkNotNullExpressionValue(str3, "TAG");
                logger2.e(str3, e2, "Exception throw from native");
                return null;
            }
        }
    }

    public final char textPageGetUnicode(int i) {
        char nativeTextGetUnicode;
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            nativeTextGetUnicode = (char) nativeTextGetUnicode(this.pagePtr, i);
        }
        return nativeTextGetUnicode;
    }

    public final RectF textPageGetCharBox(int i) {
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                double[] nativeTextGetCharBox = nativeTextGetCharBox(this.pagePtr, i);
                RectF rectF = new RectF();
                rectF.left = (float) nativeTextGetCharBox[0];
                rectF.right = (float) nativeTextGetCharBox[1];
                rectF.bottom = (float) nativeTextGetCharBox[2];
                rectF.top = (float) nativeTextGetCharBox[3];
                return rectF;
            } catch (NullPointerException e) {
                Logger logger = Logger.INSTANCE;
                String str = TAG;
                Intrinsics.checkNotNullExpressionValue(str, "TAG");
                logger.e(str, e, "mContext may be null");
                Unit unit = Unit.INSTANCE;
                return null;
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String str2 = TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                logger2.e(str2, e2, "Exception throw from native");
                Unit unit2 = Unit.INSTANCE;
                return null;
            }
        }
    }

    public final int textPageGetCharIndexAtPos(double d, double d2, double d3, double d4) {
        int nativeTextGetCharIndexAtPos;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return -1;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                nativeTextGetCharIndexAtPos = nativeTextGetCharIndexAtPos(this.pagePtr, d, d2, d3, d4);
            } catch (Exception e) {
                Logger logger = Logger.INSTANCE;
                String str = TAG;
                Intrinsics.checkNotNullExpressionValue(str, "TAG");
                logger.e(str, e, "Exception throw from native");
                Unit unit = Unit.INSTANCE;
                return -1;
            }
        }
        return nativeTextGetCharIndexAtPos;
    }

    public final int textPageCountRects(int i, int i2) {
        if (this.isClosed || this.doc.isClosed()) {
            throw new IllegalStateException("Already closed".toString());
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                int nativeTextCountRects = nativeTextCountRects(this.pagePtr, i, i2);
                return nativeTextCountRects;
            } catch (NullPointerException e) {
                Logger logger = Logger.INSTANCE;
                String str = TAG;
                Intrinsics.checkNotNullExpressionValue(str, "TAG");
                logger.e(str, e, "mContext may be null");
                Unit unit = Unit.INSTANCE;
                return -1;
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String str2 = TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                logger2.e(str2, e2, "Exception throw from native");
                Unit unit2 = Unit.INSTANCE;
                return -1;
            }
        }
    }

    public final RectF textPageGetRect(int i) {
        RectF rectF = null;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                double[] nativeTextGetRect = nativeTextGetRect(this.pagePtr, i);
                RectF rectF2 = new RectF();
                rectF2.left = (float) nativeTextGetRect[0];
                rectF2.top = (float) nativeTextGetRect[1];
                rectF2.right = (float) nativeTextGetRect[2];
                rectF2.bottom = (float) nativeTextGetRect[3];
                rectF = rectF2;
            } catch (NullPointerException e) {
                Logger logger = Logger.INSTANCE;
                String str = TAG;
                Intrinsics.checkNotNullExpressionValue(str, "TAG");
                logger.e(str, e, "mContext may be null");
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String str2 = TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                logger2.e(str2, e2, "Exception throw from native");
            }
        }
        return rectF;
    }

    public final String textPageGetBoundedText(RectF rectF, int i) {
        RectF rectF2 = rectF;
        Intrinsics.checkNotNullParameter(rectF2, "rect");
        String str = null;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return null;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            try {
                short[] sArr = new short[(i + 1)];
                long j = this.pagePtr;
                double d = (double) rectF2.left;
                double d2 = (double) rectF2.top;
                double d3 = (double) rectF2.right;
                double d4 = (double) rectF2.bottom;
                short[] sArr2 = sArr;
                int nativeTextGetBoundedText = nativeTextGetBoundedText(j, d, d2, d3, d4, sArr) - 1;
                byte[] bArr = new byte[(nativeTextGetBoundedText * 2)];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.order(ByteOrder.LITTLE_ENDIAN);
                for (int i2 = 0; i2 < nativeTextGetBoundedText; i2++) {
                    wrap.putShort(sArr2[i2]);
                }
                Charset charset = StandardCharsets.UTF_16LE;
                Intrinsics.checkNotNullExpressionValue(charset, "UTF_16LE");
                str = new String(bArr, charset);
            } catch (NullPointerException e) {
                Logger logger = Logger.INSTANCE;
                String str2 = TAG;
                Intrinsics.checkNotNullExpressionValue(str2, "TAG");
                logger.e(str2, e, "mContext may be null");
            } catch (Exception e2) {
                Logger logger2 = Logger.INSTANCE;
                String str3 = TAG;
                Intrinsics.checkNotNullExpressionValue(str3, "TAG");
                logger2.e(str3, e2, "Exception throw from native");
            }
        }
        return str;
    }

    public final double getFontSize(int i) {
        double nativeGetFontSize;
        if (ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            nativeGetFontSize = nativeGetFontSize(this.pagePtr, i);
        }
        return nativeGetFontSize;
    }

    public void close() {
        if (!ConfigKt.handleAlreadyClosed(this.isClosed || this.doc.isClosed())) {
            synchronized (PdfiumCore.Companion.getLock()) {
                PdfDocument.PageCount pageCount = this.pageMap.get(Integer.valueOf(this.pageIndex));
                if (pageCount == null || pageCount.getCount() <= 1) {
                    this.pageMap.remove(Integer.valueOf(this.pageIndex));
                    this.isClosed = true;
                    nativeCloseTextPage(this.pagePtr);
                    Unit unit = Unit.INSTANCE;
                    return;
                }
                pageCount.setCount(pageCount.getCount() - 1);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lio/legere/pdfiumandroid/PdfTextPage$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PdfTextPage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
