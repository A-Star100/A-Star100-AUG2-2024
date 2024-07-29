package com.reactnativeimageresizer;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class ImageResizerModule extends ImageResizerSpec {
    public static final String NAME = "ImageResizer";

    public String getName() {
        return NAME;
    }

    ImageResizerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public void createResizedImage(String str, double d, double d2, String str2, double d3, String str3, boolean z, Double d4, String str4, Boolean bool, Promise promise) {
        final WritableMap createMap = Arguments.createMap();
        createMap.putString("mode", str3);
        createMap.putBoolean("onlyScaleDown", z);
        final String str5 = str;
        final double d5 = d;
        final double d6 = d2;
        final String str6 = str2;
        final double d7 = d3;
        final Double d8 = d4;
        final String str7 = str4;
        final Boolean bool2 = bool;
        AnonymousClass1 r16 = r0;
        final Promise promise2 = promise;
        AnonymousClass1 r0 = new GuardedAsyncTask<Void, Void>(getReactApplicationContext()) {
            /* access modifiers changed from: protected */
            public void doInBackgroundGuarded(Void... voidArr) {
                try {
                    promise2.resolve(ImageResizerModule.this.createResizedImageWithExceptions(str5, (int) d5, (int) d6, str6, (int) d7, d8.intValue(), str7, bool2.booleanValue(), createMap));
                } catch (IOException e) {
                    promise2.reject((Throwable) e);
                }
            }
        };
        r16.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    /* access modifiers changed from: private */
    public Object createResizedImageWithExceptions(String str, int i, int i2, String str2, int i3, int i4, String str3, boolean z, ReadableMap readableMap) throws IOException {
        String str4 = str3;
        ReadableMap readableMap2 = readableMap;
        Bitmap.CompressFormat valueOf = Bitmap.CompressFormat.valueOf(str2);
        Uri parse = Uri.parse(str);
        Bitmap createResizedImage = ImageResizer.createResizedImage(getReactApplicationContext(), parse, i, i2, i3, i4, readableMap2.getString("mode"), readableMap2.getBoolean("onlyScaleDown"));
        if (createResizedImage != null) {
            File cacheDir = getReactApplicationContext().getCacheDir();
            if (str4 != null) {
                cacheDir = new File(str4);
            }
            File saveImage = ImageResizer.saveImage(createResizedImage, cacheDir, UUID.randomUUID().toString(), valueOf, i3);
            WritableMap createMap = Arguments.createMap();
            if (saveImage.isFile()) {
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, saveImage.getAbsolutePath());
                createMap.putString("uri", Uri.fromFile(saveImage).toString());
                createMap.putString("name", saveImage.getName());
                createMap.putDouble("size", (double) saveImage.length());
                createMap.putDouble("width", (double) createResizedImage.getWidth());
                createMap.putDouble("height", (double) createResizedImage.getHeight());
                if (z) {
                    try {
                        ImageResizer.copyExif(getReactApplicationContext(), parse, saveImage.getAbsolutePath());
                    } catch (Exception e) {
                        Log.e("ImageResizer::createResizedImageWithExceptions", "EXIF copy failed", e);
                    }
                }
                createResizedImage.recycle();
                return createMap;
            }
            throw new IOException("Error getting resized image path");
        }
        throw new IOException("The image failed to be resized; invalid Bitmap result.");
    }
}
