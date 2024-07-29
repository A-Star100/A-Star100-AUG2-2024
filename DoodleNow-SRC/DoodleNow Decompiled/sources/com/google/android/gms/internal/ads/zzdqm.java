package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdqm extends zzctv {
    private final Context zzc;
    private final WeakReference zzd;
    private final zzdiu zze;
    private final zzdfr zzf;
    private final zzczd zzg;
    private final zzdak zzh;
    private final zzcuq zzi;
    private final zzbyg zzj;
    private final zzfqa zzk;
    private final zzfgb zzl;
    private boolean zzm = false;

    zzdqm(zzctu zzctu, Context context, zzcgm zzcgm, zzdiu zzdiu, zzdfr zzdfr, zzczd zzczd, zzdak zzdak, zzcuq zzcuq, zzffn zzffn, zzfqa zzfqa, zzfgb zzfgb) {
        super(zzctu);
        this.zzc = context;
        this.zze = zzdiu;
        this.zzd = new WeakReference(zzcgm);
        this.zzf = zzdfr;
        this.zzg = zzczd;
        this.zzh = zzdak;
        this.zzi = zzcuq;
        this.zzk = zzfqa;
        zzbyc zzbyc = zzffn.zzm;
        this.zzj = new zzbza(zzbyc != null ? zzbyc.zza : "", zzbyc != null ? zzbyc.zzb : 1);
        this.zzl = zzfgb;
    }

    public final void finalize() throws Throwable {
        try {
            zzcgm zzcgm = (zzcgm) this.zzd.get();
            if (((Boolean) zzba.zzc().zza(zzbdz.zzgO)).booleanValue()) {
                if (!this.zzm && zzcgm != null) {
                    zzgep zzgep = zzcbr.zze;
                    Objects.requireNonNull(zzcgm);
                    zzgep.execute(new zzdql(zzcgm));
                }
            } else if (zzcgm != null) {
                zzcgm.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle zza() {
        return this.zzh.zzb();
    }

    public final zzbyg zzc() {
        return this.zzj;
    }

    public final zzfgb zzd() {
        return this.zzl;
    }

    public final boolean zze() {
        return this.zzi.zzg();
    }

    public final boolean zzf() {
        return this.zzm;
    }

    public final boolean zzg() {
        zzcgm zzcgm = (zzcgm) this.zzd.get();
        return zzcgm != null && !zzcgm.zzaD();
    }

    public final boolean zzh(boolean z, Activity activity) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzaB)).booleanValue()) {
            zzu.zzp();
            if (zzt.zzG(this.zzc)) {
                zzm.zzj("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzb();
                if (((Boolean) zzba.zzc().zza(zzbdz.zzaC)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzm) {
            zzm.zzj("The rewarded ad have been showed.");
            this.zzg.zza(zzfhk.zzd(10, (String) null, (zze) null));
            return false;
        }
        this.zzm = true;
        this.zzf.zzb();
        Context context = activity;
        if (activity == null) {
            context = this.zzc;
        }
        try {
            this.zze.zza(z, context, this.zzg);
            this.zzf.zza();
            return true;
        } catch (zzdit e) {
            this.zzg.zzc(e);
            return false;
        }
    }
}
