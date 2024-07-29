package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.util.client.zzm;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdwt implements zzcyt, zzdbl, zzdai {
    private final zzdxf zza;
    private final String zzb;
    private final String zzc;
    private int zzd;
    private zzdws zze;
    private zzcyj zzf;
    private zze zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private JSONObject zzk;
    private JSONObject zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;

    zzdwt(zzdxf zzdxf, zzfgi zzfgi, String str) {
        this.zza = zzdxf;
        this.zzc = str;
        this.zzb = zzfgi.zzf;
        this.zzd = 0;
        this.zze = zzdws.AD_REQUESTED;
    }

    private static JSONObject zzh(zze zze2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorDomain", zze2.zzc);
        jSONObject.put("errorCode", zze2.zza);
        jSONObject.put("errorDescription", zze2.zzb);
        zze zze3 = zze2.zzd;
        jSONObject.put("underlyingError", zze3 == null ? null : zzh(zze3));
        return jSONObject;
    }

    private final JSONObject zzi(zzcyj zzcyj) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("winningAdapterClassName", zzcyj.zzg());
        jSONObject2.put("responseSecsSinceEpoch", zzcyj.zzc());
        jSONObject2.put("responseId", zzcyj.zzi());
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjf)).booleanValue()) {
            String zzd2 = zzcyj.zzd();
            if (!TextUtils.isEmpty(zzd2)) {
                zzm.zze("Bidding data: ".concat(String.valueOf(zzd2)));
                jSONObject2.put("biddingData", new JSONObject(zzd2));
            }
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            jSONObject2.put("adRequestUrl", this.zzh);
        }
        if (!TextUtils.isEmpty(this.zzi)) {
            jSONObject2.put("postBody", this.zzi);
        }
        if (!TextUtils.isEmpty(this.zzj)) {
            jSONObject2.put("adResponseBody", this.zzj);
        }
        JSONObject jSONObject3 = this.zzk;
        if (jSONObject3 != null) {
            jSONObject2.put("adResponseHeaders", jSONObject3);
        }
        JSONObject jSONObject4 = this.zzl;
        if (jSONObject4 != null) {
            jSONObject2.put("transactionExtras", jSONObject4);
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzji)).booleanValue()) {
            jSONObject2.put("hasExceededMemoryLimit", this.zzo);
        }
        JSONArray jSONArray = new JSONArray();
        for (zzu zzu : zzcyj.zzj()) {
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("adapterClassName", zzu.zza);
            jSONObject5.put("latencyMillis", zzu.zzb);
            if (((Boolean) zzba.zzc().zza(zzbdz.zzjg)).booleanValue()) {
                jSONObject5.put("credentials", zzay.zzb().zzi(zzu.zzd));
            }
            zze zze2 = zzu.zzc;
            if (zze2 == null) {
                jSONObject = null;
            } else {
                jSONObject = zzh(zze2);
            }
            jSONObject5.put("error", jSONObject);
            jSONArray.put(jSONObject5);
        }
        jSONObject2.put("adNetworks", jSONArray);
        return jSONObject2;
    }

    public final void zza(zzctv zzctv) {
        if (this.zza.zzq()) {
            this.zzf = zzctv.zzl();
            this.zze = zzdws.AD_LOADED;
            if (((Boolean) zzba.zzc().zza(zzbdz.zzjm)).booleanValue()) {
                this.zza.zzf(this.zzb, this);
            }
        }
    }

    public final String zzc() {
        return this.zzc;
    }

    public final JSONObject zzd() throws JSONException {
        JSONObject jSONObject;
        IBinder iBinder;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("state", this.zze);
        jSONObject2.put("format", zzffn.zza(this.zzd));
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjm)).booleanValue()) {
            jSONObject2.put("isOutOfContext", this.zzm);
            if (this.zzm) {
                jSONObject2.put("shown", this.zzn);
            }
        }
        zzcyj zzcyj = this.zzf;
        if (zzcyj != null) {
            jSONObject = zzi(zzcyj);
        } else {
            zze zze2 = this.zzg;
            JSONObject jSONObject3 = null;
            if (!(zze2 == null || (iBinder = zze2.zze) == null)) {
                zzcyj zzcyj2 = (zzcyj) iBinder;
                jSONObject3 = zzi(zzcyj2);
                if (zzcyj2.zzj().isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(zzh(this.zzg));
                    jSONObject3.put("errors", jSONArray);
                }
            }
            jSONObject = jSONObject3;
        }
        jSONObject2.put("responseInfo", jSONObject);
        return jSONObject2;
    }

    public final void zzdB(zze zze2) {
        if (this.zza.zzq()) {
            this.zze = zzdws.AD_LOAD_FAILED;
            this.zzg = zze2;
            if (((Boolean) zzba.zzc().zza(zzbdz.zzjm)).booleanValue()) {
                this.zza.zzf(this.zzb, this);
            }
        }
    }

    public final void zzdn(zzbxd zzbxd) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzjm)).booleanValue() && this.zza.zzq()) {
            this.zza.zzf(this.zzb, this);
        }
    }

    public final void zzdo(zzffz zzffz) {
        if (this.zza.zzq()) {
            int i = 0;
            if (!zzffz.zzb.zza.isEmpty()) {
                this.zzd = ((zzffn) zzffz.zzb.zza.get(0)).zzb;
            }
            if (!TextUtils.isEmpty(zzffz.zzb.zzb.zzk)) {
                this.zzh = zzffz.zzb.zzb.zzk;
            }
            if (!TextUtils.isEmpty(zzffz.zzb.zzb.zzl)) {
                this.zzi = zzffz.zzb.zzb.zzl;
            }
            if (zzffz.zzb.zzb.zzo.length() > 0) {
                this.zzl = zzffz.zzb.zzb.zzo;
            }
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzji)).booleanValue()) {
                return;
            }
            if (!this.zza.zzs()) {
                this.zzo = true;
                return;
            }
            if (!TextUtils.isEmpty(zzffz.zzb.zzb.zzm)) {
                this.zzj = zzffz.zzb.zzb.zzm;
            }
            if (zzffz.zzb.zzb.zzn.length() > 0) {
                this.zzk = zzffz.zzb.zzb.zzn;
            }
            zzdxf zzdxf = this.zza;
            JSONObject jSONObject = this.zzk;
            if (jSONObject != null) {
                i = jSONObject.toString().length();
            }
            if (!TextUtils.isEmpty(this.zzj)) {
                i += this.zzj.length();
            }
            zzdxf.zzk((long) i);
        }
    }

    public final void zze() {
        this.zzm = true;
    }

    public final void zzf() {
        this.zzn = true;
    }

    public final boolean zzg() {
        return this.zze != zzdws.AD_REQUESTED;
    }
}
