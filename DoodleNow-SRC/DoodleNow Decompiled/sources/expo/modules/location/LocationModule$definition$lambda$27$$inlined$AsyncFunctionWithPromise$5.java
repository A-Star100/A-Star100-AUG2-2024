package expo.modules.location;

import android.content.Context;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.gms.location.LocationRequest;
import expo.modules.kotlin.Promise;
import expo.modules.location.LocationHelpers;
import expo.modules.location.records.LocationOptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u00012\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "<name for destructuring parameter 0>", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$14"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithPromise$5 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ LocationModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationModule$definition$lambda$27$$inlined$AsyncFunctionWithPromise$5(LocationModule locationModule) {
        super(2);
        this.this$0 = locationModule;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Number number = objArr[0];
        LocationOptions locationOptions = objArr[1];
        int intValue = number.intValue();
        if (this.this$0.isMissingForegroundPermissions()) {
            promise.reject(new LocationUnauthorizedException());
            return;
        }
        LocationRequest prepareLocationRequest$expo_location_release = LocationHelpers.Companion.prepareLocationRequest$expo_location_release(locationOptions);
        boolean mayShowUserSettingsDialog = locationOptions.getMayShowUserSettingsDialog();
        LocationHelpers.Companion companion = LocationHelpers.Companion;
        Context access$getMContext$p = this.this$0.mContext;
        if (access$getMContext$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            access$getMContext$p = null;
        }
        if (companion.hasNetworkProviderEnabled(access$getMContext$p) || !mayShowUserSettingsDialog) {
            LocationHelpers.Companion.requestContinuousUpdates(this.this$0, prepareLocationRequest$expo_location_release, intValue, promise);
            return;
        }
        LocationModule locationModule = this.this$0;
        locationModule.addPendingLocationRequest(prepareLocationRequest$expo_location_release, new LocationModule$definition$1$12$1(locationModule, prepareLocationRequest$expo_location_release, intValue, promise));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
