package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhjo extends CustomTabsServiceConnection {
    private final WeakReference zza;

    public zzhjo(zzbew zzbew) {
        this.zza = new WeakReference(zzbew);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbew zzbew = (zzbew) this.zza.get();
        if (zzbew != null) {
            zzbew.zzc(customTabsClient);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzbew zzbew = (zzbew) this.zza.get();
        if (zzbew != null) {
            zzbew.zzd();
        }
    }
}
