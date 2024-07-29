package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioProfile;
import com.google.android.material.chip.Chip$$ExternalSyntheticApiModelOutline0;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzpe {
    public static zzph zza(AudioManager audioManager, zzk zzk) {
        List m = audioManager.getDirectProfilesForAttributes(zzk.zza().zza);
        HashMap hashMap = new HashMap();
        hashMap.put(2, new HashSet(zzgcl.zzf(12)));
        for (int i = 0; i < m.size(); i++) {
            AudioProfile m2 = Chip$$ExternalSyntheticApiModelOutline0.m(m.get(i));
            if (Chip$$ExternalSyntheticApiModelOutline0.m(m2) != 1) {
                int m$1 = m2.getFormat();
                if (zzfx.zzK(m$1) || zzph.zzb.containsKey(Integer.valueOf(m$1))) {
                    Integer valueOf = Integer.valueOf(m$1);
                    if (hashMap.containsKey(valueOf)) {
                        Set set = (Set) hashMap.get(valueOf);
                        set.getClass();
                        set.addAll(zzgcl.zzf(Chip$$ExternalSyntheticApiModelOutline0.m(m2)));
                    } else {
                        hashMap.put(valueOf, new HashSet(zzgcl.zzf(Chip$$ExternalSyntheticApiModelOutline0.m(m2))));
                    }
                }
            }
        }
        zzfzk zzfzk = new zzfzk();
        for (Map.Entry entry : hashMap.entrySet()) {
            zzfzk.zzf(new zzpf(((Integer) entry.getKey()).intValue(), (Set) entry.getValue()));
        }
        return new zzph(zzfzk.zzi());
    }

    public static zzpp zzb(AudioManager audioManager, zzk zzk) {
        audioManager.getClass();
        try {
            List m$1 = audioManager.getAudioDevicesForAttributes(zzk.zza().zza);
            if (m$1.isEmpty()) {
                return null;
            }
            return new zzpp((AudioDeviceInfo) m$1.get(0));
        } catch (RuntimeException unused) {
            return null;
        }
    }
}
