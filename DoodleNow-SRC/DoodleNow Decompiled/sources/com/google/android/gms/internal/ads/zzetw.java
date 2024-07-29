package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzetw implements zzewr {
    private final zzgep zza;
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set zzd;

    public zzetw(zzgep zzgep, ViewGroup viewGroup, Context context, Set set) {
        this.zza = zzgep;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    public final int zza() {
        return 22;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzetv(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzetx zzc() throws Exception {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfV)).booleanValue() && this.zzb != null && this.zzd.contains("banner")) {
            return new zzetx(Boolean.valueOf(this.zzb.isHardwareAccelerated()));
        }
        boolean z = null;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfW)).booleanValue() && this.zzd.contains("native")) {
            Context context = this.zzc;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                Window window = activity.getWindow();
                boolean z2 = true;
                if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                    try {
                        if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) == 0) {
                            z2 = false;
                        }
                        z = Boolean.valueOf(z2);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                } else {
                    z = true;
                }
                return new zzetx(z);
            }
        }
        return new zzetx((Boolean) null);
    }
}
