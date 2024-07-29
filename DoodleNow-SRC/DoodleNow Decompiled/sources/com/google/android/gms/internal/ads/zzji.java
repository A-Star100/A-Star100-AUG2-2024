package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.ExoPlayer;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzji {
    final Context zza;
    zzel zzb = zzel.zza;
    zzfxh zzc;
    zzfxh zzd;
    zzfxh zze;
    zzfxh zzf;
    zzfxh zzg;
    zzfwf zzh;
    Looper zzi = zzfx.zzy();
    zzk zzj = zzk.zza;
    int zzk = 1;
    boolean zzl = true;
    zzmj zzm = zzmj.zze;
    long zzn = 500;
    long zzo = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    boolean zzp = true;
    boolean zzq;
    String zzr = "";
    zziu zzs = new zziu(0.97f, 1.03f, 1000, 1.0E-7f, zzfx.zzr(20), zzfx.zzr(500), 0.999f, (zzit) null);

    static /* synthetic */ zzvg zza(Context context) {
        return new zzuu(context, new zzacy());
    }

    public zzji(Context context, zzcfw zzcfw) {
        Context context2 = context;
        zzjb zzjb = new zzjb(zzcfw);
        zzjc zzjc = new zzjc(context2);
        zzjd zzjd = new zzjd(context2);
        zzje zzje = zzje.zza;
        zzjf zzjf = new zzjf(context2);
        zzjg zzjg = zzjg.zza;
        context.getClass();
        this.zza = context2;
        this.zzc = zzjb;
        this.zzd = zzjc;
        this.zze = zzjd;
        this.zzf = zzje;
        this.zzg = zzjf;
        this.zzh = zzjg;
    }
}
