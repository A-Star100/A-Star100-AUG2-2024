package expo.modules.asset;

import android.content.Context;
import androidx.tracing.Trace;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionBuilder;
import expo.modules.kotlin.functions.SuspendFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.net.URI;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H@¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lexpo/modules/asset/AssetModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "downloadAsset", "Landroid/net/Uri;", "appContext", "Lexpo/modules/kotlin/AppContext;", "uri", "Ljava/net/URI;", "localUrl", "Ljava/io/File;", "(Lexpo/modules/kotlin/AppContext;Ljava/net/URI;Ljava/io/File;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMD5HashOfFileContent", "", "file", "getMD5HashOfFilePath", "expo-asset_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AssetModule.kt */
public final class AssetModule extends Module {
    /* access modifiers changed from: private */
    public final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.AppContextLost();
    }

    /* access modifiers changed from: private */
    public final String getMD5HashOfFilePath(URI uri) {
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "toString(...)");
        byte[] bytes = uri2.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = instance.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) AssetModule$getMD5HashOfFilePath$1.INSTANCE, 30, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0049, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004d, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0050, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0054, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getMD5HashOfFileContent(java.io.File r13) {
        /*
            r12 = this;
            r0 = 0
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0055 }
            r1.<init>(r13)     // Catch:{ Exception -> 0x0055 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ Exception -> 0x0055 }
            r13 = r1
            java.io.FileInputStream r13 = (java.io.FileInputStream) r13     // Catch:{ all -> 0x004e }
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch:{ all -> 0x004e }
            java.io.InputStream r13 = (java.io.InputStream) r13     // Catch:{ all -> 0x004e }
            java.lang.String r3 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ all -> 0x004e }
            r2.<init>(r13, r3)     // Catch:{ all -> 0x004e }
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ all -> 0x004e }
            r13 = r2
            java.security.DigestInputStream r13 = (java.security.DigestInputStream) r13     // Catch:{ all -> 0x0047 }
            java.security.MessageDigest r13 = r13.getMessageDigest()     // Catch:{ all -> 0x0047 }
            byte[] r3 = r13.digest()     // Catch:{ all -> 0x0047 }
            java.lang.String r13 = "digest(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r13)     // Catch:{ all -> 0x0047 }
            java.lang.String r13 = ""
            r4 = r13
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x0047 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            expo.modules.asset.AssetModule$getMD5HashOfFileContent$1$1$1 r13 = expo.modules.asset.AssetModule$getMD5HashOfFileContent$1$1$1.INSTANCE     // Catch:{ all -> 0x0047 }
            r9 = r13
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9     // Catch:{ all -> 0x0047 }
            r10 = 30
            r11 = 0
            java.lang.String r13 = kotlin.collections.ArraysKt.joinToString$default((byte[]) r3, (java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (java.lang.CharSequence) r6, (int) r7, (java.lang.CharSequence) r8, (kotlin.jvm.functions.Function1) r9, (int) r10, (java.lang.Object) r11)     // Catch:{ all -> 0x0047 }
            kotlin.io.CloseableKt.closeFinally(r2, r0)     // Catch:{ all -> 0x004e }
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ Exception -> 0x0055 }
            r0 = r13
            goto L_0x0059
        L_0x0047:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r13)     // Catch:{ all -> 0x004e }
            throw r3     // Catch:{ all -> 0x004e }
        L_0x004e:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r13)     // Catch:{ Exception -> 0x0055 }
            throw r2     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            r13 = move-exception
            r13.printStackTrace()
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.asset.AssetModule.getMD5HashOfFileContent(java.io.File):java.lang.String");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object downloadAsset(expo.modules.kotlin.AppContext r6, java.net.URI r7, java.io.File r8, kotlin.coroutines.Continuation<? super android.net.Uri> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof expo.modules.asset.AssetModule$downloadAsset$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            expo.modules.asset.AssetModule$downloadAsset$1 r0 = (expo.modules.asset.AssetModule$downloadAsset$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            expo.modules.asset.AssetModule$downloadAsset$1 r0 = new expo.modules.asset.AssetModule$downloadAsset$1
            r0.<init>(r5, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x007a
        L_0x002a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r9)
            java.io.File r9 = r8.getParentFile()
            if (r9 == 0) goto L_0x0042
            boolean r9 = r9.exists()
            if (r9 != r3) goto L_0x0042
            goto L_0x0045
        L_0x0042:
            r8.mkdirs()
        L_0x0045:
            expo.modules.interfaces.filesystem.FilePermissionModuleInterface r9 = r6.getFilePermission()
            if (r9 == 0) goto L_0x0080
            android.content.Context r2 = r6.getReactContext()
            java.lang.String r4 = r8.getParent()
            java.util.EnumSet r9 = r9.getPathPermissions(r2, r4)
            if (r9 == 0) goto L_0x0080
            expo.modules.interfaces.filesystem.Permission r2 = expo.modules.interfaces.filesystem.Permission.WRITE
            boolean r9 = r9.contains(r2)
            if (r9 != r3) goto L_0x0080
            kotlinx.coroutines.CoroutineScope r6 = r6.getBackgroundCoroutineScope()
            kotlin.coroutines.CoroutineContext r6 = r6.getCoroutineContext()
            expo.modules.asset.AssetModule$downloadAsset$2 r9 = new expo.modules.asset.AssetModule$downloadAsset$2
            r2 = 0
            r9.<init>(r7, r5, r8, r2)
            kotlin.jvm.functions.Function2 r9 = (kotlin.jvm.functions.Function2) r9
            r0.label = r3
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r6, r9, r0)
            if (r9 != r1) goto L_0x007a
            return r1
        L_0x007a:
            java.lang.String r6 = "withContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r6)
            return r9
        L_0x0080:
            expo.modules.asset.UnableToDownloadAssetException r6 = new expo.modules.asset.UnableToDownloadAssetException
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = "toString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.asset.AssetModule.downloadAsset(expo.modules.kotlin.AppContext, java.net.URI, java.io.File, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public ModuleDefinitionData definition() {
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExpoAsset");
            AsyncFunctionBuilder AsyncFunction = moduleDefinitionBuilder.AsyncFunction("downloadAsync");
            Class<URI> cls = URI.class;
            Class<String> cls2 = String.class;
            Class<String> cls3 = String.class;
            AsyncFunction.setAsyncFunctionComponent(new SuspendFunctionComponent(AsyncFunction.getName(), new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(URI.class), false, AssetModule$definition$lambda$3$$inlined$Coroutine$1.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, AssetModule$definition$lambda$3$$inlined$Coroutine$2.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, AssetModule$definition$lambda$3$$inlined$Coroutine$3.INSTANCE))}, new AssetModule$definition$lambda$3$$inlined$Coroutine$4((Continuation) null, this)));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
