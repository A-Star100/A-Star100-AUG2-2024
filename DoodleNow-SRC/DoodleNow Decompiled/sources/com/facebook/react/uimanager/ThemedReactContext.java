package com.facebook.react.uimanager;

import android.app.Activity;
import android.content.Context;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;

public class ThemedReactContext extends ReactContext {
    private final String mModuleName;
    private final ReactApplicationContext mReactApplicationContext;
    private final int mSurfaceId;

    public String getModuleName() {
        return this.mModuleName;
    }

    public ReactApplicationContext getReactApplicationContext() {
        return this.mReactApplicationContext;
    }

    @Deprecated
    public String getSurfaceID() {
        return this.mModuleName;
    }

    public int getSurfaceId() {
        return this.mSurfaceId;
    }

    @Deprecated
    public ThemedReactContext(ReactApplicationContext reactApplicationContext, Context context) {
        this(reactApplicationContext, context, (String) null, -1);
    }

    @Deprecated
    public ThemedReactContext(ReactApplicationContext reactApplicationContext, Context context, String str) {
        this(reactApplicationContext, context, str, -1);
    }

    public ThemedReactContext(ReactApplicationContext reactApplicationContext, Context context, String str, int i) {
        super(context);
        if (reactApplicationContext.hasCatalystInstance()) {
            initializeWithInstance(reactApplicationContext.getCatalystInstance());
        }
        initializeInteropModules(reactApplicationContext);
        this.mReactApplicationContext = reactApplicationContext;
        this.mModuleName = str;
        this.mSurfaceId = i;
    }

    public void addLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.mReactApplicationContext.addLifecycleEventListener(lifecycleEventListener);
    }

    public void removeLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        this.mReactApplicationContext.removeLifecycleEventListener(lifecycleEventListener);
    }

    public boolean hasCurrentActivity() {
        return this.mReactApplicationContext.hasCurrentActivity();
    }

    public Activity getCurrentActivity() {
        return this.mReactApplicationContext.getCurrentActivity();
    }

    public boolean isBridgeless() {
        return this.mReactApplicationContext.isBridgeless();
    }

    public UIManager getFabricUIManager() {
        if (isBridgeless()) {
            return this.mReactApplicationContext.getFabricUIManager();
        }
        return super.getFabricUIManager();
    }
}
