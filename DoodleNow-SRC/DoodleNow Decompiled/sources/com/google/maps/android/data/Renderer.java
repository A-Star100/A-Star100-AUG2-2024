package com.google.maps.android.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amazon.a.a.o.b;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.R;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Layer;
import com.google.maps.android.data.geojson.BiMultiMap;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonLineString;
import com.google.maps.android.data.geojson.GeoJsonLineStringStyle;
import com.google.maps.android.data.geojson.GeoJsonMultiLineString;
import com.google.maps.android.data.geojson.GeoJsonMultiPoint;
import com.google.maps.android.data.geojson.GeoJsonMultiPolygon;
import com.google.maps.android.data.geojson.GeoJsonPoint;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;
import com.google.maps.android.data.geojson.GeoJsonPolygon;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlGroundOverlay;
import com.google.maps.android.data.kml.KmlMultiGeometry;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.google.maps.android.data.kml.KmlStyle;
import com.google.maps.android.data.kml.KmlUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Renderer {
    private static final Object FEATURE_NOT_ON_MAP = null;
    private static final int MARKER_ICON_SIZE = 32;
    private static final DecimalFormat sScaleFormat = new DecimalFormat("#.####");
    private final BiMultiMap<Feature> mContainerFeatures;
    private ArrayList<KmlContainer> mContainers;
    /* access modifiers changed from: private */
    public Context mContext;
    private final GeoJsonLineStringStyle mDefaultLineStringStyle;
    private final GeoJsonPointStyle mDefaultPointStyle;
    private final GeoJsonPolygonStyle mDefaultPolygonStyle;
    private final BiMultiMap<Feature> mFeatures;
    private HashMap<KmlGroundOverlay, GroundOverlay> mGroundOverlayMap;
    private final GroundOverlayManager.Collection mGroundOverlays;
    private ImagesCache mImagesCache;
    private boolean mLayerOnMap;
    private GoogleMap mMap;
    private final Set<String> mMarkerIconUrls;
    private final MarkerManager.Collection mMarkers;
    private int mNumActiveDownloads;
    private final PolygonManager.Collection mPolygons;
    private final PolylineManager.Collection mPolylines;
    private HashMap<String, String> mStyleMaps;
    private HashMap<String, KmlStyle> mStyles;
    private HashMap<String, KmlStyle> mStylesRenderer;

    public static final class ImagesCache {
        final Map<String, Bitmap> bitmapCache = new HashMap();
        final Map<String, BitmapDescriptor> groundOverlayImagesCache = new HashMap();
        final Map<String, Map<String, BitmapDescriptor>> markerImagesCache = new HashMap();
    }

    /* access modifiers changed from: protected */
    public void downloadStarted() {
        this.mNumActiveDownloads++;
    }

    /* access modifiers changed from: protected */
    public HashMap<? extends Feature, Object> getAllFeatures() {
        return this.mFeatures;
    }

    /* access modifiers changed from: protected */
    public ArrayList<KmlContainer> getContainerList() {
        return this.mContainers;
    }

    /* access modifiers changed from: package-private */
    public GeoJsonLineStringStyle getDefaultLineStringStyle() {
        return this.mDefaultLineStringStyle;
    }

    /* access modifiers changed from: package-private */
    public GeoJsonPointStyle getDefaultPointStyle() {
        return this.mDefaultPointStyle;
    }

    /* access modifiers changed from: package-private */
    public GeoJsonPolygonStyle getDefaultPolygonStyle() {
        return this.mDefaultPolygonStyle;
    }

    public HashMap<KmlGroundOverlay, GroundOverlay> getGroundOverlayMap() {
        return this.mGroundOverlayMap;
    }

    public GoogleMap getMap() {
        return this.mMap;
    }

    /* access modifiers changed from: protected */
    public Set<String> getMarkerIconUrls() {
        return this.mMarkerIconUrls;
    }

    /* access modifiers changed from: protected */
    public HashMap<String, String> getStyleMaps() {
        return this.mStyleMaps;
    }

    /* access modifiers changed from: protected */
    public HashMap<String, KmlStyle> getStylesRenderer() {
        return this.mStylesRenderer;
    }

    public boolean isLayerOnMap() {
        return this.mLayerOnMap;
    }

    /* access modifiers changed from: protected */
    public void setLayerVisibility(boolean z) {
        this.mLayerOnMap = z;
    }

    public void setMap(GoogleMap googleMap) {
        this.mMap = googleMap;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Renderer(GoogleMap googleMap, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, ImagesCache imagesCache) {
        this(googleMap, new HashSet(), (GeoJsonPointStyle) null, (GeoJsonLineStringStyle) null, (GeoJsonPolygonStyle) null, new BiMultiMap(), markerManager, polygonManager, polylineManager, groundOverlayManager);
        this.mContext = context;
        this.mStylesRenderer = new HashMap<>();
        this.mImagesCache = imagesCache == null ? new ImagesCache() : imagesCache;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public Renderer(GoogleMap googleMap, HashMap<? extends Feature, Object> hashMap, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        this(googleMap, (Set<String>) null, new GeoJsonPointStyle(), new GeoJsonLineStringStyle(), new GeoJsonPolygonStyle(), (BiMultiMap<Feature>) null, markerManager, polygonManager, polylineManager, groundOverlayManager);
        HashMap<? extends Feature, Object> hashMap2 = hashMap;
        this.mFeatures.putAll(hashMap);
        this.mImagesCache = null;
    }

    private Renderer(GoogleMap googleMap, Set<String> set, GeoJsonPointStyle geoJsonPointStyle, GeoJsonLineStringStyle geoJsonLineStringStyle, GeoJsonPolygonStyle geoJsonPolygonStyle, BiMultiMap<Feature> biMultiMap, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        this.mFeatures = new BiMultiMap<>();
        this.mNumActiveDownloads = 0;
        this.mMap = googleMap;
        this.mLayerOnMap = false;
        this.mMarkerIconUrls = set;
        this.mDefaultPointStyle = geoJsonPointStyle;
        this.mDefaultLineStringStyle = geoJsonLineStringStyle;
        this.mDefaultPolygonStyle = geoJsonPolygonStyle;
        this.mContainerFeatures = biMultiMap;
        if (googleMap != null) {
            this.mMarkers = (markerManager == null ? new MarkerManager(googleMap) : markerManager).newCollection();
            this.mPolygons = (polygonManager == null ? new PolygonManager(googleMap) : polygonManager).newCollection();
            this.mPolylines = (polylineManager == null ? new PolylineManager(googleMap) : polylineManager).newCollection();
            this.mGroundOverlays = (groundOverlayManager == null ? new GroundOverlayManager(googleMap) : groundOverlayManager).newCollection();
            return;
        }
        this.mMarkers = null;
        this.mPolygons = null;
        this.mPolylines = null;
        this.mGroundOverlays = null;
    }

    /* access modifiers changed from: protected */
    public void putContainerFeature(Object obj, Feature feature) {
        this.mContainerFeatures.put(feature, obj);
    }

    public Set<Feature> getFeatures() {
        return this.mFeatures.keySet();
    }

    /* access modifiers changed from: package-private */
    public Feature getFeature(Object obj) {
        return this.mFeatures.getKey(obj);
    }

    /* access modifiers changed from: package-private */
    public Feature getContainerFeature(Object obj) {
        BiMultiMap<Feature> biMultiMap = this.mContainerFeatures;
        if (biMultiMap != null) {
            return biMultiMap.getKey(obj);
        }
        return null;
    }

    public Collection<Object> getValues() {
        return this.mFeatures.values();
    }

    /* access modifiers changed from: protected */
    public BitmapDescriptor getCachedMarkerImage(String str, double d) {
        Bitmap bitmap;
        String format = sScaleFormat.format(d);
        Map map = this.mImagesCache.markerImagesCache.get(str);
        BitmapDescriptor bitmapDescriptor = map != null ? (BitmapDescriptor) map.get(format) : null;
        if (bitmapDescriptor != null || (bitmap = this.mImagesCache.bitmapCache.get(str)) == null) {
            return bitmapDescriptor;
        }
        BitmapDescriptor scaleIcon = scaleIcon(bitmap, d);
        putMarkerImagesCache(str, format, scaleIcon);
        return scaleIcon;
    }

    private BitmapDescriptor scaleIcon(Bitmap bitmap, double d) {
        int i;
        int i2 = (int) (((double) (this.mContext.getResources().getDisplayMetrics().density * 32.0f)) * d);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width < height) {
            i = (int) (((float) (height * i2)) / ((float) width));
        } else if (width > height) {
            int i3 = (int) (((float) (width * i2)) / ((float) height));
            i = i2;
            i2 = i3;
        } else {
            i = i2;
        }
        return BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(bitmap, i2, i, false));
    }

    /* access modifiers changed from: protected */
    public BitmapDescriptor getCachedGroundOverlayImage(String str) {
        Bitmap bitmap;
        BitmapDescriptor bitmapDescriptor = this.mImagesCache.groundOverlayImagesCache.get(str);
        if (bitmapDescriptor != null || (bitmap = this.mImagesCache.bitmapCache.get(str)) == null) {
            return bitmapDescriptor;
        }
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap(bitmap);
        this.mImagesCache.groundOverlayImagesCache.put(str, fromBitmap);
        return fromBitmap;
    }

    /* access modifiers changed from: protected */
    public KmlStyle getPlacemarkStyle(String str) {
        return this.mStylesRenderer.get(str) != null ? this.mStylesRenderer.get(str) : this.mStylesRenderer.get((Object) null);
    }

    /* access modifiers changed from: protected */
    public void putFeatures(Feature feature, Object obj) {
        this.mFeatures.put(feature, obj);
    }

    /* access modifiers changed from: protected */
    public void putStyles() {
        this.mStylesRenderer.putAll(this.mStyles);
    }

    /* access modifiers changed from: protected */
    public void putStyles(HashMap<String, KmlStyle> hashMap) {
        this.mStylesRenderer.putAll(hashMap);
    }

    private void putMarkerImagesCache(String str, String str2, BitmapDescriptor bitmapDescriptor) {
        Map map = this.mImagesCache.markerImagesCache.get(str);
        if (map == null) {
            map = new HashMap();
            this.mImagesCache.markerImagesCache.put(str, map);
        }
        map.put(str2, bitmapDescriptor);
    }

    /* access modifiers changed from: protected */
    public void cacheBitmap(String str, Bitmap bitmap) {
        this.mImagesCache.bitmapCache.put(str, bitmap);
    }

    /* access modifiers changed from: protected */
    public void downloadFinished() {
        this.mNumActiveDownloads--;
        checkClearBitmapCache();
    }

    /* access modifiers changed from: protected */
    public void checkClearBitmapCache() {
        ImagesCache imagesCache;
        if (this.mNumActiveDownloads == 0 && (imagesCache = this.mImagesCache) != null && !imagesCache.bitmapCache.isEmpty()) {
            this.mImagesCache.bitmapCache.clear();
        }
    }

    /* access modifiers changed from: protected */
    public boolean hasFeatures() {
        return this.mFeatures.size() > 0;
    }

    /* access modifiers changed from: protected */
    public void removeFeatures(HashMap<? extends Feature, Object> hashMap) {
        removeFeatures((Collection) hashMap.values());
    }

    private void removeFeatures(Collection collection) {
        for (Object next : collection) {
            if (next instanceof Collection) {
                removeFeatures((Collection) next);
            } else if (next instanceof Marker) {
                this.mMarkers.remove((Marker) next);
            } else if (next instanceof Polyline) {
                this.mPolylines.remove((Polyline) next);
            } else if (next instanceof Polygon) {
                this.mPolygons.remove((Polygon) next);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeGroundOverlays(HashMap<KmlGroundOverlay, GroundOverlay> hashMap) {
        for (GroundOverlay next : hashMap.values()) {
            if (next != null) {
                this.mGroundOverlays.remove(next);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void removeFeature(Feature feature) {
        if (this.mFeatures.containsKey(feature)) {
            removeFromMap(this.mFeatures.remove(feature));
        }
    }

    private void setFeatureDefaultStyles(GeoJsonFeature geoJsonFeature) {
        if (geoJsonFeature.getPointStyle() == null) {
            geoJsonFeature.setPointStyle(this.mDefaultPointStyle);
        }
        if (geoJsonFeature.getLineStringStyle() == null) {
            geoJsonFeature.setLineStringStyle(this.mDefaultLineStringStyle);
        }
        if (geoJsonFeature.getPolygonStyle() == null) {
            geoJsonFeature.setPolygonStyle(this.mDefaultPolygonStyle);
        }
    }

    /* access modifiers changed from: protected */
    public void clearStylesRenderer() {
        this.mStylesRenderer.clear();
    }

    /* access modifiers changed from: protected */
    public void storeData(HashMap<String, KmlStyle> hashMap, HashMap<String, String> hashMap2, HashMap<KmlPlacemark, Object> hashMap3, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> hashMap4) {
        this.mStyles = hashMap;
        this.mStyleMaps = hashMap2;
        this.mFeatures.putAll(hashMap3);
        this.mContainers = arrayList;
        this.mGroundOverlayMap = hashMap4;
    }

    /* access modifiers changed from: protected */
    public void addFeature(Feature feature) {
        Object obj = FEATURE_NOT_ON_MAP;
        if (feature instanceof GeoJsonFeature) {
            setFeatureDefaultStyles((GeoJsonFeature) feature);
        }
        if (this.mLayerOnMap) {
            if (this.mFeatures.containsKey(feature)) {
                removeFromMap(this.mFeatures.get(feature));
            }
            if (feature.hasGeometry()) {
                if (feature instanceof KmlPlacemark) {
                    KmlPlacemark kmlPlacemark = (KmlPlacemark) feature;
                    obj = addKmlPlacemarkToMap(kmlPlacemark, feature.getGeometry(), getPlacemarkStyle(feature.getId()), kmlPlacemark.getInlineStyle(), getPlacemarkVisibility(feature));
                } else {
                    obj = addGeoJsonFeatureToMap(feature, feature.getGeometry());
                }
            }
        }
        this.mFeatures.put(feature, obj);
    }

    /* access modifiers changed from: protected */
    public void removeFromMap(Object obj) {
        if (obj instanceof Marker) {
            this.mMarkers.remove((Marker) obj);
        } else if (obj instanceof Polyline) {
            this.mPolylines.remove((Polyline) obj);
        } else if (obj instanceof Polygon) {
            this.mPolygons.remove((Polygon) obj);
        } else if (obj instanceof GroundOverlay) {
            this.mGroundOverlays.remove((GroundOverlay) obj);
        } else if (obj instanceof ArrayList) {
            Iterator it = ((ArrayList) obj).iterator();
            while (it.hasNext()) {
                removeFromMap(it.next());
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.maps.model.PolygonOptions} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.google.android.gms.maps.model.PolylineOptions} */
    /* JADX WARNING: type inference failed for: r0v1 */
    /* JADX WARNING: type inference failed for: r0v2, types: [com.google.android.gms.maps.model.MarkerOptions] */
    /* JADX WARNING: type inference failed for: r0v18 */
    /* JADX WARNING: type inference failed for: r0v19 */
    /* JADX WARNING: type inference failed for: r0v20 */
    /* JADX WARNING: type inference failed for: r0v21 */
    /* JADX WARNING: type inference failed for: r0v22 */
    /* JADX WARNING: type inference failed for: r0v23 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object addGeoJsonFeatureToMap(com.google.maps.android.data.Feature r4, com.google.maps.android.data.Geometry r5) {
        /*
            r3 = this;
            java.lang.String r0 = r5.getGeometryType()
            r0.hashCode()
            int r1 = r0.hashCode()
            r2 = -1
            switch(r1) {
                case -2116761119: goto L_0x0052;
                case -1065891849: goto L_0x0047;
                case -627102946: goto L_0x003c;
                case 77292912: goto L_0x0031;
                case 1267133722: goto L_0x0026;
                case 1806700869: goto L_0x001b;
                case 1950410960: goto L_0x0010;
                default: goto L_0x000f;
            }
        L_0x000f:
            goto L_0x005c
        L_0x0010:
            java.lang.String r1 = "GeometryCollection"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0019
            goto L_0x005c
        L_0x0019:
            r2 = 6
            goto L_0x005c
        L_0x001b:
            java.lang.String r1 = "LineString"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0024
            goto L_0x005c
        L_0x0024:
            r2 = 5
            goto L_0x005c
        L_0x0026:
            java.lang.String r1 = "Polygon"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002f
            goto L_0x005c
        L_0x002f:
            r2 = 4
            goto L_0x005c
        L_0x0031:
            java.lang.String r1 = "Point"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003a
            goto L_0x005c
        L_0x003a:
            r2 = 3
            goto L_0x005c
        L_0x003c:
            java.lang.String r1 = "MultiLineString"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0045
            goto L_0x005c
        L_0x0045:
            r2 = 2
            goto L_0x005c
        L_0x0047:
            java.lang.String r1 = "MultiPoint"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0050
            goto L_0x005c
        L_0x0050:
            r2 = 1
            goto L_0x005c
        L_0x0052:
            java.lang.String r1 = "MultiPolygon"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x005b
            goto L_0x005c
        L_0x005b:
            r2 = 0
        L_0x005c:
            r0 = 0
            switch(r2) {
                case 0: goto L_0x00dc;
                case 1: goto L_0x00cf;
                case 2: goto L_0x00c2;
                case 3: goto L_0x00a6;
                case 4: goto L_0x008a;
                case 5: goto L_0x006e;
                case 6: goto L_0x0061;
                default: goto L_0x0060;
            }
        L_0x0060:
            return r0
        L_0x0061:
            com.google.maps.android.data.geojson.GeoJsonFeature r4 = (com.google.maps.android.data.geojson.GeoJsonFeature) r4
            com.google.maps.android.data.geojson.GeoJsonGeometryCollection r5 = (com.google.maps.android.data.geojson.GeoJsonGeometryCollection) r5
            java.util.List r5 = r5.getGeometries()
            java.util.ArrayList r4 = r3.addGeometryCollectionToMap(r4, r5)
            return r4
        L_0x006e:
            boolean r1 = r4 instanceof com.google.maps.android.data.geojson.GeoJsonFeature
            if (r1 == 0) goto L_0x0079
            com.google.maps.android.data.geojson.GeoJsonFeature r4 = (com.google.maps.android.data.geojson.GeoJsonFeature) r4
            com.google.android.gms.maps.model.PolylineOptions r0 = r4.getPolylineOptions()
            goto L_0x0083
        L_0x0079:
            boolean r1 = r4 instanceof com.google.maps.android.data.kml.KmlPlacemark
            if (r1 == 0) goto L_0x0083
            com.google.maps.android.data.kml.KmlPlacemark r4 = (com.google.maps.android.data.kml.KmlPlacemark) r4
            com.google.android.gms.maps.model.PolylineOptions r0 = r4.getPolylineOptions()
        L_0x0083:
            com.google.maps.android.data.geojson.GeoJsonLineString r5 = (com.google.maps.android.data.geojson.GeoJsonLineString) r5
            com.google.android.gms.maps.model.Polyline r4 = r3.addLineStringToMap(r0, r5)
            return r4
        L_0x008a:
            boolean r1 = r4 instanceof com.google.maps.android.data.geojson.GeoJsonFeature
            if (r1 == 0) goto L_0x0095
            com.google.maps.android.data.geojson.GeoJsonFeature r4 = (com.google.maps.android.data.geojson.GeoJsonFeature) r4
            com.google.android.gms.maps.model.PolygonOptions r0 = r4.getPolygonOptions()
            goto L_0x009f
        L_0x0095:
            boolean r1 = r4 instanceof com.google.maps.android.data.kml.KmlPlacemark
            if (r1 == 0) goto L_0x009f
            com.google.maps.android.data.kml.KmlPlacemark r4 = (com.google.maps.android.data.kml.KmlPlacemark) r4
            com.google.android.gms.maps.model.PolygonOptions r0 = r4.getPolygonOptions()
        L_0x009f:
            com.google.maps.android.data.DataPolygon r5 = (com.google.maps.android.data.DataPolygon) r5
            com.google.android.gms.maps.model.Polygon r4 = r3.addPolygonToMap(r0, r5)
            return r4
        L_0x00a6:
            boolean r1 = r4 instanceof com.google.maps.android.data.geojson.GeoJsonFeature
            if (r1 == 0) goto L_0x00b1
            com.google.maps.android.data.geojson.GeoJsonFeature r4 = (com.google.maps.android.data.geojson.GeoJsonFeature) r4
            com.google.android.gms.maps.model.MarkerOptions r0 = r4.getMarkerOptions()
            goto L_0x00bb
        L_0x00b1:
            boolean r1 = r4 instanceof com.google.maps.android.data.kml.KmlPlacemark
            if (r1 == 0) goto L_0x00bb
            com.google.maps.android.data.kml.KmlPlacemark r4 = (com.google.maps.android.data.kml.KmlPlacemark) r4
            com.google.android.gms.maps.model.MarkerOptions r0 = r4.getMarkerOptions()
        L_0x00bb:
            com.google.maps.android.data.geojson.GeoJsonPoint r5 = (com.google.maps.android.data.geojson.GeoJsonPoint) r5
            com.google.android.gms.maps.model.Marker r4 = r3.addPointToMap(r0, r5)
            return r4
        L_0x00c2:
            com.google.maps.android.data.geojson.GeoJsonFeature r4 = (com.google.maps.android.data.geojson.GeoJsonFeature) r4
            com.google.maps.android.data.geojson.GeoJsonLineStringStyle r4 = r4.getLineStringStyle()
            com.google.maps.android.data.geojson.GeoJsonMultiLineString r5 = (com.google.maps.android.data.geojson.GeoJsonMultiLineString) r5
            java.util.ArrayList r4 = r3.addMultiLineStringToMap(r4, r5)
            return r4
        L_0x00cf:
            com.google.maps.android.data.geojson.GeoJsonFeature r4 = (com.google.maps.android.data.geojson.GeoJsonFeature) r4
            com.google.maps.android.data.geojson.GeoJsonPointStyle r4 = r4.getPointStyle()
            com.google.maps.android.data.geojson.GeoJsonMultiPoint r5 = (com.google.maps.android.data.geojson.GeoJsonMultiPoint) r5
            java.util.ArrayList r4 = r3.addMultiPointToMap(r4, r5)
            return r4
        L_0x00dc:
            com.google.maps.android.data.geojson.GeoJsonFeature r4 = (com.google.maps.android.data.geojson.GeoJsonFeature) r4
            com.google.maps.android.data.geojson.GeoJsonPolygonStyle r4 = r4.getPolygonStyle()
            com.google.maps.android.data.geojson.GeoJsonMultiPolygon r5 = (com.google.maps.android.data.geojson.GeoJsonMultiPolygon) r5
            java.util.ArrayList r4 = r3.addMultiPolygonToMap(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.data.Renderer.addGeoJsonFeatureToMap(com.google.maps.android.data.Feature, com.google.maps.android.data.Geometry):java.lang.Object");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        if (r0.equals("Point") == false) goto L_0x002a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object addKmlPlacemarkToMap(com.google.maps.android.data.kml.KmlPlacemark r13, com.google.maps.android.data.Geometry r14, com.google.maps.android.data.kml.KmlStyle r15, com.google.maps.android.data.kml.KmlStyle r16, boolean r17) {
        /*
            r12 = this;
            r6 = r12
            r1 = r13
            r3 = r15
            r4 = r16
            r5 = r17
            java.lang.String r0 = r14.getGeometryType()
            java.lang.String r2 = "drawOrder"
            boolean r7 = r13.hasProperty(r2)
            r8 = 0
            r9 = 0
            if (r7 == 0) goto L_0x001f
            java.lang.String r2 = r13.getProperty(r2)     // Catch:{ NumberFormatException -> 0x001e }
            float r9 = java.lang.Float.parseFloat(r2)     // Catch:{ NumberFormatException -> 0x001e }
            goto L_0x001f
        L_0x001e:
            r7 = r8
        L_0x001f:
            r0.hashCode()
            int r2 = r0.hashCode()
            r10 = -1
            switch(r2) {
                case 77292912: goto L_0x004d;
                case 89139371: goto L_0x0042;
                case 1267133722: goto L_0x0037;
                case 1806700869: goto L_0x002c;
                default: goto L_0x002a;
            }
        L_0x002a:
            r8 = r10
            goto L_0x0056
        L_0x002c:
            java.lang.String r2 = "LineString"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0035
            goto L_0x002a
        L_0x0035:
            r8 = 3
            goto L_0x0056
        L_0x0037:
            java.lang.String r2 = "Polygon"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0040
            goto L_0x002a
        L_0x0040:
            r8 = 2
            goto L_0x0056
        L_0x0042:
            java.lang.String r2 = "MultiGeometry"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x004b
            goto L_0x002a
        L_0x004b:
            r8 = 1
            goto L_0x0056
        L_0x004d:
            java.lang.String r2 = "Point"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0056
            goto L_0x002a
        L_0x0056:
            switch(r8) {
                case 0: goto L_0x00c0;
                case 1: goto L_0x00b1;
                case 2: goto L_0x0086;
                case 3: goto L_0x005b;
                default: goto L_0x0059;
            }
        L_0x0059:
            r0 = 0
            return r0
        L_0x005b:
            com.google.android.gms.maps.model.PolylineOptions r0 = r15.getPolylineOptions()
            if (r4 == 0) goto L_0x0065
            r12.setInlineLineStringStyle(r0, r4)
            goto L_0x0076
        L_0x0065:
            boolean r1 = r15.isLineRandomColorMode()
            if (r1 == 0) goto L_0x0076
            int r1 = r0.getColor()
            int r1 = com.google.maps.android.data.kml.KmlStyle.computeRandomColor(r1)
            r0.color(r1)
        L_0x0076:
            r1 = r14
            com.google.maps.android.data.LineString r1 = (com.google.maps.android.data.LineString) r1
            com.google.android.gms.maps.model.Polyline r0 = r12.addLineStringToMap(r0, r1)
            r0.setVisible(r5)
            if (r7 == 0) goto L_0x0085
            r0.setZIndex(r9)
        L_0x0085:
            return r0
        L_0x0086:
            com.google.android.gms.maps.model.PolygonOptions r0 = r15.getPolygonOptions()
            if (r4 == 0) goto L_0x0090
            r12.setInlinePolygonStyle(r0, r4)
            goto L_0x00a1
        L_0x0090:
            boolean r1 = r15.isPolyRandomColorMode()
            if (r1 == 0) goto L_0x00a1
            int r1 = r0.getFillColor()
            int r1 = com.google.maps.android.data.kml.KmlStyle.computeRandomColor(r1)
            r0.fillColor(r1)
        L_0x00a1:
            r1 = r14
            com.google.maps.android.data.DataPolygon r1 = (com.google.maps.android.data.DataPolygon) r1
            com.google.android.gms.maps.model.Polygon r0 = r12.addPolygonToMap(r0, r1)
            r0.setVisible(r5)
            if (r7 == 0) goto L_0x00b0
            r0.setZIndex(r9)
        L_0x00b0:
            return r0
        L_0x00b1:
            r2 = r14
            com.google.maps.android.data.kml.KmlMultiGeometry r2 = (com.google.maps.android.data.kml.KmlMultiGeometry) r2
            r0 = r12
            r1 = r13
            r3 = r15
            r4 = r16
            r5 = r17
            java.util.ArrayList r0 = r0.addMultiGeometryToMap(r1, r2, r3, r4, r5)
            return r0
        L_0x00c0:
            com.google.android.gms.maps.model.MarkerOptions r0 = r15.getMarkerOptions()
            if (r4 == 0) goto L_0x00ca
            r12.setInlinePointStyle(r0, r4, r15)
            goto L_0x00db
        L_0x00ca:
            java.lang.String r2 = r15.getIconUrl()
            if (r2 == 0) goto L_0x00db
            java.lang.String r2 = r15.getIconUrl()
            double r10 = r15.getIconScale()
            r12.addMarkerIcons(r2, r10, r0)
        L_0x00db:
            r2 = r14
            com.google.maps.android.data.kml.KmlPoint r2 = (com.google.maps.android.data.kml.KmlPoint) r2
            com.google.android.gms.maps.model.Marker r0 = r12.addPointToMap(r0, r2)
            r0.setVisible(r5)
            r12.setMarkerInfoWindow(r15, r0, r13)
            if (r7 == 0) goto L_0x00ed
            r0.setZIndex(r9)
        L_0x00ed:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.data.Renderer.addKmlPlacemarkToMap(com.google.maps.android.data.kml.KmlPlacemark, com.google.maps.android.data.Geometry, com.google.maps.android.data.kml.KmlStyle, com.google.maps.android.data.kml.KmlStyle, boolean):java.lang.Object");
    }

    private Marker addPointToMap(MarkerOptions markerOptions, Point point) {
        markerOptions.position(point.getGeometryObject());
        return this.mMarkers.addMarker(markerOptions);
    }

    private void setInlinePointStyle(MarkerOptions markerOptions, KmlStyle kmlStyle, KmlStyle kmlStyle2) {
        double d;
        MarkerOptions markerOptions2 = kmlStyle.getMarkerOptions();
        if (kmlStyle.isStyleSet("heading")) {
            markerOptions.rotation(markerOptions2.getRotation());
        }
        if (kmlStyle.isStyleSet("hotSpot")) {
            markerOptions.anchor(markerOptions2.getAnchorU(), markerOptions2.getAnchorV());
        }
        if (kmlStyle.isStyleSet("markerColor")) {
            markerOptions.icon(markerOptions2.getIcon());
        }
        if (kmlStyle.isStyleSet("iconScale")) {
            d = kmlStyle.getIconScale();
        } else {
            d = kmlStyle2.isStyleSet("iconScale") ? kmlStyle2.getIconScale() : 1.0d;
        }
        if (kmlStyle.isStyleSet(b.j)) {
            addMarkerIcons(kmlStyle.getIconUrl(), d, markerOptions);
        } else if (kmlStyle2.getIconUrl() != null) {
            addMarkerIcons(kmlStyle2.getIconUrl(), d, markerOptions);
        }
    }

    private Polyline addLineStringToMap(PolylineOptions polylineOptions, LineString lineString) {
        polylineOptions.addAll(lineString.getGeometryObject());
        Polyline addPolyline = this.mPolylines.addPolyline(polylineOptions);
        addPolyline.setClickable(polylineOptions.isClickable());
        return addPolyline;
    }

    private void setInlineLineStringStyle(PolylineOptions polylineOptions, KmlStyle kmlStyle) {
        PolylineOptions polylineOptions2 = kmlStyle.getPolylineOptions();
        if (kmlStyle.isStyleSet("outlineColor")) {
            polylineOptions.color(polylineOptions2.getColor());
        }
        if (kmlStyle.isStyleSet("width")) {
            polylineOptions.width(polylineOptions2.getWidth());
        }
        if (kmlStyle.isLineRandomColorMode()) {
            polylineOptions.color(KmlStyle.computeRandomColor(polylineOptions2.getColor()));
        }
    }

    private Polygon addPolygonToMap(PolygonOptions polygonOptions, DataPolygon dataPolygon) {
        polygonOptions.addAll(dataPolygon.getOuterBoundaryCoordinates());
        for (List<LatLng> addHole : dataPolygon.getInnerBoundaryCoordinates()) {
            polygonOptions.addHole(addHole);
        }
        Polygon addPolygon = this.mPolygons.addPolygon(polygonOptions);
        addPolygon.setClickable(polygonOptions.isClickable());
        return addPolygon;
    }

    private void setInlinePolygonStyle(PolygonOptions polygonOptions, KmlStyle kmlStyle) {
        PolygonOptions polygonOptions2 = kmlStyle.getPolygonOptions();
        if (kmlStyle.hasFill() && kmlStyle.isStyleSet("fillColor")) {
            polygonOptions.fillColor(polygonOptions2.getFillColor());
        }
        if (kmlStyle.hasOutline()) {
            if (kmlStyle.isStyleSet("outlineColor")) {
                polygonOptions.strokeColor(polygonOptions2.getStrokeColor());
            }
            if (kmlStyle.isStyleSet("width")) {
                polygonOptions.strokeWidth(polygonOptions2.getStrokeWidth());
            }
        }
        if (kmlStyle.isPolyRandomColorMode()) {
            polygonOptions.fillColor(KmlStyle.computeRandomColor(polygonOptions2.getFillColor()));
        }
    }

    private ArrayList<Object> addGeometryCollectionToMap(GeoJsonFeature geoJsonFeature, List<Geometry> list) {
        ArrayList<Object> arrayList = new ArrayList<>();
        for (Geometry addGeoJsonFeatureToMap : list) {
            arrayList.add(addGeoJsonFeatureToMap(geoJsonFeature, addGeoJsonFeatureToMap));
        }
        return arrayList;
    }

    protected static boolean getPlacemarkVisibility(Feature feature) {
        return !feature.hasProperty("visibility") || Integer.parseInt(feature.getProperty("visibility")) != 0;
    }

    public void assignStyleMap(HashMap<String, String> hashMap, HashMap<String, KmlStyle> hashMap2) {
        for (String next : hashMap.keySet()) {
            String str = hashMap.get(next);
            if (hashMap2.containsKey(str)) {
                hashMap2.put(next, hashMap2.get(str));
            }
        }
    }

    private ArrayList<Object> addMultiGeometryToMap(KmlPlacemark kmlPlacemark, KmlMultiGeometry kmlMultiGeometry, KmlStyle kmlStyle, KmlStyle kmlStyle2, boolean z) {
        ArrayList<Object> arrayList = new ArrayList<>();
        Iterator it = kmlMultiGeometry.getGeometryObject().iterator();
        while (it.hasNext()) {
            arrayList.add(addKmlPlacemarkToMap(kmlPlacemark, (Geometry) it.next(), kmlStyle, kmlStyle2, z));
        }
        return arrayList;
    }

    private ArrayList<Marker> addMultiPointToMap(GeoJsonPointStyle geoJsonPointStyle, GeoJsonMultiPoint geoJsonMultiPoint) {
        ArrayList<Marker> arrayList = new ArrayList<>();
        for (GeoJsonPoint addPointToMap : geoJsonMultiPoint.getPoints()) {
            arrayList.add(addPointToMap(geoJsonPointStyle.toMarkerOptions(), addPointToMap));
        }
        return arrayList;
    }

    private ArrayList<Polyline> addMultiLineStringToMap(GeoJsonLineStringStyle geoJsonLineStringStyle, GeoJsonMultiLineString geoJsonMultiLineString) {
        ArrayList<Polyline> arrayList = new ArrayList<>();
        for (GeoJsonLineString addLineStringToMap : geoJsonMultiLineString.getLineStrings()) {
            arrayList.add(addLineStringToMap(geoJsonLineStringStyle.toPolylineOptions(), addLineStringToMap));
        }
        return arrayList;
    }

    private ArrayList<Polygon> addMultiPolygonToMap(GeoJsonPolygonStyle geoJsonPolygonStyle, GeoJsonMultiPolygon geoJsonMultiPolygon) {
        ArrayList<Polygon> arrayList = new ArrayList<>();
        for (GeoJsonPolygon addPolygonToMap : geoJsonMultiPolygon.getPolygons()) {
            arrayList.add(addPolygonToMap(geoJsonPolygonStyle.toPolygonOptions(), addPolygonToMap));
        }
        return arrayList;
    }

    private void addMarkerIcons(String str, double d, MarkerOptions markerOptions) {
        BitmapDescriptor cachedMarkerImage = getCachedMarkerImage(str, d);
        if (cachedMarkerImage != null) {
            markerOptions.icon(cachedMarkerImage);
        } else {
            this.mMarkerIconUrls.add(str);
        }
    }

    /* access modifiers changed from: protected */
    public GroundOverlay attachGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        return this.mGroundOverlays.addGroundOverlay(groundOverlayOptions);
    }

    private void setMarkerInfoWindow(KmlStyle kmlStyle, Marker marker, KmlPlacemark kmlPlacemark) {
        boolean hasProperty = kmlPlacemark.hasProperty("name");
        boolean hasProperty2 = kmlPlacemark.hasProperty(b.c);
        boolean hasBalloonStyle = kmlStyle.hasBalloonStyle();
        boolean containsKey = kmlStyle.getBalloonOptions().containsKey("text");
        if (hasBalloonStyle && containsKey) {
            marker.setTitle(KmlUtil.substituteProperties(kmlStyle.getBalloonOptions().get("text"), kmlPlacemark));
            createInfoWindow();
        } else if (hasBalloonStyle && hasProperty) {
            marker.setTitle(kmlPlacemark.getProperty("name"));
            createInfoWindow();
        } else if (hasProperty && hasProperty2) {
            marker.setTitle(kmlPlacemark.getProperty("name"));
            marker.setSnippet(kmlPlacemark.getProperty(b.c));
            createInfoWindow();
        } else if (hasProperty2) {
            marker.setTitle(kmlPlacemark.getProperty(b.c));
            createInfoWindow();
        } else if (hasProperty) {
            marker.setTitle(kmlPlacemark.getProperty("name"));
            createInfoWindow();
        }
    }

    private void createInfoWindow() {
        this.mMarkers.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            public View getInfoWindow(Marker marker) {
                return null;
            }

            public View getInfoContents(Marker marker) {
                View inflate = LayoutInflater.from(Renderer.this.mContext).inflate(R.layout.amu_info_window, (ViewGroup) null);
                TextView textView = (TextView) inflate.findViewById(R.id.window);
                if (marker.getSnippet() != null) {
                    textView.setText(Html.fromHtml(marker.getTitle() + "<br>" + marker.getSnippet()));
                } else {
                    textView.setText(Html.fromHtml(marker.getTitle()));
                }
                return inflate;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setOnFeatureClickListener(Layer.OnFeatureClickListener onFeatureClickListener) {
        this.mPolygons.setOnPolygonClickListener(new Renderer$$ExternalSyntheticLambda0(this, onFeatureClickListener));
        this.mMarkers.setOnMarkerClickListener(new Renderer$$ExternalSyntheticLambda1(this, onFeatureClickListener));
        this.mPolylines.setOnPolylineClickListener(new Renderer$$ExternalSyntheticLambda2(this, onFeatureClickListener));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setOnFeatureClickListener$0$com-google-maps-android-data-Renderer  reason: not valid java name */
    public /* synthetic */ void m989lambda$setOnFeatureClickListener$0$comgooglemapsandroiddataRenderer(Layer.OnFeatureClickListener onFeatureClickListener, Polygon polygon) {
        if (getFeature(polygon) != null) {
            onFeatureClickListener.onFeatureClick(getFeature(polygon));
        } else if (getContainerFeature(polygon) != null) {
            onFeatureClickListener.onFeatureClick(getContainerFeature(polygon));
        } else {
            onFeatureClickListener.onFeatureClick(getFeature(multiObjectHandler(polygon)));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setOnFeatureClickListener$1$com-google-maps-android-data-Renderer  reason: not valid java name */
    public /* synthetic */ boolean m990lambda$setOnFeatureClickListener$1$comgooglemapsandroiddataRenderer(Layer.OnFeatureClickListener onFeatureClickListener, Marker marker) {
        if (getFeature(marker) != null) {
            onFeatureClickListener.onFeatureClick(getFeature(marker));
            return false;
        } else if (getContainerFeature(marker) != null) {
            onFeatureClickListener.onFeatureClick(getContainerFeature(marker));
            return false;
        } else {
            onFeatureClickListener.onFeatureClick(getFeature(multiObjectHandler(marker)));
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setOnFeatureClickListener$2$com-google-maps-android-data-Renderer  reason: not valid java name */
    public /* synthetic */ void m991lambda$setOnFeatureClickListener$2$comgooglemapsandroiddataRenderer(Layer.OnFeatureClickListener onFeatureClickListener, Polyline polyline) {
        if (getFeature(polyline) != null) {
            onFeatureClickListener.onFeatureClick(getFeature(polyline));
        } else if (getContainerFeature(polyline) != null) {
            onFeatureClickListener.onFeatureClick(getContainerFeature(polyline));
        } else {
            onFeatureClickListener.onFeatureClick(getFeature(multiObjectHandler(polyline)));
        }
    }

    private ArrayList<?> multiObjectHandler(Object obj) {
        for (Object next : getValues()) {
            if (next.getClass().getSimpleName().equals("ArrayList")) {
                ArrayList<?> arrayList = (ArrayList) next;
                if (arrayList.contains(obj)) {
                    return arrayList;
                }
            }
        }
        return null;
    }
}
