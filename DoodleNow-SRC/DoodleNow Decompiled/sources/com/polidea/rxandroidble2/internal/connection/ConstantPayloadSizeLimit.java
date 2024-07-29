package com.polidea.rxandroidble2.internal.connection;

class ConstantPayloadSizeLimit implements PayloadSizeLimitProvider {
    private final int limit;

    public int getPayloadSizeLimit() {
        return this.limit;
    }

    ConstantPayloadSizeLimit(int i) {
        this.limit = i;
    }
}
