package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzfqt implements zzgzz {
    EVENT_TYPE_UNKNOWN(0),
    BLOCKED_IMPRESSION(1);
    
    private static final zzhaa zzc = null;
    private final int zze;

    static {
        zzc = new zzfqr();
    }

    private zzfqt(int i) {
        this.zze = i;
    }

    public static zzfqt zzb(int i) {
        if (i == 0) {
            return EVENT_TYPE_UNKNOWN;
        }
        if (i != 1) {
            return null;
        }
        return BLOCKED_IMPRESSION;
    }

    public final String toString() {
        return Integer.toString(this.zze);
    }

    public final int zza() {
        return this.zze;
    }
}
