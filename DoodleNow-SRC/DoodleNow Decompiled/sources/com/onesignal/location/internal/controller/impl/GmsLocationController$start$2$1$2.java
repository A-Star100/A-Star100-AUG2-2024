package com.onesignal.location.internal.controller.impl;

import android.location.Location;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.internal.controller.impl.GmsLocationController;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.location.internal.controller.impl.GmsLocationController$start$2$1$2", f = "GmsLocationController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: GmsLocationController.kt */
final class GmsLocationController$start$2$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<GmsLocationController> $self;
    final /* synthetic */ Ref.BooleanRef $wasSuccessful;
    int label;
    final /* synthetic */ GmsLocationController this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GmsLocationController$start$2$1$2(Ref.ObjectRef<GmsLocationController> objectRef, GmsLocationController gmsLocationController, Ref.BooleanRef booleanRef, Continuation<? super GmsLocationController$start$2$1$2> continuation) {
        super(2, continuation);
        this.$self = objectRef;
        this.this$0 = gmsLocationController;
        this.$wasSuccessful = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new GmsLocationController$start$2$1$2(this.$self, this.this$0, this.$wasSuccessful, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((GmsLocationController$start$2$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Location lastLocation;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            GmsLocationController.GoogleApiClientListener googleApiClientListener = new GmsLocationController.GoogleApiClientListener((GmsLocationController) this.$self.element);
            GoogleApiClient build = new GoogleApiClient.Builder(this.this$0._applicationService.getAppContext()).addApi(LocationServices.API).addConnectionCallbacks(googleApiClientListener).addOnConnectionFailedListener(googleApiClientListener).setHandler(this.this$0.locationHandlerThread.getMHandler()).build();
            Intrinsics.checkNotNullExpressionValue(build, "googleApiClient");
            GoogleApiClientCompatProxy googleApiClientCompatProxy = new GoogleApiClientCompatProxy(build);
            ConnectionResult blockingConnect = googleApiClientCompatProxy.blockingConnect();
            if (blockingConnect == null || !blockingConnect.isSuccess()) {
                StringBuilder sb = new StringBuilder("GMSLocationController connection to GoogleApiService failed: (");
                sb.append(blockingConnect != null ? Boxing.boxInt(blockingConnect.getErrorCode()) : null);
                sb.append(") ");
                sb.append(blockingConnect != null ? blockingConnect.getErrorMessage() : null);
                Logging.debug$default(sb.toString(), (Throwable) null, 2, (Object) null);
            } else {
                if (this.this$0.lastLocation == null && (lastLocation = this.this$0._fusedLocationApiWrapper.getLastLocation(build)) != null) {
                    this.this$0.setLocationAndFire(lastLocation);
                }
                ((GmsLocationController) this.$self.element).locationUpdateListener = new GmsLocationController.LocationUpdateListener(this.this$0._applicationService, (GmsLocationController) this.$self.element, googleApiClientCompatProxy.getRealInstance(), this.this$0._fusedLocationApiWrapper);
                ((GmsLocationController) this.$self.element).googleApiClient = googleApiClientCompatProxy;
                this.$wasSuccessful.element = true;
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
