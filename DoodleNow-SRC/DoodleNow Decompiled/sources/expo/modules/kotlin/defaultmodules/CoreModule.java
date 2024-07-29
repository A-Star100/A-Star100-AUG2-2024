package expo.modules.kotlin.defaultmodules;

import androidx.tracing.Trace;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/kotlin/defaultmodules/CoreModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CoreModule.kt */
public final class CoreModule extends Module {
    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunctionComponent;
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.getSyncFunctions().put("uuidv4", new SyncFunctionComponent("uuidv4", new AnyType[0], new CoreModule$definition$lambda$8$$inlined$FunctionWithoutArgs$1()));
            Class<String> cls = String.class;
            Class<String> cls2 = String.class;
            moduleDefinitionBuilder.getSyncFunctions().put("uuidv5", new SyncFunctionComponent("uuidv5", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, CoreModule$definition$lambda$8$$inlined$Function$1.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, CoreModule$definition$lambda$8$$inlined$Function$2.INSTANCE))}, new CoreModule$definition$lambda$8$$inlined$Function$3()));
            Class<String> cls3 = String.class;
            moduleDefinitionBuilder.getSyncFunctions().put("getViewConfig", new SyncFunctionComponent("getViewConfig", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, CoreModule$definition$lambda$8$$inlined$Function$4.INSTANCE))}, new CoreModule$definition$lambda$8$$inlined$Function$5(this)));
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) String.class, (Object) Promise.class)) {
                asyncFunction = new AsyncFunctionWithPromiseComponent("reloadAppAsync", new AnyType[0], new CoreModule$definition$lambda$8$$inlined$AsyncFunction$1(this));
            } else {
                Class<String> cls4 = String.class;
                AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, CoreModule$definition$lambda$8$$inlined$AsyncFunction$2.INSTANCE))};
                Function1 coreModule$definition$lambda$8$$inlined$AsyncFunction$3 = new CoreModule$definition$lambda$8$$inlined$AsyncFunction$3(this);
                Class<Unit> cls5 = Unit.class;
                if (Intrinsics.areEqual((Object) cls5, (Object) Integer.TYPE)) {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("reloadAppAsync", anyTypeArr, coreModule$definition$lambda$8$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls5, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("reloadAppAsync", anyTypeArr, coreModule$definition$lambda$8$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls5, (Object) Double.TYPE)) {
                    asyncFunctionComponent = new DoubleAsyncFunctionComponent("reloadAppAsync", anyTypeArr, coreModule$definition$lambda$8$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls5, (Object) Float.TYPE)) {
                    asyncFunctionComponent = new FloatAsyncFunctionComponent("reloadAppAsync", anyTypeArr, coreModule$definition$lambda$8$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls5, (Object) String.class)) {
                    asyncFunctionComponent = new StringAsyncFunctionComponent("reloadAppAsync", anyTypeArr, coreModule$definition$lambda$8$$inlined$AsyncFunction$3);
                } else {
                    asyncFunctionComponent = new AsyncFunctionComponent("reloadAppAsync", anyTypeArr, coreModule$definition$lambda$8$$inlined$AsyncFunction$3);
                }
                asyncFunction = asyncFunctionComponent;
            }
            objectDefinitionBuilder.getAsyncFunctions().put("reloadAppAsync", asyncFunction);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
