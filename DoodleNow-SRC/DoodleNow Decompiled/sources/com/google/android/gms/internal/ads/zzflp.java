package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzflp implements zzhaa {
    zzflp() {
    }

    public final /* synthetic */ zzgzz zza(int i) {
        zzflq zzflq = zzflq.FORMAT_UNKNOWN;
        switch (i) {
            case 0:
                return zzflq.FORMAT_UNKNOWN;
            case 1:
                return zzflq.FORMAT_BANNER;
            case 2:
                return zzflq.FORMAT_INTERSTITIAL;
            case 3:
                return zzflq.FORMAT_REWARDED;
            case 4:
                return zzflq.FORMAT_REWARDED_INTERSTITIAL;
            case 5:
                return zzflq.FORMAT_APP_OPEN;
            case 6:
                return zzflq.FORMAT_NATIVE;
            default:
                return null;
        }
    }
}
