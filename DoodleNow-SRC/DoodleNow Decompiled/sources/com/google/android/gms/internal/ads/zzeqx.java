package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeqx implements zzewr {
    private static final Object zzb = new Object();
    final Context zza;
    private final String zzc;
    private final String zzd;
    private final long zze;
    private final zzcvp zzf;
    private final zzfhq zzg;
    private final zzfgi zzh;
    private final zzg zzi = zzu.zzo().zzi();
    private final zzduc zzj;
    private final zzcwc zzk;

    public zzeqx(Context context, String str, String str2, zzcvp zzcvp, zzfhq zzfhq, zzfgi zzfgi, zzduc zzduc, zzcwc zzcwc, long j) {
        this.zza = context;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = zzcvp;
        this.zzg = zzfhq;
        this.zzh = zzfgi;
        this.zzj = zzduc;
        this.zzk = zzcwc;
        this.zze = j;
    }

    public final int zza() {
        return 12;
    }

    public final ListenableFuture zzb() {
        Bundle bundle = new Bundle();
        this.zzj.zzb().put("seq_num", this.zzc);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcc)).booleanValue()) {
            this.zzj.zzc("tsacc", String.valueOf(zzu.zzB().currentTimeMillis() - this.zze));
            zzduc zzduc = this.zzj;
            zzu.zzp();
            zzduc.zzc(DownloadService.KEY_FOREGROUND, true != zzt.zzG(this.zza) ? "1" : SessionDescription.SUPPORTED_SDP_VERSION);
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfC)).booleanValue()) {
            this.zzf.zzk(this.zzh.zzd);
            bundle.putAll(this.zzg.zzb());
        }
        return zzgee.zzh(new zzeqw(this, bundle));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Bundle bundle, Bundle bundle2) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfC)).booleanValue()) {
            bundle2.putBundle("quality_signals", bundle);
        } else {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzfB)).booleanValue()) {
                synchronized (zzb) {
                    this.zzf.zzk(this.zzh.zzd);
                    bundle2.putBundle("quality_signals", this.zzg.zzb());
                }
            } else {
                this.zzf.zzk(this.zzh.zzd);
                bundle2.putBundle("quality_signals", this.zzg.zzb());
            }
        }
        bundle2.putString("seq_num", this.zzc);
        if (!this.zzi.zzO()) {
            bundle2.putString("session_id", this.zzd);
        }
        bundle2.putBoolean("client_purpose_one", !this.zzi.zzO());
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfD)).booleanValue()) {
            try {
                zzu.zzp();
                bundle2.putString("_app_id", zzt.zzp(this.zza));
            } catch (RemoteException e) {
                zzu.zzo().zzw(e, "AppStatsSignal_AppId");
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfE)).booleanValue() && this.zzh.zzf != null) {
            Bundle bundle3 = new Bundle();
            bundle3.putLong("dload", this.zzk.zzb(this.zzh.zzf));
            bundle3.putInt("pcc", this.zzk.zza(this.zzh.zzf));
            bundle2.putBundle("ad_unit_quality_signals", bundle3);
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjE)).booleanValue() && zzu.zzo().zza() > 0) {
            bundle2.putInt("nrwv", zzu.zzo().zza());
        }
    }
}
