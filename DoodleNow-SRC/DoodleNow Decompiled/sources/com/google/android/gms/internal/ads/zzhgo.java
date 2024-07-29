package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzhgo implements zzgzz {
    TYPE_UNKNOWN(0),
    TYPE_CREATIVE(1);
    
    private static final zzhaa zzc = null;
    private final int zze;

    static {
        zzc = new zzhgm();
    }

    private zzhgo(int i) {
        this.zze = i;
    }

    public static zzhgo zzb(int i) {
        if (i == 0) {
            return TYPE_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return TYPE_CREATIVE;
    }

    public final String toString() {
        return Integer.toString(this.zze);
    }

    public final int zza() {
        return this.zze;
    }
}
