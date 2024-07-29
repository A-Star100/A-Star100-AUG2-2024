package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzhfg implements zzgzz {
    SURFACE_UNSPECIFIED(0),
    BUBBLE_MAINPAGE(1),
    BUBBLE_SUBPAGE(2),
    DOWNLOADS_PAGE(3),
    DOWNLOAD_PROMPT(4),
    DOWNLOAD_NOTIFICATION(5);
    
    private static final zzhaa zzg = null;
    private final int zzi;

    static {
        zzg = new zzhfe();
    }

    private zzhfg(int i) {
        this.zzi = i;
    }

    public static zzhfg zzb(int i) {
        if (i == 0) {
            return SURFACE_UNSPECIFIED;
        }
        if (i == 1) {
            return BUBBLE_MAINPAGE;
        }
        if (i == 2) {
            return BUBBLE_SUBPAGE;
        }
        if (i == 3) {
            return DOWNLOADS_PAGE;
        }
        if (i == 4) {
            return DOWNLOAD_PROMPT;
        }
        if (i != 5) {
            return null;
        }
        return DOWNLOAD_NOTIFICATION;
    }

    public final String toString() {
        return Integer.toString(this.zzi);
    }

    public final int zza() {
        return this.zzi;
    }
}
