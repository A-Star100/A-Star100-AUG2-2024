package com.rnmaps.maps;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class MapCalloutManager extends ViewGroupManager<MapCallout> {
    public String getName() {
        return "AIRMapCallout";
    }

    public MapCallout createViewInstance(ThemedReactContext themedReactContext) {
        return new MapCallout(themedReactContext);
    }

    @ReactProp(defaultBoolean = false, name = "tooltip")
    public void setTooltip(MapCallout mapCallout, boolean z) {
        mapCallout.setTooltip(z);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"));
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }

    public void updateExtraData(MapCallout mapCallout, Object obj) {
        Map map = (Map) obj;
        float floatValue = ((Float) map.get("width")).floatValue();
        float floatValue2 = ((Float) map.get("height")).floatValue();
        mapCallout.width = (int) floatValue;
        mapCallout.height = (int) floatValue2;
    }
}
