package com.rnmaps.maps;

import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public class RegionChangeEvent extends Event<RegionChangeEvent> {
    private final LatLngBounds bounds;
    private final boolean continuous;
    private final boolean isGesture;

    public boolean canCoalesce() {
        return false;
    }

    public String getEventName() {
        return "topChange";
    }

    public RegionChangeEvent(int i, LatLngBounds latLngBounds, boolean z, boolean z2) {
        super(i);
        this.bounds = latLngBounds;
        this.continuous = z;
        this.isGesture = z2;
    }

    public void dispatch(RCTEventEmitter rCTEventEmitter) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putBoolean("continuous", this.continuous);
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        LatLng center = this.bounds.getCenter();
        writableNativeMap2.putDouble("latitude", center.latitude);
        writableNativeMap2.putDouble("longitude", center.longitude);
        writableNativeMap2.putDouble("latitudeDelta", this.bounds.northeast.latitude - this.bounds.southwest.latitude);
        writableNativeMap2.putDouble("longitudeDelta", this.bounds.northeast.longitude - this.bounds.southwest.longitude);
        writableNativeMap.putMap("region", writableNativeMap2);
        writableNativeMap.putBoolean("isGesture", this.isGesture);
        rCTEventEmitter.receiveEvent(getViewTag(), getEventName(), writableNativeMap);
    }
}
