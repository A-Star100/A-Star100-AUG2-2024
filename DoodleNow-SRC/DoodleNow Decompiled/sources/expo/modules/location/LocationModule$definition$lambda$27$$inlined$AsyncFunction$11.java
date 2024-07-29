package expo.modules.location;

import expo.modules.location.records.LocationTaskOptions;
import expo.modules.location.taskConsumers.LocationTaskConsumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u0001\"\u0006\b\u0002\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u0005H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "R", "P0", "P1", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$8"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class LocationModule$definition$lambda$27$$inlined$AsyncFunction$11 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ LocationModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationModule$definition$lambda$27$$inlined$AsyncFunction$11(LocationModule locationModule) {
        super(1);
        this.this$0 = locationModule;
    }

    public final Unit invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        boolean z = false;
        String str = objArr[0];
        LocationTaskOptions locationTaskOptions = objArr[1];
        String str2 = str;
        if (locationTaskOptions.getForegroundService() != null) {
            z = true;
        }
        if (this.this$0.isMissingForegroundPermissions()) {
            throw new LocationBackgroundUnauthorizedException();
        } else if (!z && this.this$0.isMissingBackgroundPermissions()) {
            throw new LocationBackgroundUnauthorizedException();
        } else if (!AppForegroundedSingleton.INSTANCE.isForegrounded() && locationTaskOptions.getForegroundService() != null) {
            throw new ForegroundServiceStartNotAllowedException();
        } else if (this.this$0.hasForegroundServicePermissions()) {
            this.this$0.getMTaskManager().registerTask(str2, LocationTaskConsumer.class, locationTaskOptions.toMutableMap$expo_location_release());
            return Unit.INSTANCE;
        } else {
            throw new ForegroundServicePermissionsException();
        }
    }
}
