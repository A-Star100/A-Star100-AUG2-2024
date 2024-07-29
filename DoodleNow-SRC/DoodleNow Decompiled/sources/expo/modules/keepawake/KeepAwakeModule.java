package expo.modules.keepawake;

import androidx.tracing.Trace;
import expo.modules.core.interfaces.services.KeepAwakeManager;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lexpo/modules/keepawake/KeepAwakeModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "keepAwakeManager", "Lexpo/modules/core/interfaces/services/KeepAwakeManager;", "getKeepAwakeManager", "()Lexpo/modules/core/interfaces/services/KeepAwakeManager;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-keep-awake_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: KeepAwakeModule.kt */
public final class KeepAwakeModule extends Module {
    /* access modifiers changed from: private */
    public final KeepAwakeManager getKeepAwakeManager() {
        Object obj;
        try {
            obj = getAppContext().getLegacyModuleRegistry().getModule(KeepAwakeManager.class);
        } catch (Exception unused) {
            obj = null;
        }
        KeepAwakeManager keepAwakeManager = (KeepAwakeManager) obj;
        if (keepAwakeManager != null) {
            return keepAwakeManager;
        }
        throw new MissingModuleException("KeepAwakeManager");
    }

    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExpoKeepAwake");
            Class<String> cls = String.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("activate", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$1.INSTANCE))}, new KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$2(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("activate", asyncFunctionWithPromiseComponent);
            AsyncFunction asyncFunction2 = asyncFunctionWithPromiseComponent;
            Class<String> cls2 = String.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("deactivate", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$3.INSTANCE))}, new KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunctionWithPromise$4(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("deactivate", asyncFunctionWithPromiseComponent2);
            AsyncFunction asyncFunction3 = asyncFunctionWithPromiseComponent2;
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            AnyType[] anyTypeArr = new AnyType[0];
            Function1 keepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$1 = new KeepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$1(this);
            Class<Boolean> cls3 = Boolean.class;
            if (Intrinsics.areEqual((Object) cls3, (Object) Integer.TYPE)) {
                asyncFunction = new IntAsyncFunctionComponent("isActivated", anyTypeArr, keepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls3, (Object) Boolean.TYPE)) {
                asyncFunction = new BoolAsyncFunctionComponent("isActivated", anyTypeArr, keepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls3, (Object) Double.TYPE)) {
                asyncFunction = new DoubleAsyncFunctionComponent("isActivated", anyTypeArr, keepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls3, (Object) Float.TYPE)) {
                asyncFunction = new FloatAsyncFunctionComponent("isActivated", anyTypeArr, keepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$1);
            } else if (Intrinsics.areEqual((Object) cls3, (Object) String.class)) {
                asyncFunction = new StringAsyncFunctionComponent("isActivated", anyTypeArr, keepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$1);
            } else {
                asyncFunction = new AsyncFunctionComponent("isActivated", anyTypeArr, keepAwakeModule$definition$lambda$3$$inlined$AsyncFunction$1);
            }
            objectDefinitionBuilder.getAsyncFunctions().put("isActivated", asyncFunction);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
