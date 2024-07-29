package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzazg implements zzhaa {
    zzazg() {
    }

    public final /* synthetic */ zzgzz zza(int i) {
        zzazh zzazh = zzazh.UNSUPPORTED;
        if (i == 0) {
            return zzazh.UNSUPPORTED;
        }
        if (i == 2) {
            return zzazh.ARM7;
        }
        if (i == 999) {
            return zzazh.UNKNOWN;
        }
        if (i == 4) {
            return zzazh.X86;
        }
        if (i == 5) {
            return zzazh.ARM64;
        }
        if (i == 6) {
            return zzazh.X86_64;
        }
        if (i != 7) {
            return null;
        }
        return zzazh.RISCV64;
    }
}
