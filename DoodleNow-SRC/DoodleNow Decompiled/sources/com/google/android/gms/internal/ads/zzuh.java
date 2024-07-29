package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzuh implements zzvj {
    private final ArrayList zza = new ArrayList(1);
    private final HashSet zzb = new HashSet(1);
    private final zzvq zzc = new zzvq();
    private final zzsg zzd = new zzsg();
    private Looper zze;
    private zzcx zzf;
    private zzpb zzg;

    public /* synthetic */ zzcx zzM() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final zzpb zzb() {
        zzpb zzpb = this.zzg;
        zzek.zzb(zzpb);
        return zzpb;
    }

    /* access modifiers changed from: protected */
    public final zzsg zzc(zzvh zzvh) {
        return this.zzd.zza(0, zzvh);
    }

    /* access modifiers changed from: protected */
    public final zzsg zzd(int i, zzvh zzvh) {
        return this.zzd.zza(0, zzvh);
    }

    /* access modifiers changed from: protected */
    public final zzvq zze(zzvh zzvh) {
        return this.zzc.zza(0, zzvh);
    }

    /* access modifiers changed from: protected */
    public final zzvq zzf(int i, zzvh zzvh) {
        return this.zzc.zza(0, zzvh);
    }

    public final void zzg(Handler handler, zzsh zzsh) {
        this.zzd.zzb(handler, zzsh);
    }

    public final void zzh(Handler handler, zzvr zzvr) {
        this.zzc.zzb(handler, zzvr);
    }

    public final void zzi(zzvi zzvi) {
        boolean z = !this.zzb.isEmpty();
        this.zzb.remove(zzvi);
        if (z && this.zzb.isEmpty()) {
            zzj();
        }
    }

    /* access modifiers changed from: protected */
    public void zzj() {
    }

    /* access modifiers changed from: protected */
    public void zzl() {
    }

    public final void zzm(zzvi zzvi, zzhy zzhy, zzpb zzpb) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.zze;
        boolean z = true;
        if (!(looper == null || looper == myLooper)) {
            z = false;
        }
        zzek.zzd(z);
        this.zzg = zzpb;
        zzcx zzcx = this.zzf;
        this.zza.add(zzvi);
        if (this.zze == null) {
            this.zze = myLooper;
            this.zzb.add(zzvi);
            zzn(zzhy);
        } else if (zzcx != null) {
            zzk(zzvi);
            zzvi.zza(this, zzcx);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzn(zzhy zzhy);

    /* access modifiers changed from: protected */
    public final void zzo(zzcx zzcx) {
        this.zzf = zzcx;
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((zzvi) arrayList.get(i)).zza(this, zzcx);
        }
    }

    public final void zzp(zzvi zzvi) {
        this.zza.remove(zzvi);
        if (this.zza.isEmpty()) {
            this.zze = null;
            this.zzf = null;
            this.zzg = null;
            this.zzb.clear();
            zzq();
            return;
        }
        zzi(zzvi);
    }

    /* access modifiers changed from: protected */
    public abstract void zzq();

    public final void zzr(zzsh zzsh) {
        this.zzd.zzc(zzsh);
    }

    public final void zzs(zzvr zzvr) {
        this.zzc.zzh(zzvr);
    }

    public /* synthetic */ void zzt(zzbp zzbp) {
        throw null;
    }

    /* access modifiers changed from: protected */
    public final boolean zzu() {
        return !this.zzb.isEmpty();
    }

    public /* synthetic */ boolean zzv() {
        return true;
    }

    public final void zzk(zzvi zzvi) {
        this.zze.getClass();
        HashSet hashSet = this.zzb;
        boolean isEmpty = hashSet.isEmpty();
        hashSet.add(zzvi);
        if (isEmpty) {
            zzl();
        }
    }
}
