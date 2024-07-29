package expo.modules.documentpicker;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lexpo/modules/documentpicker/DocumentDetailsReader;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "read", "Lexpo/modules/documentpicker/DocumentDetails;", "uri", "Landroid/net/Uri;", "expo-document-picker_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DocumentDetailsReader.kt */
public final class DocumentDetailsReader {
    private final Context context;

    public DocumentDetailsReader(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0060, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0064, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final expo.modules.documentpicker.DocumentDetails read(android.net.Uri r8) {
        /*
            r7 = this;
            java.lang.String r0 = "uri"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            android.content.Context r0 = r7.context
            android.content.ContentResolver r1 = r0.getContentResolver()
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r2 = r8
            android.database.Cursor r0 = r1.query(r2, r3, r4, r5, r6)
            r1 = 0
            if (r0 == 0) goto L_0x0065
            java.io.Closeable r0 = (java.io.Closeable) r0
            r2 = r0
            android.database.Cursor r2 = (android.database.Cursor) r2     // Catch:{ all -> 0x005e }
            r2.moveToFirst()     // Catch:{ all -> 0x005e }
            java.lang.String r3 = "_display_name"
            int r3 = r2.getColumnIndex(r3)     // Catch:{ all -> 0x005e }
            java.lang.String r3 = r2.getString(r3)     // Catch:{ all -> 0x005e }
            java.lang.String r4 = r8.toString()     // Catch:{ all -> 0x005e }
            java.lang.String r5 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch:{ all -> 0x005e }
            java.lang.String r5 = "_size"
            int r5 = r2.getColumnIndex(r5)     // Catch:{ all -> 0x005e }
            boolean r6 = r2.isNull(r5)     // Catch:{ all -> 0x005e }
            if (r6 != 0) goto L_0x0047
            int r2 = r2.getInt(r5)     // Catch:{ all -> 0x005e }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x005e }
            goto L_0x0048
        L_0x0047:
            r2 = r1
        L_0x0048:
            android.content.Context r5 = r7.context     // Catch:{ all -> 0x005e }
            android.content.ContentResolver r5 = r5.getContentResolver()     // Catch:{ all -> 0x005e }
            java.lang.String r8 = r5.getType(r8)     // Catch:{ all -> 0x005e }
            expo.modules.documentpicker.DocumentDetails r5 = new expo.modules.documentpicker.DocumentDetails     // Catch:{ all -> 0x005e }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ all -> 0x005e }
            r5.<init>(r3, r4, r2, r8)     // Catch:{ all -> 0x005e }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return r5
        L_0x005e:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0060 }
        L_0x0060:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r8)
            throw r1
        L_0x0065:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.documentpicker.DocumentDetailsReader.read(android.net.Uri):expo.modules.documentpicker.DocumentDetails");
    }
}
