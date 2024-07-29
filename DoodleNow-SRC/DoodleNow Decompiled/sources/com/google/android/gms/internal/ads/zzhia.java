package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzhia implements zzgzz {
    EVENT_URL(1),
    LANDING_PAGE(2),
    LANDING_REFERRER(3),
    CLIENT_REDIRECT(4),
    SERVER_REDIRECT(5),
    RECENT_NAVIGATION(6),
    REFERRER(7);
    
    private static final zzhaa zzh = null;
    private final int zzj;

    static {
        zzh = new zzhhy();
    }

    private zzhia(int i) {
        this.zzj = i;
    }

    public static zzhia zzb(int i) {
        switch (i) {
            case 1:
                return EVENT_URL;
            case 2:
                return LANDING_PAGE;
            case 3:
                return LANDING_REFERRER;
            case 4:
                return CLIENT_REDIRECT;
            case 5:
                return SERVER_REDIRECT;
            case 6:
                return RECENT_NAVIGATION;
            case 7:
                return REFERRER;
            default:
                return null;
        }
    }

    public final String toString() {
        return Integer.toString(this.zzj);
    }

    public final int zza() {
        return this.zzj;
    }
}
