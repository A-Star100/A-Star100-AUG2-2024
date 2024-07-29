package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdnn implements Callable {
    public final /* synthetic */ zzdno zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ ListenableFuture zzd;
    public final /* synthetic */ ListenableFuture zze;
    public final /* synthetic */ ListenableFuture zzf;
    public final /* synthetic */ JSONObject zzg;
    public final /* synthetic */ ListenableFuture zzh;
    public final /* synthetic */ ListenableFuture zzi;
    public final /* synthetic */ ListenableFuture zzj;
    public final /* synthetic */ ListenableFuture zzk;

    public /* synthetic */ zzdnn(zzdno zzdno, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3, ListenableFuture listenableFuture4, ListenableFuture listenableFuture5, JSONObject jSONObject, ListenableFuture listenableFuture6, ListenableFuture listenableFuture7, ListenableFuture listenableFuture8, ListenableFuture listenableFuture9) {
        this.zza = zzdno;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = listenableFuture3;
        this.zze = listenableFuture4;
        this.zzf = listenableFuture5;
        this.zzg = jSONObject;
        this.zzh = listenableFuture6;
        this.zzi = listenableFuture7;
        this.zzj = listenableFuture8;
        this.zzk = listenableFuture9;
    }

    public final Object call() {
        zzdky zzdky = (zzdky) this.zzb.get();
        zzdky.zzP((List) this.zzc.get());
        zzdky.zzM((zzbhe) this.zzd.get());
        zzdky.zzQ((zzbhe) this.zze.get());
        zzdky.zzJ((zzbgx) this.zzf.get());
        JSONObject jSONObject = this.zzg;
        zzdky.zzS(zzdob.zzj(jSONObject));
        zzdky.zzL(zzdob.zzi(jSONObject));
        zzcgm zzcgm = (zzcgm) this.zzh.get();
        if (zzcgm != null) {
            zzdky.zzad(zzcgm);
            zzdky.zzac(zzcgm.zzF());
            zzdky.zzab(zzcgm.zzq());
        }
        zzcgm zzcgm2 = (zzcgm) this.zzi.get();
        if (zzcgm2 != null) {
            zzdky.zzO(zzcgm2);
            zzdky.zzae(zzcgm2.zzF());
        }
        ListenableFuture listenableFuture = this.zzj;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfc)).booleanValue()) {
            zzdky.zzU(listenableFuture);
            zzdky.zzX(new zzcbw());
        } else {
            zzcgm zzcgm3 = (zzcgm) listenableFuture.get();
            if (zzcgm3 != null) {
                zzdky.zzT(zzcgm3);
            }
        }
        for (zzdof zzdof : (List) this.zzk.get()) {
            if (zzdof.zza != 1) {
                zzdky.zzN(zzdof.zzb, zzdof.zzd);
            } else {
                zzdky.zzZ(zzdof.zzb, zzdof.zzc);
            }
        }
        return zzdky;
    }
}
