package expo.modules.filesystem;

import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u0001\"\u0006\b\u0004\u0010\u0006\u0018\u0001\"\u0006\b\u0005\u0010\u0007\u0018\u00012\u0010\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\n¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "P3", "P4", "<name for destructuring parameter 0>", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$26"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class FileSystemModule$definition$lambda$48$$inlined$AsyncFunctionWithPromise$21 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ FileSystemModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$48$$inlined$AsyncFunctionWithPromise$21(FileSystemModule fileSystemModule) {
        super(2);
        this.this$0 = fileSystemModule;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0058, code lost:
        r5 = (r6 = r6.newBuilder()).addInterceptor(new expo.modules.filesystem.FileSystemModule$definition$lambda$48$lambda$42$$inlined$addInterceptor$1(r5));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(java.lang.Object[] r14, expo.modules.kotlin.Promise r15) {
        /*
            r13 = this;
            java.lang.String r0 = "<name for destructuring parameter 0>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "promise"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = 0
            r1 = r14[r0]
            r2 = 1
            r3 = r14[r2]
            r4 = 2
            r4 = r14[r4]
            r5 = 3
            r5 = r14[r5]
            r6 = 4
            r14 = r14[r6]
            java.lang.String r14 = (java.lang.String) r14
            r7 = r5
            expo.modules.filesystem.DownloadOptions r7 = (expo.modules.filesystem.DownloadOptions) r7
            java.lang.String r4 = (java.lang.String) r4
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r3 = expo.modules.filesystem.FileSystemModuleKt.slashifyFilePath(r3)
            android.net.Uri r3 = android.net.Uri.parse(r3)
            expo.modules.filesystem.FileSystemModule r5 = r13.this$0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r5.checkIfFileDirExists(r3)
            java.lang.String r5 = r3.getScheme()
            java.lang.String r6 = "file"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x010a
            expo.modules.filesystem.FileSystemModule$definition$1$21$progressListener$1 r5 = new expo.modules.filesystem.FileSystemModule$definition$1$21$progressListener$1
            expo.modules.filesystem.FileSystemModule r6 = r13.this$0
            r5.<init>(r14, r4, r6)
            expo.modules.filesystem.FileSystemModule$ProgressListener r5 = (expo.modules.filesystem.FileSystemModule.ProgressListener) r5
            expo.modules.filesystem.FileSystemModule r6 = r13.this$0
            okhttp3.OkHttpClient r6 = r6.getOkHttpClient()
            r12 = 0
            if (r6 == 0) goto L_0x006a
            okhttp3.OkHttpClient$Builder r6 = r6.newBuilder()
            if (r6 == 0) goto L_0x006a
            expo.modules.filesystem.FileSystemModule$definition$lambda$48$lambda$42$$inlined$-addInterceptor$1 r8 = new expo.modules.filesystem.FileSystemModule$definition$lambda$48$lambda$42$$inlined$-addInterceptor$1
            r8.<init>(r5)
            okhttp3.Interceptor r8 = (okhttp3.Interceptor) r8
            okhttp3.OkHttpClient$Builder r5 = r6.addInterceptor(r8)
            if (r5 == 0) goto L_0x006a
            okhttp3.OkHttpClient r5 = r5.build()
            goto L_0x006b
        L_0x006a:
            r5 = r12
        L_0x006b:
            if (r5 != 0) goto L_0x0079
            expo.modules.filesystem.FileSystemOkHttpNullException r14 = new expo.modules.filesystem.FileSystemOkHttpNullException
            r14.<init>()
            expo.modules.kotlin.exception.CodedException r14 = (expo.modules.kotlin.exception.CodedException) r14
            r15.reject(r14)
            goto L_0x0109
        L_0x0079:
            okhttp3.Request$Builder r6 = new okhttp3.Request$Builder
            r6.<init>()
            if (r14 == 0) goto L_0x0098
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r9 = "bytes="
            r8.<init>(r9)
            r8.append(r14)
            java.lang.String r9 = "-"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "Range"
            r6.addHeader(r9, r8)
        L_0x0098:
            java.util.Map r8 = r7.getHeaders()
            if (r8 == 0) goto L_0x00c6
            java.util.Map r8 = r7.getHeaders()
            java.util.Set r8 = r8.entrySet()
            java.util.Iterator r8 = r8.iterator()
        L_0x00aa:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x00c6
            java.lang.Object r9 = r8.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r10 = r9.getKey()
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r9 = r9.getValue()
            java.lang.String r9 = (java.lang.String) r9
            r6.addHeader(r10, r9)
            goto L_0x00aa
        L_0x00c6:
            okhttp3.Request$Builder r1 = r6.url((java.lang.String) r1)
            okhttp3.Request r1 = r1.build()
            okhttp3.Call r8 = r5.newCall(r1)
            expo.modules.filesystem.FileSystemModule r1 = r13.this$0
            java.util.Map r1 = r1.taskHandlers
            expo.modules.filesystem.FileSystemModule$DownloadTaskHandler r5 = new expo.modules.filesystem.FileSystemModule$DownloadTaskHandler
            r5.<init>(r3, r8)
            r1.put(r4, r5)
            expo.modules.filesystem.FileSystemModule$DownloadResumableTaskParams r1 = new expo.modules.filesystem.FileSystemModule$DownloadResumableTaskParams
            expo.modules.filesystem.FileSystemModule r4 = r13.this$0
            java.io.File r9 = r4.toFile(r3)
            if (r14 == 0) goto L_0x00ec
            r10 = r2
            goto L_0x00ed
        L_0x00ec:
            r10 = r0
        L_0x00ed:
            r6 = r1
            r11 = r15
            r6.<init>(r7, r8, r9, r10, r11)
            expo.modules.filesystem.FileSystemModule r14 = r13.this$0
            kotlinx.coroutines.CoroutineScope r2 = r14.moduleCoroutineScope
            r3 = 0
            r4 = 0
            expo.modules.filesystem.FileSystemModule$definition$1$21$3 r14 = new expo.modules.filesystem.FileSystemModule$definition$1$21$3
            expo.modules.filesystem.FileSystemModule r15 = r13.this$0
            r14.<init>(r15, r1, r12)
            r5 = r14
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = 3
            r7 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r2, r3, r4, r5, r6, r7)
        L_0x0109:
            return
        L_0x010a:
            java.io.IOException r14 = new java.io.IOException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            java.lang.String r0 = "Unsupported scheme for location '"
            r15.<init>(r0)
            r15.append(r3)
            java.lang.String r0 = "'."
            r15.append(r0)
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.filesystem.FileSystemModule$definition$lambda$48$$inlined$AsyncFunctionWithPromise$21.invoke(java.lang.Object[], expo.modules.kotlin.Promise):void");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
