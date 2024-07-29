package com.amazon.device.iap.model;

public final class CoinsReward {
    private final int amount;

    public int getAmount() {
        return this.amount;
    }

    protected CoinsReward(int i) {
        this.amount = i;
    }

    protected static final CoinsReward from(int i) {
        if (i > 0) {
            return new CoinsReward(i);
        }
        return null;
    }
}
