package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcah implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzcai zza;
    private final String zzb;

    public zzcah(zzcai zzcai, String str) {
        this.zza = zzcai;
        this.zzb = str;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            for (zzcag zzcag : this.zza.zzb) {
                zzcag.zza.zzb(zzcag.zzb, sharedPreferences, this.zzb, str);
            }
        }
    }
}
