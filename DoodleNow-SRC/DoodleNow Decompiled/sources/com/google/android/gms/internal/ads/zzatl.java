package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzatl implements zzgzz {
    FUNCTION_UNSPECIFIED(0),
    FUNCTION_METHOD_EXCHANGEIMPLEMENTATIONS(1),
    FUNCTION_METHOD_SETIMPLEMENTATIONS(2),
    FUNCTION_CLASS_ADDMETHOD(3),
    FUNCTION_CLASS_REPLACEMETHOD(4);
    
    private static final zzhaa zzf = null;
    private final int zzh;

    static {
        zzf = new zzatj();
    }

    private zzatl(int i) {
        this.zzh = i;
    }

    public static zzatl zzb(int i) {
        if (i == 0) {
            return FUNCTION_UNSPECIFIED;
        }
        if (i == 1) {
            return FUNCTION_METHOD_EXCHANGEIMPLEMENTATIONS;
        }
        if (i == 2) {
            return FUNCTION_METHOD_SETIMPLEMENTATIONS;
        }
        if (i == 3) {
            return FUNCTION_CLASS_ADDMETHOD;
        }
        if (i != 4) {
            return null;
        }
        return FUNCTION_CLASS_REPLACEMETHOD;
    }

    public final String toString() {
        return Integer.toString(this.zzh);
    }

    public final int zza() {
        return this.zzh;
    }
}
