package androidx.camera.core.impl.utils;

import androidx.work.WorkRequest;

final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    /* access modifiers changed from: package-private */
    public long getDenominator() {
        return this.mDenominator;
    }

    /* access modifiers changed from: package-private */
    public long getNumerator() {
        return this.mNumerator;
    }

    /* access modifiers changed from: package-private */
    public double toDouble() {
        return ((double) this.mNumerator) / ((double) this.mDenominator);
    }

    LongRational(long j, long j2) {
        this.mNumerator = j;
        this.mDenominator = j2;
    }

    LongRational(double d) {
        this((long) (d * 10000.0d), WorkRequest.MIN_BACKOFF_MILLIS);
    }

    public String toString() {
        return this.mNumerator + "/" + this.mDenominator;
    }
}
