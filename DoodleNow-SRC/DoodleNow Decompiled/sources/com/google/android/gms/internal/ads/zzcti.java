package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcti implements zzdae, zzczk {
    private final Context zza;
    private final zzcgm zzb;
    private final zzffn zzc;
    private final VersionInfoParcel zzd;
    private zzfmy zze;
    private boolean zzf;

    public zzcti(Context context, zzcgm zzcgm, zzffn zzffn, VersionInfoParcel versionInfoParcel) {
        this.zza = context;
        this.zzb = zzcgm;
        this.zzc = zzffn;
        this.zzd = versionInfoParcel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00a0, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zza() {
        /*
            r12 = this;
            monitor-enter(r12)
            com.google.android.gms.internal.ads.zzffn r0 = r12.zzc     // Catch:{ all -> 0x00a1 }
            boolean r0 = r0.zzU     // Catch:{ all -> 0x00a1 }
            if (r0 != 0) goto L_0x0009
            goto L_0x009f
        L_0x0009:
            com.google.android.gms.internal.ads.zzcgm r0 = r12.zzb     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x009f
            android.content.Context r0 = r12.zza     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzegc r1 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00a1 }
            boolean r0 = r1.zzj(r0)     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x009f
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r0 = r12.zzd     // Catch:{ all -> 0x00a1 }
            int r1 = r0.buddyApkVersion     // Catch:{ all -> 0x00a1 }
            int r0 = r0.clientJarVersion     // Catch:{ all -> 0x00a1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a1 }
            r2.<init>()     // Catch:{ all -> 0x00a1 }
            r2.append(r1)     // Catch:{ all -> 0x00a1 }
            java.lang.String r1 = "."
            r2.append(r1)     // Catch:{ all -> 0x00a1 }
            r2.append(r0)     // Catch:{ all -> 0x00a1 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzffn r0 = r12.zzc     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzfgl r0 = r0.zzW     // Catch:{ all -> 0x00a1 }
            java.lang.String r8 = r0.zza()     // Catch:{ all -> 0x00a1 }
            int r0 = r0.zzb()     // Catch:{ all -> 0x00a1 }
            r1 = 1
            if (r0 != r1) goto L_0x0049
            com.google.android.gms.internal.ads.zzegd r0 = com.google.android.gms.internal.ads.zzegd.VIDEO     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzege r2 = com.google.android.gms.internal.ads.zzege.DEFINED_BY_JAVASCRIPT     // Catch:{ all -> 0x00a1 }
            r10 = r0
            r9 = r2
            goto L_0x0058
        L_0x0049:
            com.google.android.gms.internal.ads.zzffn r0 = r12.zzc     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzegd r2 = com.google.android.gms.internal.ads.zzegd.HTML_DISPLAY     // Catch:{ all -> 0x00a1 }
            int r0 = r0.zzf     // Catch:{ all -> 0x00a1 }
            if (r0 != r1) goto L_0x0054
            com.google.android.gms.internal.ads.zzege r0 = com.google.android.gms.internal.ads.zzege.ONE_PIXEL     // Catch:{ all -> 0x00a1 }
            goto L_0x0056
        L_0x0054:
            com.google.android.gms.internal.ads.zzege r0 = com.google.android.gms.internal.ads.zzege.BEGIN_TO_RENDER     // Catch:{ all -> 0x00a1 }
        L_0x0056:
            r9 = r0
            r10 = r2
        L_0x0058:
            com.google.android.gms.internal.ads.zzcgm r0 = r12.zzb     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzffn r2 = r12.zzc     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzegc r3 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00a1 }
            android.webkit.WebView r5 = r0.zzG()     // Catch:{ all -> 0x00a1 }
            java.lang.String r11 = r2.zzam     // Catch:{ all -> 0x00a1 }
            java.lang.String r6 = ""
            java.lang.String r7 = "javascript"
            com.google.android.gms.internal.ads.zzfmy r0 = r3.zza(r4, r5, r6, r7, r8, r9, r10, r11)     // Catch:{ all -> 0x00a1 }
            r12.zze = r0     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzcgm r2 = r12.zzb     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x009f
            com.google.android.gms.internal.ads.zzegc r0 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzfmy r3 = r12.zze     // Catch:{ all -> 0x00a1 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x00a1 }
            r0.zzh(r3, r2)     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzcgm r0 = r12.zzb     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzfmy r2 = r12.zze     // Catch:{ all -> 0x00a1 }
            r0.zzaq(r2)     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzegc r0 = com.google.android.gms.ads.internal.zzu.zzA()     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzfmy r2 = r12.zze     // Catch:{ all -> 0x00a1 }
            r0.zzi(r2)     // Catch:{ all -> 0x00a1 }
            r12.zzf = r1     // Catch:{ all -> 0x00a1 }
            com.google.android.gms.internal.ads.zzcgm r0 = r12.zzb     // Catch:{ all -> 0x00a1 }
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x00a1 }
            r1.<init>()     // Catch:{ all -> 0x00a1 }
            java.lang.String r2 = "onSdkLoaded"
            r0.zzd(r2, r1)     // Catch:{ all -> 0x00a1 }
            monitor-exit(r12)
            return
        L_0x009f:
            monitor-exit(r12)
            return
        L_0x00a1:
            r0 = move-exception
            monitor-exit(r12)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcti.zza():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzr() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzf     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0008
            r3.zza()     // Catch:{ all -> 0x0024 }
        L_0x0008:
            com.google.android.gms.internal.ads.zzffn r0 = r3.zzc     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.zzU     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.internal.ads.zzfmy r0 = r3.zze     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            com.google.android.gms.internal.ads.zzcgm r0 = r3.zzb     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0022
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0024 }
            r1.<init>()     // Catch:{ all -> 0x0024 }
            java.lang.String r2 = "onSdkImpression"
            r0.zzd(r2, r1)     // Catch:{ all -> 0x0024 }
            monitor-exit(r3)
            return
        L_0x0022:
            monitor-exit(r3)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcti.zzr():void");
    }

    public final synchronized void zzs() {
        if (!this.zzf) {
            zza();
        }
    }
}
