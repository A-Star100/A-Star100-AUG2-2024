package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzyq {
    private final Spatializer zza;
    private final boolean zzb;
    private Handler zzc;
    private Spatializer$OnSpatializerStateChangedListener zzd;

    private zzyq(Spatializer spatializer) {
        this.zza = spatializer;
        this.zzb = FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m(spatializer) != 0;
    }

    public static zzyq zza(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return null;
        }
        return new zzyq(audioManager.getSpatializer());
    }

    public final void zzb(zzyx zzyx, Looper looper) {
        if (this.zzd == null && this.zzc == null) {
            this.zzd = new zzyp(this, zzyx);
            Handler handler = new Handler(looper);
            this.zzc = handler;
            Spatializer spatializer = this.zza;
            Objects.requireNonNull(handler);
            spatializer.addOnSpatializerStateChangedListener(new zzyo(handler), this.zzd);
        }
    }

    public final void zzc() {
        Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener = this.zzd;
        if (spatializer$OnSpatializerStateChangedListener != null && this.zzc != null) {
            this.zza.removeOnSpatializerStateChangedListener(spatializer$OnSpatializerStateChangedListener);
            Handler handler = this.zzc;
            int i = zzfx.zza;
            handler.removeCallbacksAndMessages((Object) null);
            this.zzc = null;
            this.zzd = null;
        }
    }

    public final boolean zzd(zzk zzk, zzam zzam) {
        int i;
        if (!MimeTypes.AUDIO_E_AC3_JOC.equals(zzam.zzm) || zzam.zzz != 16) {
            i = zzam.zzz;
        } else {
            i = 12;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(zzfx.zzh(i));
        int i2 = zzam.zzA;
        if (i2 != -1) {
            channelMask.setSampleRate(i2);
        }
        return this.zza.canBeSpatialized(zzk.zza().zza, channelMask.build());
    }

    public final boolean zze() {
        return this.zza.isAvailable();
    }

    public final boolean zzf() {
        return FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m(this.zza);
    }

    public final boolean zzg() {
        return this.zzb;
    }
}
