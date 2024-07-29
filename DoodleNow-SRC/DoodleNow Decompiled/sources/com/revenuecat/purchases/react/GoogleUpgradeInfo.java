package com.revenuecat.purchases.react;

class GoogleUpgradeInfo {
    private final String oldProductIdentifier;
    private final Integer prorationMode;

    public String getOldProductIdentifier() {
        return this.oldProductIdentifier;
    }

    public Integer getProrationMode() {
        return this.prorationMode;
    }

    public GoogleUpgradeInfo(String str, Integer num) {
        this.oldProductIdentifier = str;
        this.prorationMode = num;
    }
}
