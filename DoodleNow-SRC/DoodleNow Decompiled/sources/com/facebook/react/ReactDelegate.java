package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.devsupport.DisabledDevSupportManager;
import com.facebook.react.devsupport.DoubleTapReloadRecognizer;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.interfaces.fabric.ReactSurface;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;

public class ReactDelegate {
    private final Activity mActivity;
    private DoubleTapReloadRecognizer mDoubleTapReloadRecognizer;
    private boolean mFabricEnabled;
    private Bundle mLaunchOptions;
    private final String mMainComponentName;
    private ReactHost mReactHost;
    private ReactNativeHost mReactNativeHost;
    private ReactRootView mReactRootView;
    private ReactSurface mReactSurface;

    private ReactNativeHost getReactNativeHost() {
        return this.mReactNativeHost;
    }

    /* access modifiers changed from: protected */
    public boolean isFabricEnabled() {
        return this.mFabricEnabled;
    }

    @Deprecated
    public ReactDelegate(Activity activity, ReactNativeHost reactNativeHost, String str, Bundle bundle) {
        this.mFabricEnabled = false;
        this.mActivity = activity;
        this.mMainComponentName = str;
        this.mLaunchOptions = bundle;
        this.mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
        this.mReactNativeHost = reactNativeHost;
    }

    public ReactDelegate(Activity activity, ReactHost reactHost, String str, Bundle bundle) {
        this.mFabricEnabled = false;
        this.mActivity = activity;
        this.mMainComponentName = str;
        this.mLaunchOptions = bundle;
        this.mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
        this.mReactHost = reactHost;
    }

    public ReactDelegate(Activity activity, ReactNativeHost reactNativeHost, String str, Bundle bundle, boolean z) {
        this.mFabricEnabled = z;
        this.mActivity = activity;
        this.mMainComponentName = str;
        this.mLaunchOptions = composeLaunchOptions(bundle);
        this.mDoubleTapReloadRecognizer = new DoubleTapReloadRecognizer();
        this.mReactNativeHost = reactNativeHost;
    }

    private DevSupportManager getDevSupportManager() {
        ReactHost reactHost;
        if (ReactFeatureFlags.enableBridgelessArchitecture && (reactHost = this.mReactHost) != null && reactHost.getDevSupportManager() != null) {
            return this.mReactHost.getDevSupportManager();
        }
        if (!getReactNativeHost().hasInstance() || getReactNativeHost().getReactInstanceManager() == null) {
            return null;
        }
        return getReactNativeHost().getReactInstanceManager().getDevSupportManager();
    }

