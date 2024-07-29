package com.google.android.gms.ads.nonagon.signalgeneration;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.browser.customtabs.CustomTabsCallback;
import androidx.browser.customtabs.CustomTabsClient;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzawo;
import com.google.android.gms.internal.ads.zzawp;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbve;
import com.google.android.gms.internal.ads.zzbvn;
import com.google.android.gms.internal.ads.zzcam;
import com.google.android.gms.internal.ads.zzcao;
import com.google.android.gms.internal.ads.zzcat;
import com.google.android.gms.internal.ads.zzcbr;
import com.google.android.gms.internal.ads.zzcik;
import com.google.android.gms.internal.ads.zzdpx;
import com.google.android.gms.internal.ads.zzdtq;
import com.google.android.gms.internal.ads.zzdum;
import com.google.android.gms.internal.ads.zzfgm;
import com.google.android.gms.internal.ads.zzfhh;
import com.google.android.gms.internal.ads.zzfkv;
import com.google.android.gms.internal.ads.zzfkw;
import com.google.android.gms.internal.ads.zzflh;
import com.google.android.gms.internal.ads.zzflk;
import com.google.android.gms.internal.ads.zzflo;
import com.google.android.gms.internal.ads.zzfmt;
import com.google.android.gms.internal.ads.zzfxg;
import com.google.android.gms.internal.ads.zzgdv;
import com.google.android.gms.internal.ads.zzgee;
import com.google.android.gms.internal.ads.zzgep;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzab extends zzcao {
    protected static final List zza = new ArrayList(Arrays.asList(new String[]{"/aclk", "/pcs/click", "/dbm/clk"}));
    protected static final List zzb = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com"}));
    protected static final List zzc = new ArrayList(Arrays.asList(new String[]{"/pagead/adview", "/pcs/view", "/pagead/conversion", "/dbm/ad"}));
    protected static final List zzd = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"}));
    public static final /* synthetic */ int zze = 0;
    /* access modifiers changed from: private */
    public String zzA;
    /* access modifiers changed from: private */
    public final String zzB;
    private final List zzC;
    private final List zzD;
    private final List zzE;
    private final List zzF;
    private final AtomicBoolean zzG = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicBoolean zzH = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final AtomicInteger zzI = new AtomicInteger(0);
    private final zzbfa zzJ;
    private final zzcik zzf;
    /* access modifiers changed from: private */
    public Context zzg;
    private final zzawo zzh;
    private final zzfgm zzi;
    private final zzfhh zzj;
    private final zzgep zzk;
    private final ScheduledExecutorService zzl;
    private zzbvn zzm;
    private Point zzn = new Point();
    private Point zzo = new Point();
    private final Set zzp = Collections.newSetFromMap(new WeakHashMap());
    /* access modifiers changed from: private */
    public final zzdum zzq;
    /* access modifiers changed from: private */
    public final zzfmt zzr;
    /* access modifiers changed from: private */
    public final boolean zzs;
    /* access modifiers changed from: private */
    public final boolean zzt;
    /* access modifiers changed from: private */
    public final boolean zzu;
    /* access modifiers changed from: private */
    public final boolean zzv;
    /* access modifiers changed from: private */
    public final String zzw;
    /* access modifiers changed from: private */
    public final String zzx;
    /* access modifiers changed from: private */
    public final AtomicInteger zzy = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final VersionInfoParcel zzz;

    public zzab(zzcik zzcik, Context context, zzawo zzawo, zzfhh zzfhh, zzgep zzgep, ScheduledExecutorService scheduledExecutorService, zzdum zzdum, zzfmt zzfmt, VersionInfoParcel versionInfoParcel, zzbfa zzbfa, zzfgm zzfgm) {
        List list;
        this.zzf = zzcik;
        this.zzg = context;
        this.zzh = zzawo;
        this.zzi = zzfgm;
        this.zzj = zzfhh;
        this.zzk = zzgep;
        this.zzl = scheduledExecutorService;
        this.zzq = zzdum;
        this.zzr = zzfmt;
        this.zzz = versionInfoParcel;
        this.zzJ = zzbfa;
        this.zzs = ((Boolean) zzba.zzc().zza(zzbdz.zzho)).booleanValue();
        this.zzt = ((Boolean) zzba.zzc().zza(zzbdz.zzhn)).booleanValue();
        this.zzu = ((Boolean) zzba.zzc().zza(zzbdz.zzhq)).booleanValue();
        this.zzv = ((Boolean) zzba.zzc().zza(zzbdz.zzhs)).booleanValue();
        this.zzw = (String) zzba.zzc().zza(zzbdz.zzhr);
        this.zzx = (String) zzba.zzc().zza(zzbdz.zzht);
        this.zzB = (String) zzba.zzc().zza(zzbdz.zzhu);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzhv)).booleanValue()) {
            this.zzC = zzaa((String) zzba.zzc().zza(zzbdz.zzhw));
            this.zzD = zzaa((String) zzba.zzc().zza(zzbdz.zzhx));
            this.zzE = zzaa((String) zzba.zzc().zza(zzbdz.zzhy));
            list = zzaa((String) zzba.zzc().zza(zzbdz.zzhz));
        } else {
            this.zzC = zza;
            this.zzD = zzb;
            this.zzE = zzc;
            list = zzd;
        }
        this.zzF = list;
    }

    static /* bridge */ /* synthetic */ void zzH(zzab zzab, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (zzab.zzO((Uri) it.next())) {
                zzab.zzy.getAndIncrement();
                return;
            }
        }
    }

    static final /* synthetic */ Uri zzQ(Uri uri, String str) {
        return !TextUtils.isEmpty(str) ? zzZ(uri, "nas", str) : uri;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.ads.nonagon.signalgeneration.zzj zzR(android.content.Context r8, java.lang.String r9, java.lang.String r10, com.google.android.gms.ads.internal.client.zzq r11, com.google.android.gms.ads.internal.client.zzl r12, android.os.Bundle r13) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzfgg r0 = new com.google.android.gms.internal.ads.zzfgg
            r0.<init>()
            java.lang.String r1 = "REWARDED"
            boolean r2 = r1.equals(r10)
            java.lang.String r3 = "REWARDED_INTERSTITIAL"
            r4 = 3
            r5 = 2
            if (r2 == 0) goto L_0x0019
            com.google.android.gms.internal.ads.zzfft r2 = r0.zzp()
            r2.zza(r5)
            goto L_0x0026
        L_0x0019:
            boolean r2 = r3.equals(r10)
            if (r2 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzfft r2 = r0.zzp()
            r2.zza(r4)
        L_0x0026:
            com.google.android.gms.internal.ads.zzcik r2 = r7.zzf
            com.google.android.gms.ads.nonagon.signalgeneration.zzi r2 = r2.zzp()
            com.google.android.gms.internal.ads.zzcxy r6 = new com.google.android.gms.internal.ads.zzcxy
            r6.<init>()
            r6.zze(r8)
            if (r9 != 0) goto L_0x0038
            java.lang.String r9 = "adUnitId"
        L_0x0038:
            r0.zzt(r9)
            if (r12 != 0) goto L_0x0046
            com.google.android.gms.ads.internal.client.zzm r9 = new com.google.android.gms.ads.internal.client.zzm
            r9.<init>()
            com.google.android.gms.ads.internal.client.zzl r12 = r9.zza()
        L_0x0046:
            r0.zzG(r12)
            r9 = 1
            if (r11 != 0) goto L_0x00aa
            int r11 = r10.hashCode()
            r12 = 4
            switch(r11) {
                case -1999289321: goto L_0x0079;
                case -428325382: goto L_0x006f;
                case 543046670: goto L_0x0067;
                case 1854800829: goto L_0x005f;
                case 1951953708: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x0083
        L_0x0055:
            java.lang.String r11 = "BANNER"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0083
            r11 = 0
            goto L_0x0084
        L_0x005f:
            boolean r11 = r10.equals(r3)
            if (r11 == 0) goto L_0x0083
            r11 = r5
            goto L_0x0084
        L_0x0067:
            boolean r11 = r10.equals(r1)
            if (r11 == 0) goto L_0x0083
            r11 = r9
            goto L_0x0084
        L_0x006f:
            java.lang.String r11 = "APP_OPEN_AD"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0083
            r11 = r12
            goto L_0x0084
        L_0x0079:
            java.lang.String r11 = "NATIVE"
            boolean r11 = r10.equals(r11)
            if (r11 == 0) goto L_0x0083
            r11 = r4
            goto L_0x0084
        L_0x0083:
            r11 = -1
        L_0x0084:
            if (r11 == 0) goto L_0x00a3
            if (r11 == r9) goto L_0x009e
            if (r11 == r5) goto L_0x009e
            if (r11 == r4) goto L_0x0099
            if (r11 == r12) goto L_0x0094
            com.google.android.gms.ads.internal.client.zzq r11 = new com.google.android.gms.ads.internal.client.zzq
            r11.<init>()
            goto L_0x00aa
        L_0x0094:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzb()
            goto L_0x00aa
        L_0x0099:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzc()
            goto L_0x00aa
        L_0x009e:
            com.google.android.gms.ads.internal.client.zzq r11 = com.google.android.gms.ads.internal.client.zzq.zzd()
            goto L_0x00aa
        L_0x00a3:
            com.google.android.gms.ads.internal.client.zzq r11 = new com.google.android.gms.ads.internal.client.zzq
            com.google.android.gms.ads.AdSize r12 = com.google.android.gms.ads.AdSize.BANNER
            r11.<init>((android.content.Context) r8, (com.google.android.gms.ads.AdSize) r12)
        L_0x00aa:
            r0.zzs(r11)
            r0.zzy(r9)
            r0.zzz(r13)
            com.google.android.gms.internal.ads.zzfgi r8 = r0.zzI()
            r6.zzi(r8)
            com.google.android.gms.internal.ads.zzcya r8 = r6.zzj()
            r2.zza(r8)
            com.google.android.gms.ads.nonagon.signalgeneration.zzae r8 = new com.google.android.gms.ads.nonagon.signalgeneration.zzae
            r8.<init>()
            r8.zza(r10)
            com.google.android.gms.ads.nonagon.signalgeneration.zzag r9 = new com.google.android.gms.ads.nonagon.signalgeneration.zzag
            r10 = 0
            r9.<init>(r8, r10)
            r2.zzb(r9)
            com.google.android.gms.internal.ads.zzdef r8 = new com.google.android.gms.internal.ads.zzdef
            r8.<init>()
            com.google.android.gms.ads.nonagon.signalgeneration.zzj r8 = r2.zzc()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzab.zzR(android.content.Context, java.lang.String, java.lang.String, com.google.android.gms.ads.internal.client.zzq, com.google.android.gms.ads.internal.client.zzl, android.os.Bundle):com.google.android.gms.ads.nonagon.signalgeneration.zzj");
    }

    private final ListenableFuture zzS(String str) {
        zzdpx[] zzdpxArr = new zzdpx[1];
        ListenableFuture zzn2 = zzgee.zzn(this.zzj.zza(), new zzm(this, zzdpxArr, str), this.zzk);
        zzn2.addListener(new zzn(this, zzdpxArr), this.zzk);
        return zzgee.zze(zzgee.zzm((zzgdv) zzgee.zzo(zzgdv.zzu(zzn2), (long) ((Integer) zzba.zzc().zza(zzbdz.zzhF)).intValue(), TimeUnit.MILLISECONDS, this.zzl), zzt.zza, this.zzk), Exception.class, zzu.zza, this.zzk);
    }

    /* access modifiers changed from: private */
    public final void zzT() {
        ListenableFuture listenableFuture;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkK)).booleanValue()) {
            listenableFuture = zzgee.zzk(new zzk(this), zzcbr.zza);
        } else {
            listenableFuture = zzR(this.zzg, (String) null, AdFormat.BANNER.name(), (zzq) null, (zzl) null, new Bundle()).zzb();
        }
        zzgee.zzr(listenableFuture, new zzaa(this), this.zzf.zzB());
    }

    private final void zzU() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzjv)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzjy)).booleanValue()) {
                if (!((Boolean) zzba.zzc().zza(zzbdz.zzjC)).booleanValue() || !this.zzG.getAndSet(true)) {
                    zzT();
                }
            }
        }
    }

    private final void zzV(List list, IObjectWrapper iObjectWrapper, zzbve zzbve, boolean z) {
        ListenableFuture listenableFuture;
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzhE)).booleanValue()) {
            zzm.zzj("The updating URL feature is not enabled.");
            try {
                zzbve.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzm.zzh("", e);
            }
        } else {
            Iterator it = list.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (zzO((Uri) it.next())) {
                    i++;
                }
            }
            if (i > 1) {
                zzm.zzj("Multiple google urls found: ".concat(String.valueOf(String.valueOf(list))));
            }
            ArrayList arrayList = new ArrayList();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Uri uri = (Uri) it2.next();
                if (!zzO(uri)) {
                    zzm.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                    listenableFuture = zzgee.zzh(uri);
                } else {
                    listenableFuture = this.zzk.zzb(new zzo(this, uri, iObjectWrapper));
                    if (zzY()) {
                        listenableFuture = zzgee.zzn(listenableFuture, new zzp(this), this.zzk);
                    } else {
                        zzm.zzi("Asset view map is empty.");
                    }
                }
                arrayList.add(listenableFuture);
            }
            zzgee.zzr(zzgee.zzd(arrayList), new zzz(this, zzbve, z), this.zzf.zzB());
        }
    }

    private final void zzW(List list, IObjectWrapper iObjectWrapper, zzbve zzbve, boolean z) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzhE)).booleanValue()) {
            try {
                zzbve.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e) {
                zzm.zzh("", e);
            }
        } else {
            ListenableFuture zzb2 = this.zzk.zzb(new zzv(this, list, iObjectWrapper));
            if (zzY()) {
                zzb2 = zzgee.zzn(zzb2, new zzw(this), this.zzk);
            } else {
                zzm.zzi("Asset view map is empty.");
            }
            zzgee.zzr(zzb2, new zzy(this, zzbve, z), this.zzf.zzB());
        }
    }

    private static boolean zzX(Uri uri, List list, List list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (path.contains((String) it.next())) {
                    Iterator it2 = list2.iterator();
                    while (it2.hasNext()) {
                        if (host.endsWith((String) it2.next())) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzY() {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzbvn r0 = r1.zzm
            if (r0 == 0) goto L_0x0010
            java.util.Map r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzab.zzY():boolean");
    }

    /* access modifiers changed from: private */
    public static final Uri zzZ(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i = indexOf + 1;
        return Uri.parse(uri2.substring(0, i) + str + f.b + str2 + "&" + uri2.substring(i));
    }

    private static final List zzaa(String str) {
        String[] split = TextUtils.split(str, f.a);
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (!zzfxg.zzd(str2)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    static /* bridge */ /* synthetic */ zzflh zzr(ListenableFuture listenableFuture, zzcat zzcat) {
        String str;
        if (!zzflk.zza() || !((Boolean) zzbfm.zze.zze()).booleanValue()) {
            return null;
        }
        try {
            zzflh zza2 = ((zzj) zzgee.zzp(listenableFuture)).zza();
            zza2.zze(new ArrayList(Collections.singletonList(zzcat.zzb)));
            zzl zzl2 = zzcat.zzd;
            if (zzl2 == null) {
                str = "";
            } else {
                str = zzl2.zzp;
            }
            zza2.zzb(str);
            return zza2;
        } catch (ExecutionException e) {
            zzu.zzo().zzw(e, "SignalGeneratorImpl.getConfiguredCriticalUserJourney");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzB(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzP(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzZ(uri, "nas", str));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzC(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String zzh2 = this.zzh.zzc() != null ? this.zzh.zzc().zzh(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null) : "";
        if (!TextUtils.isEmpty(zzh2)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzP(uri)) {
                    zzm.zzj("Not a Google URL: ".concat(String.valueOf(String.valueOf(uri))));
                    arrayList.add(uri);
                } else {
                    arrayList.add(zzZ(uri, "ms", zzh2));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzJ(zzdpx[] zzdpxArr) {
        zzdpx zzdpx = zzdpxArr[0];
        if (zzdpx != null) {
            this.zzj.zzb(zzgee.zzh(zzdpx));
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzO(Uri uri) {
        return zzX(uri, this.zzC, this.zzD);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzP(Uri uri) {
        return zzX(uri, this.zzE, this.zzF);
    }

    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzjF)).booleanValue()) {
            return ObjectWrapper.wrap(null);
        }
        this.zzJ.zzg((Context) ObjectWrapper.unwrap(iObjectWrapper), (CustomTabsClient) ObjectWrapper.unwrap(iObjectWrapper2), str, (CustomTabsCallback) ObjectWrapper.unwrap(iObjectWrapper3));
        return ObjectWrapper.wrap(this.zzJ.zzb());
    }

    public final void zzf(IObjectWrapper iObjectWrapper, zzcat zzcat, zzcam zzcam) {
        ListenableFuture listenableFuture;
        ListenableFuture listenableFuture2;
        ListenableFuture listenableFuture3;
        ListenableFuture listenableFuture4;
        Bundle bundle = new Bundle();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcc)).booleanValue()) {
            bundle.putLong(zzdtq.PUBLIC_API_CALL.zza(), zzcat.zzd.zzz);
            bundle.putLong(zzdtq.DYNAMITE_ENTER.zza(), zzu.zzB().currentTimeMillis());
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzg = context;
        zzfkw zza2 = zzfkv.zza(context, zzflo.CUI_NAME_SCAR_SIGNALS);
        zza2.zzi();
        if ("UNKNOWN".equals(zzcat.zzb)) {
            List arrayList = new ArrayList();
            if (!((String) zzba.zzc().zza(zzbdz.zzhD)).isEmpty()) {
                arrayList = Arrays.asList(((String) zzba.zzc().zza(zzbdz.zzhD)).split(f.a));
            }
            if (arrayList.contains(zzh.zzb(zzcat.zzd))) {
                listenableFuture4 = zzgee.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                listenableFuture3 = zzgee.zzg(new IllegalArgumentException("Unknown format is no longer supported."));
                listenableFuture2 = listenableFuture4;
                listenableFuture = listenableFuture3;
                zzgee.zzr(listenableFuture, new zzx(this, listenableFuture2, zzcat, zzcam, zza2), this.zzf.zzB());
            }
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkK)).booleanValue()) {
            listenableFuture4 = zzcbr.zza.zzb(new zzr(this, zzcat, bundle));
            listenableFuture3 = zzgee.zzn(listenableFuture4, zzs.zza, zzcbr.zza);
            listenableFuture2 = listenableFuture4;
            listenableFuture = listenableFuture3;
            zzgee.zzr(listenableFuture, new zzx(this, listenableFuture2, zzcat, zzcam, zza2), this.zzf.zzB());
        }
        zzj zzR = zzR(this.zzg, zzcat.zza, zzcat.zzb, zzcat.zzc, zzcat.zzd, bundle);
        ListenableFuture zzh2 = zzgee.zzh(zzR);
        listenableFuture = zzR.zzb();
        listenableFuture2 = zzh2;
        zzgee.zzr(listenableFuture, new zzx(this, listenableFuture2, zzcat, zzcam, zza2), this.zzf.zzB());
    }

    public final void zzg(zzbvn zzbvn) {
        this.zzm = zzbvn;
        this.zzj.zzc(1);
    }

    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbve zzbve) {
        zzV(list, iObjectWrapper, zzbve, true);
    }

    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbve zzbve) {
        zzW(list, iObjectWrapper, zzbve, true);
    }

    public final void zzj(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzju)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzhC)).booleanValue()) {
                zzU();
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                zzm.zzg("The webView cannot be null.");
            } else if (this.zzp.contains(webView)) {
                zzm.zzi("This webview has already been registered.");
            } else {
                this.zzp.add(webView);
                webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh, this.zzq, this.zzr, this.zzi), "gmaSdk");
                if (((Boolean) zzba.zzc().zza(zzbdz.zzjE)).booleanValue()) {
                    zzu.zzo().zzs();
                }
                if (((Boolean) zzba.zzc().zza(zzbdz.zzhC)).booleanValue()) {
                    zzU();
                }
            }
        }
    }

    public final void zzk(IObjectWrapper iObjectWrapper) {
        View view;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzhE)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzbvn zzbvn = this.zzm;
            if (zzbvn == null) {
                view = null;
            } else {
                view = zzbvn.zza;
            }
            this.zzn = zzbz.zza(motionEvent, view);
            if (motionEvent.getAction() == 0) {
                this.zzo = this.zzn;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setLocation((float) this.zzn.x, (float) this.zzn.y);
            this.zzh.zzd(obtain);
            obtain.recycle();
        }
    }

    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbve zzbve) {
        zzV(list, iObjectWrapper, zzbve, false);
    }

    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbve zzbve) {
        zzW(list, iObjectWrapper, zzbve, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Uri zzn(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        zzfgm zzfgm;
        try {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzlF)).booleanValue() || (zzfgm = this.zzi) == null) {
                uri = this.zzh.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
            } else {
                uri = zzfgm.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
            }
        } catch (zzawp e) {
            zzm.zzk("", e);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzj zzq(zzcat zzcat, Bundle bundle) throws Exception {
        return zzR(this.zzg, zzcat.zza, zzcat.zzb, zzcat.zzc, zzcat.zzd, bundle);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzu() throws Exception {
        return zzR(this.zzg, (String) null, AdFormat.BANNER.name(), (zzq) null, (zzl) null, new Bundle()).zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzv(zzdpx[] zzdpxArr, String str, zzdpx zzdpx) throws Exception {
        zzdpxArr[0] = zzdpx;
        Context context = this.zzg;
        zzbvn zzbvn = this.zzm;
        Map map = zzbvn.zzb;
        JSONObject zzd2 = zzbz.zzd(context, map, map, zzbvn.zza, (ImageView.ScaleType) null);
        JSONObject zzg2 = zzbz.zzg(this.zzg, this.zzm.zza);
        JSONObject zzf2 = zzbz.zzf(this.zzm.zza);
        JSONObject zze2 = zzbz.zze(this.zzg, this.zzm.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", zzd2);
        jSONObject.put("ad_view_signal", zzg2);
        jSONObject.put("scroll_view_signal", zzf2);
        jSONObject.put("lock_screen_signal", zze2);
        if ("google.afma.nativeAds.getPublisherCustomRenderedClickSignals".equals(str)) {
            jSONObject.put("click_signal", zzbz.zzc((String) null, this.zzg, this.zzo, this.zzn));
        }
        return zzdpx.zzg(str, jSONObject);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzw(ArrayList arrayList) throws Exception {
        return zzgee.zzm(zzS("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzl(this, arrayList), this.zzk);
    }
}
