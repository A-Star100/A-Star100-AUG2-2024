package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbwz extends zzbwx {
    private final Object zza = new Object();
    private final Context zzb;
    private SharedPreferences zzc;
    private final zzbpg zzd;
    private final VersionInfoParcel zze;

    public zzbwz(Context context, zzbpg zzbpg, VersionInfoParcel versionInfoParcel) {
        this.zzb = context.getApplicationContext();
        this.zze = versionInfoParcel;
        this.zzd = zzbpg;
    }

    public static JSONObject zzc(Context context, VersionInfoParcel versionInfoParcel) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (((Boolean) zzbft.zzb.zze()).booleanValue()) {
                jSONObject.put("package_name", context.getPackageName());
            }
            jSONObject.put("js", versionInfoParcel.afmaVersion);
            jSONObject.put("mf", zzbft.zzc.zze());
            jSONObject.put("cl", "619949182");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public final ListenableFuture zza() {
        synchronized (this.zza) {
            if (this.zzc == null) {
                this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        SharedPreferences sharedPreferences = this.zzc;
        long j = 0;
        if (sharedPreferences != null) {
            j = sharedPreferences.getLong("js_last_update", 0);
        }
        if (zzu.zzB().currentTimeMillis() - j < ((Long) zzbft.zzd.zze()).longValue()) {
            return zzgee.zzh((Object) null);
        }
        return zzgee.zzm(this.zzd.zzb(zzc(this.zzb, this.zze)), new zzbwy(this), zzcbr.zzf);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzb(JSONObject jSONObject) {
        zzbdq zzbdq = zzbdz.zza;
        zzba.zzb();
        SharedPreferences.Editor edit = zzbds.zza(this.zzb).edit();
        zzba.zza();
        zzbff zzbff = zzbfk.zza;
        zzba.zza().zze(edit, 1, jSONObject);
        zzba.zzb();
        edit.commit();
        SharedPreferences sharedPreferences = this.zzc;
        if (sharedPreferences == null) {
            return null;
        }
        sharedPreferences.edit().putLong("js_last_update", zzu.zzB().currentTimeMillis()).apply();
        return null;
    }
}
