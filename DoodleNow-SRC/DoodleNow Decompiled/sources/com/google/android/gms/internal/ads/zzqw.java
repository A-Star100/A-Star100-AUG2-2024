package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzqw implements Runnable {
    public final /* synthetic */ AudioTrack zza;
    public final /* synthetic */ zzqk zzb;
    public final /* synthetic */ Handler zzc;
    public final /* synthetic */ zzqh zzd;
    public final /* synthetic */ zzeo zze;

    public /* synthetic */ zzqw(AudioTrack audioTrack, zzqk zzqk, Handler handler, zzqh zzqh, zzeo zzeo) {
        this.zza = audioTrack;
        this.zzb = zzqk;
        this.zzc = handler;
        this.zzd = zzqh;
        this.zze = zzeo;
    }

    public final void run() {
        zzrr.zzH(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
