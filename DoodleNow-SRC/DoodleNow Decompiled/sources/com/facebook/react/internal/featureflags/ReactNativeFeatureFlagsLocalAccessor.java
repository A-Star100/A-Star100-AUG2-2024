package com.facebook.react.internal.featureflags;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0007H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016J\b\u0010\u001d\u001a\u00020\u0007H\u0016J\b\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u0007H\u0016J\b\u0010!\u001a\u00020\u0007H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J\u0010\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\fH\u0016J\b\u0010%\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\n\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0004\n\u0002\u0010\b¨\u0006&"}, d2 = {"Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsLocalAccessor;", "Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsAccessor;", "()V", "accessedFeatureFlags", "", "", "androidEnablePendingFabricTransactionsCache", "", "Ljava/lang/Boolean;", "batchRenderingUpdatesInEventLoopCache", "commonTestFlagCache", "currentProvider", "Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsProvider;", "destroyFabricSurfacesInReactInstanceManagerCache", "enableBackgroundExecutorCache", "enableCustomDrawOrderFabricCache", "enableFixForClippedSubviewsCrashCache", "enableMicrotasksCache", "enableSpannableBuildingUnificationCache", "inspectorEnableCxxInspectorPackagerConnectionCache", "inspectorEnableModernCDPRegistryCache", "useModernRuntimeSchedulerCache", "androidEnablePendingFabricTransactions", "batchRenderingUpdatesInEventLoop", "commonTestFlag", "dangerouslyReset", "", "destroyFabricSurfacesInReactInstanceManager", "enableBackgroundExecutor", "enableCustomDrawOrderFabric", "enableFixForClippedSubviewsCrash", "enableMicrotasks", "enableSpannableBuildingUnification", "inspectorEnableCxxInspectorPackagerConnection", "inspectorEnableModernCDPRegistry", "override", "provider", "useModernRuntimeScheduler", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReactNativeFeatureFlagsLocalAccessor.kt */
public final class ReactNativeFeatureFlagsLocalAccessor implements ReactNativeFeatureFlagsAccessor {
    private final Set<String> accessedFeatureFlags = new LinkedHashSet();
    private Boolean androidEnablePendingFabricTransactionsCache;
    private Boolean batchRenderingUpdatesInEventLoopCache;
    private Boolean commonTestFlagCache;
    private ReactNativeFeatureFlagsProvider currentProvider = new ReactNativeFeatureFlagsDefaults();
    private Boolean destroyFabricSurfacesInReactInstanceManagerCache;
    private Boolean enableBackgroundExecutorCache;
    private Boolean enableCustomDrawOrderFabricCache;
    private Boolean enableFixForClippedSubviewsCrashCache;
    private Boolean enableMicrotasksCache;
    private Boolean enableSpannableBuildingUnificationCache;
    private Boolean inspectorEnableCxxInspectorPackagerConnectionCache;
    private Boolean inspectorEnableModernCDPRegistryCache;
    private Boolean useModernRuntimeSchedulerCache;

    public void dangerouslyReset() {
    }

    public boolean commonTestFlag() {
        Boolean bool = this.commonTestFlagCache;
        if (bool == null) {
            bool = Boolean.valueOf(this.currentProvider.commonTestFlag());
            this.accessedFeatureFlags.add("commonTestFlag");
            this.commonTestFlagCache = bool;
        }
        return bool.booleanValue();
    }

    public boolean androidEnablePendingFabricTransactions() {
        Boolean bool = this.androidEnablePendingFabricTransactionsCache;
        if (bool == null) {
            bool = Boolean.valueOf(this.currentProvider.androidEnablePendingFabricTransactions());
            this.accessedFeatureFlags.add("androidEnablePendingFabricTransactions");
            this.androidEnablePendingFabricTransactionsCache = bool;
        }
        return bool.booleanValue();
    }

    public boolean batchRenderingUpdatesInEventLoop() {
        Boolean bool = this.batchRenderingUpdatesInEventLoopCache;
        if (bool == null) {
            bool = Boolean.valueOf(this.currentProvider.batchRenderingUpdatesInEventLoop());
            this.accessedFeatureFlags.add("batchRenderingUpdatesInEventLoop");
            this.batchRenderingUpdatesInEventLoopCache = bool;
        }
        return bool.booleanValue();
    }

