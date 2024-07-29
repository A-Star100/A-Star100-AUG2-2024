package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzddj implements zzded {
    public final /* synthetic */ String zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzddj(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final void zza(Object obj) {
        ((AppEventListener) obj).onAppEvent(this.zza, this.zzb);
    }
}
