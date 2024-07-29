package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Pair;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcb;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeox implements zzeoq {
    private final zzfgg zza;
    /* access modifiers changed from: private */
    public final zzcik zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final zzeon zzd;
    /* access modifiers changed from: private */
    public final zzflk zze;
    private zzcuk zzf;

    public zzeox(zzcik zzcik, Context context, zzeon zzeon, zzfgg zzfgg) {
        this.zzb = zzcik;
        this.zzc = context;
        this.zzd = zzeon;
        this.zza = zzfgg;
        this.zze = zzcik.zzz();
        zzfgg.zzv(zzeon.zzd());
    }

    public final boolean zza() {
        zzcuk zzcuk = this.zzf;
        return zzcuk != null && zzcuk.zzf();
    }

    public final boolean zzb(zzl zzl, String str, zzeoo zzeoo, zzeop zzeop) throws RemoteException {
        zzflh zzflh;
        zzu.zzp();
        if (zzt.zzH(this.zzc) && zzl.zzs == null) {
            zzm.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzB().execute(new zzeos(this));
            return false;
        } else if (str == null) {
            zzm.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzB().execute(new zzeot(this));
            return false;
        } else {
            zzfhf.zza(this.zzc, zzl.zzf);
            if (((Boolean) zzba.zzc().zza(zzbdz.zziO)).booleanValue() && zzl.zzf) {
                this.zzb.zzl().zzo(true);
            }
            int i = ((zzeor) zzeoo).zza;
            Bundle zza2 = zzdts.zza(new Pair(zzdtq.PUBLIC_API_CALL.zza(), Long.valueOf(zzl.zzz)), new Pair(zzdtq.DYNAMITE_ENTER.zza(), Long.valueOf(zzu.zzB().currentTimeMillis())));
            zzfgg zzfgg = this.zza;
            zzfgg.zzG(zzl);
            zzfgg.zzz(zza2);
            zzfgg.zzB(i);
            Context context = this.zzc;
            zzfgi zzI = zzfgg.zzI();
            zzfkw zzb2 = zzfkv.zzb(context, zzflg.zza(zzI), zzflq.FORMAT_NATIVE, zzl);
            zzcb zzcb = zzI.zzn;
            if (zzcb != null) {
                this.zzd.zzd().zzm(zzcb);
            }
            zzdjh zzh = this.zzb.zzh();
            zzcxy zzcxy = new zzcxy();
            zzcxy.zze(this.zzc);
            zzcxy.zzi(zzI);
            zzh.zzf(zzcxy.zzj());
            zzdef zzdef = new zzdef();
            zzdef.zzk(this.zzd.zzd(), this.zzb.zzB());
            zzh.zze(zzdef.zzn());
            zzh.zzd(this.zzd.zzc());
            zzh.zzc(new zzcrj((ViewGroup) null));
            zzdji zzg = zzh.zzg();
            if (((Boolean) zzbfm.zzc.zze()).booleanValue()) {
                zzflh zzf2 = zzg.zzf();
                zzf2.zzd(zzflq.FORMAT_NATIVE);
                zzf2.zzb(zzl.zzp);
                zzflh = zzf2;
            } else {
                zzflh = null;
            }
            this.zzb.zzy().zzc(1);
            zzgep zzgep = zzcbr.zza;
            zzhjd.zzb(zzgep);
            ScheduledExecutorService zzC = this.zzb.zzC();
            zzcvd zza3 = zzg.zza();
            zzcuk zzcuk = new zzcuk(zzgep, zzC, zza3.zzi(zza3.zzj()));
            this.zzf = zzcuk;
            zzcuk.zze(new zzeow(this, zzeop, zzflh, zzb2, zzg));
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        this.zzd.zza().zzdB(zzfhk.zzd(4, (String) null, (zze) null));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzd.zza().zzdB(zzfhk.zzd(6, (String) null, (zze) null));
    }
}
