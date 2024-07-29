package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzflt implements zzhaa {
    zzflt() {
    }

    public final /* synthetic */ zzgzz zza(int i) {
        zzflu zzflu = zzflu.OS_UNKNOWN;
        if (i == 0) {
            return zzflu.OS_UNKNOWN;
        }
        if (i == 1) {
            return zzflu.OS_ANDROID;
        }
        if (i != 2) {
            return null;
        }
        return zzflu.OS_IOS;
    }
}
