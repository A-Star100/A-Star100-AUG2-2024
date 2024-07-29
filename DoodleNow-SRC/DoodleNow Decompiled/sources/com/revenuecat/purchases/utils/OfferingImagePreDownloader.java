package com.revenuecat.purchases.utils;

import android.net.Uri;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.paywalls.PaywallData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/utils/OfferingImagePreDownloader;", "", "shouldPredownloadImages", "", "coilImageDownloader", "Lcom/revenuecat/purchases/utils/CoilImageDownloader;", "(ZLcom/revenuecat/purchases/utils/CoilImageDownloader;)V", "preDownloadOfferingImages", "", "offering", "Lcom/revenuecat/purchases/Offering;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingImagePreDownloader.kt */
public final class OfferingImagePreDownloader {
    private final CoilImageDownloader coilImageDownloader;
    private final boolean shouldPredownloadImages;

    public OfferingImagePreDownloader(boolean z, CoilImageDownloader coilImageDownloader2) {
        Intrinsics.checkNotNullParameter(coilImageDownloader2, "coilImageDownloader");
        this.shouldPredownloadImages = z;
        this.coilImageDownloader = coilImageDownloader2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ OfferingImagePreDownloader(boolean r1, com.revenuecat.purchases.utils.CoilImageDownloader r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = 1
            r3 = r3 & r4
            if (r3 == 0) goto L_0x000c
            java.lang.String r1 = "com.revenuecat.purchases.ui.revenuecatui.PaywallKt"
            java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x000b }
            r1 = r4
            goto L_0x000c
        L_0x000b:
            r1 = 0
        L_0x000c:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.utils.OfferingImagePreDownloader.<init>(boolean, com.revenuecat.purchases.utils.CoilImageDownloader, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final void preDownloadOfferingImages(Offering offering) {
        Intrinsics.checkNotNullParameter(offering, "offering");
        if (!this.shouldPredownloadImages) {
            LogUtilsKt.verboseLog("OfferingImagePreDownloader won't pre-download images");
            return;
        }
        LogUtilsKt.debugLog("OfferingImagePreDownloader: starting image download");
        PaywallData paywall = offering.getPaywall();
        if (paywall != null) {
            Iterable<String> all$purchases_defaultsRelease = paywall.getConfig().getImages().getAll$purchases_defaultsRelease();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(all$purchases_defaultsRelease, 10));
            for (String path : all$purchases_defaultsRelease) {
                arrayList.add(Uri.parse(paywall.getAssetBaseURL().toString()).buildUpon().path(path).build());
            }
            for (Uri uri : (List) arrayList) {
                LogUtilsKt.debugLog("Pre-downloading paywall image: " + uri);
                CoilImageDownloader coilImageDownloader2 = this.coilImageDownloader;
                Intrinsics.checkNotNullExpressionValue(uri, "it");
                coilImageDownloader2.downloadImage(uri);
            }
        }
    }
}
