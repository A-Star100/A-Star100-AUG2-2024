package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.internal.ads.zzcgm;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzi {
    public final int zza;
    public final ViewGroup.LayoutParams zzb;
    public final ViewGroup zzc;
    public final Context zzd;

    public zzi(zzcgm zzcgm) throws zzg {
        this.zzb = zzcgm.getLayoutParams();
        ViewParent parent = zzcgm.getParent();
        this.zzd = zzcgm.zzE();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new zzg("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        this.zzc = viewGroup;
        this.zza = viewGroup.indexOfChild(zzcgm.zzF());
        viewGroup.removeView(zzcgm.zzF());
        zzcgm.zzao(true);
    }
}
