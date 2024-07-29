package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzexg implements zzewr {
    private final zzg zza;
    private final Context zzb;
    private final zzgep zzc;
    private final ScheduledExecutorService zzd;
    private final zzegh zze;
    private final zzfgi zzf;

    zzexg(zzg zzg, Context context, zzgep zzgep, ScheduledExecutorService scheduledExecutorService, zzegh zzegh, zzfgi zzfgi) {
        this.zza = zzg;
        this.zzb = context;
        this.zzc = zzgep;
        this.zzd = scheduledExecutorService;
        this.zze = zzegh;
        this.zzf = zzfgi;
    }

    public final int zza() {
        return 56;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0038, code lost:
        if (r0.zzd.zzy != com.google.android.gms.ads.RequestConfiguration.PublisherPrivacyPersonalizationState.DISABLED.getValue()) goto L_0x003a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.common.util.concurrent.ListenableFuture zzb() {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzkd
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x008d
            com.google.android.gms.ads.internal.util.zzg r0 = r5.zza
            boolean r0 = r0.zzP()
            if (r0 == 0) goto L_0x008d
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzkg
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x003a
            com.google.android.gms.internal.ads.zzfgi r0 = r5.zzf
            com.google.android.gms.ads.RequestConfiguration$PublisherPrivacyPersonalizationState r1 = com.google.android.gms.ads.RequestConfiguration.PublisherPrivacyPersonalizationState.DISABLED
            int r1 = r1.getValue()
            com.google.android.gms.ads.internal.client.zzl r0 = r0.zzd
            int r0 = r0.zzy
            if (r0 == r1) goto L_0x008d
        L_0x003a:
            com.google.android.gms.internal.ads.zzegh r0 = r5.zze
            r1 = 0
            com.google.common.util.concurrent.ListenableFuture r0 = r0.zza(r1)
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zzke
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            long r1 = (long) r1
            java.util.concurrent.ScheduledExecutorService r3 = r5.zzd
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgee.zzo(r0, r1, r4, r3)
            com.google.android.gms.internal.ads.zzgdv r0 = com.google.android.gms.internal.ads.zzgdv.zzu(r0)
            com.google.android.gms.internal.ads.zzgep r1 = r5.zzc
            com.google.android.gms.internal.ads.zzexe r2 = com.google.android.gms.internal.ads.zzexe.zza
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgee.zzn(r0, r2, r1)
            com.google.android.gms.internal.ads.zzexf r1 = new com.google.android.gms.internal.ads.zzexf
            r1.<init>(r5)
            com.google.android.gms.internal.ads.zzgep r2 = r5.zzc
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgee.zzf(r0, r3, r1, r2)
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zzke
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            long r1 = (long) r1
            java.util.concurrent.ScheduledExecutorService r3 = r5.zzd
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgee.zzo(r0, r1, r4, r3)
            return r0
        L_0x008d:
            com.google.android.gms.internal.ads.zzexi r0 = new com.google.android.gms.internal.ads.zzexi
            r1 = -1
            r2 = 0
            java.lang.String r3 = ""
            r0.<init>(r3, r1, r2)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgee.zzh(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzexg.zzb():com.google.common.util.concurrent.ListenableFuture");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(Throwable th) throws Exception {
        zzexi zzexi;
        zzbvs.zza(this.zzb).zzg(th, "TopicsSignal.fetchTopicsSignal");
        if (th instanceof SecurityException) {
            zzexi = new zzexi("", 2, (zzexh) null);
        } else if (th instanceof IllegalStateException) {
            zzexi = new zzexi("", 3, (zzexh) null);
        } else if (th instanceof IllegalArgumentException) {
            zzexi = new zzexi("", 4, (zzexh) null);
        } else if (th instanceof TimeoutException) {
            zzexi = new zzexi("", 5, (zzexh) null);
        } else {
            zzexi = new zzexi("", 0, (zzexh) null);
        }
        return zzgee.zzh(zzexi);
    }
}
