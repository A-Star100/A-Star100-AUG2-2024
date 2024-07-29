package com.google.android.gms.internal.ads;

import android.app.UiModeManager;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfoj {
    private static UiModeManager zza;

    public static zzfne zza() {
        UiModeManager uiModeManager = zza;
        if (uiModeManager == null) {
            return zzfne.OTHER;
        }
        int currentModeType = uiModeManager.getCurrentModeType();
        if (currentModeType == 1) {
            return zzfne.MOBILE;
        }
        if (currentModeType != 4) {
            return zzfne.OTHER;
        }
        return zzfne.CTV;
    }

    public static void zzb(Context context) {
        if (context != null) {
            zza = (UiModeManager) context.getSystemService("uimode");
        }
    }
}
