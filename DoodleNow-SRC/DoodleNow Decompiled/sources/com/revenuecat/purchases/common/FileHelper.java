package com.revenuecat.purchases.common;

import android.content.Context;
import com.revenuecat.purchases.utils.FileExtensionsKt;
import java.io.File;
import java.util.stream.Stream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0010H\u0002J$\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00060\u0014H\u0002J*\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0018\u0012\u0004\u0012\u00020\u00060\u0014H\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/common/FileHelper;", "", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appendToFile", "", "filePath", "", "contentToAppend", "deleteFile", "", "fileIsEmpty", "fileSizeInKB", "", "getFileInFilesDir", "Ljava/io/File;", "getFilesDir", "openBufferedReader", "contentBlock", "Lkotlin/Function1;", "Ljava/io/BufferedReader;", "readFilePerLines", "streamBlock", "Ljava/util/stream/Stream;", "removeFirstLinesFromFile", "numberOfLinesToRemove", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FileHelper.kt */
public final class FileHelper {
    private final Context applicationContext;

    public FileHelper(Context context) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        this.applicationContext = context;
    }

    public final double fileSizeInKB(String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        return FileExtensionsKt.getSizeInKB(getFileInFilesDir(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void appendToFile(java.lang.String r3, java.lang.String r4) {
        /*
            r2 = this;
            java.lang.String r0 = "filePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "contentToAppend"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.io.File r3 = r2.getFileInFilesDir(r3)
            java.io.File r0 = r3.getParentFile()
            if (r0 == 0) goto L_0x0017
            r0.mkdirs()
        L_0x0017:
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r1 = 1
            r0.<init>(r3, r1)
            r3 = r0
            java.io.Closeable r3 = (java.io.Closeable) r3
            r1 = r3
            java.io.FileOutputStream r1 = (java.io.FileOutputStream) r1     // Catch:{ all -> 0x0038 }
            java.nio.charset.Charset r1 = kotlin.text.Charsets.UTF_8     // Catch:{ all -> 0x0038 }
            byte[] r4 = r4.getBytes(r1)     // Catch:{ all -> 0x0038 }
            java.lang.String r1 = "this as java.lang.String).getBytes(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)     // Catch:{ all -> 0x0038 }
            r0.write(r4)     // Catch:{ all -> 0x0038 }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0038 }
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            return
        L_0x0038:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x003a }
        L_0x003a:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.FileHelper.appendToFile(java.lang.String, java.lang.String):void");
    }

    public final boolean deleteFile(String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        return getFileInFilesDir(str).delete();
    }

    public final void readFilePerLines(String str, Function1<? super Stream<String>, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        Intrinsics.checkNotNullParameter(function1, "streamBlock");
        openBufferedReader(str, new FileHelper$readFilePerLines$1(function1));
    }

    public final void removeFirstLinesFromFile(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        StringBuilder sb = new StringBuilder();
        readFilePerLines(str, new FileHelper$removeFirstLinesFromFile$1(i, sb));
        deleteFile(str);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "textToAppend.toString()");
        appendToFile(str, sb2);
    }

    public final boolean fileIsEmpty(String str) {
        Intrinsics.checkNotNullParameter(str, "filePath");
        File fileInFilesDir = getFileInFilesDir(str);
        return !fileInFilesDir.exists() || fileInFilesDir.length() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003c, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0040, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0043, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0047, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x004b, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x004e, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void openBufferedReader(java.lang.String r4, kotlin.jvm.functions.Function1<? super java.io.BufferedReader, kotlin.Unit> r5) {
        /*
            r3 = this;
            java.io.File r4 = r3.getFileInFilesDir(r4)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r4)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r4 = r0
            java.io.FileInputStream r4 = (java.io.FileInputStream) r4     // Catch:{ all -> 0x0048 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ all -> 0x0048 }
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ all -> 0x0048 }
            r1.<init>(r4)     // Catch:{ all -> 0x0048 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ all -> 0x0048 }
            r4 = r1
            java.io.InputStreamReader r4 = (java.io.InputStreamReader) r4     // Catch:{ all -> 0x0041 }
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ all -> 0x0041 }
            java.io.Reader r4 = (java.io.Reader) r4     // Catch:{ all -> 0x0041 }
            r2.<init>(r4)     // Catch:{ all -> 0x0041 }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x0041 }
            r4 = r2
            java.io.BufferedReader r4 = (java.io.BufferedReader) r4     // Catch:{ all -> 0x003a }
            r5.invoke(r4)     // Catch:{ all -> 0x003a }
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x003a }
            r4 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ all -> 0x0041 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0041 }
            kotlin.io.CloseableKt.closeFinally(r1, r4)     // Catch:{ all -> 0x0048 }
            kotlin.Unit r5 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0048 }
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            return
        L_0x003a:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x003c }
        L_0x003c:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r4)     // Catch:{ all -> 0x0041 }
            throw r5     // Catch:{ all -> 0x0041 }
        L_0x0041:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r4)     // Catch:{ all -> 0x0048 }
            throw r5     // Catch:{ all -> 0x0048 }
        L_0x0048:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x004a }
        L_0x004a:
            r5 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.FileHelper.openBufferedReader(java.lang.String, kotlin.jvm.functions.Function1):void");
    }

    private final File getFileInFilesDir(String str) {
        return new File(getFilesDir(), str);
    }

    private final File getFilesDir() {
        File filesDir = this.applicationContext.getFilesDir();
        Intrinsics.checkNotNullExpressionValue(filesDir, "applicationContext.filesDir");
        return filesDir;
    }
}
