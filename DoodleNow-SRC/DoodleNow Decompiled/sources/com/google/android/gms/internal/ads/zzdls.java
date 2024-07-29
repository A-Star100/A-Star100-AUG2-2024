package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdls extends zzbhn implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzdmu {
    private final WeakReference zza;
    private final Map zzb = new HashMap();
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private zzdkt zze;
    private zzazz zzf;

    public zzdls(View view, HashMap hashMap, HashMap hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzu.zzx();
        zzcce.zza(view, this);
        zzu.zzx();
        zzcce.zzb(view, this);
        this.zza = new WeakReference(view);
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            View view2 = (View) entry.getValue();
            if (view2 != null) {
                this.zzb.put(str, new WeakReference(view2));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !"3011".equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.zzd.putAll(this.zzb);
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            View view3 = (View) entry2.getValue();
            if (view3 != null) {
                this.zzc.put((String) entry2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.zzd.putAll(this.zzc);
        this.zzf = new zzazz(view.getContext(), view);
    }

    public final synchronized void onClick(View view) {
        zzdkt zzdkt = this.zze;
        if (zzdkt != null) {
            zzdkt.zzC(view, zzf(), zzl(), zzm(), true);
        }
    }

    public final synchronized void onGlobalLayout() {
        zzdkt zzdkt = this.zze;
        if (zzdkt != null) {
            zzdkt.zzA(zzf(), zzl(), zzm(), zzdkt.zzW(zzf()));
        }
    }

    public final synchronized void onScrollChanged() {
        zzdkt zzdkt = this.zze;
        if (zzdkt != null) {
            zzdkt.zzA(zzf(), zzl(), zzm(), zzdkt.zzW(zzf()));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzdkt zzdkt = this.zze;
        if (zzdkt != null) {
            zzdkt.zzJ(view, motionEvent, zzf());
        }
        return false;
    }

    public final synchronized void zzb(IObjectWrapper iObjectWrapper) {
        if (this.zze != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzm.zzj("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zze.zzL((View) unwrap);
        }
    }

    public final synchronized void zzc(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzdkt)) {
            zzm.zzj("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        zzdkt zzdkt = this.zze;
        if (zzdkt != null) {
            zzdkt.zzR(this);
        }
        zzdkt zzdkt2 = (zzdkt) unwrap;
        if (zzdkt2.zzS()) {
            this.zze = zzdkt2;
            zzdkt2.zzQ(this);
            this.zze.zzI(zzf());
            return;
        }
        zzm.zzg("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    public final synchronized void zzd() {
        zzdkt zzdkt = this.zze;
        if (zzdkt != null) {
            zzdkt.zzR(this);
            this.zze = null;
        }
    }

    public final View zzf() {
        return (View) this.zza.get();
    }

    public final synchronized View zzg(String str) {
        WeakReference weakReference = (WeakReference) this.zzd.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final FrameLayout zzh() {
        return null;
    }

    public final zzazz zzi() {
        return this.zzf;
    }

    public final synchronized IObjectWrapper zzj() {
        return null;
    }

    public final synchronized String zzk() {
        return "1007";
    }

    public final synchronized Map zzl() {
        return this.zzd;
    }

    public final synchronized Map zzm() {
        return this.zzb;
    }

    public final synchronized Map zzn() {
        return this.zzc;
    }

    public final synchronized JSONObject zzo() {
        return null;
    }

    public final synchronized JSONObject zzp() {
        zzdkt zzdkt = this.zze;
        if (zzdkt == null) {
            return null;
        }
        return zzdkt.zzk(zzf(), zzl(), zzm());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0033, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzq(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0034 }
            r4.<init>(r3)     // Catch:{ all -> 0x0034 }
            java.util.Map r0 = r1.zzd     // Catch:{ all -> 0x0034 }
            r0.put(r2, r4)     // Catch:{ all -> 0x0034 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0034 }
            if (r4 != 0) goto L_0x0032
            java.lang.String r4 = "3011"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0034 }
            if (r4 == 0) goto L_0x001c
            goto L_0x0032
        L_0x001c:
            java.util.Map r4 = r1.zzb     // Catch:{ all -> 0x0034 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0034 }
            r0.<init>(r3)     // Catch:{ all -> 0x0034 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0034 }
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0034 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0034 }
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0034 }
            monitor-exit(r1)
            return
        L_0x0032:
            monitor-exit(r1)
            return
        L_0x0034:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdls.zzq(java.lang.String, android.view.View, boolean):void");
    }
}
