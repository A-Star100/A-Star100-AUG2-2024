package com.google.android.gms.internal.ads;

import androidx.room.RoomDatabase;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public enum zzazh implements zzgzz {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6),
    RISCV64(7),
    UNKNOWN(RoomDatabase.MAX_BIND_PARAMETER_CNT);
    
    private static final zzhaa zzh = null;
    private final int zzj;

    static {
        zzh = new zzazg();
    }

    private zzazh(int i) {
        this.zzj = i;
    }

    public final String toString() {
        return Integer.toString(this.zzj);
    }

    public final int zza() {
        return this.zzj;
    }
}
