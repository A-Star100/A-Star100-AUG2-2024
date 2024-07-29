package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcai {
    private final Map zza = new HashMap();
    /* access modifiers changed from: private */
    public final List zzb = new ArrayList();
    private final Context zzc;
    private final zzbzt zzd;

    zzcai(Context context, zzbzt zzbzt) {
        this.zzc = context;
        this.zzd = zzbzt;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (map.containsKey(str) && ((Set) map.get(str)).contains(str2)) {
            this.zzd.zzd();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzc(String str) {
        SharedPreferences sharedPreferences;
        if (!this.zza.containsKey(str)) {
            if (Objects.equals(str, "__default__")) {
                sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.zzc);
            } else {
                sharedPreferences = this.zzc.getSharedPreferences(str, 0);
            }
            zzcah zzcah = new zzcah(this, str);
            this.zza.put(str, zzcah);
            sharedPreferences.registerOnSharedPreferenceChangeListener(zzcah);
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzd(zzcag zzcag) {
        this.zzb.add(zzcag);
    }
}
