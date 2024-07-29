package com.airbnb.lottie;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.util.Base64;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.parser.LottieCompositionMoshiParser;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.google.common.base.Ascii;
import com.google.mlkit.common.sdkinternal.Constants;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import okio.BufferedSource;
import okio.Okio;
import org.json.JSONObject;

public class LottieCompositionFactory {
    private static final byte[] GZIP_MAGIC = {Ascii.US, -117, 8};
    private static final byte[] ZIP_MAGIC = {80, 75, 3, 4};
    private static final Map<String, LottieTask<LottieComposition>> taskCache = new HashMap();
    private static final Set<LottieTaskIdleListener> taskIdleListeners = new HashSet();

    private LottieCompositionFactory() {
    }

    public static void setMaxCacheSize(int i) {
        LottieCompositionCache.getInstance().resize(i);
    }

    public static void clearCache(Context context) {
        taskCache.clear();
        LottieCompositionCache.getInstance().clear();
        NetworkCache networkCache = L.networkCache(context);
        if (networkCache != null) {
            networkCache.clear();
        }
    }

    public static void registerLottieTaskIdleListener(LottieTaskIdleListener lottieTaskIdleListener) {
        taskIdleListeners.add(lottieTaskIdleListener);
        lottieTaskIdleListener.onIdleChanged(taskCache.size() == 0);
    }

    public static void unregisterLottieTaskIdleListener(LottieTaskIdleListener lottieTaskIdleListener) {
        taskIdleListeners.remove(lottieTaskIdleListener);
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str) {
        return fromUrl(context, str, "url_" + str);
    }

    public static LottieTask<LottieComposition> fromUrl(Context context, String str, String str2) {
        return cache(str2, new LottieCompositionFactory$$ExternalSyntheticLambda15(context, str, str2), (Runnable) null);
    }

    static /* synthetic */ LottieResult lambda$fromUrl$0(Context context, String str, String str2) throws Exception {
        LottieResult<LottieComposition> fetchSync = L.networkFetcher(context).fetchSync(context, str, str2);
        if (!(str2 == null || fetchSync.getValue() == null)) {
            LottieCompositionCache.getInstance().put(str2, fetchSync.getValue());
        }
        return fetchSync;
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str) {
        return fromUrlSync(context, str, str);
    }

    public static LottieResult<LottieComposition> fromUrlSync(Context context, String str, String str2) {
        LottieComposition lottieComposition = str2 == null ? null : LottieCompositionCache.getInstance().get(str2);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        LottieResult<LottieComposition> fetchSync = L.networkFetcher(context).fetchSync(context, str, str2);
        if (!(str2 == null || fetchSync.getValue() == null)) {
            LottieCompositionCache.getInstance().put(str2, fetchSync.getValue());
        }
        return fetchSync;
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str) {
        return fromAsset(context, str, "asset_" + str);
    }

    public static LottieTask<LottieComposition> fromAsset(Context context, String str, String str2) {
        return cache(str2, new LottieCompositionFactory$$ExternalSyntheticLambda6(context.getApplicationContext(), str, str2), (Runnable) null);
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str) {
        return fromAssetSync(context, str, "asset_" + str);
    }

