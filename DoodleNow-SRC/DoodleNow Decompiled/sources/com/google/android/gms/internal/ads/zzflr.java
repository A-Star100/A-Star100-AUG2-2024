package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzflr implements zzhaa {
    zzflr() {
    }

    public final /* synthetic */ zzgzz zza(int i) {
        zzfls zzfls = zzfls.ORIENTATION_UNKNOWN;
        if (i == 0) {
            return zzfls.ORIENTATION_UNKNOWN;
        }
        if (i == 1) {
            return zzfls.ORIENTATION_PORTRAIT;
        }
        if (i != 2) {
            return null;
        }
        return zzfls.ORIENTATION_LANDSCAPE;
    }
}
