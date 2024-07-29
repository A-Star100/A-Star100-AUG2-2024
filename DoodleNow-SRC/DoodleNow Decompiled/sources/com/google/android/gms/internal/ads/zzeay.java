package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeay {
    private final zzgep zza;
    private final zzeac zzb;
    private final zzhip zzc;
    private final zzflk zzd;
    private final Context zze;
    private final VersionInfoParcel zzf;

    public zzeay(zzgep zzgep, zzeac zzeac, zzhip zzhip, zzflk zzflk, Context context, VersionInfoParcel versionInfoParcel) {
        this.zza = zzgep;
        this.zzb = zzeac;
        this.zzc = zzhip;
        this.zzd = zzflk;
        this.zze = context;
        this.zzf = versionInfoParcel;
    }

    private final ListenableFuture zzh(zzbxd zzbxd, zzeax zzeax, zzeax zzeax2, zzgdl zzgdl) {
        ListenableFuture listenableFuture;
        String str = zzbxd.zzd;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgee.zzg(new zzeal(1));
        } else {
            listenableFuture = zzgee.zzf(zzeax.zza(zzbxd), ExecutionException.class, zzeaw.zza, this.zza);
        }
        return zzgee.zzf(zzgee.zzn(zzgee.zzn(zzgdv.zzu(listenableFuture), zzeau.zza, this.zza), zzgdl, this.zza), zzeal.class, new zzeav(this, zzeax2, zzbxd, zzgdl), this.zza);
    }

    public final ListenableFuture zza(zzbxd zzbxd) {
        zzear zzear = new zzear(zzbxd);
        zzeac zzeac = this.zzb;
        Objects.requireNonNull(zzeac);
        return zzh(zzbxd, new zzeas(zzeac), new zzeat(this), zzear);
    }

    public final ListenableFuture zzb(JSONObject jSONObject) {
        return zzgee.zzn(zzgdv.zzu(zzgee.zzh(jSONObject)), zzu.zzf().zza(this.zze, this.zzf, this.zzd).zza("AFMA_getAdDictionary", zzbpn.zza, zzean.zza), this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzeax zzeax, zzbxd zzbxd, zzgdl zzgdl, zzeal zzeal) throws Exception {
        return zzgee.zzn(zzeax.zza(zzbxd), zzgdl, this.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzbxd zzbxd) {
        return ((zzecu) this.zzc.zzb()).zzb(zzbxd, Binder.getCallingUid());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(zzbxd zzbxd) {
        return this.zzb.zzc(zzbxd.zzh);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(zzbxd zzbxd) {
        return ((zzecu) this.zzc.zzb()).zzi(zzbxd.zzh);
    }

    public final ListenableFuture zzg(zzbxd zzbxd) {
        return zzh(zzbxd, new zzeap(this), new zzeaq(this), zzeao.zza);
    }
}
