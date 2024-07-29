package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzck {
    public static final zzck zza = new zzci().zze();
    @Deprecated
    public static final zzn zzb = zzch.zza;
    private static final String zzc = Integer.toString(0, 36);
    /* access modifiers changed from: private */
    public final zzah zzd;

    /* synthetic */ zzck(zzah zzah, zzcj zzcj) {
        this.zzd = zzah;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzck)) {
            return false;
        }
        return this.zzd.equals(((zzck) obj).zzd);
    }

    public final int hashCode() {
        return this.zzd.hashCode();
    }
}
