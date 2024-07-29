package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdms {
    private final zzdri zza;
    private final zzdpx zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdms(zzdri zzdri, zzdpx zzdpx) {
        this.zza = zzdri;
        this.zzb = zzdpx;
    }

    private static final int zzf(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzay.zzb();
        return zzf.zzy(context, i);
    }

    public final View zza(View view, WindowManager windowManager) throws zzcgy {
        zzcgm zza2 = this.zza.zza(zzq.zzc(), (zzffn) null, (zzffq) null);
        View view2 = (View) zza2;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zza2.zzae("/sendMessageToSdk", new zzdmm(this));
        zza2.zzae("/hideValidatorOverlay", new zzdmn(this, windowManager, view));
        zza2.zzae("/open", new zzblk((zzb) null, (zzbtm) null, (zzefd) null, (zzduh) null, (zzcpk) null));
        this.zzb.zzm(new WeakReference(zza2), "/loadNativeAdPolicyViolations", new zzdmo(this, view, windowManager));
        this.zzb.zzm(new WeakReference(zza2), "/showValidatorOverlay", zzdmp.zza);
        return view2;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcgm zzcgm, Map map) {
        this.zzb.zzj("sendMessageToNativeJs", map);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(WindowManager windowManager, View view, zzcgm zzcgm, Map map) {
        zzm.zze("Hide native ad policy validator overlay.");
        zzcgm.zzF().setVisibility(8);
        if (zzcgm.zzF().getWindowToken() != null) {
            windowManager.removeView(zzcgm.zzF());
        }
        zzcgm.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzc);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Map map, boolean z, int i, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzj("sendMessageToNativeJs", hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(View view, WindowManager windowManager, zzcgm zzcgm, Map map) {
        int i;
        zzcgm.zzN().zzB(new zzdmr(this, map));
        if (map != null) {
            Context context = view.getContext();
            int zzf = zzf(context, (String) map.get("validator_width"), ((Integer) zzba.zzc().zza(zzbdz.zzia)).intValue());
            int zzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) zzba.zzc().zza(zzbdz.zzib)).intValue());
            int zzf3 = zzf(context, (String) map.get("validator_x"), 0);
            int zzf4 = zzf(context, (String) map.get("validator_y"), 0);
            zzcgm.zzah(zzcie.zzb(zzf, zzf2));
            try {
                zzcgm.zzG().getSettings().setUseWideViewPort(((Boolean) zzba.zzc().zza(zzbdz.zzic)).booleanValue());
                zzcgm.zzG().getSettings().setLoadWithOverviewMode(((Boolean) zzba.zzc().zza(zzbdz.zzid)).booleanValue());
            } catch (NullPointerException unused) {
            }
            WindowManager.LayoutParams zzb2 = zzbz.zzb();
            zzb2.x = zzf3;
            zzb2.y = zzf4;
            windowManager.updateViewLayout(zzcgm.zzF(), zzb2);
            String str = (String) map.get("orientation");
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                if ("1".equals(str) || ExifInterface.GPS_MEASUREMENT_2D.equals(str)) {
                    i = rect.bottom;
                } else {
                    i = rect.top;
                }
                this.zzc = new zzdmq(view, zzcgm, str, zzb2, i - zzf4, windowManager);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.zzc);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzcgm.loadUrl(str2);
            }
        }
    }
}
