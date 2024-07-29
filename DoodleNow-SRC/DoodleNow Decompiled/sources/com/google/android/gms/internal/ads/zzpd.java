package com.google.android.gms.internal.ads;

import android.media.AudioFormat;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzpd {
    public static int zza(int i, int i2, zzk zzk) {
        for (int i3 = 10; i3 > 0; i3--) {
            int zzh = zzfx.zzh(i3);
            if (zzh != 0 && FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m(new AudioFormat.Builder().setEncoding(i).setSampleRate(i2).setChannelMask(zzh).build(), zzk.zza().zza)) {
                return i3;
            }
        }
        return 0;
    }

    public static zzfzn<Integer> zzb(zzk zzk) {
        zzfzk zzfzk = new zzfzk();
        zzgbt zze = zzph.zzb.keySet().iterator();
        while (zze.hasNext()) {
            int intValue = ((Integer) zze.next()).intValue();
            if (zzfx.zza >= zzfx.zzg(intValue) && FrameworkMediaDrm$$ExternalSyntheticApiModelOutline0.m(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(OpusUtil.SAMPLE_RATE).build(), zzk.zza().zza)) {
                zzfzk.zzf(Integer.valueOf(intValue));
            }
        }
        zzfzk.zzf(2);
        return zzfzk.zzi();
    }
}
