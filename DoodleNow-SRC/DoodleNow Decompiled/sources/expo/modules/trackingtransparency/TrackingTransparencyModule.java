package expo.modules.trackingtransparency;

import android.content.Context;
import androidx.tracing.Trace;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lexpo/modules/trackingtransparency/TrackingTransparencyModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getAdvertisingId", "", "expo-tracking-transparency_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrackingTransparencyModule.kt */
public final class TrackingTransparencyModule extends Module {
    private final Context getContext() {
        Context reactContext = getAppContext().getReactContext();
        if (reactContext != null) {
            return reactContext;
        }
        throw new Exceptions.ReactContextLost();
    }

    public ModuleDefinitionData definition() {
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExpoTrackingTransparency");
            moduleDefinitionBuilder.getSyncFunctions().put("getAdvertisingId", new SyncFunctionComponent("getAdvertisingId", new AnyType[0], new TrackingTransparencyModule$definition$lambda$1$$inlined$FunctionWithoutArgs$1(this)));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    /* access modifiers changed from: private */
    public final String getAdvertisingId() {
        return AdvertisingIdClient.getAdvertisingIdInfo(getContext()).getId();
    }
}
