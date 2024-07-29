package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzckd extends zzeyg {
    private final zzexu zza;
    private final zzckh zzb;
    private final zzckd zzc = this;
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

    /* synthetic */ zzckd(zzckh zzckh, zzexu zzexu, zzckc zzckc) {
        this.zzb = zzckh;
        this.zza = zzexu;
        this.zzd = zzhiu.zzc(new zzfli(zzckh.zzz));
        zzeyc zzeyc = new zzeyc(zzexu);
        this.zze = zzeyc;
        zzhje zzc2 = zzhiu.zzc(zzdtc.zza());
        this.zzf = zzc2;
        zzhje zzc3 = zzhiu.zzc(zzdta.zza());
        this.zzg = zzc3;
        zzhje zzc4 = zzhiu.zzc(zzdte.zza());
        this.zzh = zzc4;
        zzhje zzc5 = zzhiu.zzc(zzdtg.zza());
        this.zzi = zzc5;
        zzhiy zzc6 = zzhiz.zzc(4);
        zzc6.zzb(zzfkh.GMS_SIGNALS, zzc2);
        zzc6.zzb(zzfkh.BUILD_URL, zzc3);
        zzc6.zzb(zzfkh.HTTP, zzc4);
        zzc6.zzb(zzfkh.PRE_PROCESS, zzc5);
        zzhiz zzc7 = zzc6.zzc();
        this.zzj = zzc7;
        zzhje zzc8 = zzhiu.zzc(new zzdth(zzeyc, zzckh.zzh, zzfji.zza(), zzc7));
        this.zzk = zzc8;
        zzhji zza2 = zzhjj.zza(0, 1);
        zza2.zza(zzc8);
        zzhjj zzc9 = zza2.zzc();
        this.zzl = zzc9;
        zzfkq zzfkq = new zzfkq(zzc9);
        this.zzm = zzfkq;
        this.zzn = zzhiu.zzc(new zzfkp(zzfji.zza(), zzckh.zze, zzfkq));
    }

    public final zzewu zza() {
        Context zzb2 = this.zzb.zza.zzb();
        zzhjd.zzb(zzb2);
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        zzcav zzcav = new zzcav();
        zzgep zzgep2 = zzcbr.zza;
        zzhjd.zzb(zzgep2);
        zzewr zza2 = zzfab.zza(new zzezf(zzcav, zzgep2, zzexv.zza(this.zza)), zzeut.zza(), (ScheduledExecutorService) this.zzb.zze.zzb(), 0);
        Context zzb3 = this.zzb.zza.zzb();
        zzhjd.zzb(zzb3);
        zzewr zzb4 = zzfab.zzb(new zzezp(new zzbut(), (ScheduledExecutorService) this.zzb.zze.zzb(), zzb3), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzcay zzcay = new zzcay();
        Context zzb5 = this.zzb.zza.zzb();
        zzhjd.zzb(zzb5);
        zzgep zzgep3 = zzcbr.zza;
        zzhjd.zzb(zzgep3);
        zzexu zzexu = this.zza;
        zzewr zza3 = zzfac.zza(zzexo.zza(zzcay, zzb5, (ScheduledExecutorService) this.zzb.zze.zzb(), zzgep3, zzexw.zza(zzexu), zzexy.zza(zzexu), zzexz.zza(zzexu)), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzgep zzgep4 = zzcbr.zza;
        zzhjd.zzb(zzgep4);
        zzewr zzc2 = zzfab.zzc(new zzfak(zzgep4), (ScheduledExecutorService) this.zzb.zze.zzb());
        zzezz zzezz = zzezz.zza;
        Context zzb6 = this.zzb.zza.zzb();
        zzhjd.zzb(zzb6);
        String zza4 = zzexv.zza(this.zza);
        zzgep zzgep5 = zzcbr.zza;
        zzhjd.zzb(zzgep5);
        zzeyi zzeyi = new zzeyi((zzbxf) null, zzb6, zza4, zzgep5);
        zzbcm zzbcm = new zzbcm();
        zzgep zzgep6 = zzcbr.zza;
        zzhjd.zzb(zzgep6);
        Context zzb7 = this.zzb.zza.zzb();
        zzhjd.zzb(zzb7);
        zzbdj zzbdj = new zzbdj();
        zzgep zzgep7 = zzcbr.zza;
        zzhjd.zzb(zzgep7);
        zzcay zzcay2 = new zzcay();
        zzgep zzgep8 = zzcbr.zza;
        zzhjd.zzb(zzgep8);
        zzexu zzexu2 = this.zza;
        zzcay zzcay3 = new zzcay();
        zzexu zzexu3 = this.zza;
        zzckh zzckh = this.zzb;
        int zza5 = zzexw.zza(zzexu3);
        Context zzb8 = zzckh.zza.zzb();
        zzhjd.zzb(zzb8);
        zzgep zzgep9 = zzcbr.zza;
        zzhjd.zzb(zzgep9);
        zzgep zzgep10 = zzcbr.zza;
        zzhjd.zzb(zzgep10);
        return new zzewu(zzb2, zzgep, zzfzs.zzs(zza2, zzb4, zza3, zzc2, zzezz, zzeyi, new zzeyx(zzbcm, zzgep6, zzb7), new zzezj(zzbdj, zzgep7, zzexx.zza(this.zza)), new zzexs(zzcay2, zzgep8, zzeya.zza(zzexu2), zzeyb.zza(zzexu2), zzexw.zza(zzexu2)), new zzeyt(zzcay3, zza5, zzb8, (zzcbh) this.zzb.zzad.zzb(), (ScheduledExecutorService) this.zzb.zze.zzb(), zzgep9, zzexv.zza(this.zza)), (zzewr) this.zzb.zzaH.zzb(), zzeyp.zza(zzexv.zza(this.zza), new zzbca(), (zzcbh) this.zzb.zzad.zzb(), (ScheduledExecutorService) this.zzb.zze.zzb(), zzgep10)), (zzflh) this.zzd.zzb(), (zzduh) this.zzb.zzM.zzb());
    }

    public final zzfkn zzb() {
        return (zzfkn) this.zzn.zzb();
    }
}
