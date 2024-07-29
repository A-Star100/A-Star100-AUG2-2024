package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import androidx.browser.customtabs.CustomTabsCallback;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbex extends CustomTabsCallback {
    private final AtomicBoolean zza = new AtomicBoolean(false);
    private final List zzb;
    private final zzbfa zzc;
    private final CustomTabsCallback zzd;

    zzbex(zzbfa zzbfa, CustomTabsCallback customTabsCallback) {
        this.zzd = customTabsCallback;
        this.zzc = zzbfa;
        this.zzb = Arrays.asList(((String) zzba.zzc().zza(zzbdz.zzjJ)).split(f.a));
    }

    public final void extraCallback(String str, Bundle bundle) {
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            customTabsCallback.extraCallback(str, bundle);
        }
    }

    public final Bundle extraCallbackWithResult(String str, Bundle bundle) {
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            return customTabsCallback.extraCallbackWithResult(str, bundle);
        }
        return null;
    }

    public final void onActivityResized(int i, int i2, Bundle bundle) {
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            customTabsCallback.onActivityResized(i, i2, bundle);
        }
    }

    public final void onMessageChannelReady(Bundle bundle) {
        this.zza.set(false);
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            customTabsCallback.onMessageChannelReady(bundle);
        }
    }

    public final void onNavigationEvent(int i, Bundle bundle) {
        List list;
        this.zza.set(false);
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            customTabsCallback.onNavigationEvent(i, bundle);
        }
        this.zzc.zzi(zzu.zzB().currentTimeMillis());
        if (this.zzc != null && (list = this.zzb) != null && list.contains(String.valueOf(i))) {
            this.zzc.zzf();
        }
    }

    public final void onPostMessage(String str, Bundle bundle) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optInt("gpa", -1) == 0) {
                this.zza.set(true);
                this.zzc.zzh(jSONObject.getString("paw_id"));
            }
        } catch (JSONException e) {
            zze.zzb("Message is not in JSON format: ", e);
        }
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            customTabsCallback.onPostMessage(str, bundle);
        }
    }

    public final void onRelationshipValidationResult(int i, Uri uri, boolean z, Bundle bundle) {
        CustomTabsCallback customTabsCallback = this.zzd;
        if (customTabsCallback != null) {
            customTabsCallback.onRelationshipValidationResult(i, uri, z, bundle);
        }
    }

    public final Boolean zza() {
        return Boolean.valueOf(this.zza.get());
    }
}