    public boolean destroyFabricSurfacesInReactInstanceManager() {
        Boolean bool = this.destroyFabricSurfacesInReactInstanceManagerCache;
        if (bool == null) {
            bool = Boolean.valueOf(this.currentProvider.destroyFabricSurfacesInReactInstanceManager());
            this.accessedFeatureFlags.add("destroyFabricSurfacesInReactInstanceManager");
            this.destroyFabricSurfacesInReactInstanceManagerCache = bool;
        }
        return bool.booleanValue();
    }

    public boolean enableBackgroundExecutor() {
        Boolean bool = this.enableBackgroundExecutorCache;
        if (bool == null) {
            bool = Boolean.valueOf(this.currentProvider.enableBackgroundExecutor());
            this.accessedFeatureFlags.add("enableBackgroundExecutor");
            this.enableBackgroundExecutorCache = bool;
        }
        return bool.booleanValue();
    }

    public boolean useModernRuntimeScheduler() {
        Boolean bool = this.useModernRuntimeSchedulerCache;
        if (bool == null) {
            bool = Boolean.valueOf(this.currentProvider.useModernRuntimeScheduler());
            this.accessedFeatureFlags.add("useModernRuntimeScheduler");
            this.useModernRuntimeSchedulerCache = bool;
        }
        return bool.booleanValue();
    }

    public boolean enableMicrotasks() {
        Boolean bool = this.enableMicrotasksCache;
        if (bool == null) {
            bool = Boolean.valueOf(this.currentProvider.enableMicrotasks());
            this.accessedFeatureFlags.add("enableMicrotasks");
            this.enableMicrotasksCache = bool;
        }
        return bool.booleanValue();
    }

    public boolean enableSpannableBuildingUnification() {
        Boolean bool = this.enableSpannableBuildingUnificationCache;
        if (bool == null) {
            bool = Boolean.valueOf(this.currentProvider.enableSpannableBuildingUnification());
            this.accessedFeatureFlags.add("enableSpannableBuildingUnification");
            this.enableSpannableBuildingUnificationCache = bool;
        }
        return bool.booleanValue();
    }

    public boolean enableCustomDrawOrderFabric() {
        Boolean bool = this.enableCustomDrawOrderFabricCache;
        if (bool == null) {
            bool = Boolean.valueOf(this.currentProvider.enableCustomDrawOrderFabric());
            this.accessedFeatureFlags.add("enableCustomDrawOrderFabric");
            this.enableCustomDrawOrderFabricCache = bool;
        }
        return bool.booleanValue();
    }

    public boolean enableFixForClippedSubviewsCrash() {
        Boolean bool = this.enableFixForClippedSubviewsCrashCache;
        if (bool == null) {
            bool = Boolean.valueOf(this.currentProvider.enableFixForClippedSubviewsCrash());
            this.accessedFeatureFlags.add("enableFixForClippedSubviewsCrash");
            this.enableFixForClippedSubviewsCrashCache = bool;
        }
        return bool.booleanValue();
    }

    public boolean inspectorEnableCxxInspectorPackagerConnection() {
        Boolean bool = this.inspectorEnableCxxInspectorPackagerConnectionCache;
        if (bool == null) {
            bool = Boolean.valueOf(this.currentProvider.inspectorEnableCxxInspectorPackagerConnection());
            this.accessedFeatureFlags.add("inspectorEnableCxxInspectorPackagerConnection");
            this.inspectorEnableCxxInspectorPackagerConnectionCache = bool;
        }
        return bool.booleanValue();
    }

    public boolean inspectorEnableModernCDPRegistry() {
        Boolean bool = this.inspectorEnableModernCDPRegistryCache;
        if (bool == null) {
            bool = Boolean.valueOf(this.currentProvider.inspectorEnableModernCDPRegistry());
            this.accessedFeatureFlags.add("inspectorEnableModernCDPRegistry");
            this.inspectorEnableModernCDPRegistryCache = bool;
        }
        return bool.booleanValue();
    }

    public void override(ReactNativeFeatureFlagsProvider reactNativeFeatureFlagsProvider) {
        Intrinsics.checkNotNullParameter(reactNativeFeatureFlagsProvider, "provider");
        if (!(!this.accessedFeatureFlags.isEmpty())) {
            this.currentProvider = reactNativeFeatureFlagsProvider;
            return;
        }
        String joinToString$default = CollectionsKt.joinToString$default(this.accessedFeatureFlags, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, ReactNativeFeatureFlagsLocalAccessor$override$accessedFeatureFlagsStr$1.INSTANCE, 30, (Object) null);
        throw new IllegalStateException("Feature flags were accessed before being overridden: " + joinToString$default);
    }
}
