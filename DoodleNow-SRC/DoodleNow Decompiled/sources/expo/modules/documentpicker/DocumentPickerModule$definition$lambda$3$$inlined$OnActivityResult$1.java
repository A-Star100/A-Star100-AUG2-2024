package expo.modules.documentpicker;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.exception.CodedException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "sender", "Landroid/app/Activity;", "payload", "Lexpo/modules/kotlin/events/OnActivityResultPayload;", "invoke", "expo/modules/kotlin/modules/ModuleDefinitionBuilder$OnActivityResult$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ModuleDefinitionBuilder.kt */
public final class DocumentPickerModule$definition$lambda$3$$inlined$OnActivityResult$1 extends Lambda implements Function2<Activity, OnActivityResultPayload, Unit> {
    final /* synthetic */ DocumentPickerModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DocumentPickerModule$definition$lambda$3$$inlined$OnActivityResult$1(DocumentPickerModule documentPickerModule) {
        super(2);
        this.this$0 = documentPickerModule;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Activity) obj, (OnActivityResultPayload) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Activity activity, OnActivityResultPayload onActivityResultPayload) {
        ClipData clipData;
        Intrinsics.checkNotNullParameter(activity, "sender");
        Intrinsics.checkNotNullParameter(onActivityResultPayload, "payload");
        int component1 = onActivityResultPayload.component1();
        int component2 = onActivityResultPayload.component2();
        Intent component3 = onActivityResultPayload.component3();
        if (component1 == 4137 && this.this$0.pendingPromise != null) {
            Promise access$getPendingPromise$p = this.this$0.pendingPromise;
            Intrinsics.checkNotNull(access$getPendingPromise$p);
            if (component2 == -1) {
                if (component3 != null) {
                    try {
                        clipData = component3.getClipData();
                    } catch (CodedException e) {
                        access$getPendingPromise$p.resolve((Object) e);
                    }
                } else {
                    clipData = null;
                }
                if (clipData != null) {
                    this.this$0.handleMultipleSelection(component3);
                } else {
                    this.this$0.handleSingleSelection(component3);
                }
            } else {
                access$getPendingPromise$p.resolve((Object) new DocumentPickerResult(true, (List) null, 2, (DefaultConstructorMarker) null));
            }
            this.this$0.pendingPromise = null;
        }
    }
}
