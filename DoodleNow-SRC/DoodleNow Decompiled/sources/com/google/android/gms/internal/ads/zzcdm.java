package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcdm {
    public final boolean zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final String zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final boolean zzj;
    public final boolean zzk;
    public final boolean zzl;
    public final boolean zzm;
    public final long zzn;
    public final long zzo;

    public zzcdm(String str) {
        String str2;
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zza = zza(jSONObject, "aggressive_media_codec_release", zzbdz.zzJ);
        this.zzb = zzb(jSONObject, "byte_buffer_precache_limit", zzbdz.zzl);
        this.zzc = zzb(jSONObject, "exo_cache_buffer_size", zzbdz.zzw);
        this.zzd = zzb(jSONObject, "exo_connect_timeout_millis", zzbdz.zzh);
        zzbdq zzbdq = zzbdz.zzg;
        if (jSONObject != null) {
            try {
                str2 = jSONObject.getString("exo_player_version");
            } catch (JSONException unused2) {
            }
            this.zze = str2;
            this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzbdz.zzi);
            this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzbdz.zzj);
            this.zzh = zzb(jSONObject, "player_precache_limit", zzbdz.zzk);
            this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzbdz.zzm);
            this.zzj = zza(jSONObject, "use_cache_data_source", zzbdz.zzek);
            zzb(jSONObject, "min_retry_count", zzbdz.zzn);
            this.zzk = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbdz.zzq);
            this.zzl = zza(jSONObject, "enable_multiple_video_playback", zzbdz.zzbR);
            this.zzm = zza(jSONObject, "use_range_http_data_source", zzbdz.zzbT);
            this.zzn = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbdz.zzbU);
            this.zzo = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbdz.zzbV);
        }
        str2 = (String) zzba.zzc().zza(zzbdq);
        this.zze = str2;
        this.zzf = zzb(jSONObject, "exo_read_timeout_millis", zzbdz.zzi);
        this.zzg = zzb(jSONObject, "load_check_interval_bytes", zzbdz.zzj);
        this.zzh = zzb(jSONObject, "player_precache_limit", zzbdz.zzk);
        this.zzi = zzb(jSONObject, "socket_receive_buffer_size", zzbdz.zzm);
        this.zzj = zza(jSONObject, "use_cache_data_source", zzbdz.zzek);
        zzb(jSONObject, "min_retry_count", zzbdz.zzn);
        this.zzk = zza(jSONObject, "treat_load_exception_as_non_fatal", zzbdz.zzq);
        this.zzl = zza(jSONObject, "enable_multiple_video_playback", zzbdz.zzbR);
        this.zzm = zza(jSONObject, "use_range_http_data_source", zzbdz.zzbT);
        this.zzn = zzc(jSONObject, "range_http_data_source_high_water_mark", zzbdz.zzbU);
        this.zzo = zzc(jSONObject, "range_http_data_source_low_water_mark", zzbdz.zzbV);
    }

    private static final boolean zza(JSONObject jSONObject, String str, zzbdq zzbdq) {
        boolean booleanValue = ((Boolean) zzba.zzc().zza(zzbdq)).booleanValue();
        if (jSONObject == null) {
            return booleanValue;
        }
        try {
            return jSONObject.getBoolean(str);
        } catch (JSONException unused) {
            return booleanValue;
        }
    }

    private static final int zzb(JSONObject jSONObject, String str, zzbdq zzbdq) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) zzba.zzc().zza(zzbdq)).intValue();
    }

    private static final long zzc(JSONObject jSONObject, String str, zzbdq zzbdq) {
        if (jSONObject != null) {
            try {
                return jSONObject.getLong(str);
            } catch (JSONException unused) {
            }
        }
        return ((Long) zzba.zzc().zza(zzbdq)).longValue();
    }
}
