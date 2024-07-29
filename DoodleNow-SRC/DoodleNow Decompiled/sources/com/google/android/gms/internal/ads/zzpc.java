package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzpc {
    private static zzfzs<Integer> zzb() {
        zzfzr zzfzr = new zzfzr();
        zzfzr.zzg(8, 7);
        if (zzfx.zza >= 31) {
            zzfzr.zzg(26, 27);
        }
        if (zzfx.zza >= 33) {
            zzfzr.zzf(30);
        }
        return zzfzr.zzi();
    }

    public static boolean zza(AudioManager audioManager, zzpp zzpp) {
        AudioDeviceInfo[] audioDeviceInfoArr;
        if (zzpp == null) {
            audioManager.getClass();
            audioDeviceInfoArr = audioManager.getDevices(2);
        } else {
            audioDeviceInfoArr = new AudioDeviceInfo[]{zzpp.zza};
        }
        zzfzs<Integer> zzb = zzb();
        for (AudioDeviceInfo type : audioDeviceInfoArr) {
            if (zzb.contains(Integer.valueOf(type.getType()))) {
                return true;
            }
        }
        return false;
    }
}
