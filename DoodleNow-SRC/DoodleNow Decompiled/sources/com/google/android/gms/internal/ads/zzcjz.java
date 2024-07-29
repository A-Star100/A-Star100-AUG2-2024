package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcjz extends zzeye {
    private final zzezl zza;
    private final zzckh zzb;
    private final zzcjz zzc = this;
    private final zzhje zzd;
    private final zzhje zze;
    private final zzhje zzf;
    private final zzhje zzg;
    private final zzhje zzh;
    private final zzhje zzi;
    private final zzhje zzj;
    private final zzhje zzk;
    private final zzhje zzl;
    private final zzhje zzm;
    private final zzhje zzn;

    /* synthetic */ zzcjz(zzckh zzckh, zzezl zzezl, zzcjy zzcjy) {
        this.zzb = zzckh;
        this.zza = zzezl;
        zzezn zzezn = new zzezn(zzezl);
        this.zzd = zzezn;
        zzhje zzc2 = zzhiu.zzc(zzdtc.zza());
        this.zze = zzc2;
        zzhje zzc3 = zzhiu.zzc(zzdta.zza());
        this.zzf = zzc3;
        zzhje zzc4 = zzhiu.zzc(zzdte.zza());
        this.zzg = zzc4;
        zzhje zzc5 = zzhiu.zzc(zzdtg.zza());
        this.zzh = zzc5;
        zzhiy zzc6 = zzhiz.zzc(4);
        zzc6.zzb(zzfkh.GMS_SIGNALS, zzc2);
        zzc6.zzb(zzfkh.BUILD_URL, zzc3);
        zzc6.zzb(zzfkh.HTTP, zzc4);
        zzc6.zzb(zzfkh.PRE_PROCESS, zzc5);
        zzhiz zzc7 = zzc6.zzc();
        this.zzi = zzc7;
        zzhje zzc8 = zzhiu.zzc(new zzdth(zzezn, zzckh.zzh, zzfji.zza(), zzc7));
        this.zzj = zzc8;
        zzhji zza2 = zzhjj.zza(0, 1);
        zza2.zza(zzc8);
        zzhjj zzc9 = zza2.zzc();
        this.zzk = zzc9;
        zzfkq zzfkq = new zzfkq(zzc9);
        this.zzl = zzfkq;
        this.zzm = zzhiu.zzc(new zzfkp(zzfji.zza(), zzckh.zze, zzfkq));
        this.zzn = zzhiu.zzc(new zzfli(zzckh.zzz));
    }

    public final zzewu zza() {
        Context zzb2 = this.zzb.zza.zzb();
        zzhjd.zzb(zzb2);
        zzcav zzcav = new zzcav();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        zzezf zzezf = new zzezf(zzcav, zzgep, zzezm.zza(this.zza));
        zzgep zzgep2 = zzcbr.zza;
        zzhjd.zzb(zzgep2);
        HashSet hashSet = new HashSet();
        hashSet.add(new zzeuz(zzezf, 0, (ScheduledExecutorService) this.zzb.zze.zzb()));
        return new zzewu(zzb2, zzgep2, hashSet, (zzflh) this.zzn.zzb(), (zzduh) this.zzb.zzM.zzb());
    }

    public final zzfkn zzb() {
        return (zzfkn) this.zzm.zzb();
    }
}
