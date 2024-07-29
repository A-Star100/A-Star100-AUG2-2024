package com.rnmaps.maps;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.location.Location;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.content.PermissionChecker;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;
import com.amazon.a.a.o.b;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.IndoorBuilding;
import com.google.android.gms.maps.model.IndoorLevel;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PointOfInterest;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.maps.android.collections.CircleManager;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Renderer;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlLayer;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.onesignal.location.internal.common.LocationConstants;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.xmlpull.v1.XmlPullParserException;

public class MapView extends com.google.android.gms.maps.MapView implements GoogleMap.InfoWindowAdapter, GoogleMap.OnMarkerDragListener, OnMapReadyCallback, GoogleMap.OnPoiClickListener, GoogleMap.OnIndoorStateChangeListener {
    private static final String[] PERMISSIONS = {LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING, LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING};
    private final ViewAttacherGroup attacherGroup;
    int baseBottomMapPadding;
    int baseLeftMapPadding;
    private final int baseMapPadding = 50;
    int baseRightMapPadding;
    int baseTopMapPadding;
    private LatLngBounds boundsToMove;
    private boolean cacheEnabled = false;
    private ImageView cacheImageView;
    private ReadableMap camera;
    /* access modifiers changed from: private */
    public LatLngBounds cameraLastIdleBounds;
    /* access modifiers changed from: private */
    public int cameraMoveReason = 0;
    private CameraUpdate cameraToSet;
    private CircleManager.Collection circleCollection;
    /* access modifiers changed from: private */
    public final ThemedReactContext context;
    private String customMapStyleString;
    /* access modifiers changed from: private */
    public boolean destroyed = false;
    /* access modifiers changed from: private */
    public final EventDispatcher eventDispatcher;
    private final List<MapFeature> features = new ArrayList();
    /* access modifiers changed from: private */
    public final FusedLocationSource fusedLocationSource;
    private final GestureDetectorCompat gestureDetector;
    private final Map<TileOverlay, MapGradientPolyline> gradientPolylineMap = new HashMap();
    private GroundOverlayManager.Collection groundOverlayCollection;
    private GroundOverlayManager groundOverlayManager;
    /* access modifiers changed from: private */
    public boolean handlePanDrag = false;
    private final Map<TileOverlay, MapHeatmap> heatmapMap = new HashMap();
    private ReadableMap initialRegion;
    private boolean initialRegionSet = false;
    /* access modifiers changed from: private */
    public Boolean isMapLoaded = false;
    private LifecycleEventListener lifecycleListener;
    private Integer loadingBackgroundColor = null;
    private Integer loadingIndicatorColor = null;
    /* access modifiers changed from: private */
    public final MapManager manager;
    public GoogleMap map;
    private RelativeLayout mapLoadingLayout;
    private ProgressBar mapLoadingProgressBar;
    private MarkerManager.Collection markerCollection;
    private MarkerManager markerManager;
    private final Map<Marker, MapMarker> markerMap = new HashMap();
    private final Runnable measureAndLayout = new Runnable() {
        public void run() {
            MapView mapView = MapView.this;
            mapView.measure(View.MeasureSpec.makeMeasureSpec(mapView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(MapView.this.getHeight(), 1073741824));
            MapView mapView2 = MapView.this;
            mapView2.layout(mapView2.getLeft(), MapView.this.getTop(), MapView.this.getRight(), MapView.this.getBottom());
        }
    };
    /* access modifiers changed from: private */
    public boolean moveOnMarkerPress = true;
    /* access modifiers changed from: private */
    public final Map<GroundOverlay, MapOverlay> overlayMap = new HashMap();
    /* access modifiers changed from: private */
    public boolean paused = false;
    private PolygonManager.Collection polygonCollection;
    private PolygonManager polygonManager;
    /* access modifiers changed from: private */
    public final Map<Polygon, MapPolygon> polygonMap = new HashMap();
    private PolylineManager.Collection polylineCollection;
    private PolylineManager polylineManager;
    /* access modifiers changed from: private */
    public final Map<Polyline, MapPolyline> polylineMap = new HashMap();
    private ReadableMap region;
    private MapMarker selectedMarker;
    /* access modifiers changed from: private */
    public boolean showUserLocation = false;
    /* access modifiers changed from: private */
    public LatLng tapLocation;

    public void setHandlePanDrag(boolean z) {
        this.handlePanDrag = z;
    }

    public void setMoveOnMarkerPress(boolean z) {
        this.moveOnMarkerPress = z;
    }

    private static boolean contextHasBug(Context context2) {
        return context2 == null || context2.getResources() == null || context2.getResources().getConfiguration() == null;
    }

    private static Context getNonBuggyContext(ThemedReactContext themedReactContext, ReactApplicationContext reactApplicationContext) {
        if (!contextHasBug(reactApplicationContext.getCurrentActivity())) {
            return reactApplicationContext.getCurrentActivity();
        }
        if (!contextHasBug(themedReactContext)) {
            return themedReactContext;
        }
        if (!contextHasBug(themedReactContext.getCurrentActivity())) {
            return themedReactContext.getCurrentActivity();
        }
        return !contextHasBug(themedReactContext.getApplicationContext()) ? themedReactContext.getApplicationContext() : themedReactContext;
    }

    public MapView(ThemedReactContext themedReactContext, ReactApplicationContext reactApplicationContext, MapManager mapManager, GoogleMapOptions googleMapOptions) {
        super(getNonBuggyContext(themedReactContext, reactApplicationContext), googleMapOptions);
        this.manager = mapManager;
        this.context = themedReactContext;
        MapsInitializer.initialize(themedReactContext, mapManager.renderer, new MapView$$ExternalSyntheticLambda0());
        super.onCreate((Bundle) null);
        super.onResume();
        super.getMapAsync(this);
        this.fusedLocationSource = new FusedLocationSource(themedReactContext);
        this.gestureDetector = new GestureDetectorCompat(themedReactContext, new GestureDetector.SimpleOnGestureListener() {
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (!MapView.this.handlePanDrag) {
                    return false;
                }
                MapView.this.onPanDrag(motionEvent2);
                return false;
            }

            public boolean onDoubleTap(MotionEvent motionEvent) {
                MapView.this.onDoublePress(motionEvent);
                return false;
            }
        });
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (!MapView.this.paused) {
                    MapView.this.cacheView();
                }
            }
        });
        this.eventDispatcher = (EventDispatcher) UIManagerHelper.getUIManager(themedReactContext, 1).getEventDispatcher();
        ViewAttacherGroup viewAttacherGroup = new ViewAttacherGroup(themedReactContext);
        this.attacherGroup = viewAttacherGroup;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        layoutParams.width = 0;
        layoutParams.height = 0;
        layoutParams.leftMargin = 99999999;
        layoutParams.topMargin = 99999999;
        viewAttacherGroup.setLayoutParams(layoutParams);
        addView(viewAttacherGroup);
    }

    public void onMapReady(final GoogleMap googleMap) {
        if (!this.destroyed) {
            this.map = googleMap;
            MarkerManager markerManager2 = new MarkerManager(googleMap);
            this.markerManager = markerManager2;
            this.markerCollection = markerManager2.newCollection();
            PolylineManager polylineManager2 = new PolylineManager(googleMap);
            this.polylineManager = polylineManager2;
            this.polylineCollection = polylineManager2.newCollection();
            PolygonManager polygonManager2 = new PolygonManager(googleMap);
            this.polygonManager = polygonManager2;
            this.polygonCollection = polygonManager2.newCollection();
            this.circleCollection = new CircleManager(googleMap).newCollection();
            GroundOverlayManager groundOverlayManager2 = new GroundOverlayManager(googleMap);
            this.groundOverlayManager = groundOverlayManager2;
            this.groundOverlayCollection = groundOverlayManager2.newCollection();
            this.markerCollection.setInfoWindowAdapter(this);
            this.markerCollection.setOnMarkerDragListener(this);
            this.map.setOnPoiClickListener(this);
            this.map.setOnIndoorStateChangeListener(this);
            applyBridgedProps();
            this.manager.pushEvent(this.context, this, "onMapReady", new WritableNativeMap());
            googleMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
                public void onMyLocationChange(Location location) {
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    WritableNativeMap writableNativeMap2 = new WritableNativeMap();
                    writableNativeMap2.putDouble("latitude", location.getLatitude());
                    writableNativeMap2.putDouble("longitude", location.getLongitude());
                    writableNativeMap2.putDouble("altitude", location.getAltitude());
                    writableNativeMap2.putDouble("timestamp", (double) location.getTime());
                    writableNativeMap2.putDouble("accuracy", (double) location.getAccuracy());
                    writableNativeMap2.putDouble("speed", (double) location.getSpeed());
                    writableNativeMap2.putDouble("heading", (double) location.getBearing());
                    writableNativeMap2.putBoolean("isFromMockProvider", location.isFromMockProvider());
                    writableNativeMap.putMap("coordinate", writableNativeMap2);
                    MapView.this.manager.pushEvent(MapView.this.context, this, "onUserLocationChange", writableNativeMap);
                }
            });
            this.markerCollection.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                public boolean onMarkerClick(Marker marker) {
                    MapMarker r0 = MapView.this.getMarkerMap(marker);
                    WritableMap makeClickEventData = MapView.this.makeClickEventData(marker.getPosition());
                    makeClickEventData.putString("action", "marker-press");
                    makeClickEventData.putString("id", r0.getIdentifier());
                    MapView.this.manager.pushEvent(MapView.this.context, this, "onMarkerPress", makeClickEventData);
                    WritableMap makeClickEventData2 = MapView.this.makeClickEventData(marker.getPosition());
                    makeClickEventData2.putString("action", "marker-press");
                    makeClickEventData2.putString("id", r0.getIdentifier());
                    MapView.this.manager.pushEvent(MapView.this.context, r0, "onPress", makeClickEventData2);
                    MapView.this.handleMarkerSelection(r0);
                    if (this.moveOnMarkerPress) {
                        return false;
                    }
                    marker.showInfoWindow();
                    return true;
                }
            });
            this.polygonCollection.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() {
                public void onPolygonClick(Polygon polygon) {
                    MapView mapView = MapView.this;
                    WritableMap makeClickEventData = mapView.makeClickEventData(mapView.tapLocation);
                    makeClickEventData.putString("action", "polygon-press");
                    MapView.this.manager.pushEvent(MapView.this.context, (View) MapView.this.polygonMap.get(polygon), "onPress", makeClickEventData);
                }
            });
            this.polylineCollection.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() {
                public void onPolylineClick(Polyline polyline) {
                    MapView mapView = MapView.this;
                    WritableMap makeClickEventData = mapView.makeClickEventData(mapView.tapLocation);
                    makeClickEventData.putString("action", "polyline-press");
                    MapView.this.manager.pushEvent(MapView.this.context, (View) MapView.this.polylineMap.get(polyline), "onPress", makeClickEventData);
                }
            });
            this.markerCollection.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                public void onInfoWindowClick(Marker marker) {
                    WritableMap makeClickEventData = MapView.this.makeClickEventData(marker.getPosition());
                    makeClickEventData.putString("action", "callout-press");
                    MapView.this.manager.pushEvent(MapView.this.context, this, "onCalloutPress", makeClickEventData);
                    WritableMap makeClickEventData2 = MapView.this.makeClickEventData(marker.getPosition());
                    makeClickEventData2.putString("action", "callout-press");
                    MapMarker r3 = MapView.this.getMarkerMap(marker);
                    MapView.this.manager.pushEvent(MapView.this.context, r3, "onCalloutPress", makeClickEventData2);
                    WritableMap makeClickEventData3 = MapView.this.makeClickEventData(marker.getPosition());
                    makeClickEventData3.putString("action", "callout-press");
                    MapCallout calloutView = r3.getCalloutView();
                    if (calloutView != null) {
                        MapView.this.manager.pushEvent(MapView.this.context, calloutView, "onPress", makeClickEventData3);
                    }
                }
            });
            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
                public void onMapClick(LatLng latLng) {
                    WritableMap makeClickEventData = MapView.this.makeClickEventData(latLng);
                    makeClickEventData.putString("action", "press");
                    MapView.this.manager.pushEvent(MapView.this.context, this, "onPress", makeClickEventData);
                    MapView.this.handleMarkerSelection((MapMarker) null);
                }
            });
            googleMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
                public void onMapLongClick(LatLng latLng) {
                    MapView.this.makeClickEventData(latLng).putString("action", "long-press");
                    MapView.this.manager.pushEvent(MapView.this.context, this, "onLongPress", MapView.this.makeClickEventData(latLng));
                }
            });
            this.groundOverlayCollection.setOnGroundOverlayClickListener(new GoogleMap.OnGroundOverlayClickListener() {
                public void onGroundOverlayClick(GroundOverlay groundOverlay) {
                    WritableMap makeClickEventData = MapView.this.makeClickEventData(groundOverlay.getPosition());
                    makeClickEventData.putString("action", "overlay-press");
                    MapView.this.manager.pushEvent(MapView.this.context, (View) MapView.this.overlayMap.get(groundOverlay), "onPress", makeClickEventData);
                }
            });
            googleMap.setOnCameraMoveStartedListener(new GoogleMap.OnCameraMoveStartedListener() {
                public void onCameraMoveStarted(int i) {
                    MapView.this.cameraMoveReason = i;
                }
            });
            googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
                public void onCameraMove() {
                    LatLngBounds latLngBounds = googleMap.getProjection().getVisibleRegion().latLngBounds;
                    MapView.this.cameraLastIdleBounds = null;
                    MapView.this.eventDispatcher.dispatchEvent(new RegionChangeEvent(MapView.this.getId(), latLngBounds, true, 1 == MapView.this.cameraMoveReason));
                }
            });
            googleMap.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
                public void onCameraIdle() {
                    LatLngBounds latLngBounds = googleMap.getProjection().getVisibleRegion().latLngBounds;
                    if (MapView.this.cameraMoveReason == 0) {
                        return;
                    }
                    if (MapView.this.cameraLastIdleBounds == null || LatLngBoundsUtils.BoundsAreDifferent(latLngBounds, MapView.this.cameraLastIdleBounds)) {
                        MapView.this.cameraLastIdleBounds = latLngBounds;
                        boolean z = true;
                        if (1 != MapView.this.cameraMoveReason) {
                            z = false;
                        }
                        MapView.this.eventDispatcher.dispatchEvent(new RegionChangeEvent(MapView.this.getId(), latLngBounds, false, z));
                    }
                }
            });
            googleMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
                public void onMapLoaded() {
                    MapView.this.isMapLoaded = true;
                    MapView.this.manager.pushEvent(MapView.this.context, this, "onMapLoaded", new WritableNativeMap());
                    MapView.this.cacheView();
                }
            });
            AnonymousClass15 r0 = new LifecycleEventListener() {
                public void onHostResume() {
                    GoogleMap googleMap;
                    if (MapView.this.hasPermissions() && (googleMap = googleMap) != null) {
                        googleMap.setMyLocationEnabled(MapView.this.showUserLocation);
                        googleMap.setLocationSource(MapView.this.fusedLocationSource);
                    }
                    synchronized (MapView.this) {
                        if (!MapView.this.destroyed) {
                            MapView.this.onResume();
                        }
                        MapView.this.paused = false;
                    }
                }

                public void onHostPause() {
                    GoogleMap googleMap;
                    if (MapView.this.hasPermissions() && (googleMap = googleMap) != null) {
                        googleMap.setMyLocationEnabled(false);
                    }
                    synchronized (MapView.this) {
                        if (!MapView.this.destroyed) {
                            MapView.this.onPause();
                        }
                        MapView.this.paused = true;
                    }
                }

                public void onHostDestroy() {
                    MapView.this.doDestroy();
                }
            };
            this.lifecycleListener = r0;
            this.context.addLifecycleEventListener(r0);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void handleMarkerSelection(MapMarker mapMarker) {
        MapMarker mapMarker2 = this.selectedMarker;
        if (mapMarker2 != mapMarker) {
            if (mapMarker2 != null) {
                WritableMap makeClickEventData = makeClickEventData(mapMarker2.getPosition());
                makeClickEventData.putString("action", "marker-deselect");
                makeClickEventData.putString("id", this.selectedMarker.getIdentifier());
                this.manager.pushEvent(this.context, this.selectedMarker, "onDeselect", makeClickEventData);
                WritableMap makeClickEventData2 = makeClickEventData(this.selectedMarker.getPosition());
                makeClickEventData2.putString("action", "marker-deselect");
                makeClickEventData2.putString("id", this.selectedMarker.getIdentifier());
                this.manager.pushEvent(this.context, this, "onMarkerDeselect", makeClickEventData2);
            }
            if (mapMarker != null) {
                WritableMap makeClickEventData3 = makeClickEventData(mapMarker.getPosition());
                makeClickEventData3.putString("action", "marker-select");
                makeClickEventData3.putString("id", mapMarker.getIdentifier());
                this.manager.pushEvent(this.context, mapMarker, "onSelect", makeClickEventData3);
                WritableMap makeClickEventData4 = makeClickEventData(mapMarker.getPosition());
                makeClickEventData4.putString("action", "marker-select");
                makeClickEventData4.putString("id", mapMarker.getIdentifier());
                this.manager.pushEvent(this.context, this, "onMarkerSelect", makeClickEventData4);
            }
            this.selectedMarker = mapMarker;
        }
    }

    /* access modifiers changed from: private */
    public boolean hasPermissions() {
        Context context2 = getContext();
        String[] strArr = PERMISSIONS;
        if (PermissionChecker.checkSelfPermission(context2, strArr[0]) == 0 || PermissionChecker.checkSelfPermission(getContext(), strArr[1]) == 0) {
            return true;
        }
        return false;
    }

    public synchronized void doDestroy() {
        ThemedReactContext themedReactContext;
        if (!this.destroyed) {
            this.destroyed = true;
            LifecycleEventListener lifecycleEventListener = this.lifecycleListener;
            if (!(lifecycleEventListener == null || (themedReactContext = this.context) == null)) {
                themedReactContext.removeLifecycleEventListener(lifecycleEventListener);
                this.lifecycleListener = null;
            }
            if (!this.paused) {
                onPause();
                this.paused = true;
            }
            onDestroy();
        }
    }

    public void setInitialRegion(ReadableMap readableMap) {
        this.initialRegion = readableMap;
        if (!this.initialRegionSet && this.map != null) {
            moveToRegion(readableMap);
            this.initialRegionSet = true;
        }
    }

    private void applyBridgedProps() {
        ReadableMap readableMap = this.initialRegion;
        if (readableMap != null) {
            moveToRegion(readableMap);
            this.initialRegionSet = true;
        } else {
            ReadableMap readableMap2 = this.region;
            if (readableMap2 != null) {
                moveToRegion(readableMap2);
            } else {
                moveToCamera(this.camera);
            }
        }
        if (this.customMapStyleString != null) {
            this.map.setMapStyle(new MapStyleOptions(this.customMapStyleString));
        }
    }

    private void moveToRegion(ReadableMap readableMap) {
        if (readableMap != null) {
            double d = readableMap.getDouble("longitude");
            double d2 = readableMap.getDouble("latitude");
            double d3 = readableMap.getDouble("longitudeDelta");
            double d4 = readableMap.getDouble("latitudeDelta") / 2.0d;
            double d5 = d3 / 2.0d;
            LatLngBounds latLngBounds = new LatLngBounds(new LatLng(d2 - d4, d - d5), new LatLng(d4 + d2, d5 + d));
            if (super.getHeight() <= 0 || super.getWidth() <= 0) {
                this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d2, d), 10.0f));
                this.boundsToMove = latLngBounds;
                return;
            }
            this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0));
            this.boundsToMove = null;
        }
    }

    public void setRegion(ReadableMap readableMap) {
        this.region = readableMap;
        if (readableMap != null && this.map != null) {
            moveToRegion(readableMap);
        }
    }

    public void setCamera(ReadableMap readableMap) {
        this.camera = readableMap;
        if (readableMap != null && this.map != null) {
            moveToCamera(readableMap);
        }
    }

    public static CameraPosition cameraPositionFromMap(ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        CameraPosition.Builder builder = new CameraPosition.Builder();
        ReadableMap map2 = readableMap.getMap(TtmlNode.CENTER);
        if (map2 != null) {
            builder.target(new LatLng(map2.getDouble("latitude"), map2.getDouble("longitude")));
        }
        builder.tilt((float) readableMap.getDouble("pitch"));
        builder.bearing((float) readableMap.getDouble("heading"));
        builder.zoom((float) readableMap.getDouble("zoom"));
        return builder.build();
    }

    public void moveToCamera(ReadableMap readableMap) {
        CameraPosition cameraPositionFromMap = cameraPositionFromMap(readableMap);
        if (cameraPositionFromMap != null) {
            CameraUpdate newCameraPosition = CameraUpdateFactory.newCameraPosition(cameraPositionFromMap);
            if (super.getHeight() <= 0 || super.getWidth() <= 0) {
                this.cameraToSet = newCameraPosition;
                return;
            }
            this.map.moveCamera(newCameraPosition);
            this.cameraToSet = null;
        }
    }

    public void setMapStyle(String str) {
        this.customMapStyleString = str;
        GoogleMap googleMap = this.map;
        if (googleMap != null && str != null) {
            googleMap.setMapStyle(new MapStyleOptions(str));
        }
    }

    public void setShowsUserLocation(boolean z) {
        this.showUserLocation = z;
        if (hasPermissions()) {
            this.map.setLocationSource(this.fusedLocationSource);
            this.map.setMyLocationEnabled(z);
        }
    }

    public void setUserLocationPriority(int i) {
        this.fusedLocationSource.setPriority(i);
    }

    public void setUserLocationUpdateInterval(int i) {
        this.fusedLocationSource.setInterval(i);
    }

    public void setUserLocationFastestInterval(int i) {
        this.fusedLocationSource.setFastestInterval(i);
    }

    public void setShowsMyLocationButton(boolean z) {
        if (hasPermissions() || !z) {
            this.map.getUiSettings().setMyLocationButtonEnabled(z);
        }
    }

    public void setToolbarEnabled(boolean z) {
        if (hasPermissions() || !z) {
            this.map.getUiSettings().setMapToolbarEnabled(z);
        }
    }

    public void setCacheEnabled(boolean z) {
        this.cacheEnabled = z;
        cacheView();
    }

    public void enableMapLoading(boolean z) {
        if (z && !this.isMapLoaded.booleanValue()) {
            getMapLoadingLayoutView().setVisibility(0);
        }
    }

    public void setLoadingBackgroundColor(Integer num) {
        this.loadingBackgroundColor = num;
        RelativeLayout relativeLayout = this.mapLoadingLayout;
        if (relativeLayout == null) {
            return;
        }
        if (num == null) {
            relativeLayout.setBackgroundColor(-1);
        } else {
            relativeLayout.setBackgroundColor(num.intValue());
        }
    }

    public void setLoadingIndicatorColor(Integer num) {
        this.loadingIndicatorColor = num;
        if (this.mapLoadingProgressBar != null) {
            if (num == null) {
                Integer.valueOf(Color.parseColor("#606060"));
            }
            ColorStateList valueOf = ColorStateList.valueOf(num.intValue());
            ColorStateList valueOf2 = ColorStateList.valueOf(num.intValue());
            ColorStateList valueOf3 = ColorStateList.valueOf(num.intValue());
            this.mapLoadingProgressBar.setProgressTintList(valueOf);
            this.mapLoadingProgressBar.setSecondaryProgressTintList(valueOf2);
            this.mapLoadingProgressBar.setIndeterminateTintList(valueOf3);
        }
    }

    public void addFeature(View view, int i) {
        if (view instanceof MapMarker) {
            MapMarker mapMarker = (MapMarker) view;
            mapMarker.addToMap(this.markerCollection);
            this.features.add(i, mapMarker);
            int visibility = mapMarker.getVisibility();
            mapMarker.setVisibility(4);
            ViewGroup viewGroup = (ViewGroup) mapMarker.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(mapMarker);
            }
            this.attacherGroup.addView(mapMarker);
            mapMarker.setVisibility(visibility);
            this.markerMap.put((Marker) mapMarker.getFeature(), mapMarker);
        } else if (view instanceof MapPolyline) {
            MapPolyline mapPolyline = (MapPolyline) view;
            mapPolyline.addToMap(this.polylineCollection);
            this.features.add(i, mapPolyline);
            this.polylineMap.put((Polyline) mapPolyline.getFeature(), mapPolyline);
        } else if (view instanceof MapGradientPolyline) {
            MapGradientPolyline mapGradientPolyline = (MapGradientPolyline) view;
            mapGradientPolyline.addToMap(this.map);
            this.features.add(i, mapGradientPolyline);
            this.gradientPolylineMap.put((TileOverlay) mapGradientPolyline.getFeature(), mapGradientPolyline);
        } else if (view instanceof MapPolygon) {
            MapPolygon mapPolygon = (MapPolygon) view;
            mapPolygon.addToMap(this.polygonCollection);
            this.features.add(i, mapPolygon);
            this.polygonMap.put((Polygon) mapPolygon.getFeature(), mapPolygon);
        } else if (view instanceof MapCircle) {
            MapCircle mapCircle = (MapCircle) view;
            mapCircle.addToMap(this.circleCollection);
            this.features.add(i, mapCircle);
        } else if (view instanceof MapUrlTile) {
            MapUrlTile mapUrlTile = (MapUrlTile) view;
            mapUrlTile.addToMap(this.map);
            this.features.add(i, mapUrlTile);
        } else if (view instanceof MapWMSTile) {
            MapWMSTile mapWMSTile = (MapWMSTile) view;
            mapWMSTile.addToMap(this.map);
            this.features.add(i, mapWMSTile);
        } else if (view instanceof MapLocalTile) {
            MapLocalTile mapLocalTile = (MapLocalTile) view;
            mapLocalTile.addToMap(this.map);
            this.features.add(i, mapLocalTile);
        } else if (view instanceof MapOverlay) {
            MapOverlay mapOverlay = (MapOverlay) view;
            mapOverlay.addToMap(this.groundOverlayCollection);
            this.features.add(i, mapOverlay);
            this.overlayMap.put((GroundOverlay) mapOverlay.getFeature(), mapOverlay);
        } else if (view instanceof MapHeatmap) {
            MapHeatmap mapHeatmap = (MapHeatmap) view;
            mapHeatmap.addToMap(this.map);
            this.features.add(i, mapHeatmap);
            this.heatmapMap.put((TileOverlay) mapHeatmap.getFeature(), mapHeatmap);
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup2 = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup2.getChildCount(); i2++) {
                addFeature(viewGroup2.getChildAt(i2), i);
            }
        } else {
            addView(view, i);
        }
    }

    public int getFeatureCount() {
        return this.features.size();
    }

    public View getFeatureAt(int i) {
        return this.features.get(i);
    }

    public void removeFeatureAt(int i) {
        MapFeature remove = this.features.remove(i);
        if (remove instanceof MapMarker) {
            this.markerMap.remove(remove.getFeature());
            remove.removeFromMap(this.markerCollection);
            this.attacherGroup.removeView(remove);
        } else if (remove instanceof MapHeatmap) {
            this.heatmapMap.remove(remove.getFeature());
            remove.removeFromMap(this.map);
        } else if (remove instanceof MapCircle) {
            remove.removeFromMap(this.circleCollection);
        } else if (remove instanceof MapOverlay) {
            remove.removeFromMap(this.groundOverlayCollection);
        } else if (remove instanceof MapPolygon) {
            remove.removeFromMap(this.polygonCollection);
        } else if (remove instanceof MapPolyline) {
            remove.removeFromMap(this.polylineCollection);
        } else {
            remove.removeFromMap(this.map);
        }
    }

    public WritableMap makeClickEventData(LatLng latLng) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putDouble("latitude", latLng.latitude);
        writableNativeMap2.putDouble("longitude", latLng.longitude);
        writableNativeMap.putMap("coordinate", writableNativeMap2);
        Point screenLocation = this.map.getProjection().toScreenLocation(latLng);
        WritableNativeMap writableNativeMap3 = new WritableNativeMap();
        writableNativeMap3.putDouble("x", (double) screenLocation.x);
        writableNativeMap3.putDouble("y", (double) screenLocation.y);
        writableNativeMap.putMap(ViewProps.POSITION, writableNativeMap3);
        return writableNativeMap;
    }

    public void updateExtraData(Object obj) {
        if (this.boundsToMove != null) {
            HashMap hashMap = (HashMap) obj;
            int intValue = hashMap.get("width") == null ? 0 : ((Float) hashMap.get("width")).intValue();
            int intValue2 = hashMap.get("height") == null ? 0 : ((Float) hashMap.get("height")).intValue();
            if (intValue <= 0 || intValue2 <= 0) {
                this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(this.boundsToMove, 0));
            } else {
                this.map.moveCamera(CameraUpdateFactory.newLatLngBounds(this.boundsToMove, intValue, intValue2, 0));
            }
            this.boundsToMove = null;
            this.cameraToSet = null;
            return;
        }
        CameraUpdate cameraUpdate = this.cameraToSet;
        if (cameraUpdate != null) {
            this.map.moveCamera(cameraUpdate);
            this.cameraToSet = null;
        }
    }

    public void animateToCamera(ReadableMap readableMap, int i) {
        if (this.map != null) {
            CameraPosition.Builder builder = new CameraPosition.Builder(this.map.getCameraPosition());
            if (readableMap.hasKey("zoom")) {
                builder.zoom((float) readableMap.getDouble("zoom"));
            }
            if (readableMap.hasKey("heading")) {
                builder.bearing((float) readableMap.getDouble("heading"));
            }
            if (readableMap.hasKey("pitch")) {
                builder.tilt((float) readableMap.getDouble("pitch"));
            }
            if (readableMap.hasKey(TtmlNode.CENTER)) {
                ReadableMap map2 = readableMap.getMap(TtmlNode.CENTER);
                builder.target(new LatLng(map2.getDouble("latitude"), map2.getDouble("longitude")));
            }
            CameraUpdate newCameraPosition = CameraUpdateFactory.newCameraPosition(builder.build());
            if (i <= 0) {
                this.map.moveCamera(newCameraPosition);
            } else {
                this.map.animateCamera(newCameraPosition, i, (GoogleMap.CancelableCallback) null);
            }
        }
    }

    public void animateToRegion(LatLngBounds latLngBounds, int i) {
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            if (i <= 0) {
                googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0));
            } else {
                googleMap.animateCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, 0), i, (GoogleMap.CancelableCallback) null);
            }
        }
    }

    public void fitToElements(ReadableMap readableMap, boolean z) {
        if (this.map != null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            boolean z2 = false;
            for (MapFeature next : this.features) {
                if (next instanceof MapMarker) {
                    builder.include(((Marker) next.getFeature()).getPosition());
                    z2 = true;
                }
            }
            if (z2) {
                CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), 50);
                if (readableMap != null) {
                    this.map.setPadding(readableMap.getInt("left"), readableMap.getInt(ViewProps.TOP), readableMap.getInt("right"), readableMap.getInt(ViewProps.BOTTOM));
                }
                if (z) {
                    this.map.animateCamera(newLatLngBounds);
                } else {
                    this.map.moveCamera(newLatLngBounds);
                }
            }
        }
    }

    public void fitToSuppliedMarkers(ReadableArray readableArray, ReadableMap readableMap, boolean z) {
        if (this.map != null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            String[] strArr = new String[readableArray.size()];
            boolean z2 = false;
            for (int i = 0; i < readableArray.size(); i++) {
                strArr[i] = readableArray.getString(i);
            }
            List asList = Arrays.asList(strArr);
            for (MapFeature next : this.features) {
                if (next instanceof MapMarker) {
                    String identifier = ((MapMarker) next).getIdentifier();
                    Marker marker = (Marker) next.getFeature();
                    if (asList.contains(identifier)) {
                        builder.include(marker.getPosition());
                        z2 = true;
                    }
                }
            }
            if (z2) {
                CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), 50);
                if (readableMap != null) {
                    this.map.setPadding(readableMap.getInt("left"), readableMap.getInt(ViewProps.TOP), readableMap.getInt("right"), readableMap.getInt(ViewProps.BOTTOM));
                }
                if (z) {
                    this.map.animateCamera(newLatLngBounds);
                } else {
                    this.map.moveCamera(newLatLngBounds);
                }
            }
        }
    }

    public void applyBaseMapPadding(int i, int i2, int i3, int i4) {
        this.map.setPadding(i, i2, i3, i4);
        this.baseLeftMapPadding = i;
        this.baseRightMapPadding = i3;
        this.baseTopMapPadding = i2;
        this.baseBottomMapPadding = i4;
    }

    public void fitToCoordinates(ReadableArray readableArray, ReadableMap readableMap, boolean z) {
        if (this.map != null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap map2 = readableArray.getMap(i);
                builder.include(new LatLng(map2.getDouble("latitude"), map2.getDouble("longitude")));
            }
            CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), 50);
            if (readableMap != null) {
                appendMapPadding(readableMap.getInt("left"), readableMap.getInt(ViewProps.TOP), readableMap.getInt("right"), readableMap.getInt(ViewProps.BOTTOM));
            }
            if (z) {
                this.map.animateCamera(newLatLngBounds);
            } else {
                this.map.moveCamera(newLatLngBounds);
            }
            this.map.setPadding(this.baseLeftMapPadding, this.baseTopMapPadding, this.baseRightMapPadding, this.baseBottomMapPadding);
        }
    }

    private void appendMapPadding(int i, int i2, int i3, int i4) {
        double d = (double) getResources().getDisplayMetrics().density;
        this.map.setPadding(((int) (((double) i) * d)) + this.baseLeftMapPadding, ((int) (((double) i2) * d)) + this.baseTopMapPadding, ((int) (((double) i3) * d)) + this.baseRightMapPadding, ((int) (((double) i4) * d)) + this.baseBottomMapPadding);
    }

    public double[][] getMapBoundaries() {
        LatLngBounds latLngBounds = this.map.getProjection().getVisibleRegion().latLngBounds;
        LatLng latLng = latLngBounds.northeast;
        LatLng latLng2 = latLngBounds.southwest;
        return new double[][]{new double[]{latLng.longitude, latLng.latitude}, new double[]{latLng2.longitude, latLng2.latitude}};
    }

    public void setMapBoundaries(ReadableMap readableMap, ReadableMap readableMap2) {
        if (this.map != null) {
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(new LatLng(readableMap.getDouble("latitude"), readableMap.getDouble("longitude")));
            builder.include(new LatLng(readableMap2.getDouble("latitude"), readableMap2.getDouble("longitude")));
            this.map.setLatLngBoundsForCameraTarget(builder.build());
        }
    }

    public View getInfoWindow(Marker marker) {
        return getMarkerMap(marker).getCallout();
    }

    public View getInfoContents(Marker marker) {
        return getMarkerMap(marker).getInfoContents();
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.gestureDetector.onTouchEvent(motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        GoogleMap googleMap = this.map;
        if (googleMap != null) {
            this.tapLocation = googleMap.getProjection().fromScreenLocation(new Point(x, y));
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        boolean z = false;
        if (actionMasked == 0) {
            ViewParent parent = getParent();
            GoogleMap googleMap2 = this.map;
            if (googleMap2 != null && googleMap2.getUiSettings().isScrollGesturesEnabled()) {
                z = true;
            }
            parent.requestDisallowInterceptTouchEvent(z);
        } else if (actionMasked == 1) {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        super.dispatchTouchEvent(motionEvent);
        return true;
    }

    public void onMarkerDragStart(Marker marker) {
        this.manager.pushEvent(this.context, this, "onMarkerDragStart", makeClickEventData(marker.getPosition()));
        this.manager.pushEvent(this.context, getMarkerMap(marker), "onDragStart", makeClickEventData(marker.getPosition()));
    }

    public void onMarkerDrag(Marker marker) {
        this.manager.pushEvent(this.context, this, "onMarkerDrag", makeClickEventData(marker.getPosition()));
        this.manager.pushEvent(this.context, getMarkerMap(marker), "onDrag", makeClickEventData(marker.getPosition()));
    }

    public void onMarkerDragEnd(Marker marker) {
        this.manager.pushEvent(this.context, this, "onMarkerDragEnd", makeClickEventData(marker.getPosition()));
        this.manager.pushEvent(this.context, getMarkerMap(marker), "onDragEnd", makeClickEventData(marker.getPosition()));
    }

    public void onPoiClick(PointOfInterest pointOfInterest) {
        WritableMap makeClickEventData = makeClickEventData(pointOfInterest.latLng);
        makeClickEventData.putString("placeId", pointOfInterest.placeId);
        makeClickEventData.putString("name", pointOfInterest.name);
        this.manager.pushEvent(this.context, this, "onPoiClick", makeClickEventData);
    }

    private ProgressBar getMapLoadingProgressBar() {
        if (this.mapLoadingProgressBar == null) {
            ProgressBar progressBar = new ProgressBar(getContext());
            this.mapLoadingProgressBar = progressBar;
            progressBar.setIndeterminate(true);
        }
        Integer num = this.loadingIndicatorColor;
        if (num != null) {
            setLoadingIndicatorColor(num);
        }
        return this.mapLoadingProgressBar;
    }

    private RelativeLayout getMapLoadingLayoutView() {
        if (this.mapLoadingLayout == null) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            this.mapLoadingLayout = relativeLayout;
            relativeLayout.setBackgroundColor(-3355444);
            addView(this.mapLoadingLayout, new ViewGroup.LayoutParams(-1, -1));
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.mapLoadingLayout.addView(getMapLoadingProgressBar(), layoutParams);
            this.mapLoadingLayout.setVisibility(4);
        }
        setLoadingBackgroundColor(this.loadingBackgroundColor);
        return this.mapLoadingLayout;
    }

    private ImageView getCacheImageView() {
        if (this.cacheImageView == null) {
            ImageView imageView = new ImageView(getContext());
            this.cacheImageView = imageView;
            addView(imageView, new ViewGroup.LayoutParams(-1, -1));
            this.cacheImageView.setVisibility(4);
        }
        return this.cacheImageView;
    }

    private void removeCacheImageView() {
        ImageView imageView = this.cacheImageView;
        if (imageView != null) {
            ((ViewGroup) imageView.getParent()).removeView(this.cacheImageView);
            this.cacheImageView = null;
        }
    }

    private void removeMapLoadingProgressBar() {
        ProgressBar progressBar = this.mapLoadingProgressBar;
        if (progressBar != null) {
            ((ViewGroup) progressBar.getParent()).removeView(this.mapLoadingProgressBar);
            this.mapLoadingProgressBar = null;
        }
    }

    private void removeMapLoadingLayoutView() {
        removeMapLoadingProgressBar();
        RelativeLayout relativeLayout = this.mapLoadingLayout;
        if (relativeLayout != null) {
            ((ViewGroup) relativeLayout.getParent()).removeView(this.mapLoadingLayout);
            this.mapLoadingLayout = null;
        }
    }

    /* access modifiers changed from: private */
    public void cacheView() {
        if (this.cacheEnabled) {
            final ImageView cacheImageView2 = getCacheImageView();
            final RelativeLayout mapLoadingLayoutView = getMapLoadingLayoutView();
            cacheImageView2.setVisibility(4);
            mapLoadingLayoutView.setVisibility(0);
            if (this.isMapLoaded.booleanValue()) {
                this.map.snapshot(new GoogleMap.SnapshotReadyCallback() {
                    public void onSnapshotReady(Bitmap bitmap) {
                        cacheImageView2.setImageBitmap(bitmap);
                        cacheImageView2.setVisibility(0);
                        mapLoadingLayoutView.setVisibility(4);
                    }
                });
                return;
            }
            return;
        }
        removeCacheImageView();
        if (this.isMapLoaded.booleanValue()) {
            removeMapLoadingLayoutView();
        }
    }

    public void onPanDrag(MotionEvent motionEvent) {
        this.manager.pushEvent(this.context, this, "onPanDrag", makeClickEventData(this.map.getProjection().fromScreenLocation(new Point((int) motionEvent.getX(), (int) motionEvent.getY()))));
    }

    public void onDoublePress(MotionEvent motionEvent) {
        if (this.map != null) {
            this.manager.pushEvent(this.context, this, "onDoublePress", makeClickEventData(this.map.getProjection().fromScreenLocation(new Point((int) motionEvent.getX(), (int) motionEvent.getY()))));
        }
    }

    public void setKmlSrc(String str) {
        String str2 = "name";
        try {
            InputStream inputStream = (InputStream) new FileUtil(this.context).execute(new String[]{str}).get();
            if (inputStream != null) {
                KmlLayer kmlLayer = new KmlLayer(this.map, inputStream, (Context) this.context, this.markerManager, this.polygonManager, this.polylineManager, this.groundOverlayManager, (Renderer.ImagesCache) null);
                kmlLayer.addLayerToMap();
                WritableNativeMap writableNativeMap = new WritableNativeMap();
                WritableNativeArray writableNativeArray = new WritableNativeArray();
                if (kmlLayer.getContainers() == null) {
                    this.manager.pushEvent(this.context, this, "onKmlReady", writableNativeMap);
                    return;
                }
                KmlContainer next = kmlLayer.getContainers().iterator().next();
                if (next != null) {
                    if (next.getContainers() != null) {
                        if (next.getContainers().iterator().hasNext()) {
                            next = next.getContainers().iterator().next();
                        }
                        int i = 0;
                        for (KmlPlacemark next2 : next.getPlacemarks()) {
                            MarkerOptions markerOptions = new MarkerOptions();
                            if (next2.getInlineStyle() != null) {
                                markerOptions = next2.getMarkerOptions();
                            } else {
                                markerOptions.icon(BitmapDescriptorFactory.defaultMarker());
                            }
                            LatLng latLng = (LatLng) next2.getGeometry().getGeometryObject();
                            String str3 = "";
                            String property = next2.hasProperty(str2) ? next2.getProperty(str2) : str3;
                            if (next2.hasProperty(b.c)) {
                                str3 = next2.getProperty(b.c);
                            }
                            markerOptions.position(latLng);
                            markerOptions.title(property);
                            markerOptions.snippet(str3);
                            String str4 = str2;
                            MapMarker mapMarker = new MapMarker(this.context, markerOptions, this.manager.getMarkerManager());
                            if (next2.getInlineStyle() != null && next2.getInlineStyle().getIconUrl() != null) {
                                mapMarker.setImage(next2.getInlineStyle().getIconUrl());
                            } else if (next.getStyle(next2.getStyleId()) != null) {
                                mapMarker.setImage(next.getStyle(next2.getStyleId()).getIconUrl());
                            }
                            String str5 = property + " - " + i;
                            mapMarker.setIdentifier(str5);
                            int i2 = i + 1;
                            addFeature(mapMarker, i);
                            WritableMap makeClickEventData = makeClickEventData(latLng);
                            makeClickEventData.putString("id", str5);
                            makeClickEventData.putString("title", property);
                            makeClickEventData.putString(b.c, str3);
                            writableNativeArray.pushMap(makeClickEventData);
                            i = i2;
                            str2 = str4;
                        }
                        writableNativeMap.putArray("markers", writableNativeArray);
                        this.manager.pushEvent(this.context, this, "onKmlReady", writableNativeMap);
                        return;
                    }
                }
                this.manager.pushEvent(this.context, this, "onKmlReady", writableNativeMap);
            }
        } catch (IOException | InterruptedException | ExecutionException | XmlPullParserException e) {
            e.printStackTrace();
        }
    }

    public void onIndoorBuildingFocused() {
        IndoorBuilding focusedBuilding = this.map.getFocusedBuilding();
        int i = 0;
        if (focusedBuilding != null) {
            List<IndoorLevel> levels = focusedBuilding.getLevels();
            WritableArray createArray = Arguments.createArray();
            for (IndoorLevel next : levels) {
                WritableMap createMap = Arguments.createMap();
                createMap.putInt("index", i);
                createMap.putString("name", next.getName());
                createMap.putString("shortName", next.getShortName());
                createArray.pushMap(createMap);
                i++;
            }
            WritableMap createMap2 = Arguments.createMap();
            WritableMap createMap3 = Arguments.createMap();
            createMap3.putArray("levels", createArray);
            createMap3.putInt("activeLevelIndex", focusedBuilding.getActiveLevelIndex());
            createMap3.putBoolean("underground", focusedBuilding.isUnderground());
            createMap2.putMap("IndoorBuilding", createMap3);
            this.manager.pushEvent(this.context, this, "onIndoorBuildingFocused", createMap2);
            return;
        }
        WritableMap createMap4 = Arguments.createMap();
        WritableArray createArray2 = Arguments.createArray();
        WritableMap createMap5 = Arguments.createMap();
        createMap5.putArray("levels", createArray2);
        createMap5.putInt("activeLevelIndex", 0);
        createMap5.putBoolean("underground", false);
        createMap4.putMap("IndoorBuilding", createMap5);
        this.manager.pushEvent(this.context, this, "onIndoorBuildingFocused", createMap4);
    }

    public void onIndoorLevelActivated(IndoorBuilding indoorBuilding) {
        int activeLevelIndex;
        if (indoorBuilding != null && (activeLevelIndex = indoorBuilding.getActiveLevelIndex()) >= 0 && activeLevelIndex < indoorBuilding.getLevels().size()) {
            IndoorLevel indoorLevel = indoorBuilding.getLevels().get(activeLevelIndex);
            WritableMap createMap = Arguments.createMap();
            WritableMap createMap2 = Arguments.createMap();
            createMap2.putInt("activeLevelIndex", activeLevelIndex);
            createMap2.putString("name", indoorLevel.getName());
            createMap2.putString("shortName", indoorLevel.getShortName());
            createMap.putMap("IndoorLevel", createMap2);
            this.manager.pushEvent(this.context, this, "onIndoorLevelActivated", createMap);
        }
    }

    public void setIndoorActiveLevelIndex(int i) {
        IndoorLevel indoorLevel;
        IndoorBuilding focusedBuilding = this.map.getFocusedBuilding();
        if (focusedBuilding != null && i >= 0 && i < focusedBuilding.getLevels().size() && (indoorLevel = focusedBuilding.getLevels().get(i)) != null) {
            indoorLevel.activate();
        }
    }

    /* access modifiers changed from: private */
    public MapMarker getMarkerMap(Marker marker) {
        MapMarker mapMarker = this.markerMap.get(marker);
        if (mapMarker != null) {
            return mapMarker;
        }
        for (Map.Entry next : this.markerMap.entrySet()) {
            if (((Marker) next.getKey()).getPosition().equals(marker.getPosition()) && ((Marker) next.getKey()).getTitle().equals(marker.getTitle())) {
                return (MapMarker) next.getValue();
            }
        }
        return mapMarker;
    }

    public void requestLayout() {
        super.requestLayout();
        post(this.measureAndLayout);
    }
}
