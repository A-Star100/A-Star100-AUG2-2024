package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
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
public final class zzffa implements zzeoq {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcik zzc;
    /* access modifiers changed from: private */
    public final zzfeq zzd;
    /* access modifiers changed from: private */
    public final zzfde zze;
    private final zzfga zzf;
    /* access modifiers changed from: private */
    public final zzflk zzg;
    private final zzfgg zzh;
    private ListenableFuture zzi;

    public zzffa(Context context, Executor executor, zzcik zzcik, zzfde zzfde, zzfeq zzfeq, zzfgg zzfgg, zzfga zzfga) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcik;
        this.zze = zzfde;
        this.zzd = zzfeq;
        this.zzh = zzfgg;
        this.zzf = zzfga;
        this.zzg = zzcik.zzz();
    }

    /* access modifiers changed from: private */
    public final zzdqq zzk(zzfdc zzfdc) {
        zzdqq zzi2 = this.zzc.zzi();
        zzcxy zzcxy = new zzcxy();
        zzcxy.zze(this.zza);
        zzcxy.zzi(((zzfez) zzfdc).zza);
        zzcxy.zzh(this.zzf);
        zzi2.zzd(zzcxy.zzj());
        zzi2.zzc(new zzdef().zzn());
        return zzi2;
    }

    public final boolean zza() {
        throw null;
    }

    public final boolean zzb(zzl zzl, String str, zzeoo zzeoo, zzeop zzeop) throws RemoteException {
        zzflh zzflh;
        zzbxx zzbxx = new zzbxx(zzl, str);
        if (zzbxx.zzb == null) {
            zzm.zzg("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new zzfet(this));
            return false;
        }
        ListenableFuture listenableFuture = this.zzi;
        if (listenableFuture != null && !listenableFuture.isDone()) {
            return false;
        }
        if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
            zzfde zzfde = this.zze;
            if (zzfde.zzd() != null) {
                zzflh zzh2 = ((zzdqr) zzfde.zzd()).zzh();
                zzh2.zzd(zzflq.FORMAT_REWARDED);
                zzh2.zzb(zzbxx.zza.zzp);
                zzflh = zzh2;
                zzfhf.zza(this.zza, zzbxx.zza.zzf);
                if (((Boolean) zzba.zzc().zza(zzbdz.zziO)).booleanValue() && zzbxx.zza.zzf) {
                    this.zzc.zzl().zzo(true);
                }
                Bundle zza2 = zzdts.zza(new Pair(zzdtq.PUBLIC_API_CALL.zza(), Long.valueOf(zzbxx.zza.zzz)), new Pair(zzdtq.DYNAMITE_ENTER.zza(), Long.valueOf(zzu.zzB().currentTimeMillis())));
                zzfgg zzfgg = this.zzh;
                zzfgg.zzt(zzbxx.zzb);
                zzfgg.zzs(zzq.zzd());
                zzfgg.zzG(zzbxx.zza);
                zzfgg.zzz(zza2);
                Context context = this.zza;
                zzfgi zzI = zzfgg.zzI();
                zzfkw zzb2 = zzfkv.zzb(context, zzflg.zza(zzI), zzflq.FORMAT_REWARDED, zzbxx.zza);
                zzfez zzfez = new zzfez((zzfey) null);
                zzfez.zza = zzI;
                ListenableFuture zzc2 = this.zze.zzc(new zzfdf(zzfez, (zzbxd) null), new zzfeu(this), (Object) null);
                this.zzi = zzc2;
                zzgee.zzr(zzc2, new zzfex(this, zzeop, zzflh, zzb2, zzfez), this.zzb);
                return true;
            }
        }
        zzflh = null;
        zzfhf.zza(this.zza, zzbxx.zza.zzf);
        this.zzc.zzl().zzo(true);
        Bundle zza22 = zzdts.zza(new Pair(zzdtq.PUBLIC_API_CALL.zza(), Long.valueOf(zzbxx.zza.zzz)), new Pair(zzdtq.DYNAMITE_ENTER.zza(), Long.valueOf(zzu.zzB().currentTimeMillis())));
        zzfgg zzfgg2 = this.zzh;
        zzfgg2.zzt(zzbxx.zzb);
        zzfgg2.zzs(zzq.zzd());
        zzfgg2.zzG(zzbxx.zza);
        zzfgg2.zzz(zza22);
        Context context2 = this.zza;
        zzfgi zzI2 = zzfgg2.zzI();
        zzfkw zzb22 = zzfkv.zzb(context2, zzflg.zza(zzI2), zzflq.FORMAT_REWARDED, zzbxx.zza);
        zzfez zzfez2 = new zzfez((zzfey) null);
        zzfez2.zza = zzI2;
        ListenableFuture zzc22 = this.zze.zzc(new zzfdf(zzfez2, (zzbxd) null), new zzfeu(this), (Object) null);
        this.zzi = zzc22;
        zzgee.zzr(zzc22, new zzfex(this, zzeop, zzflh, zzb22, zzfez2), this.zzb);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        this.zzd.zzdB(zzfhk.zzd(6, (String) null, (zze) null));
    }

    /* access modifiers changed from: package-private */
    public final void zzj(int i) {
        this.zzh.zzp().zza(i);
    }
}
