package expo.modules.documentpicker;

import android.content.Intent;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.imagepicker.MediaTypes;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"<anonymous>", "", "R", "P0", "<name for destructuring parameter 0>", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$10"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class DocumentPickerModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$2 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ DocumentPickerModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DocumentPickerModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$2(DocumentPickerModule documentPickerModule) {
        super(2);
        this.this$0 = documentPickerModule;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        String str;
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        DocumentPickerOptions documentPickerOptions = objArr[0];
        if (this.this$0.pendingPromise == null) {
            this.this$0.pendingPromise = promise;
            this.this$0.copyToCacheDirectory = documentPickerOptions.getCopyToCacheDirectory();
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", documentPickerOptions.getMultiple());
            if (documentPickerOptions.getType().size() > 1) {
                intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) documentPickerOptions.getType().toArray(new String[0]));
                str = MediaTypes.AllMimeType;
            } else {
                str = documentPickerOptions.getType().get(0);
            }
            intent.setType(str);
            this.this$0.getCurrentActivity().startActivityForResult(intent, 4137);
            return;
        }
        throw new PickingInProgressException();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
