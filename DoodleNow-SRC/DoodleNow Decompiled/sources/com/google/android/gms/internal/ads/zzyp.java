package com.google.android.gms.internal.ads;

import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzyp implements Spatializer$OnSpatializerStateChangedListener {
    final /* synthetic */ zzyx zza;

    zzyp(zzyq zzyq, zzyx zzyx) {
        this.zza = zzyx;
    }

    public final void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
        this.zza.zzv();
    }

    public final void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
        this.zza.zzv();
    }
}
