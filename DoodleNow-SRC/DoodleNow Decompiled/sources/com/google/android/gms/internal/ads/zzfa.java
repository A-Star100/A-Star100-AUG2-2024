package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfa {
    public final Object zza;
    private zzaf zzb = new zzaf();
    private boolean zzc;
    private boolean zzd;

    public zzfa(Object obj) {
        this.zza = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zza.equals(((zzfa) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zza(int i, zzey zzey) {
        if (!this.zzd) {
            if (i != -1) {
                this.zzb.zza(i);
            }
            this.zzc = true;
            zzey.zza(this.zza);
        }
    }

    public final void zzb(zzez zzez) {
        if (!this.zzd && this.zzc) {
            zzah zzb2 = this.zzb.zzb();
            this.zzb = new zzaf();
            this.zzc = false;
            zzez.zza(this.zza, zzb2);
        }
    }

    public final void zzc(zzez zzez) {
        this.zzd = true;
        if (this.zzc) {
            this.zzc = false;
            zzez.zza(this.zza, this.zzb.zzb());
        }
    }
}
