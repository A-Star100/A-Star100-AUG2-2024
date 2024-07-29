package com.polidea.rxandroidble2.internal.connection;

import com.polidea.rxandroidble2.ConnectionParameters;

public class ConnectionParametersImpl implements ConnectionParameters {
    private final int interval;
    private final int latency;
    private final int timeout;

    public int getConnectionInterval() {
        return this.interval;
    }

    public int getSlaveLatency() {
        return this.latency;
    }

    public int getSupervisionTimeout() {
        return this.timeout;
    }

    ConnectionParametersImpl(int i, int i2, int i3) {
        this.interval = i;
        this.latency = i2;
        this.timeout = i3;
    }
}
