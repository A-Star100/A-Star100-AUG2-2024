package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.nonagon.signalgeneration.zzap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcwi implements zzdbl, zzdgz {
    private zzbwx zza;
    private final AtomicBoolean zzb = new AtomicBoolean();
    private final Context zzc;
    private final zzflk zzd;
    private final VersionInfoParcel zze;
    private boolean zzf = false;

    zzcwi(Context context, zzflk zzflk, VersionInfoParcel versionInfoParcel) {
        this.zzc = context;
        this.zzd = zzflk;
        this.zze = versionInfoParcel;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0066, code lost:
        if (android.text.TextUtils.equals(r0, androidx.core.app.NotificationCompat.CATEGORY_SERVICE) != false) goto L_0x0068;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0080  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc() {
        /*
            r5 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.zzb
            r1 = 1
            boolean r0 = r0.getAndSet(r1)
            if (r0 == 0) goto L_0x000b
            goto L_0x00a7
        L_0x000b:
            com.google.android.gms.internal.ads.zzbff r0 = com.google.android.gms.internal.ads.zzbft.zzk
            java.lang.Object r0 = r0.zze()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r2 = 2
            if (r0 == 0) goto L_0x001c
        L_0x001a:
            r3 = r2
            goto L_0x0068
        L_0x001c:
            com.google.android.gms.internal.ads.zzbff r0 = com.google.android.gms.internal.ads.zzbft.zzl
            java.lang.Object r0 = r0.zze()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r3 = 3
            if (r0 == 0) goto L_0x002c
            goto L_0x0068
        L_0x002c:
            com.google.android.gms.internal.ads.zzbff r0 = com.google.android.gms.internal.ads.zzbft.zzj
            java.lang.Object r0 = r0.zze()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x003c
        L_0x003a:
            r3 = r1
            goto L_0x0068
        L_0x003c:
            com.google.android.gms.internal.ads.zzcbh r0 = com.google.android.gms.ads.internal.zzu.zzo()
            com.google.android.gms.ads.internal.util.zzg r0 = r0.zzi()
            com.google.android.gms.internal.ads.zzcbb r0 = r0.zzg()
            java.lang.String r0 = r0.zzc()
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x003a }
            r4.<init>(r0)     // Catch:{ JSONException -> 0x003a }
            java.lang.String r0 = "local_flag_write"
            java.lang.String r0 = r4.optString(r0)     // Catch:{ JSONException -> 0x003a }
            java.lang.String r4 = "client"
            boolean r4 = android.text.TextUtils.equals(r0, r4)     // Catch:{ JSONException -> 0x003a }
            if (r4 == 0) goto L_0x0060
            goto L_0x001a
        L_0x0060:
            java.lang.String r4 = "service"
            boolean r0 = android.text.TextUtils.equals(r0, r4)     // Catch:{ JSONException -> 0x003a }
            if (r0 == 0) goto L_0x003a
        L_0x0068:
            int r3 = r3 + -1
            if (r3 == r1) goto L_0x0080
            if (r3 == r2) goto L_0x006f
            goto L_0x00a7
        L_0x006f:
            android.content.Context r0 = r5.zzc
            com.google.android.gms.internal.ads.zzflk r2 = r5.zzd
            com.google.android.gms.internal.ads.zzbph r3 = com.google.android.gms.ads.internal.zzu.zzf()
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = com.google.android.gms.ads.internal.util.client.VersionInfoParcel.forPackage()
            com.google.android.gms.internal.ads.zzbpq r0 = r3.zzb(r0, r4, r2)
            goto L_0x0090
        L_0x0080:
            android.content.Context r0 = r5.zzc
            com.google.android.gms.internal.ads.zzflk r2 = r5.zzd
            com.google.android.gms.internal.ads.zzbph r3 = com.google.android.gms.ads.internal.zzu.zzf()
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r4 = com.google.android.gms.ads.internal.util.client.VersionInfoParcel.forPackage()
            com.google.android.gms.internal.ads.zzbpq r0 = r3.zza(r0, r4, r2)
        L_0x0090:
            com.google.android.gms.internal.ads.zzbpk r2 = com.google.android.gms.internal.ads.zzbpn.zza
            com.google.android.gms.internal.ads.zzbpk r3 = com.google.android.gms.internal.ads.zzbpn.zza
            java.lang.String r4 = "google.afma.sdkConstants.getSdkConstants"
            com.google.android.gms.internal.ads.zzbpg r0 = r0.zza(r4, r2, r3)
            android.content.Context r2 = r5.zzc
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r3 = r5.zze
            com.google.android.gms.internal.ads.zzbwz r4 = new com.google.android.gms.internal.ads.zzbwz
            r4.<init>(r2, r0, r3)
            r5.zza = r4
            r5.zzf = r1
        L_0x00a7:
            boolean r0 = r5.zzf
            if (r0 != 0) goto L_0x00ac
            goto L_0x00b9
        L_0x00ac:
            com.google.android.gms.internal.ads.zzbwx r0 = r5.zza
            if (r0 == 0) goto L_0x00b9
            com.google.common.util.concurrent.ListenableFuture r0 = r0.zza()
            java.lang.String r1 = "persistFlagsClient"
            com.google.android.gms.internal.ads.zzcbu.zza(r0, r1)
        L_0x00b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcwi.zzc():void");
    }

    public final void zzd(zzap zzap) {
        zzc();
    }

    public final void zzdn(zzbxd zzbxd) {
        zzc();
    }

    public final void zzdo(zzffz zzffz) {
    }

    public final void zze(String str) {
        zzc();
    }
}
