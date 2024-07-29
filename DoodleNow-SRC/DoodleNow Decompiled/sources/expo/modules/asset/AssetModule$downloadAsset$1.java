package expo.modules.asset;

import expo.modules.kotlin.AppContext;
import java.io.File;
import java.net.URI;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.asset.AssetModule", f = "AssetModule.kt", i = {}, l = {56}, m = "downloadAsset", n = {}, s = {})
/* compiled from: AssetModule.kt */
final class AssetModule$downloadAsset$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AssetModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AssetModule$downloadAsset$1(AssetModule assetModule, Continuation<? super AssetModule$downloadAsset$1> continuation) {
        super(continuation);
        this.this$0 = assetModule;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.downloadAsset((AppContext) null, (URI) null, (File) null, this);
    }
}
