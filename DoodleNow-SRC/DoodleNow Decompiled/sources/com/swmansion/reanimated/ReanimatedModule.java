package com.swmansion.reanimated;

import android.util.Log;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerListener;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModuleListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

@ReactModule(name = "ReanimatedModule")
public class ReanimatedModule extends NativeReanimatedModuleSpec implements LifecycleEventListener, UIManagerModuleListener, UIManagerListener {
    public static final String NAME = "ReanimatedModule";
    @Nullable
    private NodesManager mNodesManager;
    private ArrayList<UIThreadOperation> mOperations = new ArrayList<>();

    private interface UIThreadOperation {
        void execute(NodesManager nodesManager);
    }

    @ReactMethod
    public void addListener(String str) {
    }

    public void didDispatchMountItems(UIManager uIManager) {
    }

    public void didMountItems(UIManager uIManager) {
    }

    public void didScheduleMountItems(UIManager uIManager) {
    }

    public String getName() {
        return "ReanimatedModule";
    }

    public void onHostDestroy() {
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public void willMountItems(UIManager uIManager) {
    }

    public void willDispatchViewUpdates(UIManager uIManager) {
        if (!this.mOperations.isEmpty()) {
            ArrayList<UIThreadOperation> arrayList = this.mOperations;
            this.mOperations = new ArrayList<>();
            if (uIManager instanceof FabricUIManager) {
                ((FabricUIManager) uIManager).addUIBlock(new ReanimatedModule$$ExternalSyntheticLambda0(this, arrayList));
                return;
            }
            throw new RuntimeException("[Reanimated] Failed to obtain instance of FabricUIManager.");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$willDispatchViewUpdates$0(ArrayList arrayList, UIBlockViewResolver uIBlockViewResolver) {
        NodesManager nodesManager = getNodesManager();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((UIThreadOperation) it.next()).execute(nodesManager);
        }
    }

    public ReanimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public void initialize() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        ((UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class)).addUIManagerListener(this);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    public void onHostPause() {
        NodesManager nodesManager = this.mNodesManager;
        if (nodesManager != null) {
            nodesManager.onHostPause();
        }
    }

    public void onHostResume() {
        NodesManager nodesManager = this.mNodesManager;
        if (nodesManager != null) {
            nodesManager.onHostResume();
        }
    }

    public void willDispatchViewUpdates(UIManagerModule uIManagerModule) {
        if (!this.mOperations.isEmpty()) {
            ArrayList<UIThreadOperation> arrayList = this.mOperations;
            this.mOperations = new ArrayList<>();
            uIManagerModule.addUIBlock(new ReanimatedModule$$ExternalSyntheticLambda1(this, arrayList));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$willDispatchViewUpdates$1(ArrayList arrayList, NativeViewHierarchyManager nativeViewHierarchyManager) {
        NodesManager nodesManager = getNodesManager();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((UIThreadOperation) it.next()).execute(nodesManager);
        }
    }

    public NodesManager getNodesManager() {
        if (this.mNodesManager == null) {
            this.mNodesManager = new NodesManager(getReactApplicationContext());
        }
        return this.mNodesManager;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean installTurboModule(String str) {
        Utils.isChromeDebugger = getReactApplicationContext().getJavaScriptContextHolder().get() == 0;
        if (!Utils.isChromeDebugger) {
            getNodesManager().initWithContext(getReactApplicationContext(), str);
            return true;
        }
        Log.w("[REANIMATED]", "Unable to create Reanimated Native Module. You can ignore this message if you are using Chrome Debugger now.");
        return false;
    }

    public void invalidate() {
        super.invalidate();
        NodesManager nodesManager = this.mNodesManager;
        if (nodesManager != null) {
            nodesManager.invalidate();
        }
    }
}
