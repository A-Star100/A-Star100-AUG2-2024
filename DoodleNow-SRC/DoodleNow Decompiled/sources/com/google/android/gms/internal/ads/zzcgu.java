package com.google.android.gms.internal.ads;

import android.net.TrafficStats;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import com.amazon.a.a.o.b.f;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzaa;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.zzl;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.Predicate;
import com.google.android.material.chip.Chip$$ExternalSyntheticApiModelOutline0;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import okhttp3.internal.ws.WebSocketProtocol;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzcgu extends WebViewClient implements zzcic {
    public static final /* synthetic */ int zzb = 0;
    private boolean zzA;
    private int zzB;
    private boolean zzC;
    private final HashSet zzD;
    private final zzefo zzE;
    private View.OnAttachStateChangeListener zzF;
    protected zzbzo zza;
    private final zzcgm zzc;
    private final zzbcx zzd;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private zza zzg;
    private zzp zzh;
    private zzcia zzi;
    private zzcib zzj;
    private zzbjo zzk;
    private zzbjq zzl;
    private zzdgn zzm;
    private boolean zzn;
    private boolean zzo;
    private int zzp = 0;
    private String zzq = "";
    private String zzr = "";
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private zzaa zzv;
    private zzbtr zzw;
    private zzb zzx;
    private zzbtm zzy;
    private boolean zzz;

    public zzcgu(zzcgm zzcgm, zzbcx zzbcx, boolean z, zzbtr zzbtr, zzbtm zzbtm, zzefo zzefo) {
        this.zzd = zzbcx;
        this.zzc = zzcgm;
        this.zzs = z;
        this.zzw = zzbtr;
        this.zzy = null;
        this.zzD = new HashSet(Arrays.asList(((String) zzba.zzc().zza(zzbdz.zzfG)).split(f.a)));
        this.zzE = zzefo;
    }

    private static WebResourceResponse zzS() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzaJ)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzT(String str, Map map) throws IOException {
        HttpURLConnection httpURLConnection;
        WebResourceResponse webResourceResponse;
        String str2;
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i = 0;
            while (true) {
                i++;
                if (i <= 20) {
                    URLConnection openConnection = url.openConnection();
                    openConnection.setConnectTimeout(10000);
                    openConnection.setReadTimeout(10000);
                    for (Map.Entry entry : map.entrySet()) {
                        openConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    if (openConnection instanceof HttpURLConnection) {
                        httpURLConnection = (HttpURLConnection) openConnection;
                        zzu.zzp().zzf(this.zzc.getContext(), this.zzc.zzn().afmaVersion, false, httpURLConnection, false, 60000);
                        webResourceResponse = null;
                        zzl zzl2 = new zzl((String) null);
                        zzl2.zzc(httpURLConnection, (byte[]) null);
                        int responseCode = httpURLConnection.getResponseCode();
                        zzl2.zze(httpURLConnection, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            zzu.zzp();
                            zzu.zzp();
                            String contentType = httpURLConnection.getContentType();
                        } else {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (headerField != null) {
                                if (!headerField.startsWith("tel:")) {
                                    URL url2 = new URL(url, headerField);
                                    String protocol = url2.getProtocol();
                                    if (protocol != null) {
                                        if (!protocol.equals("http") && !protocol.equals("https")) {
                                            zzm.zzj("Unsupported scheme: " + protocol);
                                            webResourceResponse = zzS();
                                            break;
                                        }
                                        zzm.zze("Redirecting to " + headerField);
                                        httpURLConnection.disconnect();
                                        url = url2;
                                    } else {
                                        zzm.zzj("Protocol is null");
                                        webResourceResponse = zzS();
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            } else {
                                throw new IOException("Missing Location header in redirect");
                            }
                        }
                    } else {
                        throw new IOException("Invalid protocol.");
                    }
                } else {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
            }
            zzu.zzp();
            zzu.zzp();
            String contentType2 = httpURLConnection.getContentType();
            String str3 = "";
            if (TextUtils.isEmpty(contentType2)) {
                str2 = str3;
            } else {
                str2 = contentType2.split(";")[0].trim();
            }
            zzu.zzp();
            String contentType3 = httpURLConnection.getContentType();
            if (!TextUtils.isEmpty(contentType3)) {
                String[] split = contentType3.split(";");
                if (split.length != 1) {
                    int i2 = 1;
                    while (true) {
                        if (i2 >= split.length) {
                            break;
                        }
                        if (split[i2].trim().startsWith("charset")) {
                            String[] split2 = split[i2].trim().split(f.b);
                            if (split2.length > 1) {
                                str3 = split2[1].trim();
                                break;
                            }
                        }
                        i2++;
                    }
                }
            }
            String str4 = str3;
            Map headerFields = httpURLConnection.getHeaderFields();
            HashMap hashMap = new HashMap(headerFields.size());
            for (Map.Entry entry2 : headerFields.entrySet()) {
                if (!(entry2.getKey() == null || entry2.getValue() == null || ((List) entry2.getValue()).isEmpty())) {
                    hashMap.put((String) entry2.getKey(), (String) ((List) entry2.getValue()).get(0));
                }
            }
            webResourceResponse = zzu.zzq().zzb(str2, str4, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), hashMap, httpURLConnection.getInputStream());
            return webResourceResponse;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    /* access modifiers changed from: private */
    public final void zzU(Map map, List list, String str) {
        if (zze.zzc()) {
            zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                zze.zza("  " + str2 + ": " + ((String) map.get(str2)));
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbky) it.next()).zza(this.zzc, map);
        }
    }

    private final void zzV() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzF;
        if (onAttachStateChangeListener != null) {
            ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    /* access modifiers changed from: private */
    public final void zzW(View view, zzbzo zzbzo, int i) {
        if (zzbzo.zzi() && i > 0) {
            zzbzo.zzg(view);
            if (zzbzo.zzi()) {
                zzt.zza.postDelayed(new zzcgn(this, view, zzbzo, i), 100);
            }
        }
    }

    private static final boolean zzX(zzcgm zzcgm) {
        if (zzcgm.zzD() != null) {
            return zzcgm.zzD().zzaj;
        }
        return false;
    }

    private static final boolean zzY(boolean z, zzcgm zzcgm) {
        return z && !zzcgm.zzO().zzi() && !zzcgm.zzT().equals("interstitial_mb");
    }

    public final void onAdClicked() {
        zza zza2 = this.zzg;
        if (zza2 != null) {
            zza2.onAdClicked();
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        zze.zza("Loading resource: ".concat(String.valueOf(str)));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r2 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r2.zza();
        r1.zzj = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r1.zzc.zzL() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0040, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbdz.zzlA)).booleanValue() == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0042, code lost:
        r1.zzc.zzL().zzG(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r1.zzz = true;
        r2 = r1.zzj;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.Object r2 = r1.zzf
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzcgm r0 = r1.zzc     // Catch:{ all -> 0x004c }
            boolean r0 = r0.zzaB()     // Catch:{ all -> 0x004c }
            if (r0 == 0) goto L_0x0017
            java.lang.String r3 = "Blank page loaded, 1..."
            com.google.android.gms.ads.internal.util.zze.zza(r3)     // Catch:{ all -> 0x004c }
            com.google.android.gms.internal.ads.zzcgm r3 = r1.zzc     // Catch:{ all -> 0x004c }
            r3.zzV()     // Catch:{ all -> 0x004c }
            monitor-exit(r2)     // Catch:{ all -> 0x004c }
            return
        L_0x0017:
            monitor-exit(r2)     // Catch:{ all -> 0x004c }
            r2 = 1
            r1.zzz = r2
            com.google.android.gms.internal.ads.zzcib r2 = r1.zzj
            if (r2 == 0) goto L_0x0025
            r2.zza()
            r2 = 0
            r1.zzj = r2
        L_0x0025:
            r1.zzg()
            com.google.android.gms.internal.ads.zzcgm r2 = r1.zzc
            com.google.android.gms.ads.internal.overlay.zzm r2 = r2.zzL()
            if (r2 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzbdq r2 = com.google.android.gms.internal.ads.zzbdz.zzlA
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r0.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzcgm r2 = r1.zzc
            com.google.android.gms.ads.internal.overlay.zzm r2 = r2.zzL()
            r2.zzG(r3)
        L_0x004b:
            return
        L_0x004c:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004c }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgu.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.zzo = true;
        this.zzp = i;
        this.zzq = str;
        this.zzr = str2;
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaA(Chip$$ExternalSyntheticApiModelOutline0.m(renderProcessGoneDetail), Chip$$ExternalSyntheticApiModelOutline0.m(renderProcessGoneDetail));
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY:
            case 86:
            case 87:
            case 88:
            case TsExtractor.TS_STREAM_TYPE_DVBSUBS:
            case RotationOptions.ROTATE_90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case WebSocketProtocol.PAYLOAD_SHORT /*126*/:
                    case 127:
                    case 128:
                    case TsExtractor.TS_STREAM_TYPE_AC3:
                    case TsExtractor.TS_STREAM_TYPE_HDMV_DTS:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean shouldOverrideUrlLoading(android.webkit.WebView r13, java.lang.String r14) {
        /*
            r12 = this;
            java.lang.String r0 = "AdWebView shouldOverrideUrlLoading: "
            java.lang.String r1 = java.lang.String.valueOf(r14)
            java.lang.String r0 = r0.concat(r1)
            com.google.android.gms.ads.internal.util.zze.zza(r0)
            android.net.Uri r0 = android.net.Uri.parse(r14)
            java.lang.String r1 = r0.getScheme()
            java.lang.String r2 = "gmsg"
            boolean r1 = r2.equalsIgnoreCase(r1)
            r2 = 1
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = r0.getHost()
            java.lang.String r3 = "mobileads.google.com"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x002f
            r12.zzj(r0)
            goto L_0x010f
        L_0x002f:
            boolean r1 = r12.zzn
            if (r1 == 0) goto L_0x006e
            com.google.android.gms.internal.ads.zzcgm r1 = r12.zzc
            android.webkit.WebView r1 = r1.zzG()
            if (r13 != r1) goto L_0x006e
            java.lang.String r1 = r0.getScheme()
            java.lang.String r3 = "http"
            boolean r3 = r3.equalsIgnoreCase(r1)
            if (r3 != 0) goto L_0x004f
            java.lang.String r3 = "https"
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 == 0) goto L_0x006e
        L_0x004f:
            com.google.android.gms.ads.internal.client.zza r0 = r12.zzg
            r1 = 0
            if (r0 == 0) goto L_0x0060
            r0.onAdClicked()
            com.google.android.gms.internal.ads.zzbzo r0 = r12.zza
            if (r0 == 0) goto L_0x005e
            r0.zzh(r14)
        L_0x005e:
            r12.zzg = r1
        L_0x0060:
            com.google.android.gms.internal.ads.zzdgn r0 = r12.zzm
            if (r0 == 0) goto L_0x0069
            r0.zzdG()
            r12.zzm = r1
        L_0x0069:
            boolean r13 = super.shouldOverrideUrlLoading(r13, r14)
            return r13
        L_0x006e:
            com.google.android.gms.internal.ads.zzcgm r13 = r12.zzc
            android.webkit.WebView r13 = r13.zzG()
            boolean r13 = r13.willNotDraw()
            if (r13 != 0) goto L_0x0102
            com.google.android.gms.internal.ads.zzcgm r13 = r12.zzc     // Catch:{ zzawp -> 0x00d0 }
            com.google.android.gms.internal.ads.zzawo r13 = r13.zzI()     // Catch:{ zzawp -> 0x00d0 }
            com.google.android.gms.internal.ads.zzcgm r1 = r12.zzc     // Catch:{ zzawp -> 0x00d0 }
            com.google.android.gms.internal.ads.zzfgm r1 = r1.zzQ()     // Catch:{ zzawp -> 0x00d0 }
            com.google.android.gms.internal.ads.zzbdq r3 = com.google.android.gms.internal.ads.zzbdz.zzlF     // Catch:{ zzawp -> 0x00d0 }
            com.google.android.gms.internal.ads.zzbdx r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzawp -> 0x00d0 }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ zzawp -> 0x00d0 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ zzawp -> 0x00d0 }
            boolean r3 = r3.booleanValue()     // Catch:{ zzawp -> 0x00d0 }
            if (r3 == 0) goto L_0x00b5
            if (r1 == 0) goto L_0x00b5
            if (r13 == 0) goto L_0x00dd
            boolean r13 = r13.zzf(r0)     // Catch:{ zzawp -> 0x00d0 }
            if (r13 == 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzcgm r13 = r12.zzc     // Catch:{ zzawp -> 0x00d0 }
            android.content.Context r13 = r13.getContext()     // Catch:{ zzawp -> 0x00d0 }
            com.google.android.gms.internal.ads.zzcgm r3 = r12.zzc     // Catch:{ zzawp -> 0x00d0 }
            android.app.Activity r4 = r3.zzi()     // Catch:{ zzawp -> 0x00d0 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ zzawp -> 0x00d0 }
            android.net.Uri r0 = r1.zza(r0, r13, r3, r4)     // Catch:{ zzawp -> 0x00d0 }
            goto L_0x00dd
        L_0x00b5:
            if (r13 == 0) goto L_0x00dd
            boolean r1 = r13.zzf(r0)     // Catch:{ zzawp -> 0x00d0 }
            if (r1 == 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzcgm r1 = r12.zzc     // Catch:{ zzawp -> 0x00d0 }
            android.content.Context r1 = r1.getContext()     // Catch:{ zzawp -> 0x00d0 }
            com.google.android.gms.internal.ads.zzcgm r3 = r12.zzc     // Catch:{ zzawp -> 0x00d0 }
            android.app.Activity r4 = r3.zzi()     // Catch:{ zzawp -> 0x00d0 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ zzawp -> 0x00d0 }
            android.net.Uri r0 = r13.zza(r0, r1, r3, r4)     // Catch:{ zzawp -> 0x00d0 }
            goto L_0x00dd
        L_0x00d0:
            java.lang.String r13 = java.lang.String.valueOf(r14)
            java.lang.String r1 = "Unable to append parameter to URL: "
            java.lang.String r13 = r1.concat(r13)
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r13)
        L_0x00dd:
            com.google.android.gms.ads.internal.zzb r13 = r12.zzx
            if (r13 == 0) goto L_0x00ec
            boolean r1 = r13.zzc()
            if (r1 == 0) goto L_0x00e8
            goto L_0x00ec
        L_0x00e8:
            r13.zzb(r14)
            goto L_0x010f
        L_0x00ec:
            com.google.android.gms.ads.internal.overlay.zzc r13 = new com.google.android.gms.ads.internal.overlay.zzc
            java.lang.String r5 = r0.toString()
            java.lang.String r4 = "android.intent.action.VIEW"
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r3 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r12.zzu(r13, r2)
            goto L_0x010f
        L_0x0102:
            java.lang.String r13 = java.lang.String.valueOf(r14)
            java.lang.String r14 = "AdWebView unable to handle URL: "
            java.lang.String r13 = r14.concat(r13)
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r13)
        L_0x010f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgu.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }

    public final void zzA(String str, zzbky zzbky) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zze.put(str, list);
            }
            list.add(zzbky);
        }
    }

    public final void zzB(zzcia zzcia) {
        this.zzi = zzcia;
    }

    public final void zzC(int i, int i2) {
        zzbtm zzbtm = this.zzy;
        if (zzbtm != null) {
            zzbtm.zze(i, i2);
        }
    }

    public final void zzD(boolean z) {
        this.zzn = false;
    }

    public final void zzE(boolean z) {
        synchronized (this.zzf) {
            this.zzu = z;
        }
    }

    public final void zzF() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzs = true;
            zzcbr.zze.execute(new zzcgo(this));
        }
    }

    public final void zzG(boolean z) {
        synchronized (this.zzf) {
            this.zzt = true;
        }
    }

    public final void zzH(zzcib zzcib) {
        this.zzj = zzcib;
    }

    public final void zzI(zzcpk zzcpk, zzefd zzefd, zzfmt zzfmt) {
        zzL("/click");
        if (zzefd == null || zzfmt == null) {
            zzA("/click", new zzbjw(this.zzm, zzcpk));
        } else {
            zzA("/click", new zzfgq(this.zzm, zzcpk, zzfmt, zzefd));
        }
    }

    public final void zzJ(zzcpk zzcpk) {
        zzL("/click");
        zzA("/click", new zzbjw(this.zzm, zzcpk));
    }

    public final void zzK(zzcpk zzcpk, zzefd zzefd, zzduh zzduh) {
        zzL("/open");
        zzA("/open", new zzblk(this.zzx, this.zzy, zzefd, zzduh, zzcpk));
    }

    public final void zzL(String str) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list != null) {
                list.clear();
            }
        }
    }

    public final void zzM(String str, zzbky zzbky) {
        synchronized (this.zzf) {
            List list = (List) this.zze.get(str);
            if (list != null) {
                list.remove(zzbky);
            }
        }
    }

    public final void zzN(String str, Predicate predicate) {
        synchronized (this.zzf) {
            List<zzbky> list = (List) this.zze.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzbky zzbky : list) {
                    if (predicate.apply(zzbky)) {
                        arrayList.add(zzbky);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final boolean zzO() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzu;
        }
        return z;
    }

    public final boolean zzP() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzs;
        }
        return z;
    }

    public final boolean zzQ() {
        boolean z;
        synchronized (this.zzf) {
            z = this.zzt;
        }
        return z;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x01b1: MOVE  (r1v47 com.google.android.gms.internal.ads.zzbkz) = (r35v0 com.google.android.gms.internal.ads.zzbkz)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    public final void zzR(com.google.android.gms.ads.internal.client.zza r18, com.google.android.gms.internal.ads.zzbjo r19, com.google.android.gms.ads.internal.overlay.zzp r20, com.google.android.gms.internal.ads.zzbjq r21, com.google.android.gms.ads.internal.overlay.zzaa r22, boolean r23, com.google.android.gms.internal.ads.zzblb r24, com.google.android.gms.ads.internal.zzb r25, com.google.android.gms.internal.ads.zzbtt r26, com.google.android.gms.internal.ads.zzbzo r27, com.google.android.gms.internal.ads.zzefd r28, com.google.android.gms.internal.ads.zzfmt r29, com.google.android.gms.internal.ads.zzduh r30, com.google.android.gms.internal.ads.zzbls r31, com.google.android.gms.internal.ads.zzdgn r32, com.google.android.gms.internal.ads.zzblr r33, com.google.android.gms.internal.ads.zzbll r34, com.google.android.gms.internal.ads.zzbkz r35, com.google.android.gms.internal.ads.zzcpk r36) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            r2 = r21
            r3 = r24
            r4 = r26
            r5 = r27
            r10 = r28
            r11 = r29
            r12 = r31
            r13 = r32
            r14 = r33
            r15 = r34
            r9 = r35
            r8 = r36
            if (r25 != 0) goto L_0x002c
            com.google.android.gms.internal.ads.zzcgm r6 = r0.zzc
            com.google.android.gms.ads.internal.zzb r7 = new com.google.android.gms.ads.internal.zzb
            android.content.Context r6 = r6.getContext()
            r8 = 0
            r7.<init>(r6, r5, r8)
            r8 = r7
            goto L_0x002e
        L_0x002c:
            r8 = r25
        L_0x002e:
            com.google.android.gms.internal.ads.zzcgm r6 = r0.zzc
            com.google.android.gms.internal.ads.zzbtm r7 = new com.google.android.gms.internal.ads.zzbtm
            r7.<init>(r6, r4)
            r0.zzy = r7
            r0.zza = r5
            com.google.android.gms.internal.ads.zzbdq r5 = com.google.android.gms.internal.ads.zzbdz.zzaR
            com.google.android.gms.internal.ads.zzbdx r6 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r5 = r6.zza(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0055
            com.google.android.gms.internal.ads.zzbjn r5 = new com.google.android.gms.internal.ads.zzbjn
            r5.<init>(r1)
            java.lang.String r6 = "/adMetadata"
            r0.zzA(r6, r5)
        L_0x0055:
            if (r2 == 0) goto L_0x0061
            com.google.android.gms.internal.ads.zzbjp r5 = new com.google.android.gms.internal.ads.zzbjp
            r5.<init>(r2)
            java.lang.String r6 = "/appEvent"
            r0.zzA(r6, r5)
        L_0x0061:
            java.lang.String r5 = "/backButton"
            com.google.android.gms.internal.ads.zzbky r6 = com.google.android.gms.internal.ads.zzbkx.zzj
            r0.zzA(r5, r6)
            java.lang.String r5 = "/refresh"
            com.google.android.gms.internal.ads.zzbky r6 = com.google.android.gms.internal.ads.zzbkx.zzk
            r0.zzA(r5, r6)
            java.lang.String r5 = "/canOpenApp"
            com.google.android.gms.internal.ads.zzbky r6 = com.google.android.gms.internal.ads.zzbkx.zzb
            r0.zzA(r5, r6)
            java.lang.String r5 = "/canOpenURLs"
            com.google.android.gms.internal.ads.zzbky r6 = com.google.android.gms.internal.ads.zzbkx.zza
            r0.zzA(r5, r6)
            java.lang.String r5 = "/canOpenIntents"
            com.google.android.gms.internal.ads.zzbky r6 = com.google.android.gms.internal.ads.zzbkx.zzc
            r0.zzA(r5, r6)
            java.lang.String r5 = "/close"
            com.google.android.gms.internal.ads.zzbky r6 = com.google.android.gms.internal.ads.zzbkx.zzd
            r0.zzA(r5, r6)
            java.lang.String r5 = "/customClose"
            com.google.android.gms.internal.ads.zzbky r6 = com.google.android.gms.internal.ads.zzbkx.zze
            r0.zzA(r5, r6)
            java.lang.String r5 = "/instrument"
            com.google.android.gms.internal.ads.zzbky r6 = com.google.android.gms.internal.ads.zzbkx.zzn
            r0.zzA(r5, r6)
            java.lang.String r5 = "/delayPageLoaded"
            com.google.android.gms.internal.ads.zzbky r6 = com.google.android.gms.internal.ads.zzbkx.zzp
            r0.zzA(r5, r6)
            java.lang.String r5 = "/delayPageClosed"
            com.google.android.gms.internal.ads.zzbky r6 = com.google.android.gms.internal.ads.zzbkx.zzq
            r0.zzA(r5, r6)
            java.lang.String r5 = "/getLocationInfo"
            com.google.android.gms.internal.ads.zzbky r6 = com.google.android.gms.internal.ads.zzbkx.zzr
            r0.zzA(r5, r6)
            java.lang.String r5 = "/log"
            com.google.android.gms.internal.ads.zzbky r6 = com.google.android.gms.internal.ads.zzbkx.zzg
            r0.zzA(r5, r6)
            com.google.android.gms.internal.ads.zzblf r5 = new com.google.android.gms.internal.ads.zzblf
            com.google.android.gms.internal.ads.zzbtm r6 = r0.zzy
            r5.<init>(r8, r6, r4)
            java.lang.String r4 = "/mraid"
            r0.zzA(r4, r5)
            com.google.android.gms.internal.ads.zzbtr r4 = r0.zzw
            if (r4 == 0) goto L_0x00ca
            java.lang.String r5 = "/mraidLoaded"
            r0.zzA(r5, r4)
        L_0x00ca:
            com.google.android.gms.internal.ads.zzblk r7 = new com.google.android.gms.internal.ads.zzblk
            com.google.android.gms.internal.ads.zzbtm r6 = r0.zzy
            r4 = r7
            r5 = r8
            r2 = r7
            r7 = r28
            r1 = r36
            r16 = r8
            r8 = r30
            r9 = r36
            r4.<init>(r5, r6, r7, r8, r9)
            java.lang.String r4 = "/open"
            r0.zzA(r4, r2)
            com.google.android.gms.internal.ads.zzcez r2 = new com.google.android.gms.internal.ads.zzcez
            r2.<init>()
            java.lang.String r4 = "/precache"
            r0.zzA(r4, r2)
            java.lang.String r2 = "/touch"
            com.google.android.gms.internal.ads.zzbky r4 = com.google.android.gms.internal.ads.zzbkx.zzi
            r0.zzA(r2, r4)
            java.lang.String r2 = "/video"
            com.google.android.gms.internal.ads.zzbky r4 = com.google.android.gms.internal.ads.zzbkx.zzl
            r0.zzA(r2, r4)
            java.lang.String r2 = "/videoMeta"
            com.google.android.gms.internal.ads.zzbky r4 = com.google.android.gms.internal.ads.zzbkx.zzm
            r0.zzA(r2, r4)
            java.lang.String r2 = "/httpTrack"
            java.lang.String r4 = "/click"
            if (r10 == 0) goto L_0x011b
            if (r11 == 0) goto L_0x011b
            com.google.android.gms.internal.ads.zzfgq r5 = new com.google.android.gms.internal.ads.zzfgq
            r5.<init>(r13, r1, r11, r10)
            r0.zzA(r4, r5)
            com.google.android.gms.internal.ads.zzfgr r1 = new com.google.android.gms.internal.ads.zzfgr
            r1.<init>(r11, r10)
            r0.zzA(r2, r1)
            goto L_0x0128
        L_0x011b:
            com.google.android.gms.internal.ads.zzbjw r5 = new com.google.android.gms.internal.ads.zzbjw
            r5.<init>(r13, r1)
            r0.zzA(r4, r5)
            com.google.android.gms.internal.ads.zzbky r1 = com.google.android.gms.internal.ads.zzbkx.zzf
            r0.zzA(r2, r1)
        L_0x0128:
            com.google.android.gms.internal.ads.zzcgm r1 = r0.zzc
            com.google.android.gms.internal.ads.zzcad r2 = com.google.android.gms.ads.internal.zzu.zzn()
            android.content.Context r1 = r1.getContext()
            boolean r1 = r2.zzp(r1)
            if (r1 == 0) goto L_0x0148
            com.google.android.gms.internal.ads.zzcgm r1 = r0.zzc
            com.google.android.gms.internal.ads.zzble r2 = new com.google.android.gms.internal.ads.zzble
            android.content.Context r1 = r1.getContext()
            r2.<init>(r1)
            java.lang.String r1 = "/logScionEvent"
            r0.zzA(r1, r2)
        L_0x0148:
            if (r3 == 0) goto L_0x0154
            com.google.android.gms.internal.ads.zzbla r1 = new com.google.android.gms.internal.ads.zzbla
            r1.<init>(r3)
            java.lang.String r2 = "/setInterstitialProperties"
            r0.zzA(r2, r1)
        L_0x0154:
            if (r12 == 0) goto L_0x016d
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zziO
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x016d
            java.lang.String r1 = "/inspectorNetworkExtras"
            r0.zzA(r1, r12)
        L_0x016d:
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zzjh
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x0186
            if (r14 == 0) goto L_0x0186
            java.lang.String r1 = "/shareSheet"
            r0.zzA(r1, r14)
        L_0x0186:
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zzjm
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x019f
            if (r15 == 0) goto L_0x019f
            java.lang.String r1 = "/inspectorOutOfContextTest"
            r0.zzA(r1, r15)
        L_0x019f:
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zzjq
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x01ba
            r1 = r35
            if (r1 == 0) goto L_0x01ba
            java.lang.String r2 = "/inspectorStorage"
            r0.zzA(r2, r1)
        L_0x01ba:
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zzli
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x01ef
            java.lang.String r1 = "/bindPlayStoreOverlay"
            com.google.android.gms.internal.ads.zzbky r2 = com.google.android.gms.internal.ads.zzbkx.zzu
            r0.zzA(r1, r2)
            java.lang.String r1 = "/presentPlayStoreOverlay"
            com.google.android.gms.internal.ads.zzbky r2 = com.google.android.gms.internal.ads.zzbkx.zzv
            r0.zzA(r1, r2)
            java.lang.String r1 = "/expandPlayStoreOverlay"
            com.google.android.gms.internal.ads.zzbky r2 = com.google.android.gms.internal.ads.zzbkx.zzw
            r0.zzA(r1, r2)
            java.lang.String r1 = "/collapsePlayStoreOverlay"
            com.google.android.gms.internal.ads.zzbky r2 = com.google.android.gms.internal.ads.zzbkx.zzx
            r0.zzA(r1, r2)
            java.lang.String r1 = "/closePlayStoreOverlay"
            com.google.android.gms.internal.ads.zzbky r2 = com.google.android.gms.internal.ads.zzbkx.zzy
            r0.zzA(r1, r2)
        L_0x01ef:
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zzdd
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x020f
            java.lang.String r1 = "/setPAIDPersonalizationEnabled"
            com.google.android.gms.internal.ads.zzbky r2 = com.google.android.gms.internal.ads.zzbkx.zzA
            r0.zzA(r1, r2)
            java.lang.String r1 = "/resetPAID"
            com.google.android.gms.internal.ads.zzbky r2 = com.google.android.gms.internal.ads.zzbkx.zzz
            r0.zzA(r1, r2)
        L_0x020f:
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zzlz
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x023f
            com.google.android.gms.internal.ads.zzcgm r1 = r0.zzc
            com.google.android.gms.internal.ads.zzffn r2 = r1.zzD()
            if (r2 == 0) goto L_0x023f
            com.google.android.gms.internal.ads.zzffn r1 = r1.zzD()
            boolean r1 = r1.zzar
            if (r1 == 0) goto L_0x023f
            java.lang.String r1 = "/writeToLocalStorage"
            com.google.android.gms.internal.ads.zzbky r2 = com.google.android.gms.internal.ads.zzbkx.zzB
            r0.zzA(r1, r2)
            java.lang.String r1 = "/clearLocalStorageKeys"
            com.google.android.gms.internal.ads.zzbky r2 = com.google.android.gms.internal.ads.zzbkx.zzC
            r0.zzA(r1, r2)
        L_0x023f:
            r1 = r18
            r0.zzg = r1
            r1 = r20
            r0.zzh = r1
            r1 = r19
            r0.zzk = r1
            r1 = r21
            r0.zzl = r1
            r1 = r22
            r0.zzv = r1
            r7 = r16
            r0.zzx = r7
            r0.zzm = r13
            r1 = r23
            r0.zzn = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgu.zzR(com.google.android.gms.ads.internal.client.zza, com.google.android.gms.internal.ads.zzbjo, com.google.android.gms.ads.internal.overlay.zzp, com.google.android.gms.internal.ads.zzbjq, com.google.android.gms.ads.internal.overlay.zzaa, boolean, com.google.android.gms.internal.ads.zzblb, com.google.android.gms.ads.internal.zzb, com.google.android.gms.internal.ads.zzbtt, com.google.android.gms.internal.ads.zzbzo, com.google.android.gms.internal.ads.zzefd, com.google.android.gms.internal.ads.zzfmt, com.google.android.gms.internal.ads.zzduh, com.google.android.gms.internal.ads.zzbls, com.google.android.gms.internal.ads.zzdgn, com.google.android.gms.internal.ads.zzblr, com.google.android.gms.internal.ads.zzbll, com.google.android.gms.internal.ads.zzbkz, com.google.android.gms.internal.ads.zzcpk):void");
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0126, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0128, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x014f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0150, code lost:
        r10 = true;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009c A[SYNTHETIC, Splitter:B:20:0x009c] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x014f A[ExcHandler: all (th java.lang.Throwable), Splitter:B:28:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01e8 A[Catch:{ Exception | NoClassDefFoundError -> 0x0260 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0236 A[Catch:{ Exception | NoClassDefFoundError -> 0x0260 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0259 A[Catch:{ Exception | NoClassDefFoundError -> 0x0260 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:52:0x0161=Splitter:B:52:0x0161, B:60:0x0197=Splitter:B:60:0x0197} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.webkit.WebResourceResponse zzc(java.lang.String r19, java.util.Map r20) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            java.lang.String r2 = "range"
            java.lang.String r3 = "ms"
            java.lang.String r4 = "Cache connection took "
            com.google.android.gms.internal.ads.zzcgm r5 = r1.zzc     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            android.content.Context r5 = r5.getContext()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            boolean r6 = r1.zzC     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r5 = com.google.android.gms.internal.ads.zzcaf.zzc(r0, r5, r6)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            boolean r6 = r5.equals(r0)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            if (r6 != 0) goto L_0x0023
            r6 = r20
            android.webkit.WebResourceResponse r0 = r1.zzT(r5, r6)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            return r0
        L_0x0023:
            r6 = r20
            android.net.Uri r5 = android.net.Uri.parse(r19)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.internal.ads.zzbcj r5 = com.google.android.gms.internal.ads.zzbcj.zza(r5)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            if (r5 == 0) goto L_0x0245
            java.util.HashMap r13 = new java.util.HashMap     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r13.<init>()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r8 = "Access-Control-Allow-Origin"
            java.lang.String r9 = "*"
            r13.put(r8, r9)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            android.net.Uri r8 = android.net.Uri.parse(r19)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.util.Set r9 = r8.getQueryParameterNames()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            boolean r9 = r9.contains(r2)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r10 = 0
            r11 = -1
            r12 = 1
            if (r9 == 0) goto L_0x0081
            r9 = 45
            com.google.android.gms.internal.ads.zzfwc r9 = com.google.android.gms.internal.ads.zzfwc.zzc(r9)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.internal.ads.zzfxe r9 = com.google.android.gms.internal.ads.zzfxe.zzc(r9)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r2 = r8.getQueryParameter(r2)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.util.List r2 = r9.zzf(r2)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            int r8 = r2.size()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r9 = 2
            if (r8 != r9) goto L_0x0081
            java.lang.Object r8 = r2.get(r10)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.Object r2 = r2.get(r12)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            int r2 = r2 + r12
            if (r8 <= 0) goto L_0x007f
            long r14 = (long) r8     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r5.zzh = r14     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
        L_0x007f:
            int r2 = r2 - r8
            goto L_0x0082
        L_0x0081:
            r2 = r11
        L_0x0082:
            com.google.android.gms.internal.ads.zzbdq r8 = com.google.android.gms.internal.ads.zzbdz.zzel     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.internal.ads.zzbdx r9 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.Object r8 = r9.zza(r8)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.Boolean r8 = (java.lang.Boolean) r8     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            boolean r8 = r8.booleanValue()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r9 = "X-Afma-Gcache-CachedBytes"
            java.lang.String r14 = "X-Afma-Gcache-IsDownloaded"
            java.lang.String r15 = "X-Afma-Gcache-IsGcacheHit"
            java.lang.String r10 = "X-Afma-Gcache-HasAdditionalMetadataFromReadV2"
            if (r8 == 0) goto L_0x01e8
            com.google.android.gms.internal.ads.zzcgm r8 = r1.zzc     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r8 = r8.zzr()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfxg.zzc(r8)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r5.zzi = r8     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.internal.ads.zzcgm r8 = r1.zzc     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            int r8 = r8.zzf()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r5.zzj = r8     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            boolean r8 = r5.zzg     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            if (r8 == 0) goto L_0x00c1
            com.google.android.gms.internal.ads.zzbdq r8 = com.google.android.gms.internal.ads.zzbdz.zzen     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.internal.ads.zzbdx r7 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.Object r7 = r7.zza(r8)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            goto L_0x00cd
        L_0x00c1:
            com.google.android.gms.internal.ads.zzbdq r7 = com.google.android.gms.internal.ads.zzbdz.zzem     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.internal.ads.zzbdx r8 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.Object r7 = r8.zza(r7)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
        L_0x00cd:
            long r7 = r7.longValue()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.common.util.Clock r16 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            long r16 = r16.elapsedRealtime()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.ads.internal.zzu.zzd()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.internal.ads.zzcgm r12 = r1.zzc     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            android.content.Context r12 = r12.getContext()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.util.concurrent.Future r5 = com.google.android.gms.internal.ads.zzbcu.zza(r12, r5)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x0194, InterruptedException -> 0x015e, all -> 0x015b }
            java.lang.Object r7 = r5.get(r7, r12)     // Catch:{ ExecutionException | TimeoutException -> 0x0194, InterruptedException -> 0x015e, all -> 0x015b }
            com.google.android.gms.internal.ads.zzbcv r7 = (com.google.android.gms.internal.ads.zzbcv) r7     // Catch:{ ExecutionException | TimeoutException -> 0x0194, InterruptedException -> 0x015e, all -> 0x015b }
            boolean r8 = r7.zzd()     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            java.lang.String r8 = java.lang.Boolean.toString(r8)     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            r13.put(r10, r8)     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            boolean r8 = r7.zzf()     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            java.lang.String r8 = java.lang.Boolean.toString(r8)     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            r13.put(r15, r8)     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            boolean r8 = r7.zze()     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            java.lang.String r8 = java.lang.Boolean.toString(r8)     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            r13.put(r14, r8)     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            long r14 = r7.zza()     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            java.lang.String r8 = java.lang.Long.toString(r14)     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            r13.put(r9, r8)     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            java.io.InputStream r7 = r7.zzc()     // Catch:{ ExecutionException | TimeoutException -> 0x0157, InterruptedException -> 0x0153, all -> 0x014f }
            if (r2 == r11) goto L_0x012a
            long r8 = (long) r2
            java.io.InputStream r7 = com.google.android.gms.internal.ads.zzgbx.zza(r7, r8)     // Catch:{ ExecutionException | TimeoutException -> 0x0128, InterruptedException -> 0x0126, all -> 0x014f }
            goto L_0x012a
        L_0x0126:
            r2 = 1
            goto L_0x0155
        L_0x0128:
            r2 = 1
            goto L_0x0159
        L_0x012a:
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            long r8 = r2.elapsedRealtime()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            long r8 = r8 - r16
            com.google.android.gms.internal.ads.zzftg r2 = com.google.android.gms.ads.internal.util.zzt.zza     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.internal.ads.zzcgq r5 = new com.google.android.gms.internal.ads.zzcgq     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r10 = 1
            r5.<init>(r1, r10, r8)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.post(r5)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.append(r8)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.append(r3)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            goto L_0x018e
        L_0x014f:
            r0 = move-exception
            r10 = 1
            goto L_0x01c1
        L_0x0153:
            r2 = 1
            r7 = 0
        L_0x0155:
            r10 = 1
            goto L_0x0161
        L_0x0157:
            r2 = 1
            r7 = 0
        L_0x0159:
            r10 = 1
            goto L_0x0197
        L_0x015b:
            r0 = move-exception
            r10 = 0
            goto L_0x01c1
        L_0x015e:
            r2 = 1
            r7 = 0
            r10 = 0
        L_0x0161:
            r5.cancel(r2)     // Catch:{ all -> 0x0192 }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0192 }
            r2.interrupt()     // Catch:{ all -> 0x0192 }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            long r8 = r2.elapsedRealtime()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            long r8 = r8 - r16
            com.google.android.gms.internal.ads.zzftg r2 = com.google.android.gms.ads.internal.util.zzt.zza     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.internal.ads.zzcgq r5 = new com.google.android.gms.internal.ads.zzcgq     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r5.<init>(r1, r10, r8)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.post(r5)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.append(r8)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.append(r3)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
        L_0x018e:
            com.google.android.gms.ads.internal.util.zze.zza(r2)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            goto L_0x01be
        L_0x0192:
            r0 = move-exception
            goto L_0x01c1
        L_0x0194:
            r2 = 1
            r7 = 0
            r10 = 0
        L_0x0197:
            r5.cancel(r2)     // Catch:{ all -> 0x0192 }
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            long r8 = r2.elapsedRealtime()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            long r8 = r8 - r16
            com.google.android.gms.internal.ads.zzftg r2 = com.google.android.gms.ads.internal.util.zzt.zza     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.internal.ads.zzcgq r5 = new com.google.android.gms.internal.ads.zzcgq     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r5.<init>(r1, r10, r8)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.post(r5)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.append(r8)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.append(r3)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            goto L_0x018e
        L_0x01be:
            r14 = r7
            goto L_0x0234
        L_0x01c1:
            com.google.android.gms.common.util.Clock r2 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            long r5 = r2.elapsedRealtime()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            long r5 = r5 - r16
            com.google.android.gms.internal.ads.zzftg r2 = com.google.android.gms.ads.internal.util.zzt.zza     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.internal.ads.zzcgq r7 = new com.google.android.gms.internal.ads.zzcgq     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r7.<init>(r1, r10, r5)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.post(r7)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.<init>(r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.append(r5)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r2.append(r3)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.ads.internal.util.zze.zza(r2)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            throw r0     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
        L_0x01e8:
            com.google.android.gms.internal.ads.zzbcf r3 = com.google.android.gms.ads.internal.zzu.zzc()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            com.google.android.gms.internal.ads.zzbcg r3 = r3.zzb(r5)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            if (r3 == 0) goto L_0x0233
            boolean r4 = r3.zze()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            if (r4 == 0) goto L_0x0233
            boolean r4 = r3.zzd()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r13.put(r10, r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            boolean r4 = r3.zzg()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r13.put(r15, r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            boolean r4 = r3.zzf()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r4 = java.lang.Boolean.toString(r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r13.put(r14, r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            long r4 = r3.zza()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r4 = java.lang.Long.toString(r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r13.put(r9, r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.io.InputStream r3 = r3.zzc()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            if (r2 == r11) goto L_0x0231
            long r4 = (long) r2     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.io.InputStream r2 = com.google.android.gms.internal.ads.zzgbx.zza(r3, r4)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            r14 = r2
            goto L_0x0234
        L_0x0231:
            r14 = r3
            goto L_0x0234
        L_0x0233:
            r14 = 0
        L_0x0234:
            if (r14 == 0) goto L_0x0245
            android.webkit.WebResourceResponse r0 = new android.webkit.WebResourceResponse     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.String r9 = ""
            java.lang.String r10 = ""
            r11 = 200(0xc8, float:2.8E-43)
            java.lang.String r12 = "OK"
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r14)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            return r0
        L_0x0245:
            boolean r2 = com.google.android.gms.ads.internal.util.client.zzl.zzk()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            if (r2 == 0) goto L_0x025e
            com.google.android.gms.internal.ads.zzbff r2 = com.google.android.gms.internal.ads.zzbfp.zzb     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.Object r2 = r2.zze()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            boolean r2 = r2.booleanValue()     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            if (r2 == 0) goto L_0x025e
            android.webkit.WebResourceResponse r0 = r18.zzT(r19, r20)     // Catch:{ Exception -> 0x0262, NoClassDefFoundError -> 0x0260 }
            return r0
        L_0x025e:
            r0 = 0
            return r0
        L_0x0260:
            r0 = move-exception
            goto L_0x0263
        L_0x0262:
            r0 = move-exception
        L_0x0263:
            java.lang.String r2 = "AdWebViewClient.interceptRequest"
            com.google.android.gms.internal.ads.zzcbh r3 = com.google.android.gms.ads.internal.zzu.zzo()
            r3.zzw(r0, r2)
            android.webkit.WebResourceResponse r0 = zzS()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcgu.zzc(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    public final zzb zzd() {
        return this.zzx;
    }

    public final void zzdG() {
        zzdgn zzdgn = this.zzm;
        if (zzdgn != null) {
            zzdgn.zzdG();
        }
    }

    public final void zzdf() {
        zzdgn zzdgn = this.zzm;
        if (zzdgn != null) {
            zzdgn.zzdf();
        }
    }

    public final void zzg() {
        if (this.zzi != null && ((this.zzz && this.zzB <= 0) || this.zzA || this.zzo)) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzbQ)).booleanValue() && this.zzc.zzm() != null) {
                zzbeg.zza(this.zzc.zzm().zza(), this.zzc.zzk(), "awfllc");
            }
            zzcia zzcia = this.zzi;
            boolean z = false;
            if (!this.zzA && !this.zzo) {
                z = true;
            }
            zzcia.zza(z, this.zzp, this.zzq, this.zzr);
            this.zzi = null;
        }
        this.zzc.zzad();
    }

    public final void zzh() {
        zzbzo zzbzo = this.zza;
        if (zzbzo != null) {
            zzbzo.zze();
            this.zza = null;
        }
        zzV();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzs = false;
            this.zzt = false;
            this.zzv = null;
            this.zzx = null;
            this.zzw = null;
            zzbtm zzbtm = this.zzy;
            if (zzbtm != null) {
                zzbtm.zza(true);
                this.zzy = null;
            }
        }
    }

    public final void zzi(boolean z) {
        this.zzC = z;
    }

    public final void zzj(Uri uri) {
        zze.zza("Received GMSG: ".concat(String.valueOf(String.valueOf(uri))));
        HashMap hashMap = this.zze;
        String path = uri.getPath();
        List list = (List) hashMap.get(path);
        if (path == null || list == null) {
            zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(String.valueOf(uri))));
            if (((Boolean) zzba.zzc().zza(zzbdz.zzgP)).booleanValue() && zzu.zzo().zzg() != null) {
                zzcbr.zza.execute(new zzcgp((path == null || path.length() < 2) ? "null" : path.substring(1)));
                return;
            }
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfF)).booleanValue() && this.zzD.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) zzba.zzc().zza(zzbdz.zzfH)).intValue()) {
                zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                zzgee.zzr(zzu.zzp().zzb(uri), new zzcgs(this, list, path, uri), zzcbr.zze);
                return;
            }
        }
        zzu.zzp();
        zzU(zzt.zzP(uri), list, path);
    }

    public final void zzk() {
        zzbcx zzbcx = this.zzd;
        if (zzbcx != null) {
            zzbcx.zzb(zzbcz.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzA = true;
        this.zzp = zzbcz.DELAY_PAGE_LOAD_CANCELLED_AD.zza();
        this.zzq = "Page loaded delay cancel.";
        zzg();
        this.zzc.destroy();
    }

    public final void zzl() {
        synchronized (this.zzf) {
        }
        this.zzB++;
        zzg();
    }

    public final void zzm() {
        this.zzB--;
        zzg();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzn() {
        this.zzc.zzab();
        com.google.android.gms.ads.internal.overlay.zzm zzL = this.zzc.zzL();
        if (zzL != null) {
            zzL.zzz();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(boolean z, long j) {
        this.zzc.zzv(z, j);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(View view, zzbzo zzbzo, int i) {
        zzW(view, zzbzo, i - 1);
    }

    public final void zzq(int i, int i2, boolean z) {
        zzbtr zzbtr = this.zzw;
        if (zzbtr != null) {
            zzbtr.zzb(i, i2);
        }
        zzbtm zzbtm = this.zzy;
        if (zzbtm != null) {
            zzbtm.zzd(i, i2, false);
        }
    }

    public final void zzr() {
        zzbzo zzbzo = this.zza;
        if (zzbzo != null) {
            WebView zzG = this.zzc.zzG();
            if (ViewCompat.isAttachedToWindow(zzG)) {
                zzW(zzG, zzbzo, 10);
                return;
            }
            zzV();
            zzcgr zzcgr = new zzcgr(this, zzbzo);
            this.zzF = zzcgr;
            ((View) this.zzc).addOnAttachStateChangeListener(zzcgr);
        }
    }

    public final void zzu(zzc zzc2, boolean z) {
        zzcgm zzcgm = this.zzc;
        boolean zzaC = zzcgm.zzaC();
        boolean zzY = zzY(zzaC, zzcgm);
        boolean z2 = true;
        if (!zzY && z) {
            z2 = false;
        }
        zza zza2 = zzY ? null : this.zzg;
        zzp zzp2 = zzaC ? null : this.zzh;
        zzaa zzaa = this.zzv;
        zzcgm zzcgm2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzc2, zza2, zzp2, zzaa, zzcgm2.zzn(), zzcgm2, z2 ? null : this.zzm));
    }

    public final void zzv(String str, String str2, int i) {
        zzefo zzefo = this.zzE;
        zzcgm zzcgm = this.zzc;
        zzx(new AdOverlayInfoParcel(zzcgm, zzcgm.zzn(), str, str2, 14, zzefo));
    }

    public final void zzw(boolean z, int i, boolean z2) {
        zzcgm zzcgm = this.zzc;
        boolean zzY = zzY(zzcgm.zzaC(), zzcgm);
        boolean z3 = true;
        if (!zzY && z2) {
            z3 = false;
        }
        zza zza2 = zzY ? null : this.zzg;
        zzp zzp2 = this.zzh;
        zzaa zzaa = this.zzv;
        zzcgm zzcgm2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zza2, zzp2, zzaa, zzcgm2, z, i, zzcgm2.zzn(), z3 ? null : this.zzm, zzX(this.zzc) ? this.zzE : null));
    }

    public final void zzx(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzc zzc2;
        zzbtm zzbtm = this.zzy;
        boolean zzf2 = zzbtm != null ? zzbtm.zzf() : false;
        zzu.zzi();
        zzn.zza(this.zzc.getContext(), adOverlayInfoParcel, !zzf2);
        zzbzo zzbzo = this.zza;
        if (zzbzo != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzc2 = adOverlayInfoParcel.zza) != null) {
                str = zzc2.zzb;
            }
            zzbzo.zzh(str);
        }
    }

    public final void zzy(boolean z, int i, String str, String str2, boolean z2) {
        zzcgt zzcgt;
        zzcgm zzcgm = this.zzc;
        boolean zzaC = zzcgm.zzaC();
        boolean zzY = zzY(zzaC, zzcgm);
        boolean z3 = true;
        if (!zzY && z2) {
            z3 = false;
        }
        zza zza2 = zzY ? null : this.zzg;
        if (zzaC) {
            zzcgt = null;
        } else {
            zzcgt = new zzcgt(this.zzc, this.zzh);
        }
        zzbjo zzbjo = this.zzk;
        zzbjq zzbjq = this.zzl;
        zzaa zzaa = this.zzv;
        zzcgm zzcgm2 = this.zzc;
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel(zza2, (zzp) zzcgt, zzbjo, zzbjq, zzaa, zzcgm2, z, i, str, str2, zzcgm2.zzn(), z3 ? null : this.zzm, (zzbui) zzX(this.zzc) ? this.zzE : null);
        zzx(adOverlayInfoParcel);
    }

    public final void zzz(boolean z, int i, String str, boolean z2, boolean z3) {
        zzcgt zzcgt;
        zzcgm zzcgm = this.zzc;
        boolean zzaC = zzcgm.zzaC();
        boolean zzY = zzY(zzaC, zzcgm);
        boolean z4 = true;
        if (!zzY && z2) {
            z4 = false;
        }
        zza zza2 = zzY ? null : this.zzg;
        if (zzaC) {
            zzcgt = null;
        } else {
            zzcgt = new zzcgt(this.zzc, this.zzh);
        }
        zzbjo zzbjo = this.zzk;
        zzbjq zzbjq = this.zzl;
        zzaa zzaa = this.zzv;
        zzcgm zzcgm2 = this.zzc;
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel(zza2, (zzp) zzcgt, zzbjo, zzbjq, zzaa, zzcgm2, z, i, str, zzcgm2.zzn(), z4 ? null : this.zzm, (zzbui) zzX(this.zzc) ? this.zzE : null, z3);
        zzx(adOverlayInfoParcel);
    }
}
