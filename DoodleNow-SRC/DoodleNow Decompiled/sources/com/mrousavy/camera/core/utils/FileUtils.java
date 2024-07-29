package com.mrousavy.camera.core.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.Size;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/mrousavy/camera/core/utils/FileUtils;", "", "()V", "Companion", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FileUtils.kt */
public final class FileUtils {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012¨\u0006\u0013"}, d2 = {"Lcom/mrousavy/camera/core/utils/FileUtils$Companion;", "", "()V", "createTempFile", "Ljava/io/File;", "context", "Landroid/content/Context;", "extension", "", "getImageSize", "Landroid/util/Size;", "imagePath", "writeBitmapTofile", "", "bitmap", "Landroid/graphics/Bitmap;", "file", "quality", "", "react-native-vision-camera_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: FileUtils.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final File createTempFile(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "extension");
            File createTempFile = File.createTempFile("mrousavy-", str, context.getCacheDir());
            createTempFile.deleteOnExit();
            Intrinsics.checkNotNullExpressionValue(createTempFile, "also(...)");
            return createTempFile;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
            throw r4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0022, code lost:
            r4 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
            kotlin.io.CloseableKt.closeFinally(r0, r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void writeBitmapTofile(android.graphics.Bitmap r3, java.io.File r4, int r5) {
            /*
                r2 = this;
                java.lang.String r0 = "bitmap"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
                java.lang.String r0 = "file"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
                java.io.FileOutputStream r0 = new java.io.FileOutputStream
                r0.<init>(r4)
                java.io.Closeable r0 = (java.io.Closeable) r0
                r4 = r0
                java.io.FileOutputStream r4 = (java.io.FileOutputStream) r4     // Catch:{ all -> 0x0020 }
                android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0020 }
                java.io.OutputStream r4 = (java.io.OutputStream) r4     // Catch:{ all -> 0x0020 }
                r3.compress(r1, r5, r4)     // Catch:{ all -> 0x0020 }
                r3 = 0
                kotlin.io.CloseableKt.closeFinally(r0, r3)
                return
            L_0x0020:
                r3 = move-exception
                throw r3     // Catch:{ all -> 0x0022 }
            L_0x0022:
                r4 = move-exception
                kotlin.io.CloseableKt.closeFinally(r0, r3)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mrousavy.camera.core.utils.FileUtils.Companion.writeBitmapTofile(android.graphics.Bitmap, java.io.File, int):void");
        }

        public final Size getImageSize(String str) {
            Intrinsics.checkNotNullParameter(str, "imagePath");
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return new Size(options.outWidth, options.outHeight);
        }
    }
}
