package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzro extends AudioTrack$StreamEventCallback {
    final /* synthetic */ zzrr zza;
    final /* synthetic */ zzrp zzb;

    zzro(zzrp zzrp, zzrr zzrr) {
        this.zza = zzrr;
        this.zzb = zzrp;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i) {
        if (audioTrack.equals(this.zzb.zza.zzu)) {
            zzrr zzrr = this.zzb.zza;
            if (zzrr.zzq != null && zzrr.zzR) {
                zzrr.zzq.zzb();
            }
        }
    }

    public final void onTearDown(AudioTrack audioTrack) {
        if (audioTrack.equals(this.zzb.zza.zzu)) {
            zzrr zzrr = this.zzb.zza;
            if (zzrr.zzq != null && zzrr.zzR) {
                zzrr.zzq.zzb();
            }
        }
    }
}
