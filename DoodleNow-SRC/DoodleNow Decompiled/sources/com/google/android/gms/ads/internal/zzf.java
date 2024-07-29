package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.amazon.a.a.o.b.f;
import com.amplitude.api.Constants;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbdq;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbpn;
import com.google.android.gms.internal.ads.zzcbb;
import com.google.android.gms.internal.ads.zzcbr;
import com.google.android.gms.internal.ads.zzcbu;
import com.google.android.gms.internal.ads.zzdug;
import com.google.android.gms.internal.ads.zzduh;
import com.google.android.gms.internal.ads.zzfkv;
import com.google.android.gms.internal.ads.zzfkw;
import com.google.android.gms.internal.ads.zzflk;
import com.google.android.gms.internal.ads.zzflo;
import com.google.android.gms.internal.ads.zzgee;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzf {
    private Context zza;
    private long zzb = 0;

    static final /* synthetic */ ListenableFuture zzd(Long l, zzduh zzduh, zzflk zzflk, zzfkw zzfkw, JSONObject jSONObject) throws Exception {
        boolean optBoolean = jSONObject.optBoolean("isSuccessful", false);
        if (optBoolean) {
            zzu.zzo().zzi().zzt(jSONObject.getString("appSettingsJson"));
            if (l != null) {
                zzf(zzduh, "cld_s", zzu.zzB().elapsedRealtime() - l.longValue());
            }
        }
        zzfkw.zzg(optBoolean);
        zzflk.zzb(zzfkw.zzm());
        return zzgee.zzh((Object) null);
    }

    /* access modifiers changed from: private */
    public static final void zzf(zzduh zzduh, String str, long j) {
        if (zzduh != null) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzmk)).booleanValue()) {
                zzdug zza2 = zzduh.zza();
                zza2.zzb("action", "lat_init");
                zza2.zzb(str, Long.toString(j));
                zza2.zzf();
            }
        }
    }

    public final void zza(Context context, VersionInfoParcel versionInfoParcel, String str, Runnable runnable, zzflk zzflk, zzduh zzduh, Long l) {
        zzb(context, versionInfoParcel, true, (zzcbb) null, str, (String) null, runnable, zzflk, zzduh, l);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Context context, VersionInfoParcel versionInfoParcel, boolean z, zzcbb zzcbb, String str, String str2, Runnable runnable, zzflk zzflk, zzduh zzduh, Long l) {
        PackageInfo packageInfo;
        Context context2 = context;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        Runnable runnable2 = runnable;
        zzflk zzflk2 = zzflk;
        Long l2 = l;
        if (zzu.zzB().elapsedRealtime() - this.zzb < 5000) {
            zzm.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzu.zzB().elapsedRealtime();
        if (zzcbb != null && !TextUtils.isEmpty(zzcbb.zzc())) {
            if (zzu.zzB().currentTimeMillis() - zzcbb.zza() <= ((Long) zzba.zzc().zza(zzbdz.zzea)).longValue() && zzcbb.zzi()) {
                return;
            }
        }
        if (context2 == null) {
            zzm.zzj("Context not provided to fetch application settings");
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context2;
            }
            this.zza = applicationContext;
            zzfkw zza2 = zzfkv.zza(context, zzflo.CUI_NAME_SDKINIT_CLD);
            zza2.zzi();
            zzbpg zza3 = zzu.zzf().zza(this.zza, versionInfoParcel, zzflk2).zza("google.afma.config.fetchAppSettings", zzbpn.zza, zzbpn.zza);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", str2);
                }
                jSONObject.put("is_init", z);
                jSONObject.put("pn", context.getPackageName());
                zzbdq zzbdq = zzbdz.zza;
                jSONObject.put("experiment_ids", TextUtils.join(f.a, zzba.zza().zza()));
                jSONObject.put("js", versionInfoParcel2.afmaVersion);
                try {
                    ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                    if (!(applicationInfo == null || (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) == null)) {
                        jSONObject.put(Constants.AMP_PLAN_VERSION, packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    zze.zza("Error fetching PackageInfo.");
                }
                ListenableFuture zzb2 = zza3.zzb(jSONObject);
                ListenableFuture zzn = zzgee.zzn(zzb2, new zzd(this, l, zzduh, zzflk, zza2), zzcbr.zzf);
                if (runnable2 != null) {
                    zzb2.addListener(runnable2, zzcbr.zzf);
                }
                if (l2 != null) {
                    zzb2.addListener(new zze(this, zzduh, l2), zzcbr.zzf);
                }
                if (((Boolean) zzba.zzc().zza(zzbdz.zzhJ)).booleanValue()) {
                    zzcbu.zzb(zzn, "ConfigLoader.maybeFetchNewAppSettings");
                } else {
                    zzcbu.zza(zzn, "ConfigLoader.maybeFetchNewAppSettings");
                }
            } catch (Exception e) {
                zzm.zzh("Error requesting application settings", e);
                zza2.zzh(e);
                zza2.zzg(false);
                zzflk2.zzb(zza2.zzm());
            }
        } else {
            zzm.zzj("App settings could not be fetched. Required parameters missing");
        }
    }

    public final void zzc(Context context, VersionInfoParcel versionInfoParcel, String str, zzcbb zzcbb, zzflk zzflk) {
        zzb(context, versionInfoParcel, false, zzcbb, zzcbb != null ? zzcbb.zzb() : null, str, (Runnable) null, zzflk, (zzduh) null, (Long) null);
    }
}
