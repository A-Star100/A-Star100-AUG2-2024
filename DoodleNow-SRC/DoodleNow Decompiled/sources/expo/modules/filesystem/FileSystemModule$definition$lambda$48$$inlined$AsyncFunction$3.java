package expo.modules.filesystem;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "R", "P0", "P1", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$8"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$3 extends Lambda implements Function1<Object[], Bundle> {
    final /* synthetic */ FileSystemModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$3(FileSystemModule fileSystemModule) {
        super(1);
        this.this$0 = fileSystemModule;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0142 A[Catch:{ FileNotFoundException -> 0x0184 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x017e A[Catch:{ FileNotFoundException -> 0x0184 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle invoke(java.lang.Object[] r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            java.lang.String r2 = "<name for destructuring parameter 0>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r2 = 0
            r3 = r1[r2]
            r4 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r4)
            r1 = r1[r4]
            expo.modules.filesystem.InfoOptions r1 = (expo.modules.filesystem.InfoOptions) r1
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r3 = expo.modules.filesystem.FileSystemModuleKt.slashifyFilePath(r3)
            android.net.Uri r6 = android.net.Uri.parse(r3)
            java.lang.String r7 = r6.getScheme()
            java.lang.String r8 = "file"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x003b
            expo.modules.filesystem.FileSystemModule r7 = r0.this$0
            java.lang.String r9 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r9)
            java.lang.String r3 = r7.parseFileUri(r3)
            android.net.Uri r7 = android.net.Uri.parse(r3)
            goto L_0x003c
        L_0x003b:
            r7 = r6
        L_0x003c:
            expo.modules.filesystem.FileSystemModule r9 = r0.this$0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            expo.modules.interfaces.filesystem.Permission r10 = expo.modules.interfaces.filesystem.Permission.READ
            r9.ensurePermission(r7, r10)
            java.lang.String r9 = r6.getScheme()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r8)
            java.lang.String r9 = "md5"
            java.lang.String r10 = "size"
            java.lang.String r11 = "uri"
            java.lang.String r12 = "isDirectory"
            java.lang.String r13 = "exists"
            if (r8 == 0) goto L_0x00c7
            expo.modules.filesystem.FileSystemModule r3 = r0.this$0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            java.io.File r3 = r3.toFile(r7)
            boolean r6 = r3.exists()
            if (r6 == 0) goto L_0x00b9
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r2.putBoolean(r13, r4)
            boolean r4 = r3.isDirectory()
            r2.putBoolean(r12, r4)
            android.net.Uri r4 = android.net.Uri.fromFile(r3)
            java.lang.String r4 = r4.toString()
            r2.putString(r11, r4)
            expo.modules.filesystem.FileSystemModule r4 = r0.this$0
            long r6 = r4.getFileSize(r3)
            double r6 = (double) r6
            r2.putDouble(r10, r6)
            long r6 = r3.lastModified()
            double r6 = (double) r6
            r10 = 4562254508917369340(0x3f50624dd2f1a9fc, double:0.001)
            double r6 = r6 * r10
            java.lang.String r4 = "modificationTime"
            r2.putDouble(r4, r6)
            java.lang.Boolean r1 = r1.getMd5()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x00a8
            goto L_0x00a9
        L_0x00a8:
            r1 = 0
        L_0x00a9:
            if (r1 == 0) goto L_0x0190
            r1.booleanValue()
            expo.modules.filesystem.FileSystemModule r1 = r0.this$0
            java.lang.String r1 = r1.md5(r3)
            r2.putString(r9, r1)
            goto L_0x0190
        L_0x00b9:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            r1.putBoolean(r13, r2)
            r1.putBoolean(r12, r2)
            r2 = r1
            goto L_0x0190
        L_0x00c7:
            java.lang.String r7 = r6.getScheme()
            java.lang.String r8 = "content"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            java.lang.String r14 = "asset"
            if (r7 != 0) goto L_0x00ff
            java.lang.String r7 = r6.getScheme()
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r14)
            if (r7 != 0) goto L_0x00ff
            java.lang.String r7 = r6.getScheme()
            if (r7 != 0) goto L_0x00e6
            goto L_0x00ff
        L_0x00e6:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unsupported scheme for location '"
            r2.<init>(r3)
            r2.append(r6)
            java.lang.String r3 = "'."
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00ff:
            java.lang.String r7 = r6.getScheme()     // Catch:{ FileNotFoundException -> 0x0184 }
            if (r7 == 0) goto L_0x013a
            int r15 = r7.hashCode()     // Catch:{ FileNotFoundException -> 0x0184 }
            r2 = 93121264(0x58ceaf0, float:1.3251839E-35)
            if (r15 == r2) goto L_0x0129
            r2 = 951530617(0x38b73479, float:8.735894E-5)
            if (r15 == r2) goto L_0x0114
            goto L_0x013a
        L_0x0114:
            boolean r2 = r7.equals(r8)     // Catch:{ FileNotFoundException -> 0x0184 }
            if (r2 == 0) goto L_0x013a
            expo.modules.filesystem.FileSystemModule r2 = r0.this$0     // Catch:{ FileNotFoundException -> 0x0184 }
            android.content.Context r2 = r2.getContext()     // Catch:{ FileNotFoundException -> 0x0184 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0184 }
            java.io.InputStream r2 = r2.openInputStream(r6)     // Catch:{ FileNotFoundException -> 0x0184 }
            goto L_0x0140
        L_0x0129:
            boolean r2 = r7.equals(r14)     // Catch:{ FileNotFoundException -> 0x0184 }
            if (r2 != 0) goto L_0x0130
            goto L_0x013a
        L_0x0130:
            expo.modules.filesystem.FileSystemModule r2 = r0.this$0     // Catch:{ FileNotFoundException -> 0x0184 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)     // Catch:{ FileNotFoundException -> 0x0184 }
            java.io.InputStream r2 = r2.openAssetInputStream(r6)     // Catch:{ FileNotFoundException -> 0x0184 }
            goto L_0x0140
        L_0x013a:
            expo.modules.filesystem.FileSystemModule r2 = r0.this$0     // Catch:{ FileNotFoundException -> 0x0184 }
            java.io.InputStream r2 = r2.openResourceInputStream(r3)     // Catch:{ FileNotFoundException -> 0x0184 }
        L_0x0140:
            if (r2 == 0) goto L_0x017e
            android.os.Bundle r3 = new android.os.Bundle     // Catch:{ FileNotFoundException -> 0x0184 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x0184 }
            r3.putBoolean(r13, r4)     // Catch:{ FileNotFoundException -> 0x0184 }
            r4 = 0
            r3.putBoolean(r12, r4)     // Catch:{ FileNotFoundException -> 0x0184 }
            java.lang.String r4 = r6.toString()     // Catch:{ FileNotFoundException -> 0x0184 }
            r3.putString(r11, r4)     // Catch:{ FileNotFoundException -> 0x0184 }
            int r4 = r2.available()     // Catch:{ FileNotFoundException -> 0x0184 }
            double r6 = (double) r4     // Catch:{ FileNotFoundException -> 0x0184 }
            r3.putDouble(r10, r6)     // Catch:{ FileNotFoundException -> 0x0184 }
            java.lang.Boolean r1 = r1.getMd5()     // Catch:{ FileNotFoundException -> 0x0184 }
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r5)     // Catch:{ FileNotFoundException -> 0x0184 }
            if (r1 == 0) goto L_0x017c
            byte[] r1 = org.apache.commons.codec.digest.DigestUtils.md5((java.io.InputStream) r2)     // Catch:{ FileNotFoundException -> 0x0184 }
            char[] r1 = org.apache.commons.codec.binary.Hex.encodeHex(r1)     // Catch:{ FileNotFoundException -> 0x0184 }
            java.lang.String r2 = "encodeHex(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)     // Catch:{ FileNotFoundException -> 0x0184 }
            java.lang.String r2 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0184 }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0184 }
            r3.putString(r9, r2)     // Catch:{ FileNotFoundException -> 0x0184 }
        L_0x017c:
            r2 = r3
            goto L_0x0190
        L_0x017e:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0184 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0184 }
            throw r1     // Catch:{ FileNotFoundException -> 0x0184 }
        L_0x0184:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            r1 = 0
            r2.putBoolean(r13, r1)
            r2.putBoolean(r12, r1)
        L_0x0190:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunction$3.invoke(java.lang.Object[]):java.lang.Object");
    }
}
