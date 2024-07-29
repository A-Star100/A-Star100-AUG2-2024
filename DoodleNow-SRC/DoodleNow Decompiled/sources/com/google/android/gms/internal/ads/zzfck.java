package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfck implements zzfde {
    private final zzfde zza;
    private final zzfde zzb;
    private final zzfis zzc;
    private final String zzd;
    private zzcxx zze;
    private final Executor zzf;

    public zzfck(zzfde zzfde, zzfde zzfde2, zzfis zzfis, String str, Executor executor) {
        this.zza = zzfde;
        this.zzb = zzfde2;
        this.zzc = zzfis;
        this.zzd = str;
        this.zzf = executor;
    }

    private final ListenableFuture zzg(zzfif zzfif, zzfdf zzfdf) {
        zzcxx zzcxx = zzfif.zza;
        this.zze = zzcxx;
        if (zzfif.zzc != null) {
            if (zzcxx.zzf() != null) {
                zzfif.zzc.zzo().zzl(zzfif.zza.zzf());
            }
            return zzgee.zzh(zzfif.zzc);
        }
        zzcxx.zzb().zzl(zzfif.zzb);
        return ((zzfcu) this.zza).zzb(zzfdf, (zzfdd) null, zzfif.zza);
    }

    /* renamed from: zza */
    public final synchronized zzcxx zzd() {
        return this.zze;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzfdf zzfdf, zzfcj zzfcj, zzfdd zzfdd, zzcxx zzcxx, zzfcp zzfcp) throws Exception {
        if (zzfcp != null) {
            zzfcj zzfcj2 = new zzfcj(zzfcj.zza, zzfcj.zzb, zzfcj.zzc, zzfcj.zzd, zzfcj.zze, zzfcj.zzf, zzfcp.zza);
            if (zzfcp.zzc != null) {
                this.zze = null;
                this.zzc.zze(zzfcj2);
                return zzg(zzfcp.zzc, zzfdf);
            }
            ListenableFuture zza2 = this.zzc.zza(zzfcj2);
            if (zza2 != null) {
                this.zze = null;
                return zzgee.zzn(zza2, new zzfcg(this), this.zzf);
            }
            this.zzc.zze(zzfcj2);
            zzfdf = new zzfdf(zzfdf.zzb, zzfcp.zzb);
        }
        ListenableFuture zzb2 = ((zzfcu) this.zza).zzb(zzfdf, zzfdd, zzcxx);
        this.zze = zzcxx;
        return zzb2;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zzc(zzfdf zzfdf, zzfdd zzfdd, Object obj) {
        return zzf(zzfdf, zzfdd, (zzcxx) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(zzfip zzfip) throws Exception {
        zzfir zzfir;
        if (zzfip == null || zzfip.zza == null || (zzfir = zzfip.zzb) == null) {
            throw new zzdyi(1, "Empty prefetch");
        }
        zzbdg.zzb.zzc zzd2 = zzbdg.zzb.zzd();
        zzbdg.zzb.zza.C0016zza zza2 = zzbdg.zzb.zza.zza();
        zza2.zzf(zzbdg.zzb.zzd.IN_MEMORY);
        zza2.zzh(zzbdg.zzb.zze.zzi());
        zzd2.zzd(zza2);
        zzfip.zza.zza.zzb().zzc().zzm((zzbdg.zzb) zzd2.zzbr());
        return zzg(zzfip.zza, ((zzfcj) zzfir).zzb);
    }

    public final synchronized ListenableFuture zzf(zzfdf zzfdf, zzfdd zzfdd, zzcxx zzcxx) {
        zzfdf zzfdf2 = zzfdf;
        zzfdd zzfdd2 = zzfdd;
        synchronized (this) {
            zzcxw zza2 = zzfdd2.zza(zzfdf2.zzb);
            zza2.zza(new zzfcl(this.zzd));
            zzcxx zzcxx2 = (zzcxx) zza2.zzh();
            zzcxx2.zzg();
            zzcxx2.zzg();
            zzl zzl = zzcxx2.zzg().zzd;
            if (zzl.zzs == null) {
                if (zzl.zzx == null) {
                    zzfgi zzg = zzcxx2.zzg();
                    zzfdd zzfdd3 = zzfdd;
                    zzfdf zzfdf3 = zzfdf;
                    ListenableFuture zzn = zzgee.zzn(zzgdv.zzu(((zzfcq) this.zzb).zzb(zzfdf2, zzfdd2, zzcxx2)), new zzfch(this, zzfdf, new zzfcj(zzfdd3, zzfdf3, zzg.zzd, zzg.zzf, this.zzf, zzg.zzj, (zzfig) null), zzfdd, zzcxx2), this.zzf);
                    return zzn;
                }
            }
            this.zze = zzcxx2;
            ListenableFuture zzb2 = ((zzfcu) this.zza).zzb(zzfdf2, zzfdd2, zzcxx2);
            return zzb2;
        }
    }
}
