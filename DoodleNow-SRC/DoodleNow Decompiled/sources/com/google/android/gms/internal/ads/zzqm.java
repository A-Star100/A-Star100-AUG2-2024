package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzqm extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzam zzc;

    public zzqm(int i, zzam zzam, boolean z) {
        super("AudioTrack write failed: " + i);
        this.zzb = z;
        this.zza = i;
        this.zzc = zzam;
    }
}
