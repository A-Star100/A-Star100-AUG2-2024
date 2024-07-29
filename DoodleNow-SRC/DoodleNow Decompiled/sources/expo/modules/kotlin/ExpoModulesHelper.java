package expo.modules.kotlin;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lexpo/modules/kotlin/ExpoModulesHelper;", "", "()V", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ExpoModulesHelper.kt */
public final class ExpoModulesHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Lazy<ModulesProvider> modulesProvider$delegate = LazyKt.lazy(ExpoModulesHelper$Companion$modulesProvider$2.INSTANCE);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lexpo/modules/kotlin/ExpoModulesHelper$Companion;", "", "()V", "modulesProvider", "Lexpo/modules/kotlin/ModulesProvider;", "getModulesProvider", "()Lexpo/modules/kotlin/ModulesProvider;", "modulesProvider$delegate", "Lkotlin/Lazy;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ExpoModulesHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ModulesProvider getModulesProvider() {
            return (ModulesProvider) ExpoModulesHelper.modulesProvider$delegate.getValue();
        }
    }
}
