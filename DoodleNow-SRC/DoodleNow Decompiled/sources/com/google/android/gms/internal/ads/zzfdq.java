package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfdq implements zzeoq {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcik zzc;
    /* access modifiers changed from: private */
    public final zzeoa zzd;
    /* access modifiers changed from: private */
    public final zzfeq zze;
    private zzbeu zzf;
    /* access modifiers changed from: private */
    public final zzflk zzg;
    private final zzfgg zzh;
    /* access modifiers changed from: private */
    public ListenableFuture zzi;

    public zzfdq(Context context, Executor executor, zzcik zzcik, zzeoa zzeoa, zzfeq zzfeq, zzfgg zzfgg) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcik;
        this.zzd = zzeoa;
        this.zzh = zzfgg;
        this.zze = zzfeq;
        this.zzg = zzcik.zzz();
    }

    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzi;
        return listenableFuture != null && !listenableFuture.isDone();
    }

    public final boolean zzb(zzl zzl, String str, zzeoo zzeoo, zzeop zzeop) {
        zzdim zzf2;
        zzflh zzflh;
        if (str == null) {
            zzm.zzg("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new zzfdk(this));
            return false;
        } else if (zza()) {
            return false;
        } else {
            if (((Boolean) zzba.zzc().zza(zzbdz.zziO)).booleanValue() && zzl.zzf) {
                this.zzc.zzl().zzo(true);
            }
            zzq zzq = ((zzfdj) zzeoo).zza;
            Bundle zza2 = zzdts.zza(new Pair(zzdtq.PUBLIC_API_CALL.zza(), Long.valueOf(zzl.zzz)), new Pair(zzdtq.DYNAMITE_ENTER.zza(), Long.valueOf(zzu.zzB().currentTimeMillis())));
            zzfgg zzfgg = this.zzh;
            zzfgg.zzt(str);
            zzfgg.zzs(zzq);
            zzfgg.zzG(zzl);
            zzfgg.zzz(zza2);
            Context context = this.zza;
            zzfgi zzI = zzfgg.zzI();
            zzfkw zzb2 = zzfkv.zzb(context, zzflg.zza(zzI), zzflq.FORMAT_INTERSTITIAL, zzl);
            if (((Boolean) zzba.zzc().zza(zzbdz.zzig)).booleanValue()) {
                zzdil zzg2 = this.zzc.zzg();
                zzcxy zzcxy = new zzcxy();
                zzcxy.zze(this.zza);
                zzcxy.zzi(zzI);
                zzg2.zze(zzcxy.zzj());
                zzdef zzdef = new zzdef();
                zzdef.zzj(this.zzd, this.zzb);
                zzdef.zzk(this.zzd, this.zzb);
                zzg2.zzd(zzdef.zzn());
                zzg2.zzc(new zzemj(this.zzf));
                zzf2 = zzg2.zzf();
            } else {
                zzdef zzdef2 = new zzdef();
                zzfeq zzfeq = this.zze;
                if (zzfeq != null) {
                    zzdef2.zze(zzfeq, this.zzb);
                    zzdef2.zzf(this.zze, this.zzb);
                    zzdef2.zzb(this.zze, this.zzb);
                }
                zzdil zzg3 = this.zzc.zzg();
                zzcxy zzcxy2 = new zzcxy();
                zzcxy2.zze(this.zza);
                zzcxy2.zzi(zzI);
                zzg3.zze(zzcxy2.zzj());
                zzdef2.zzj(this.zzd, this.zzb);
                zzdef2.zze(this.zzd, this.zzb);
                zzdef2.zzf(this.zzd, this.zzb);
                zzdef2.zzb(this.zzd, this.zzb);
                zzdef2.zza(this.zzd, this.zzb);
                zzdef2.zzl(this.zzd, this.zzb);
                zzdef2.zzk(this.zzd, this.zzb);
                zzdef2.zzi(this.zzd, this.zzb);
                zzdef2.zzc(this.zzd, this.zzb);
                zzg3.zzd(zzdef2.zzn());
                zzg3.zzc(new zzemj(this.zzf));
                zzf2 = zzg3.zzf();
            }
            zzdim zzdim = zzf2;
            if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
                zzflh zzf3 = zzdim.zzf();
                zzf3.zzd(zzflq.FORMAT_INTERSTITIAL);
                zzf3.zzb(zzl.zzp);
                zzflh = zzf3;
            } else {
                zzflh = null;
            }
            zzcvd zza3 = zzdim.zza();
            ListenableFuture zzi2 = zza3.zzi(zza3.zzj());
            this.zzi = zzi2;
            zzgee.zzr(zzi2, new zzfdp(this, zzeop, zzflh, zzb2, zzdim), this.zzb);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        this.zzd.zzdB(zzfhk.zzd(6, (String) null, (zze) null));
    }

    public final void zzi(zzbeu zzbeu) {
        this.zzf = zzbeu;
    }
}
