package com.rnmaps.maps;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.autofill.HintConstants;
import androidx.camera.video.AudioStats;
import com.amplitude.api.Constants;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.module.annotations.ReactModule;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ReactModule(name = "AirMapModule")
public class MapModule extends ReactContextBaseJavaModule {
    public static final String NAME = "AirMapModule";
    private static final String SNAPSHOT_FORMAT_JPG = "jpg";
    private static final String SNAPSHOT_FORMAT_PNG = "png";
    private static final String SNAPSHOT_RESULT_BASE64 = "base64";
    private static final String SNAPSHOT_RESULT_FILE = "file";

    public String getName() {
        return NAME;
    }

    public MapModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("legalNotice", "This license information is displayed in Settings > Google > Open Source on any device running Google Play services.");
        return hashMap;
    }

    public Activity getActivity() {
        return getCurrentActivity();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    @ReactMethod
    public void takeSnapshot(int i, ReadableMap readableMap, Promise promise) {
        Bitmap.CompressFormat compressFormat;
        ReadableMap readableMap2 = readableMap;
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        String string = readableMap2.hasKey("format") ? readableMap2.getString("format") : SNAPSHOT_FORMAT_PNG;
        if (string.equals(SNAPSHOT_FORMAT_PNG)) {
            compressFormat = Bitmap.CompressFormat.PNG;
        } else {
            compressFormat = string.equals(SNAPSHOT_FORMAT_JPG) ? Bitmap.CompressFormat.JPEG : null;
        }
        Bitmap.CompressFormat compressFormat2 = compressFormat;
        double d = readableMap2.hasKey("quality") ? readableMap2.getDouble("quality") : 1.0d;
        DisplayMetrics displayMetrics = reactApplicationContext.getResources().getDisplayMetrics();
        int i2 = 0;
        Integer valueOf = Integer.valueOf(readableMap2.hasKey("width") ? (int) (((double) displayMetrics.density) * readableMap2.getDouble("width")) : 0);
        if (readableMap2.hasKey("height")) {
            i2 = (int) (((double) displayMetrics.density) * readableMap2.getDouble("height"));
        }
        MapModule$$ExternalSyntheticLambda1 mapModule$$ExternalSyntheticLambda1 = new MapModule$$ExternalSyntheticLambda1(this, promise, valueOf, Integer.valueOf(i2), readableMap2.hasKey("result") ? readableMap2.getString("result") : "file", string, reactApplicationContext, compressFormat2, d);
        int i3 = i;
        new MapUIBlock(i, promise, reactApplicationContext, mapModule$$ExternalSyntheticLambda1).addToUIManager();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void lambda$takeSnapshot$0(Promise promise, Integer num, Integer num2, String str, String str2, ReactApplicationContext reactApplicationContext, Bitmap.CompressFormat compressFormat, double d, MapView mapView) {
        final Promise promise2 = promise;
        final Integer num3 = num;
        final Integer num4 = num2;
        final String str3 = str;
        final String str4 = str2;
        final ReactApplicationContext reactApplicationContext2 = reactApplicationContext;
        final Bitmap.CompressFormat compressFormat2 = compressFormat;
        final double d2 = d;
        mapView.map.snapshot(new GoogleMap.SnapshotReadyCallback() {
            public void onSnapshotReady(Bitmap bitmap) {
                if (bitmap == null) {
                    promise2.reject("Failed to generate bitmap, snapshot = null");
                    return;
                }
                if (!(num3.intValue() == 0 || num4.intValue() == 0 || (num3.intValue() == bitmap.getWidth() && num4.intValue() == bitmap.getHeight()))) {
                    bitmap = Bitmap.createScaledBitmap(bitmap, num3.intValue(), num4.intValue(), true);
                }
                if (str3.equals("file")) {
                    try {
                        File createTempFile = File.createTempFile("AirMapSnapshot", "." + str4, reactApplicationContext2.getCacheDir());
                        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                        bitmap.compress(compressFormat2, (int) (d2 * 100.0d), fileOutputStream);
                        MapModule.closeQuietly(fileOutputStream);
                        promise2.resolve(Uri.fromFile(createTempFile).toString());
                    } catch (Exception e) {
                        promise2.reject((Throwable) e);
                    }
                } else if (str3.equals("base64")) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    bitmap.compress(compressFormat2, (int) (d2 * 100.0d), byteArrayOutputStream);
                    MapModule.closeQuietly(byteArrayOutputStream);
                    promise2.resolve(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2));
                }
            }
        });
        return null;
    }

    @ReactMethod
    public void getCamera(int i, Promise promise) {
        new MapUIBlock(i, promise, getReactApplicationContext(), new MapModule$$ExternalSyntheticLambda3(promise)).addToUIManager();
    }

    static /* synthetic */ Void lambda$getCamera$1(Promise promise, MapView mapView) {
        CameraPosition cameraPosition = mapView.map.getCameraPosition();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("latitude", cameraPosition.target.latitude);
        writableNativeMap.putDouble("longitude", cameraPosition.target.longitude);
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        writableNativeMap2.putMap(TtmlNode.CENTER, writableNativeMap);
        writableNativeMap2.putDouble("heading", (double) cameraPosition.bearing);
        writableNativeMap2.putDouble("zoom", (double) cameraPosition.zoom);
        writableNativeMap2.putDouble("pitch", (double) cameraPosition.tilt);
        promise.resolve(writableNativeMap2);
        return null;
    }

    @ReactMethod
    public void getAddressFromCoordinates(int i, ReadableMap readableMap, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        new MapUIBlock(i, promise, reactApplicationContext, new MapModule$$ExternalSyntheticLambda0(readableMap, promise, reactApplicationContext)).addToUIManager();
    }

    static /* synthetic */ Void lambda$getAddressFromCoordinates$2(ReadableMap readableMap, Promise promise, ReactApplicationContext reactApplicationContext, MapView mapView) {
        if (readableMap == null || !readableMap.hasKey("latitude") || !readableMap.hasKey("longitude")) {
            promise.reject("Invalid coordinate format");
            return null;
        }
        try {
            List<Address> fromLocation = new Geocoder(reactApplicationContext).getFromLocation(readableMap.getDouble("latitude"), readableMap.getDouble("longitude"), 1);
            if (fromLocation.isEmpty()) {
                promise.reject("Can not get address location");
                return null;
            }
            Address address = fromLocation.get(0);
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("name", address.getFeatureName());
            writableNativeMap.putString("locality", address.getLocality());
            writableNativeMap.putString("thoroughfare", address.getThoroughfare());
            writableNativeMap.putString("subThoroughfare", address.getSubThoroughfare());
            writableNativeMap.putString("subLocality", address.getSubLocality());
            writableNativeMap.putString("administrativeArea", address.getAdminArea());
            writableNativeMap.putString("subAdministrativeArea", address.getSubAdminArea());
            writableNativeMap.putString(HintConstants.AUTOFILL_HINT_POSTAL_CODE, address.getPostalCode());
            writableNativeMap.putString("countryCode", address.getCountryCode());
            writableNativeMap.putString(Constants.AMP_TRACKING_OPTION_COUNTRY, address.getCountryName());
            promise.resolve(writableNativeMap);
            return null;
        } catch (IOException unused) {
            promise.reject("Can not get address location");
        }
    }

    @ReactMethod
    public void pointForCoordinate(int i, ReadableMap readableMap, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        double d = (double) reactApplicationContext.getResources().getDisplayMetrics().density;
        boolean hasKey = readableMap.hasKey("latitude");
        double d2 = AudioStats.AUDIO_AMPLITUDE_NONE;
        double d3 = hasKey ? readableMap.getDouble("latitude") : 0.0d;
        if (readableMap.hasKey("longitude")) {
            d2 = readableMap.getDouble("longitude");
        }
        new MapUIBlock(i, promise, reactApplicationContext, new MapModule$$ExternalSyntheticLambda2(new LatLng(d3, d2), d, promise)).addToUIManager();
    }

    static /* synthetic */ Void lambda$pointForCoordinate$3(LatLng latLng, double d, Promise promise, MapView mapView) {
        Point screenLocation = mapView.map.getProjection().toScreenLocation(latLng);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("x", ((double) screenLocation.x) / d);
        writableNativeMap.putDouble("y", ((double) screenLocation.y) / d);
        promise.resolve(writableNativeMap);
        return null;
    }

    @ReactMethod
    public void coordinateForPoint(int i, ReadableMap readableMap, Promise promise) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        double d = (double) reactApplicationContext.getResources().getDisplayMetrics().density;
        int i2 = 0;
        int i3 = readableMap.hasKey("x") ? (int) (readableMap.getDouble("x") * d) : 0;
        if (readableMap.hasKey("y")) {
            i2 = (int) (readableMap.getDouble("y") * d);
        }
        new MapUIBlock(i, promise, reactApplicationContext, new MapModule$$ExternalSyntheticLambda4(new Point(i3, i2), promise)).addToUIManager();
    }

    static /* synthetic */ Void lambda$coordinateForPoint$4(Point point, Promise promise, MapView mapView) {
        LatLng fromScreenLocation = mapView.map.getProjection().fromScreenLocation(point);
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putDouble("latitude", fromScreenLocation.latitude);
        writableNativeMap.putDouble("longitude", fromScreenLocation.longitude);
        promise.resolve(writableNativeMap);
        return null;
    }

    @ReactMethod
    public void getMapBoundaries(int i, Promise promise) {
        new MapUIBlock(i, promise, getReactApplicationContext(), new MapModule$$ExternalSyntheticLambda5(promise)).addToUIManager();
    }

    static /* synthetic */ Void lambda$getMapBoundaries$5(Promise promise, MapView mapView) {
        double[][] mapBoundaries = mapView.getMapBoundaries();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        WritableNativeMap writableNativeMap2 = new WritableNativeMap();
        WritableNativeMap writableNativeMap3 = new WritableNativeMap();
        writableNativeMap2.putDouble("longitude", mapBoundaries[0][0]);
        writableNativeMap2.putDouble("latitude", mapBoundaries[0][1]);
        writableNativeMap3.putDouble("longitude", mapBoundaries[1][0]);
        writableNativeMap3.putDouble("latitude", mapBoundaries[1][1]);
        writableNativeMap.putMap("northEast", writableNativeMap2);
        writableNativeMap.putMap("southWest", writableNativeMap3);
        promise.resolve(writableNativeMap);
        return null;
    }
}
