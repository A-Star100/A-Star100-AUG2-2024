package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfad implements zzhiv {
    public static zzewu zza(Context context, zzcav zzcav, zzcaw zzcaw, Object obj, zzexs zzexs, zzezj zzezj, zzhip zzhip, zzhip zzhip2, zzhip zzhip3, zzhip zzhip4, zzhip zzhip5, zzhip zzhip6, zzhip zzhip7, zzhip zzhip8, zzhip zzhip9, Executor executor, zzflh zzflh, zzduh zzduh) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzezc) obj);
        zzexs zzexs2 = zzexs;
        hashSet.add(zzexs);
        zzezj zzezj2 = zzezj;
        hashSet.add(zzezj);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfM)).booleanValue()) {
            hashSet.add((zzewr) zzhip.zzb());
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfN)).booleanValue()) {
            hashSet.add((zzewr) zzhip2.zzb());
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfO)).booleanValue()) {
            hashSet.add((zzewr) zzhip3.zzb());
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfP)).booleanValue()) {
            hashSet.add((zzewr) zzhip4.zzb());
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfT)).booleanValue()) {
            hashSet.add((zzewr) zzhip6.zzb());
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfU)).booleanValue()) {
            hashSet.add((zzewr) zzhip7.zzb());
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcL)).booleanValue()) {
            hashSet.add((zzewr) zzhip9.zzb());
        }
        return new zzewu(context, executor, hashSet, zzflh, zzduh);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }
}
