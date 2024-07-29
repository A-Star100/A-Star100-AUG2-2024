package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultLoadControl;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zziv implements zzlc {
    private final zzzo zzb;
    private final long zzc = zzfx.zzr(50000);
    private final long zzd = zzfx.zzr(50000);
    private final long zze = zzfx.zzr(2500);
    private final long zzf = zzfx.zzr(5000);
    private final long zzg = zzfx.zzr(0);
    private int zzh = 13107200;
    private boolean zzi;

    public zziv() {
        zzzo zzzo = new zzzo(true, 65536);
        zzj(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 0, "bufferForPlaybackMs", SessionDescription.SUPPORTED_SDP_VERSION);
        zzj(5000, 0, "bufferForPlaybackAfterRebufferMs", SessionDescription.SUPPORTED_SDP_VERSION);
        zzj(50000, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, "minBufferMs", "bufferForPlaybackMs");
        zzj(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzj(50000, 50000, "maxBufferMs", "minBufferMs");
        zzj(0, 0, "backBufferDurationMs", SessionDescription.SUPPORTED_SDP_VERSION);
        this.zzb = zzzo;
    }

    private static void zzj(int i, int i2, String str, String str2) {
        zzek.zze(i >= i2, str + " cannot be less than " + str2);
    }

    private final void zzk(boolean z) {
        this.zzh = 13107200;
        this.zzi = false;
        if (z) {
            this.zzb.zze();
        }
    }

    public final /* synthetic */ long zza(zzpb zzpb) {
        return this.zzg;
    }

    public final /* synthetic */ void zzb(zzpb zzpb) {
        zzk(false);
    }

    public final /* synthetic */ void zzc(zzpb zzpb) {
        zzk(true);
    }

    public final /* synthetic */ void zzd(zzpb zzpb) {
        zzk(true);
    }

    public final /* synthetic */ void zze(zzpb zzpb, zzcx zzcx, zzvh zzvh, zzmf[] zzmfArr, zzxk zzxk, zzyz[] zzyzArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int length = zzmfArr.length;
            int i3 = 13107200;
            if (i < 2) {
                if (zzyzArr[i] != null) {
                    if (zzmfArr[i].zzb() != 1) {
                        i3 = DefaultLoadControl.DEFAULT_VIDEO_BUFFER_SIZE;
                    }
                    i2 += i3;
                }
                i++;
            } else {
                int max = Math.max(13107200, i2);
                this.zzh = max;
                this.zzb.zzf(max);
                return;
            }
        }
    }

    public final /* synthetic */ boolean zzf(zzpb zzpb) {
        return false;
    }

    public final /* synthetic */ boolean zzg(zzpb zzpb, zzcx zzcx, zzvh zzvh, long j, long j2, float f) {
        int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
        int zza = this.zzb.zza();
        int i2 = this.zzh;
        long j3 = this.zzc;
        if (i > 0) {
            j3 = Math.min(zzfx.zzp(j3, f), this.zzd);
        }
        int i3 = (j2 > Math.max(j3, 500000) ? 1 : (j2 == Math.max(j3, 500000) ? 0 : -1));
        boolean z = false;
        if (i3 < 0) {
            if (zza < i2) {
                z = true;
            }
            this.zzi = z;
            if (!z && j2 < 500000) {
                zzfe.zzf("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.zzd || zza >= i2) {
            this.zzi = false;
        }
        return this.zzi;
    }

    public final /* synthetic */ boolean zzh(zzpb zzpb, zzcx zzcx, zzvh zzvh, long j, float f, boolean z, long j2) {
        long zzq = zzfx.zzq(j, f);
        long j3 = z ? this.zzf : this.zze;
        if (j2 != C.TIME_UNSET) {
            j3 = Math.min(j2 / 2, j3);
        }
        return j3 <= 0 || zzq >= j3 || this.zzb.zza() >= this.zzh;
    }

    public final zzzo zzi() {
        return this.zzb;
    }
}
