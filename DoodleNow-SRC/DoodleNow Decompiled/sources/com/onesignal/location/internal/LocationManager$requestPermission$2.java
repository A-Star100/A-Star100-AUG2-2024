package com.onesignal.location.internal;

import android.os.Build;
import com.onesignal.common.AndroidUtils;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.location.internal.common.LocationConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.location.internal.LocationManager$requestPermission$2", f = "LocationManager.kt", i = {}, l = {109, 150, 155, 158}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LocationManager.kt */
final class LocationManager$requestPermission$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ Ref.BooleanRef $result;
    Object L$0;
    int label;
    final /* synthetic */ LocationManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationManager$requestPermission$2(LocationManager locationManager, Ref.BooleanRef booleanRef, Continuation<? super LocationManager$requestPermission$2> continuation) {
        super(2, continuation);
        this.this$0 = locationManager;
        this.$result = booleanRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocationManager$requestPermission$2(this.this$0, this.$result, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((LocationManager$requestPermission$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Ref.BooleanRef booleanRef;
        Ref.BooleanRef booleanRef2;
        Ref.BooleanRef booleanRef3;
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z2 = true;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                this.$result.element = true;
            } else if (i == 2) {
                booleanRef3 = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else if (i == 3) {
                booleanRef = (Ref.BooleanRef) this.L$0;
                ResultKt.throwOnFailure(obj);
                booleanRef.element = ((Boolean) obj).booleanValue();
            } else if (i == 4) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        String str = null;
        if (!this.this$0.isShared()) {
            Logging.warn$default("Requesting location permission, but location sharing must also be enabled by setting isShared to true", (Throwable) null, 2, (Object) null);
        }
        boolean hasPermission = AndroidUtils.INSTANCE.hasPermission(LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING, true, this.this$0._applicationService);
        if (!hasPermission) {
            z = AndroidUtils.INSTANCE.hasPermission(LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING, true, this.this$0._applicationService);
            this.this$0._capturer.setLocationCoarse(true);
        } else {
            z = false;
        }
        boolean hasPermission2 = Build.VERSION.SDK_INT >= 29 ? AndroidUtils.INSTANCE.hasPermission(LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING, true, this.this$0._applicationService) : false;
        if (!hasPermission) {
            String str2 = null;
            List<String> filterManifestPermissions = AndroidUtils.INSTANCE.filterManifestPermissions(CollectionsKt.listOf(LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING, LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING, LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING), this.this$0._applicationService);
            if (filterManifestPermissions.contains(LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING)) {
                str = LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING;
            } else if (!filterManifestPermissions.contains(LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING)) {
                Logging.info$default("Location permissions not added on AndroidManifest file >= M", (Throwable) null, 2, (Object) null);
            } else if (!z) {
                str = LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING;
            } else if (Build.VERSION.SDK_INT >= 29 && filterManifestPermissions.contains(LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING)) {
                str = LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING;
            }
            booleanRef2 = this.$result;
            if (str != null) {
                this.L$0 = booleanRef2;
                this.label = 2;
                Object prompt = this.this$0._locationPermissionController.prompt(true, str, this);
                if (prompt == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef3 = booleanRef2;
                obj = prompt;
            } else {
                if (!z) {
                    z2 = false;
                }
                booleanRef2.element = z2;
                return Unit.INSTANCE;
            }
        } else if (Build.VERSION.SDK_INT < 29 || hasPermission2) {
            this.$result.element = true;
            this.label = 4;
            if (this.this$0.startGetLocation(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } else {
            Ref.BooleanRef booleanRef4 = this.$result;
            this.L$0 = booleanRef4;
            this.label = 3;
            Object access$backgroundLocationPermissionLogic = this.this$0.backgroundLocationPermissionLogic(true, this);
            if (access$backgroundLocationPermissionLogic == coroutine_suspended) {
                return coroutine_suspended;
            }
            booleanRef = booleanRef4;
            obj = access$backgroundLocationPermissionLogic;
            booleanRef.element = ((Boolean) obj).booleanValue();
            return Unit.INSTANCE;
        }
        z2 = ((Boolean) obj).booleanValue();
        booleanRef2 = booleanRef3;
        booleanRef2.element = z2;
        return Unit.INSTANCE;
    }
}
