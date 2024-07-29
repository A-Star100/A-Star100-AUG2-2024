package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfsc extends zzfsj {
    private String zza;
    private byte zzb;
    private int zzc;

    zzfsc() {
    }

    public final zzfsj zza(String str) {
        this.zza = "";
        return this;
    }

    public final zzfsj zzb(boolean z) {
        this.zzb = (byte) (this.zzb | 1);
        return this;
    }

    public final zzfsj zzc(boolean z) {
        this.zzb = (byte) (this.zzb | 2);
        return this;
    }

    public final zzfsj zze(int i) {
        this.zzc = 1;
        return this;
    }

    public final zzfsk zzd() {
        if (this.zzb == 3 && this.zza != null && this.zzc != 0) {
            return new zzfse(this.zza, false, false, (zzfsa) null, (zzfsb) null, this.zzc, (zzfsd) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" fileOwner");
        }
        if ((this.zzb & 1) == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if ((this.zzb & 2) == 0) {
            sb.append(" skipChecks");
        }
        if (this.zzc == 0) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
