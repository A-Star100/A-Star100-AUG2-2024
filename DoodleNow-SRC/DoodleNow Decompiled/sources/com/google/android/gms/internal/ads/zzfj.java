package com.google.android.gms.internal.ads;

import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfj extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
    private final zzfm zza;

    public zzfj(zzfm zzfm) {
        this.zza = zzfm;
    }

    public final void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
        int m = telephonyDisplayInfo.getOverrideNetworkType();
        int i = 5;
        boolean z = m == 3 || m == 4 || m == 5;
        zzfm zzfm = this.zza;
        if (true == z) {
            i = 10;
        }
        zzfm.zzc(zzfm, i);
    }
}
