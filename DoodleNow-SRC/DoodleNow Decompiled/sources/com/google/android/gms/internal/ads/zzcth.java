package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.core.view.ViewCompat;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.zzu;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcth extends FrameLayout implements ViewTreeObserver.OnScrollChangedListener, ViewTreeObserver.OnGlobalLayoutListener {
    private final Context zza;
    private View zzb;

    private zzcth(Context context) {
        super(context);
        this.zza = context;
    }

    public static zzcth zza(Context context, View view, zzffn zzffn) {
        Resources resources;
        DisplayMetrics displayMetrics;
        zzcth zzcth = new zzcth(context);
        if (!(zzffn.zzv.isEmpty() || (resources = zzcth.zza.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null)) {
            zzffo zzffo = (zzffo) zzffn.zzv.get(0);
            zzcth.setLayoutParams(new FrameLayout.LayoutParams((int) (((float) zzffo.zza) * displayMetrics.density), (int) (((float) zzffo.zzb) * displayMetrics.density)));
        }
        zzcth.zzb = view;
        zzcth.addView(view);
        zzu.zzx();
        zzcce.zzb(zzcth, zzcth);
        zzu.zzx();
        zzcce.zza(zzcth, zzcth);
        JSONObject jSONObject = zzffn.zzai;
        RelativeLayout relativeLayout = new RelativeLayout(zzcth.zza);
        JSONObject optJSONObject = jSONObject.optJSONObject("header");
        if (optJSONObject != null) {
            zzcth.zzc(optJSONObject, relativeLayout, 10);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("footer");
        if (optJSONObject2 != null) {
            zzcth.zzc(optJSONObject2, relativeLayout, 12);
        }
        zzcth.addView(relativeLayout);
        return zzcth;
    }

    private final int zzb(double d) {
        zzay.zzb();
        return zzf.zzy(this.zza, (int) d);
    }

    private final void zzc(JSONObject jSONObject, RelativeLayout relativeLayout, int i) {
        TextView textView = new TextView(this.zza);
        textView.setTextColor(-1);
        textView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        textView.setGravity(17);
        textView.setText(jSONObject.optString("text", ""));
        textView.setTextSize((float) jSONObject.optDouble("text_size", 11.0d));
        int zzb2 = zzb(jSONObject.optDouble(ViewProps.PADDING, AudioStats.AUDIO_AMPLITUDE_NONE));
        textView.setPadding(0, zzb2, 0, zzb2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, zzb(jSONObject.optDouble("height", 15.0d)));
        layoutParams.addRule(i);
        relativeLayout.addView(textView, layoutParams);
    }

    public final void onGlobalLayout() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }

    public final void onScrollChanged() {
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        this.zzb.setY((float) (-iArr[1]));
    }
}
