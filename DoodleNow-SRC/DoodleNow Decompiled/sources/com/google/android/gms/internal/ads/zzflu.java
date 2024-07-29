package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzflu implements zzgzz {
    OS_UNKNOWN(0),
    OS_ANDROID(1),
    OS_IOS(2),
    UNRECOGNIZED(-1);
    
    private static final zzhaa zze = null;
    private final int zzg;

    static {
        zze = new zzflt();
    }

    private zzflu(int i) {
        this.zzg = i;
    }

    public final String toString() {
        return Integer.toString(zza());
    }

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzg;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
