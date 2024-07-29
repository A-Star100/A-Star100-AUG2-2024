package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbzj implements zzbzo {
    public static final /* synthetic */ int zzb = 0;
    /* access modifiers changed from: private */
    public static final List zzc = Collections.synchronizedList(new ArrayList());
    boolean zza;
    private final zzhet zzd;
    private final LinkedHashMap zze;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final Context zzh;
    private final zzbzl zzi;
    private final Object zzj = new Object();
    private HashSet zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;
    private final zzbzk zzn;

    public zzbzj(Context context, VersionInfoParcel versionInfoParcel, zzbzl zzbzl, String str, zzbzk zzbzk) {
        Preconditions.checkNotNull(zzbzl, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap();
        this.zzn = zzbzk;
        this.zzi = zzbzl;
        for (String lowerCase : zzbzl.zze) {
            this.zzk.add(lowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzhet zzc2 = zzhhn.zzc();
        zzc2.zzj(zzhgs.OCTAGON_AD);
        zzc2.zzk(str);
        zzc2.zzh(str);
        zzheu zzc3 = zzhev.zzc();
        String str2 = this.zzi.zza;
        if (str2 != null) {
            zzc3.zza(str2);
        }
        zzc2.zzg((zzhev) zzc3.zzbr());
        zzhgy zzc4 = zzhgz.zzc();
        zzc4.zzc(Wrappers.packageManager(this.zzh).isCallerInstantApp());
        String str3 = versionInfoParcel.afmaVersion;
        if (str3 != null) {
            zzc4.zza(str3);
        }
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzh);
        if (apkVersion > 0) {
            zzc4.zzb(apkVersion);
        }
        zzc2.zzf((zzhgz) zzc4.zzbr());
        this.zzd = zzc2;
    }

    public final zzbzl zza() {
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(Map map) throws Exception {
        ListenableFuture zzm2;
        zzhgw zzhgw;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.zzj) {
                            int length = optJSONArray.length();
                            synchronized (this.zzj) {
                                zzhgw = (zzhgw) this.zze.get(str);
                            }
                            if (zzhgw == null) {
                                zzbzn.zza("Cannot find the corresponding resource object for " + str);
                            } else {
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    zzhgw.zza(optJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                boolean z2 = this.zza;
                                if (length > 0) {
                                    z = true;
                                }
                                this.zza = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (((Boolean) zzbga.zzb.zze()).booleanValue()) {
                    zzm.zzf("Failed to get SafeBrowsing metadata", e);
                }
                return zzgee.zzg(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zza) {
            synchronized (this.zzj) {
                this.zzd.zzj(zzhgs.OCTAGON_AD_SB_MATCH);
            }
        }
        boolean z3 = this.zza;
        if ((!z3 || !this.zzi.zzg) && ((!this.zzm || !this.zzi.zzf) && (z3 || !this.zzi.zzd))) {
            return zzgee.zzh((Object) null);
        }
        synchronized (this.zzj) {
            for (zzhgw zzbn : this.zze.values()) {
                this.zzd.zzc((zzhgx) zzbn.zzbr());
            }
            this.zzd.zza(this.zzf);
            this.zzd.zzb(this.zzg);
            if (zzbzn.zzb()) {
                StringBuilder sb = new StringBuilder("Sending SB report\n  url: " + this.zzd.zzm() + "\n  clickUrl: " + this.zzd.zzl() + "\n  resources: \n");
                for (zzhgx zzhgx : this.zzd.zzn()) {
                    sb.append("    [");
                    sb.append(zzhgx.zzc());
                    sb.append("] ");
                    sb.append(zzhgx.zzg());
                }
                zzbzn.zza(sb.toString());
            }
            ListenableFuture zzb2 = new zzbq(this.zzh).zzb(1, this.zzi.zzb, (Map) null, ((zzhhn) this.zzd.zzbr()).zzaV());
            if (zzbzn.zzb()) {
                zzb2.addListener(zzbzg.zza, zzcbr.zza);
            }
            zzm2 = zzgee.zzm(zzb2, zzbzh.zza, zzcbr.zzf);
        }
        return zzm2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(java.lang.String r7, java.util.Map r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.zzj
            monitor-enter(r0)
            r1 = 3
            if (r9 != r1) goto L_0x0009
            r2 = 1
            r6.zzm = r2     // Catch:{ all -> 0x00b7 }
        L_0x0009:
            java.util.LinkedHashMap r2 = r6.zze     // Catch:{ all -> 0x00b7 }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x00b7 }
            if (r2 == 0) goto L_0x0024
            if (r9 != r1) goto L_0x0022
            com.google.android.gms.internal.ads.zzhgv r8 = com.google.android.gms.internal.ads.zzhgv.AD_RESOURCE_AUTO_CLICK_DESTINATION     // Catch:{ all -> 0x00b7 }
            if (r8 == 0) goto L_0x0022
            java.util.LinkedHashMap r9 = r6.zze     // Catch:{ all -> 0x00b7 }
            java.lang.Object r7 = r9.get(r7)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzhgw r7 = (com.google.android.gms.internal.ads.zzhgw) r7     // Catch:{ all -> 0x00b7 }
            r7.zzb(r8)     // Catch:{ all -> 0x00b7 }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x00b7 }
            return
        L_0x0024:
            com.google.android.gms.internal.ads.zzhgw r1 = com.google.android.gms.internal.ads.zzhgx.zze()     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzhgv r9 = com.google.android.gms.internal.ads.zzhgv.zzb(r9)     // Catch:{ all -> 0x00b7 }
            if (r9 == 0) goto L_0x0031
            r1.zzb(r9)     // Catch:{ all -> 0x00b7 }
        L_0x0031:
            java.util.LinkedHashMap r9 = r6.zze     // Catch:{ all -> 0x00b7 }
            int r9 = r9.size()     // Catch:{ all -> 0x00b7 }
            r1.zzc(r9)     // Catch:{ all -> 0x00b7 }
            r1.zze(r7)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzhfk r9 = com.google.android.gms.internal.ads.zzhfn.zzc()     // Catch:{ all -> 0x00b7 }
            java.util.HashSet r2 = r6.zzk     // Catch:{ all -> 0x00b7 }
            boolean r2 = r2.isEmpty()     // Catch:{ all -> 0x00b7 }
            if (r2 != 0) goto L_0x00a7
            if (r8 == 0) goto L_0x00a7
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x00b7 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00b7 }
        L_0x0053:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00b7 }
            if (r2 == 0) goto L_0x00a7
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00b7 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00b7 }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00b7 }
            if (r3 == 0) goto L_0x006c
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00b7 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00b7 }
            goto L_0x006e
        L_0x006c:
            java.lang.String r3 = ""
        L_0x006e:
            java.lang.Object r4 = r2.getValue()     // Catch:{ all -> 0x00b7 }
            if (r4 == 0) goto L_0x007b
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00b7 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00b7 }
            goto L_0x007d
        L_0x007b:
            java.lang.String r2 = ""
        L_0x007d:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00b7 }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ all -> 0x00b7 }
            java.util.HashSet r5 = r6.zzk     // Catch:{ all -> 0x00b7 }
            boolean r4 = r5.contains(r4)     // Catch:{ all -> 0x00b7 }
            if (r4 == 0) goto L_0x0053
            com.google.android.gms.internal.ads.zzhfi r4 = com.google.android.gms.internal.ads.zzhfj.zzc()     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzgyj r3 = com.google.android.gms.internal.ads.zzgyj.zzw(r3)     // Catch:{ all -> 0x00b7 }
            r4.zza(r3)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzgyj r2 = com.google.android.gms.internal.ads.zzgyj.zzw(r2)     // Catch:{ all -> 0x00b7 }
            r4.zzb(r2)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzgzv r2 = r4.zzbr()     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzhfj r2 = (com.google.android.gms.internal.ads.zzhfj) r2     // Catch:{ all -> 0x00b7 }
            r9.zza(r2)     // Catch:{ all -> 0x00b7 }
            goto L_0x0053
        L_0x00a7:
            com.google.android.gms.internal.ads.zzgzv r8 = r9.zzbr()     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzhfn r8 = (com.google.android.gms.internal.ads.zzhfn) r8     // Catch:{ all -> 0x00b7 }
            r1.zzd(r8)     // Catch:{ all -> 0x00b7 }
            java.util.LinkedHashMap r8 = r6.zze     // Catch:{ all -> 0x00b7 }
            r8.put(r7, r1)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b7 }
            return
        L_0x00b7:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b7 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzj.zzd(java.lang.String, java.util.Map, int):void");
    }

    public final void zze() {
        synchronized (this.zzj) {
            this.zze.keySet();
            ListenableFuture zzn2 = zzgee.zzn(zzgee.zzh(Collections.emptyMap()), new zzbze(this), zzcbr.zzf);
            ListenableFuture zzo = zzgee.zzo(zzn2, 10, TimeUnit.SECONDS, zzcbr.zzd);
            zzgee.zzr(zzn2, new zzbzi(this, zzo), zzcbr.zzf);
            zzc.add(zzo);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Bitmap bitmap) {
        zzgyg zzt = zzgyj.zzt();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzt);
        synchronized (this.zzj) {
            zzhet zzhet = this.zzd;
            zzhgl zzc2 = zzhgp.zzc();
            zzc2.zza(zzt.zzb());
            zzc2.zzb("image/png");
            zzc2.zzc(zzhgo.TYPE_CREATIVE);
            zzhet.zzi((zzhgp) zzc2.zzbr());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0036 A[SYNTHETIC, Splitter:B:18:0x0036] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0075  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(android.view.View r8) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzbzl r0 = r7.zzi
            boolean r0 = r0.zzc
            if (r0 != 0) goto L_0x0008
            goto L_0x0093
        L_0x0008:
            boolean r0 = r7.zzl
            if (r0 != 0) goto L_0x0093
            com.google.android.gms.ads.internal.zzu.zzp()
            r0 = 1
            r1 = 0
            if (r8 != 0) goto L_0x0014
            goto L_0x006d
        L_0x0014:
            boolean r2 = r8.isDrawingCacheEnabled()     // Catch:{ RuntimeException -> 0x002d }
            r8.setDrawingCacheEnabled(r0)     // Catch:{ RuntimeException -> 0x002d }
            android.graphics.Bitmap r3 = r8.getDrawingCache()     // Catch:{ RuntimeException -> 0x002d }
            if (r3 == 0) goto L_0x0026
            android.graphics.Bitmap r3 = android.graphics.Bitmap.createBitmap(r3)     // Catch:{ RuntimeException -> 0x002d }
            goto L_0x0027
        L_0x0026:
            r3 = r1
        L_0x0027:
            r8.setDrawingCacheEnabled(r2)     // Catch:{ RuntimeException -> 0x002b }
            goto L_0x0034
        L_0x002b:
            r2 = move-exception
            goto L_0x002f
        L_0x002d:
            r2 = move-exception
            r3 = r1
        L_0x002f:
            java.lang.String r4 = "Fail to capture the web view"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r4, r2)
        L_0x0034:
            if (r3 != 0) goto L_0x006c
            int r2 = r8.getWidth()     // Catch:{ RuntimeException -> 0x0065 }
            int r3 = r8.getHeight()     // Catch:{ RuntimeException -> 0x0065 }
            if (r2 == 0) goto L_0x005f
            if (r3 != 0) goto L_0x0043
            goto L_0x005f
        L_0x0043:
            int r4 = r8.getWidth()     // Catch:{ RuntimeException -> 0x0065 }
            int r5 = r8.getHeight()     // Catch:{ RuntimeException -> 0x0065 }
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.RGB_565     // Catch:{ RuntimeException -> 0x0065 }
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r4, r5, r6)     // Catch:{ RuntimeException -> 0x0065 }
            android.graphics.Canvas r5 = new android.graphics.Canvas     // Catch:{ RuntimeException -> 0x0065 }
            r5.<init>(r4)     // Catch:{ RuntimeException -> 0x0065 }
            r6 = 0
            r8.layout(r6, r6, r2, r3)     // Catch:{ RuntimeException -> 0x0065 }
            r8.draw(r5)     // Catch:{ RuntimeException -> 0x0065 }
            r1 = r4
            goto L_0x006d
        L_0x005f:
            java.lang.String r8 = "Width or height of view is zero"
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r8)     // Catch:{ RuntimeException -> 0x0065 }
            goto L_0x006d
        L_0x0065:
            r8 = move-exception
            java.lang.String r2 = "Fail to capture the webview"
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r8)
            goto L_0x006d
        L_0x006c:
            r1 = r3
        L_0x006d:
            if (r1 != 0) goto L_0x0075
            java.lang.String r8 = "Failed to capture the webview bitmap."
            com.google.android.gms.internal.ads.zzbzn.zza(r8)
            return
        L_0x0075:
            r7.zzl = r0
            com.google.android.gms.internal.ads.zzbzf r8 = new com.google.android.gms.internal.ads.zzbzf
            r8.<init>(r7, r1)
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            java.lang.Thread r0 = r0.getThread()
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            if (r0 == r1) goto L_0x008e
            r8.run()
            return
        L_0x008e:
            com.google.android.gms.internal.ads.zzgep r0 = com.google.android.gms.internal.ads.zzcbr.zza
            r0.execute(r8)
        L_0x0093:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbzj.zzg(android.view.View):void");
    }

    public final void zzh(String str) {
        synchronized (this.zzj) {
            if (str == null) {
                this.zzd.zzd();
            } else {
                this.zzd.zze(str);
            }
        }
    }

    public final boolean zzi() {
        return PlatformVersion.isAtLeastKitKat() && this.zzi.zzc && !this.zzl;
    }
}
