package expo.modules.imagepicker.exporters;

import android.content.ContentResolver;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ImageExporter.kt */
final class ImageExportResult$exif$2 extends Lambda implements Function0<Bundle> {
    final /* synthetic */ ContentResolver $contentResolver;
    final /* synthetic */ ImageExportResult this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageExportResult$exif$2(ContentResolver contentResolver, ImageExportResult imageExportResult) {
        super(0);
        this.$contentResolver = contentResolver;
        this.this$0 = imageExportResult;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00de, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00df, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00e2, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle invoke() {
        /*
            r12 = this;
            android.content.ContentResolver r0 = r12.$contentResolver
            expo.modules.imagepicker.exporters.ImageExportResult r1 = r12.this$0
            java.io.File r1 = r1.imageFile
            android.net.Uri r1 = android.net.Uri.fromFile(r1)
            java.io.InputStream r0 = r0.openInputStream(r1)
            r1 = 0
            if (r0 == 0) goto L_0x00e3
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = r0
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x00dc }
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ all -> 0x00dc }
            r3.<init>()     // Catch:{ all -> 0x00dc }
            androidx.exifinterface.media.ExifInterface r4 = new androidx.exifinterface.media.ExifInterface     // Catch:{ all -> 0x00dc }
            r4.<init>((java.io.InputStream) r2)     // Catch:{ all -> 0x00dc }
            expo.modules.imagepicker.ImagePickerConstants r2 = expo.modules.imagepicker.ImagePickerConstants.INSTANCE     // Catch:{ all -> 0x00dc }
            java.lang.Iterable r2 = r2.getEXIF_TAGS()     // Catch:{ all -> 0x00dc }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00dc }
            r5.<init>()     // Catch:{ all -> 0x00dc }
            java.util.Collection r5 = (java.util.Collection) r5     // Catch:{ all -> 0x00dc }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x00dc }
        L_0x0033:
            boolean r6 = r2.hasNext()     // Catch:{ all -> 0x00dc }
            if (r6 == 0) goto L_0x0050
            java.lang.Object r6 = r2.next()     // Catch:{ all -> 0x00dc }
            r7 = r6
            kotlin.Pair r7 = (kotlin.Pair) r7     // Catch:{ all -> 0x00dc }
            java.lang.Object r7 = r7.component2()     // Catch:{ all -> 0x00dc }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x00dc }
            java.lang.String r7 = r4.getAttribute(r7)     // Catch:{ all -> 0x00dc }
            if (r7 == 0) goto L_0x0033
            r5.add(r6)     // Catch:{ all -> 0x00dc }
            goto L_0x0033
        L_0x0050:
            java.util.List r5 = (java.util.List) r5     // Catch:{ all -> 0x00dc }
            java.lang.Iterable r5 = (java.lang.Iterable) r5     // Catch:{ all -> 0x00dc }
            java.util.Iterator r2 = r5.iterator()     // Catch:{ all -> 0x00dc }
        L_0x0058:
            boolean r5 = r2.hasNext()     // Catch:{ all -> 0x00dc }
            r6 = 0
            r8 = 0
            if (r5 == 0) goto L_0x00ba
            java.lang.Object r5 = r2.next()     // Catch:{ all -> 0x00dc }
            kotlin.Pair r5 = (kotlin.Pair) r5     // Catch:{ all -> 0x00dc }
            java.lang.Object r9 = r5.component1()     // Catch:{ all -> 0x00dc }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x00dc }
            java.lang.Object r5 = r5.component2()     // Catch:{ all -> 0x00dc }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ all -> 0x00dc }
            int r10 = r9.hashCode()     // Catch:{ all -> 0x00dc }
            r11 = -1325958191(0xffffffffb0f77bd1, float:-1.8006806E-9)
            if (r10 == r11) goto L_0x00a9
            r6 = -891985903(0xffffffffcad56011, float:-6991880.5)
            if (r10 == r6) goto L_0x0098
            r6 = 104431(0x197ef, float:1.46339E-40)
            if (r10 == r6) goto L_0x0087
            goto L_0x0058
        L_0x0087:
            java.lang.String r6 = "int"
            boolean r6 = r9.equals(r6)     // Catch:{ all -> 0x00dc }
            if (r6 != 0) goto L_0x0090
            goto L_0x0058
        L_0x0090:
            int r6 = r4.getAttributeInt(r5, r8)     // Catch:{ all -> 0x00dc }
            r3.putInt(r5, r6)     // Catch:{ all -> 0x00dc }
            goto L_0x0058
        L_0x0098:
            java.lang.String r6 = "string"
            boolean r6 = r9.equals(r6)     // Catch:{ all -> 0x00dc }
            if (r6 != 0) goto L_0x00a1
            goto L_0x0058
        L_0x00a1:
            java.lang.String r6 = r4.getAttribute(r5)     // Catch:{ all -> 0x00dc }
            r3.putString(r5, r6)     // Catch:{ all -> 0x00dc }
            goto L_0x0058
        L_0x00a9:
            java.lang.String r8 = "double"
            boolean r8 = r9.equals(r8)     // Catch:{ all -> 0x00dc }
            if (r8 != 0) goto L_0x00b2
            goto L_0x0058
        L_0x00b2:
            double r6 = r4.getAttributeDouble(r5, r6)     // Catch:{ all -> 0x00dc }
            r3.putDouble(r5, r6)     // Catch:{ all -> 0x00dc }
            goto L_0x0058
        L_0x00ba:
            double[] r2 = r4.getLatLong()     // Catch:{ all -> 0x00dc }
            if (r2 == 0) goto L_0x00d8
            java.lang.String r5 = "GPSLatitude"
            r8 = r2[r8]     // Catch:{ all -> 0x00dc }
            r3.putDouble(r5, r8)     // Catch:{ all -> 0x00dc }
            java.lang.String r5 = "GPSLongitude"
            r8 = 1
            r8 = r2[r8]     // Catch:{ all -> 0x00dc }
            r3.putDouble(r5, r8)     // Catch:{ all -> 0x00dc }
            java.lang.String r2 = "GPSAltitude"
            double r4 = r4.getAltitude(r6)     // Catch:{ all -> 0x00dc }
            r3.putDouble(r2, r4)     // Catch:{ all -> 0x00dc }
        L_0x00d8:
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r3
        L_0x00dc:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x00de }
        L_0x00de:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        L_0x00e3:
            expo.modules.imagepicker.FailedToReadFileException r0 = new expo.modules.imagepicker.FailedToReadFileException
            expo.modules.imagepicker.exporters.ImageExportResult r2 = r12.this$0
            java.io.File r2 = r2.imageFile
            r3 = 2
            r0.<init>(r2, r1, r3, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.imagepicker.exporters.ImageExportResult$exif$2.invoke():android.os.Bundle");
    }
}
