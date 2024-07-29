package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeqc implements zzewr {
    private final zzgep zza;
    private final zzdry zzb;
    private final zzdwk zzc;
    private final zzeqe zzd;

    public zzeqc(zzgep zzgep, zzdry zzdry, zzdwk zzdwk, zzeqe zzeqe) {
        this.zza = zzgep;
        this.zzb = zzdry;
        this.zzc = zzdwk;
        this.zzd = zzeqe;
    }

    public final int zza() {
        return 1;
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzlq)).booleanValue() || this.zzd.zza() == null) {
            if (!zzfxg.zzd((String) zzba.zzc().zza(zzbdz.zzbr))) {
                if (((Boolean) zzba.zzc().zza(zzbdz.zzlq)).booleanValue() || (!this.zzd.zzd() && this.zzc.zzt())) {
                    this.zzd.zzc(true);
                    return this.zza.zzb(new zzeqb(this));
                }
            }
            return zzgee.zzh(new zzeqd(new Bundle()));
        }
        zzeqd zza2 = this.zzd.zza();
        zza2.getClass();
        return zzgee.zzh(zza2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(12:4|5|6|(3:9|10|(1:12))|13|14|(1:16)|17|18|25|23|1) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:5|6|(3:9|10|(1:12))|13|14|(1:16)|17|18|25) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0067 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0076 */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x006d A[Catch:{ zzfgp -> 0x0076 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.ads.zzeqd zzc() throws java.lang.Exception {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzbr
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = ";"
            java.lang.String[] r0 = r0.split(r1)
            java.util.List r0 = java.util.Arrays.asList(r0)
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            java.util.Iterator r0 = r0.iterator()
        L_0x001f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x007a
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            com.google.android.gms.internal.ads.zzdry r3 = r8.zzb     // Catch:{ zzfgp -> 0x001f }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ zzfgp -> 0x001f }
            r4.<init>()     // Catch:{ zzfgp -> 0x001f }
            com.google.android.gms.internal.ads.zzfhg r3 = r3.zzc(r2, r4)     // Catch:{ zzfgp -> 0x001f }
            r3.zzC()     // Catch:{ zzfgp -> 0x001f }
            com.google.android.gms.internal.ads.zzdwk r4 = r8.zzc     // Catch:{ zzfgp -> 0x001f }
            boolean r4 = r4.zzt()     // Catch:{ zzfgp -> 0x001f }
            android.os.Bundle r5 = new android.os.Bundle     // Catch:{ zzfgp -> 0x001f }
            r5.<init>()     // Catch:{ zzfgp -> 0x001f }
            com.google.android.gms.internal.ads.zzbdq r6 = com.google.android.gms.internal.ads.zzbdz.zzlq     // Catch:{ zzfgp -> 0x001f }
            com.google.android.gms.internal.ads.zzbdx r7 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzfgp -> 0x001f }
            java.lang.Object r6 = r7.zza(r6)     // Catch:{ zzfgp -> 0x001f }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ zzfgp -> 0x001f }
            boolean r6 = r6.booleanValue()     // Catch:{ zzfgp -> 0x001f }
            if (r6 == 0) goto L_0x0058
            if (r4 == 0) goto L_0x0067
        L_0x0058:
            com.google.android.gms.internal.ads.zzbtc r4 = r3.zzf()     // Catch:{ zzfgp -> 0x0067 }
            if (r4 == 0) goto L_0x0067
            java.lang.String r6 = "sdk_version"
            java.lang.String r4 = r4.toString()     // Catch:{ zzfgp -> 0x0067 }
            r5.putString(r6, r4)     // Catch:{ zzfgp -> 0x0067 }
        L_0x0067:
            com.google.android.gms.internal.ads.zzbtc r3 = r3.zze()     // Catch:{ zzfgp -> 0x0076 }
            if (r3 == 0) goto L_0x0076
            java.lang.String r4 = "adapter_version"
            java.lang.String r3 = r3.toString()     // Catch:{ zzfgp -> 0x0076 }
            r5.putString(r4, r3)     // Catch:{ zzfgp -> 0x0076 }
        L_0x0076:
            r1.putBundle(r2, r5)     // Catch:{ zzfgp -> 0x001f }
            goto L_0x001f
        L_0x007a:
            com.google.android.gms.internal.ads.zzeqd r0 = new com.google.android.gms.internal.ads.zzeqd
            r0.<init>(r1)
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zzlq
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0096
            com.google.android.gms.internal.ads.zzeqe r1 = r8.zzd
            r1.zzb(r0)
        L_0x0096:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeqc.zzc():com.google.android.gms.internal.ads.zzeqd");
    }
}
