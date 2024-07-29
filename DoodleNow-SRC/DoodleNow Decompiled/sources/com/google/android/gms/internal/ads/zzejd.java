package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzejd implements zzeix {
    private final zzdji zza;
    private final zzgep zzb;
    private final zzdno zzc;
    private final zzfhh zzd;
    private final zzdqd zze;

    public zzejd(zzdji zzdji, zzgep zzgep, zzdno zzdno, zzfhh zzfhh, zzdqd zzdqd) {
        this.zza = zzdji;
        this.zzb = zzgep;
        this.zzc = zzdno;
        this.zzd = zzfhh;
        this.zze = zzdqd;
    }

    private final ListenableFuture zzg(zzffz zzffz, zzffn zzffn, JSONObject jSONObject) {
        zzdno zzdno = this.zzc;
        ListenableFuture zza2 = this.zzd.zza();
        ListenableFuture zza3 = zzdno.zza(zzffz, zzffn, jSONObject);
        return zzgee.zzc(zza2, zza3).zza(new zzeiy(this, zza3, zza2, zzffz, zzffn, jSONObject), this.zzb);
    }

    public final ListenableFuture zza(zzffz zzffz, zzffn zzffn) {
        return zzgee.zzn(zzgee.zzn(this.zzd.zza(), new zzeja(this, zzffn), this.zzb), new zzejb(this, zzffz, zzffn), this.zzb);
    }

    public final boolean zzb(zzffz zzffz, zzffn zzffn) {
        zzffs zzffs = zzffn.zzt;
        return (zzffs == null || zzffs.zzc == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdkt zzc(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzffz zzffz, zzffn zzffn, JSONObject jSONObject) throws Exception {
        zzdky zzdky = (zzdky) listenableFuture.get();
        zzdpx zzdpx = (zzdpx) listenableFuture2.get();
        zzdkz zzd2 = this.zza.zzd(new zzcul(zzffz, zzffn, (String) null), new zzdlk(zzdky), new zzdjx(jSONObject, zzdpx));
        zzd2.zzh().zzb();
        zzd2.zzk().zza(zzdpx);
        zzd2.zzg().zza(zzdky.zzs());
        zzd2.zzl().zza(this.zze, zzdky.zzq());
        return zzd2.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(zzdpx zzdpx, JSONObject jSONObject) throws Exception {
        this.zzd.zzb(zzgee.zzh(zzdpx));
        if (jSONObject.optBoolean("success")) {
            return zzgee.zzh(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzbpf("process json failed");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(zzffn zzffn, zzdpx zzdpx) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzba.zzc().zza(zzbdz.zziB)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzffn.zzt.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzgee.zzn(zzdpx.zzg("google.afma.nativeAds.preProcessJson", jSONObject2), new zzeiz(this, zzdpx), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzf(zzffz zzffz, zzffn zzffn, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzgee.zzg(new zzdyi(3));
        }
        if (zzffz.zza.zza.zzk > 1) {
            int length = jSONArray.length();
            this.zzd.zzc(Math.min(length, zzffz.zza.zza.zzk));
            ArrayList arrayList = new ArrayList(zzffz.zza.zza.zzk);
            for (int i = 0; i < zzffz.zza.zza.zzk; i++) {
                if (i < length) {
                    arrayList.add(zzg(zzffz, zzffn, jSONArray.getJSONObject(i)));
                } else {
                    arrayList.add(zzgee.zzg(new zzdyi(3)));
                }
            }
            return zzgee.zzh(arrayList);
        }
        return zzgee.zzm(zzg(zzffz, zzffn, jSONArray.getJSONObject(0)), zzejc.zza, this.zzb);
    }
}
