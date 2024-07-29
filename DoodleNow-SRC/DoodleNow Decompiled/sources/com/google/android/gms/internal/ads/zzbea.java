package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class zzbea {
    static List zza() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzbff.zzc("gad:dynamite_module:experiment_id", ""));
        zzc(arrayList, zzbfq.zza);
        zzc(arrayList, zzbfq.zzb);
        zzc(arrayList, zzbfq.zzc);
        zzc(arrayList, zzbfq.zzd);
        zzc(arrayList, zzbfq.zze);
        zzc(arrayList, zzbfq.zzu);
        zzc(arrayList, zzbfq.zzf);
        zzc(arrayList, zzbfq.zzm);
        zzc(arrayList, zzbfq.zzn);
        zzc(arrayList, zzbfq.zzo);
        zzc(arrayList, zzbfq.zzp);
        zzc(arrayList, zzbfq.zzq);
        zzc(arrayList, zzbfq.zzr);
        zzc(arrayList, zzbfq.zzs);
        zzc(arrayList, zzbfq.zzt);
        zzc(arrayList, zzbfq.zzg);
        zzc(arrayList, zzbfq.zzh);
        zzc(arrayList, zzbfq.zzi);
        zzc(arrayList, zzbfq.zzj);
        zzc(arrayList, zzbfq.zzk);
        zzc(arrayList, zzbfq.zzl);
        return arrayList;
    }

    static List zzb() {
        ArrayList arrayList = new ArrayList();
        zzc(arrayList, zzbgd.zza);
        return arrayList;
    }

    private static void zzc(List list, zzbff zzbff) {
        String str = (String) zzbff.zze();
        if (!TextUtils.isEmpty(str)) {
            list.add(str);
        }
    }
}
