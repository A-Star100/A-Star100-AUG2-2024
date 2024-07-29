package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzrw implements zzqk {
    final /* synthetic */ zzrx zza;

    /* synthetic */ zzrw(zzrx zzrx, zzrv zzrv) {
        this.zza = zzrx;
    }

    public final void zza(Exception exc) {
        zzfe.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        this.zza.zzc.zzb(exc);
    }

    public final void zzb() {
        zzrx zzrx = this.zza;
        if (zzrx.zzm != null) {
            zzrx.zzm.zzb();
        }
    }
}
