package expo.modules.kotlin.defaultmodules;

import androidx.tracing.Trace;
import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/defaultmodules/NativeModulesProxyModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: NativeModulesProxyModule.kt */
public final class NativeModulesProxyModule extends Module {
    public ModuleDefinitionData definition() {
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name(NativeModulesProxyModuleKt.NativeModulesProxyModuleName);
            moduleDefinitionBuilder.Constants((Function0<? extends Map<String, ? extends Object>>) new NativeModulesProxyModule$definition$1$1(this));
            Class<String> cls = String.class;
            Class<String> cls2 = String.class;
            Class<ReadableArray> cls3 = ReadableArray.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("callMethod", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunctionWithPromise$1.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunctionWithPromise$2.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ReadableArray.class), false, NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunctionWithPromise$3.INSTANCE))}, new NativeModulesProxyModule$definition$lambda$1$$inlined$AsyncFunctionWithPromise$4(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("callMethod", asyncFunctionWithPromiseComponent);
            AsyncFunction asyncFunction = asyncFunctionWithPromiseComponent;
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
