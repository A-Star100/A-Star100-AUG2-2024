package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzhfv implements zzgzz {
    SAFE_OR_OTHER(0),
    MALWARE(1),
    PHISHING(2),
    UNWANTED(3),
    BILLING(4);
    
    private static final zzhaa zzf = null;
    private final int zzh;

    static {
        zzf = new zzhft();
    }

    private zzhfv(int i) {
        this.zzh = i;
    }

    public static zzhfv zzb(int i) {
        if (i == 0) {
            return SAFE_OR_OTHER;
        }
        if (i == 1) {
            return MALWARE;
        }
        if (i == 2) {
            return PHISHING;
        }
        if (i == 3) {
            return UNWANTED;
        }
        if (i != 4) {
            return null;
        }
        return BILLING;
    }

    public final String toString() {
        return Integer.toString(this.zzh);
    }

    public final int zza() {
        return this.zzh;
    }
}
