package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdno {
    private final zzgep zza;
    private final zzdob zzb;
    private final zzdog zzc;

    public zzdno(zzgep zzgep, zzdob zzdob, zzdog zzdog) {
        this.zza = zzgep;
        this.zzb = zzdob;
        this.zzc = zzdog;
    }

    public final ListenableFuture zza(zzffz zzffz, zzffn zzffn, JSONObject jSONObject) {
        ListenableFuture zzn;
        zzffz zzffz2 = zzffz;
        zzffn zzffn2 = zzffn;
        JSONObject jSONObject2 = jSONObject;
        ListenableFuture zzb2 = this.zza.zzb(new zzdnm(this, zzffz2, zzffn2, jSONObject2));
        ListenableFuture zzf = this.zzb.zzf(jSONObject2, "images");
        zzffq zzffq = zzffz2.zzb.zzb;
        zzdob zzdob = this.zzb;
        ListenableFuture zzg = zzdob.zzg(jSONObject2, "images", zzffn2, zzffq);
        ListenableFuture zze = zzdob.zze(jSONObject2, "secondary_image");
        ListenableFuture zze2 = zzdob.zze(jSONObject2, "app_icon");
        ListenableFuture zzd = zzdob.zzd(jSONObject2, "attribution");
        ListenableFuture zzh = this.zzb.zzh(jSONObject2, zzffn2, zzffz2.zzb.zzb);
        ListenableFuture zza2 = this.zzc.zza(jSONObject2, "custom_assets");
        if (!jSONObject2.optBoolean("enable_omid")) {
            zzn = zzgee.zzh((Object) null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzn = zzgee.zzh((Object) null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzn = zzgee.zzh((Object) null);
                } else {
                    zzn = zzgee.zzn(zzgee.zzh((Object) null), new zzdnq(this.zzb, optString), zzcbr.zze);
                }
            }
        }
        ListenableFuture listenableFuture = zzn;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzb2);
        arrayList.add(zzf);
        arrayList.add(zzg);
        arrayList.add(zze);
        arrayList.add(zze2);
        arrayList.add(zzd);
        arrayList.add(zzh);
        arrayList.add(zza2);
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzfc)).booleanValue()) {
            arrayList.add(listenableFuture);
        }
        return zzgee.zza(arrayList).zza(new zzdnn(this, zzb2, zzf, zze2, zze, zzd, jSONObject, zzh, zzg, listenableFuture, zza2), this.zza);
    }
}
