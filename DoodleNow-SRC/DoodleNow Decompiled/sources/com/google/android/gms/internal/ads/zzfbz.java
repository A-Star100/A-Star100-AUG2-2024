package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbe;
import com.google.android.gms.ads.internal.client.zzbh;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfbz implements zzeoq {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzcik zzc;
    /* access modifiers changed from: private */
    public final zzeoa zzd;
    /* access modifiers changed from: private */
    public final zzeoe zze;
    /* access modifiers changed from: private */
    public final ViewGroup zzf;
    private zzbeu zzg;
    /* access modifiers changed from: private */
    public final zzdbf zzh;
    /* access modifiers changed from: private */
    public final zzflk zzi;
    /* access modifiers changed from: private */
    public final zzddm zzj;
    private final zzfgg zzk;
    /* access modifiers changed from: private */
    public ListenableFuture zzl;

    public zzfbz(Context context, Executor executor, zzq zzq, zzcik zzcik, zzeoa zzeoa, zzeoe zzeoe, zzfgg zzfgg, zzddm zzddm) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcik;
        this.zzd = zzeoa;
        this.zze = zzeoe;
        this.zzk = zzfgg;
        this.zzh = zzcik.zzf();
        this.zzi = zzcik.zzz();
        this.zzf = new FrameLayout(context);
        this.zzj = zzddm;
        zzfgg.zzs(zzq);
    }

    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzl;
        return listenableFuture != null && !listenableFuture.isDone();
    }

    public final boolean zzb(zzl zzl2, String str, zzeoo zzeoo, zzeop zzeop) throws RemoteException {
        zzcsm zzcsm;
        zzflh zzflh;
        if (str == null) {
            zzm.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new zzfbv(this));
            return false;
        }
        if (!zza()) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zziO)).booleanValue() && zzl2.zzf) {
                this.zzc.zzl().zzo(true);
            }
            Bundle zza2 = zzdts.zza(new Pair(zzdtq.PUBLIC_API_CALL.zza(), Long.valueOf(zzl2.zzz)), new Pair(zzdtq.DYNAMITE_ENTER.zza(), Long.valueOf(zzu.zzB().currentTimeMillis())));
            zzfgg zzfgg = this.zzk;
            zzfgg.zzt(str);
            zzfgg.zzG(zzl2);
            zzfgg.zzz(zza2);
            Context context = this.zza;
            zzfgi zzI = zzfgg.zzI();
            zzfkw zzb2 = zzfkv.zzb(context, zzflg.zza(zzI), zzflq.FORMAT_BANNER, zzl2);
            if (!((Boolean) zzbfy.zze.zze()).booleanValue() || !this.zzk.zzh().zzk) {
                if (((Boolean) zzba.zzc().zza(zzbdz.zzie)).booleanValue()) {
                    zzcsl zze2 = this.zzc.zze();
                    zzcxy zzcxy = new zzcxy();
                    zzcxy.zze(this.zza);
                    zzcxy.zzi(zzI);
                    zze2.zzi(zzcxy.zzj());
                    zzdef zzdef = new zzdef();
                    zzdef.zzj(this.zzd, this.zzb);
                    zzdef.zzk(this.zzd, this.zzb);
                    zze2.zzf(zzdef.zzn());
                    zze2.zze(new zzemj(this.zzg));
                    zze2.zzd(new zzdjd(zzdlj.zza, (zzbh) null));
                    zze2.zzg(new zzctn(this.zzh, this.zzj));
                    zze2.zzc(new zzcrj(this.zzf));
                    zzcsm = zze2.zzk();
                } else {
                    zzcsl zze3 = this.zzc.zze();
                    zzcxy zzcxy2 = new zzcxy();
                    zzcxy2.zze(this.zza);
                    zzcxy2.zzi(zzI);
                    zze3.zzi(zzcxy2.zzj());
                    zzdef zzdef2 = new zzdef();
                    zzdef2.zzj(this.zzd, this.zzb);
                    zzdef2.zza(this.zzd, this.zzb);
                    zzdef2.zza(this.zze, this.zzb);
                    zzdef2.zzl(this.zzd, this.zzb);
                    zzdef2.zzd(this.zzd, this.zzb);
                    zzdef2.zze(this.zzd, this.zzb);
                    zzdef2.zzf(this.zzd, this.zzb);
                    zzdef2.zzb(this.zzd, this.zzb);
                    zzdef2.zzk(this.zzd, this.zzb);
                    zzdef2.zzi(this.zzd, this.zzb);
                    zze3.zzf(zzdef2.zzn());
                    zze3.zze(new zzemj(this.zzg));
                    zze3.zzd(new zzdjd(zzdlj.zza, (zzbh) null));
                    zze3.zzg(new zzctn(this.zzh, this.zzj));
                    zze3.zzc(new zzcrj(this.zzf));
                    zzcsm = zze3.zzk();
                }
                zzcsm zzcsm2 = zzcsm;
                if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
                    zzflh zzj2 = zzcsm2.zzj();
                    zzj2.zzd(zzflq.FORMAT_BANNER);
                    zzj2.zzb(zzl2.zzp);
                    zzflh = zzj2;
                } else {
                    zzflh = null;
                }
                zzcvd zzd2 = zzcsm2.zzd();
                ListenableFuture zzi2 = zzd2.zzi(zzd2.zzj());
                this.zzl = zzi2;
                zzgee.zzr(zzi2, new zzfby(this, zzeop, zzflh, zzb2, zzcsm2), this.zzb);
                return true;
            }
            zzeoa zzeoa = this.zzd;
            if (zzeoa != null) {
                zzeoa.zzdB(zzfhk.zzd(7, (String) null, (zze) null));
            }
        }
        return false;
    }

    public final ViewGroup zzd() {
        return this.zzf;
    }

    public final zzfgg zzi() {
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        this.zzd.zzdB(zzfhk.zzd(6, (String) null, (zze) null));
    }

    public final void zzn() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzo(zzbe zzbe) {
        this.zze.zza(zzbe);
    }

    public final void zzp(zzdbg zzdbg) {
        this.zzh.zzo(zzdbg, this.zzb);
    }

    public final void zzq(zzbeu zzbeu) {
        this.zzg = zzbeu;
    }

    public final boolean zzr() {
        ViewParent parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        zzu.zzp();
        return zzt.zzW(view, view.getContext());
    }
}
