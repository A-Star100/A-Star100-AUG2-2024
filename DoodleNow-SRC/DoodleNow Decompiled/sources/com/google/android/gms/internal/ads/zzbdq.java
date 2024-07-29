package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public abstract class zzbdq {
    private final int zza;
    private final String zzb;
    private final Object zzc;
    private final Object zzd;

    /* synthetic */ zzbdq(int i, String str, Object obj, Object obj2, zzbdp zzbdp) {
        this.zza = i;
        this.zzb = str;
        this.zzc = obj;
        this.zzd = obj2;
        zzba.zza().zzd(this);
    }

    public static zzbdq zzf(int i, String str, float f, float f2) {
        return new zzbdn(1, str, Float.valueOf(f), Float.valueOf(f2));
    }

    public static zzbdq zzg(int i, String str, int i2, int i3) {
        return new zzbdl(1, str, Integer.valueOf(i2), Integer.valueOf(i3));
    }

    public static zzbdq zzh(int i, String str, long j, long j2) {
        return new zzbdm(1, str, Long.valueOf(j), Long.valueOf(j2));
    }

    public static zzbdq zzi(int i, String str, Boolean bool, Boolean bool2) {
        return new zzbdk(i, str, bool, bool2);
    }

    public static zzbdq zzj(int i, String str, String str2, String str3) {
        return new zzbdo(1, str, str2, str3);
    }

    public static zzbdq zzk(int i, String str) {
        zzbdq zzj = zzj(1, "gads:sdk_core_constants:experiment_id", (String) null, (String) null);
        zzba.zza().zzc(zzj);
        return zzj;
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(JSONObject jSONObject);

    public abstract Object zzb(Bundle bundle);

    /* access modifiers changed from: protected */
    public abstract Object zzc(SharedPreferences sharedPreferences);

    public abstract void zzd(SharedPreferences.Editor editor, Object obj);

    public final int zze() {
        return this.zza;
    }

    public final Object zzl() {
        return zzba.zzc().zza(this);
    }

    public final Object zzm() {
        return zzba.zzc().zze() ? this.zzd : this.zzc;
    }

    public final String zzn() {
        return this.zzb;
    }
}
