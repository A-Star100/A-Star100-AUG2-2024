package com.facebook.react.internal.featureflags;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016¨\u0006\u0010"}, d2 = {"Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsDefaults;", "Lcom/facebook/react/internal/featureflags/ReactNativeFeatureFlagsProvider;", "()V", "androidEnablePendingFabricTransactions", "", "batchRenderingUpdatesInEventLoop", "commonTestFlag", "destroyFabricSurfacesInReactInstanceManager", "enableBackgroundExecutor", "enableCustomDrawOrderFabric", "enableFixForClippedSubviewsCrash", "enableMicrotasks", "enableSpannableBuildingUnification", "inspectorEnableCxxInspectorPackagerConnection", "inspectorEnableModernCDPRegistry", "useModernRuntimeScheduler", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReactNativeFeatureFlagsDefaults.kt */
public class ReactNativeFeatureFlagsDefaults implements ReactNativeFeatureFlagsProvider {
    public boolean androidEnablePendingFabricTransactions() {
        return false;
    }

    public boolean batchRenderingUpdatesInEventLoop() {
        return false;
    }

    public boolean commonTestFlag() {
        return false;
    }

    public boolean destroyFabricSurfacesInReactInstanceManager() {
        return false;
    }

    public boolean enableBackgroundExecutor() {
        return false;
    }

    public boolean enableCustomDrawOrderFabric() {
        return false;
    }

    public boolean enableFixForClippedSubviewsCrash() {
        return false;
    }

    public boolean enableMicrotasks() {
        return false;
    }

    public boolean enableSpannableBuildingUnification() {
        return false;
    }

    public boolean inspectorEnableCxxInspectorPackagerConnection() {
        return false;
    }

    public boolean inspectorEnableModernCDPRegistry() {
        return false;
    }

    public boolean useModernRuntimeScheduler() {
        return false;
    }
}
