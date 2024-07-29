package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdrc implements View.OnTouchListener {
    public final /* synthetic */ zzdrh zza;

    public /* synthetic */ zzdrc(zzdrh zzdrh) {
        this.zza = zzdrh;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.zza.zzh(view, motionEvent);
        return false;
    }
}
