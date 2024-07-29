package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzip {
    private final AudioManager zza;
    private final zzin zzb;
    private zzio zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzip(Context context, Handler handler, zzio zzio) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        audioManager.getClass();
        this.zza = audioManager;
        this.zzc = zzio;
        this.zzb = new zzin(this, handler);
        this.zzd = 0;
    }

    private final void zze() {
        if (this.zzd != 0) {
            if (zzfx.zza < 26) {
                this.zza.abandonAudioFocus(this.zzb);
            }
            zzg(0);
        }
    }

    private final void zzf(int i) {
        zzio zzio = this.zzc;
        if (zzio != null) {
            zzkk zzkk = (zzkk) zzio;
            boolean zzv = zzkk.zza.zzv();
            zzkk.zza.zzak(zzv, i, zzko.zzX(zzv, i));
        }
    }

    private final void zzg(int i) {
        if (this.zzd != i) {
            this.zzd = i;
            float f = i == 3 ? 0.2f : 1.0f;
            if (this.zze != f) {
                this.zze = f;
                zzio zzio = this.zzc;
                if (zzio != null) {
                    ((zzkk) zzio).zza.zzah();
                }
            }
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z, int i) {
        zze();
        return z ? 1 : -1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
    }

    static /* bridge */ /* synthetic */ void zzc(zzip zzip, int i) {
        if (i == -3 || i == -2) {
            if (i != -2) {
                zzip.zzg(3);
                return;
            }
            zzip.zzf(0);
            zzip.zzg(2);
        } else if (i == -1) {
            zzip.zzf(-1);
            zzip.zze();
        } else if (i != 1) {
            zzfe.zzf("AudioFocusManager", "Unknown focus change type: " + i);
        } else {
            zzip.zzg(1);
            zzip.zzf(1);
        }
    }
}
