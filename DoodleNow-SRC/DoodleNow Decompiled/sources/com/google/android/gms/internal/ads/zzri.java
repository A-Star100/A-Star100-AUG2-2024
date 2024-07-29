package com.google.android.gms.internal.ads;

import android.media.AudioRouting;
import android.media.AudioRouting$OnRoutingChangedListener;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzri implements AudioRouting$OnRoutingChangedListener {
    public final /* synthetic */ zzrj zza;

    public /* synthetic */ zzri(zzrj zzrj) {
        this.zza = zzrj;
    }

    public final void onRoutingChanged(AudioRouting audioRouting) {
        this.zza.zzc(audioRouting);
    }
}
