package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.zzcf;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.nonagon.signalgeneration.zzab;
import com.google.android.gms.ads.nonagon.signalgeneration.zzc;
import com.google.android.gms.ads.nonagon.signalgeneration.zzi;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzcik implements zzcnx {
    @Nullable
    private static zzcik zza;

    private static synchronized zzcik zzD(Context context, @Nullable zzbqo zzbqo, int i, boolean z, int i2, zzcjp zzcjp) {
        synchronized (zzcik.class) {
            zzcik zzcik = zza;
            if (zzcik != null) {
                return zzcik;
            }
            long currentTimeMillis = zzu.zzB().currentTimeMillis();
            zzbdz.zza(context);
            zzfhe zzd = zzfhe.zzd(context);
            VersionInfoParcel zzc = zzd.zzc(241199000, false, i2);
            zzd.zzf(zzbqo);
            zzcld zzcld = new zzcld((zzclc) null);
            zzcil zzcil = new zzcil();
            zzcil.zzf(zzc);
            zzcil.zze(context);
            zzcil.zzd(currentTimeMillis);
            zzcld.zzb(new zzcin(zzcil, (zzcim) null));
            zzcld.zzc(new zzcmq(zzcjp));
            zzcik zza2 = zzcld.zza();
            zzu.zzo().zzu(context, zzc);
            zzu.zzc().zzi(context);
            zzu.zzp().zzl(context);
            zzu.zzp().zzk(context);
            zzd.zza(context);
            zzu.zzb().zzd(context);
            zzu.zzv().zzb(context);
            zza2.zza().zzc();
            zzcae.zzd(context);
            if (((Boolean) zzba.zzc().zza(zzbdz.zzgm)).booleanValue()) {
                if (!((Boolean) zzba.zzc().zza(zzbdz.zzav)).booleanValue()) {
                    new zzeeq(context, zzc, new zzbcx(new zzbdf(context)), new zzedv(new zzedr(context), zza2.zzA())).zzb(zzu.zzo().zzi().zzO());
                }
            }
            zza = zza2;
            return zza2;
        }
    }

    public static zzcik zzb(Context context, @Nullable zzbqo zzbqo, int i) {
        return zzD(context, zzbqo, 241199000, false, i, new zzcjp());
    }

    public abstract zzgep zzA();

    public abstract Executor zzB();

    public abstract ScheduledExecutorService zzC();

    public abstract zzcf zza();

    public abstract zzcna zzc();

    public abstract zzcqz zzd();

    public abstract zzcsl zze();

    public abstract zzdbf zzf();

    public abstract zzdil zzg();

    public abstract zzdjh zzh();

    public abstract zzdqq zzi();

    public abstract zzduh zzj();

    public abstract zzdvq zzk();

    public abstract zzdxf zzl();

    public abstract zzdyc zzm();

    public abstract zzefo zzn();

    public abstract zzc zzo();

    public abstract zzi zzp();

    public abstract zzab zzq();

    public final zzexp zzr(zzbxd zzbxd, int i) {
        return zzs(new zzezs(zzbxd, i));
    }

    /* access modifiers changed from: protected */
    public abstract zzexp zzs(zzezs zzezs);

    public abstract zzfan zzt();

    public abstract zzfcb zzu();

    public abstract zzfds zzv();

    public abstract zzffg zzw();

    public abstract zzfgx zzx();

    public abstract zzfhh zzy();

    public abstract zzflk zzz();
}
