package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.amazon.a.a.o.b.f;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.nonagon.signalgeneration.zzh;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzevs implements zzewr {
    final String zza;
    private final zzgep zzb;
    private final ScheduledExecutorService zzc;
    private final zzemw zzd;
    private final Context zze;
    private final zzfgi zzf;
    private final zzems zzg;
    private final zzdry zzh;
    private final zzdwm zzi;

    zzevs(zzgep zzgep, ScheduledExecutorService scheduledExecutorService, String str, zzemw zzemw, Context context, zzfgi zzfgi, zzems zzems, zzdry zzdry, zzdwm zzdwm) {
        this.zzb = zzgep;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzemw;
        this.zze = context;
        this.zzf = zzfgi;
        this.zzg = zzems;
        this.zzh = zzdry;
        this.zzi = zzdwm;
    }

    public static /* synthetic */ ListenableFuture zzc(zzevs zzevs) {
        String str;
        Bundle bundle;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkA)).booleanValue()) {
            str = zzevs.zzf.zzf.toLowerCase(Locale.ROOT);
        } else {
            str = zzevs.zzf.zzf;
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzbD)).booleanValue()) {
            bundle = zzevs.zzi.zzg();
        } else {
            bundle = new Bundle();
        }
        ArrayList arrayList = new ArrayList();
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzbM)).booleanValue()) {
            for (Map.Entry entry : ((zzfzq) zzevs.zzd.zzb(zzevs.zza, str)).entrySet()) {
                String str2 = (String) entry.getKey();
                arrayList.add(zzevs.zzg(str2, (List) entry.getValue(), zzevs.zzf(str2), true, true));
            }
            zzevs.zzi(arrayList, zzevs.zzd.zzc());
        } else {
            zzevs.zzi(arrayList, zzevs.zzd.zza(zzevs.zza, str));
        }
        return zzgee.zzb(arrayList).zza(new zzevn(arrayList, bundle), zzevs.zzb);
    }

    private final Bundle zzf(String str) {
        Bundle bundle = this.zzf.zzd.zzm;
        if (bundle != null) {
            return bundle.getBundle(str);
        }
        return null;
    }

    private final zzgdv zzg(String str, List list, Bundle bundle, boolean z, boolean z2) {
        zzgdv zzu = zzgdv.zzu(zzgee.zzk(new zzevp(this, str, list, bundle, z, z2), this.zzb));
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzbz)).booleanValue()) {
            zzu = (zzgdv) zzgee.zzo(zzu, ((Long) zzba.zzc().zza(zzbdz.zzbs)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return (zzgdv) zzgee.zze(zzu, Throwable.class, new zzevq(str), this.zzb);
    }

    private final void zzh(zzbsn zzbsn, Bundle bundle, List list, zzemz zzemz) throws RemoteException {
        zzbsn zzbsn2 = zzbsn;
        zzbsn2.zzh(ObjectWrapper.wrap(this.zze), this.zza, bundle, (Bundle) list.get(0), this.zzf.zze, zzemz);
    }

    private final void zzi(List list, Map map) {
        for (Map.Entry value : map.entrySet()) {
            zzena zzena = (zzena) value.getValue();
            String str = zzena.zza;
            list.add(zzg(str, Collections.singletonList(zzena.zze), zzf(str), zzena.zzb, zzena.zzc));
        }
    }

    public final int zza() {
        return 32;
    }

    public final ListenableFuture zzb() {
        zzfgi zzfgi = this.zzf;
        if (zzfgi.zzq) {
            if (!Arrays.asList(((String) zzba.zzc().zza(zzbdz.zzbF)).split(f.a)).contains(zzh.zza(zzh.zzb(zzfgi.zzd)))) {
                return zzgee.zzh(new zzevt(new JSONArray().toString(), new Bundle()));
            }
        }
        return zzgee.zzk(new zzevm(this), this.zzb);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.common.util.concurrent.ListenableFuture zzd(java.lang.String r9, java.util.List r10, android.os.Bundle r11, boolean r12, boolean r13) throws java.lang.Exception {
        /*
            r8 = this;
            com.google.android.gms.internal.ads.zzcbw r7 = new com.google.android.gms.internal.ads.zzcbw
            r7.<init>()
            r0 = 0
            if (r13 == 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzbdq r13 = com.google.android.gms.internal.ads.zzbdz.zzbE
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r13 = r1.zza(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L_0x0026
            com.google.android.gms.internal.ads.zzems r13 = r8.zzg
            r13.zzb(r9)
            com.google.android.gms.internal.ads.zzems r13 = r8.zzg
            com.google.android.gms.internal.ads.zzbsn r13 = r13.zza(r9)
            goto L_0x0034
        L_0x0026:
            com.google.android.gms.internal.ads.zzdry r13 = r8.zzh     // Catch:{ RemoteException -> 0x002d }
            com.google.android.gms.internal.ads.zzbsn r13 = r13.zzb(r9)     // Catch:{ RemoteException -> 0x002d }
            goto L_0x0034
        L_0x002d:
            r13 = move-exception
            java.lang.String r1 = "Couldn't create RTB adapter : "
            com.google.android.gms.ads.internal.util.client.zzm.zzh(r1, r13)
            r13 = r0
        L_0x0034:
            if (r13 != 0) goto L_0x004e
            com.google.android.gms.internal.ads.zzbdq r10 = com.google.android.gms.internal.ads.zzbdz.zzbu
            com.google.android.gms.internal.ads.zzbdx r11 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r10 = r11.zza(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x004d
            com.google.android.gms.internal.ads.zzemz.zzb(r9, r7)
            goto L_0x00ba
        L_0x004d:
            throw r0
        L_0x004e:
            com.google.android.gms.internal.ads.zzemz r6 = new com.google.android.gms.internal.ads.zzemz
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzu.zzB()
            long r4 = r0.elapsedRealtime()
            r0 = r6
            r1 = r9
            r2 = r13
            r3 = r7
            r0.<init>(r1, r2, r3, r4)
            com.google.android.gms.internal.ads.zzbdq r9 = com.google.android.gms.internal.ads.zzbdz.zzbz
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r9 = r0.zza(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x008d
            java.util.concurrent.ScheduledExecutorService r9 = r8.zzc
            com.google.android.gms.internal.ads.zzevr r0 = new com.google.android.gms.internal.ads.zzevr
            r0.<init>(r6)
            com.google.android.gms.internal.ads.zzbdq r1 = com.google.android.gms.internal.ads.zzbdz.zzbs
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r1 = r2.zza(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            r9.schedule(r0, r1, r3)
        L_0x008d:
            if (r12 == 0) goto L_0x00b7
            com.google.android.gms.internal.ads.zzbdq r9 = com.google.android.gms.internal.ads.zzbdz.zzbG
            com.google.android.gms.internal.ads.zzbdx r12 = com.google.android.gms.ads.internal.client.zzba.zzc()
            java.lang.Object r9 = r12.zza(r9)
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x00b3
            com.google.android.gms.internal.ads.zzgep r9 = r8.zzb
            com.google.android.gms.internal.ads.zzevo r12 = new com.google.android.gms.internal.ads.zzevo
            r0 = r12
            r1 = r8
            r2 = r13
            r3 = r11
            r4 = r10
            r5 = r6
            r6 = r7
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r9.zza(r12)
            goto L_0x00ba
        L_0x00b3:
            r8.zzh(r13, r11, r10, r6)
            goto L_0x00ba
        L_0x00b7:
            r6.zzd()
        L_0x00ba:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzevs.zzd(java.lang.String, java.util.List, android.os.Bundle, boolean, boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbsn zzbsn, Bundle bundle, List list, zzemz zzemz, zzcbw zzcbw) {
        try {
            zzh(zzbsn, bundle, list, zzemz);
        } catch (RemoteException e) {
            zzcbw.zzd(e);
        }
    }
}
