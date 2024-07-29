package expo.modules.imagepicker;

import expo.modules.imagepicker.contracts.ImageLibraryContractOptions;
import expo.modules.imagepicker.contracts.ImagePickerContractResult;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0018\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lexpo/modules/imagepicker/contracts/ImagePickerContractResult;", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "expo.modules.imagepicker.ImagePickerModule$definition$1$6$1", f = "ImagePickerModule.kt", i = {}, l = {84}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ImagePickerModule.kt */
final class ImagePickerModule$definition$1$6$1 extends SuspendLambda implements Function1<Continuation<? super ImagePickerContractResult>, Object> {
    final /* synthetic */ ImageLibraryContractOptions $contractOptions;
    int label;
    final /* synthetic */ ImagePickerModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImagePickerModule$definition$1$6$1(ImagePickerModule imagePickerModule, ImageLibraryContractOptions imageLibraryContractOptions, Continuation<? super ImagePickerModule$definition$1$6$1> continuation) {
        super(1, continuation);
        this.this$0 = imagePickerModule;
        this.$contractOptions = imageLibraryContractOptions;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ImagePickerModule$definition$1$6$1(this.this$0, this.$contractOptions, continuation);
    }

    public final Object invoke(Continuation<? super ImagePickerContractResult> continuation) {
        return ((ImagePickerModule$definition$1$6$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AppContextActivityResultLauncher access$getImageLibraryLauncher$p = this.this$0.imageLibraryLauncher;
            if (access$getImageLibraryLauncher$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("imageLibraryLauncher");
                access$getImageLibraryLauncher$p = null;
            }
            this.label = 1;
            obj = access$getImageLibraryLauncher$p.launch(this.$contractOptions, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
