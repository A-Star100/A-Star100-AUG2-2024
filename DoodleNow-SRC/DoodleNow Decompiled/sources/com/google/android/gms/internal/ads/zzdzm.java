package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdzm implements zzeak {
    /* access modifiers changed from: private */
    public static final Pattern zza = Pattern.compile("Received error HTTP response code: (.*)");
    private final zzdyn zzb;
    private final zzgep zzc;
    private final zzfgi zzd;
    private final ScheduledExecutorService zze;
    /* access modifiers changed from: private */
    public final zzedz zzf;
    private final zzflh zzg;
    private final Context zzh;

    zzdzm(Context context, zzfgi zzfgi, zzdyn zzdyn, zzgep zzgep, ScheduledExecutorService scheduledExecutorService, zzedz zzedz, zzflh zzflh) {
        this.zzh = context;
        this.zzd = zzfgi;
        this.zzb = zzdyn;
        this.zzc = zzgep;
        this.zze = scheduledExecutorService;
        this.zzf = zzedz;
        this.zzg = zzflh;
    }

    public final ListenableFuture zzb(zzbxd zzbxd) {
        Context context = this.zzh;
        ListenableFuture zzc2 = this.zzb.zzc(zzbxd);
        zzfkw zza2 = zzfkv.zza(context, zzflo.CUI_NAME_ADREQUEST_PARSERESPONSE);
        zzflg.zze(zzc2, zza2);
        ListenableFuture zzn = zzgee.zzn(zzc2, new zzdzj(this), this.zzc);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfx)).booleanValue()) {
            zzbdq zzbdq = zzbdz.zzfz;
            zzn = zzgee.zzf(zzgee.zzo(zzn, (long) ((Integer) zzba.zzc().zza(zzbdq)).intValue(), TimeUnit.SECONDS, this.zze), TimeoutException.class, zzdzk.zza, zzcbr.zzf);
        }
        zzflg.zzb(zzn, this.zzg, zza2);
        zzgee.zzr(zzn, new zzdzl(this), zzcbr.zzf);
        return zzn;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(zzeam zzeam) throws Exception {
        return zzgee.zzh(new zzffz(new zzffw(this.zzd), zzffy.zza(new InputStreamReader(zzeam.zzb()), zzeam.zza())));
    }
}