    public void onHostResume() {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            Activity activity = this.mActivity;
            if (activity instanceof DefaultHardwareBackBtnHandler) {
                this.mReactHost.onHostResume(activity, (DefaultHardwareBackBtnHandler) activity);
            }
        } else if (!getReactNativeHost().hasInstance()) {
        } else {
            if (this.mActivity instanceof DefaultHardwareBackBtnHandler) {
                ReactInstanceManager reactInstanceManager = getReactNativeHost().getReactInstanceManager();
                Activity activity2 = this.mActivity;
                reactInstanceManager.onHostResume(activity2, (DefaultHardwareBackBtnHandler) activity2);
                return;
            }
            throw new ClassCastException("Host Activity does not implement DefaultHardwareBackBtnHandler");
        }
    }

    public void onHostPause() {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.mReactHost.onHostPause(this.mActivity);
        } else if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onHostPause(this.mActivity);
        }
    }

    public void onHostDestroy() {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.mReactHost.onHostDestroy(this.mActivity);
            return;
        }
        ReactRootView reactRootView = this.mReactRootView;
        if (reactRootView != null) {
            reactRootView.unmountReactApplication();
            this.mReactRootView = null;
        }
        if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onHostDestroy(this.mActivity);
        }
    }

    public boolean onBackPressed() {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.mReactHost.onBackPressed();
            return true;
        } else if (!getReactNativeHost().hasInstance()) {
            return false;
        } else {
            getReactNativeHost().getReactInstanceManager().onBackPressed();
            return true;
        }
    }

    public boolean onNewIntent(Intent intent) {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.mReactHost.onNewIntent(intent);
            return true;
        } else if (!getReactNativeHost().hasInstance()) {
            return false;
        } else {
            getReactNativeHost().getReactInstanceManager().onNewIntent(intent);
            return true;
        }
    }

    public void onActivityResult(int i, int i2, Intent intent, boolean z) {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.mReactHost.onActivityResult(this.mActivity, i, i2, intent);
        } else if (getReactNativeHost().hasInstance() && z) {
            getReactNativeHost().getReactInstanceManager().onActivityResult(this.mActivity, i, i2, intent);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.mReactHost.onWindowFocusChange(z);
        } else if (getReactNativeHost().hasInstance()) {
            getReactNativeHost().getReactInstanceManager().onWindowFocusChange(z);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            this.mReactHost.onConfigurationChanged((Context) Assertions.assertNotNull(this.mActivity));
        } else if (getReactNativeHost().hasInstance()) {
            getReactInstanceManager().onConfigurationChanged((Context) Assertions.assertNotNull(this.mActivity), configuration);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        ReactHost reactHost;
        if (i != 90) {
            return false;
        }
        if ((!ReactFeatureFlags.enableBridgelessArchitecture || (reactHost = this.mReactHost) == null || reactHost.getDevSupportManager() == null) && (!getReactNativeHost().hasInstance() || !getReactNativeHost().getUseDeveloperSupport())) {
            return false;
        }
        keyEvent.startTracking();
        return true;
    }

    public boolean onKeyLongPress(int i) {
        ReactHost reactHost;
        if (i != 90) {
            return false;
        }
        if (ReactFeatureFlags.enableBridgelessArchitecture && (reactHost = this.mReactHost) != null && reactHost.getDevSupportManager() != null) {
            this.mReactHost.getDevSupportManager().showDevOptionsDialog();
            return true;
        } else if (!getReactNativeHost().hasInstance() || !getReactNativeHost().getUseDeveloperSupport()) {
            return false;
        } else {
            getReactNativeHost().getReactInstanceManager().showDevOptionsDialog();
            return true;
        }
    }

    public void reload() {
        DevSupportManager devSupportManager = getDevSupportManager();
        if (devSupportManager != null) {
            if (!(devSupportManager instanceof DisabledDevSupportManager)) {
                devSupportManager.handleReloadJS();
            } else if (ReactFeatureFlags.enableBridgelessArchitecture) {
                ReactHost reactHost = this.mReactHost;
                if (reactHost != null) {
                    reactHost.reload("ReactDelegate.reload()");
                }
            } else {
                UiThreadUtil.runOnUiThread(new ReactDelegate$$ExternalSyntheticLambda0(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$reload$0() {
        if (this.mReactNativeHost.hasInstance() && this.mReactNativeHost.getReactInstanceManager() != null) {
            this.mReactNativeHost.getReactInstanceManager().recreateReactContextInBackground();
        }
    }

    public void loadApp() {
        loadApp(this.mMainComponentName);
    }

    public void loadApp(String str) {
        if (ReactFeatureFlags.enableBridgelessArchitecture) {
            if (this.mReactSurface == null) {
                ReactSurface createSurface = this.mReactHost.createSurface(this.mActivity, str, this.mLaunchOptions);
                this.mReactSurface = createSurface;
                this.mActivity.setContentView(createSurface.getView());
            }
            this.mReactSurface.start();
        } else if (this.mReactRootView == null) {
            ReactRootView createRootView = createRootView();
            this.mReactRootView = createRootView;
            createRootView.startReactApplication(getReactNativeHost().getReactInstanceManager(), str, this.mLaunchOptions);
        } else {
            throw new IllegalStateException("Cannot loadApp while app is already running.");
        }
    }

    public ReactRootView getReactRootView() {
        return ReactFeatureFlags.enableBridgelessArchitecture ? (ReactRootView) this.mReactSurface.getView() : this.mReactRootView;
    }

    /* access modifiers changed from: protected */
    public ReactRootView createRootView() {
        ReactRootView reactRootView = new ReactRootView(this.mActivity);
        reactRootView.setIsFabric(isFabricEnabled());
        return reactRootView;
    }

    public boolean shouldShowDevMenuOrReload(int i, KeyEvent keyEvent) {
        DevSupportManager devSupportManager = getDevSupportManager();
        if (devSupportManager == null) {
            return false;
        }
        if (i == 82) {
            devSupportManager.showDevOptionsDialog();
            return true;
        } else if (!((DoubleTapReloadRecognizer) Assertions.assertNotNull(this.mDoubleTapReloadRecognizer)).didDoubleTapR(i, this.mActivity.getCurrentFocus())) {
            return false;
        } else {
            devSupportManager.handleReloadJS();
            return true;
        }
    }

    public ReactInstanceManager getReactInstanceManager() {
        return getReactNativeHost().getReactInstanceManager();
    }

    private Bundle composeLaunchOptions(Bundle bundle) {
        return (!isFabricEnabled() || bundle != null) ? bundle : new Bundle();
    }
}
