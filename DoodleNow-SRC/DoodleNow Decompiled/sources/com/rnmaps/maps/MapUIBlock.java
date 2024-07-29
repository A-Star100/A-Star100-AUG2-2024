package com.rnmaps.maps;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.fabric.interop.UIBlockViewResolver;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.function.Function;

public class MapUIBlock implements UIBlockInterface {
    private ReactApplicationContext context;
    private Function<MapView, Void> mapOperation;
    private Promise promise;
    private int tag;

    public MapUIBlock(int i, Promise promise2, ReactApplicationContext reactApplicationContext, Function<MapView, Void> function) {
        this.tag = i;
        this.promise = promise2;
        this.context = reactApplicationContext;
        this.mapOperation = function;
    }

    public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
        executeImpl(nativeViewHierarchyManager, (UIBlockViewResolver) null);
    }

    public void execute(UIBlockViewResolver uIBlockViewResolver) {
        executeImpl((NativeViewHierarchyManager) null, uIBlockViewResolver);
    }

    private void executeImpl(NativeViewHierarchyManager nativeViewHierarchyManager, UIBlockViewResolver uIBlockViewResolver) {
        MapView mapView = (MapView) (uIBlockViewResolver != null ? uIBlockViewResolver.resolveView(this.tag) : nativeViewHierarchyManager.resolveView(this.tag));
        if (mapView == null) {
            this.promise.reject("AirMapView not found");
        } else if (mapView.map == null) {
            this.promise.reject("AirMapView.map is not valid");
        } else {
            Object unused = this.mapOperation.apply(mapView);
        }
    }

    public void addToUIManager() {
        ((UIManagerModule) this.context.getNativeModule(UIManagerModule.class)).addUIBlock(this);
    }
}
