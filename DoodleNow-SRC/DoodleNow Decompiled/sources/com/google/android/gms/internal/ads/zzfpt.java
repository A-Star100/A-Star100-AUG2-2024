package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfpt extends zzfpq {
    private String zza;
    private boolean zzb;
    private boolean zzc;
    private byte zzd;

    zzfpt() {
    }

    public final zzfpq zza(String str) {
        if (str != null) {
            this.zza = str;
            return this;
        }
        throw new NullPointerException("Null clientVersion");
    }

    public final zzfpq zzb(boolean z) {
        this.zzc = true;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    public final zzfpq zzc(boolean z) {
        this.zzb = z;
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    public final zzfpr zzd() {
        String str;
        if (this.zzd == 3 && (str = this.zza) != null) {
            return new zzfpv(str, this.zzb, this.zzc, (zzfpu) null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" clientVersion");
        }
        if ((this.zzd & 1) == 0) {
            sb.append(" shouldGetAdvertisingId");
        }
        if ((this.zzd & 2) == 0) {
            sb.append(" isGooglePlayServicesAvailable");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
