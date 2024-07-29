package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfgo {
    public static zzq zza(Context context, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzffo zzffo = (zzffo) it.next();
            if (zzffo.zzc) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(zzffo.zza, zzffo.zzb));
            }
        }
        return new zzq(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzffo zzb(zzq zzq) {
        return zzq.zzi ? new zzffo(-3, 0, true) : new zzffo(zzq.zze, zzq.zzb, false);
    }
}
