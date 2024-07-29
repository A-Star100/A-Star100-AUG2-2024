package expo.modules.filesystem;

import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u00012\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "<name for destructuring parameter 0>", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$18"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class FileSystemModule$definition$lambda$48$$inlined$AsyncFunctionWithPromise$6 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ ModuleDefinitionBuilder $this_ModuleDefinition$inlined;
    final /* synthetic */ FileSystemModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$48$$inlined$AsyncFunctionWithPromise$6(FileSystemModule fileSystemModule, ModuleDefinitionBuilder moduleDefinitionBuilder) {
        super(2);
        this.this$0 = fileSystemModule;
        this.$this_ModuleDefinition$inlined = moduleDefinitionBuilder;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Unit unit;
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        String str = objArr[0];
        String str2 = str;
        FileSystemModule fileSystemModule = this.this$0;
        Request access$createUploadRequest = fileSystemModule.createUploadRequest(str2, objArr[1], objArr[2], FileSystemModule$definition$1$17$request$1.INSTANCE);
        OkHttpClient access$getOkHttpClient = this.this$0.getOkHttpClient();
        if (access$getOkHttpClient != null) {
            access$getOkHttpClient.newCall(access$createUploadRequest).enqueue(new FileSystemModule$definition$1$17$1$1(promise, this.this$0));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            promise.reject(new FileSystemOkHttpNullException());
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
