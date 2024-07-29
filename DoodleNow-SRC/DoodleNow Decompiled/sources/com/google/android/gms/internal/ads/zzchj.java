package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.amazon.a.a.o.b;
import com.amplitude.api.Constants;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.zzch;
import com.google.android.gms.ads.internal.util.zzck;
import com.google.android.gms.ads.internal.util.zzco;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzk;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzchj extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcgm {
    public static final /* synthetic */ int zza = 0;
    private zzchm zzA;
    private boolean zzB;
    private boolean zzC;
    private zzbgs zzD;
    private zzbgq zzE;
    private zzbbl zzF;
    private int zzG;
    /* access modifiers changed from: private */
    public int zzH;
    private zzbel zzI;
    private final zzbel zzJ;
    private zzbel zzK;
    private final zzbem zzL;
    private int zzM;
    private zzm zzN;
    private boolean zzO;
    private final zzco zzP;
    private int zzQ = -1;
    private int zzR = -1;
    private int zzS = -1;
    private int zzT = -1;
    private Map zzU;
    private final WindowManager zzV;
    private final zzbcx zzW;
    private boolean zzX;
    private final zzcid zzb;
    private final zzawo zzc;
    private final zzfgm zzd;
    private final zzbfc zze;
    private final VersionInfoParcel zzf;
    private com.google.android.gms.ads.internal.zzm zzg;
    private final zza zzh;
    private final DisplayMetrics zzi;
    private final float zzj;
    private zzffn zzk;
    private zzffq zzl;
    private boolean zzm = false;
    private boolean zzn = false;
    private zzcgu zzo;
    private zzm zzp;
    private zzfmy zzq;
    private zzcie zzr;
    private final String zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;
    private Boolean zzx;
    private boolean zzy = true;
    private final String zzz = "";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected zzchj(zzcid zzcid, zzcie zzcie, String str, boolean z, boolean z2, zzawo zzawo, zzbfc zzbfc, VersionInfoParcel versionInfoParcel, zzbeo zzbeo, com.google.android.gms.ads.internal.zzm zzm2, zza zza2, zzbcx zzbcx, zzffn zzffn, zzffq zzffq, zzfgm zzfgm) {
        super(zzcid);
        zzffq zzffq2;
        VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        this.zzb = zzcid;
        this.zzr = zzcie;
        this.zzs = str;
        this.zzv = z;
        this.zzc = zzawo;
        this.zzd = zzfgm;
        this.zze = zzbfc;
        this.zzf = versionInfoParcel2;
        this.zzg = zzm2;
        this.zzh = zza2;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzV = windowManager;
        zzu.zzp();
        DisplayMetrics zzt2 = zzt.zzt(windowManager);
        this.zzi = zzt2;
        this.zzj = zzt2.density;
        this.zzW = zzbcx;
        this.zzk = zzffn;
        this.zzl = zzffq;
        this.zzP = new zzco(zzcid.zza(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        this.zzX = false;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzlo)).booleanValue()) {
            settings.setMixedContentMode(1);
        } else {
            settings.setMixedContentMode(2);
        }
        settings.setUserAgentString(zzu.zzp().zzc(zzcid, versionInfoParcel2.afmaVersion));
        zzu.zzp();
        Context context = getContext();
        zzch.zza(context, new zzk(settings, context));
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setDownloadListener(this);
        zzaX();
        addJavascriptInterface(new zzchq(this, new zzchp(this)), "googleAdsJsInterface");
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzbf();
        zzbem zzbem = new zzbem(new zzbeo(true, "make_wv", this.zzs));
        this.zzL = zzbem;
        zzbem.zza().zzc((zzbeo) null);
        if (!(!((Boolean) zzba.zzc().zza(zzbdz.zzbQ)).booleanValue() || (zzffq2 = this.zzl) == null || zzffq2.zzb == null)) {
            zzbem.zza().zzd("gqi", this.zzl.zzb);
        }
        zzbem.zza();
        zzbel zzf2 = zzbeo.zzf();
        this.zzJ = zzf2;
        zzbem.zzb("native:view_create", zzf2);
        this.zzK = null;
        this.zzI = null;
        zzck.zza().zzb(zzcid);
        zzu.zzo().zzt();
    }

    private final synchronized void zzaX() {
        zzffn zzffn = this.zzk;
        if (zzffn != null) {
            if (zzffn.zzan) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Disabling hardware acceleration on an overlay.");
                zzaZ();
                return;
            }
        }
        if (!this.zzv) {
            if (!this.zzr.zzi()) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Enabling hardware acceleration on an AdView.");
                zzbb();
                return;
            }
        }
        com.google.android.gms.ads.internal.util.client.zzm.zze("Enabling hardware acceleration on an overlay.");
        zzbb();
    }

    private final synchronized void zzaY() {
        if (!this.zzO) {
            this.zzO = true;
            zzu.zzo().zzr();
        }
    }

    private final synchronized void zzaZ() {
        if (!this.zzw) {
            setLayerType(1, (Paint) null);
        }
        this.zzw = true;
    }

    private final void zzba(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", true != z ? SessionDescription.SUPPORTED_SDP_VERSION : "1");
        zzd("onAdVisibilityChanged", hashMap);
    }

    private final synchronized void zzbb() {
        if (this.zzw) {
            setLayerType(0, (Paint) null);
        }
        this.zzw = false;
    }

    private final synchronized void zzbc(String str) {
        try {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzkU)).booleanValue()) {
                zzt.zza.post(new zzche(this, "about:blank"));
            } else {
                super.loadUrl("about:blank");
            }
        } catch (Throwable th) {
            zzu.zzo().zzw(th, "AdWebViewImpl.loadUrlUnsafe");
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Could not call loadUrl in destroy(). ", th);
        }
    }

    private final void zzbd() {
        zzbeg.zza(this.zzL.zza(), this.zzJ, "aeh2");
    }

    private final synchronized void zzbe() {
        Map map = this.zzU;
        if (map != null) {
            for (zzcey release : map.values()) {
                release.release();
            }
        }
        this.zzU = null;
    }

    private final void zzbf() {
        zzbem zzbem = this.zzL;
        if (zzbem != null) {
            zzbeo zza2 = zzbem.zza();
            zzbee zzg2 = zzu.zzo().zzg();
            if (zzg2 != null) {
                zzg2.zzf(zza2);
            }
        }
    }

    private final synchronized void zzbg() {
        Boolean zzl2 = zzu.zzo().zzl();
        this.zzx = zzl2;
        if (zzl2 == null) {
            try {
                evaluateJavascript("(function(){})()", (ValueCallback) null);
                zzaV(true);
            } catch (IllegalStateException unused) {
                zzaV(false);
            }
        }
    }

    public final synchronized void destroy() {
        zzbf();
        this.zzP.zza();
        zzm zzm2 = this.zzp;
        if (zzm2 != null) {
            zzm2.zzb();
            this.zzp.zzm();
            this.zzp = null;
        }
        this.zzq = null;
        this.zzo.zzh();
        this.zzF = null;
        this.zzg = null;
        setOnClickListener((View.OnClickListener) null);
        setOnTouchListener((View.OnTouchListener) null);
        if (!this.zzu) {
            zzu.zzy().zzd(this);
            zzbe();
            this.zzu = true;
            if (((Boolean) zzba.zzc().zza(zzbdz.zzkw)).booleanValue()) {
                zze.zza("Initiating WebView self destruct sequence in 3...");
                zze.zza("Loading blank page in WebView, 2...");
                zzbc("about:blank");
                return;
            }
            zze.zza("Destroying the WebView immediately...");
            zzV();
        }
    }

    public final synchronized void evaluateJavascript(String str, ValueCallback valueCallback) {
        if (zzaB()) {
            com.google.android.gms.ads.internal.util.client.zzm.zzl("#004 The webview is destroyed. Ignoring action.", (Throwable) null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue((Object) null);
                return;
            }
            return;
        }
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzkx)).booleanValue() || Looper.getMainLooper().getThread() == Thread.currentThread()) {
            super.evaluateJavascript(str, valueCallback);
        } else {
            zzcbr.zze.zza(new zzchd(this, str, valueCallback));
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzu) {
                    this.zzo.zzh();
                    zzu.zzy().zzd(this);
                    zzbe();
                    zzaY();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final synchronized void loadData(String str, String str2, String str3) {
        if (!zzaB()) {
            super.loadData(str, str2, str3);
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!zzaB()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadUrl(String str) {
        if (!zzaB()) {
            try {
                if (((Boolean) zzba.zzc().zza(zzbdz.zzkU)).booleanValue()) {
                    zzt.zza.post(new zzchg(this, str));
                } else {
                    super.loadUrl(str);
                }
            } catch (Throwable th) {
                zzu.zzo().zzw(th, "AdWebViewImpl.loadUrl");
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Could not call loadUrl. ", th);
            }
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final void onAdClicked() {
        zzcgu zzcgu = this.zzo;
        if (zzcgu != null) {
            zzcgu.onAdClicked();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!zzaB()) {
            this.zzP.zzc();
        }
        if (this.zzX) {
            onResume();
            this.zzX = false;
        }
        boolean z = this.zzB;
        zzcgu zzcgu = this.zzo;
        if (zzcgu != null && zzcgu.zzQ()) {
            if (!this.zzC) {
                this.zzo.zza();
                this.zzo.zzb();
                this.zzC = true;
            }
            zzaW();
            z = true;
        }
        zzba(z);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        zzcgu zzcgu;
        synchronized (this) {
            if (!zzaB()) {
                this.zzP.zzd();
            }
            super.onDetachedFromWindow();
            if (this.zzC && (zzcgu = this.zzo) != null && zzcgu.zzQ() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzo.zza();
                this.zzo.zzb();
                this.zzC = false;
            }
        }
        zzba(false);
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            if (((Boolean) zzba.zzc().zza(zzbdz.zzkI)).booleanValue() && getContext() != null) {
                intent.setPackage(getContext().getPackageName());
            }
            zzu.zzp();
            zzt.zzT(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Couldn't find an Activity to view url/mimetype: " + str + " / " + str4);
            zzu.zzo().zzw(e, "AdWebViewImpl.onDownloadStart: ".concat(String.valueOf(str)));
        }
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        if (!zzaB()) {
            super.onDraw(canvas);
        }
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public final void onGlobalLayout() {
        boolean zzaW = zzaW();
        zzm zzL2 = zzL();
        if (zzL2 != null && zzaW) {
            zzL2.zzn();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0159  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x01b7 A[SYNTHETIC, Splitter:B:114:0x01b7] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0139  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            java.lang.String r0 = "Not enough space to show ad. Needs "
            monitor-enter(r9)
            boolean r1 = r9.zzaB()     // Catch:{ all -> 0x01dd }
            r2 = 0
            if (r1 == 0) goto L_0x000f
            r9.setMeasuredDimension(r2, r2)     // Catch:{ all -> 0x01dd }
            monitor-exit(r9)
            return
        L_0x000f:
            boolean r1 = r9.isInEditMode()     // Catch:{ all -> 0x01dd }
            if (r1 != 0) goto L_0x01d8
            boolean r1 = r9.zzv     // Catch:{ all -> 0x01dd }
            if (r1 != 0) goto L_0x01d8
            com.google.android.gms.internal.ads.zzcie r1 = r9.zzr     // Catch:{ all -> 0x01dd }
            boolean r1 = r1.zzf()     // Catch:{ all -> 0x01dd }
            if (r1 == 0) goto L_0x0023
            goto L_0x01d8
        L_0x0023:
            com.google.android.gms.internal.ads.zzcie r1 = r9.zzr     // Catch:{ all -> 0x01dd }
            boolean r1 = r1.zzh()     // Catch:{ all -> 0x01dd }
            if (r1 == 0) goto L_0x0030
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x01dd }
            monitor-exit(r9)
            return
        L_0x0030:
            com.google.android.gms.internal.ads.zzcie r1 = r9.zzr     // Catch:{ all -> 0x01dd }
            boolean r1 = r1.zzj()     // Catch:{ all -> 0x01dd }
            if (r1 == 0) goto L_0x0099
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzdL     // Catch:{ all -> 0x01dd }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x01dd }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x01dd }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01dd }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01dd }
            if (r0 == 0) goto L_0x004f
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x01dd }
            monitor-exit(r9)
            return
        L_0x004f:
            com.google.android.gms.internal.ads.zzchm r0 = r9.zzq()     // Catch:{ all -> 0x01dd }
            r1 = 0
            if (r0 == 0) goto L_0x005b
            float r0 = r0.zze()     // Catch:{ all -> 0x01dd }
            goto L_0x005c
        L_0x005b:
            r0 = r1
        L_0x005c:
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0065
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x01dd }
            monitor-exit(r9)
            return
        L_0x0065:
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01dd }
            int r11 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x01dd }
            float r1 = (float) r11     // Catch:{ all -> 0x01dd }
            float r1 = r1 * r0
            float r3 = (float) r10     // Catch:{ all -> 0x01dd }
            float r3 = r3 / r0
            int r3 = (int) r3     // Catch:{ all -> 0x01dd }
            if (r11 != 0) goto L_0x007d
            if (r3 == 0) goto L_0x007c
            float r11 = (float) r3     // Catch:{ all -> 0x01dd }
            float r11 = r11 * r0
            int r11 = (int) r11     // Catch:{ all -> 0x01dd }
            r2 = r10
            r10 = r3
            goto L_0x008c
        L_0x007c:
            r11 = r2
        L_0x007d:
            int r1 = (int) r1     // Catch:{ all -> 0x01dd }
            if (r10 != 0) goto L_0x0089
            if (r1 == 0) goto L_0x008a
            float r10 = (float) r1     // Catch:{ all -> 0x01dd }
            float r10 = r10 / r0
            int r3 = (int) r10     // Catch:{ all -> 0x01dd }
            r10 = r11
            r11 = r1
            r2 = r11
            goto L_0x008c
        L_0x0089:
            r2 = r10
        L_0x008a:
            r10 = r11
            r11 = r1
        L_0x008c:
            int r11 = java.lang.Math.min(r11, r2)     // Catch:{ all -> 0x01dd }
            int r10 = java.lang.Math.min(r3, r10)     // Catch:{ all -> 0x01dd }
            r9.setMeasuredDimension(r11, r10)     // Catch:{ all -> 0x01dd }
            monitor-exit(r9)
            return
        L_0x0099:
            com.google.android.gms.internal.ads.zzcie r1 = r9.zzr     // Catch:{ all -> 0x01dd }
            boolean r1 = r1.zzg()     // Catch:{ all -> 0x01dd }
            if (r1 == 0) goto L_0x00e1
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzdS     // Catch:{ all -> 0x01dd }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x01dd }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x01dd }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01dd }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01dd }
            if (r0 == 0) goto L_0x00b8
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x01dd }
            monitor-exit(r9)
            return
        L_0x00b8:
            com.google.android.gms.internal.ads.zzchh r0 = new com.google.android.gms.internal.ads.zzchh     // Catch:{ all -> 0x01dd }
            r0.<init>(r9)     // Catch:{ all -> 0x01dd }
            java.lang.String r1 = "/contentHeight"
            r9.zzae(r1, r0)     // Catch:{ all -> 0x01dd }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r9.zzaQ(r0)     // Catch:{ all -> 0x01dd }
            android.util.DisplayMetrics r0 = r9.zzi     // Catch:{ all -> 0x01dd }
            float r0 = r0.density     // Catch:{ all -> 0x01dd }
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01dd }
            int r1 = r9.zzH     // Catch:{ all -> 0x01dd }
            r2 = -1
            if (r1 == r2) goto L_0x00d8
            float r11 = (float) r1     // Catch:{ all -> 0x01dd }
            float r11 = r11 * r0
            int r11 = (int) r11     // Catch:{ all -> 0x01dd }
            goto L_0x00dc
        L_0x00d8:
            int r11 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x01dd }
        L_0x00dc:
            r9.setMeasuredDimension(r10, r11)     // Catch:{ all -> 0x01dd }
            monitor-exit(r9)
            return
        L_0x00e1:
            com.google.android.gms.internal.ads.zzcie r1 = r9.zzr     // Catch:{ all -> 0x01dd }
            boolean r1 = r1.zzi()     // Catch:{ all -> 0x01dd }
            if (r1 == 0) goto L_0x00f4
            android.util.DisplayMetrics r10 = r9.zzi     // Catch:{ all -> 0x01dd }
            int r11 = r10.widthPixels     // Catch:{ all -> 0x01dd }
            int r10 = r10.heightPixels     // Catch:{ all -> 0x01dd }
            r9.setMeasuredDimension(r11, r10)     // Catch:{ all -> 0x01dd }
            monitor-exit(r9)
            return
        L_0x00f4:
            int r1 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x01dd }
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01dd }
            int r3 = android.view.View.MeasureSpec.getMode(r11)     // Catch:{ all -> 0x01dd }
            int r11 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x01dd }
            r4 = 2147483647(0x7fffffff, float:NaN)
            r5 = 1073741824(0x40000000, float:2.0)
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 == r6) goto L_0x0112
            if (r1 != r5) goto L_0x0110
            goto L_0x0112
        L_0x0110:
            r1 = r4
            goto L_0x0113
        L_0x0112:
            r1 = r10
        L_0x0113:
            if (r3 == r6) goto L_0x0117
            if (r3 != r5) goto L_0x0118
        L_0x0117:
            r4 = r11
        L_0x0118:
            com.google.android.gms.internal.ads.zzcie r3 = r9.zzr     // Catch:{ all -> 0x01dd }
            int r5 = r3.zzb     // Catch:{ all -> 0x01dd }
            r6 = 1
            if (r5 > r1) goto L_0x0126
            int r3 = r3.zza     // Catch:{ all -> 0x01dd }
            if (r3 <= r4) goto L_0x0124
            goto L_0x0126
        L_0x0124:
            r3 = r2
            goto L_0x0127
        L_0x0126:
            r3 = r6
        L_0x0127:
            com.google.android.gms.internal.ads.zzbdq r5 = com.google.android.gms.internal.ads.zzbdz.zzfs     // Catch:{ all -> 0x01dd }
            com.google.android.gms.internal.ads.zzbdx r7 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x01dd }
            java.lang.Object r5 = r7.zza(r5)     // Catch:{ all -> 0x01dd }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ all -> 0x01dd }
            boolean r5 = r5.booleanValue()     // Catch:{ all -> 0x01dd }
            if (r5 == 0) goto L_0x0155
            com.google.android.gms.internal.ads.zzcie r5 = r9.zzr     // Catch:{ all -> 0x01dd }
            int r7 = r5.zzb     // Catch:{ all -> 0x01dd }
            float r7 = (float) r7     // Catch:{ all -> 0x01dd }
            float r8 = r9.zzj     // Catch:{ all -> 0x01dd }
            float r1 = (float) r1     // Catch:{ all -> 0x01dd }
            float r7 = r7 / r8
            float r1 = r1 / r8
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 > 0) goto L_0x0153
            int r1 = r5.zza     // Catch:{ all -> 0x01dd }
            float r1 = (float) r1     // Catch:{ all -> 0x01dd }
            float r1 = r1 / r8
            float r4 = (float) r4     // Catch:{ all -> 0x01dd }
            float r4 = r4 / r8
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x0153
            r1 = r6
            goto L_0x0154
        L_0x0153:
            r1 = r2
        L_0x0154:
            r3 = r3 & r1
        L_0x0155:
            r1 = 8
            if (r3 == 0) goto L_0x01b7
            com.google.android.gms.internal.ads.zzcie r3 = r9.zzr     // Catch:{ all -> 0x01dd }
            int r4 = r3.zzb     // Catch:{ all -> 0x01dd }
            float r4 = (float) r4     // Catch:{ all -> 0x01dd }
            float r5 = r9.zzj     // Catch:{ all -> 0x01dd }
            int r3 = r3.zza     // Catch:{ all -> 0x01dd }
            float r3 = (float) r3     // Catch:{ all -> 0x01dd }
            float r10 = (float) r10     // Catch:{ all -> 0x01dd }
            float r11 = (float) r11     // Catch:{ all -> 0x01dd }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01dd }
            r7.<init>(r0)     // Catch:{ all -> 0x01dd }
            float r4 = r4 / r5
            int r0 = (int) r4     // Catch:{ all -> 0x01dd }
            r7.append(r0)     // Catch:{ all -> 0x01dd }
            java.lang.String r0 = "x"
            r7.append(r0)     // Catch:{ all -> 0x01dd }
            float r3 = r3 / r5
            int r0 = (int) r3     // Catch:{ all -> 0x01dd }
            r7.append(r0)     // Catch:{ all -> 0x01dd }
            java.lang.String r0 = " dp, but only has "
            r7.append(r0)     // Catch:{ all -> 0x01dd }
            float r10 = r10 / r5
            int r10 = (int) r10     // Catch:{ all -> 0x01dd }
            r7.append(r10)     // Catch:{ all -> 0x01dd }
            java.lang.String r10 = "x"
            r7.append(r10)     // Catch:{ all -> 0x01dd }
            float r11 = r11 / r5
            int r10 = (int) r11     // Catch:{ all -> 0x01dd }
            r7.append(r10)     // Catch:{ all -> 0x01dd }
            java.lang.String r10 = " dp."
            r7.append(r10)     // Catch:{ all -> 0x01dd }
            java.lang.String r10 = r7.toString()     // Catch:{ all -> 0x01dd }
            com.google.android.gms.ads.internal.util.client.zzm.zzj(r10)     // Catch:{ all -> 0x01dd }
            int r10 = r9.getVisibility()     // Catch:{ all -> 0x01dd }
            if (r10 == r1) goto L_0x01a3
            r10 = 4
            r9.setVisibility(r10)     // Catch:{ all -> 0x01dd }
        L_0x01a3:
            r9.setMeasuredDimension(r2, r2)     // Catch:{ all -> 0x01dd }
            boolean r10 = r9.zzm     // Catch:{ all -> 0x01dd }
            if (r10 != 0) goto L_0x01b5
            com.google.android.gms.internal.ads.zzbcx r10 = r9.zzW     // Catch:{ all -> 0x01dd }
            com.google.android.gms.internal.ads.zzbcz r11 = com.google.android.gms.internal.ads.zzbcz.BANNER_SIZE_INVALID     // Catch:{ all -> 0x01dd }
            r10.zzb(r11)     // Catch:{ all -> 0x01dd }
            r9.zzm = r6     // Catch:{ all -> 0x01dd }
            monitor-exit(r9)
            return
        L_0x01b5:
            monitor-exit(r9)
            return
        L_0x01b7:
            int r10 = r9.getVisibility()     // Catch:{ all -> 0x01dd }
            if (r10 == r1) goto L_0x01c0
            r9.setVisibility(r2)     // Catch:{ all -> 0x01dd }
        L_0x01c0:
            boolean r10 = r9.zzn     // Catch:{ all -> 0x01dd }
            if (r10 != 0) goto L_0x01cd
            com.google.android.gms.internal.ads.zzbcx r10 = r9.zzW     // Catch:{ all -> 0x01dd }
            com.google.android.gms.internal.ads.zzbcz r11 = com.google.android.gms.internal.ads.zzbcz.BANNER_SIZE_VALID     // Catch:{ all -> 0x01dd }
            r10.zzb(r11)     // Catch:{ all -> 0x01dd }
            r9.zzn = r6     // Catch:{ all -> 0x01dd }
        L_0x01cd:
            com.google.android.gms.internal.ads.zzcie r10 = r9.zzr     // Catch:{ all -> 0x01dd }
            int r11 = r10.zzb     // Catch:{ all -> 0x01dd }
            int r10 = r10.zza     // Catch:{ all -> 0x01dd }
            r9.setMeasuredDimension(r11, r10)     // Catch:{ all -> 0x01dd }
            monitor-exit(r9)
            return
        L_0x01d8:
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x01dd }
            monitor-exit(r9)
            return
        L_0x01dd:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchj.onMeasure(int, int):void");
    }

    public final void onPause() {
        if (!zzaB()) {
            try {
                super.onPause();
            } catch (Exception e) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Could not pause webview.", e);
            }
            if (((Boolean) zzba.zzc().zza(zzbdz.zzmh)).booleanValue() && WebViewFeature.isFeatureSupported("MUTE_AUDIO")) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Muting webview");
                WebViewCompat.setAudioMuted(this, true);
            }
        }
    }

    public final void onResume() {
        if (!zzaB()) {
            try {
                super.onResume();
            } catch (Exception e) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Could not resume webview.", e);
            }
            if (((Boolean) zzba.zzc().zza(zzbdz.zzmh)).booleanValue() && WebViewFeature.isFeatureSupported("MUTE_AUDIO")) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Unmuting webview");
                WebViewCompat.setAudioMuted(this, false);
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzo.zzQ() || this.zzo.zzO()) {
            zzawo zzawo = this.zzc;
            if (zzawo != null) {
                zzawo.zzd(motionEvent);
            }
            zzbfc zzbfc = this.zze;
            if (zzbfc != null) {
                zzbfc.zzb(motionEvent);
            }
        } else {
            synchronized (this) {
                zzbgs zzbgs = this.zzD;
                if (zzbgs != null) {
                    zzbgs.zzd(motionEvent);
                }
            }
        }
        if (zzaB()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcgu) {
            this.zzo = (zzcgu) webViewClient;
        }
    }

    public final void stopLoading() {
        if (!zzaB()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Could not stop loading webview.", e);
            }
        }
    }

    public final synchronized void zzA(int i) {
        this.zzM = i;
    }

    public final void zzB(int i) {
    }

    public final synchronized void zzC(zzchm zzchm) {
        if (this.zzA != null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzA = zzchm;
        }
    }

    public final zzffn zzD() {
        return this.zzk;
    }

    public final Context zzE() {
        return this.zzb.zzb();
    }

    public final View zzF() {
        return this;
    }

    public final WebView zzG() {
        return this;
    }

    public final WebViewClient zzH() {
        return this.zzo;
    }

    public final zzawo zzI() {
        return this.zzc;
    }

    public final synchronized zzbbl zzJ() {
        return this.zzF;
    }

    public final synchronized zzbgs zzK() {
        return this.zzD;
    }

    public final synchronized zzm zzL() {
        return this.zzp;
    }

    public final synchronized zzm zzM() {
        return this.zzN;
    }

    public final /* synthetic */ zzcic zzN() {
        return this.zzo;
    }

    public final synchronized zzcie zzO() {
        return this.zzr;
    }

    public final zzffq zzP() {
        return this.zzl;
    }

    public final zzfgm zzQ() {
        return this.zzd;
    }

    public final synchronized zzfmy zzR() {
        return this.zzq;
    }

    public final ListenableFuture zzS() {
        zzbfc zzbfc = this.zze;
        if (zzbfc == null) {
            return zzgee.zzh((Object) null);
        }
        return zzbfc.zza();
    }

    public final synchronized String zzT() {
        return this.zzs;
    }

    public final void zzU(zzffn zzffn, zzffq zzffq) {
        this.zzk = zzffn;
        this.zzl = zzffq;
    }

    public final synchronized void zzV() {
        zze.zza("Destroying WebView!");
        zzaY();
        zzt.zza.post(new zzchi(this));
    }

    public final void zzW() {
        zzbd();
        HashMap hashMap = new HashMap(1);
        hashMap.put(Constants.AMP_PLAN_VERSION, this.zzf.afmaVersion);
        zzd("onhide", hashMap);
    }

    public final void zzX(int i) {
        if (i == 0) {
            zzbem zzbem = this.zzL;
            zzbeg.zza(zzbem.zza(), this.zzJ, "aebb2");
        }
        zzbd();
        this.zzL.zza();
        this.zzL.zza().zzd("close_type", String.valueOf(i));
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put(Constants.AMP_PLAN_VERSION, this.zzf.afmaVersion);
        zzd("onhide", hashMap);
    }

    public final void zzY() {
        if (this.zzI == null) {
            zzbem zzbem = this.zzL;
            zzbeg.zza(zzbem.zza(), this.zzJ, "aes2");
            this.zzL.zza();
            zzbel zzf2 = zzbeo.zzf();
            this.zzI = zzf2;
            this.zzL.zzb("native:view_show", zzf2);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put(Constants.AMP_PLAN_VERSION, this.zzf.afmaVersion);
        zzd("onshow", hashMap);
    }

    public final void zzZ() {
        throw null;
    }

    public final void zza(String str) {
        throw null;
    }

    public final boolean zzaA(boolean z, int i) {
        destroy();
        this.zzW.zzc(new zzchf(z, i));
        this.zzW.zzb(zzbcz.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    public final synchronized boolean zzaB() {
        return this.zzu;
    }

    public final synchronized boolean zzaC() {
        return this.zzv;
    }

    public final boolean zzaD() {
        return false;
    }

    public final synchronized boolean zzaE() {
        return this.zzy;
    }

    public final void zzaF(zzc zzc2, boolean z) {
        this.zzo.zzu(zzc2, z);
    }

    public final void zzaG(String str, String str2, int i) {
        this.zzo.zzv(str, str2, 14);
    }

    public final void zzaH(boolean z, int i, boolean z2) {
        this.zzo.zzw(z, i, z2);
    }

    public final void zzaI(boolean z, int i, String str, String str2, boolean z2) {
        this.zzo.zzy(z, i, str, str2, z2);
    }

    public final void zzaJ(boolean z, int i, String str, boolean z2, boolean z3) {
        this.zzo.zzz(z, i, str, z2, z3);
    }

    public final zzcgu zzaL() {
        return this.zzo;
    }

    /* access modifiers changed from: package-private */
    public final synchronized Boolean zzaM() {
        return this.zzx;
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzaP(String str, ValueCallback valueCallback) {
        if (!zzaB()) {
            evaluateJavascript(str, (ValueCallback) null);
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* access modifiers changed from: protected */
    public final void zzaQ(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzaM() == null) {
                zzbg();
            }
            if (zzaM().booleanValue()) {
                zzaP(str, (ValueCallback) null);
            } else {
                zzaU("javascript:".concat(str));
            }
        } else {
            zzaU("javascript:".concat(str));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaR(String str, ValueCallback valueCallback) {
        super.evaluateJavascript(str, valueCallback);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaS(String str) {
        super.loadUrl(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaT(String str) {
        super.loadUrl("about:blank");
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzaU(String str) {
        if (!zzaB()) {
            loadUrl(str);
        } else {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzaV(Boolean bool) {
        synchronized (this) {
            this.zzx = bool;
        }
        zzu.zzo().zzx(bool);
    }

    public final boolean zzaW() {
        int i;
        int i2;
        boolean z = false;
        if (this.zzo.zzP() || this.zzo.zzQ()) {
            zzay.zzb();
            DisplayMetrics displayMetrics = this.zzi;
            int zzw2 = zzf.zzw(displayMetrics, displayMetrics.widthPixels);
            zzay.zzb();
            DisplayMetrics displayMetrics2 = this.zzi;
            int zzw3 = zzf.zzw(displayMetrics2, displayMetrics2.heightPixels);
            Activity zza2 = this.zzb.zza();
            if (zza2 == null || zza2.getWindow() == null) {
                i2 = zzw2;
                i = zzw3;
            } else {
                zzu.zzp();
                int[] zzQ2 = zzt.zzQ(zza2);
                zzay.zzb();
                int zzw4 = zzf.zzw(this.zzi, zzQ2[0]);
                zzay.zzb();
                i = zzf.zzw(this.zzi, zzQ2[1]);
                i2 = zzw4;
            }
            int i3 = this.zzR;
            if (!(i3 == zzw2 && this.zzQ == zzw3 && this.zzS == i2 && this.zzT == i)) {
                if (!(i3 == zzw2 && this.zzQ == zzw3)) {
                    z = true;
                }
                this.zzR = zzw2;
                this.zzQ = zzw3;
                this.zzS = i2;
                this.zzT = i;
                new zzbts(this, "").zzj(zzw2, zzw3, i2, i, this.zzi.density, this.zzV.getDefaultDisplay().getRotation());
                return z;
            }
        }
        return false;
    }

    public final void zzaa(boolean z) {
        this.zzo.zzi(z);
    }

    public final void zzab() {
        this.zzP.zzb();
    }

    public final synchronized void zzac(String str, String str2, String str3) {
        String str4;
        if (!zzaB()) {
            String[] strArr = new String[1];
            String str5 = (String) zzba.zzc().zza(zzbdz.zzP);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Constants.AMP_PLAN_VERSION, str5);
                jSONObject.put("sdk", "Google Mobile Ads");
                jSONObject.put(b.I, "12.4.51-000");
                str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + jSONObject.toString() + "}});</script>";
            } catch (JSONException e) {
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Unable to build MRAID_ENV", e);
                str4 = null;
            }
            strArr[0] = str4;
            super.loadDataWithBaseURL(str, zzchv.zza(str2, strArr), "text/html", "UTF-8", (String) null);
            return;
        }
        com.google.android.gms.ads.internal.util.client.zzm.zzj("#004 The webview is destroyed. Ignoring action.");
    }

    public final void zzad() {
        if (this.zzK == null) {
            this.zzL.zza();
            zzbel zzf2 = zzbeo.zzf();
            this.zzK = zzf2;
            this.zzL.zzb("native:view_load", zzf2);
        }
    }

    public final void zzae(String str, zzbky zzbky) {
        zzcgu zzcgu = this.zzo;
        if (zzcgu != null) {
            zzcgu.zzA(str, zzbky);
        }
    }

    public final void zzaf() {
        throw null;
    }

    public final synchronized void zzag(zzm zzm2) {
        this.zzp = zzm2;
    }

    public final synchronized void zzah(zzcie zzcie) {
        this.zzr = zzcie;
        requestLayout();
    }

    public final synchronized void zzai(zzbbl zzbbl) {
        this.zzF = zzbbl;
    }

    public final synchronized void zzaj(boolean z) {
        this.zzy = z;
    }

    public final void zzak() {
        setBackgroundColor(0);
    }

    public final void zzal(Context context) {
        this.zzb.setBaseContext(context);
        this.zzP.zze(this.zzb.zza());
    }

    public final synchronized void zzam(boolean z) {
        zzm zzm2 = this.zzp;
        if (zzm2 != null) {
            zzm2.zzy(this.zzo.zzP(), z);
        } else {
            this.zzt = z;
        }
    }

    public final synchronized void zzan(zzbgq zzbgq) {
        this.zzE = zzbgq;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzao(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzv     // Catch:{ all -> 0x003a }
            r2.zzv = r3     // Catch:{ all -> 0x003a }
            r2.zzaX()     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x0038
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzQ     // Catch:{ all -> 0x003a }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x003a }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x003a }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003a }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzcie r0 = r2.zzr     // Catch:{ all -> 0x003a }
            boolean r0 = r0.zzi()     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0038
        L_0x0024:
            java.lang.String r0 = ""
            com.google.android.gms.internal.ads.zzbts r1 = new com.google.android.gms.internal.ads.zzbts     // Catch:{ all -> 0x003a }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x003a }
            r0 = 1
            if (r0 == r3) goto L_0x0031
            java.lang.String r3 = "default"
            goto L_0x0033
        L_0x0031:
            java.lang.String r3 = "expanded"
        L_0x0033:
            r1.zzl(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)
            return
        L_0x0038:
            monitor-exit(r2)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchj.zzao(boolean):void");
    }

    public final synchronized void zzap(zzbgs zzbgs) {
        this.zzD = zzbgs;
    }

    public final synchronized void zzaq(zzfmy zzfmy) {
        this.zzq = zzfmy;
    }

    public final synchronized void zzar(int i) {
        zzm zzm2 = this.zzp;
        if (zzm2 != null) {
            zzm2.zzA(i);
        }
    }

    public final void zzas(boolean z) {
        this.zzX = true;
    }

    public final synchronized void zzat(zzm zzm2) {
        this.zzN = zzm2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzau(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.zzG     // Catch:{ all -> 0x0017 }
            r1 = 1
            if (r1 == r3) goto L_0x0007
            r1 = -1
        L_0x0007:
            int r0 = r0 + r1
            r2.zzG = r0     // Catch:{ all -> 0x0017 }
            if (r0 > 0) goto L_0x0015
            com.google.android.gms.ads.internal.overlay.zzm r3 = r2.zzp     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0015
            r3.zzE()     // Catch:{ all -> 0x0017 }
            monitor-exit(r2)
            return
        L_0x0015:
            monitor-exit(r2)
            return
        L_0x0017:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzchj.zzau(boolean):void");
    }

    public final synchronized void zzav(boolean z) {
        if (z) {
            setBackgroundColor(0);
        }
        zzm zzm2 = this.zzp;
        if (zzm2 != null) {
            zzm2.zzB(z);
        }
    }

    public final void zzaw(String str, zzbky zzbky) {
        zzcgu zzcgu = this.zzo;
        if (zzcgu != null) {
            zzcgu.zzM(str, zzbky);
        }
    }

    public final void zzax(String str, Predicate predicate) {
        zzcgu zzcgu = this.zzo;
        if (zzcgu != null) {
            zzcgu.zzN(str, predicate);
        }
    }

    public final synchronized boolean zzay() {
        return this.zzt;
    }

    public final synchronized boolean zzaz() {
        return this.zzG > 0;
    }

    public final void zzb(String str, String str2) {
        zzaQ(str + "(" + str2 + ");");
    }

    public final void zzd(String str, Map map) {
        try {
            zze(str, zzay.zzb().zzj(map));
        } catch (JSONException unused) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not convert parameters to JSON.");
        }
    }

    public final void zzdG() {
        zzcgu zzcgu = this.zzo;
        if (zzcgu != null) {
            zzcgu.zzdG();
        }
    }

    public final void zzdf() {
        zzcgu zzcgu = this.zzo;
        if (zzcgu != null) {
            zzcgu.zzdf();
        }
    }

    public final synchronized void zzdg() {
        com.google.android.gms.ads.internal.zzm zzm2 = this.zzg;
        if (zzm2 != null) {
            zzm2.zzdg();
        }
    }

    public final synchronized void zzdh() {
        com.google.android.gms.ads.internal.zzm zzm2 = this.zzg;
        if (zzm2 != null) {
            zzm2.zzdh();
        }
    }

    public final synchronized String zzdi() {
        return this.zzz;
    }

    public final void zzdp(zzazx zzazx) {
        synchronized (this) {
            this.zzB = zzazx.zzj;
        }
        zzba(zzazx.zzj);
    }

    public final void zze(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        com.google.android.gms.ads.internal.util.client.zzm.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzaQ(sb.toString());
    }

    public final synchronized int zzf() {
        return this.zzM;
    }

    public final int zzg() {
        return getMeasuredHeight();
    }

    public final int zzh() {
        return getMeasuredWidth();
    }

    public final Activity zzi() {
        return this.zzb.zza();
    }

    public final zza zzj() {
        return this.zzh;
    }

    public final zzbel zzk() {
        return this.zzJ;
    }

    public final void zzl(String str, JSONObject jSONObject) {
        zzb(str, jSONObject.toString());
    }

    public final zzbem zzm() {
        return this.zzL;
    }

    public final VersionInfoParcel zzn() {
        return this.zzf;
    }

    public final zzcdc zzo() {
        return null;
    }

    public final synchronized zzcey zzp(String str) {
        Map map = this.zzU;
        if (map == null) {
            return null;
        }
        return (zzcey) map.get(str);
    }

    public final synchronized zzchm zzq() {
        return this.zzA;
    }

    public final synchronized String zzr() {
        zzffq zzffq = this.zzl;
        if (zzffq == null) {
            return null;
        }
        return zzffq.zzb;
    }

    public final synchronized void zzt(String str, zzcey zzcey) {
        if (this.zzU == null) {
            this.zzU = new HashMap();
        }
        this.zzU.put(str, zzcey);
    }

    public final void zzu() {
        zzm zzL2 = zzL();
        if (zzL2 != null) {
            zzL2.zzd();
        }
    }

    public final void zzv(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("success", true != z ? SessionDescription.SUPPORTED_SDP_VERSION : "1");
        hashMap.put("duration", Long.toString(j));
        zzd("onCacheAccessComplete", hashMap);
    }

    public final synchronized void zzw() {
        zzbgq zzbgq = this.zzE;
        if (zzbgq != null) {
            zzt.zza.post(new zzdow((zzdoy) zzbgq));
        }
    }

    public final void zzx(int i) {
    }

    public final void zzy(int i) {
    }

    public final void zzz(boolean z) {
        this.zzo.zzD(false);
    }
}
