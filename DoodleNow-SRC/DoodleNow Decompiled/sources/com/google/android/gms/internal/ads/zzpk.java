package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzpk extends AudioDeviceCallback {
    final /* synthetic */ zzpo zza;

    /* synthetic */ zzpk(zzpo zzpo, zzpj zzpj) {
        this.zza = zzpo;
    }

    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpo zzpo = this.zza;
        this.zza.zzj(zzph.zzc(zzpo.zza, zzpo.zzh, zzpo.zzg));
    }

    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        zzpp zzd = this.zza.zzg;
        int i = zzfx.zza;
        int length = audioDeviceInfoArr.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            } else if (zzfx.zzG(audioDeviceInfoArr[i2], zzd)) {
                this.zza.zzg = null;
                break;
            } else {
                i2++;
            }
        }
        zzpo zzpo = this.zza;
        zzpo.zzj(zzph.zzc(zzpo.zza, zzpo.zzh, zzpo.zzg));
    }
}
