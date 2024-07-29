package com.google.maps.android.data.kml;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import com.google.maps.android.data.Renderer;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class KmlRenderer extends Renderer {
    private static final String LOG_TAG = "KmlRenderer";
    /* access modifiers changed from: private */
    public ArrayList<KmlContainer> mContainers;
    private boolean mGroundOverlayImagesDownloaded = false;
    private final Set<String> mGroundOverlayUrls = new HashSet();
    private boolean mMarkerIconsDownloaded = false;

    public Iterable<KmlContainer> getNestedContainers() {
        return this.mContainers;
    }

    KmlRenderer(GoogleMap googleMap, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, Renderer.ImagesCache imagesCache) {
        super(googleMap, context, markerManager, polygonManager, polylineManager, groundOverlayManager, imagesCache);
    }

    private void removePlacemarks(HashMap<? extends Feature, Object> hashMap) {
        removeFeatures(hashMap);
    }

    static boolean getContainerVisibility(KmlContainer kmlContainer, boolean z) {
        boolean z2 = !kmlContainer.hasProperty("visibility") || Integer.parseInt(kmlContainer.getProperty("visibility")) != 0;
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    private void removeContainers(Iterable<KmlContainer> iterable) {
        for (KmlContainer next : iterable) {
            removePlacemarks(next.getPlacemarksHashMap());
            removeGroundOverlays(next.getGroundOverlayHashMap());
            removeContainers(next.getContainers());
        }
    }

    public void addLayerToMap() {
        setLayerVisibility(true);
        this.mContainers = getContainerList();
        putStyles();
        assignStyleMap(getStyleMaps(), getStylesRenderer());
        addGroundOverlays(getGroundOverlayMap(), this.mContainers);
        addContainerGroupToMap(this.mContainers, true);
        addPlacemarksToMap(getAllFeatures());
        if (!this.mGroundOverlayImagesDownloaded) {
            downloadGroundOverlays();
        }
        if (!this.mMarkerIconsDownloaded) {
            downloadMarkerIcons();
        }
        checkClearBitmapCache();
    }

    /* access modifiers changed from: package-private */
    public void storeKmlData(HashMap<String, KmlStyle> hashMap, HashMap<String, String> hashMap2, HashMap<KmlPlacemark, Object> hashMap3, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> hashMap4) {
        storeData(hashMap, hashMap2, hashMap3, arrayList, hashMap4);
    }

    /* access modifiers changed from: package-private */
    public void storeKmzData(HashMap<String, KmlStyle> hashMap, HashMap<String, String> hashMap2, HashMap<KmlPlacemark, Object> hashMap3, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> hashMap4, HashMap<String, Bitmap> hashMap5) {
        storeData(hashMap, hashMap2, hashMap3, arrayList, hashMap4);
        for (Map.Entry next : hashMap5.entrySet()) {
            cacheBitmap((String) next.getKey(), (Bitmap) next.getValue());
        }
    }

    public void setMap(GoogleMap googleMap) {
        removeLayerFromMap();
        super.setMap(googleMap);
        addLayerToMap();
    }

    /* access modifiers changed from: package-private */
    public boolean hasKmlPlacemarks() {
        return hasFeatures();
    }

    /* access modifiers changed from: package-private */
    public Iterable<? extends Feature> getKmlPlacemarks() {
        return getFeatures();
    }

    public boolean hasNestedContainers() {
        return this.mContainers.size() > 0;
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return getGroundOverlayMap().keySet();
    }

    public void removeLayerFromMap() {
        removePlacemarks(getAllFeatures());
        removeGroundOverlays(getGroundOverlayMap());
        if (hasNestedContainers()) {
            removeContainers(getNestedContainers());
        }
        setLayerVisibility(false);
        clearStylesRenderer();
    }

    private void addPlacemarksToMap(HashMap<? extends Feature, Object> hashMap) {
        for (Feature addFeature : hashMap.keySet()) {
            addFeature(addFeature);
        }
    }

    private void addContainerGroupToMap(Iterable<KmlContainer> iterable, boolean z) {
        for (KmlContainer next : iterable) {
            boolean containerVisibility = getContainerVisibility(next, z);
            if (next.getStyles() != null) {
                putStyles(next.getStyles());
            }
            if (next.getStyleMap() != null) {
                super.assignStyleMap(next.getStyleMap(), getStylesRenderer());
            }
            addContainerObjectToMap(next, containerVisibility);
            if (next.hasContainers()) {
                addContainerGroupToMap(next.getContainers(), containerVisibility);
            }
        }
    }

    private void addContainerObjectToMap(KmlContainer kmlContainer, boolean z) {
        for (Feature next : kmlContainer.getPlacemarks()) {
            boolean z2 = z && getPlacemarkVisibility(next);
            if (next.getGeometry() != null) {
                String id = next.getId();
                Geometry geometry = next.getGeometry();
                KmlStyle placemarkStyle = getPlacemarkStyle(id);
                KmlPlacemark kmlPlacemark = (KmlPlacemark) next;
                Object addKmlPlacemarkToMap = addKmlPlacemarkToMap(kmlPlacemark, geometry, placemarkStyle, kmlPlacemark.getInlineStyle(), z2);
                kmlContainer.setPlacemark(kmlPlacemark, addKmlPlacemarkToMap);
                putContainerFeature(addKmlPlacemarkToMap, next);
            }
        }
    }

    private void downloadMarkerIcons() {
        this.mMarkerIconsDownloaded = true;
        Iterator<String> it = getMarkerIconUrls().iterator();
        while (it.hasNext()) {
            new MarkerIconImageDownload(it.next()).execute(new String[0]);
            it.remove();
        }
    }

    /* access modifiers changed from: private */
    public void addIconToMarkers(String str, HashMap<KmlPlacemark, Object> hashMap) {
        for (Feature next : hashMap.keySet()) {
            addIconToGeometry(str, getStylesRenderer().get(next.getId()), ((KmlPlacemark) next).getInlineStyle(), next.getGeometry(), hashMap.get(next));
        }
    }

    private void addIconToGeometry(String str, KmlStyle kmlStyle, KmlStyle kmlStyle2, Geometry geometry, Object obj) {
        if (geometry != null) {
            if ("Point".equals(geometry.getGeometryType())) {
                addIconToMarker(str, kmlStyle, kmlStyle2, (Marker) obj);
            } else if ("MultiGeometry".equals(geometry.getGeometryType())) {
                addIconToMultiGeometry(str, kmlStyle, kmlStyle2, (MultiGeometry) geometry, (List) obj);
            }
        }
    }

    private void addIconToMultiGeometry(String str, KmlStyle kmlStyle, KmlStyle kmlStyle2, MultiGeometry multiGeometry, List<Object> list) {
        Iterator it = multiGeometry.getGeometryObject().iterator();
        Iterator<Object> it2 = list.iterator();
        while (it.hasNext() && it2.hasNext()) {
            addIconToGeometry(str, kmlStyle, kmlStyle2, (Geometry) it.next(), it2.next());
        }
    }

    private void addIconToMarker(String str, KmlStyle kmlStyle, KmlStyle kmlStyle2, Marker marker) {
        boolean z = true;
        boolean z2 = kmlStyle2 != null && str.equals(kmlStyle2.getIconUrl());
        if (kmlStyle == null || !str.equals(kmlStyle.getIconUrl())) {
            z = false;
        }
        if (z2) {
            scaleBitmap(kmlStyle2, marker);
        } else if (z) {
            scaleBitmap(kmlStyle, marker);
        }
    }

    private void scaleBitmap(KmlStyle kmlStyle, Marker marker) {
        marker.setIcon(getCachedMarkerImage(kmlStyle.getIconUrl(), kmlStyle.getIconScale()));
    }

    /* access modifiers changed from: private */
    public void addContainerGroupIconsToMarkers(String str, Iterable<KmlContainer> iterable) {
        for (KmlContainer next : iterable) {
            addIconToMarkers(str, next.getPlacemarksHashMap());
            if (next.hasContainers()) {
                addContainerGroupIconsToMarkers(str, next.getContainers());
            }
        }
    }

    private void addGroundOverlays(HashMap<KmlGroundOverlay, GroundOverlay> hashMap, Iterable<KmlContainer> iterable) {
        addGroundOverlays(hashMap);
        for (KmlContainer next : iterable) {
            addGroundOverlays(next.getGroundOverlayHashMap(), next.getContainers());
        }
    }

    private void addGroundOverlays(HashMap<KmlGroundOverlay, GroundOverlay> hashMap) {
        for (KmlGroundOverlay next : hashMap.keySet()) {
            String imageUrl = next.getImageUrl();
            if (!(imageUrl == null || next.getLatLngBox() == null)) {
                if (getCachedGroundOverlayImage(imageUrl) != null) {
                    addGroundOverlayToMap(imageUrl, hashMap, true);
                } else {
                    this.mGroundOverlayUrls.add(imageUrl);
                }
            }
        }
    }

    private void downloadGroundOverlays() {
        this.mGroundOverlayImagesDownloaded = true;
        Iterator<String> it = this.mGroundOverlayUrls.iterator();
        while (it.hasNext()) {
            new GroundOverlayImageDownload(it.next()).execute(new String[0]);
            it.remove();
        }
    }

    /* access modifiers changed from: private */
    public void addGroundOverlayToMap(String str, HashMap<KmlGroundOverlay, GroundOverlay> hashMap, boolean z) {
        BitmapDescriptor cachedGroundOverlayImage = getCachedGroundOverlayImage(str);
        for (KmlGroundOverlay next : hashMap.keySet()) {
            if (next.getImageUrl().equals(str)) {
                GroundOverlay attachGroundOverlay = attachGroundOverlay(next.getGroundOverlayOptions().image(cachedGroundOverlayImage));
                if (!z) {
                    attachGroundOverlay.setVisible(false);
                }
                hashMap.put(next, attachGroundOverlay);
            }
        }
    }

    /* access modifiers changed from: private */
    public void addGroundOverlayInContainerGroups(String str, Iterable<KmlContainer> iterable, boolean z) {
        for (KmlContainer next : iterable) {
            boolean containerVisibility = getContainerVisibility(next, z);
            addGroundOverlayToMap(str, next.getGroundOverlayHashMap(), containerVisibility);
            if (next.hasContainers()) {
                addGroundOverlayInContainerGroups(str, next.getContainers(), containerVisibility);
            }
        }
    }

    private class MarkerIconImageDownload extends AsyncTask<String, Void, Bitmap> {
        private final String mIconUrl;

        public MarkerIconImageDownload(String str) {
            this.mIconUrl = str;
            KmlRenderer.this.downloadStarted();
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(String... strArr) {
            try {
                return KmlRenderer.this.getBitmapFromUrl(this.mIconUrl);
            } catch (MalformedURLException unused) {
                return BitmapFactory.decodeFile(this.mIconUrl);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap == null) {
                Log.e(KmlRenderer.LOG_TAG, "Image at this URL could not be found " + this.mIconUrl);
            } else {
                KmlRenderer.this.cacheBitmap(this.mIconUrl, bitmap);
                if (KmlRenderer.this.isLayerOnMap()) {
                    KmlRenderer kmlRenderer = KmlRenderer.this;
                    kmlRenderer.addIconToMarkers(this.mIconUrl, kmlRenderer.getAllFeatures());
                    KmlRenderer kmlRenderer2 = KmlRenderer.this;
                    kmlRenderer2.addContainerGroupIconsToMarkers(this.mIconUrl, kmlRenderer2.mContainers);
                }
            }
            KmlRenderer.this.downloadFinished();
        }
    }

    private class GroundOverlayImageDownload extends AsyncTask<String, Void, Bitmap> {
        private final String mGroundOverlayUrl;

        public GroundOverlayImageDownload(String str) {
            this.mGroundOverlayUrl = str;
            KmlRenderer.this.downloadStarted();
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(String... strArr) {
            try {
                return KmlRenderer.this.getBitmapFromUrl(this.mGroundOverlayUrl);
            } catch (MalformedURLException unused) {
                return BitmapFactory.decodeFile(this.mGroundOverlayUrl);
            } catch (IOException e) {
                Log.e(KmlRenderer.LOG_TAG, "Image [" + this.mGroundOverlayUrl + "] download issue", e);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap == null) {
                Log.e(KmlRenderer.LOG_TAG, "Image at this URL could not be found " + this.mGroundOverlayUrl);
            } else {
                KmlRenderer.this.cacheBitmap(this.mGroundOverlayUrl, bitmap);
                if (KmlRenderer.this.isLayerOnMap()) {
                    KmlRenderer kmlRenderer = KmlRenderer.this;
                    kmlRenderer.addGroundOverlayToMap(this.mGroundOverlayUrl, kmlRenderer.getGroundOverlayMap(), true);
                    KmlRenderer kmlRenderer2 = KmlRenderer.this;
                    kmlRenderer2.addGroundOverlayInContainerGroups(this.mGroundOverlayUrl, kmlRenderer2.mContainers, true);
                }
            }
            KmlRenderer.this.downloadFinished();
        }
    }

    /* access modifiers changed from: private */
    public Bitmap getBitmapFromUrl(String str) throws IOException {
        return BitmapFactory.decodeStream(openConnectionCheckRedirects(new URL(str).openConnection()));
    }

    private InputStream openConnectionCheckRedirects(URLConnection uRLConnection) throws IOException {
        InputStream inputStream;
        boolean z;
        HttpURLConnection httpURLConnection;
        int responseCode;
        int i = 0;
        do {
            boolean z2 = uRLConnection instanceof HttpURLConnection;
            if (z2) {
                ((HttpURLConnection) uRLConnection).setInstanceFollowRedirects(false);
            }
            inputStream = uRLConnection.getInputStream();
            if (!z2 || (responseCode = httpURLConnection.getResponseCode()) < 300 || responseCode > 307 || responseCode == 306 || responseCode == 304) {
                z = false;
                continue;
            } else {
                URL url = (httpURLConnection = (HttpURLConnection) uRLConnection).getURL();
                String headerField = httpURLConnection.getHeaderField("Location");
                URL url2 = headerField != null ? new URL(url, headerField) : null;
                httpURLConnection.disconnect();
                if (url2 == null || ((!url2.getProtocol().equals("http") && !url2.getProtocol().equals("https")) || i >= 5)) {
                    throw new SecurityException("illegal URL redirect");
                }
                uRLConnection = url2.openConnection();
                i++;
                z = true;
                continue;
            }
        } while (z);
        return inputStream;
    }
}
