package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzpo {
    /* access modifiers changed from: private */
    public final Context zza;
    private final Handler zzb;
    private final zzpk zzc;
    private final BroadcastReceiver zzd;
    private final zzpl zze;
    private zzph zzf;
    /* access modifiers changed from: private */
    public zzpp zzg;
    /* access modifiers changed from: private */
    public zzk zzh;
    private boolean zzi;
    private final zzqz zzj;

    zzpo(Context context, zzqz zzqz, zzk zzk, zzpp zzpp) {
        Context applicationContext = context.getApplicationContext();
        this.zza = applicationContext;
        this.zzj = zzqz;
        this.zzh = zzk;
        this.zzg = zzpp;
        zzpl zzpl = null;
        Handler handler = new Handler(zzfx.zzy(), (Handler.Callback) null);
        this.zzb = handler;
        this.zzc = zzfx.zza >= 23 ? new zzpk(this, (zzpj) null) : null;
        this.zzd = new zzpn(this, (zzpm) null);
        Uri zza2 = zzph.zza();
        this.zze = zza2 != null ? new zzpl(this, handler, applicationContext.getContentResolver(), zza2) : zzpl;
    }

    /* access modifiers changed from: private */
    public final void zzj(zzph zzph) {
        if (this.zzi && !zzph.equals(this.zzf)) {
            this.zzf = zzph;
            this.zzj.zza.zzI(zzph);
        }
    }

    public final zzph zzc() {
        zzpk zzpk;
        if (this.zzi) {
            zzph zzph = this.zzf;
            zzph.getClass();
            return zzph;
        }
        this.zzi = true;
        zzpl zzpl = this.zze;
        if (zzpl != null) {
            zzpl.zza();
        }
        if (zzfx.zza >= 23 && (zzpk = this.zzc) != null) {
            zzpi.zza(this.zza, zzpk, this.zzb);
        }
        Intent intent = null;
        if (this.zzd != null) {
            intent = this.zza.registerReceiver(this.zzd, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), (String) null, this.zzb);
        }
        zzph zzd2 = zzph.zzd(this.zza, intent, this.zzh, this.zzg);
        this.zzf = zzd2;
        return zzd2;
    }

    public final void zzg(zzk zzk) {
        this.zzh = zzk;
        zzj(zzph.zzc(this.zza, zzk, this.zzg));
    }

    public final void zzi() {
        zzpk zzpk;
        if (this.zzi) {
            this.zzf = null;
            if (zzfx.zza >= 23 && (zzpk = this.zzc) != null) {
                zzpi.zzb(this.zza, zzpk);
            }
            BroadcastReceiver broadcastReceiver = this.zzd;
            if (broadcastReceiver != null) {
                this.zza.unregisterReceiver(broadcastReceiver);
            }
            zzpl zzpl = this.zze;
            if (zzpl != null) {
                zzpl.zzb();
            }
            this.zzi = false;
        }
    }

    public final void zzh(AudioDeviceInfo audioDeviceInfo) {
        zzpp zzpp = this.zzg;
        zzpp zzpp2 = null;
        if (!zzfx.zzG(audioDeviceInfo, zzpp == null ? null : zzpp.zza)) {
            if (audioDeviceInfo != null) {
                zzpp2 = new zzpp(audioDeviceInfo);
            }
            this.zzg = zzpp2;
            zzj(zzph.zzc(this.zza, this.zzh, zzpp2));
        }
    }
}
