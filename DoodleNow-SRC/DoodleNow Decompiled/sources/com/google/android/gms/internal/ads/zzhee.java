package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzhee implements zzgzz {
    SOURCE_UNSPECIFIED(0),
    CLIENT_GENERATION(1);
    
    private static final zzhaa zzc = null;
    private final int zze;

    static {
        zzc = new zzhec();
    }

    private zzhee(int i) {
        this.zze = i;
    }

    public static zzhee zzb(int i) {
        if (i == 0) {
            return SOURCE_UNSPECIFIED;
        }
        if (i != 1) {
            return null;
        }
        return CLIENT_GENERATION;
    }

    public final String toString() {
        return Integer.toString(this.zze);
    }

    public final int zza() {
        return this.zze;
    }
}
