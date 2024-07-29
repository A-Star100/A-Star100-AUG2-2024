package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzelf implements zzdiu {
    private final Context zza;
    private final zzdri zzb;
    private final zzfgi zzc;
    private final VersionInfoParcel zzd;
    private final zzffn zze;
    private final ListenableFuture zzf;
    private final zzcgm zzg;
    private final zzblb zzh;
    private final boolean zzi;
    private final zzefo zzj;

    zzelf(Context context, zzdri zzdri, zzfgi zzfgi, VersionInfoParcel versionInfoParcel, zzffn zzffn, ListenableFuture listenableFuture, zzcgm zzcgm, zzblb zzblb, boolean z, zzefo zzefo) {
        this.zza = context;
        this.zzb = zzdri;
        this.zzc = zzfgi;
        this.zzd = versionInfoParcel;
        this.zze = zzffn;
        this.zzf = listenableFuture;
        this.zzg = zzcgm;
        this.zzh = zzblb;
        this.zzi = z;
        this.zzj = zzefo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ec  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r22, android.content.Context r23, com.google.android.gms.internal.ads.zzczd r24) {
        /*
            r21 = this;
            r1 = r21
            com.google.common.util.concurrent.ListenableFuture r0 = r1.zzf
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzgee.zzq(r0)
            com.google.android.gms.internal.ads.zzdqn r0 = (com.google.android.gms.internal.ads.zzdqn) r0
            com.google.android.gms.internal.ads.zzffn r2 = r1.zze     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzcgm r3 = r1.zzg     // Catch:{ zzcgy -> 0x0108 }
            boolean r3 = r3.zzaD()     // Catch:{ zzcgy -> 0x0108 }
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzcgm r2 = r1.zzg     // Catch:{ zzcgy -> 0x0108 }
        L_0x0018:
            r11 = r2
            goto L_0x0081
        L_0x001a:
            com.google.android.gms.internal.ads.zzbdq r3 = com.google.android.gms.internal.ads.zzbdz.zzaM     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzbdx r6 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzcgy -> 0x0108 }
            java.lang.Object r3 = r6.zza(r3)     // Catch:{ zzcgy -> 0x0108 }
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch:{ zzcgy -> 0x0108 }
            boolean r3 = r3.booleanValue()     // Catch:{ zzcgy -> 0x0108 }
            if (r3 != 0) goto L_0x002f
            com.google.android.gms.internal.ads.zzcgm r2 = r1.zzg     // Catch:{ zzcgy -> 0x0108 }
            goto L_0x0018
        L_0x002f:
            com.google.android.gms.internal.ads.zzdri r3 = r1.zzb     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzfgi r6 = r1.zzc     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.ads.internal.client.zzq r6 = r6.zze     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzcgm r3 = r3.zza(r6, r5, r5)     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzdgw r6 = r0.zzg()     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzblq.zzb(r3, r6)     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzdrm r6 = new com.google.android.gms.internal.ads.zzdrm     // Catch:{ zzcgy -> 0x0108 }
            r6.<init>()     // Catch:{ zzcgy -> 0x0108 }
            android.content.Context r7 = r1.zza     // Catch:{ zzcgy -> 0x0108 }
            r8 = r3
            android.view.View r8 = (android.view.View) r8     // Catch:{ zzcgy -> 0x0108 }
            r6.zza(r7, r8)     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzdrh r7 = r0.zzl()     // Catch:{ zzcgy -> 0x0108 }
            boolean r8 = r1.zzi     // Catch:{ zzcgy -> 0x0108 }
            if (r8 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzblb r8 = r1.zzh     // Catch:{ zzcgy -> 0x0108 }
            goto L_0x0059
        L_0x0058:
            r8 = r5
        L_0x0059:
            r7.zzi(r3, r4, r8)     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzcic r7 = r3.zzN()     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzeld r8 = new com.google.android.gms.internal.ads.zzeld     // Catch:{ zzcgy -> 0x0108 }
            r8.<init>(r6, r3)     // Catch:{ zzcgy -> 0x0108 }
            r7.zzB(r8)     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzcic r6 = r3.zzN()     // Catch:{ zzcgy -> 0x0108 }
            java.util.Objects.requireNonNull(r3)     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzele r7 = new com.google.android.gms.internal.ads.zzele     // Catch:{ zzcgy -> 0x0108 }
            r7.<init>(r3)     // Catch:{ zzcgy -> 0x0108 }
            r6.zzH(r7)     // Catch:{ zzcgy -> 0x0108 }
            com.google.android.gms.internal.ads.zzffs r2 = r2.zzt     // Catch:{ zzcgy -> 0x0108 }
            java.lang.String r6 = r2.zzb     // Catch:{ zzcgy -> 0x0108 }
            java.lang.String r2 = r2.zza     // Catch:{ zzcgy -> 0x0108 }
            r3.zzac(r6, r2, r5)     // Catch:{ zzcgy -> 0x0108 }
            r11 = r3
        L_0x0081:
            r11.zzao(r4)
            boolean r2 = r1.zzi
            com.google.android.gms.ads.internal.zzk r3 = new com.google.android.gms.ads.internal.zzk
            r6 = 0
            if (r2 == 0) goto L_0x0093
            com.google.android.gms.internal.ads.zzblb r2 = r1.zzh
            boolean r2 = r2.zze(r6)
            r13 = r2
            goto L_0x0094
        L_0x0093:
            r13 = r6
        L_0x0094:
            com.google.android.gms.ads.internal.zzu.zzp()
            android.content.Context r2 = r1.zza
            boolean r7 = r1.zzi
            boolean r14 = com.google.android.gms.ads.internal.util.zzt.zzI(r2)
            if (r7 == 0) goto L_0x00a9
            com.google.android.gms.internal.ads.zzblb r2 = r1.zzh
            boolean r2 = r2.zzd()
            r15 = r2
            goto L_0x00aa
        L_0x00a9:
            r15 = r6
        L_0x00aa:
            boolean r2 = r1.zzi
            if (r2 == 0) goto L_0x00b5
            com.google.android.gms.internal.ads.zzblb r2 = r1.zzh
            float r2 = r2.zza()
            goto L_0x00b6
        L_0x00b5:
            r2 = 0
        L_0x00b6:
            r16 = r2
            com.google.android.gms.internal.ads.zzffn r2 = r1.zze
            r17 = -1
            boolean r6 = r2.zzP
            boolean r2 = r2.zzQ
            r12 = r3
            r18 = r22
            r19 = r6
            r20 = r2
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20)
            if (r24 == 0) goto L_0x00cf
            r24.zzf()
        L_0x00cf:
            com.google.android.gms.ads.internal.zzu.zzi()
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r2 = new com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
            com.google.android.gms.internal.ads.zzdij r9 = r0.zzh()
            com.google.android.gms.internal.ads.zzffn r0 = r1.zze
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r13 = r1.zzd
            int r12 = r0.zzR
            java.lang.String r14 = r0.zzC
            com.google.android.gms.internal.ads.zzffs r6 = r0.zzt
            java.lang.String r15 = r6.zzb
            java.lang.String r6 = r6.zza
            com.google.android.gms.internal.ads.zzfgi r7 = r1.zzc
            boolean r0 = r0.zzaj
            if (r0 == 0) goto L_0x00ee
            com.google.android.gms.internal.ads.zzefo r5 = r1.zzj
        L_0x00ee:
            r20 = r5
            r8 = 0
            r10 = 0
            java.lang.String r0 = r7.zzf
            r7 = r2
            r5 = r15
            r15 = r3
            r16 = r5
            r17 = r6
            r18 = r0
            r19 = r24
            r7.<init>((com.google.android.gms.ads.internal.client.zza) r8, (com.google.android.gms.ads.internal.overlay.zzp) r9, (com.google.android.gms.ads.internal.overlay.zzaa) r10, (com.google.android.gms.internal.ads.zzcgm) r11, (int) r12, (com.google.android.gms.ads.internal.util.client.VersionInfoParcel) r13, (java.lang.String) r14, (com.google.android.gms.ads.internal.zzk) r15, (java.lang.String) r16, (java.lang.String) r17, (java.lang.String) r18, (com.google.android.gms.internal.ads.zzczd) r19, (com.google.android.gms.internal.ads.zzbui) r20)
            r0 = r23
            com.google.android.gms.ads.internal.overlay.zzn.zza(r0, r2, r4)
            return
        L_0x0108:
            r0 = move-exception
            java.lang.String r2 = ""
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzelf.zza(boolean, android.content.Context, com.google.android.gms.internal.ads.zzczd):void");
    }
}
