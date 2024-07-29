package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.material.chip.Chip$$ExternalSyntheticApiModelOutline0;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zztj {
    public static int zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        List m;
        List m2 = videoCapabilities.getSupportedPerformancePoints();
        if (m2 == null || m2.isEmpty()) {
            return 0;
        }
        int zzb = zzb(m2, Chip$$ExternalSyntheticApiModelOutline0.m(i, i2, (int) d));
        boolean z = true;
        if (zzb == 1 && zztk.zza == null) {
            try {
                zzak zzak = new zzak();
                zzak.zzW(MimeTypes.VIDEO_H264);
                zzam zzac = zzak.zzac();
                if (zzac.zzm != null) {
                    List zzf = zzuc.zzf(zztq.zzb, zzac, false, false);
                    int i3 = 0;
                    while (true) {
                        if (i3 >= zzf.size()) {
                            break;
                        } else if (((zzti) zzf.get(i3)).zzd == null || ((zzti) zzf.get(i3)).zzd.getVideoCapabilities() == null || (m = ((zzti) zzf.get(i3)).zzd.getVideoCapabilities().getSupportedPerformancePoints()) == null || m.isEmpty()) {
                            i3++;
                        } else {
                            Chip$$ExternalSyntheticApiModelOutline0.m$2();
                            if (zzb(m, Chip$$ExternalSyntheticApiModelOutline0.m(1280, 720, 60)) != 1) {
                                z = false;
                            }
                        }
                    }
                }
            } catch (zztw unused) {
            }
            zztk.zza = Boolean.valueOf(z);
            if (zztk.zza.booleanValue()) {
                return 0;
            }
        }
        return zzb;
    }

    private static int zzb(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
        for (int i = 0; i < list.size(); i++) {
            if (Chip$$ExternalSyntheticApiModelOutline0.m(list.get(i)).covers(performancePoint)) {
                return 2;
            }
        }
        return 1;
    }
}
