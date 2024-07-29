package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcph implements Runnable {
    public final /* synthetic */ zzcpj zza;
    public final /* synthetic */ Throwable zzb;
    public final /* synthetic */ zzfmt zzc;
    public final /* synthetic */ String zzd;

    public /* synthetic */ zzcph(zzcpj zzcpj, Throwable th, zzfmt zzfmt, String str) {
        this.zza = zzcpj;
        this.zzb = th;
        this.zzc = zzfmt;
        this.zzd = str;
    }

    public final void run() {
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbdz.zzkc)).booleanValue();
        zzcpj zzcpj = this.zza;
        Throwable th = this.zzb;
        if (booleanValue) {
            zzcpk zzcpk = zzcpj.zzc;
            zzcpk.zzb = zzbvs.zzc(zzcpk.zzc);
            zzcpj.zzc.zzb.zzg(th, "AttributionReporting.registerSourceAndPingClickUrl");
        } else {
            zzcpk zzcpk2 = zzcpj.zzc;
            zzcpk2.zza = zzbvs.zza(zzcpk2.zzc);
            zzcpj.zzc.zza.zzg(th, "AttributionReportingSampled.registerSourceAndPingClickUrl");
        }
        this.zzc.zzc(this.zzd, (zzflh) null);
    }
}
