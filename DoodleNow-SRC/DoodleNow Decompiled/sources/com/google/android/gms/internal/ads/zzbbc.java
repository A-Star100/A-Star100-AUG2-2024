package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.client.zzm;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbbc {
    private final int zza;
    private final zzbaz zzb = new zzbbe();

    public zzbbc(int i) {
        this.zza = i;
    }

    public final String zza(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            sb.append(((String) arrayList.get(i)).toLowerCase(Locale.US));
            sb.append(10);
        }
        String[] split = sb.toString().split("\n");
        if (split.length == 0) {
            return "";
        }
        zzbbb zzbbb = new zzbbb();
        PriorityQueue priorityQueue = new PriorityQueue(this.zza, new zzbba(this));
        for (String zzb2 : split) {
            String[] zzb3 = zzbbd.zzb(zzb2, false);
            if (zzb3.length != 0) {
                zzbbh.zzc(zzb3, this.zza, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzbbb.zzb.write(this.zzb.zzb(((zzbbg) it.next()).zzb));
            } catch (IOException e) {
                zzm.zzh("Error while writing hash to byteStream", e);
            }
        }
        return zzbbb.toString();
    }
}
