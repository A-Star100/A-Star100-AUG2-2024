package expo.modules.filesystem;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u0001\"\u0006\b\u0003\u0010\u0004\u0018\u00012\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"<anonymous>", "R", "P0", "P1", "P2", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$12"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$10 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ FileSystemModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$10(FileSystemModule fileSystemModule) {
        super(1);
        this.this$0 = fileSystemModule;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r7, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0069, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Unit invoke(java.lang.Object[] r7) {
        /*
            r6 = this;
            java.lang.String r0 = "<name for destructuring parameter 0>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            r1 = r7[r0]
            r2 = 1
            r2 = r7[r2]
            r3 = 2
            r7 = r7[r3]
            expo.modules.filesystem.WritingOptions r7 = (expo.modules.filesystem.WritingOptions) r7
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = expo.modules.filesystem.FileSystemModuleKt.slashifyFilePath(r1)
            android.net.Uri r1 = android.net.Uri.parse(r1)
            expo.modules.filesystem.FileSystemModule r3 = r6.this$0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            expo.modules.interfaces.filesystem.Permission r4 = expo.modules.interfaces.filesystem.Permission.WRITE
            r3.ensurePermission(r1, r4)
            expo.modules.filesystem.EncodingType r7 = r7.getEncoding()
            expo.modules.filesystem.FileSystemModule r3 = r6.this$0
            java.io.OutputStream r1 = r3.getOutputStream(r1)
            java.io.Closeable r1 = (java.io.Closeable) r1
            r3 = r1
            java.io.OutputStream r3 = (java.io.OutputStream) r3     // Catch:{ all -> 0x0063 }
            expo.modules.filesystem.EncodingType r4 = expo.modules.filesystem.EncodingType.BASE64     // Catch:{ all -> 0x0063 }
            r5 = 0
            if (r7 != r4) goto L_0x0042
            byte[] r7 = android.util.Base64.decode(r2, r0)     // Catch:{ all -> 0x0063 }
            r3.write(r7)     // Catch:{ all -> 0x0063 }
            goto L_0x0054
        L_0x0042:
            java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0063 }
            r7.<init>(r3)     // Catch:{ all -> 0x0063 }
            java.io.Closeable r7 = (java.io.Closeable) r7     // Catch:{ all -> 0x0063 }
            r0 = r7
            java.io.OutputStreamWriter r0 = (java.io.OutputStreamWriter) r0     // Catch:{ all -> 0x005c }
            r0.write(r2)     // Catch:{ all -> 0x005c }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x005c }
            kotlin.io.CloseableKt.closeFinally(r7, r5)     // Catch:{ all -> 0x0063 }
        L_0x0054:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0063 }
            kotlin.io.CloseableKt.closeFinally(r1, r5)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x005c:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x005e }
        L_0x005e:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r7, r0)     // Catch:{ all -> 0x0063 }
            throw r2     // Catch:{ all -> 0x0063 }
        L_0x0063:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$10.invoke(java.lang.Object[]):java.lang.Object");
    }
}
