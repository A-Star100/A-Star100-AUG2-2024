package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcld {
    private zzcin zza;
    private zzcmq zzb;
    private zzfkr zzc;
    private zzcnc zzd;
    private zzfhl zze;

    private zzcld() {
    }

    /* synthetic */ zzcld(zzclc zzclc) {
    }

    public final zzcik zza() {
        zzhjd.zzc(this.zza, zzcin.class);
        zzhjd.zzc(this.zzb, zzcmq.class);
        if (this.zzc == null) {
            this.zzc = new zzfkr();
        }
        if (this.zzd == null) {
            this.zzd = new zzcnc();
        }
        if (this.zze == null) {
            this.zze = new zzfhl();
        }
        return new zzckh(this.zza, this.zzb, this.zzc, this.zzd, this.zze, (zzckg) null);
    }

    public final zzcld zzb(zzcin zzcin) {
        this.zza = zzcin;
        return this;
    }

    public final zzcld zzc(zzcmq zzcmq) {
        this.zzb = zzcmq;
        return this;
    }
}
