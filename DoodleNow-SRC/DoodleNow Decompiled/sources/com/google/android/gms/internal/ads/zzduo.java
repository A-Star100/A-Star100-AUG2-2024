package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzduo implements SharedPreferences.OnSharedPreferenceChangeListener {
    public final /* synthetic */ zzdup zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzduo(zzdup zzdup, String str) {
        this.zza = zzdup;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zzd(this.zzb, sharedPreferences, str);
    }
}
