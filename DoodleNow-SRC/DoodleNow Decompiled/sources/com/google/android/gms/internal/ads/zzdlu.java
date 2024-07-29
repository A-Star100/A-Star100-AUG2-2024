package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdlu extends zzbhh implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdmu {
    public static final zzfzn zza = zzfzn.zzp("2011", "1009", "3010");
    private final String zzb;
    private Map zzc = new HashMap();
    private FrameLayout zzd;
    private FrameLayout zze;
    private final zzgep zzf;
    private View zzg;
    private final int zzh;
    private zzdkt zzi;
    private zzazz zzj;
    private IObjectWrapper zzk = null;
    private zzbhb zzl;
    private boolean zzm;
    private boolean zzn = false;
    private GestureDetector zzo;

    public zzdlu(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.zzd = frameLayout;
        this.zze = frameLayout2;
        this.zzh = 241199000;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = "1007";
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = "2009";
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzb = str;
        zzu.zzx();
        zzcce.zza(frameLayout, this);
        zzu.zzx();
        zzcce.zzb(frameLayout, this);
        this.zzf = zzcbr.zze;
        this.zzj = new zzazz(this.zzd.getContext(), this.zzd);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzt(String str) {
        DisplayMetrics displayMetrics;
        FrameLayout frameLayout = new FrameLayout(this.zze.getContext());
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        Context context = this.zze.getContext();
        frameLayout.setClickable(false);
        frameLayout.setFocusable(false);
        if (!TextUtils.isEmpty(str)) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Resources resources = context.getResources();
            if (!(resources == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
                try {
                    byte[] decode = Base64.decode(str, 0);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(BitmapFactory.decodeByteArray(decode, 0, decode.length));
                    bitmapDrawable.setTargetDensity(displayMetrics.densityDpi);
                    bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                    frameLayout.setBackground(bitmapDrawable);
                } catch (IllegalArgumentException e) {
                    zzm.zzk("Encountered invalid base64 watermark.", e);
                }
            }
        }
        this.zze.addView(frameLayout);
    }

    private final synchronized void zzu() {
        this.zzf.execute(new zzdlt(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzv() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzlj     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x0033 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x0033 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0033 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzdkt r0 = r4.zzi     // Catch:{ all -> 0x0033 }
            int r0 = r0.zza()     // Catch:{ all -> 0x0033 }
            if (r0 == 0) goto L_0x0031
            android.view.GestureDetector r0 = new android.view.GestureDetector     // Catch:{ all -> 0x0033 }
            android.widget.FrameLayout r1 = r4.zzd     // Catch:{ all -> 0x0033 }
            android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzdma r2 = new com.google.android.gms.internal.ads.zzdma     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzdkt r3 = r4.zzi     // Catch:{ all -> 0x0033 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0033 }
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0033 }
            r4.zzo = r0     // Catch:{ all -> 0x0033 }
            monitor-exit(r4)
            return
        L_0x0031:
            monitor-exit(r4)
            return
        L_0x0033:
            r0 = move-exception
            monitor-exit(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlu.zzv():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onClick(android.view.View r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            com.google.android.gms.internal.ads.zzdkt r0 = r7.zzi     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0023
            boolean r0 = r0.zzT()     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zzdkt r0 = r7.zzi     // Catch:{ all -> 0x0025 }
            r0.zzu()     // Catch:{ all -> 0x0025 }
            com.google.android.gms.internal.ads.zzdkt r1 = r7.zzi     // Catch:{ all -> 0x0025 }
            android.widget.FrameLayout r3 = r7.zzd     // Catch:{ all -> 0x0025 }
            java.util.Map r4 = r7.zzl()     // Catch:{ all -> 0x0025 }
            java.util.Map r5 = r7.zzm()     // Catch:{ all -> 0x0025 }
            r6 = 0
            r2 = r8
            r1.zzC(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0025 }
            monitor-exit(r7)
            return
        L_0x0023:
            monitor-exit(r7)
            return
        L_0x0025:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlu.onClick(android.view.View):void");
    }

    public final synchronized void onGlobalLayout() {
        zzdkt zzdkt = this.zzi;
        if (zzdkt != null) {
            FrameLayout frameLayout = this.zzd;
            zzdkt.zzA(frameLayout, zzl(), zzm(), zzdkt.zzW(frameLayout));
        }
    }

    public final synchronized void onScrollChanged() {
        zzdkt zzdkt = this.zzi;
        if (zzdkt != null) {
            FrameLayout frameLayout = this.zzd;
            zzdkt.zzA(frameLayout, zzl(), zzm(), zzdkt.zzW(frameLayout));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdkt zzdkt = this.zzi;
        if (zzdkt != null) {
            zzdkt.zzJ(view, motionEvent, this.zzd);
            if (!(!((Boolean) zzba.zzc().zza(zzbdz.zzlj)).booleanValue() || this.zzo == null || this.zzi.zza() == 0)) {
                this.zzo.onTouchEvent(motionEvent);
            }
        }
        return false;
    }

    public final synchronized IObjectWrapper zzb(String str) {
        return ObjectWrapper.wrap(zzg(str));
    }

    public final synchronized void zzc() {
        if (!this.zzn) {
            zzdkt zzdkt = this.zzi;
            if (zzdkt != null) {
                zzdkt.zzR(this);
                this.zzi = null;
            }
            this.zzc.clear();
            this.zzd.removeAllViews();
            this.zze.removeAllViews();
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzg = null;
            this.zzj = null;
            this.zzn = true;
        }
    }

    public final void zzd(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzd, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzdv(String str, IObjectWrapper iObjectWrapper) {
        zzq(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    public final synchronized void zzdw(IObjectWrapper iObjectWrapper) {
        this.zzi.zzL((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzdx(com.google.android.gms.internal.ads.zzbhb r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzn     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0006
            goto L_0x0018
        L_0x0006:
            r0 = 1
            r1.zzm = r0     // Catch:{ all -> 0x001a }
            r1.zzl = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.ads.zzdkt r0 = r1.zzi     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x0018
            com.google.android.gms.internal.ads.zzdkv r0 = r0.zzc()     // Catch:{ all -> 0x001a }
            r0.zzb(r2)     // Catch:{ all -> 0x001a }
            monitor-exit(r1)
            return
        L_0x0018:
            monitor-exit(r1)
            return
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlu.zzdx(com.google.android.gms.internal.ads.zzbhb):void");
    }

    public final synchronized void zzdy(IObjectWrapper iObjectWrapper) {
        if (!this.zzn) {
            this.zzk = iObjectWrapper;
        }
    }

    public final synchronized void zzdz(IObjectWrapper iObjectWrapper) {
        if (!this.zzn) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof zzdkt)) {
                zzm.zzj("Not an instance of native engine. This is most likely a transient error");
                return;
            }
            zzdkt zzdkt = this.zzi;
            if (zzdkt != null) {
                zzdkt.zzR(this);
            }
            zzu();
            zzdkt zzdkt2 = (zzdkt) unwrap;
            this.zzi = zzdkt2;
            zzdkt2.zzQ(this);
            this.zzi.zzI(this.zzd);
            this.zzi.zzt(this.zze);
            if (this.zzm) {
                this.zzi.zzc().zzb(this.zzl);
            }
            if (((Boolean) zzba.zzc().zza(zzbdz.zzdQ)).booleanValue() && !TextUtils.isEmpty(this.zzi.zzg())) {
                zzt(this.zzi.zzg());
            }
            zzv();
        }
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) {
    }

    public final /* synthetic */ View zzf() {
        return this.zzd;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized android.view.View zzg(java.lang.String r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzn     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0006
            goto L_0x0018
        L_0x0006:
            java.util.Map r0 = r1.zzc     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001b }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x001b }
            if (r2 == 0) goto L_0x0018
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x001b }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x001b }
            monitor-exit(r1)
            return r2
        L_0x0018:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlu.zzg(java.lang.String):android.view.View");
    }

    public final FrameLayout zzh() {
        return this.zze;
    }

    public final zzazz zzi() {
        return this.zzj;
    }

    public final IObjectWrapper zzj() {
        return this.zzk;
    }

    public final synchronized String zzk() {
        return this.zzb;
    }

    public final synchronized Map zzl() {
        return this.zzc;
    }

    public final synchronized Map zzm() {
        return this.zzc;
    }

    public final synchronized Map zzn() {
        return null;
    }

    public final synchronized JSONObject zzo() {
        zzdkt zzdkt = this.zzi;
        if (zzdkt == null) {
            return null;
        }
        return zzdkt.zzi(this.zzd, zzl(), zzm());
    }

    public final synchronized JSONObject zzp() {
        zzdkt zzdkt = this.zzi;
        if (zzdkt == null) {
            return null;
        }
        return zzdkt.zzk(this.zzd, zzl(), zzm());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzq(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.zzn     // Catch:{ all -> 0x003f }
            if (r4 == 0) goto L_0x0006
            goto L_0x003d
        L_0x0006:
            if (r3 != 0) goto L_0x000f
            java.util.Map r3 = r1.zzc     // Catch:{ all -> 0x003f }
            r3.remove(r2)     // Catch:{ all -> 0x003f }
            monitor-exit(r1)
            return
        L_0x000f:
            java.util.Map r4 = r1.zzc     // Catch:{ all -> 0x003f }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x003f }
            r0.<init>(r3)     // Catch:{ all -> 0x003f }
            r4.put(r2, r0)     // Catch:{ all -> 0x003f }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x003f }
            if (r4 != 0) goto L_0x003d
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x003f }
            if (r2 != 0) goto L_0x003d
            int r2 = r1.zzh     // Catch:{ all -> 0x003f }
            boolean r2 = com.google.android.gms.ads.internal.util.zzbz.zzi(r2)     // Catch:{ all -> 0x003f }
            if (r2 == 0) goto L_0x0034
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x003f }
        L_0x0034:
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x003f }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x003f }
            monitor-exit(r1)
            return
        L_0x003d:
            monitor-exit(r1)
            return
        L_0x003f:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdlu.zzq(java.lang.String, android.view.View, boolean):void");
    }

    public final FrameLayout zzr() {
        return this.zzd;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzs() {
        if (this.zzg == null) {
            View view = new View(this.zzd.getContext());
            this.zzg = view;
            view.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzd != this.zzg.getParent()) {
            this.zzd.addView(this.zzg);
        }
    }
}
