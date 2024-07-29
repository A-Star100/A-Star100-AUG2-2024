package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzfav implements zzeoq {
    protected final zzcik zza;
    private final Context zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public final zzfbl zzd;
    /* access modifiers changed from: private */
    public final zzfde zze;
    private final VersionInfoParcel zzf;
    private final ViewGroup zzg;
    /* access modifiers changed from: private */
    public final zzflk zzh;
    private final zzfgg zzi;
    /* access modifiers changed from: private */
    @Nullable
    public ListenableFuture zzj;

    protected zzfav(Context context, Executor executor, zzcik zzcik, zzfde zzfde, zzfbl zzfbl, zzfgg zzfgg, VersionInfoParcel versionInfoParcel) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzcik;
        this.zze = zzfde;
        this.zzd = zzfbl;
        this.zzi = zzfgg;
        this.zzf = versionInfoParcel;
        this.zzg = new FrameLayout(context);
        this.zzh = zzcik.zzz();
    }

    /* access modifiers changed from: private */
    public final synchronized zzcxw zzm(zzfdc zzfdc) {
        zzfau zzfau = (zzfau) zzfdc;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzif)).booleanValue()) {
            zzcrj zzcrj = new zzcrj(this.zzg);
            zzcxy zzcxy = new zzcxy();
            zzcxy.zze(this.zzb);
            zzcxy.zzi(zzfau.zza);
            zzcya zzj2 = zzcxy.zzj();
            zzdef zzdef = new zzdef();
            zzdef.zzc(this.zzd, this.zzc);
            zzdef.zzl(this.zzd, this.zzc);
            return zze(zzcrj, zzj2, zzdef.zzn());
        }
        zzfbl zzi2 = zzfbl.zzi(this.zzd);
        zzdef zzdef2 = new zzdef();
        zzdef2.zzb(zzi2, this.zzc);
        zzdef2.zzg(zzi2, this.zzc);
        zzdef2.zzh(zzi2, this.zzc);
        zzdef2.zzi(zzi2, this.zzc);
        zzdef2.zzc(zzi2, this.zzc);
        zzdef2.zzl(zzi2, this.zzc);
        zzdef2.zzm(zzi2);
        zzcrj zzcrj2 = new zzcrj(this.zzg);
        zzcxy zzcxy2 = new zzcxy();
        zzcxy2.zze(this.zzb);
        zzcxy2.zzi(zzfau.zza);
        return zze(zzcrj2, zzcxy2.zzj(), zzdef2.zzn());
    }

    public final boolean zza() {
        ListenableFuture listenableFuture = this.zzj;
        return listenableFuture != null && !listenableFuture.isDone();
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056 A[SYNTHETIC, Splitter:B:16:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean zzb(com.google.android.gms.ads.internal.client.zzl r9, java.lang.String r10, com.google.android.gms.internal.ads.zzeoo r11, com.google.android.gms.internal.ads.zzeop r12) throws android.os.RemoteException {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.android.gms.internal.ads.zzbff r11 = com.google.android.gms.internal.ads.zzbfr.zzd     // Catch:{ all -> 0x012d }
            java.lang.Object r11 = r11.zze()     // Catch:{ all -> 0x012d }
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x012d }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x012d }
            r0 = 1
            r1 = 0
            if (r11 == 0) goto L_0x0025
            com.google.android.gms.internal.ads.zzbdq r11 = com.google.android.gms.internal.ads.zzbdz.zzkP     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzbdx r2 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x012d }
            java.lang.Object r11 = r2.zza(r11)     // Catch:{ all -> 0x012d }
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x012d }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x012d }
            if (r11 == 0) goto L_0x0025
            r11 = r0
            goto L_0x0026
        L_0x0025:
            r11 = r1
        L_0x0026:
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r2 = r8.zzf     // Catch:{ all -> 0x012d }
            int r2 = r2.clientJarVersion     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzbdq r3 = com.google.android.gms.internal.ads.zzbdz.zzkQ     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzbdx r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x012d }
            java.lang.Object r3 = r4.zza(r3)     // Catch:{ all -> 0x012d }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x012d }
            int r3 = r3.intValue()     // Catch:{ all -> 0x012d }
            if (r2 < r3) goto L_0x003e
            if (r11 != 0) goto L_0x0043
        L_0x003e:
            java.lang.String r11 = "loadAd must be called on the main UI thread."
            com.google.android.gms.common.internal.Preconditions.checkMainThread(r11)     // Catch:{ all -> 0x012d }
        L_0x0043:
            if (r10 != 0) goto L_0x0056
            java.lang.String r9 = "Ad unit ID should not be null for app open ad."
            com.google.android.gms.ads.internal.util.client.zzm.zzg(r9)     // Catch:{ all -> 0x012d }
            java.util.concurrent.Executor r9 = r8.zzc     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzfap r10 = new com.google.android.gms.internal.ads.zzfap     // Catch:{ all -> 0x012d }
            r10.<init>(r8)     // Catch:{ all -> 0x012d }
            r9.execute(r10)     // Catch:{ all -> 0x012d }
            monitor-exit(r8)
            return r1
        L_0x0056:
            com.google.common.util.concurrent.ListenableFuture r11 = r8.zzj     // Catch:{ all -> 0x012d }
            if (r11 == 0) goto L_0x005c
            monitor-exit(r8)
            return r1
        L_0x005c:
            com.google.android.gms.internal.ads.zzbff r11 = com.google.android.gms.internal.ads.zzbfm.zzc     // Catch:{ all -> 0x012d }
            java.lang.Object r11 = r11.zze()     // Catch:{ all -> 0x012d }
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x012d }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x012d }
            r2 = 0
            if (r11 == 0) goto L_0x0089
            com.google.android.gms.internal.ads.zzfde r11 = r8.zze     // Catch:{ all -> 0x012d }
            java.lang.Object r3 = r11.zzd()     // Catch:{ all -> 0x012d }
            if (r3 == 0) goto L_0x0089
            java.lang.Object r11 = r11.zzd()     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzcqw r11 = (com.google.android.gms.internal.ads.zzcqw) r11     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzflh r11 = r11.zzh()     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzflq r3 = com.google.android.gms.internal.ads.zzflq.FORMAT_APP_OPEN     // Catch:{ all -> 0x012d }
            r11.zzd(r3)     // Catch:{ all -> 0x012d }
            java.lang.String r3 = r9.zzp     // Catch:{ all -> 0x012d }
            r11.zzb(r3)     // Catch:{ all -> 0x012d }
            r4 = r11
            goto L_0x008a
        L_0x0089:
            r4 = r2
        L_0x008a:
            android.content.Context r11 = r8.zzb     // Catch:{ all -> 0x012d }
            boolean r3 = r9.zzf     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzfhf.zza(r11, r3)     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzbdq r11 = com.google.android.gms.internal.ads.zzbdz.zziO     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzbdx r3 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x012d }
            java.lang.Object r11 = r3.zza(r11)     // Catch:{ all -> 0x012d }
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x012d }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x012d }
            if (r11 == 0) goto L_0x00b0
            boolean r11 = r9.zzf     // Catch:{ all -> 0x012d }
            if (r11 == 0) goto L_0x00b0
            com.google.android.gms.internal.ads.zzcik r11 = r8.zza     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzdxf r11 = r11.zzl()     // Catch:{ all -> 0x012d }
            r11.zzo(r0)     // Catch:{ all -> 0x012d }
        L_0x00b0:
            r11 = 2
            android.util.Pair[] r11 = new android.util.Pair[r11]     // Catch:{ all -> 0x012d }
            android.util.Pair r3 = new android.util.Pair     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzdtq r5 = com.google.android.gms.internal.ads.zzdtq.PUBLIC_API_CALL     // Catch:{ all -> 0x012d }
            java.lang.String r5 = r5.zza()     // Catch:{ all -> 0x012d }
            long r6 = r9.zzz     // Catch:{ all -> 0x012d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x012d }
            r3.<init>(r5, r6)     // Catch:{ all -> 0x012d }
            r11[r1] = r3     // Catch:{ all -> 0x012d }
            android.util.Pair r1 = new android.util.Pair     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzdtq r3 = com.google.android.gms.internal.ads.zzdtq.DYNAMITE_ENTER     // Catch:{ all -> 0x012d }
            java.lang.String r3 = r3.zza()     // Catch:{ all -> 0x012d }
            com.google.android.gms.common.util.Clock r5 = com.google.android.gms.ads.internal.zzu.zzB()     // Catch:{ all -> 0x012d }
            long r5 = r5.currentTimeMillis()     // Catch:{ all -> 0x012d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x012d }
            r1.<init>(r3, r5)     // Catch:{ all -> 0x012d }
            r11[r0] = r1     // Catch:{ all -> 0x012d }
            android.os.Bundle r11 = com.google.android.gms.internal.ads.zzdts.zza(r11)     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzfgg r1 = r8.zzi     // Catch:{ all -> 0x012d }
            r1.zzt(r10)     // Catch:{ all -> 0x012d }
            com.google.android.gms.ads.internal.client.zzq r10 = com.google.android.gms.ads.internal.client.zzq.zzb()     // Catch:{ all -> 0x012d }
            r1.zzs(r10)     // Catch:{ all -> 0x012d }
            r1.zzG(r9)     // Catch:{ all -> 0x012d }
            r1.zzz(r11)     // Catch:{ all -> 0x012d }
            android.content.Context r10 = r8.zzb     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzfgi r11 = r1.zzI()     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzflo r1 = com.google.android.gms.internal.ads.zzflg.zza(r11)     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzflq r3 = com.google.android.gms.internal.ads.zzflq.FORMAT_APP_OPEN     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzfkw r5 = com.google.android.gms.internal.ads.zzfkv.zzb(r10, r1, r3, r9)     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzfau r6 = new com.google.android.gms.internal.ads.zzfau     // Catch:{ all -> 0x012d }
            r6.<init>(r2)     // Catch:{ all -> 0x012d }
            r6.zza = r11     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzfde r9 = r8.zze     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzfdf r10 = new com.google.android.gms.internal.ads.zzfdf     // Catch:{ all -> 0x012d }
            r10.<init>(r6, r2)     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzfaq r11 = new com.google.android.gms.internal.ads.zzfaq     // Catch:{ all -> 0x012d }
            r11.<init>(r8)     // Catch:{ all -> 0x012d }
            com.google.common.util.concurrent.ListenableFuture r9 = r9.zzc(r10, r11, r2)     // Catch:{ all -> 0x012d }
            r8.zzj = r9     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzfas r10 = new com.google.android.gms.internal.ads.zzfas     // Catch:{ all -> 0x012d }
            r1 = r10
            r2 = r8
            r3 = r12
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x012d }
            java.util.concurrent.Executor r11 = r8.zzc     // Catch:{ all -> 0x012d }
            com.google.android.gms.internal.ads.zzgee.zzr(r9, r10, r11)     // Catch:{ all -> 0x012d }
            monitor-exit(r8)
            return r0
        L_0x012d:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfav.zzb(com.google.android.gms.ads.internal.client.zzl, java.lang.String, com.google.android.gms.internal.ads.zzeoo, com.google.android.gms.internal.ads.zzeop):boolean");
    }

    /* access modifiers changed from: protected */
    public abstract zzcxw zze(zzcrj zzcrj, zzcya zzcya, zzdeh zzdeh);

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzk() {
        this.zzd.zzdB(zzfhk.zzd(6, (String) null, (zze) null));
    }

    public final void zzl(zzw zzw) {
        this.zzi.zzu(zzw);
    }
}
