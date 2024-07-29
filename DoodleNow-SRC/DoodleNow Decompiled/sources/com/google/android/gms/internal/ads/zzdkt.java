package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzcs;
import com.google.android.gms.ads.internal.client.zzcw;
import com.google.android.gms.ads.internal.client.zzdg;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdkt extends zzctv {
    public static final zzfzn zzc = zzfzn.zzr("3010", "3008", "1005", "1009", "2011", "2007");
    private final zzbaa zzA;
    private final Executor zzd;
    /* access modifiers changed from: private */
    public final zzdky zze;
    private final zzdlg zzf;
    private final zzdly zzg;
    private final zzdld zzh;
    private final zzdlj zzi;
    private final zzhip zzj;
    private final zzhip zzk;
    private final zzhip zzl;
    private final zzhip zzm;
    private final zzhip zzn;
    /* access modifiers changed from: private */
    public zzdmu zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private final zzbzz zzs;
    private final zzawo zzt;
    private final VersionInfoParcel zzu;
    private final Context zzv;
    private final zzdkv zzw;
    private final zzeod zzx;
    /* access modifiers changed from: private */
    public final Map zzy = new HashMap();
    private final List zzz = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdkt(zzctu zzctu, Executor executor, zzdky zzdky, zzdlg zzdlg, zzdly zzdly, zzdld zzdld, zzdlj zzdlj, zzhip zzhip, zzhip zzhip2, zzhip zzhip3, zzhip zzhip4, zzhip zzhip5, zzbzz zzbzz, zzawo zzawo, VersionInfoParcel versionInfoParcel, Context context, zzdkv zzdkv, zzeod zzeod, zzbaa zzbaa) {
        super(zzctu);
        this.zzd = executor;
        this.zze = zzdky;
        this.zzf = zzdlg;
        this.zzg = zzdly;
        this.zzh = zzdld;
        this.zzi = zzdlj;
        this.zzj = zzhip;
        this.zzk = zzhip2;
        this.zzl = zzhip3;
        this.zzm = zzhip4;
        this.zzn = zzhip5;
        this.zzs = zzbzz;
        this.zzt = zzawo;
        this.zzu = versionInfoParcel;
        this.zzv = context;
        this.zzw = zzdkv;
        this.zzx = zzeod;
        this.zzA = zzbaa;
    }

    public static boolean zzW(View view) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzkn)).booleanValue()) {
            return view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null);
        }
        zzu.zzp();
        long zzw2 = zzt.zzw(view);
        if (view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null)) {
            if (zzw2 >= ((long) ((Integer) zzba.zzc().zza(zzbdz.zzko)).intValue())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized android.view.View zzY(java.util.Map r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            if (r5 != 0) goto L_0x0004
            goto L_0x0025
        L_0x0004:
            com.google.android.gms.internal.ads.zzfzn r0 = zzc     // Catch:{ all -> 0x0028 }
            int r1 = r0.size()     // Catch:{ all -> 0x0028 }
            r2 = 0
        L_0x000b:
            if (r2 >= r1) goto L_0x0025
            java.lang.Object r3 = r0.get(r2)     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0028 }
            java.lang.Object r3 = r5.get(r3)     // Catch:{ all -> 0x0028 }
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3     // Catch:{ all -> 0x0028 }
            int r2 = r2 + 1
            if (r3 == 0) goto L_0x000b
            java.lang.Object r5 = r3.get()     // Catch:{ all -> 0x0028 }
            android.view.View r5 = (android.view.View) r5     // Catch:{ all -> 0x0028 }
            monitor-exit(r4)
            return r5
        L_0x0025:
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x0028:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdkt.zzY(java.util.Map):android.view.View");
    }

    private final synchronized ImageView.ScaleType zzZ() {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzhV)).booleanValue()) {
            return null;
        }
        zzdmu zzdmu = this.zzo;
        if (zzdmu == null) {
            zzm.zze("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        IObjectWrapper zzj2 = zzdmu.zzj();
        if (zzj2 != null) {
            return (ImageView.ScaleType) ObjectWrapper.unwrap(zzj2);
        }
        return zzdly.zza;
    }

    private final void zzaa(String str, boolean z) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfc)).booleanValue()) {
            ListenableFuture zzw2 = this.zze.zzw();
            if (zzw2 != null) {
                zzgee.zzr(zzw2, new zzdkr(this, "Google", true), this.zzd);
                return;
            }
            return;
        }
        zzf("Google", true);
    }

    private final synchronized void zzab(View view, Map map, Map map2) {
        this.zzg.zzd(this.zzo);
        this.zzf.zzq(view, map, map2, zzZ());
        this.zzq = true;
    }

    /* access modifiers changed from: private */
    public final void zzac(View view, zzfmy zzfmy) {
        zzcgm zzr2 = this.zze.zzr();
        if (this.zzh.zzd() && zzfmy != null && zzr2 != null && view != null) {
            zzu.zzA().zzh(zzfmy, view);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        return;
     */
    /* renamed from: zzad */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzy(com.google.android.gms.internal.ads.zzdmu r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.zzp     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0007
            goto L_0x00b5
        L_0x0007:
            r7.zzo = r8     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzdly r0 = r7.zzg     // Catch:{ all -> 0x00b7 }
            r0.zze(r8)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzdlg r1 = r7.zzf     // Catch:{ all -> 0x00b7 }
            android.view.View r2 = r8.zzf()     // Catch:{ all -> 0x00b7 }
            java.util.Map r3 = r8.zzm()     // Catch:{ all -> 0x00b7 }
            java.util.Map r4 = r8.zzn()     // Catch:{ all -> 0x00b7 }
            r5 = r8
            r6 = r8
            r1.zzy(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzcy     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00b7 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00b7 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00b7 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzawo r0 = r7.zzt     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzawk r0 = r0.zzc()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0042
            android.view.View r1 = r8.zzf()     // Catch:{ all -> 0x00b7 }
            r0.zzo(r1)     // Catch:{ all -> 0x00b7 }
        L_0x0042:
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzbK     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00b7 }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00b7 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00b7 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00a4
            com.google.android.gms.internal.ads.zzffn r0 = r7.zzb     // Catch:{ all -> 0x00b7 }
            boolean r1 = r0.zzal     // Catch:{ all -> 0x00b7 }
            if (r1 != 0) goto L_0x005b
            goto L_0x00a4
        L_0x005b:
            org.json.JSONObject r0 = r0.zzak     // Catch:{ all -> 0x00b7 }
            java.util.Iterator r0 = r0.keys()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00a4
        L_0x0063:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00b7 }
            if (r1 == 0) goto L_0x00a4
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00b7 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzdmu r2 = r7.zzo     // Catch:{ all -> 0x00b7 }
            java.util.Map r2 = r2.zzl()     // Catch:{ all -> 0x00b7 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x00b7 }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x00b7 }
            java.util.Map r3 = r7.zzy     // Catch:{ all -> 0x00b7 }
            r4 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)     // Catch:{ all -> 0x00b7 }
            r3.put(r1, r4)     // Catch:{ all -> 0x00b7 }
            if (r2 == 0) goto L_0x0063
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x00b7 }
            android.view.View r2 = (android.view.View) r2     // Catch:{ all -> 0x00b7 }
            if (r2 == 0) goto L_0x0063
            android.content.Context r3 = r7.zzv     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzazz r4 = new com.google.android.gms.internal.ads.zzazz     // Catch:{ all -> 0x00b7 }
            r4.<init>(r3, r2)     // Catch:{ all -> 0x00b7 }
            java.util.List r2 = r7.zzz     // Catch:{ all -> 0x00b7 }
            r2.add(r4)     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzdkq r2 = new com.google.android.gms.internal.ads.zzdkq     // Catch:{ all -> 0x00b7 }
            r2.<init>(r7, r1)     // Catch:{ all -> 0x00b7 }
            r4.zzc(r2)     // Catch:{ all -> 0x00b7 }
            goto L_0x0063
        L_0x00a4:
            com.google.android.gms.internal.ads.zzazz r0 = r8.zzi()     // Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x00b5
            com.google.android.gms.internal.ads.zzazz r8 = r8.zzi()     // Catch:{ all -> 0x00b7 }
            com.google.android.gms.internal.ads.zzbzz r0 = r7.zzs     // Catch:{ all -> 0x00b7 }
            r8.zzc(r0)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r7)
            return
        L_0x00b5:
            monitor-exit(r7)
            return
        L_0x00b7:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdkt.zzy(com.google.android.gms.internal.ads.zzdmu):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: zzae */
    public final void zzz(zzdmu zzdmu) {
        this.zzf.zzz(zzdmu.zzf(), zzdmu.zzl());
        if (zzdmu.zzh() != null) {
            zzdmu.zzh().setClickable(false);
            zzdmu.zzh().removeAllViews();
        }
        if (zzdmu.zzi() != null) {
            zzdmu.zzi().zze(this.zzs);
        }
        this.zzo = null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00e8, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzA(android.view.View r4, java.util.Map r5, java.util.Map r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzq     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x0007
            goto L_0x00e7
        L_0x0007:
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzbK     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00ee }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00ee }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00ee }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzffn r0 = r3.zzb     // Catch:{ all -> 0x00ee }
            boolean r0 = r0.zzal     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x0045
            java.util.Map r0 = r3.zzy     // Catch:{ all -> 0x00ee }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x00ee }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00ee }
        L_0x0029:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00ee }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00ee }
            java.util.Map r2 = r3.zzy     // Catch:{ all -> 0x00ee }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x00ee }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x00ee }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00ee }
            if (r1 != 0) goto L_0x0029
            goto L_0x00e7
        L_0x0045:
            if (r7 != 0) goto L_0x0088
            com.google.android.gms.internal.ads.zzbdq r7 = com.google.android.gms.internal.ads.zzbdz.zzdN     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.ads.zzbdx r0 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00ee }
            java.lang.Object r7 = r0.zza(r7)     // Catch:{ all -> 0x00ee }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x00ee }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x00ee }
            if (r7 == 0) goto L_0x00e7
            if (r5 == 0) goto L_0x00e7
            java.util.Set r7 = r5.entrySet()     // Catch:{ all -> 0x00ee }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00ee }
        L_0x0063:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x00e7
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x00ee }
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch:{ all -> 0x00ee }
            java.lang.Object r0 = r0.getValue()     // Catch:{ all -> 0x00ee }
            java.lang.ref.WeakReference r0 = (java.lang.ref.WeakReference) r0     // Catch:{ all -> 0x00ee }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x00ee }
            android.view.View r0 = (android.view.View) r0     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x0063
            boolean r0 = zzW(r0)     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x0063
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x00ee }
            monitor-exit(r3)
            return
        L_0x0088:
            android.view.View r7 = r3.zzY(r5)     // Catch:{ all -> 0x00ee }
            if (r7 != 0) goto L_0x0093
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x00ee }
            monitor-exit(r3)
            return
        L_0x0093:
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzdO     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00ee }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00ee }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00ee }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x00b0
            boolean r7 = zzW(r7)     // Catch:{ all -> 0x00ee }
            if (r7 == 0) goto L_0x00e7
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x00ee }
            monitor-exit(r3)
            return
        L_0x00b0:
            com.google.android.gms.internal.ads.zzbdq r0 = com.google.android.gms.internal.ads.zzbdz.zzdP     // Catch:{ all -> 0x00ee }
            com.google.android.gms.internal.ads.zzbdx r1 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch:{ all -> 0x00ee }
            java.lang.Object r0 = r1.zza(r0)     // Catch:{ all -> 0x00ee }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00ee }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00ee }
            if (r0 == 0) goto L_0x00e9
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ all -> 0x00ee }
            r0.<init>()     // Catch:{ all -> 0x00ee }
            r1 = 0
            boolean r1 = r7.getGlobalVisibleRect(r0, r1)     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00e7
            int r1 = r7.getHeight()     // Catch:{ all -> 0x00ee }
            int r2 = r0.height()     // Catch:{ all -> 0x00ee }
            if (r1 != r2) goto L_0x00e7
            int r7 = r7.getWidth()     // Catch:{ all -> 0x00ee }
            int r0 = r0.width()     // Catch:{ all -> 0x00ee }
            if (r7 != r0) goto L_0x00e7
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x00ee }
            monitor-exit(r3)
            return
        L_0x00e7:
            monitor-exit(r3)
            return
        L_0x00e9:
            r3.zzab(r4, r5, r6)     // Catch:{ all -> 0x00ee }
            monitor-exit(r3)
            return
        L_0x00ee:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdkt.zzA(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzB(zzcw zzcw) {
        this.zzf.zzj(zzcw);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzC(android.view.View r10, android.view.View r11, java.util.Map r12, java.util.Map r13, boolean r14) {
        /*
            r9 = this;
            monitor-enter(r9)
            com.google.android.gms.internal.ads.zzdly r0 = r9.zzg     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzdmu r1 = r9.zzo     // Catch:{ all -> 0x0035 }
            r0.zzc(r1)     // Catch:{ all -> 0x0035 }
            android.widget.ImageView$ScaleType r8 = r9.zzZ()     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzdlg r2 = r9.zzf     // Catch:{ all -> 0x0035 }
            r3 = r10
            r4 = r11
            r5 = r12
            r6 = r13
            r7 = r14
            r2.zzk(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0035 }
            boolean r10 = r9.zzr     // Catch:{ all -> 0x0035 }
            if (r10 == 0) goto L_0x0033
            com.google.android.gms.internal.ads.zzdky r10 = r9.zze     // Catch:{ all -> 0x0035 }
            com.google.android.gms.internal.ads.zzcgm r11 = r10.zzs()     // Catch:{ all -> 0x0035 }
            if (r11 != 0) goto L_0x0023
            goto L_0x0033
        L_0x0023:
            com.google.android.gms.internal.ads.zzcgm r10 = r10.zzs()     // Catch:{ all -> 0x0035 }
            androidx.collection.ArrayMap r11 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0035 }
            r11.<init>()     // Catch:{ all -> 0x0035 }
            java.lang.String r12 = "onSdkAdUserInteractionClick"
            r10.zzd(r12, r11)     // Catch:{ all -> 0x0035 }
            monitor-exit(r9)
            return
        L_0x0033:
            monitor-exit(r9)
            return
        L_0x0035:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdkt.zzC(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzD(View view, int i) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzlj)).booleanValue()) {
            zzdmu zzdmu = this.zzo;
            if (zzdmu == null) {
                zzm.zze("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            } else {
                this.zzd.execute(new zzdkn(this, view, zzdmu instanceof zzdls, i));
            }
        }
    }

    public final synchronized void zzE(String str) {
        this.zzf.zzl(str);
    }

    public final synchronized void zzF(Bundle bundle) {
        this.zzf.zzm(bundle);
    }

    public final synchronized void zzG() {
        zzdmu zzdmu = this.zzo;
        if (zzdmu == null) {
            zzm.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzd.execute(new zzdkp(this, zzdmu instanceof zzdls));
        }
    }

    public final synchronized void zzH() {
        if (!this.zzq) {
            this.zzf.zzr();
        }
    }

    public final void zzI(View view) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfc)).booleanValue()) {
            zzcbw zzp2 = this.zze.zzp();
            if (zzp2 != null) {
                zzgee.zzr(zzp2, new zzdks(this, view), this.zzd);
                return;
            }
            return;
        }
        zzac(view, this.zze.zzu());
    }

    public final synchronized void zzJ(View view, MotionEvent motionEvent, View view2) {
        this.zzf.zzs(view, motionEvent, view2);
    }

    public final synchronized void zzK(Bundle bundle) {
        this.zzf.zzt(bundle);
    }

    public final synchronized void zzL(View view) {
        this.zzf.zzu(view);
    }

    public final synchronized void zzM() {
        this.zzf.zzv();
    }

    public final synchronized void zzN(zzcs zzcs) {
        this.zzf.zzw(zzcs);
    }

    public final synchronized void zzO(zzdg zzdg) {
        this.zzx.zza(zzdg);
    }

    public final synchronized void zzP(zzbiy zzbiy) {
        this.zzf.zzx(zzbiy);
    }

    public final synchronized void zzQ(zzdmu zzdmu) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzbI)).booleanValue()) {
            zzt.zza.post(new zzdkj(this, zzdmu));
        } else {
            zzy(zzdmu);
        }
    }

    public final synchronized void zzR(zzdmu zzdmu) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzbI)).booleanValue()) {
            zzt.zza.post(new zzdkk(this, zzdmu));
        } else {
            zzz(zzdmu);
        }
    }

    public final boolean zzS() {
        return this.zzh.zze();
    }

    public final synchronized boolean zzT() {
        return this.zzf.zzA();
    }

    public final synchronized boolean zzU() {
        return this.zzf.zzB();
    }

    public final boolean zzV() {
        return this.zzh.zzd();
    }

    public final synchronized boolean zzX(Bundle bundle) {
        if (this.zzq) {
            return true;
        }
        boolean zzC = this.zzf.zzC(bundle);
        this.zzq = zzC;
        return zzC;
    }

    public final synchronized int zza() {
        return this.zzf.zza();
    }

    public final synchronized void zzb() {
        this.zzp = true;
        this.zzd.execute(new zzdko(this));
        super.zzb();
    }

    public final zzdkv zzc() {
        return this.zzw;
    }

    public final zzfmy zzf(String str, boolean z) {
        String str2;
        zzegd zzegd;
        zzege zzege;
        zzege zzege2;
        if (!this.zzh.zzd() || TextUtils.isEmpty(str)) {
            return null;
        }
        zzdky zzdky = this.zze;
        zzcgm zzr2 = zzdky.zzr();
        zzcgm zzs2 = zzdky.zzs();
        if (zzr2 == null && zzs2 == null) {
            zzm.zzj("Omid display and video webview are null. Skipping initialization.");
            return null;
        }
        boolean z2 = false;
        boolean z3 = zzr2 != null;
        boolean z4 = zzs2 != null;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfa)).booleanValue()) {
            this.zzh.zza();
            int zzb = this.zzh.zza().zzb();
            int i = zzb - 1;
            if (i != 0) {
                if (i != 1) {
                    zzm.zzj("Unknown omid media type: " + (zzb != 1 ? zzb != 2 ? "UNKNOWN" : "DISPLAY" : "VIDEO") + ". Not initializing Omid.");
                    return null;
                } else if (zzr2 != null) {
                    z4 = false;
                    z2 = true;
                } else {
                    zzm.zzj("Omid media type was display but there was no display webview.");
                    return null;
                }
            } else if (zzs2 != null) {
                z4 = true;
            } else {
                zzm.zzj("Omid media type was video but there was no video webview.");
                return null;
            }
        } else {
            z2 = z3;
        }
        if (z2) {
            str2 = null;
        } else {
            str2 = "javascript";
            zzr2 = zzs2;
        }
        zzr2.zzG();
        if (!zzu.zzA().zzj(this.zzv)) {
            zzm.zzj("Failed to initialize omid in InternalNativeAd");
            return null;
        }
        VersionInfoParcel versionInfoParcel = this.zzu;
        String str3 = versionInfoParcel.buddyApkVersion + "." + versionInfoParcel.clientJarVersion;
        if (z4) {
            zzegd = zzegd.VIDEO;
            zzege = zzege.DEFINED_BY_JAVASCRIPT;
        } else {
            zzdky zzdky2 = this.zze;
            zzegd zzegd2 = zzegd.NATIVE_DISPLAY;
            if (zzdky2.zzc() == 3) {
                zzege2 = zzege.UNSPECIFIED;
            } else {
                zzege2 = zzege.ONE_PIXEL;
            }
            zzege = zzege2;
            zzegd = zzegd2;
        }
        zzfmy zzb2 = zzu.zzA().zzb(str3, zzr2.zzG(), "", "javascript", str2, str, zzege, zzegd, this.zzb.zzam);
        if (zzb2 == null) {
            zzm.zzj("Failed to create omid session in InternalNativeAd");
            return null;
        }
        this.zze.zzW(zzb2);
        zzr2.zzaq(zzb2);
        if (z4) {
            zzu.zzA().zzh(zzb2, zzs2.zzF());
            this.zzr = true;
        }
        if (z) {
            zzu.zzA().zzi(zzb2);
            zzr2.zzd("onSdkLoaded", new ArrayMap());
        }
        return zzb2;
    }

    public final String zzg() {
        return this.zzh.zzb();
    }

    public final synchronized JSONObject zzi(View view, Map map, Map map2) {
        return this.zzf.zze(view, map, map2, zzZ());
    }

    public final void zzj() {
        this.zzd.execute(new zzdkl(this));
        if (this.zze.zzc() != 7) {
            Executor executor = this.zzd;
            zzdlg zzdlg = this.zzf;
            Objects.requireNonNull(zzdlg);
            executor.execute(new zzdkm(zzdlg));
        }
        super.zzj();
    }

    public final synchronized JSONObject zzk(View view, Map map, Map map2) {
        return this.zzf.zzf(view, map, map2, zzZ());
    }

    public final void zzt(View view) {
        zzfmy zzu2 = this.zze.zzu();
        if (this.zzh.zzd() && zzu2 != null && view != null) {
            zzu.zzA().zzf(zzu2, view);
        }
    }

    public final synchronized void zzu() {
        this.zzf.zzh();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzv() {
        this.zzf.zzi();
        this.zze.zzI();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzw(View view, boolean z, int i) {
        this.zzf.zzo(view, this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z, zzZ(), i);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzx(boolean z) {
        this.zzf.zzo((View) null, this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z, zzZ(), 0);
    }

    public static /* synthetic */ void zzr(zzdkt zzdkt) {
        try {
            zzdky zzdky = zzdkt.zze;
            int zzc2 = zzdky.zzc();
            if (zzc2 != 1) {
                if (zzc2 != 2) {
                    if (zzc2 != 3) {
                        if (zzc2 != 6) {
                            if (zzc2 != 7) {
                                zzm.zzg("Wrong native template id!");
                                return;
                            }
                            zzdlj zzdlj = zzdkt.zzi;
                            if (zzdlj.zzg() != null) {
                                zzdlj.zzg().zzg((zzbnl) zzdkt.zzm.zzb());
                            }
                        } else if (zzdkt.zzi.zzf() != null) {
                            zzdkt.zzaa("Google", true);
                            zzdkt.zzi.zzf().zze((zzbjb) zzdkt.zzl.zzb());
                        }
                    } else if (zzdkt.zzi.zzd(zzdky.zzA()) != null) {
                        if (zzdkt.zze.zzs() != null) {
                            zzdkt.zzf("Google", true);
                        }
                        zzdkt.zzi.zzd(zzdkt.zze.zzA()).zze((zzbhy) zzdkt.zzn.zzb());
                    }
                } else if (zzdkt.zzi.zza() != null) {
                    zzdkt.zzaa("Google", true);
                    zzdkt.zzi.zza().zze((zzbht) zzdkt.zzk.zzb());
                }
            } else if (zzdkt.zzi.zzb() != null) {
                zzdkt.zzaa("Google", true);
                zzdkt.zzi.zzb().zze((zzbhv) zzdkt.zzj.zzb());
            }
        } catch (RemoteException e) {
            zzm.zzh("RemoteException when notifyAdLoad is called", e);
        }
    }
}
