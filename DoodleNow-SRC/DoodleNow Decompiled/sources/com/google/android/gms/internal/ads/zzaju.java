package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaju {
    public final zzakb zza;
    public final zzake zzb;
    public final zzaem zzc;
    public final zzaen zzd;
    public int zze;

    public zzaju(zzakb zzakb, zzake zzake, zzaem zzaem) {
        this.zza = zzakb;
        this.zzb = zzake;
        this.zzc = zzaem;
        this.zzd = MimeTypes.AUDIO_TRUEHD.equals(zzakb.zzf.zzm) ? new zzaen() : null;
    }
}
