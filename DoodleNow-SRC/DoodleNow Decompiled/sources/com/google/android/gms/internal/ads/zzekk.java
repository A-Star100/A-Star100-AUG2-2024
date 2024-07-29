package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzekk implements zzgdl {
    private final zzfkn zza;
    private final zzcys zzb;
    private final zzfmp zzc;
    private final zzfmt zzd;
    private final Executor zze;
    private final ScheduledExecutorService zzf;
    private final zzcty zzg;
    private final zzekd zzh;
    private final zzego zzi;
    private final Context zzj;
    private final zzflh zzk;
    private final zzejn zzl;
    private final zzduc zzm;

    zzekk(Context context, zzfkn zzfkn, zzekd zzekd, zzcys zzcys, zzfmp zzfmp, zzfmt zzfmt, zzcty zzcty, Executor executor, ScheduledExecutorService scheduledExecutorService, zzego zzego, zzflh zzflh, zzejn zzejn, zzduc zzduc) {
        this.zzj = context;
        this.zza = zzfkn;
        this.zzh = zzekd;
        this.zzb = zzcys;
        this.zzc = zzfmp;
        this.zzd = zzfmt;
        this.zzg = zzcty;
        this.zze = executor;
        this.zzf = scheduledExecutorService;
        this.zzi = zzego;
        this.zzk = zzflh;
        this.zzl = zzejn;
        this.zzm = zzduc;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        if (((java.lang.Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(com.google.android.gms.internal.ads.zzbdz.zzfv)).booleanValue() == false) goto L_0x0055;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static java.lang.String zzc(com.google.android.gms.internal.ads.zzffz r5) {
        /*
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzfw
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            java.lang.String r1 = "No fill."
            r2 = 1
            if (r2 == r0) goto L_0x0018
            java.lang.String r0 = "No ad config."
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            com.google.android.gms.internal.ads.zzffy r2 = r5.zzb
            com.google.android.gms.internal.ads.zzffq r2 = r2.zzb
            int r2 = r2.zze
            if (r2 == 0) goto L_0x0054
            r3 = 200(0xc8, float:2.8E-43)
            r4 = 300(0x12c, float:4.2E-43)
            if (r2 < r3) goto L_0x003c
            if (r2 >= r4) goto L_0x003c
            com.google.android.gms.internal.ads.zzbdq r2 = com.google.android.gms.internal.ads.zzbdz.zzfv
            com.google.android.gms.internal.ads.zzbdx r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r2 = r3.zza(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 != 0) goto L_0x0054
            goto L_0x0055
        L_0x003c:
            if (r2 < r4) goto L_0x0045
            r0 = 400(0x190, float:5.6E-43)
            if (r2 >= r0) goto L_0x0045
            java.lang.String r1 = "No location header to follow redirect or too many redirects."
            goto L_0x0055
        L_0x0045:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Received error HTTP response code: "
            r0.<init>(r1)
            r0.append(r2)
            java.lang.String r1 = r0.toString()
            goto L_0x0055
        L_0x0054:
            r1 = r0
        L_0x0055:
            com.google.android.gms.internal.ads.zzffy r5 = r5.zzb
            com.google.android.gms.internal.ads.zzffq r5 = r5.zzb
            com.google.android.gms.internal.ads.zzffp r5 = r5.zzi
            if (r5 == 0) goto L_0x0062
            java.lang.String r5 = r5.zza()
            return r5
        L_0x0062:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekk.zzc(com.google.android.gms.internal.ads.zzffz):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture zza(java.lang.Object r9) throws java.lang.Exception {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzffz r9 = (com.google.android.gms.internal.ads.zzffz) r9
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzcc
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0027
            com.google.android.gms.internal.ads.zzffy r0 = r9.zzb
            com.google.android.gms.internal.ads.zzbxd r0 = r0.zzd
            if (r0 == 0) goto L_0x0027
            android.os.Bundle r0 = r0.zzm
            if (r0 == 0) goto L_0x0027
            com.google.android.gms.internal.ads.zzduc r1 = r8.zzm
            android.os.Bundle r1 = r1.zza()
            r1.putAll(r0)
        L_0x0027:
            java.lang.String r0 = zzc(r9)
            com.google.android.gms.internal.ads.zzego r1 = r8.zzi
            com.google.android.gms.internal.ads.zzffy r2 = r9.zzb
            com.google.android.gms.internal.ads.zzffq r2 = r2.zzb
            r1.zzi(r2)
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zzim
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r2 = 3
            if (r1 == 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzffy r1 = r9.zzb
            com.google.android.gms.internal.ads.zzffq r1 = r1.zzb
            int r1 = r1.zze
            if (r1 == 0) goto L_0x0062
            r3 = 200(0xc8, float:2.8E-43)
            if (r1 < r3) goto L_0x0057
            r3 = 300(0x12c, float:4.2E-43)
            if (r1 < r3) goto L_0x0062
        L_0x0057:
            com.google.android.gms.internal.ads.zzekh r9 = new com.google.android.gms.internal.ads.zzekh
            r9.<init>(r2, r0)
            com.google.common.util.concurrent.ListenableFuture r9 = com.google.android.gms.internal.ads.zzgee.zzg(r9)
            goto L_0x018d
        L_0x0062:
            com.google.android.gms.internal.ads.zzffy r0 = r9.zzb
            com.google.android.gms.internal.ads.zzffq r0 = r0.zzb
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zzdv
            com.google.android.gms.internal.ads.zzbdx r3 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r3.zza(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r3 = 1
            if (r1 == 0) goto L_0x008b
            java.lang.String r0 = r0.zzp
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L_0x008b
            com.google.android.gms.internal.ads.zzego r1 = r8.zzi
            com.google.android.gms.internal.ads.zzffy r4 = r9.zzb
            java.util.List r4 = r4.zza
            r1.zzh(r0, r4)
            goto L_0x00d4
        L_0x008b:
            com.google.android.gms.internal.ads.zzffy r0 = r9.zzb
            java.util.List r0 = r0.zza
            java.util.Iterator r0 = r0.iterator()
        L_0x0093:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00d4
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.ads.zzffn r1 = (com.google.android.gms.internal.ads.zzffn) r1
            com.google.android.gms.internal.ads.zzego r4 = r8.zzi
            r4.zzd(r1)
            java.util.List r4 = r1.zza
            java.util.Iterator r4 = r4.iterator()
        L_0x00aa:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x00c7
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzcty r6 = r8.zzg
            int r7 = r1.zzb
            com.google.android.gms.internal.ads.zzegj r5 = r6.zza(r7, r5)
            if (r5 == 0) goto L_0x00aa
            boolean r5 = r5.zzb(r9, r1)
            if (r5 == 0) goto L_0x00aa
            goto L_0x0093
        L_0x00c7:
            com.google.android.gms.internal.ads.zzego r4 = r8.zzi
            r5 = 0
            r7 = 0
            com.google.android.gms.ads.internal.client.zze r7 = com.google.android.gms.internal.ads.zzfhk.zzd(r3, r7, r7)
            r4.zzf(r1, r5, r7)
            goto L_0x0093
        L_0x00d4:
            com.google.android.gms.internal.ads.zzcys r0 = r8.zzb
            com.google.android.gms.internal.ads.zzfmt r1 = r8.zzd
            com.google.android.gms.internal.ads.zzfmp r4 = r8.zzc
            com.google.android.gms.internal.ads.zzcpo r5 = new com.google.android.gms.internal.ads.zzcpo
            r5.<init>(r9, r1, r4)
            java.util.concurrent.Executor r1 = r8.zze
            r0.zzo(r5, r1)
            com.google.android.gms.internal.ads.zzffy r0 = r9.zzb
            com.google.android.gms.internal.ads.zzffq r0 = r0.zzb
            int r0 = r0.zzq
            if (r0 <= r3) goto L_0x00f4
            com.google.android.gms.internal.ads.zzejn r0 = r8.zzl
            com.google.common.util.concurrent.ListenableFuture r9 = r0.zzb(r9)
            goto L_0x018d
        L_0x00f4:
            java.lang.String r0 = zzc(r9)
            com.google.android.gms.internal.ads.zzfkn r1 = r8.zza
            com.google.android.gms.internal.ads.zzfkh r3 = com.google.android.gms.internal.ads.zzfkh.RENDER_CONFIG_INIT
            com.google.android.gms.internal.ads.zzekh r4 = new com.google.android.gms.internal.ads.zzekh
            r4.<init>(r2, r0)
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgee.zzg(r4)
            com.google.android.gms.internal.ads.zzfke r0 = com.google.android.gms.internal.ads.zzfjx.zzc(r0, r3, r1)
            com.google.android.gms.internal.ads.zzfjs r0 = r0.zza()
            com.google.android.gms.internal.ads.zzekd r1 = r8.zzh
            r1.zzl()
            com.google.android.gms.internal.ads.zzffy r1 = r9.zzb
            java.util.List r1 = r1.zza
            java.util.Iterator r1 = r1.iterator()
            r2 = 0
        L_0x011b:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x017d
            java.lang.Object r3 = r1.next()
            com.google.android.gms.internal.ads.zzffn r3 = (com.google.android.gms.internal.ads.zzffn) r3
            java.util.List r4 = r3.zza
            java.util.Iterator r4 = r4.iterator()
        L_0x012d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x017a
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            com.google.android.gms.internal.ads.zzcty r6 = r8.zzg
            int r7 = r3.zzb
            com.google.android.gms.internal.ads.zzegj r6 = r6.zza(r7, r5)
            if (r6 == 0) goto L_0x012d
            boolean r7 = r6.zzb(r9, r3)
            if (r7 == 0) goto L_0x012d
            com.google.android.gms.internal.ads.zzfkn r4 = r8.zza
            com.google.android.gms.internal.ads.zzfkh r7 = com.google.android.gms.internal.ads.zzfkh.RENDER_CONFIG_WATERFALL
            com.google.android.gms.internal.ads.zzfke r0 = r4.zzb(r7, r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r7 = "render-config-"
            r4.<init>(r7)
            r4.append(r2)
            java.lang.String r7 = "-"
            r4.append(r7)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            com.google.android.gms.internal.ads.zzfke r0 = r0.zzh(r4)
            com.google.android.gms.internal.ads.zzeki r4 = new com.google.android.gms.internal.ads.zzeki
            r4.<init>(r8, r3, r9, r6)
            java.lang.Class<java.lang.Throwable> r3 = java.lang.Throwable.class
            com.google.android.gms.internal.ads.zzfke r0 = r0.zzc(r3, r4)
            com.google.android.gms.internal.ads.zzfjs r0 = r0.zza()
        L_0x017a:
            int r2 = r2 + 1
            goto L_0x011b
        L_0x017d:
            com.google.android.gms.internal.ads.zzekd r9 = r8.zzh
            java.util.Objects.requireNonNull(r9)
            com.google.android.gms.internal.ads.zzekj r1 = new com.google.android.gms.internal.ads.zzekj
            r1.<init>(r9)
            java.util.concurrent.Executor r9 = r8.zze
            r0.addListener(r1, r9)
            r9 = r0
        L_0x018d:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekk.zza(java.lang.Object):com.google.common.util.concurrent.ListenableFuture");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzffn zzffn, zzffz zzffz, zzegj zzegj, Throwable th) throws Exception {
        zzfkw zza2 = zzfkv.zza(this.zzj, zzflo.CUI_NAME_ADREQUEST_MEDIATION_ADAPTER);
        zza2.zze(zzffn.zzF);
        zza2.zzi();
        ListenableFuture zzo = zzgee.zzo(zzegj.zza(zzffz, zzffn), (long) zzffn.zzS, TimeUnit.MILLISECONDS, this.zzf);
        this.zzh.zzf(zzffz, zzffn, zzo, this.zzc);
        zzflg.zzb(zzo, this.zzk, zza2);
        return zzo;
    }
}
