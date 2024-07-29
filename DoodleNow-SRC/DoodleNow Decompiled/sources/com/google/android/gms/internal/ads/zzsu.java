package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzsu implements zztf {
    private final MediaCodec zza;
    private final zzta zzb;
    private final zztg zzc;
    private boolean zzd;
    private int zze = 0;

    /* synthetic */ zzsu(MediaCodec mediaCodec, HandlerThread handlerThread, zztg zztg, zzst zzst) {
        this.zza = mediaCodec;
        this.zzb = new zzta(handlerThread);
        this.zzc = zztg;
    }

    static /* bridge */ /* synthetic */ void zzh(zzsu zzsu, MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        zzsu.zzb.zzf(zzsu.zza);
        Trace.beginSection("configureCodec");
        zzsu.zza.configure(mediaFormat, surface, (MediaCrypto) null, i);
        Trace.endSection();
        zzsu.zzc.zzh();
        Trace.beginSection("startCodec");
        zzsu.zza.start();
        Trace.endSection();
        zzsu.zze = 1;
    }

    /* access modifiers changed from: private */
    public static String zzr(int i, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i == 1) {
            sb.append("Audio");
        } else if (i == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i);
            sb.append(")");
        }
        return sb.toString();
    }

    public final int zza() {
        this.zzc.zzc();
        return this.zzb.zza();
    }

    public final int zzb(MediaCodec.BufferInfo bufferInfo) {
        this.zzc.zzc();
        return this.zzb.zzb(bufferInfo);
    }

    public final MediaFormat zzc() {
        return this.zzb.zzc();
    }

    public final ByteBuffer zzf(int i) {
        return this.zza.getInputBuffer(i);
    }

    public final ByteBuffer zzg(int i) {
        return this.zza.getOutputBuffer(i);
    }

    public final void zzi() {
        this.zzc.zzb();
        this.zza.flush();
        this.zzb.zze();
        this.zza.start();
    }

    public final void zzj(int i, int i2, int i3, long j, int i4) {
        this.zzc.zzd(i, 0, i3, j, i4);
    }

    public final void zzk(int i, int i2, zzie zzie, long j, int i3) {
        this.zzc.zze(i, 0, zzie, j, 0);
    }

    public final void zzl() {
        try {
            if (this.zze == 1) {
                this.zzc.zzg();
                this.zzb.zzg();
            }
            this.zze = 2;
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
        } catch (Throwable th) {
            if (!this.zzd) {
                this.zza.release();
                this.zzd = true;
            }
            throw th;
        }
    }

    public final void zzm(int i, long j) {
        this.zza.releaseOutputBuffer(i, j);
    }

    public final void zzn(int i, boolean z) {
        this.zza.releaseOutputBuffer(i, false);
    }

    public final void zzo(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    public final void zzp(Bundle bundle) {
        this.zzc.zzf(bundle);
    }

    public final void zzq(int i) {
        this.zza.setVideoScalingMode(i);
    }
}
