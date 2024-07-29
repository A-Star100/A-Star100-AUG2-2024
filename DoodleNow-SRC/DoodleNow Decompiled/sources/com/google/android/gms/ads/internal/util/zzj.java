package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzbax;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbfl;
import com.google.android.gms.internal.ads.zzcbb;
import com.google.android.gms.internal.ads.zzcbr;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzj implements zzg {
    private boolean zzA = false;
    private String zzB = "";
    private String zzC = "{}";
    private int zzD = -1;
    private int zzE = -1;
    private long zzF = 0;
    private final Object zza = new Object();
    private boolean zzb;
    private final List zzc = new ArrayList();
    private ListenableFuture zzd;
    private zzbax zze = null;
    private SharedPreferences zzf;
    private SharedPreferences.Editor zzg;
    private boolean zzh = true;
    private String zzi;
    private String zzj;
    private boolean zzk = true;
    private String zzl = "-1";
    private String zzm = "-1";
    private String zzn = "-1";
    private int zzo = -1;
    private zzcbb zzp = new zzcbb("", 0);
    private long zzq = 0;
    private long zzr = 0;
    private int zzs = -1;
    private int zzt = 0;
    private Set zzu = Collections.emptySet();
    private JSONObject zzv = new JSONObject();
    private boolean zzw = true;
    private boolean zzx = true;
    private String zzy = null;
    private String zzz = "";

    private final void zzR() {
        ListenableFuture listenableFuture = this.zzd;
        if (listenableFuture != null && !listenableFuture.isDone()) {
            try {
                this.zzd.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzm.zzk("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzm.zzh("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final void zzS() {
        zzcbr.zza.execute(new zzh(this));
    }

    public final void zzA(boolean z) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjd)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                if (this.zzA != z) {
                    this.zzA = z;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putBoolean("linked_device", z);
                        this.zzg.apply();
                    }
                    zzS();
                }
            }
        }
    }

    public final void zzB(String str) {
        zzR();
        synchronized (this.zza) {
            if (!TextUtils.equals(this.zzy, str)) {
                this.zzy = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("display_cutout", str);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzC(long j) {
        zzR();
        synchronized (this.zza) {
            if (this.zzr != j) {
                this.zzr = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", j);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzD(String str) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zziO)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                if (!this.zzz.equals(str)) {
                    this.zzz = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("inspector_info", str);
                        this.zzg.apply();
                    }
                    zzS();
                }
            }
        }
    }

    public final void zzE(String str) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjq)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                if (!this.zzC.equals(str)) {
                    this.zzC = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("inspector_ui_storage", str);
                        this.zzg.apply();
                    }
                    zzS();
                }
            }
        }
    }

    public final void zzF(boolean z) {
        zzR();
        synchronized (this.zza) {
            if (z != this.zzk) {
                this.zzk = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("gad_idless", z);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzG(boolean z) {
        zzR();
        synchronized (this.zza) {
            long currentTimeMillis = System.currentTimeMillis() + ((Long) zzba.zzc().zza(zzbdz.zzkf)).longValue();
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putBoolean("is_topics_ad_personalization_allowed", z);
                this.zzg.putLong("topics_consent_expiry_time_ms", currentTimeMillis);
                this.zzg.apply();
            }
            zzS();
        }
    }

    public final void zzH(String str, String str2, boolean z) {
        zzR();
        synchronized (this.zza) {
            JSONArray optJSONArray = this.zzv.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (!str2.equals(optJSONObject.optString("template_id"))) {
                            i++;
                        } else if (!z || !optJSONObject.optBoolean("uses_media_view", false)) {
                            length = i;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzu.zzB().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzv.put(str, optJSONArray);
            } catch (JSONException e) {
                zzm.zzk("Could not update native advanced settings", e);
            }
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.putString("native_advanced_settings", this.zzv.toString());
                this.zzg.apply();
            }
            zzS();
        }
    }

    public final void zzI(int i) {
        zzR();
        synchronized (this.zza) {
            if (this.zzs != i) {
                this.zzs = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("request_in_session_count", i);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzJ(int i) {
        zzR();
        synchronized (this.zza) {
            if (this.zzE != i) {
                this.zzE = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("sd_app_measure_npa", i);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzK(long j) {
        zzR();
        synchronized (this.zza) {
            if (this.zzF != j) {
                this.zzF = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("sd_app_measure_npa_ts", j);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final boolean zzL() {
        boolean z;
        zzR();
        synchronized (this.zza) {
            z = this.zzw;
        }
        return z;
    }

    public final boolean zzM() {
        boolean z;
        zzR();
        synchronized (this.zza) {
            z = this.zzx;
        }
        return z;
    }

    public final boolean zzN() {
        boolean z;
        zzR();
        synchronized (this.zza) {
            z = this.zzA;
        }
        return z;
    }

    public final boolean zzO() {
        boolean z;
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzau)).booleanValue()) {
            return false;
        }
        zzR();
        synchronized (this.zza) {
            z = this.zzk;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzP() {
        /*
            r7 = this;
            r7.zzR()
            java.lang.Object r0 = r7.zza
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r7.zzf     // Catch:{ all -> 0x0030 }
            r2 = 0
            if (r1 != 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return r2
        L_0x000d:
            java.lang.String r3 = "topics_consent_expiry_time_ms"
            r4 = 0
            long r3 = r1.getLong(r3, r4)     // Catch:{ all -> 0x0030 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0030 }
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x001f
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return r2
        L_0x001f:
            android.content.SharedPreferences r1 = r7.zzf     // Catch:{ all -> 0x0030 }
            java.lang.String r3 = "is_topics_ad_personalization_allowed"
            boolean r1 = r1.getBoolean(r3, r2)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
            boolean r1 = r7.zzk     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e
            r2 = 1
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return r2
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzj.zzP():boolean");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzQ(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("admob", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        try {
            synchronized (this.zza) {
                this.zzf = sharedPreferences;
                this.zzg = edit;
                if (PlatformVersion.isAtLeastM()) {
                    NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted();
                }
                this.zzh = this.zzf.getBoolean("use_https", this.zzh);
                this.zzw = this.zzf.getBoolean("content_url_opted_out", this.zzw);
                this.zzi = this.zzf.getString("content_url_hashes", this.zzi);
                this.zzk = this.zzf.getBoolean("gad_idless", this.zzk);
                this.zzx = this.zzf.getBoolean("content_vertical_opted_out", this.zzx);
                this.zzj = this.zzf.getString("content_vertical_hashes", this.zzj);
                this.zzt = this.zzf.getInt("version_code", this.zzt);
                this.zzp = new zzcbb(this.zzf.getString("app_settings_json", this.zzp.zzc()), this.zzf.getLong("app_settings_last_update_ms", this.zzp.zza()));
                this.zzq = this.zzf.getLong("app_last_background_time_ms", this.zzq);
                this.zzs = this.zzf.getInt("request_in_session_count", this.zzs);
                this.zzr = this.zzf.getLong("first_ad_req_time_ms", this.zzr);
                this.zzu = this.zzf.getStringSet("never_pool_slots", this.zzu);
                this.zzy = this.zzf.getString("display_cutout", this.zzy);
                this.zzD = this.zzf.getInt("app_measurement_npa", this.zzD);
                this.zzE = this.zzf.getInt("sd_app_measure_npa", this.zzE);
                this.zzF = this.zzf.getLong("sd_app_measure_npa_ts", this.zzF);
                this.zzz = this.zzf.getString("inspector_info", this.zzz);
                this.zzA = this.zzf.getBoolean("linked_device", this.zzA);
                this.zzB = this.zzf.getString("linked_ad_unit", this.zzB);
                this.zzC = this.zzf.getString("inspector_ui_storage", this.zzC);
                this.zzl = this.zzf.getString("IABTCF_gdprApplies", this.zzl);
                this.zzn = this.zzf.getString("IABTCF_PurposeConsents", this.zzn);
                this.zzm = this.zzf.getString("IABTCF_TCString", this.zzm);
                this.zzo = this.zzf.getInt("gad_has_consent_for_cookies", this.zzo);
                try {
                    this.zzv = new JSONObject(this.zzf.getString("native_advanced_settings", "{}"));
                } catch (JSONException e) {
                    zzm.zzk("Could not convert native advanced settings to json object", e);
                }
                zzS();
            }
        } catch (Throwable th) {
            zzu.zzo().zzw(th, "AdSharedPreferenceManagerImpl.initializeOnBackgroundThread");
            zze.zzb("AdSharedPreferenceManagerImpl.initializeOnBackgroundThread, errorMessage = ", th);
        }
    }

    public final int zza() {
        int i;
        zzR();
        synchronized (this.zza) {
            i = this.zzt;
        }
        return i;
    }

    public final int zzb() {
        int i;
        zzR();
        synchronized (this.zza) {
            i = this.zzs;
        }
        return i;
    }

    public final long zzc() {
        long j;
        zzR();
        synchronized (this.zza) {
            j = this.zzq;
        }
        return j;
    }

    public final long zzd() {
        long j;
        zzR();
        synchronized (this.zza) {
            j = this.zzr;
        }
        return j;
    }

    public final long zze() {
        long j;
        zzR();
        synchronized (this.zza) {
            j = this.zzF;
        }
        return j;
    }

    public final zzbax zzf() {
        if (!this.zzb) {
            return null;
        }
        if ((zzL() && zzM()) || !((Boolean) zzbfl.zzb.zze()).booleanValue()) {
            return null;
        }
        synchronized (this.zza) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zze == null) {
                this.zze = new zzbax();
            }
            this.zze.zze();
            zzm.zzi("start fetching content...");
            zzbax zzbax = this.zze;
            return zzbax;
        }
    }

    public final zzcbb zzg() {
        zzcbb zzcbb;
        zzR();
        synchronized (this.zza) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzls)).booleanValue() && this.zzp.zzj()) {
                for (Runnable run : this.zzc) {
                    run.run();
                }
            }
            zzcbb = this.zzp;
        }
        return zzcbb;
    }

    public final zzcbb zzh() {
        zzcbb zzcbb;
        synchronized (this.zza) {
            zzcbb = this.zzp;
        }
        return zzcbb;
    }

    public final String zzi() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzi;
        }
        return str;
    }

    public final String zzj() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzj;
        }
        return str;
    }

    public final String zzk() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzB;
        }
        return str;
    }

    public final String zzl() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzy;
        }
        return str;
    }

    public final String zzm() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzz;
        }
        return str;
    }

    public final String zzn() {
        String str;
        zzR();
        synchronized (this.zza) {
            str = this.zzC;
        }
        return str;
    }

    public final JSONObject zzo() {
        JSONObject jSONObject;
        zzR();
        synchronized (this.zza) {
            jSONObject = this.zzv;
        }
        return jSONObject;
    }

    public final void zzp(Runnable runnable) {
        this.zzc.add(runnable);
    }

    public final void zzq(Context context) {
        synchronized (this.zza) {
            if (this.zzf == null) {
                this.zzd = zzcbr.zza.zza(new zzi(this, context, "admob"));
                this.zzb = true;
            }
        }
    }

    public final void zzr() {
        zzR();
        synchronized (this.zza) {
            this.zzv = new JSONObject();
            SharedPreferences.Editor editor = this.zzg;
            if (editor != null) {
                editor.remove("native_advanced_settings");
                this.zzg.apply();
            }
            zzS();
        }
    }

    public final void zzs(long j) {
        zzR();
        synchronized (this.zza) {
            if (this.zzq != j) {
                this.zzq = j;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putLong("app_last_background_time_ms", j);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzt(String str) {
        zzR();
        synchronized (this.zza) {
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            if (str != null) {
                if (!str.equals(this.zzp.zzc())) {
                    this.zzp = new zzcbb(str, currentTimeMillis);
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("app_settings_json", str);
                        this.zzg.putLong("app_settings_last_update_ms", currentTimeMillis);
                        this.zzg.apply();
                    }
                    zzS();
                    for (Runnable run : this.zzc) {
                        run.run();
                    }
                    return;
                }
            }
            this.zzp.zzg(currentTimeMillis);
        }
    }

    public final void zzu(int i) {
        zzR();
        synchronized (this.zza) {
            if (this.zzt != i) {
                this.zzt = i;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putInt("version_code", i);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzv(String str) {
        zzR();
        synchronized (this.zza) {
            if (!str.equals(this.zzi)) {
                this.zzi = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("content_url_hashes", str);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzw(boolean z) {
        zzR();
        synchronized (this.zza) {
            if (this.zzw != z) {
                this.zzw = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_url_opted_out", z);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzx(String str) {
        zzR();
        synchronized (this.zza) {
            if (!str.equals(this.zzj)) {
                this.zzj = str;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putString("content_vertical_hashes", str);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzy(boolean z) {
        zzR();
        synchronized (this.zza) {
            if (this.zzx != z) {
                this.zzx = z;
                SharedPreferences.Editor editor = this.zzg;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", z);
                    this.zzg.apply();
                }
                zzS();
            }
        }
    }

    public final void zzz(String str) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjd)).booleanValue()) {
            zzR();
            synchronized (this.zza) {
                if (!this.zzB.equals(str)) {
                    this.zzB = str;
                    SharedPreferences.Editor editor = this.zzg;
                    if (editor != null) {
                        editor.putString("linked_ad_unit", str);
                        this.zzg.apply();
                    }
                    zzS();
                }
            }
        }
    }
}
