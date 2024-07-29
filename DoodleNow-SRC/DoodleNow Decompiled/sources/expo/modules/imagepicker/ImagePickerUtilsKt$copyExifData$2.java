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
final class ImagePickerUtilsKt$copyExifData$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ContentResolver $contentResolver;
    final /* synthetic */ Uri $sourceUri;
    final /* synthetic */ File $targetFile;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImagePickerUtilsKt$copyExifData$2(File file, Uri uri, ContentResolver contentResolver) {
        super(0);
        this.$targetFile = file;
        this.$sourceUri = uri;
        this.$contentResolver = contentResolver;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0102, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r10 = this;
            java.io.File r0 = r10.$targetFile
            android.net.Uri r0 = android.net.Uri.fromFile(r0)
            android.net.Uri r1 = r10.$sourceUri
            int r0 = r1.compareTo(r0)
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            java.lang.String r0 = "PixelYDimension"
            java.lang.String r1 = "Orientation"
            java.lang.String r2 = "ImageLength"
            java.lang.String r3 = "ImageWidth"
            java.lang.String r4 = "PixelXDimension"
            java.lang.String[] r0 = new java.lang.String[]{r2, r3, r4, r0, r1}
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            android.content.ContentResolver r1 = r10.$contentResolver     // Catch:{ FileNotFoundException -> 0x0118 }
            android.net.Uri r2 = r10.$sourceUri     // Catch:{ FileNotFoundException -> 0x0118 }
            java.io.InputStream r1 = r1.openInputStream(r2)     // Catch:{ FileNotFoundException -> 0x0118 }
            r2 = 0
            if (r1 == 0) goto L_0x0107
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ FileNotFoundException -> 0x0118 }
            java.io.File r3 = r10.$targetFile     // Catch:{ FileNotFoundException -> 0x0118 }
            r4 = r1
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ all -> 0x0100 }
            androidx.exifinterface.media.ExifInterface r5 = new androidx.exifinterface.media.ExifInterface     // Catch:{ all -> 0x0100 }
            r5.<init>((java.io.InputStream) r4)     // Catch:{ all -> 0x0100 }
            androidx.exifinterface.media.ExifInterface r4 = new androidx.exifinterface.media.ExifInterface     // Catch:{ all -> 0x0100 }
            r4.<init>((java.io.File) r3)     // Catch:{ all -> 0x0100 }
            expo.modules.imagepicker.ImagePickerConstants r6 = expo.modules.imagepicker.ImagePickerConstants.INSTANCE     // Catch:{ all -> 0x0100 }
            java.lang.Iterable r6 = r6.getEXIF_TAGS()     // Catch:{ all -> 0x0100 }
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ all -> 0x0100 }
            r7.<init>()     // Catch:{ all -> 0x0100 }
            java.util.Collection r7 = (java.util.Collection) r7     // Catch:{ all -> 0x0100 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0100 }
        L_0x004e:
            boolean r8 = r6.hasNext()     // Catch:{ all -> 0x0100 }
            if (r8 == 0) goto L_0x006d
            java.lang.Object r8 = r6.next()     // Catch:{ all -> 0x0100 }
            r9 = r8
            kotlin.Pair r9 = (kotlin.Pair) r9     // Catch:{ all -> 0x0100 }
            java.lang.Object r9 = r9.component2()     // Catch:{ all -> 0x0100 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0100 }
            boolean r9 = r0.contains(r9)     // Catch:{ all -> 0x0100 }
            r9 = r9 ^ 1
            if (r9 == 0) goto L_0x004e
            r7.add(r8)     // Catch:{ all -> 0x0100 }
            goto L_0x004e
        L_0x006d:
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x0100 }
            java.lang.Iterable r7 = (java.lang.Iterable) r7     // Catch:{ all -> 0x0100 }
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0100 }
            r6 = 10
            int r6 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r6)     // Catch:{ all -> 0x0100 }
            r0.<init>(r6)     // Catch:{ all -> 0x0100 }
            java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ all -> 0x0100 }
            java.util.Iterator r6 = r7.iterator()     // Catch:{ all -> 0x0100 }
        L_0x0082:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0100 }
            if (r7 == 0) goto L_0x00a0
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0100 }
            kotlin.Pair r7 = (kotlin.Pair) r7     // Catch:{ all -> 0x0100 }
            java.lang.Object r7 = r7.component2()     // Catch:{ all -> 0x0100 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0100 }
            java.lang.String r8 = r5.getAttribute(r7)     // Catch:{ all -> 0x0100 }
            kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r8)     // Catch:{ all -> 0x0100 }
            r0.add(r7)     // Catch:{ all -> 0x0100 }
            goto L_0x0082
        L_0x00a0:
            java.util.List r0 = (java.util.List) r0     // Catch:{ all -> 0x0100 }
            java.lang.Iterable r0 = (java.lang.Iterable) r0     // Catch:{ all -> 0x0100 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x0100 }
            r5.<init>()     // Catch:{ all -> 0x0100 }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x0100 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x0100 }
        L_0x00af:
            boolean r6 = r0.hasNext()     // Catch:{ all -> 0x0100 }
            if (r6 == 0) goto L_0x00c8
            java.lang.Object r6 = r0.next()     // Catch:{ all -> 0x0100 }
            r7 = r6
            kotlin.Pair r7 = (kotlin.Pair) r7     // Catch:{ all -> 0x0100 }
            java.lang.Object r7 = r7.component2()     // Catch:{ all -> 0x0100 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0100 }
            if (r7 == 0) goto L_0x00af
            r5.add(r6)     // Catch:{ all -> 0x0100 }
            goto L_0x00af
        L_0x00c8:
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x0100 }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x0100 }
            java.util.Iterator r0 = r5.iterator()     // Catch:{ all -> 0x0100 }
        L_0x00d0:
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x0100 }
            if (r5 == 0) goto L_0x00ec
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x0100 }
            kotlin.Pair r5 = (kotlin.Pair) r5     // Catch:{ all -> 0x0100 }
            java.lang.Object r6 = r5.component1()     // Catch:{ all -> 0x0100 }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ all -> 0x0100 }
            java.lang.Object r5 = r5.component2()     // Catch:{ all -> 0x0100 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x0100 }
            r4.setAttribute(r6, r5)     // Catch:{ all -> 0x0100 }
            goto L_0x00d0
        L_0x00ec:
            r4.saveAttributes()     // Catch:{ IOException -> 0x00f7 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0100 }
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ FileNotFoundException -> 0x0118 }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ FileNotFoundException -> 0x0118 }
            goto L_0x0108
        L_0x00f7:
            r0 = move-exception
            expo.modules.imagepicker.FailedToWriteExifDataToFileException r2 = new expo.modules.imagepicker.FailedToWriteExifDataToFileException     // Catch:{ all -> 0x0100 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ all -> 0x0100 }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x0100 }
            throw r2     // Catch:{ all -> 0x0100 }
        L_0x0100:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0102 }
        L_0x0102:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ FileNotFoundException -> 0x0118 }
            throw r2     // Catch:{ FileNotFoundException -> 0x0118 }
        L_0x0107:
            r0 = r2
        L_0x0108:
            if (r0 == 0) goto L_0x010b
            return
        L_0x010b:
            expo.modules.imagepicker.FailedToReadFileException r0 = new expo.modules.imagepicker.FailedToReadFileException     // Catch:{ FileNotFoundException -> 0x0118 }
            android.net.Uri r1 = r10.$sourceUri     // Catch:{ FileNotFoundException -> 0x0118 }
            java.io.File r1 = androidx.core.net.UriKt.toFile(r1)     // Catch:{ FileNotFoundException -> 0x0118 }
            r3 = 2
            r0.<init>(r1, r2, r3, r2)     // Catch:{ FileNotFoundException -> 0x0118 }
            throw r0     // Catch:{ FileNotFoundException -> 0x0118 }
        L_0x0118:
            r0 = move-exception
            expo.modules.imagepicker.FailedToWriteFileException r1 = new expo.modules.imagepicker.FailedToWriteFileException
            java.io.File r2 = r10.$targetFile
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.ImagePickerUtilsKt$copyExifData$2.invoke():void");
    }
}
