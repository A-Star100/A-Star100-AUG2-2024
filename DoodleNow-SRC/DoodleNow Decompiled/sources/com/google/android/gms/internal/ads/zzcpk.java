package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.InputEvent;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcpk {
    zzbvu zza;
    zzbvu zzb;
    /* access modifiers changed from: private */
    public final Context zzc;
    private final zzg zzd;
    private final zzegf zze;
    private final zzdrn zzf;
    /* access modifiers changed from: private */
    public final zzgep zzg;
    private final Executor zzh;
    private final ScheduledExecutorService zzi;

    zzcpk(Context context, zzg zzg2, zzegf zzegf, zzdrn zzdrn, zzgep zzgep, zzgep zzgep2, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = context;
        this.zzd = zzg2;
        this.zze = zzegf;
        this.zzf = zzdrn;
        this.zzg = zzgep;
        this.zzh = zzgep2;
        this.zzi = scheduledExecutorService;
    }

    public static boolean zzj(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains((CharSequence) zzba.zzc().zza(zzbdz.zzjV));
    }

    private final ListenableFuture zzk(String str, @Nullable InputEvent inputEvent, Random random) {
        if (!str.contains((CharSequence) zzba.zzc().zza(zzbdz.zzjV)) || this.zzd.zzO()) {
            return zzgee.zzh(str);
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        long nextInt = (long) random.nextInt(Integer.MAX_VALUE);
        buildUpon.appendQueryParameter((String) zzba.zzc().zza(zzbdz.zzjW), String.valueOf(nextInt));
        if (inputEvent == null) {
            buildUpon.appendQueryParameter((String) zzba.zzc().zza(zzbdz.zzjX), "11");
            return zzgee.zzh(buildUpon.toString());
        }
        return zzgee.zzf(zzgee.zzn(zzgdv.zzu(this.zze.zza()), new zzcpe(this, buildUpon, str, inputEvent), this.zzh), Throwable.class, new zzcpf(this, buildUpon), this.zzg);
    }

    public final ListenableFuture zzb(String str, Random random) {
        if (TextUtils.isEmpty(str)) {
            return zzgee.zzh(str);
        }
        return zzgee.zzf(zzk(str, this.zzf.zza(), random), Throwable.class, new zzcpb(this, str), this.zzg);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(String str, Throwable th) throws Exception {
        this.zzg.zza(new zzcpd(this, th));
        return zzgee.zzh(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzd(Uri.Builder builder, String str, InputEvent inputEvent, Integer num) throws Exception {
        if (num.intValue() == 1) {
            Uri.Builder buildUpon = builder.build().buildUpon();
            buildUpon.appendQueryParameter((String) zzba.zzc().zza(zzbdz.zzjY), "1");
            buildUpon.appendQueryParameter((String) zzba.zzc().zza(zzbdz.zzjX), "12");
            if (str.contains((CharSequence) zzba.zzc().zza(zzbdz.zzjZ))) {
                buildUpon.authority((String) zzba.zzc().zza(zzbdz.zzka));
            }
            return zzgee.zzn(zzgdv.zzu(this.zze.zzb(buildUpon.build(), inputEvent)), new zzcpg(builder), this.zzh);
        }
        builder.appendQueryParameter((String) zzba.zzc().zza(zzbdz.zzjX), "10");
        return zzgee.zzh(builder.toString());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zze(Uri.Builder builder, Throwable th) throws Exception {
        this.zzg.zza(new zzcpc(this, th));
        builder.appendQueryParameter((String) zzba.zzc().zza(zzbdz.zzjX), "9");
        return zzgee.zzh(builder.toString());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkc)).booleanValue()) {
            zzbvu zzc2 = zzbvs.zzc(this.zzc);
            this.zzb = zzc2;
            zzc2.zzg(th, "AttributionReporting.getUpdatedUrlAndRegisterSource");
            return;
        }
        zzbvu zza2 = zzbvs.zza(this.zzc);
        this.zza = zza2;
        zza2.zzg(th, "AttributionReportingSampled.getUpdatedUrlAndRegisterSource");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkc)).booleanValue()) {
            zzbvu zzc2 = zzbvs.zzc(this.zzc);
            this.zzb = zzc2;
            zzc2.zzg(th, "AttributionReporting");
            return;
        }
        zzbvu zza2 = zzbvs.zza(this.zzc);
        this.zza = zza2;
        zza2.zzg(th, "AttributionReportingSampled");
    }

    public final void zzi(String str, zzfmt zzfmt, Random random) {
        if (!TextUtils.isEmpty(str)) {
            ListenableFuture zzk = zzk(str, this.zzf.zza(), random);
            zzbdq zzbdq = zzbdz.zzkb;
            zzgee.zzr(zzgee.zzo(zzk, (long) ((Integer) zzba.zzc().zza(zzbdq)).intValue(), TimeUnit.MILLISECONDS, this.zzi), new zzcpj(this, zzfmt, str), this.zzg);
        }
    }
}
