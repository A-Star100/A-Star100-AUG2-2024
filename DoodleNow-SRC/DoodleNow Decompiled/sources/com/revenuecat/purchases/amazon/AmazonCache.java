package com.revenuecat.purchases.amazon;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.caching.DeviceCache;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Arrays;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\u001a\u0010\u000e\u001a\u00020\f2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010J\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010R\u001b\u0010\u0005\u001a\u00020\u00068@X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/revenuecat/purchases/amazon/AmazonCache;", "", "deviceCache", "Lcom/revenuecat/purchases/common/caching/DeviceCache;", "(Lcom/revenuecat/purchases/common/caching/DeviceCache;)V", "amazonPostedTokensKey", "", "getAmazonPostedTokensKey$purchases_defaultsRelease", "()Ljava/lang/String;", "amazonPostedTokensKey$delegate", "Lkotlin/Lazy;", "addSuccessfullyPostedToken", "", "token", "cacheSkusByToken", "receiptsToSkus", "", "getReceiptSkus", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonCache.kt */
public final class AmazonCache {
    private final Lazy amazonPostedTokensKey$delegate = LazyKt.lazy(new AmazonCache$amazonPostedTokensKey$2(this));
    /* access modifiers changed from: private */
    public final DeviceCache deviceCache;

    public AmazonCache(DeviceCache deviceCache2) {
        Intrinsics.checkNotNullParameter(deviceCache2, "deviceCache");
        this.deviceCache = deviceCache2;
    }

    public final String getAmazonPostedTokensKey$purchases_defaultsRelease() {
        return (String) this.amazonPostedTokensKey$delegate.getValue();
    }

    public final synchronized void cacheSkusByToken(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "receiptsToSkus");
        LogIntent logIntent = LogIntent.DEBUG;
        String format = String.format(AmazonStrings.CACHING_RECEIPT_TERM_SKUS, Arrays.copyOf(new Object[]{map}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        JSONObject jSONObject = new JSONObject(MapsKt.plus(getReceiptSkus(), map));
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("receiptsToSkus", jSONObject);
        DeviceCache deviceCache2 = this.deviceCache;
        String amazonPostedTokensKey$purchases_defaultsRelease = getAmazonPostedTokensKey$purchases_defaultsRelease();
        String jSONObject3 = jSONObject2.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject3, "jsonToCache.toString()");
        deviceCache2.putString(amazonPostedTokensKey$purchases_defaultsRelease, jSONObject3);
    }

    public final synchronized Map<String, String> getReceiptSkus() {
        Map<String, String> map;
        JSONObject jSONObjectOrNull = this.deviceCache.getJSONObjectOrNull(getAmazonPostedTokensKey$purchases_defaultsRelease());
        JSONObject jSONObject = jSONObjectOrNull != null ? jSONObjectOrNull.getJSONObject("receiptsToSkus") : null;
        if (jSONObject == null || (map = JSONObjectExtensionsKt.toMap$default(jSONObject, false, 1, (Object) null)) == null) {
            map = MapsKt.emptyMap();
        }
        return map;
    }

    public final synchronized void addSuccessfullyPostedToken(String str) {
        Intrinsics.checkNotNullParameter(str, "token");
        this.deviceCache.addSuccessfullyPostedToken(str);
    }
}
