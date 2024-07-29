package expo.modules.asset;

import android.net.Uri;
import expo.modules.kotlin.AppContext;
import java.io.File;
import java.net.URI;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0006\"\u0006\b\u0000\u0010\u0000\u0018\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u0001\"\u0006\b\u0002\u0010\u0002\u0018\u0001\"\u0006\b\u0003\u0010\u0003\u0018\u0001*\u00020\u00042\u0010\u0010\u0007\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005H@¨\u0006\b"}, d2 = {"R", "P0", "P1", "P2", "Lkotlinx/coroutines/CoroutineScope;", "", "", "<name for destructuring parameter 0>", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$7", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "expo.modules.asset.AssetModule$definition$lambda$3$$inlined$Coroutine$4", f = "AssetModule.kt", i = {}, l = {280, 287}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AsyncFunctionBuilder.kt */
public final class AssetModule$definition$lambda$3$$inlined$Coroutine$4 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AssetModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AssetModule$definition$lambda$3$$inlined$Coroutine$4(Continuation continuation, AssetModule assetModule) {
        super(3, continuation);
        this.this$0 = assetModule;
    }

    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        AssetModule$definition$lambda$3$$inlined$Coroutine$4 assetModule$definition$lambda$3$$inlined$Coroutine$4 = new AssetModule$definition$lambda$3$$inlined$Coroutine$4(continuation, this.this$0);
        assetModule$definition$lambda$3$$inlined$Coroutine$4.L$0 = objArr;
        return assetModule$definition$lambda$3$$inlined$Coroutine$4.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object[] objArr = (Object[]) this.L$0;
            Object obj2 = objArr[0];
            Object obj3 = objArr[1];
            Continuation continuation = this;
            String str = (String) objArr[2];
            String str2 = (String) obj3;
            URI uri = (URI) obj2;
            if (uri.getScheme() == "file") {
                return uri;
            }
            String access$getMD5HashOfFilePath = str2 == null ? this.this$0.getMD5HashOfFilePath(uri) : str2;
            File cacheDirectory = this.this$0.getAppContext().getCacheDirectory();
            File file = new File(cacheDirectory + "/ExponentAsset-" + access$getMD5HashOfFilePath + "." + str);
            if (!file.exists()) {
                AssetModule assetModule = this.this$0;
                AppContext appContext = assetModule.getAppContext();
                this.label = 1;
                obj = assetModule.downloadAsset(appContext, uri, file, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (str2 == null || Intrinsics.areEqual((Object) str2, (Object) this.this$0.getMD5HashOfFileContent(file))) {
                return Uri.fromFile(file);
            } else {
                AssetModule assetModule2 = this.this$0;
                AppContext appContext2 = assetModule2.getAppContext();
                this.label = 2;
                obj = assetModule2.downloadAsset(appContext2, uri, file, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1 || i == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
