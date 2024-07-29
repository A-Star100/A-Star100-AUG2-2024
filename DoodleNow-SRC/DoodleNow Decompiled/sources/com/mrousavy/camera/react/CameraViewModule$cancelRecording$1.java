package com.mrousavy.camera.react;

import com.facebook.react.bridge.Promise;
import com.mrousavy.camera.core.CameraError;
import com.mrousavy.camera.core.UnknownCameraError;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "com.mrousavy.camera.react.CameraViewModule$cancelRecording$1", f = "CameraViewModule.kt", i = {}, l = {172}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CameraViewModule.kt */
final class CameraViewModule$cancelRecording$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ int $viewTag;
    int label;
    final /* synthetic */ CameraViewModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraViewModule$cancelRecording$1(CameraViewModule cameraViewModule, int i, Promise promise, Continuation<? super CameraViewModule$cancelRecording$1> continuation) {
        super(2, continuation);
        this.this$0 = cameraViewModule;
        this.$viewTag = i;
        this.$promise = promise;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CameraViewModule$cancelRecording$1(this.this$0, this.$viewTag, this.$promise, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CameraViewModule$cancelRecording$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.findCameraView(this.$viewTag, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CameraView cameraView = (CameraView) obj;
        Promise promise = this.$promise;
        try {
            CameraView_RecordVideoKt.cancelRecording(cameraView);
            promise.resolve((Object) null);
        } catch (Throwable th) {
            th.printStackTrace();
            CameraError unknownCameraError = th instanceof CameraError ? th : new UnknownCameraError(th);
            String domain = unknownCameraError.getDomain();
            String id = unknownCameraError.getId();
            promise.reject(domain + "/" + id, unknownCameraError.getMessage(), unknownCameraError.getCause());
        }
        return Unit.INSTANCE;
    }
}
