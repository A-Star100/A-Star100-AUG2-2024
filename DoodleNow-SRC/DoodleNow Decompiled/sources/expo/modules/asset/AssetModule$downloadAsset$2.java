package expo.modules.asset;

import android.net.Uri;
import java.io.File;
import java.net.URI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "expo.modules.asset.AssetModule$downloadAsset$2", f = "AssetModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AssetModule.kt */
final class AssetModule$downloadAsset$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Uri>, Object> {
    final /* synthetic */ File $localUrl;
    final /* synthetic */ URI $uri;
    int label;
    final /* synthetic */ AssetModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssetModule$downloadAsset$2(URI uri, AssetModule assetModule, File file, Continuation<? super AssetModule$downloadAsset$2> continuation) {
        super(2, continuation);
        this.$uri = uri;
        this.this$0 = assetModule;
        this.$localUrl = file;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AssetModule$downloadAsset$2(this.$uri, this.this$0, this.$localUrl, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Uri> continuation) {
        return ((AssetModule$downloadAsset$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006a, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r6, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006e, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0071, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r8, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0075, code lost:
        throw r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.String r0 = "toString(...)"
            kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            if (r1 != 0) goto L_0x0085
            kotlin.ResultKt.throwOnFailure(r8)
            java.net.URI r8 = r7.$uri     // Catch:{ Exception -> 0x0076 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x0076 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)     // Catch:{ Exception -> 0x0076 }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x0076 }
            java.lang.String r1 = ":"
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1     // Catch:{ Exception -> 0x0076 }
            r2 = 2
            r3 = 0
            r4 = 0
            boolean r8 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r8, (java.lang.CharSequence) r1, (boolean) r3, (int) r2, (java.lang.Object) r4)     // Catch:{ Exception -> 0x0076 }
            if (r8 != 0) goto L_0x0038
            expo.modules.asset.AssetModule r8 = r7.this$0     // Catch:{ Exception -> 0x0076 }
            android.content.Context r8 = r8.getContext()     // Catch:{ Exception -> 0x0076 }
            java.net.URI r1 = r7.$uri     // Catch:{ Exception -> 0x0076 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0076 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)     // Catch:{ Exception -> 0x0076 }
            java.io.InputStream r8 = expo.modules.asset.ResourceAssetKt.openAssetResourceStream(r8, r1)     // Catch:{ Exception -> 0x0076 }
            goto L_0x0042
        L_0x0038:
            java.net.URI r8 = r7.$uri     // Catch:{ Exception -> 0x0076 }
            java.net.URL r8 = r8.toURL()     // Catch:{ Exception -> 0x0076 }
            java.io.InputStream r8 = r8.openStream()     // Catch:{ Exception -> 0x0076 }
        L_0x0042:
            java.io.Closeable r8 = (java.io.Closeable) r8     // Catch:{ Exception -> 0x0076 }
            java.io.File r1 = r7.$localUrl     // Catch:{ Exception -> 0x0076 }
            r5 = r8
            java.io.InputStream r5 = (java.io.InputStream) r5     // Catch:{ all -> 0x006f }
            java.io.FileOutputStream r6 = new java.io.FileOutputStream     // Catch:{ all -> 0x006f }
            r6.<init>(r1)     // Catch:{ all -> 0x006f }
            java.io.Closeable r6 = (java.io.Closeable) r6     // Catch:{ all -> 0x006f }
            r1 = r6
            java.io.FileOutputStream r1 = (java.io.FileOutputStream) r1     // Catch:{ all -> 0x0068 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)     // Catch:{ all -> 0x0068 }
            java.io.OutputStream r1 = (java.io.OutputStream) r1     // Catch:{ all -> 0x0068 }
            kotlin.io.ByteStreamsKt.copyTo$default(r5, r1, r3, r2, r4)     // Catch:{ all -> 0x0068 }
            kotlin.io.CloseableKt.closeFinally(r6, r4)     // Catch:{ all -> 0x006f }
            kotlin.io.CloseableKt.closeFinally(r8, r4)     // Catch:{ Exception -> 0x0076 }
            java.io.File r8 = r7.$localUrl     // Catch:{ Exception -> 0x0076 }
            android.net.Uri r8 = android.net.Uri.fromFile(r8)     // Catch:{ Exception -> 0x0076 }
            return r8
        L_0x0068:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x006a }
        L_0x006a:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r6, r1)     // Catch:{ all -> 0x006f }
            throw r2     // Catch:{ all -> 0x006f }
        L_0x006f:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x0071 }
        L_0x0071:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r8, r1)     // Catch:{ Exception -> 0x0076 }
            throw r2     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            expo.modules.asset.UnableToDownloadAssetException r8 = new expo.modules.asset.UnableToDownloadAssetException
            java.net.URI r1 = r7.$uri
            java.lang.String r1 = r1.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            r8.<init>(r1)
            throw r8
        L_0x0085:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.asset.AssetModule$downloadAsset$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
