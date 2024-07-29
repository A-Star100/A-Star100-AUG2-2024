package expo.modules.location;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "expo/modules/kotlin/modules/ModuleDefinitionBuilder$OnCreate$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ModuleDefinitionBuilder.kt */
public final class LocationModule$definition$lambda$27$$inlined$OnCreate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ LocationModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LocationModule$definition$lambda$27$$inlined$OnCreate$1(LocationModule locationModule) {
        super(0);
        this.this$0 = locationModule;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: android.hardware.SensorManager} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r5 = this;
            expo.modules.location.LocationModule r0 = r5.this$0
            expo.modules.kotlin.AppContext r1 = r0.getAppContext()
            android.content.Context r1 = r1.getReactContext()
            if (r1 == 0) goto L_0x008d
            r0.mContext = r1
            expo.modules.location.LocationModule r0 = r5.this$0
            expo.modules.kotlin.AppContext r1 = r0.getAppContext()
            r2 = 0
            expo.modules.core.ModuleRegistry r1 = r1.getLegacyModuleRegistry()     // Catch:{ Exception -> 0x0021 }
            java.lang.Class<expo.modules.core.interfaces.services.UIManager> r3 = expo.modules.core.interfaces.services.UIManager.class
            java.lang.Object r1 = r1.getModule(r3)     // Catch:{ Exception -> 0x0021 }
            goto L_0x0022
        L_0x0021:
            r1 = r2
        L_0x0022:
            expo.modules.core.interfaces.services.UIManager r1 = (expo.modules.core.interfaces.services.UIManager) r1
            if (r1 == 0) goto L_0x0087
            r0.mUIManager = r1
            expo.modules.location.LocationModule r0 = r5.this$0
            expo.modules.kotlin.AppContext r1 = r0.getAppContext()
            expo.modules.core.ModuleRegistry r1 = r1.getLegacyModuleRegistry()     // Catch:{ Exception -> 0x003a }
            java.lang.Class<expo.modules.core.interfaces.ActivityProvider> r3 = expo.modules.core.interfaces.ActivityProvider.class
            java.lang.Object r1 = r1.getModule(r3)     // Catch:{ Exception -> 0x003a }
            goto L_0x003b
        L_0x003a:
            r1 = r2
        L_0x003b:
            expo.modules.core.interfaces.ActivityProvider r1 = (expo.modules.core.interfaces.ActivityProvider) r1
            if (r1 == 0) goto L_0x0081
            r0.mActivityProvider = r1
            expo.modules.location.LocationModule r0 = r5.this$0
            android.content.Context r1 = r0.mContext
            java.lang.String r3 = "mContext"
            if (r1 != 0) goto L_0x0050
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r1 = r2
        L_0x0050:
            com.google.android.gms.location.FusedLocationProviderClient r1 = com.google.android.gms.location.LocationServices.getFusedLocationProviderClient((android.content.Context) r1)
            java.lang.String r4 = "getFusedLocationProviderClient(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            r0.mLocationProvider = r1
            expo.modules.location.LocationModule r0 = r5.this$0
            android.content.Context r1 = r0.mContext
            if (r1 != 0) goto L_0x0068
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            r1 = r2
        L_0x0068:
            java.lang.String r3 = "sensor"
            java.lang.Object r1 = r1.getSystemService(r3)
            boolean r3 = r1 instanceof android.hardware.SensorManager
            if (r3 == 0) goto L_0x0075
            r2 = r1
            android.hardware.SensorManager r2 = (android.hardware.SensorManager) r2
        L_0x0075:
            if (r2 == 0) goto L_0x007b
            r0.mSensorManager = r2
            return
        L_0x007b:
            expo.modules.location.SensorManagerUnavailable r0 = new expo.modules.location.SensorManagerUnavailable
            r0.<init>()
            throw r0
        L_0x0081:
            expo.modules.location.MissingActivityManagerException r0 = new expo.modules.location.MissingActivityManagerException
            r0.<init>()
            throw r0
        L_0x0087:
            expo.modules.location.MissingUIManagerException r0 = new expo.modules.location.MissingUIManagerException
            r0.<init>()
            throw r0
        L_0x008d:
            expo.modules.kotlin.exception.Exceptions$ReactContextLost r0 = new expo.modules.kotlin.exception.Exceptions$ReactContextLost
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.location.LocationModule$definition$lambda$27$$inlined$OnCreate$1.invoke():void");
    }
}
