package com.revenuecat.purchases.amazon;

import android.content.Context;
import com.revenuecat.purchases.PurchasesConfiguration;
import com.revenuecat.purchases.Store;

public final class AmazonConfiguration extends PurchasesConfiguration {
    public AmazonConfiguration(Builder builder) {
        super(builder);
    }

    public static final class Builder extends PurchasesConfiguration.Builder {
        public Builder(Context context, String str) {
            super(context, str);
            store(Store.AMAZON);
        }
    }
}
