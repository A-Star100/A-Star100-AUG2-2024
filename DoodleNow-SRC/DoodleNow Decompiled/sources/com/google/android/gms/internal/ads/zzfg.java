package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfg {
    private long[] zza;

    public zzfg() {
        this(16);
    }

    public zzfg(int i) {
        int i2 = 16;
        if (Integer.bitCount(16) != 1) {
            int highestOneBit = Integer.highestOneBit(15);
            i2 = highestOneBit + highestOneBit;
        }
        this.zza = new long[i2];
    }
}
