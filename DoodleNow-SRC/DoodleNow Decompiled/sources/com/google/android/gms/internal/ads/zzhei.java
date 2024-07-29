package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzhei implements zzgzz {
    UNKNOWN(0),
    UNAVAILABLE(1),
    NOT_MANAGED(2),
    ENTERPRISE_MANAGED(3);
    
    private static final zzhaa zze = null;
    private final int zzg;

    static {
        zze = new zzheg();
    }

    private zzhei(int i) {
        this.zzg = i;
    }

    public static zzhei zzb(int i) {
        if (i == 0) {
            return UNKNOWN;
        }
        if (i == 1) {
            return UNAVAILABLE;
        }
        if (i == 2) {
            return NOT_MANAGED;
        }
        if (i != 3) {
            return null;
        }
        return ENTERPRISE_MANAGED;
    }

    public final String toString() {
        return Integer.toString(this.zzg);
    }

    public final int zza() {
        return this.zzg;
    }
}
