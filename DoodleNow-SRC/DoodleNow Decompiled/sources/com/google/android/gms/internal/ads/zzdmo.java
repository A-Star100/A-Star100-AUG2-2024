package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdmo implements zzbky {
    public final /* synthetic */ zzdms zza;
    public final /* synthetic */ View zzb;
    public final /* synthetic */ WindowManager zzc;

    public /* synthetic */ zzdmo(zzdms zzdms, View view, WindowManager windowManager) {
        this.zza = zzdms;
        this.zzb = view;
        this.zzc = windowManager;
    }

    public final void zza(Object obj, Map map) {
        this.zza.zze(this.zzb, this.zzc, (zzcgm) obj, map);
    }
}
