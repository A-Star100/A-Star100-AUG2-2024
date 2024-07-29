package io.legere.pdfiumandroid;

import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import io.legere.pdfiumandroid.util.ConfigKt;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0016\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\b\u0018\u0000 G2\u00020\u0001:\u0005FGHIJB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\rJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eJ\u0011\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0003H J\u0019\u0010\"\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H J\u0011\u0010$\u001a\u00020%2\u0006\u0010#\u001a\u00020\u0003H J\u0019\u0010&\u001a\u00020%2\u0006\u0010!\u001a\u00020\u00032\u0006\u0010'\u001a\u00020%H J\"\u0010(\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0003H ¢\u0006\u0002\u0010)J\u0011\u0010*\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u0003H J\u0011\u0010+\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u0003H J \u0010,\u001a\u0004\u0018\u00010\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0003H ¢\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\rH J!\u00100\u001a\u0002012\u0006\u0010!\u001a\u00020\u00032\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\rH J\u0019\u00104\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u0003H J!\u00106\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00032\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\rH J\u000e\u0010:\u001a\u00020;2\u0006\u0010/\u001a\u00020\rJ\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020;0\u001e2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\rJ\u0010\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020;H\u0007J\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020>0\u001e2\u0006\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\rJ&\u0010A\u001a\u00020\u00172\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001f0C2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u0003H\u0002J\u0018\u0010E\u001a\u00020\u00062\u0006\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020\rR\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0004¢\u0006\u0002\n\u0000¨\u0006K"}, d2 = {"Lio/legere/pdfiumandroid/PdfDocument;", "Ljava/io/Closeable;", "mNativeDocPtr", "", "(J)V", "<set-?>", "", "isClosed", "()Z", "getMNativeDocPtr", "()J", "pageMap", "", "", "Lio/legere/pdfiumandroid/PdfDocument$PageCount;", "parcelFileDescriptor", "Landroid/os/ParcelFileDescriptor;", "getParcelFileDescriptor", "()Landroid/os/ParcelFileDescriptor;", "setParcelFileDescriptor", "(Landroid/os/ParcelFileDescriptor;)V", "textPageMap", "close", "", "getDocumentMeta", "Lio/legere/pdfiumandroid/PdfDocument$Meta;", "getPageCharCounts", "", "getPageCount", "getTableOfContents", "", "Lio/legere/pdfiumandroid/PdfDocument$Bookmark;", "nativeCloseDocument", "docPtr", "nativeGetBookmarkDestIndex", "bookmarkPtr", "nativeGetBookmarkTitle", "", "nativeGetDocumentMetaText", "tag", "nativeGetFirstChildBookmark", "(JLjava/lang/Long;)Ljava/lang/Long;", "nativeGetPageCharCounts", "nativeGetPageCount", "nativeGetSiblingBookmark", "(JJ)Ljava/lang/Long;", "nativeLoadPage", "pageIndex", "nativeLoadPages", "", "fromIndex", "toIndex", "nativeLoadTextPage", "pagePtr", "nativeSaveAsCopy", "callback", "Lio/legere/pdfiumandroid/PdfWriteCallback;", "flags", "openPage", "Lio/legere/pdfiumandroid/PdfPage;", "openPages", "openTextPage", "Lio/legere/pdfiumandroid/PdfTextPage;", "page", "openTextPages", "recursiveGetBookmark", "tree", "", "level", "saveAsCopy", "Bookmark", "Companion", "Link", "Meta", "PageCount", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PdfDocument.kt */
public final class PdfDocument implements Closeable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int FPDF_INCREMENTAL = 1;
    public static final int FPDF_NO_INCREMENTAL = 2;
    public static final int FPDF_REMOVE_SECURITY = 3;
    private static final String TAG = PdfDocument.class.getName();
    private boolean isClosed;
    private final long mNativeDocPtr;
    private final Map<Integer, PageCount> pageMap = new LinkedHashMap();
    private ParcelFileDescriptor parcelFileDescriptor;
    private final Map<Integer, PageCount> textPageMap = new LinkedHashMap();

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lio/legere/pdfiumandroid/PdfDocument$Bookmark;", "", "()V", "children", "", "getChildren", "()Ljava/util/List;", "mNativePtr", "", "getMNativePtr", "()J", "setMNativePtr", "(J)V", "pageIdx", "getPageIdx", "setPageIdx", "title", "", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PdfDocument.kt */
    public static final class Bookmark {
        private final List<Bookmark> children = new ArrayList();
        private long mNativePtr;
        private long pageIdx;
        private String title;

        public final List<Bookmark> getChildren() {
            return this.children;
        }

        public final long getMNativePtr() {
            return this.mNativePtr;
        }

        public final long getPageIdx() {
            return this.pageIdx;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setMNativePtr(long j) {
            this.mNativePtr = j;
        }

        public final void setPageIdx(long j) {
            this.pageIdx = j;
        }

        public final void setTitle(String str) {
            this.title = str;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\b¨\u0006\u001e"}, d2 = {"Lio/legere/pdfiumandroid/PdfDocument$Meta;", "", "()V", "author", "", "getAuthor", "()Ljava/lang/String;", "setAuthor", "(Ljava/lang/String;)V", "creationDate", "getCreationDate", "setCreationDate", "creator", "getCreator", "setCreator", "keywords", "getKeywords", "setKeywords", "modDate", "getModDate", "setModDate", "producer", "getProducer", "setProducer", "subject", "getSubject", "setSubject", "title", "getTitle", "setTitle", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PdfDocument.kt */
    public static final class Meta {
        private String author;
        private String creationDate;
        private String creator;
        private String keywords;
        private String modDate;
        private String producer;
        private String subject;
        private String title;

        public final String getAuthor() {
            return this.author;
        }

        public final String getCreationDate() {
            return this.creationDate;
        }

        public final String getCreator() {
            return this.creator;
        }

        public final String getKeywords() {
            return this.keywords;
        }

        public final String getModDate() {
            return this.modDate;
        }

        public final String getProducer() {
            return this.producer;
        }

        public final String getSubject() {
            return this.subject;
        }

        public final String getTitle() {
            return this.title;
        }

        public final void setAuthor(String str) {
            this.author = str;
        }

        public final void setCreationDate(String str) {
            this.creationDate = str;
        }

        public final void setCreator(String str) {
            this.creator = str;
        }

        public final void setKeywords(String str) {
            this.keywords = str;
        }

        public final void setModDate(String str) {
            this.modDate = str;
        }

        public final void setProducer(String str) {
            this.producer = str;
        }

        public final void setSubject(String str) {
            this.subject = str;
        }

        public final void setTitle(String str) {
            this.title = str;
        }
    }

    private final native void nativeCloseDocument(long j);

    private final native long nativeGetBookmarkDestIndex(long j, long j2);

    private final native String nativeGetBookmarkTitle(long j);

    private final native String nativeGetDocumentMetaText(long j, String str);

    private final native Long nativeGetFirstChildBookmark(long j, Long l);

    private final native int[] nativeGetPageCharCounts(long j);

    private final native int nativeGetPageCount(long j);

    private final native Long nativeGetSiblingBookmark(long j, long j2);

    private final native long nativeLoadPage(long j, int i);

    private final native long[] nativeLoadPages(long j, int i, int i2);

    private final native long nativeLoadTextPage(long j, long j2);

    private final native boolean nativeSaveAsCopy(long j, PdfWriteCallback pdfWriteCallback, int i);

    public final long getMNativeDocPtr() {
        return this.mNativeDocPtr;
    }

    public final ParcelFileDescriptor getParcelFileDescriptor() {
        return this.parcelFileDescriptor;
    }

    public final boolean isClosed() {
        return this.isClosed;
    }

    public final void setParcelFileDescriptor(ParcelFileDescriptor parcelFileDescriptor2) {
        this.parcelFileDescriptor = parcelFileDescriptor2;
    }

    public PdfDocument(long j) {
        this.mNativeDocPtr = j;
    }

    public final int getPageCount() {
        int nativeGetPageCount;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return 0;
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            nativeGetPageCount = nativeGetPageCount(this.mNativeDocPtr);
        }
        return nativeGetPageCount;
    }

    public final int[] getPageCharCounts() {
        int[] nativeGetPageCharCounts;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return new int[0];
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            nativeGetPageCharCounts = nativeGetPageCharCounts(this.mNativeDocPtr);
        }
        return nativeGetPageCharCounts;
    }

    public final PdfPage openPage(int i) {
        PageCount pageCount;
        if (!this.isClosed) {
            synchronized (PdfiumCore.Companion.getLock()) {
                if (!this.pageMap.containsKey(Integer.valueOf(i)) || (pageCount = this.pageMap.get(Integer.valueOf(i))) == null) {
                    long nativeLoadPage = nativeLoadPage(this.mNativeDocPtr, i);
                    this.pageMap.put(Integer.valueOf(i), new PageCount(nativeLoadPage, 1));
                    PdfPage pdfPage = new PdfPage(this, i, nativeLoadPage, this.pageMap);
                    return pdfPage;
                }
                pageCount.setCount(pageCount.getCount() + 1);
                PdfPage pdfPage2 = new PdfPage(this, i, pageCount.getPagePtr(), this.pageMap);
                return pdfPage2;
            }
        }
        throw new IllegalStateException("Already closed".toString());
    }

    public final List<PdfPage> openPages(int i, int i2) {
        List<PdfPage> list;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return CollectionsKt.emptyList();
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            long[] nativeLoadPages = nativeLoadPages(this.mNativeDocPtr, i, i2);
            for (long j : nativeLoadPages) {
                if (i > i2) {
                    break;
                }
                i++;
            }
            Collection arrayList = new ArrayList(nativeLoadPages.length);
            for (long pdfPage : nativeLoadPages) {
                arrayList.add(new PdfPage(this, i, pdfPage, this.pageMap));
            }
            list = (List) arrayList;
        }
        return list;
    }

    public final Meta getDocumentMeta() {
        Meta meta;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return new Meta();
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            meta = new Meta();
            meta.setTitle(nativeGetDocumentMetaText(this.mNativeDocPtr, "Title"));
            meta.setAuthor(nativeGetDocumentMetaText(this.mNativeDocPtr, "Author"));
            meta.setSubject(nativeGetDocumentMetaText(this.mNativeDocPtr, "Subject"));
            meta.setKeywords(nativeGetDocumentMetaText(this.mNativeDocPtr, "Keywords"));
            meta.setCreator(nativeGetDocumentMetaText(this.mNativeDocPtr, "Creator"));
            meta.setProducer(nativeGetDocumentMetaText(this.mNativeDocPtr, "Producer"));
            meta.setCreationDate(nativeGetDocumentMetaText(this.mNativeDocPtr, "CreationDate"));
            meta.setModDate(nativeGetDocumentMetaText(this.mNativeDocPtr, "ModDate"));
        }
        return meta;
    }

    private final void recursiveGetBookmark(List<Bookmark> list, long j, long j2) {
        long j3;
        long j4 = j;
        if (!ConfigKt.handleAlreadyClosed(this.isClosed)) {
            Bookmark bookmark = new Bookmark();
            bookmark.setMNativePtr(j4);
            bookmark.setTitle(nativeGetBookmarkTitle(j4));
            bookmark.setPageIdx(nativeGetBookmarkDestIndex(this.mNativeDocPtr, j4));
            List<Bookmark> list2 = list;
            list.add(bookmark);
            Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(this.mNativeDocPtr, Long.valueOf(j));
            if (nativeGetFirstChildBookmark == null || j2 >= 16) {
                j3 = j2;
            } else {
                recursiveGetBookmark(bookmark.getChildren(), nativeGetFirstChildBookmark.longValue(), j2);
                j3 = j2 + 1;
            }
            Long nativeGetSiblingBookmark = nativeGetSiblingBookmark(this.mNativeDocPtr, j4);
            if (nativeGetSiblingBookmark != null && j3 < 16) {
                recursiveGetBookmark(list, nativeGetSiblingBookmark.longValue(), j3);
            }
        }
    }

    public final List<Bookmark> getTableOfContents() {
        List<Bookmark> arrayList;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return CollectionsKt.emptyList();
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            arrayList = new ArrayList<>();
            Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(this.mNativeDocPtr, (Long) null);
            if (nativeGetFirstChildBookmark != null) {
                recursiveGetBookmark(arrayList, nativeGetFirstChildBookmark.longValue(), 1);
            }
        }
        return arrayList;
    }

    @Deprecated(message = "Use PdfPage.openTextPage instead", replaceWith = @ReplaceWith(expression = "page.openTextPage()", imports = {}))
    public final PdfTextPage openTextPage(PdfPage pdfPage) {
        PageCount pageCount;
        Intrinsics.checkNotNullParameter(pdfPage, "page");
        if (!this.isClosed) {
            synchronized (PdfiumCore.Companion.getLock()) {
                if (!this.textPageMap.containsKey(Integer.valueOf(pdfPage.getPageIndex())) || (pageCount = this.textPageMap.get(Integer.valueOf(pdfPage.getPageIndex()))) == null) {
                    long nativeLoadTextPage = nativeLoadTextPage(this.mNativeDocPtr, pdfPage.getPagePtr());
                    this.textPageMap.put(Integer.valueOf(pdfPage.getPageIndex()), new PageCount(nativeLoadTextPage, 1));
                    PdfTextPage pdfTextPage = new PdfTextPage(this, pdfPage.getPageIndex(), nativeLoadTextPage, this.textPageMap);
                    return pdfTextPage;
                }
                pageCount.setCount(pageCount.getCount() + 1);
                PdfTextPage pdfTextPage2 = new PdfTextPage(this, pdfPage.getPageIndex(), pageCount.getPagePtr(), this.textPageMap);
                return pdfTextPage2;
            }
        }
        throw new IllegalStateException("Already closed".toString());
    }

    public final List<PdfTextPage> openTextPages(int i, int i2) {
        List<PdfTextPage> list;
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return CollectionsKt.emptyList();
        }
        synchronized (PdfiumCore.Companion.getLock()) {
            long[] nativeLoadPages = nativeLoadPages(this.mNativeDocPtr, i, i2);
            Collection arrayList = new ArrayList(nativeLoadPages.length);
            int length = nativeLoadPages.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length) {
                arrayList.add(new PdfTextPage(this, i + i4, nativeLoadPages[i3], this.textPageMap));
                i3++;
                i4++;
            }
            list = (List) arrayList;
        }
        return list;
    }

    public static /* synthetic */ boolean saveAsCopy$default(PdfDocument pdfDocument, PdfWriteCallback pdfWriteCallback, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return pdfDocument.saveAsCopy(pdfWriteCallback, i);
    }

    public final boolean saveAsCopy(PdfWriteCallback pdfWriteCallback, int i) {
        Intrinsics.checkNotNullParameter(pdfWriteCallback, "callback");
        if (ConfigKt.handleAlreadyClosed(this.isClosed)) {
            return false;
        }
        return nativeSaveAsCopy(this.mNativeDocPtr, pdfWriteCallback, i);
    }

    public void close() {
        if (!ConfigKt.handleAlreadyClosed(this.isClosed)) {
            Logger logger = Logger.INSTANCE;
            String str = TAG;
            Intrinsics.checkNotNullExpressionValue(str, "TAG");
            logger.d(str, "PdfDocument.close");
            synchronized (PdfiumCore.Companion.getLock()) {
                this.isClosed = true;
                nativeCloseDocument(this.mNativeDocPtr);
                ParcelFileDescriptor parcelFileDescriptor2 = this.parcelFileDescriptor;
                if (parcelFileDescriptor2 != null) {
                    parcelFileDescriptor2.close();
                }
                this.parcelFileDescriptor = null;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/legere/pdfiumandroid/PdfDocument$Link;", "", "bounds", "Landroid/graphics/RectF;", "destPageIdx", "", "uri", "", "(Landroid/graphics/RectF;Ljava/lang/Integer;Ljava/lang/String;)V", "getBounds", "()Landroid/graphics/RectF;", "getDestPageIdx", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUri", "()Ljava/lang/String;", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PdfDocument.kt */
    public static final class Link {
        private final RectF bounds;
        private final Integer destPageIdx;
        private final String uri;

        public final RectF getBounds() {
            return this.bounds;
        }

        public final Integer getDestPageIdx() {
            return this.destPageIdx;
        }

        public final String getUri() {
            return this.uri;
        }

        public Link(RectF rectF, Integer num, String str) {
            Intrinsics.checkNotNullParameter(rectF, "bounds");
            this.bounds = rectF;
            this.destPageIdx = num;
            this.uri = str;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lio/legere/pdfiumandroid/PdfDocument$PageCount;", "", "pagePtr", "", "count", "", "(JI)V", "getCount", "()I", "setCount", "(I)V", "getPagePtr", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PdfDocument.kt */
    public static final class PageCount {
        private int count;
        private final long pagePtr;

        public static /* synthetic */ PageCount copy$default(PageCount pageCount, long j, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                j = pageCount.pagePtr;
            }
            if ((i2 & 2) != 0) {
                i = pageCount.count;
            }
            return pageCount.copy(j, i);
        }

        public final long component1() {
            return this.pagePtr;
        }

        public final int component2() {
            return this.count;
        }

        public final PageCount copy(long j, int i) {
            return new PageCount(j, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PageCount)) {
                return false;
            }
            PageCount pageCount = (PageCount) obj;
            return this.pagePtr == pageCount.pagePtr && this.count == pageCount.count;
        }

        public final int getCount() {
            return this.count;
        }

        public final long getPagePtr() {
            return this.pagePtr;
        }

        public int hashCode() {
            return (UByte$$ExternalSyntheticBackport0.m(this.pagePtr) * 31) + this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        public String toString() {
            return "PageCount(pagePtr=" + this.pagePtr + ", count=" + this.count + ')';
        }

        public PageCount(long j, int i) {
            this.pagePtr = j;
            this.count = i;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lio/legere/pdfiumandroid/PdfDocument$Companion;", "", "()V", "FPDF_INCREMENTAL", "", "FPDF_NO_INCREMENTAL", "FPDF_REMOVE_SECURITY", "TAG", "", "kotlin.jvm.PlatformType", "pdfiumandroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: PdfDocument.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
