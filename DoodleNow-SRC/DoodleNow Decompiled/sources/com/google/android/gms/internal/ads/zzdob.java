package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzel;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.util.concurrent.ListenableFuture;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdob {
    private final Context zza;
    private final zzdnk zzb;
    private final zzawo zzc;
    private final VersionInfoParcel zzd;
    private final zza zze;
    private final zzbcx zzf;
    private final Executor zzg;
    private final zzbgt zzh;
    private final zzdot zzi;
    private final zzdri zzj;
    private final ScheduledExecutorService zzk;
    private final zzdqd zzl;
    private final zzduh zzm;
    private final zzfmt zzn;
    private final zzefd zzo;
    private final zzefo zzp;
    private final zzfgm zzq;

    public zzdob(Context context, zzdnk zzdnk, zzawo zzawo, VersionInfoParcel versionInfoParcel, zza zza2, zzbcx zzbcx, Executor executor, zzfgi zzfgi, zzdot zzdot, zzdri zzdri, ScheduledExecutorService scheduledExecutorService, zzduh zzduh, zzfmt zzfmt, zzefd zzefd, zzdqd zzdqd, zzefo zzefo, zzfgm zzfgm) {
        this.zza = context;
        this.zzb = zzdnk;
        this.zzc = zzawo;
        this.zzd = versionInfoParcel;
        this.zze = zza2;
        this.zzf = zzbcx;
        this.zzg = executor;
        this.zzh = zzfgi.zzi;
        this.zzi = zzdot;
        this.zzj = zzdri;
        this.zzk = scheduledExecutorService;
        this.zzm = zzduh;
        this.zzn = zzfmt;
        this.zzo = zzefd;
        this.zzl = zzdqd;
        this.zzp = zzefo;
        this.zzq = zzfgm;
    }

    public static final zzel zzi(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(optJSONObject);
    }

    public static final List zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzfzn.zzm();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzfzn.zzm();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzel zzr = zzr(optJSONArray.optJSONObject(i));
            if (zzr != null) {
                arrayList.add(zzr);
            }
        }
        return zzfzn.zzk(arrayList);
    }

    private static ListenableFuture zzl(ListenableFuture listenableFuture, Object obj) {
        return zzgee.zzf(listenableFuture, Exception.class, new zzdnz((Object) null), zzcbr.zzf);
    }

    private static ListenableFuture zzm(boolean z, ListenableFuture listenableFuture, Object obj) {
        if (z) {
            return zzgee.zzn(listenableFuture, new zzdoa(listenableFuture), zzcbr.zzf);
        }
        return zzl(listenableFuture, (Object) null);
    }

    private final ListenableFuture zzn(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzgee.zzh((Object) null);
        }
        String optString = jSONObject.optString(ImagesContract.URL);
        if (TextUtils.isEmpty(optString)) {
            return zzgee.zzh((Object) null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzgee.zzh(new zzbgr((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zzm(jSONObject.optBoolean("require"), zzgee.zzm(this.zzb.zzb(optString, optDouble, optBoolean), new zzdnr(optString, optDouble, optInt, optInt2), this.zzg), (Object) null);
    }

    private final ListenableFuture zzo(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzgee.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i), z));
        }
        return zzgee.zzm(zzgee.zzd(arrayList), zzdnw.zza, this.zzg);
    }

    private final ListenableFuture zzp(JSONObject jSONObject, zzffn zzffn, zzffq zzffq) {
        ListenableFuture zzb2 = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString(InAppMessageContent.HTML), zzffn, zzffq, zzk(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzgee.zzn(zzb2, new zzdns(zzb2), zzcbr.zzf);
    }

    private static Integer zzq(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    private static final zzel zzr(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzel(optString, optString2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbgo zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString("text");
        Integer zzq2 = zzq(jSONObject, "bg_color");
        Integer zzq3 = zzq(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzbgo(optString, list, zzq2, zzq3, num, optInt3 + optInt2, this.zzh.zze, optBoolean);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzq zzq2, zzffn zzffn, zzffq zzffq, String str, String str2, Object obj) throws Exception {
        zzcgm zza2 = this.zzj.zza(zzq2, zzffn, zzffq);
        zzcbv zza3 = zzcbv.zza(zza2);
        zzdqa zzb2 = this.zzl.zzb();
        zzdqa zzdqa = zzb2;
        zzcic zzN = zza2.zzN();
        zzb zzb3 = r3;
        zzb zzb4 = new zzb(this.zza, (zzbzo) null, (zzbwg) null);
        zzN.zzR(zzb2, zzdqa, zzb2, zzb2, zzb2, false, (zzblb) null, zzb3, (zzbtt) null, (zzbzo) null, this.zzo, this.zzn, this.zzm, (zzbls) null, zzb2, (zzblr) null, (zzbll) null, (zzbkz) null, (zzcpk) null);
        zza2.zzae("/getNativeAdViewSignals", zzbkx.zzs);
        zza2.zzae("/getNativeClickMeta", zzbkx.zzt);
        zza2.zzN().zzB(new zzdnv(zza3));
        zza2.zzac(str, str2, (String) null);
        return zza3;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(String str, Object obj) throws Exception {
        zzu.zzz();
        zzcgm zza2 = zzcgz.zza(this.zza, zzcie.zza(), "native-omid", false, false, this.zzc, (zzbfc) null, this.zzd, (zzbeo) null, (zzm) null, this.zze, this.zzf, (zzffn) null, (zzffq) null, this.zzp, this.zzq);
        zzcbv zza3 = zzcbv.zza(zza2);
        zza2.zzN().zzB(new zzdnx(zza3));
        if (((Boolean) zzba.zzc().zza(zzbdz.zzeZ)).booleanValue()) {
            zza2.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64);
        } else {
            zza2.loadData(str, "text/html", "UTF-8");
        }
        return zza3;
    }

    public final ListenableFuture zzd(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject("attribution");
        if (optJSONObject == null) {
            return zzgee.zzh((Object) null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zzm(optJSONObject.optBoolean("require"), zzgee.zzm(zzo(optJSONArray, false, true), new zzdny(this, optJSONObject), this.zzg), (Object) null);
    }

    public final ListenableFuture zze(JSONObject jSONObject, String str) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final ListenableFuture zzf(JSONObject jSONObject, String str) {
        zzbgt zzbgt = this.zzh;
        return zzo(jSONObject.optJSONArray("images"), zzbgt.zzb, zzbgt.zzd);
    }

    public final ListenableFuture zzg(JSONObject jSONObject, String str, zzffn zzffn, zzffq zzffq) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzjQ)).booleanValue()) {
            return zzgee.zzh((Object) null);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("images");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzgee.zzh((Object) null);
        }
        JSONObject optJSONObject = optJSONArray.optJSONObject(0);
        if (optJSONObject == null) {
            return zzgee.zzh((Object) null);
        }
        String optString = optJSONObject.optString("base_url");
        String optString2 = optJSONObject.optString(InAppMessageContent.HTML);
        zzq zzk2 = zzk(optJSONObject.optInt("width", 0), optJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(optString2)) {
            return zzgee.zzh((Object) null);
        }
        ListenableFuture zzn2 = zzgee.zzn(zzgee.zzh((Object) null), new zzdnt(this, zzk2, zzffn, zzffq, optString, optString2), zzcbr.zze);
        return zzgee.zzn(zzn2, new zzdnu(zzn2), zzcbr.zzf);
    }

    public final ListenableFuture zzh(JSONObject jSONObject, zzffn zzffn, zzffq zzffq) {
        ListenableFuture listenableFuture;
        JSONObject zzg2 = zzbw.zzg(jSONObject, "html_containers", "instream");
        if (zzg2 != null) {
            return zzp(zzg2, zzffn, zzffq);
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("video");
        if (optJSONObject == null) {
            return zzgee.zzh((Object) null);
        }
        String optString = optJSONObject.optString("vast_xml");
        boolean z = false;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjP)).booleanValue() && optJSONObject.has(InAppMessageContent.HTML)) {
            z = true;
        }
        if (TextUtils.isEmpty(optString)) {
            if (!z) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Required field 'vast_xml' or 'html' is missing");
                return zzgee.zzh((Object) null);
            }
        } else if (!z) {
            listenableFuture = this.zzi.zza(optJSONObject);
            zzbdq zzbdq = zzbdz.zzdI;
            return zzl(zzgee.zzo(listenableFuture, (long) ((Integer) zzba.zzc().zza(zzbdq)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
        }
        listenableFuture = zzp(optJSONObject, zzffn, zzffq);
        zzbdq zzbdq2 = zzbdz.zzdI;
        return zzl(zzgee.zzo(listenableFuture, (long) ((Integer) zzba.zzc().zza(zzbdq2)).intValue(), TimeUnit.SECONDS, this.zzk), (Object) null);
    }

    private final zzq zzk(int i, int i2) {
        if (i == 0) {
            if (i2 == 0) {
                return zzq.zzc();
            }
            i = 0;
        }
        return new zzq(this.zza, new AdSize(i, i2));
    }
}
