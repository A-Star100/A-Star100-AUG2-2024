package com.revenuecat.purchases.utils;

import android.content.Context;
import coil.ImageLoader;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"MAX_CACHE_SIZE_BYTES", "", "PAYWALL_IMAGE_CACHE_FOLDER", "", "getRevenueCatUIImageLoader", "Lcoil/ImageLoader;", "Landroid/content/Context;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoilImageDownloader.kt */
public final class CoilImageDownloaderKt {
    private static final long MAX_CACHE_SIZE_BYTES = 26214400;
    private static final String PAYWALL_IMAGE_CACHE_FOLDER = "revenuecatui_cache";

    /* access modifiers changed from: private */
    public static final ImageLoader getRevenueCatUIImageLoader(Context context) {
        return new ImageLoader.Builder(context).diskCache(new CoilImageDownloaderKt$getRevenueCatUIImageLoader$1(context)).build();
    }
}
