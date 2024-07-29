package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcvd {
    private final zzdzr zza;
    private final zzfgi zzb;
    private final zzfkn zzc;
    private final zzcny zzd;
    private final zzekk zze;
    /* access modifiers changed from: private */
    public final zzddv zzf;
    private zzffz zzg;
    private final zzeay zzh;
    private final zzcxu zzi;
    private final Executor zzj;
    private final zzeai zzk;
    private final zzego zzl;
    private final zzebo zzm;
    private final zzebv zzn;

    zzcvd(zzdzr zzdzr, zzfgi zzfgi, zzfkn zzfkn, zzcny zzcny, zzekk zzekk, zzddv zzddv, zzffz zzffz, zzeay zzeay, zzcxu zzcxu, Executor executor, zzeai zzeai, zzego zzego, zzebo zzebo, zzebv zzebv) {
        this.zza = zzdzr;
        this.zzb = zzfgi;
        this.zzc = zzfkn;
        this.zzd = zzcny;
        this.zze = zzekk;
        this.zzf = zzddv;
        this.zzg = zzffz;
        this.zzh = zzeay;
        this.zzi = zzcxu;
        this.zzj = executor;
        this.zzk = zzeai;
        this.zzl = zzego;
        this.zzm = zzebo;
        this.zzn = zzebv;
    }

    public final zze zza(Throwable th) {
        return zzfhk.zzb(th, this.zzl);
    }

    public final zzddv zzc() {
        return this.zzf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzffz zzd(zzffz zzffz) throws Exception {
        this.zzd.zza(zzffz);
        return zzffz;
    }

    public final ListenableFuture zze(zzfid zzfid) {
        zzfjs zza2 = this.zzc.zzb(zzfkh.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzcuz(this, zzfid)).zza();
        zzgee.zzr(zza2, new zzcvb(this), this.zzj);
        return zza2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(zzfid zzfid, zzbxd zzbxd) throws Exception {
        zzbxd.zzi = zzfid;
        return this.zzh.zza(zzbxd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzg(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3) throws Exception {
        return this.zzn.zzc((zzbxd) listenableFuture.get(), (JSONObject) listenableFuture2.get(), (zzbxg) listenableFuture3.get());
    }

    public final ListenableFuture zzh(zzbxd zzbxd) {
        zzfjs zza2 = this.zzc.zzb(zzfkh.NOTIFY_CACHE_HIT, this.zzh.zzg(zzbxd)).zza();
        zzgee.zzr(zza2, new zzcvc(this), this.zzj);
        return zza2;
    }

    public final ListenableFuture zzi(ListenableFuture listenableFuture) {
        zzfke zzf2 = this.zzc.zzb(zzfkh.RENDERER, listenableFuture).zze(new zzcuu(this)).zzf(this.zze);
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzfx)).booleanValue()) {
            zzf2 = zzf2.zzi((long) ((Integer) zzba.zzc().zza(zzbdz.zzfz)).intValue(), TimeUnit.SECONDS);
        }
        return zzf2.zza();
    }

    public final ListenableFuture zzj() {
        zzl zzl2 = this.zzb.zzd;
        if (zzl2.zzx == null && zzl2.zzs == null) {
            return zzk(this.zzi.zzc());
        }
        zzfkn zzfkn = this.zzc;
        zzdzr zzdzr = this.zza;
        return zzfjx.zzc(zzdzr.zza(), zzfkh.PRELOADED_LOADER, zzfkn).zza();
    }

    public final ListenableFuture zzk(ListenableFuture listenableFuture) {
        if (this.zzg != null) {
            zzfkn zzfkn = this.zzc;
            return zzfjx.zzc(zzgee.zzh(this.zzg), zzfkh.SERVER_TRANSACTION, zzfkn).zza();
        }
        zzu.zzc().zzj();
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzlk)).booleanValue() || ((Boolean) zzbfy.zzc.zze()).booleanValue()) {
            zzfke zzb2 = this.zzc.zzb(zzfkh.SERVER_TRANSACTION, listenableFuture);
            zzeai zzeai = this.zzk;
            Objects.requireNonNull(zzeai);
            return zzb2.zzf(new zzcva(zzeai)).zza();
        }
        zzebo zzebo = this.zzm;
        Objects.requireNonNull(zzebo);
        ListenableFuture zzn2 = zzgee.zzn(listenableFuture, new zzcuv(zzebo), this.zzj);
        zzfke zzb3 = this.zzc.zzb(zzfkh.BUILD_URL, zzn2);
        zzeay zzeay = this.zzh;
        Objects.requireNonNull(zzeay);
        zzfjs zza2 = zzb3.zzf(new zzcuw(zzeay)).zza();
        return this.zzc.zza(zzfkh.SERVER_TRANSACTION, listenableFuture, zzn2, zza2).zza(new zzcux(this, listenableFuture, zzn2, zza2)).zzf(zzcuy.zza).zza();
    }

    public final void zzl(zzffz zzffz) {
        this.zzg = zzffz;
    }
}
