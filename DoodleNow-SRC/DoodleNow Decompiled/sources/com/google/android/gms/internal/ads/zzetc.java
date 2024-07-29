package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzetc implements zzewq {
    private final String zza;
    private final String zzb;
    private final Bundle zzc;

    /* synthetic */ zzetc(String str, String str2, Bundle bundle, zzetb zzetb) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = bundle;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("consent_string", this.zza);
        bundle.putString("fc_consent", this.zzb);
        bundle.putBundle("iab_consent_info", this.zzc);
    }
}
