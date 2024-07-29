package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzre {
    public final zzam zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final zzdq zzi;
    public final boolean zzj = false;
    public final boolean zzk = false;
    public final boolean zzl = false;

    public zzre(zzam zzam, int i, int i2, int i3, int i4, int i5, int i6, int i7, zzdq zzdq, boolean z, boolean z2, boolean z3) {
        this.zza = zzam;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = i3;
        this.zze = i4;
        this.zzf = i5;
        this.zzg = i6;
        this.zzh = i7;
        this.zzi = zzdq;
    }

    public final AudioTrack zza(zzk zzk2, int i) throws zzqj {
        AudioTrack audioTrack;
        try {
            if (zzfx.zza >= 29) {
                audioTrack = new AudioTrack.Builder().setAudioAttributes(zzk2.zza().zza).setAudioFormat(zzfx.zzw(this.zze, this.zzf, this.zzg)).setTransferMode(1).setBufferSizeInBytes(this.zzh).setSessionId(i).setOffloadedPlayback(this.zzc == 1).build();
            } else {
                audioTrack = new AudioTrack(zzk2.zza().zza, zzfx.zzw(this.zze, this.zzf, this.zzg), this.zzh, 1, i);
            }
            int state = audioTrack.getState();
            if (state == 1) {
                return audioTrack;
            }
            try {
                audioTrack.release();
            } catch (Exception unused) {
            }
            throw new zzqj(state, this.zze, this.zzf, this.zzh, this.zza, zzc(), (Exception) null);
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new zzqj(0, this.zze, this.zzf, this.zzh, this.zza, zzc(), e);
        }
    }

    public final zzqh zzb() {
        boolean z = this.zzc == 1;
        return new zzqh(this.zzg, this.zze, this.zzf, false, z, this.zzh);
    }

    public final boolean zzc() {
        return this.zzc == 1;
    }
}
