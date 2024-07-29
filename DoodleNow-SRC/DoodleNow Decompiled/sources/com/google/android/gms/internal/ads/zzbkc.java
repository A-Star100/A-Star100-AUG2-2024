package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbkc implements zzbky {
    zzbkc() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        zzu.zzp();
        DisplayMetrics zzt = zzt.zzt((WindowManager) zzcgm.getContext().getSystemService("window"));
        int i = zzt.widthPixels;
        int i2 = zzt.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        ((View) zzcgm).getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        zzcgm.zzd("locationReady", hashMap);
        zzm.zzj("GET LOCATION COMPILED");
    }
}
