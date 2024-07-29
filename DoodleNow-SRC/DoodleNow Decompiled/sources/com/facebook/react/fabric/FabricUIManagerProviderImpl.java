package com.facebook.react.fabric;

import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.systrace.Systrace;

public class FabricUIManagerProviderImpl implements UIManagerProvider {
    private final ComponentFactory mComponentFactory;
    private final ReactNativeConfig mConfig;
    private final ViewManagerRegistry mViewManagerRegistry;

    public FabricUIManagerProviderImpl(ComponentFactory componentFactory, ReactNativeConfig reactNativeConfig, ViewManagerRegistry viewManagerRegistry) {
        this.mComponentFactory = componentFactory;
        this.mConfig = reactNativeConfig;
        this.mViewManagerRegistry = viewManagerRegistry;
    }

    public UIManager createUIManager(ReactApplicationContext reactApplicationContext) {
        Systrace.beginSection(0, "FabricUIManagerProviderImpl.create");
        EventBeatManager eventBeatManager = new EventBeatManager();
        Systrace.beginSection(0, "FabricUIManagerProviderImpl.createUIManager");
        FabricUIManager fabricUIManager = new FabricUIManager(reactApplicationContext, this.mViewManagerRegistry, eventBeatManager);
        Systrace.endSection(0);
        Systrace.beginSection(0, "FabricUIManagerProviderImpl.registerBinding");
        BindingImpl bindingImpl = new BindingImpl();
        CatalystInstance catalystInstance = reactApplicationContext.getCatalystInstance();
        bindingImpl.register(catalystInstance.getRuntimeExecutor(), catalystInstance.getRuntimeScheduler(), fabricUIManager, eventBeatManager, this.mComponentFactory, this.mConfig);
        Systrace.endSection(0);
        Systrace.endSection(0);
        return fabricUIManager;
    }
}
