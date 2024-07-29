package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbzp implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Context zza;
    private final SharedPreferences zzb;
    private final zzg zzc;
    private final zzcad zzd;
    private String zze = "-1";
    private int zzf = -1;

    zzbzp(Context context, zzg zzg, zzcad zzcad) {
        this.zzb = PreferenceManager.getDefaultSharedPreferences(context);
        this.zzc = zzg;
        this.zza = context;
        this.zzd = zzcad;
    }

    private final void zzb(String str, int i) {
        Context context;
        boolean z = false;
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzaw)).booleanValue() ? str.isEmpty() || str.charAt(0) != '1' : i == 0 || str.isEmpty() || (str.charAt(0) != '1' && !str.equals("-1"))) {
            z = true;
        }
        this.zzc.zzF(z);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgm)).booleanValue() && z && (context = this.zza) != null) {
            context.deleteDatabase("OfflineUpload.db");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b A[Catch:{ all -> 0x008f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSharedPreferenceChanged(android.content.SharedPreferences r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "gad_has_consent_for_cookies"
            java.lang.String r1 = "-1"
            java.lang.String r2 = "IABTCF_PurposeConsents"
            java.lang.String r3 = "onSharedPreferenceChanged, key = "
            com.google.android.gms.internal.ads.zzbdq r4 = com.google.android.gms.internal.ads.zzbdz.zzay     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzbdx r5 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008f }
            java.lang.Object r4 = r5.zza(r4)     // Catch:{ all -> 0x008f }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x008f }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x008f }
            if (r4 == 0) goto L_0x002a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x008f }
            r9.<init>(r3)     // Catch:{ all -> 0x008f }
            r9.append(r10)     // Catch:{ all -> 0x008f }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x008f }
            com.google.android.gms.ads.internal.util.zze.zza(r9)     // Catch:{ all -> 0x008f }
            return
        L_0x002a:
            java.lang.String r3 = r9.getString(r2, r1)     // Catch:{ all -> 0x008f }
            r4 = -1
            int r9 = r9.getInt(r0, r4)     // Catch:{ all -> 0x008f }
            java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ all -> 0x008f }
            int r5 = r10.hashCode()     // Catch:{ all -> 0x008f }
            r6 = -2004976699(0xffffffff887e7bc5, float:-7.6580835E-34)
            r7 = 1
            if (r5 == r6) goto L_0x004f
            r2 = -527267622(0xffffffffe09288da, float:-8.447143E19)
            if (r5 == r2) goto L_0x0047
            goto L_0x0057
        L_0x0047:
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x0057
            r10 = r7
            goto L_0x0058
        L_0x004f:
            boolean r10 = r10.equals(r2)
            if (r10 == 0) goto L_0x0057
            r10 = 0
            goto L_0x0058
        L_0x0057:
            r10 = r4
        L_0x0058:
            if (r10 == 0) goto L_0x007b
            if (r10 == r7) goto L_0x005d
            goto L_0x008e
        L_0x005d:
            com.google.android.gms.internal.ads.zzbdq r10 = com.google.android.gms.internal.ads.zzbdz.zzaw     // Catch:{ all -> 0x008f }
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x008f }
            java.lang.Object r10 = r0.zza(r10)     // Catch:{ all -> 0x008f }
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x008f }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x008f }
            if (r10 == 0) goto L_0x008e
            if (r9 == r4) goto L_0x008e
            int r10 = r8.zzf     // Catch:{ all -> 0x008f }
            if (r10 == r9) goto L_0x008e
            r8.zzf = r9     // Catch:{ all -> 0x008f }
            r8.zzb(r3, r9)     // Catch:{ all -> 0x008f }
            return
        L_0x007b:
            boolean r10 = r3.equals(r1)     // Catch:{ all -> 0x008f }
            if (r10 != 0) goto L_0x008e
            java.lang.String r10 = r8.zze     // Catch:{ all -> 0x008f }
            boolean r10 = r10.equals(r3)     // Catch:{ all -> 0x008f }
            if (r10 != 0) goto L_0x008e
            r8.zze = r3     // Catch:{ all -> 0x008f }
            r8.zzb(r3, r9)     // Catch:{ all -> 0x008f }
        L_0x008e:
            return
        L_0x008f:
            r9 = move-exception
            java.lang.String r10 = "AdMobPlusIdlessListener.onSharedPreferenceChanged"
            com.google.android.gms.internal.ads.zzcbh r0 = com.google.android.gms.ads.internal.zzu.zzo()
            r0.zzw(r9, r10)
            java.lang.String r10 = "onSharedPreferenceChanged, errorMessage = "
            com.google.android.gms.ads.internal.util.zze.zzb(r10, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzp.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzb.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(this.zzb, "gad_has_consent_for_cookies");
        if (((Boolean) zzba.zzc().zza(zzbdz.zzay)).booleanValue()) {
            onSharedPreferenceChanged(this.zzb, "IABTCF_gdprApplies");
            onSharedPreferenceChanged(this.zzb, "IABTCF_TCString");
            return;
        }
        onSharedPreferenceChanged(this.zzb, "IABTCF_PurposeConsents");
    }
}
