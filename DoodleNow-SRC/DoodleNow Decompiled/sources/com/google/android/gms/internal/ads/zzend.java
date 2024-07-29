package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zzbn;
import com.google.android.gms.ads.internal.client.zzbp;
import com.google.android.gms.ads.internal.client.zzcf;
import com.google.android.gms.ads.internal.client.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzend extends zzbp {
    final zzfgg zza;
    final zzdlh zzb = new zzdlh();
    private final Context zzc;
    private final zzcik zzd;
    private zzbh zze;

    public zzend(zzcik zzcik, Context context, String str) {
        zzfgg zzfgg = new zzfgg();
        this.zza = zzfgg;
        this.zzd = zzcik;
        zzfgg.zzt(str);
        this.zzc = context;
    }

    public final zzbn zze() {
        zzdlj zzg = this.zzb.zzg();
        this.zza.zzD(zzg.zzi());
        this.zza.zzE(zzg.zzh());
        zzfgg zzfgg = this.zza;
        if (zzfgg.zzh() == null) {
            zzfgg.zzs(zzq.zzc());
        }
        return new zzene(this.zzc, this.zzd, this.zza, zzg, this.zze);
    }

    public final void zzf(zzbic zzbic) {
        this.zzb.zza(zzbic);
    }

    public final void zzg(zzbif zzbif) {
        this.zzb.zzb(zzbif);
    }

    public final void zzh(String str, zzbil zzbil, zzbii zzbii) {
        this.zzb.zzc(str, zzbil, zzbii);
    }

    public final void zzi(zzbnr zzbnr) {
        this.zzb.zzd(zzbnr);
    }

    public final void zzj(zzbip zzbip, zzq zzq) {
        this.zzb.zze(zzbip);
        this.zza.zzs(zzq);
    }

    public final void zzk(zzbis zzbis) {
        this.zzb.zzf(zzbis);
    }

    public final void zzl(zzbh zzbh) {
        this.zze = zzbh;
    }

    public final void zzm(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzr(adManagerAdViewOptions);
    }

    public final void zzn(zzbni zzbni) {
        this.zza.zzw(zzbni);
    }

    public final void zzo(zzbgt zzbgt) {
        this.zza.zzC(zzbgt);
    }

    public final void zzp(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzF(publisherAdViewOptions);
    }

    public final void zzq(zzcf zzcf) {
        this.zza.zzS(zzcf);
    }
}
