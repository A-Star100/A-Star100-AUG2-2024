package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzac;
import com.google.android.gms.ads.internal.zzu;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcqd implements zzbpj {
    private final Context zza;
    private final zzazu zzb;
    private final PowerManager zzc;

    public zzcqd(Context context, zzazu zzazu) {
        this.zza = context;
        this.zzb = zzazu;
        this.zzc = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzb(zzcqg zzcqg) throws JSONException {
        JSONObject jSONObject;
        Integer num;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzazx zzazx = zzcqg.zzf;
        if (zzazx == null) {
            jSONObject = new JSONObject();
        } else if (this.zzb.zzd() != null) {
            boolean z = zzazx.zza;
            JSONObject jSONObject3 = new JSONObject();
            JSONObject put = jSONObject3.put("afmaVersion", this.zzb.zzb()).put("activeViewJSON", this.zzb.zzd()).put("timestamp", zzcqg.zzd).put("adFormat", this.zzb.zza()).put("hashCode", this.zzb.zzc()).put("isMraid", false);
            boolean z2 = zzcqg.zzc;
            put.put("isStopped", false).put("isPaused", zzcqg.zzb).put("isNative", this.zzb.zze()).put("isScreenOn", this.zzc.isInteractive()).put("appMuted", zzu.zzr().zze()).put("appVolume", (double) zzu.zzr().zza()).put("deviceVolume", (double) zzac.zzb(this.zza.getApplicationContext()));
            if (((Boolean) zzba.zzc().zza(zzbdz.zzfK)).booleanValue()) {
                AudioManager audioManager = (AudioManager) this.zza.getApplicationContext().getSystemService("audio");
                if (audioManager == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(audioManager.getMode());
                }
                if (num != null) {
                    jSONObject3.put("audioMode", num);
                }
            }
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zza.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzazx.zzb).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put(ViewProps.TOP, zzazx.zzc.top).put(ViewProps.BOTTOM, zzazx.zzc.bottom).put("left", zzazx.zzc.left).put("right", zzazx.zzc.right)).put("adBox", new JSONObject().put(ViewProps.TOP, zzazx.zzd.top).put(ViewProps.BOTTOM, zzazx.zzd.bottom).put("left", zzazx.zzd.left).put("right", zzazx.zzd.right)).put("globalVisibleBox", new JSONObject().put(ViewProps.TOP, zzazx.zze.top).put(ViewProps.BOTTOM, zzazx.zze.bottom).put("left", zzazx.zze.left).put("right", zzazx.zze.right)).put("globalVisibleBoxVisible", zzazx.zzf).put("localVisibleBox", new JSONObject().put(ViewProps.TOP, zzazx.zzg.top).put(ViewProps.BOTTOM, zzazx.zzg.bottom).put("left", zzazx.zzg.left).put("right", zzazx.zzg.right)).put("localVisibleBoxVisible", zzazx.zzh).put("hitBox", new JSONObject().put(ViewProps.TOP, zzazx.zzi.top).put(ViewProps.BOTTOM, zzazx.zzi.bottom).put("left", zzazx.zzi.left).put("right", zzazx.zzi.right)).put("screenDensity", (double) this.zza.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzcqg.zza);
            if (((Boolean) zzba.zzc().zza(zzbdz.zzbp)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzazx.zzk;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put(ViewProps.TOP, rect2.top).put(ViewProps.BOTTOM, rect2.bottom).put("left", rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzcqg.zze)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
