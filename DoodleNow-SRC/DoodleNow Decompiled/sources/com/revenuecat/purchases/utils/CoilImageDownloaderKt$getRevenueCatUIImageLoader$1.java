package com.revenuecat.purchases.utils;

import android.content.Context;
import coil.disk.DiskCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcoil/disk/DiskCache;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoilImageDownloader.kt */
final class CoilImageDownloaderKt$getRevenueCatUIImageLoader$1 extends Lambda implements Function0<DiskCache> {
    final /* synthetic */ Context $this_getRevenueCatUIImageLoader;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CoilImageDownloaderKt$getRevenueCatUIImageLoader$1(Context context) {
        super(0);
        this.$this_getRevenueCatUIImageLoader = context;
    }

    public final DiskCache invoke() {
        DiskCache.Builder builder = new DiskCache.Builder();
        File cacheDir = this.$this_getRevenueCatUIImageLoader.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "cacheDir");
        return builder.directory(FilesKt.resolve(cacheDir, "revenuecatui_cache")).maxSizeBytes(26214400).build();
    }
}
