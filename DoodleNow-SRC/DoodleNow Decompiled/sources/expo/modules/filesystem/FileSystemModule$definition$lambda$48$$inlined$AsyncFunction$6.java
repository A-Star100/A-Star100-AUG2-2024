package expo.modules.filesystem;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "R", "P0", "P1", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$8"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$6 extends Lambda implements Function1<Object[], String> {
    final /* synthetic */ FileSystemModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$6(FileSystemModule fileSystemModule) {
        super(1);
        this.this$0 = fileSystemModule;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x007b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x007f, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String invoke(java.lang.Object[] r8) {
        /*
            r7 = this;
            java.lang.String r0 = "<name for destructuring parameter 0>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 0
            r1 = r8[r0]
            r2 = 1
            r8 = r8[r2]
            expo.modules.filesystem.ReadingOptions r8 = (expo.modules.filesystem.ReadingOptions) r8
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = expo.modules.filesystem.FileSystemModuleKt.slashifyFilePath(r1)
            android.net.Uri r2 = android.net.Uri.parse(r2)
            expo.modules.filesystem.FileSystemModule r3 = r7.this$0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            expo.modules.interfaces.filesystem.Permission r4 = expo.modules.interfaces.filesystem.Permission.READ
            r3.ensurePermission(r2, r4)
            expo.modules.filesystem.EncodingType r3 = r8.getEncoding()
            expo.modules.filesystem.EncodingType r4 = expo.modules.filesystem.EncodingType.BASE64
            if (r3 != r4) goto L_0x0080
            expo.modules.filesystem.FileSystemModule r1 = r7.this$0
            java.io.InputStream r1 = r1.getInputStream(r2)
            java.io.Closeable r1 = (java.io.Closeable) r1
            r2 = r1
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x0079 }
            java.lang.Integer r3 = r8.getLength()     // Catch:{ all -> 0x0079 }
            r4 = 2
            if (r3 == 0) goto L_0x0068
            java.lang.Integer r3 = r8.getPosition()     // Catch:{ all -> 0x0079 }
            if (r3 == 0) goto L_0x0068
            java.lang.Integer r3 = r8.getLength()     // Catch:{ all -> 0x0079 }
            int r3 = r3.intValue()     // Catch:{ all -> 0x0079 }
            byte[] r3 = new byte[r3]     // Catch:{ all -> 0x0079 }
            java.lang.Integer r5 = r8.getPosition()     // Catch:{ all -> 0x0079 }
            int r5 = r5.intValue()     // Catch:{ all -> 0x0079 }
            long r5 = (long) r5     // Catch:{ all -> 0x0079 }
            r2.skip(r5)     // Catch:{ all -> 0x0079 }
            java.lang.Integer r8 = r8.getLength()     // Catch:{ all -> 0x0079 }
            int r8 = r8.intValue()     // Catch:{ all -> 0x0079 }
            int r8 = r2.read(r3, r0, r8)     // Catch:{ all -> 0x0079 }
            java.lang.String r8 = android.util.Base64.encodeToString(r3, r0, r8, r4)     // Catch:{ all -> 0x0079 }
            goto L_0x0072
        L_0x0068:
            expo.modules.filesystem.FileSystemModule r8 = r7.this$0     // Catch:{ all -> 0x0079 }
            byte[] r8 = r8.getInputStreamBytes(r2)     // Catch:{ all -> 0x0079 }
            java.lang.String r8 = android.util.Base64.encodeToString(r8, r4)     // Catch:{ all -> 0x0079 }
        L_0x0072:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0079 }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            goto L_0x00e0
        L_0x0079:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x007b }
        L_0x007b:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r8)
            throw r0
        L_0x0080:
            java.lang.String r8 = r2.getScheme()
            java.lang.String r0 = "file"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r0)
            if (r8 == 0) goto L_0x009e
            java.io.FileInputStream r8 = new java.io.FileInputStream
            expo.modules.filesystem.FileSystemModule r0 = r7.this$0
            java.io.File r0 = r0.toFile(r2)
            r8.<init>(r0)
            java.io.InputStream r8 = (java.io.InputStream) r8
            java.lang.String r8 = org.apache.commons.io.IOUtils.toString((java.io.InputStream) r8)
            goto L_0x00e0
        L_0x009e:
            java.lang.String r8 = r2.getScheme()
            java.lang.String r0 = "asset"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r0)
            if (r8 == 0) goto L_0x00b5
            expo.modules.filesystem.FileSystemModule r8 = r7.this$0
            java.io.InputStream r8 = r8.openAssetInputStream(r2)
            java.lang.String r8 = org.apache.commons.io.IOUtils.toString((java.io.InputStream) r8)
            goto L_0x00e0
        L_0x00b5:
            java.lang.String r8 = r2.getScheme()
            if (r8 != 0) goto L_0x00c6
            expo.modules.filesystem.FileSystemModule r8 = r7.this$0
            java.io.InputStream r8 = r8.openResourceInputStream(r1)
            java.lang.String r8 = org.apache.commons.io.IOUtils.toString((java.io.InputStream) r8)
            goto L_0x00e0
        L_0x00c6:
            expo.modules.filesystem.FileSystemModule r8 = r7.this$0
            boolean r8 = r8.isSAFUri(r2)
            if (r8 == 0) goto L_0x00e1
            expo.modules.filesystem.FileSystemModule r8 = r7.this$0
            android.content.Context r8 = r8.getContext()
            android.content.ContentResolver r8 = r8.getContentResolver()
            java.io.InputStream r8 = r8.openInputStream(r2)
            java.lang.String r8 = org.apache.commons.io.IOUtils.toString((java.io.InputStream) r8)
        L_0x00e0:
            return r8
        L_0x00e1:
            java.io.IOException r8 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unsupported scheme for location '"
            r0.<init>(r1)
            r0.append(r2)
            java.lang.String r1 = "'."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$6.invoke(java.lang.Object[]):java.lang.Object");
    }
}