    public static LottieResult<LottieComposition> fromAssetSync(Context context, String str, String str2) {
        LottieComposition lottieComposition = str2 == null ? null : LottieCompositionCache.getInstance().get(str2);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getAssets().open(str)));
            if (isZipCompressed(buffer).booleanValue()) {
                return fromZipStreamSync(context, new ZipInputStream(buffer.inputStream()), str2);
            }
            if (isGzipCompressed(buffer).booleanValue()) {
                return fromJsonInputStreamSync(new GZIPInputStream(buffer.inputStream()), str2);
            }
            return fromJsonInputStreamSync(buffer.inputStream(), str2);
        } catch (IOException e) {
            return new LottieResult<>((Throwable) e);
        }
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, int i) {
        return fromRawRes(context, i, rawResCacheKey(context, i));
    }

    public static LottieTask<LottieComposition> fromRawRes(Context context, int i, String str) {
        return cache(str, new LottieCompositionFactory$$ExternalSyntheticLambda7(new WeakReference(context), context.getApplicationContext(), i, str), (Runnable) null);
    }

    static /* synthetic */ LottieResult lambda$fromRawRes$2(WeakReference weakReference, Context context, int i, String str) throws Exception {
        Context context2 = (Context) weakReference.get();
        if (context2 != null) {
            context = context2;
        }
        return fromRawResSync(context, i, str);
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i) {
        return fromRawResSync(context, i, rawResCacheKey(context, i));
    }

    public static LottieResult<LottieComposition> fromRawResSync(Context context, int i, String str) {
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        try {
            BufferedSource buffer = Okio.buffer(Okio.source(context.getResources().openRawResource(i)));
            if (isZipCompressed(buffer).booleanValue()) {
                return fromZipStreamSync(context, new ZipInputStream(buffer.inputStream()), str);
            }
            if (!isGzipCompressed(buffer).booleanValue()) {
                return fromJsonInputStreamSync(buffer.inputStream(), str);
            }
            try {
                return fromJsonInputStreamSync(new GZIPInputStream(buffer.inputStream()), str);
            } catch (IOException e) {
                return new LottieResult<>((Throwable) e);
            }
        } catch (Resources.NotFoundException e2) {
            return new LottieResult<>((Throwable) e2);
        }
    }

    private static String rawResCacheKey(Context context, int i) {
        StringBuilder sb = new StringBuilder("rawRes");
        sb.append(isNightMode(context) ? "_night_" : "_day_");
        sb.append(i);
        return sb.toString();
    }

    private static boolean isNightMode(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(InputStream inputStream, String str) {
        return cache(str, new LottieCompositionFactory$$ExternalSyntheticLambda2(inputStream, str), new LottieCompositionFactory$$ExternalSyntheticLambda3(inputStream));
    }

    public static LottieTask<LottieComposition> fromJsonInputStream(InputStream inputStream, String str, boolean z) {
        return cache(str, new LottieCompositionFactory$$ExternalSyntheticLambda0(inputStream, str, z), new LottieCompositionFactory$$ExternalSyntheticLambda8(z, inputStream));
    }

    static /* synthetic */ void lambda$fromJsonInputStream$6(boolean z, InputStream inputStream) {
        if (z) {
            Utils.closeQuietly(inputStream);
        }
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str) {
        return fromJsonInputStreamSync(inputStream, str, true);
    }

    public static LottieResult<LottieComposition> fromJsonInputStreamSync(InputStream inputStream, String str, boolean z) {
        return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source(inputStream))), str, z);
    }

    @Deprecated
    public static LottieTask<LottieComposition> fromJson(JSONObject jSONObject, String str) {
        return cache(str, new LottieCompositionFactory$$ExternalSyntheticLambda16(jSONObject, str), (Runnable) null);
    }

    @Deprecated
    public static LottieResult<LottieComposition> fromJsonSync(JSONObject jSONObject, String str) {
        return fromJsonStringSync(jSONObject.toString(), str);
    }

    public static LottieTask<LottieComposition> fromJsonString(String str, String str2) {
        return cache(str2, new LottieCompositionFactory$$ExternalSyntheticLambda1(str, str2), (Runnable) null);
    }

    public static LottieResult<LottieComposition> fromJsonStringSync(String str, String str2) {
        return fromJsonReaderSync(JsonReader.of(Okio.buffer(Okio.source((InputStream) new ByteArrayInputStream(str.getBytes())))), str2);
    }

    public static LottieTask<LottieComposition> fromJsonReader(JsonReader jsonReader, String str) {
        return cache(str, new LottieCompositionFactory$$ExternalSyntheticLambda13(jsonReader, str), new LottieCompositionFactory$$ExternalSyntheticLambda14(jsonReader));
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str) {
        return fromJsonReaderSync(jsonReader, str, true);
    }

    public static LottieResult<LottieComposition> fromJsonReaderSync(JsonReader jsonReader, String str, boolean z) {
        return fromJsonReaderSyncInternal(jsonReader, str, z);
    }

    private static LottieResult<LottieComposition> fromJsonReaderSyncInternal(JsonReader jsonReader, String str, boolean z) {
        LottieComposition lottieComposition;
        if (str == null) {
            lottieComposition = null;
        } else {
            try {
                lottieComposition = LottieCompositionCache.getInstance().get(str);
            } catch (Exception e) {
                LottieResult<LottieComposition> lottieResult = new LottieResult<>((Throwable) e);
                if (z) {
                    Utils.closeQuietly(jsonReader);
                }
                return lottieResult;
            } catch (Throwable th) {
                if (z) {
                    Utils.closeQuietly(jsonReader);
                }
                throw th;
            }
        }
        if (lottieComposition != null) {
            LottieResult<LottieComposition> lottieResult2 = new LottieResult<>(lottieComposition);
            if (z) {
                Utils.closeQuietly(jsonReader);
            }
            return lottieResult2;
        }
        LottieComposition parse = LottieCompositionMoshiParser.parse(jsonReader);
        if (str != null) {
            LottieCompositionCache.getInstance().put(str, parse);
        }
        LottieResult<LottieComposition> lottieResult3 = new LottieResult<>(parse);
        if (z) {
            Utils.closeQuietly(jsonReader);
        }
        return lottieResult3;
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, String str) {
        return fromZipStream((Context) null, zipInputStream, str);
    }

    public static LottieTask<LottieComposition> fromZipStream(ZipInputStream zipInputStream, String str, boolean z) {
        return fromZipStream((Context) null, zipInputStream, str, z);
    }

    public static LottieTask<LottieComposition> fromZipStream(Context context, ZipInputStream zipInputStream, String str) {
        return cache(str, new LottieCompositionFactory$$ExternalSyntheticLambda9(context, zipInputStream, str), new LottieCompositionFactory$$ExternalSyntheticLambda10(zipInputStream));
    }

    public static LottieTask<LottieComposition> fromZipStream(Context context, ZipInputStream zipInputStream, String str, boolean z) {
        return cache(str, new LottieCompositionFactory$$ExternalSyntheticLambda11(context, zipInputStream, str), z ? new LottieCompositionFactory$$ExternalSyntheticLambda12(zipInputStream) : null);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str) {
        return fromZipStreamSync(zipInputStream, str, true);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(ZipInputStream zipInputStream, String str, boolean z) {
        return fromZipStreamSync((Context) null, zipInputStream, str, z);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(Context context, ZipInputStream zipInputStream, String str) {
        return fromZipStreamSync(context, zipInputStream, str, true);
    }

    public static LottieResult<LottieComposition> fromZipStreamSync(Context context, ZipInputStream zipInputStream, String str, boolean z) {
        try {
            return fromZipStreamSyncInternal(context, zipInputStream, str);
        } finally {
            if (z) {
                Utils.closeQuietly(zipInputStream);
            }
        }
    }

    private static LottieResult<LottieComposition> fromZipStreamSyncInternal(Context context, ZipInputStream zipInputStream, String str) {
        LottieComposition lottieComposition;
        FileOutputStream fileOutputStream;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (str == null) {
            lottieComposition = null;
        } else {
            try {
                lottieComposition = LottieCompositionCache.getInstance().get(str);
            } catch (IOException e) {
                return new LottieResult<>((Throwable) e);
            }
        }
        if (lottieComposition != null) {
            return new LottieResult<>(lottieComposition);
        }
        ZipEntry nextEntry = zipInputStream.getNextEntry();
        LottieComposition lottieComposition2 = null;
        while (nextEntry != null) {
            String name = nextEntry.getName();
            if (name.contains("__MACOSX")) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().equalsIgnoreCase(Constants.AUTOML_IMAGE_LABELING_MANIFEST_JSON_FILE_NAME)) {
                zipInputStream.closeEntry();
            } else if (nextEntry.getName().contains(".json")) {
                lottieComposition2 = fromJsonReaderSyncInternal(JsonReader.of(Okio.buffer(Okio.source((InputStream) zipInputStream))), (String) null, false).getValue();
            } else {
                if (!name.contains(".png")) {
                    if (!name.contains(".webp") && !name.contains(".jpg")) {
                        if (!name.contains(".jpeg")) {
                            if (!name.contains(".ttf")) {
                                if (!name.contains(".otf")) {
                                    zipInputStream.closeEntry();
                                }
                            }
                            String[] split = name.split("/");
                            String str2 = split[split.length - 1];
                            String str3 = str2.split("\\.")[0];
                            File file = new File(context.getCacheDir(), str2);
                            new FileOutputStream(file);
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                byte[] bArr = new byte[4096];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                }
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (Throwable th) {
                                Logger.warning("Unable to save font " + str3 + " to the temporary file: " + str2 + ". ", th);
                            }
                            Typeface createFromFile = Typeface.createFromFile(file);
                            if (!file.delete()) {
                                Logger.warning("Failed to delete temp font file " + file.getAbsolutePath() + ".");
                            }
                            hashMap2.put(str3, createFromFile);
                        }
                    }
                }
                String[] split2 = name.split("/");
                hashMap.put(split2[split2.length - 1], BitmapFactory.decodeStream(zipInputStream));
            }
            nextEntry = zipInputStream.getNextEntry();
        }
        if (lottieComposition2 == null) {
            return new LottieResult<>((Throwable) new IllegalArgumentException("Unable to parse composition"));
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            LottieImageAsset findImageAssetForFileName = findImageAssetForFileName(lottieComposition2, (String) entry.getKey());
            if (findImageAssetForFileName != null) {
                findImageAssetForFileName.setBitmap(Utils.resizeBitmapIfNeeded((Bitmap) entry.getValue(), findImageAssetForFileName.getWidth(), findImageAssetForFileName.getHeight()));
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            boolean z = false;
            for (Font next : lottieComposition2.getFonts().values()) {
                if (next.getFamily().equals(entry2.getKey())) {
                    next.setTypeface((Typeface) entry2.getValue());
                    z = true;
                }
            }
            if (!z) {
                Logger.warning("Parsed font for " + ((String) entry2.getKey()) + " however it was not found in the animation.");
            }
        }
        if (hashMap.isEmpty()) {
            for (Map.Entry<String, LottieImageAsset> value : lottieComposition2.getImages().entrySet()) {
                LottieImageAsset lottieImageAsset = (LottieImageAsset) value.getValue();
                if (lottieImageAsset == null) {
                    return null;
                }
                String fileName = lottieImageAsset.getFileName();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inScaled = true;
                options.inDensity = 160;
                if (fileName.startsWith("data:") && fileName.indexOf("base64,") > 0) {
                    try {
                        byte[] decode = Base64.decode(fileName.substring(fileName.indexOf(44) + 1), 0);
                        lottieImageAsset.setBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
                    } catch (IllegalArgumentException e2) {
                        Logger.warning("data URL did not have correct base64 format.", e2);
                        return null;
                    }
                }
            }
        }
        if (str != null) {
            LottieCompositionCache.getInstance().put(str, lottieComposition2);
        }
        return new LottieResult<>(lottieComposition2);
        throw th;
    }

    private static Boolean isZipCompressed(BufferedSource bufferedSource) {
        return matchesMagicBytes(bufferedSource, ZIP_MAGIC);
    }

    private static Boolean isGzipCompressed(BufferedSource bufferedSource) {
        return matchesMagicBytes(bufferedSource, GZIP_MAGIC);
    }

    private static Boolean matchesMagicBytes(BufferedSource bufferedSource, byte[] bArr) {
        try {
            BufferedSource peek = bufferedSource.peek();
            for (byte b : bArr) {
                if (peek.readByte() != b) {
                    return false;
                }
            }
            peek.close();
            return true;
        } catch (NoSuchMethodError unused) {
            return false;
        } catch (Exception e) {
            Logger.error("Failed to check zip file header", e);
            return false;
        }
    }

    private static LottieImageAsset findImageAssetForFileName(LottieComposition lottieComposition, String str) {
        for (LottieImageAsset next : lottieComposition.getImages().values()) {
            if (next.getFileName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    private static LottieTask<LottieComposition> cache(String str, Callable<LottieResult<LottieComposition>> callable, Runnable runnable) {
        LottieTask<LottieComposition> lottieTask = null;
        LottieComposition lottieComposition = str == null ? null : LottieCompositionCache.getInstance().get(str);
        if (lottieComposition != null) {
            lottieTask = new LottieTask<>(lottieComposition);
        }
        if (str != null) {
            Map<String, LottieTask<LottieComposition>> map = taskCache;
            if (map.containsKey(str)) {
                lottieTask = map.get(str);
            }
        }
        if (lottieTask != null) {
            if (runnable != null) {
                runnable.run();
            }
            return lottieTask;
        }
        LottieTask<LottieComposition> lottieTask2 = new LottieTask<>(callable);
        if (str != null) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            lottieTask2.addListener(new LottieCompositionFactory$$ExternalSyntheticLambda4(str, atomicBoolean));
            lottieTask2.addFailureListener(new LottieCompositionFactory$$ExternalSyntheticLambda5(str, atomicBoolean));
            if (!atomicBoolean.get()) {
                Map<String, LottieTask<LottieComposition>> map2 = taskCache;
                map2.put(str, lottieTask2);
                if (map2.size() == 1) {
                    notifyTaskCacheIdleListeners(false);
                }
            }
        }
        return lottieTask2;
    }

    static /* synthetic */ void lambda$cache$15(String str, AtomicBoolean atomicBoolean, LottieComposition lottieComposition) {
        Map<String, LottieTask<LottieComposition>> map = taskCache;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            notifyTaskCacheIdleListeners(true);
        }
    }

    static /* synthetic */ void lambda$cache$16(String str, AtomicBoolean atomicBoolean, Throwable th) {
        Map<String, LottieTask<LottieComposition>> map = taskCache;
        map.remove(str);
        atomicBoolean.set(true);
        if (map.size() == 0) {
            notifyTaskCacheIdleListeners(true);
        }
    }

    private static void notifyTaskCacheIdleListeners(boolean z) {
        ArrayList arrayList = new ArrayList(taskIdleListeners);
        for (int i = 0; i < arrayList.size(); i++) {
            ((LottieTaskIdleListener) arrayList.get(i)).onIdleChanged(z);
        }
    }
}
