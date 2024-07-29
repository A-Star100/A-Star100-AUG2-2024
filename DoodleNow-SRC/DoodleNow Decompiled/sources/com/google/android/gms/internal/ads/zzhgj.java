package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzhgj implements zzgzz {
    UNSPECIFIED(0),
    PHISHY_CLICK_EVENT(1),
    PHISHY_KEY_EVENT(2),
    PHISHY_PASTE_EVENT(3);
    
    private static final zzhaa zze = null;
    private final int zzg;

    static {
        zze = new zzhgh();
    }

    private zzhgj(int i) {
        this.zzg = i;
    }

    public static zzhgj zzb(int i) {
        if (i == 0) {
            return UNSPECIFIED;
        }
        if (i == 1) {
            return PHISHY_CLICK_EVENT;
        }
        if (i == 2) {
            return PHISHY_KEY_EVENT;
        }
        if (i != 3) {
            return null;
        }
        return PHISHY_PASTE_EVENT;
    }

    public final String toString() {
        return Integer.toString(this.zzg);
    }

    public final int zza() {
        return this.zzg;
    }
}
