package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzqv {
    private final Context zza;
    private Boolean zzb;

    public zzqv() {
        this.zza = null;
    }

    public zzqv(Context context) {
        this.zza = context;
    }

    public final zzps zza(zzam zzam, zzk zzk) {
        boolean z;
        zzam.getClass();
        zzk.getClass();
        if (zzfx.zza < 29 || zzam.zzA == -1) {
            return zzps.zza;
        }
        Context context = this.zza;
        Boolean bool = this.zzb;
        if (bool != null) {
            z = bool.booleanValue();
        } else {
            boolean z2 = false;
            if (context != null) {
                AudioManager audioManager = (AudioManager) context.getSystemService("audio");
                if (audioManager != null) {
                    String parameters = audioManager.getParameters("offloadVariableRateSupported");
                    if (parameters != null && parameters.equals("offloadVariableRateSupported=1")) {
                        z2 = true;
                    }
                    this.zzb = Boolean.valueOf(z2);
                } else {
                    this.zzb = false;
                }
            } else {
                this.zzb = false;
            }
            z = this.zzb.booleanValue();
        }
        String str = zzam.zzm;
        str.getClass();
        int zza2 = zzcb.zza(str, zzam.zzj);
        if (zza2 == 0 || zzfx.zza < zzfx.zzg(zza2)) {
            return zzps.zza;
        }
        int zzh = zzfx.zzh(zzam.zzz);
        if (zzh == 0) {
            return zzps.zza;
        }
        try {
            AudioFormat zzw = zzfx.zzw(zzam.zzA, zzh, zza2);
            if (zzfx.zza >= 31) {
                return zzqu.zza(zzw, zzk.zza().zza, z);
            }
            return zzqt.zza(zzw, zzk.zza().zza, z);
        } catch (IllegalArgumentException unused) {
            return zzps.zza;
        }
    }
}
