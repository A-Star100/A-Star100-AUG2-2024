package expo.modules.filesystem;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"<anonymous>", "", "R", "P0", "<name for destructuring parameter 0>", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$10"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class FileSystemModule$definition$lambda$48$$inlined$AsyncFunctionWithPromise$2 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ FileSystemModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileSystemModule$definition$lambda$48$$inlined$AsyncFunctionWithPromise$2(FileSystemModule fileSystemModule) {
        super(2);
        this.this$0 = fileSystemModule;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Uri parse;
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        String str = objArr[0];
        Activity currentActivity = this.this$0.getAppContext().getCurrentActivity();
        if (currentActivity == null) {
            throw new Exceptions.MissingActivity();
        } else if (this.this$0.dirPermissionsRequest == null) {
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (!(Build.VERSION.SDK_INT < 26 || str == null || (parse = Uri.parse(FileSystemModuleKt.slashifyFilePath(str))) == null)) {
                intent.putExtra("android.provider.extra.INITIAL_URI", parse);
            }
            this.this$0.dirPermissionsRequest = promise;
            currentActivity.startActivityForResult(intent, 5394);
        } else {
            throw new FileSystemPendingPermissionsRequestException();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
