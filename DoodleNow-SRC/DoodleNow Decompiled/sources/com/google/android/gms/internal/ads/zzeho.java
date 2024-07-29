package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.zzb;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeho implements zzegp {
    private final Context zza;
    private final zzcsm zzb;
    private final Executor zzc;

    public zzeho(Context context, zzcsm zzcsm, Executor executor) {
        this.zza = context;
        this.zzb = zzcsm;
        this.zzc = executor;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: android.view.View} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ java.lang.Object zza(com.google.android.gms.internal.ads.zzffz r7, com.google.android.gms.internal.ads.zzffn r8, com.google.android.gms.internal.ads.zzegm r9) throws com.google.android.gms.internal.ads.zzfgp, com.google.android.gms.internal.ads.zzekh {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzhN
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r0 = r1.zza(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L_0x0077
            boolean r0 = r8.zzah
            if (r0 == 0) goto L_0x0077
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfhg r0 = (com.google.android.gms.internal.ads.zzfhg) r0
            com.google.android.gms.internal.ads.zzbqx r0 = r0.zzc()
            if (r0 == 0) goto L_0x0067
            com.google.android.gms.dynamic.IObjectWrapper r2 = r0.zze()     // Catch:{ RemoteException -> 0x0060 }
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x0060 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ RemoteException -> 0x0060 }
            boolean r0 = r0.zzf()     // Catch:{ RemoteException -> 0x0060 }
            if (r2 == 0) goto L_0x0053
            if (r0 == 0) goto L_0x007f
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgee.zzh(r1)
            com.google.android.gms.internal.ads.zzehm r3 = new com.google.android.gms.internal.ads.zzehm
            r3.<init>(r6, r2, r8)
            com.google.android.gms.internal.ads.zzgep r2 = com.google.android.gms.internal.ads.zzcbr.zze
            com.google.common.util.concurrent.ListenableFuture r0 = com.google.android.gms.internal.ads.zzgee.zzn(r0, r3, r2)
            java.lang.Object r0 = r0.get()     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            r2 = r0
            android.view.View r2 = (android.view.View) r2     // Catch:{ InterruptedException -> 0x004c, ExecutionException -> 0x004a }
            goto L_0x007f
        L_0x004a:
            r7 = move-exception
            goto L_0x004d
        L_0x004c:
            r7 = move-exception
        L_0x004d:
            com.google.android.gms.internal.ads.zzfgp r8 = new com.google.android.gms.internal.ads.zzfgp
            r8.<init>(r7)
            throw r8
        L_0x0053:
            com.google.android.gms.internal.ads.zzfgp r7 = new com.google.android.gms.internal.ads.zzfgp
            java.lang.Exception r8 = new java.lang.Exception
            java.lang.String r9 = "BannerAdapterWrapper interscrollerView should not be null"
            r8.<init>(r9)
            r7.<init>(r8)
            throw r7
        L_0x0060:
            r7 = move-exception
            com.google.android.gms.internal.ads.zzfgp r8 = new com.google.android.gms.internal.ads.zzfgp
            r8.<init>(r7)
            throw r8
        L_0x0067:
            java.lang.String r7 = "getInterscrollerAd should not be null after loadInterscrollerAd loaded ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r7)
            com.google.android.gms.internal.ads.zzfgp r8 = new com.google.android.gms.internal.ads.zzfgp
            java.lang.Exception r9 = new java.lang.Exception
            r9.<init>(r7)
            r8.<init>(r9)
            throw r8
        L_0x0077:
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzfhg r0 = (com.google.android.gms.internal.ads.zzfhg) r0
            android.view.View r2 = r0.zza()
        L_0x007f:
            com.google.android.gms.internal.ads.zzcsm r0 = r6.zzb
            java.lang.String r3 = r9.zza
            com.google.android.gms.internal.ads.zzcul r4 = new com.google.android.gms.internal.ads.zzcul
            r4.<init>(r7, r8, r3)
            java.lang.Object r7 = r9.zzb
            com.google.android.gms.internal.ads.zzcrt r3 = new com.google.android.gms.internal.ads.zzcrt
            com.google.android.gms.internal.ads.zzfhg r7 = (com.google.android.gms.internal.ads.zzfhg) r7
            java.util.Objects.requireNonNull(r7)
            com.google.android.gms.internal.ads.zzehn r5 = new com.google.android.gms.internal.ads.zzehn
            r5.<init>(r7)
            java.util.List r7 = r8.zzv
            r8 = 0
            java.lang.Object r7 = r7.get(r8)
            com.google.android.gms.internal.ads.zzffo r7 = (com.google.android.gms.internal.ads.zzffo) r7
            r3.<init>(r2, r1, r5, r7)
            com.google.android.gms.internal.ads.zzcrn r7 = r0.zza(r4, r3)
            com.google.android.gms.internal.ads.zzdgh r8 = r7.zzg()
            r8.zza(r2)
            com.google.android.gms.internal.ads.zzczp r8 = r7.zzd()
            java.lang.Object r0 = r9.zzb
            com.google.android.gms.internal.ads.zzcpa r1 = new com.google.android.gms.internal.ads.zzcpa
            com.google.android.gms.internal.ads.zzfhg r0 = (com.google.android.gms.internal.ads.zzfhg) r0
            r1.<init>(r0)
            java.util.concurrent.Executor r0 = r6.zzc
            r8.zzo(r1, r0)
            com.google.android.gms.internal.ads.zzdaa r8 = r9.zzc
            com.google.android.gms.internal.ads.zzeif r8 = (com.google.android.gms.internal.ads.zzeif) r8
            com.google.android.gms.internal.ads.zzelx r9 = r7.zzj()
            r8.zzc(r9)
            com.google.android.gms.internal.ads.zzcrm r7 = r7.zza()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzeho.zza(com.google.android.gms.internal.ads.zzffz, com.google.android.gms.internal.ads.zzffn, com.google.android.gms.internal.ads.zzegm):java.lang.Object");
    }

    public final void zzb(zzffz zzffz, zzffn zzffn, zzegm zzegm) throws zzfgp {
        zzq zza2;
        zzq zzq = zzffz.zza.zza.zze;
        if (zzq.zzn) {
            zza2 = new zzq(this.zza, zzb.zzd(zzq.zze, zzq.zzb));
        } else {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzhN)).booleanValue() || !zzffn.zzah) {
                zza2 = zzfgo.zza(this.zza, zzffn.zzv);
            } else {
                zza2 = new zzq(this.zza, zzb.zze(zzq.zze, zzq.zzb));
            }
        }
        zzq zzq2 = zza2;
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzhN)).booleanValue() || !zzffn.zzah) {
            Object obj = zzegm.zzb;
            Context context = this.zza;
            zzfgi zzfgi = zzffz.zza.zza;
            ((zzfhg) obj).zzm(context, zzq2, zzfgi.zzd, zzffn.zzw.toString(), zzbw.zzl(zzffn.zzt), (zzbqu) zzegm.zzc);
            return;
        }
        Object obj2 = zzegm.zzb;
        Context context2 = this.zza;
        zzfgi zzfgi2 = zzffz.zza.zza;
        ((zzfhg) obj2).zzn(context2, zzq2, zzfgi2.zzd, zzffn.zzw.toString(), zzbw.zzl(zzffn.zzt), (zzbqu) zzegm.zzc);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzc(View view, zzffn zzffn, Object obj) throws Exception {
        return zzgee.zzh(zzcth.zza(this.zza, view, zzffn));
    }
}
