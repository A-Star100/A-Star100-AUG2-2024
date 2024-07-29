package com.rnmaps.maps;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.LayoutShadowNode;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapMarkerManager extends ViewGroupManager<MapMarker> {
    private final Map<String, AirMapMarkerSharedIcon> sharedIcons = new ConcurrentHashMap();

    public String getName() {
        return "AIRMapMarker";
    }

    public static class AirMapMarkerSharedIcon {
        private Bitmap bitmap;
        private BitmapDescriptor iconBitmapDescriptor;
        private boolean loadImageStarted = false;
        private final Map<MapMarker, Boolean> markers = new WeakHashMap();

        public synchronized boolean shouldLoadImage() {
            if (this.loadImageStarted) {
                return false;
            }
            this.loadImageStarted = true;
            return true;
        }

        public synchronized void addMarker(MapMarker mapMarker) {
            this.markers.put(mapMarker, true);
            BitmapDescriptor bitmapDescriptor = this.iconBitmapDescriptor;
            if (bitmapDescriptor != null) {
                mapMarker.setIconBitmapDescriptor(bitmapDescriptor, this.bitmap);
            }
        }

        public synchronized void removeMarker(MapMarker mapMarker) {
            this.markers.remove(mapMarker);
        }

        public synchronized boolean hasMarker() {
            return this.markers.isEmpty();
        }

        public synchronized void updateIcon(BitmapDescriptor bitmapDescriptor, Bitmap bitmap2) {
            this.iconBitmapDescriptor = bitmapDescriptor;
            this.bitmap = bitmap2.copy(Bitmap.Config.ARGB_8888, true);
            if (!this.markers.isEmpty()) {
                for (Map.Entry next : this.markers.entrySet()) {
                    if (next.getKey() != null) {
                        ((MapMarker) next.getKey()).setIconBitmapDescriptor(bitmapDescriptor, bitmap2);
                    }
                }
            }
        }
    }

    public AirMapMarkerSharedIcon getSharedIcon(String str) {
        AirMapMarkerSharedIcon airMapMarkerSharedIcon = this.sharedIcons.get(str);
        if (airMapMarkerSharedIcon == null) {
            synchronized (this) {
                airMapMarkerSharedIcon = this.sharedIcons.get(str);
                if (airMapMarkerSharedIcon == null) {
                    airMapMarkerSharedIcon = new AirMapMarkerSharedIcon();
                    this.sharedIcons.put(str, airMapMarkerSharedIcon);
                }
            }
        }
        return airMapMarkerSharedIcon;
    }

    public void removeSharedIconIfEmpty(String str) {
        AirMapMarkerSharedIcon airMapMarkerSharedIcon = this.sharedIcons.get(str);
        if (airMapMarkerSharedIcon != null && !airMapMarkerSharedIcon.hasMarker()) {
            synchronized (this) {
                AirMapMarkerSharedIcon airMapMarkerSharedIcon2 = this.sharedIcons.get(str);
                if (airMapMarkerSharedIcon2 != null && !airMapMarkerSharedIcon2.hasMarker()) {
                    this.sharedIcons.remove(str);
                }
            }
        }
    }

    public MapMarker createViewInstance(ThemedReactContext themedReactContext) {
        return new MapMarker(themedReactContext, this);
    }

    @ReactProp(name = "coordinate")
    public void setCoordinate(MapMarker mapMarker, ReadableMap readableMap) {
        mapMarker.setCoordinate(readableMap);
    }

    @ReactProp(name = "title")
    public void setTitle(MapMarker mapMarker, String str) {
        mapMarker.setTitle(str);
    }

    @ReactProp(name = "identifier")
    public void setIdentifier(MapMarker mapMarker, String str) {
        mapMarker.setIdentifier(str);
    }

    @ReactProp(name = "description")
    public void setDescription(MapMarker mapMarker, String str) {
        mapMarker.setSnippet(str);
    }

    @ReactProp(name = "anchor")
    public void setAnchor(MapMarker mapMarker, ReadableMap readableMap) {
        mapMarker.setAnchor((readableMap == null || !readableMap.hasKey("x")) ? 0.5d : readableMap.getDouble("x"), (readableMap == null || !readableMap.hasKey("y")) ? 1.0d : readableMap.getDouble("y"));
    }

    @ReactProp(name = "calloutAnchor")
    public void setCalloutAnchor(MapMarker mapMarker, ReadableMap readableMap) {
        mapMarker.setCalloutAnchor((readableMap == null || !readableMap.hasKey("x")) ? 0.5d : readableMap.getDouble("x"), (readableMap == null || !readableMap.hasKey("y")) ? AudioStats.AUDIO_AMPLITUDE_NONE : readableMap.getDouble("y"));
    }

    @ReactProp(name = "image")
    public void setImage(MapMarker mapMarker, String str) {
        mapMarker.setImage(str);
    }

    @ReactProp(name = "icon")
    public void setIcon(MapMarker mapMarker, String str) {
        mapMarker.setImage(str);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "pinColor")
    public void setPinColor(MapMarker mapMarker, int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        mapMarker.setMarkerHue(fArr[0]);
    }

    @ReactProp(defaultFloat = 0.0f, name = "rotation")
    public void setMarkerRotation(MapMarker mapMarker, float f) {
        mapMarker.setRotation(f);
    }

    @ReactProp(defaultBoolean = false, name = "flat")
    public void setFlat(MapMarker mapMarker, boolean z) {
        mapMarker.setFlat(z);
    }

    @ReactProp(defaultBoolean = false, name = "draggable")
    public void setDraggable(MapMarker mapMarker, boolean z) {
        mapMarker.setDraggable(z);
    }

    @ReactProp(defaultFloat = 0.0f, name = "zIndex")
    public void setZIndex(MapMarker mapMarker, float f) {
        super.setZIndex(mapMarker, f);
        mapMarker.setZIndex(Math.round(f));
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(MapMarker mapMarker, float f) {
        super.setOpacity(mapMarker, f);
        mapMarker.setOpacity(f);
    }

    @ReactProp(defaultBoolean = true, name = "tracksViewChanges")
    public void setTracksViewChanges(MapMarker mapMarker, boolean z) {
        mapMarker.setTracksViewChanges(z);
    }

    public void addView(MapMarker mapMarker, View view, int i) {
        if (view instanceof MapCallout) {
            mapMarker.setCalloutView((MapCallout) view);
            return;
        }
        super.addView(mapMarker, view, i);
        mapMarker.update(true);
    }

    public void removeViewAt(MapMarker mapMarker, int i) {
        super.removeViewAt(mapMarker, i);
        mapMarker.update(true);
    }

    public void receiveCommand(MapMarker mapMarker, String str, ReadableArray readableArray) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1868137362:
                if (str.equals("animateMarkerToCoordinate")) {
                    c = 0;
                    break;
                }
                break;
            case -934876681:
                if (str.equals("redraw")) {
                    c = 1;
                    break;
                }
                break;
            case 428235918:
                if (str.equals("hideCallout")) {
                    c = 2;
                    break;
                }
                break;
            case 936806003:
                if (str.equals("showCallout")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                if (readableArray != null) {
                    ReadableMap map = readableArray.getMap(0);
                    mapMarker.animateToCoodinate(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")), Integer.valueOf(readableArray.getInt(1)));
                    return;
                }
                return;
            case 1:
                mapMarker.updateMarkerIcon();
                return;
            case 2:
                ((Marker) mapMarker.getFeature()).hideInfoWindow();
                return;
            case 3:
                ((Marker) mapMarker.getFeature()).showInfoWindow();
                return;
            default:
                return;
        }
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.builder().put("onPress", MapBuilder.of("registrationName", "onPress")).put("onCalloutPress", MapBuilder.of("registrationName", "onCalloutPress")).put("onDragStart", MapBuilder.of("registrationName", "onDragStart")).put("onDrag", MapBuilder.of("registrationName", "onDrag")).put("onDragEnd", MapBuilder.of("registrationName", "onDragEnd")).build();
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("onSelect", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSelect"))).put("onDeselect", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onDeselect"))).build();
    }

    public LayoutShadowNode createShadowNodeInstance() {
        return new SizeReportingShadowNode();
    }

    public void updateExtraData(MapMarker mapMarker, Object obj) {
        HashMap hashMap = (HashMap) obj;
        mapMarker.update((int) ((Float) hashMap.get("width")).floatValue(), (int) ((Float) hashMap.get("height")).floatValue());
    }
}
