package com.bleplx.adapter;

public class ConnectionOptions {
    private final boolean autoConnect;
    private final int connectionPriority;
    private final RefreshGattMoment refreshGattMoment;
    private final int requestMTU;
    private final Long timeoutInMillis;

    public int getConnectionPriority() {
        return this.connectionPriority;
    }

    public RefreshGattMoment getRefreshGattMoment() {
        return this.refreshGattMoment;
    }

    public int getRequestMTU() {
        return this.requestMTU;
    }

    public Long getTimeoutInMillis() {
        return this.timeoutInMillis;
    }

    public ConnectionOptions(Boolean bool, int i, RefreshGattMoment refreshGattMoment2, Long l, int i2) {
        this.autoConnect = bool.booleanValue();
        this.requestMTU = i;
        this.refreshGattMoment = refreshGattMoment2;
        this.timeoutInMillis = l;
        this.connectionPriority = i2;
    }

    public Boolean getAutoConnect() {
        return Boolean.valueOf(this.autoConnect);
    }
}
