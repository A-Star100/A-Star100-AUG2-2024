package com.google.android.gms.internal.ads;

import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.onesignal.core.internal.database.impl.OneSignalDbContract;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzbts {
    private final zzcgm zza;
    private final String zzb;

    public zzbts(zzcgm zzcgm, String str) {
        this.zza = zzcgm;
        this.zzb = str;
    }

    public final void zzg(int i, int i2, int i3, int i4) {
        try {
            this.zza.zze("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzm.zzh("Error occurred while dispatching default position.", e);
        }
    }

    public final void zzh(String str) {
        try {
            JSONObject put = new JSONObject().put(OneSignalDbContract.NotificationTable.COLUMN_NAME_MESSAGE, str).put("action", this.zzb);
            zzcgm zzcgm = this.zza;
            if (zzcgm != null) {
                zzcgm.zze("onError", put);
            }
        } catch (JSONException e) {
            zzm.zzh("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzi(String str) {
        try {
            this.zza.zze("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzm.zzh("Error occurred while dispatching ready Event.", e);
        }
    }

    public final void zzj(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zza.zze("onScreenInfoChanged", new JSONObject().put("width", i).put("height", i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put(ViewProps.ROTATION, i5));
        } catch (JSONException e) {
            zzm.zzh("Error occurred while obtaining screen information.", e);
        }
    }

    public final void zzk(int i, int i2, int i3, int i4) {
        try {
            this.zza.zze("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put("width", i3).put("height", i4));
        } catch (JSONException e) {
            zzm.zzh("Error occurred while dispatching size change.", e);
        }
    }

    public final void zzl(String str) {
        try {
            this.zza.zze("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzm.zzh("Error occurred while dispatching state change.", e);
        }
    }
}
