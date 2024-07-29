package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzetd implements zzewr {
    private final Context zza;
    private final zzgep zzb;

    zzetd(Context context, zzgep zzgep) {
        this.zza = context;
        this.zzb = zzgep;
    }

    public final int zza() {
        return 18;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzeta(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzetc zzc() throws Exception {
        String str;
        Bundle bundle;
        zzu.zzp();
        String str2 = "";
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzgf)).booleanValue()) {
            str = str2;
        } else {
            str = this.zza.getSharedPreferences("mobileads_consent", 0).getString("consent_string", str2);
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgh)).booleanValue()) {
            str2 = this.zza.getSharedPreferences("mobileads_consent", 0).getString("fc_consent", str2);
        }
        zzu.zzp();
        Context context = this.zza;
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzgg)).booleanValue()) {
            bundle = null;
        } else {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            bundle = new Bundle();
            if (defaultSharedPreferences.contains("IABConsent_CMPPresent")) {
                bundle.putBoolean("IABConsent_CMPPresent", defaultSharedPreferences.getBoolean("IABConsent_CMPPresent", false));
            }
            String[] strArr = {"IABConsent_SubjectToGDPR", "IABConsent_ConsentString", "IABConsent_ParsedPurposeConsents", "IABConsent_ParsedVendorConsents"};
            for (int i = 0; i < 4; i++) {
                String str3 = strArr[i];
                if (defaultSharedPreferences.contains(str3)) {
                    bundle.putString(str3, defaultSharedPreferences.getString(str3, (String) null));
                }
            }
        }
        return new zzetc(str, str2, bundle, (zzetb) null);
    }
}
