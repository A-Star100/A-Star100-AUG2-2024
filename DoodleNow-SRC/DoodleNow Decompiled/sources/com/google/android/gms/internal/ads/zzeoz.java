package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeoz implements zzewq {
    private final boolean zza;

    public zzeoz(boolean z) {
        this.zza = z;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        ((Bundle) obj).putString("adid_p", true != this.zza ? SessionDescription.SUPPORTED_SDP_VERSION : "1");
    }
}
