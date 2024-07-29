package com.google.android.gms.internal.ads;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfnm extends ContentObserver {
    private final Context zza;
    private final AudioManager zzb;
    private final zzfnk zzc;
    private float zzd;
    private final zzfny zze;

    public zzfnm(Handler handler, Context context, zzfnk zzfnk, zzfny zzfny) {
        super(handler);
        this.zza = context;
        this.zzb = (AudioManager) context.getSystemService("audio");
        this.zzc = zzfnk;
        this.zze = zzfny;
    }

    private final float zzc() {
        AudioManager audioManager = this.zzb;
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        if (streamMaxVolume <= 0 || streamVolume <= 0) {
            return 0.0f;
        }
        float f = ((float) streamVolume) / ((float) streamMaxVolume);
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    private final void zzd() {
        this.zze.zze(this.zzd);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        float zzc2 = zzc();
        if (zzc2 != this.zzd) {
            this.zzd = zzc2;
            zzd();
        }
    }

    public final void zza() {
        this.zzd = zzc();
        zzd();
        this.zza.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void zzb() {
        this.zza.getContentResolver().unregisterContentObserver(this);
    }
}
