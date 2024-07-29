package expo.modules.imagepicker;

import android.content.ContentResolver;
import android.net.Uri;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ImagePickerUtils.kt */
final class ImagePickerUtilsKt$copyFile$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ContentResolver $contentResolver;
    final /* synthetic */ Uri $sourceUri;
    final /* synthetic */ File $targetFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImagePickerUtilsKt$copyFile$2(File file, Uri uri, ContentResolver contentResolver) {
        super(0);
        this.$targetFile = file;
        this.$sourceUri = uri;
        this.$contentResolver = contentResolver;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x003f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0042, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0046, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r7 = this;
            java.io.File r0 = r7.$targetFile
            android.net.Uri r0 = android.net.Uri.fromFile(r0)
            android.net.Uri r1 = r7.$sourceUri
            int r0 = r1.compareTo(r0)
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            android.content.ContentResolver r0 = r7.$contentResolver     // Catch:{ FileNotFoundException -> 0x0053 }
            android.net.Uri r1 = r7.$sourceUri     // Catch:{ FileNotFoundException -> 0x0053 }
            java.io.InputStream r0 = r0.openInputStream(r1)     // Catch:{ FileNotFoundException -> 0x0053 }
            r1 = 2
            r2 = 0
            if (r0 == 0) goto L_0x0047
            java.io.Closeable r0 = (java.io.Closeable) r0     // Catch:{ FileNotFoundException -> 0x0053 }
            java.io.File r3 = r7.$targetFile     // Catch:{ FileNotFoundException -> 0x0053 }
            r4 = r0
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ all -> 0x0040 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x0040 }
            r5.<init>(r3)     // Catch:{ all -> 0x0040 }
            java.io.Closeable r5 = (java.io.Closeable) r5     // Catch:{ all -> 0x0040 }
            r3 = r5
            java.io.FileOutputStream r3 = (java.io.FileOutputStream) r3     // Catch:{ all -> 0x0039 }
            java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ all -> 0x0039 }
            r6 = 0
            kotlin.io.ByteStreamsKt.copyTo$default(r4, r3, r6, r1, r2)     // Catch:{ all -> 0x0039 }
            kotlin.io.CloseableKt.closeFinally(r5, r2)     // Catch:{ all -> 0x0040 }
            kotlin.io.CloseableKt.closeFinally(r0, r2)     // Catch:{ FileNotFoundException -> 0x0053 }
            return
        L_0x0039:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x003b }
        L_0x003b:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r5, r1)     // Catch:{ all -> 0x0040 }
            throw r2     // Catch:{ all -> 0x0040 }
        L_0x0040:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)     // Catch:{ FileNotFoundException -> 0x0053 }
            throw r2     // Catch:{ FileNotFoundException -> 0x0053 }
        L_0x0047:
            expo.modules.imagepicker.FailedToReadFileException r0 = new expo.modules.imagepicker.FailedToReadFileException     // Catch:{ FileNotFoundException -> 0x0053 }
            android.net.Uri r3 = r7.$sourceUri     // Catch:{ FileNotFoundException -> 0x0053 }
            java.io.File r3 = androidx.core.net.UriKt.toFile(r3)     // Catch:{ FileNotFoundException -> 0x0053 }
            r0.<init>(r3, r2, r1, r2)     // Catch:{ FileNotFoundException -> 0x0053 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0053 }
        L_0x0053:
            r0 = move-exception
            expo.modules.imagepicker.FailedToWriteFileException r1 = new expo.modules.imagepicker.FailedToWriteFileException
            java.io.File r2 = r7.$targetFile
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.ImagePickerUtilsKt$copyFile$2.invoke():void");
    }
}
