package expo.modules.location;

import android.os.Build;
import com.onesignal.location.internal.common.LocationConstants;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.location.LocationHelpers;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0002H@¨\u0006\u0005"}, d2 = {"R", "Lkotlinx/coroutines/CoroutineScope;", "", "", "it", "expo/modules/kotlin/functions/AsyncFunctionBuilder$SuspendBody$1", "<anonymous>"}, k = 3, mv = {1, 9, 0})
@DebugMetadata(c = "expo.modules.location.LocationModule$definition$lambda$27$$inlined$Coroutine$1", f = "LocationModule.kt", i = {}, l = {269, 276}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AsyncFunctionBuilder.kt */
public final class LocationModule$definition$lambda$27$$inlined$Coroutine$1 extends SuspendLambda implements Function3<CoroutineScope, Object[], Continuation<? super Object>, Object> {
    int label;
    final /* synthetic */ LocationModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationModule$definition$lambda$27$$inlined$Coroutine$1(Continuation continuation, LocationModule locationModule) {
        super(3, continuation);
        this.this$0 = locationModule;
    }

    public final Object invoke(CoroutineScope coroutineScope, Object[] objArr, Continuation<Object> continuation) {
        return new LocationModule$definition$lambda$27$$inlined$Coroutine$1(continuation, this.this$0).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Continuation continuation = this;
            Permissions permissions = this.this$0.getAppContext().getPermissions();
            if (permissions == null) {
                throw new NoPermissionsModuleException();
            } else if (Build.VERSION.SDK_INT == 29) {
                LocationHelpers.Companion companion = LocationHelpers.Companion;
                String[] strArr = {LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING, LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING, LocationConstants.ANDROID_BACKGROUND_LOCATION_PERMISSION_STRING};
                this.label = 1;
                obj = companion.askForPermissionsWithPermissionsManager$expo_location_release(permissions, strArr, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                LocationHelpers.Companion companion2 = LocationHelpers.Companion;
                String[] strArr2 = {LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING, LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING};
                this.label = 2;
                obj = companion2.askForPermissionsWithPermissionsManager$expo_location_release(permissions, strArr2, this);
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
