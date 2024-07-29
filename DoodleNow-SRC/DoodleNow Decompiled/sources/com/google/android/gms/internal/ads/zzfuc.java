package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfuc extends zzfuo {
    private String zza;
    private String zzb;

    zzfuc() {
    }

    public final zzfuo zza(String str) {
        this.zzb = str;
        return this;
    }

    public final zzfuo zzb(String str) {
        this.zza = str;
        return this;
    }

    public final zzfup zzc() {
        return new zzfue(this.zza, this.zzb, (zzfud) null);
    }
}
