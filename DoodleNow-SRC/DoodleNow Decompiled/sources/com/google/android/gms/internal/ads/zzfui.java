package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfui extends zzfvb {
    private int zza;
    private String zzb;
    private byte zzc;

    zzfui() {
    }

    public final zzfvb zza(String str) {
        this.zzb = str;
        return this;
    }

    public final zzfvb zzb(int i) {
        this.zza = i;
        this.zzc = 1;
        return this;
    }

    public final zzfvc zzc() {
        if (this.zzc == 1) {
            return new zzfuk(this.zza, this.zzb, (zzfuj) null);
        }
        throw new IllegalStateException("Missing required properties: statusCode");
    }
}
