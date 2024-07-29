package com.revenuecat.purchases;

import com.revenuecat.purchases.common.GoogleOfferingParser;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.OfferingParser;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/revenuecat/purchases/OfferingParserFactory;", "", "()V", "createOfferingParser", "Lcom/revenuecat/purchases/common/OfferingParser;", "store", "Lcom/revenuecat/purchases/Store;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingParserFactory.kt */
public final class OfferingParserFactory {
    public static final OfferingParserFactory INSTANCE = new OfferingParserFactory();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OfferingParserFactory.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.revenuecat.purchases.Store[] r0 = com.revenuecat.purchases.Store.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.revenuecat.purchases.Store r1 = com.revenuecat.purchases.Store.PLAY_STORE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.revenuecat.purchases.Store r1 = com.revenuecat.purchases.Store.AMAZON     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.OfferingParserFactory.WhenMappings.<clinit>():void");
        }
    }

    private OfferingParserFactory() {
    }

    public final OfferingParser createOfferingParser(Store store) {
        Intrinsics.checkNotNullParameter(store, ProductResponseJsonKeys.STORE);
        int i = WhenMappings.$EnumSwitchMapping$0[store.ordinal()];
        if (i == 1) {
            return new GoogleOfferingParser();
        }
        if (i == 2) {
            try {
                Object newInstance = Class.forName("com.revenuecat.purchases.amazon.AmazonOfferingParser").getConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.revenuecat.purchases.common.OfferingParser");
                return (OfferingParser) newInstance;
            } catch (ClassNotFoundException e) {
                LogUtilsKt.errorLog("Make sure purchases-amazon is added as dependency", e);
                throw e;
            }
        } else {
            LogUtilsKt.errorLog$default("Incompatible store (" + store + ") used", (Throwable) null, 2, (Object) null);
            throw new IllegalArgumentException("Couldn't configure SDK. Incompatible store (" + store + ") used");
        }
    }
}
