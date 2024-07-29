package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdmq implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ View zza;
    public final /* synthetic */ zzcgm zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ WindowManager.LayoutParams zzd;
    public final /* synthetic */ int zze;
    public final /* synthetic */ WindowManager zzf;

    public /* synthetic */ zzdmq(View view, zzcgm zzcgm, String str, WindowManager.LayoutParams layoutParams, int i, WindowManager windowManager) {
        this.zza = view;
        this.zzb = zzcgm;
        this.zzc = str;
        this.zzd = layoutParams;
        this.zze = i;
        this.zzf = windowManager;
    }

    public final void onScrollChanged() {
        Rect rect = new Rect();
        if (this.zza.getGlobalVisibleRect(rect)) {
            zzcgm zzcgm = this.zzb;
            if (zzcgm.zzF().getWindowToken() != null) {
                int i = this.zze;
                WindowManager.LayoutParams layoutParams = this.zzd;
                String str = this.zzc;
                if ("1".equals(str) || ExifInterface.GPS_MEASUREMENT_2D.equals(str)) {
                    layoutParams.y = rect.bottom - i;
                } else {
                    layoutParams.y = rect.top - i;
                }
                this.zzf.updateViewLayout(zzcgm.zzF(), layoutParams);
            }
        }
    }
}
