package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.gms.ads.internal.client.zzba;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzawh implements zzawk {
    private static zzawh zzb;
    volatile long zza = 0;
    private final Context zzc;
    private final zzfri zzd;
    private final zzfrp zze;
    private final zzfrr zzf;
    private final zzaxj zzg;
    /* access modifiers changed from: private */
    public final zzfpp zzh;
    private final Executor zzi;
    private final zzazh zzj;
    private final zzfro zzk;
    private final CountDownLatch zzl;
    private final zzaxy zzm;
    private final zzaxq zzn;
    private final zzaxh zzo;
    /* access modifiers changed from: private */
    public final Object zzp = new Object();
    /* access modifiers changed from: private */
    public volatile boolean zzq;
    private volatile boolean zzr = false;

    zzawh(Context context, zzfpp zzfpp, zzfri zzfri, zzfrp zzfrp, zzfrr zzfrr, zzaxj zzaxj, Executor executor, zzfpi zzfpi, zzazh zzazh, zzaxy zzaxy, zzaxq zzaxq, zzaxh zzaxh) {
        this.zzc = context;
        this.zzh = zzfpp;
        this.zzd = zzfri;
        this.zze = zzfrp;
        this.zzf = zzfrr;
        this.zzg = zzaxj;
        this.zzi = executor;
        this.zzj = zzazh;
        this.zzm = zzaxy;
        this.zzn = zzaxq;
        this.zzo = zzaxh;
        this.zzr = false;
        this.zzl = new CountDownLatch(1);
        this.zzk = new zzawf(this, zzfpi);
    }

    public static synchronized zzawh zza(String str, Context context, boolean z, boolean z2) {
        zzawh zzb2;
        synchronized (zzawh.class) {
            zzb2 = zzb(str, context, Executors.newCachedThreadPool(), z, z2);
        }
        return zzb2;
    }

    @Deprecated
    public static synchronized zzawh zzb(String str, Context context, Executor executor, boolean z, boolean z2) {
        zzawh zzawh;
        Context context2 = context;
        Executor executor2 = executor;
        synchronized (zzawh.class) {
            if (zzb == null) {
                zzfpq zza2 = zzfpr.zza();
                zza2.zza(str);
                zza2.zzc(z);
                zzfpr zzd2 = zza2.zzd();
                zzfpp zza3 = zzfpp.zza(context2, executor2, z2);
                zzaws zzc2 = ((Boolean) zzba.zzc().zza(zzbdz.zzdl)).booleanValue() ? zzaws.zzc(context) : null;
                zzaxy zzd3 = ((Boolean) zzba.zzc().zza(zzbdz.zzdm)).booleanValue() ? zzaxy.zzd(context, executor) : null;
                zzaxq zzaxq = ((Boolean) zzba.zzc().zza(zzbdz.zzcA)).booleanValue() ? new zzaxq() : null;
                zzaxh zzaxh = ((Boolean) zzba.zzc().zza(zzbdz.zzcC)).booleanValue() ? new zzaxh() : null;
                zzfqi zze2 = zzfqi.zze(context2, executor2, zza3, zzd2);
                zzaxi zzaxi = new zzaxi(context2);
                zzaxj zzaxj = new zzaxj(zzd2, zze2, new zzaxw(context2, zzaxi), zzaxi, zzc2, zzd3, zzaxq, zzaxh);
                zzazh zzb2 = zzfqv.zzb(context2, zza3);
                zzfpi zzfpi = new zzfpi();
                zzawh zzawh2 = new zzawh(context, zza3, new zzfri(context2, zzb2), new zzfrp(context2, zzb2, new zzawe(zza3), ((Boolean) zzba.zzc().zza(zzbdz.zzcj)).booleanValue()), new zzfrr(context2, zzaxj, zza3, zzfpi), zzaxj, executor, zzfpi, zzb2, zzd3, zzaxq, zzaxh);
                zzb = zzawh2;
                zzawh2.zzm();
                zzb.zzp();
            }
            zzawh = zzb;
        }
        return zzawh;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x009a, code lost:
        if (r4.zzd().zzj().equals(r5.zzj()) != false) goto L_0x00f5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* bridge */ /* synthetic */ void zzj(com.google.android.gms.internal.ads.zzawh r12) {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            r2 = 1
            com.google.android.gms.internal.ads.zzfrh r3 = r12.zzt(r2)
            if (r3 == 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzazn r4 = r3.zza()
            java.lang.String r4 = r4.zzk()
            com.google.android.gms.internal.ads.zzazn r3 = r3.zza()
            java.lang.String r3 = r3.zzj()
            r9 = r3
            r8 = r4
            goto L_0x0021
        L_0x001e:
            r4 = 0
            r8 = r4
            r9 = r8
        L_0x0021:
            android.content.Context r5 = r12.zzc     // Catch:{ zzhak -> 0x011e }
            r6 = 1
            com.google.android.gms.internal.ads.zzazh r7 = r12.zzj     // Catch:{ zzhak -> 0x011e }
            java.lang.String r10 = "1"
            com.google.android.gms.internal.ads.zzfpp r11 = r12.zzh     // Catch:{ zzhak -> 0x011e }
            com.google.android.gms.internal.ads.zzfrm r3 = com.google.android.gms.internal.ads.zzfpz.zza(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ zzhak -> 0x011e }
            byte[] r4 = r3.zzb     // Catch:{ zzhak -> 0x011e }
            if (r4 == 0) goto L_0x010f
            int r5 = r4.length     // Catch:{ zzhak -> 0x011e }
            if (r5 != 0) goto L_0x0037
            goto L_0x010f
        L_0x0037:
            r6 = 0
            com.google.android.gms.internal.ads.zzgyj r4 = com.google.android.gms.internal.ads.zzgyj.zzv(r4, r6, r5)     // Catch:{ NullPointerException -> 0x0102 }
            com.google.android.gms.internal.ads.zzgzf r5 = com.google.android.gms.internal.ads.zzgzf.zza()     // Catch:{ NullPointerException -> 0x0102 }
            com.google.android.gms.internal.ads.zzazk r4 = com.google.android.gms.internal.ads.zzazk.zzc(r4, r5)     // Catch:{ NullPointerException -> 0x0102 }
            com.google.android.gms.internal.ads.zzazn r5 = r4.zzd()     // Catch:{ zzhak -> 0x011e }
            java.lang.String r5 = r5.zzk()     // Catch:{ zzhak -> 0x011e }
            boolean r5 = r5.isEmpty()     // Catch:{ zzhak -> 0x011e }
            if (r5 != 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzazn r5 = r4.zzd()     // Catch:{ zzhak -> 0x011e }
            java.lang.String r5 = r5.zzj()     // Catch:{ zzhak -> 0x011e }
            boolean r5 = r5.isEmpty()     // Catch:{ zzhak -> 0x011e }
            if (r5 != 0) goto L_0x00f5
            com.google.android.gms.internal.ads.zzgyj r5 = r4.zze()     // Catch:{ zzhak -> 0x011e }
            byte[] r5 = r5.zzB()     // Catch:{ zzhak -> 0x011e }
            int r5 = r5.length     // Catch:{ zzhak -> 0x011e }
            if (r5 != 0) goto L_0x006d
            goto L_0x00f5
        L_0x006d:
            com.google.android.gms.internal.ads.zzfrh r5 = r12.zzt(r2)     // Catch:{ zzhak -> 0x011e }
            if (r5 != 0) goto L_0x0074
            goto L_0x009c
        L_0x0074:
            com.google.android.gms.internal.ads.zzazn r5 = r5.zza()     // Catch:{ zzhak -> 0x011e }
            com.google.android.gms.internal.ads.zzazn r6 = r4.zzd()     // Catch:{ zzhak -> 0x011e }
            java.lang.String r6 = r6.zzk()     // Catch:{ zzhak -> 0x011e }
            java.lang.String r7 = r5.zzk()     // Catch:{ zzhak -> 0x011e }
            boolean r6 = r6.equals(r7)     // Catch:{ zzhak -> 0x011e }
            if (r6 == 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzazn r6 = r4.zzd()     // Catch:{ zzhak -> 0x011e }
            java.lang.String r6 = r6.zzj()     // Catch:{ zzhak -> 0x011e }
            java.lang.String r5 = r5.zzj()     // Catch:{ zzhak -> 0x011e }
            boolean r5 = r6.equals(r5)     // Catch:{ zzhak -> 0x011e }
            if (r5 != 0) goto L_0x00f5
        L_0x009c:
            com.google.android.gms.internal.ads.zzfro r5 = r12.zzk     // Catch:{ zzhak -> 0x011e }
            int r3 = r3.zzc     // Catch:{ zzhak -> 0x011e }
            com.google.android.gms.internal.ads.zzbdq r6 = com.google.android.gms.internal.ads.zzbdz.zzch     // Catch:{ zzhak -> 0x011e }
            com.google.android.gms.internal.ads.zzbdx r7 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ zzhak -> 0x011e }
            java.lang.Object r6 = r7.zza(r6)     // Catch:{ zzhak -> 0x011e }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ zzhak -> 0x011e }
            boolean r6 = r6.booleanValue()     // Catch:{ zzhak -> 0x011e }
            if (r6 == 0) goto L_0x00c6
            r6 = 3
            if (r3 != r6) goto L_0x00bc
            com.google.android.gms.internal.ads.zzfrp r3 = r12.zze     // Catch:{ zzhak -> 0x011e }
            boolean r3 = r3.zza(r4)     // Catch:{ zzhak -> 0x011e }
            goto L_0x00cc
        L_0x00bc:
            r6 = 4
            if (r3 != r6) goto L_0x00ce
            com.google.android.gms.internal.ads.zzfrp r3 = r12.zze     // Catch:{ zzhak -> 0x011e }
            boolean r3 = r3.zzb(r4, r5)     // Catch:{ zzhak -> 0x011e }
            goto L_0x00cc
        L_0x00c6:
            com.google.android.gms.internal.ads.zzfri r3 = r12.zzd     // Catch:{ zzhak -> 0x011e }
            boolean r3 = r3.zza(r4, r5)     // Catch:{ zzhak -> 0x011e }
        L_0x00cc:
            if (r3 != 0) goto L_0x00db
        L_0x00ce:
            com.google.android.gms.internal.ads.zzfpp r2 = r12.zzh     // Catch:{ zzhak -> 0x011e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzhak -> 0x011e }
            long r3 = r3 - r0
            r5 = 4009(0xfa9, float:5.618E-42)
            r2.zzd(r5, r3)     // Catch:{ zzhak -> 0x011e }
            goto L_0x012b
        L_0x00db:
            com.google.android.gms.internal.ads.zzfrh r3 = r12.zzt(r2)     // Catch:{ zzhak -> 0x011e }
            if (r3 == 0) goto L_0x012b
            com.google.android.gms.internal.ads.zzfrr r4 = r12.zzf     // Catch:{ zzhak -> 0x011e }
            boolean r3 = r4.zzc(r3)     // Catch:{ zzhak -> 0x011e }
            if (r3 == 0) goto L_0x00eb
            r12.zzr = r2     // Catch:{ zzhak -> 0x011e }
        L_0x00eb:
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ zzhak -> 0x011e }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r12.zza = r2     // Catch:{ zzhak -> 0x011e }
            goto L_0x012b
        L_0x00f5:
            com.google.android.gms.internal.ads.zzfpp r2 = r12.zzh     // Catch:{ zzhak -> 0x011e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzhak -> 0x011e }
            long r3 = r3 - r0
            r5 = 5010(0x1392, float:7.02E-42)
            r2.zzd(r5, r3)     // Catch:{ zzhak -> 0x011e }
            goto L_0x012b
        L_0x0102:
            com.google.android.gms.internal.ads.zzfpp r2 = r12.zzh     // Catch:{ zzhak -> 0x011e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzhak -> 0x011e }
            long r3 = r3 - r0
            r5 = 2030(0x7ee, float:2.845E-42)
            r2.zzd(r5, r3)     // Catch:{ zzhak -> 0x011e }
            goto L_0x012b
        L_0x010f:
            com.google.android.gms.internal.ads.zzfpp r2 = r12.zzh     // Catch:{ zzhak -> 0x011e }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ zzhak -> 0x011e }
            long r3 = r3 - r0
            r5 = 5009(0x1391, float:7.019E-42)
            r2.zzd(r5, r3)     // Catch:{ zzhak -> 0x011e }
            goto L_0x012b
        L_0x011c:
            r0 = move-exception
            goto L_0x0131
        L_0x011e:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzfpp r3 = r12.zzh     // Catch:{ all -> 0x011c }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x011c }
            long r4 = r4 - r0
            r0 = 4002(0xfa2, float:5.608E-42)
            r3.zzc(r0, r4, r2)     // Catch:{ all -> 0x011c }
        L_0x012b:
            java.util.concurrent.CountDownLatch r12 = r12.zzl
            r12.countDown()
            return
        L_0x0131:
            java.util.concurrent.CountDownLatch r12 = r12.zzl
            r12.countDown()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawh.zzj(com.google.android.gms.internal.ads.zzawh):void");
    }

    private final void zzs() {
        zzaxy zzaxy = this.zzm;
        if (zzaxy != null) {
            zzaxy.zzh();
        }
    }

    private final zzfrh zzt(int i) {
        if (!zzfqv.zza(this.zzj)) {
            return null;
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzch)).booleanValue()) {
            return this.zze.zzc(1);
        }
        return this.zzd.zzc(1);
    }

    public final String zze(Context context, String str, View view) {
        return zzf(context, str, view, (Activity) null);
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        zzs();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcA)).booleanValue()) {
            this.zzn.zzi();
        }
        zzp();
        zzfps zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza3 = zza2.zza(context, (String) null, str, view, activity);
        this.zzh.zzf(5000, System.currentTimeMillis() - currentTimeMillis, zza3, (Map) null);
        return zza3;
    }

    public final String zzg(Context context) {
        zzs();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcA)).booleanValue()) {
            this.zzn.zzj();
        }
        zzp();
        zzfps zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzc2 = zza2.zzc(context, (String) null);
        this.zzh.zzf(PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED, System.currentTimeMillis() - currentTimeMillis, zzc2, (Map) null);
        return zzc2;
    }

    public final String zzh(Context context, View view, Activity activity) {
        zzs();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcA)).booleanValue()) {
            this.zzn.zzk(context, view);
        }
        zzp();
        zzfps zza2 = this.zzf.zza();
        if (zza2 == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb2 = zza2.zzb(context, (String) null, view, activity);
        this.zzh.zzf(PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED, System.currentTimeMillis() - currentTimeMillis, zzb2, (Map) null);
        return zzb2;
    }

    public final void zzk(MotionEvent motionEvent) {
        zzfps zza2 = this.zzf.zza();
        if (zza2 != null) {
            try {
                zza2.zzd((String) null, motionEvent);
            } catch (zzfrq e) {
                this.zzh.zzc(e.zza(), -1, e);
            }
        }
    }

    public final void zzl(int i, int i2, int i3) {
        DisplayMetrics displayMetrics;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzlD)).booleanValue() && (displayMetrics = this.zzc.getResources().getDisplayMetrics()) != null) {
            float f = (float) i;
            float f2 = (float) i2;
            float f3 = f2;
            MotionEvent obtain = MotionEvent.obtain(0, 0, 0, displayMetrics.density * f, displayMetrics.density * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            zzk(obtain);
            obtain.recycle();
            MotionEvent obtain2 = MotionEvent.obtain(0, 0, 2, f * displayMetrics.density, f3 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            zzk(obtain2);
            obtain2.recycle();
            MotionEvent obtain3 = MotionEvent.obtain(0, (long) i3, 1, f * displayMetrics.density, f3 * displayMetrics.density, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            zzk(obtain3);
            obtain3.recycle();
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzm() {
        long currentTimeMillis = System.currentTimeMillis();
        zzfrh zzt = zzt(1);
        if (zzt == null) {
            this.zzh.zzd(4013, System.currentTimeMillis() - currentTimeMillis);
        } else if (this.zzf.zzc(zzt)) {
            this.zzr = true;
            this.zzl.countDown();
        }
    }

    public final void zzn(StackTraceElement[] stackTraceElementArr) {
        zzaxh zzaxh = this.zzo;
        if (zzaxh != null) {
            zzaxh.zzb(Arrays.asList(stackTraceElementArr));
        }
    }

    public final void zzo(View view) {
        this.zzg.zzd(view);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzp() {
        /*
            r5 = this;
            boolean r0 = r5.zzq
            if (r0 != 0) goto L_0x0042
            java.lang.Object r0 = r5.zzp
            monitor-enter(r0)
            boolean r1 = r5.zzq     // Catch:{ all -> 0x003f }
            if (r1 != 0) goto L_0x003d
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x003f }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r5.zza     // Catch:{ all -> 0x003f }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzfrr r1 = r5.zzf     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzfrh r1 = r1.zzb()     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zzd(r3)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
        L_0x002b:
            com.google.android.gms.internal.ads.zzazh r1 = r5.zzj     // Catch:{ all -> 0x003f }
            boolean r1 = com.google.android.gms.internal.ads.zzfqv.zza(r1)     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            java.util.concurrent.Executor r1 = r5.zzi     // Catch:{ all -> 0x003f }
            com.google.android.gms.internal.ads.zzawg r2 = new com.google.android.gms.internal.ads.zzawg     // Catch:{ all -> 0x003f }
            r2.<init>(r5)     // Catch:{ all -> 0x003f }
            r1.execute(r2)     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return
        L_0x003f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r1
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawh.zzp():void");
    }

    public final synchronized boolean zzr() {
        return this.zzr;
    }
}
