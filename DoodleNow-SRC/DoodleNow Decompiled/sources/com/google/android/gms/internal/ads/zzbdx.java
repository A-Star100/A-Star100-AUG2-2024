package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ConditionVariable;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbdx implements SharedPreferences.OnSharedPreferenceChangeListener {
    volatile boolean zza = false;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private Context zzg;
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;

    private final void zzf(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.zzh = new JSONObject((String) zzbeb.zza(new zzbdu(sharedPreferences)));
            } catch (JSONException unused) {
            }
        }
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzf(sharedPreferences);
        }
    }

    public final Object zza(zzbdq zzbdq) {
        if (!this.zzc.block(5000)) {
            synchronized (this.zzb) {
                if (!this.zza) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.zzd || this.zze == null) {
            synchronized (this.zzb) {
                if (this.zzd) {
                    if (this.zze == null) {
                    }
                }
                Object zzm = zzbdq.zzm();
                return zzm;
            }
        }
        if (zzbdq.zze() == 2) {
            Bundle bundle = this.zzf;
            if (bundle == null) {
                return zzbdq.zzm();
            }
            return zzbdq.zzb(bundle);
        } else if (zzbdq.zze() != 1 || !this.zzh.has(zzbdq.zzn())) {
            return zzbeb.zza(new zzbdv(this, zzbdq));
        } else {
            return zzbdq.zza(this.zzh);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(zzbdq zzbdq) {
        return zzbdq.zzc(this.zze);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00a5, code lost:
        if (new org.json.JSONObject((java.lang.String) com.google.android.gms.internal.ads.zzbeb.zza(new com.google.android.gms.internal.ads.zzbdt(r3))).optBoolean("local_flags_enabled") != false) goto L_0x00a7;
     */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ab A[SYNTHETIC, Splitter:B:48:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00b4 A[SYNTHETIC, Splitter:B:52:0x00b4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(android.content.Context r6) {
        /*
            r5 = this;
            boolean r0 = r5.zzd
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.Object r0 = r5.zzb
            monitor-enter(r0)
            boolean r1 = r5.zzd     // Catch:{ all -> 0x00eb }
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)     // Catch:{ all -> 0x00eb }
            return
        L_0x000e:
            boolean r1 = r5.zza     // Catch:{ all -> 0x00eb }
            r2 = 1
            if (r1 != 0) goto L_0x0015
            r5.zza = r2     // Catch:{ all -> 0x00eb }
        L_0x0015:
            java.lang.String r1 = r6.getPackageName()     // Catch:{ all -> 0x00eb }
            java.lang.String r3 = "com.google.android.gms"
            boolean r1 = android.text.TextUtils.equals(r1, r3)     // Catch:{ all -> 0x00eb }
            r5.zzi = r1     // Catch:{ all -> 0x00eb }
            android.content.Context r1 = r6.getApplicationContext()     // Catch:{ all -> 0x00eb }
            if (r1 == 0) goto L_0x002b
            android.content.Context r6 = r6.getApplicationContext()     // Catch:{ all -> 0x00eb }
        L_0x002b:
            r5.zzg = r6     // Catch:{ all -> 0x00eb }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r6 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r6)     // Catch:{ NameNotFoundException | NullPointerException -> 0x0041 }
            android.content.Context r1 = r5.zzg     // Catch:{ NameNotFoundException | NullPointerException -> 0x0041 }
            java.lang.String r1 = r1.getPackageName()     // Catch:{ NameNotFoundException | NullPointerException -> 0x0041 }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r6 = r6.getApplicationInfo(r1, r3)     // Catch:{ NameNotFoundException | NullPointerException -> 0x0041 }
            android.os.Bundle r6 = r6.metaData     // Catch:{ NameNotFoundException | NullPointerException -> 0x0041 }
            r5.zzf = r6     // Catch:{ NameNotFoundException | NullPointerException -> 0x0041 }
        L_0x0041:
            r6 = 0
            android.content.Context r1 = r5.zzg     // Catch:{ all -> 0x00e2 }
            android.content.Context r3 = com.google.android.gms.common.GooglePlayServicesUtilLight.getRemoteContext(r1)     // Catch:{ all -> 0x00e2 }
            if (r3 != 0) goto L_0x0052
            if (r1 == 0) goto L_0x0052
            android.content.Context r3 = r1.getApplicationContext()     // Catch:{ all -> 0x00e2 }
            if (r3 == 0) goto L_0x0053
        L_0x0052:
            r1 = r3
        L_0x0053:
            if (r1 == 0) goto L_0x005d
            com.google.android.gms.ads.internal.client.zzba.zzb()     // Catch:{ all -> 0x00e2 }
            android.content.SharedPreferences r3 = com.google.android.gms.internal.ads.zzbds.zza(r1)     // Catch:{ all -> 0x00e2 }
            goto L_0x005e
        L_0x005d:
            r3 = 0
        L_0x005e:
            if (r3 == 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzbdw r4 = new com.google.android.gms.internal.ads.zzbdw     // Catch:{ all -> 0x00e2 }
            r4.<init>(r5, r3)     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzbgk.zzc(r4)     // Catch:{ all -> 0x00e2 }
        L_0x0068:
            android.content.Context r3 = r5.zzg     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzbff r4 = com.google.android.gms.internal.ads.zzbft.zzh     // Catch:{ all -> 0x00e2 }
            java.lang.Object r4 = r4.zze()     // Catch:{ all -> 0x00e2 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x00e2 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x00e2 }
            if (r4 == 0) goto L_0x0079
            goto L_0x00a7
        L_0x0079:
            com.google.android.gms.internal.ads.zzbff r4 = com.google.android.gms.internal.ads.zzbft.zzi     // Catch:{ all -> 0x00e2 }
            java.lang.Object r4 = r4.zze()     // Catch:{ all -> 0x00e2 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x00e2 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x00e2 }
            if (r4 == 0) goto L_0x00a9
            java.lang.String r4 = "admob"
            android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r6)     // Catch:{ all -> 0x00e2 }
            if (r3 == 0) goto L_0x00a9
            com.google.android.gms.internal.ads.zzbdt r4 = new com.google.android.gms.internal.ads.zzbdt     // Catch:{ all -> 0x00e2 }
            r4.<init>(r3)     // Catch:{ all -> 0x00e2 }
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzbeb.zza(r4)     // Catch:{ all -> 0x00e2 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00e2 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00a9 }
            r4.<init>(r3)     // Catch:{ JSONException -> 0x00a9 }
            java.lang.String r3 = "local_flags_enabled"
            boolean r3 = r4.optBoolean(r3)     // Catch:{ JSONException -> 0x00a9 }
            if (r3 == 0) goto L_0x00a9
        L_0x00a7:
            android.content.Context r1 = r5.zzg     // Catch:{ all -> 0x00e2 }
        L_0x00a9:
            if (r1 != 0) goto L_0x00b4
            r5.zza = r6     // Catch:{ all -> 0x00eb }
            android.os.ConditionVariable r6 = r5.zzc     // Catch:{ all -> 0x00eb }
            r6.open()     // Catch:{ all -> 0x00eb }
            monitor-exit(r0)     // Catch:{ all -> 0x00eb }
            return
        L_0x00b4:
            com.google.android.gms.ads.internal.client.zzba.zzb()     // Catch:{ all -> 0x00e2 }
            android.content.SharedPreferences r1 = com.google.android.gms.internal.ads.zzbds.zza(r1)     // Catch:{ all -> 0x00e2 }
            r5.zze = r1     // Catch:{ all -> 0x00e2 }
            com.google.android.gms.internal.ads.zzbff r1 = com.google.android.gms.internal.ads.zzbft.zza     // Catch:{ all -> 0x00e2 }
            java.lang.Object r1 = r1.zze()     // Catch:{ all -> 0x00e2 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x00e2 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00e2 }
            if (r1 != 0) goto L_0x00d2
            android.content.SharedPreferences r1 = r5.zze     // Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x00d2
            r1.registerOnSharedPreferenceChangeListener(r5)     // Catch:{ all -> 0x00e2 }
        L_0x00d2:
            android.content.SharedPreferences r1 = r5.zze     // Catch:{ all -> 0x00e2 }
            r5.zzf(r1)     // Catch:{ all -> 0x00e2 }
            r5.zzd = r2     // Catch:{ all -> 0x00e2 }
            r5.zza = r6     // Catch:{ all -> 0x00eb }
            android.os.ConditionVariable r6 = r5.zzc     // Catch:{ all -> 0x00eb }
            r6.open()     // Catch:{ all -> 0x00eb }
            monitor-exit(r0)     // Catch:{ all -> 0x00eb }
            return
        L_0x00e2:
            r1 = move-exception
            r5.zza = r6     // Catch:{ all -> 0x00eb }
            android.os.ConditionVariable r6 = r5.zzc     // Catch:{ all -> 0x00eb }
            r6.open()     // Catch:{ all -> 0x00eb }
            throw r1     // Catch:{ all -> 0x00eb }
        L_0x00eb:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00eb }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdx.zzd(android.content.Context):void");
    }

    /* access modifiers changed from: package-private */
    public final boolean zze() {
        return this.zzi;
    }

    public final Object zzb(zzbdq zzbdq) {
        if (this.zzd || this.zza) {
            return zza(zzbdq);
        }
        return zzbdq.zzm();
    }
}
