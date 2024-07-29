package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzl;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcbl implements zzbar {
    final zzcbi zza;
    final HashSet zzb = new HashSet();
    final HashSet zzc = new HashSet();
    private final Object zzd = new Object();
    private final zzg zze;
    private final zzcbj zzf;
    private boolean zzg = false;

    public zzcbl(String str, zzg zzg2) {
        this.zza = new zzcbi(str, zzg2);
        this.zze = zzg2;
        this.zzf = new zzcbj();
    }

    public final void zza(boolean z) {
        long currentTimeMillis = zzu.zzB().currentTimeMillis();
        if (z) {
            if (currentTimeMillis - this.zze.zzc() > ((Long) zzba.zzc().zza(zzbdz.zzaT)).longValue()) {
                this.zza.zzd = -1;
            } else {
                this.zza.zzd = this.zze.zzb();
            }
            this.zzg = true;
            return;
        }
        this.zze.zzs(currentTimeMillis);
        this.zze.zzI(this.zza.zzd);
    }

    public final int zzb() {
        int zza2;
        synchronized (this.zzd) {
            zza2 = this.zza.zza();
        }
        return zza2;
    }

    public final zzcba zzc(Clock clock, String str) {
        return new zzcba(clock, this, this.zzf.zza(), str);
    }

    public final String zzd() {
        return this.zzf.zzb();
    }

    public final void zze(zzcba zzcba) {
        synchronized (this.zzd) {
            this.zzb.add(zzcba);
        }
    }

    public final void zzf() {
        synchronized (this.zzd) {
            this.zza.zzc();
        }
    }

    public final void zzg() {
        synchronized (this.zzd) {
            this.zza.zzd();
        }
    }

    public final void zzh() {
        synchronized (this.zzd) {
            this.zza.zze();
        }
    }

    public final void zzi() {
        synchronized (this.zzd) {
            this.zza.zzf();
        }
    }

    public final void zzj(zzl zzl, long j) {
        synchronized (this.zzd) {
            this.zza.zzg(zzl, j);
        }
    }

    public final void zzk() {
        synchronized (this.zzd) {
            this.zza.zzh();
        }
    }

    public final void zzl(HashSet hashSet) {
        synchronized (this.zzd) {
            this.zzb.addAll(hashSet);
        }
    }

    public final boolean zzm() {
        return this.zzg;
    }

    public final Bundle zzn(Context context, zzfhq zzfhq) {
        HashSet hashSet = new HashSet();
        synchronized (this.zzd) {
            hashSet.addAll(this.zzb);
            this.zzb.clear();
        }
        Bundle bundle = new Bundle();
        bundle.putBundle("app", this.zza.zzb(context, this.zzf.zzb()));
        Bundle bundle2 = new Bundle();
        Iterator it = this.zzc.iterator();
        if (!it.hasNext()) {
            bundle.putBundle("slots", bundle2);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = hashSet.iterator();
            while (it2.hasNext()) {
                arrayList.add(((zzcba) it2.next()).zza());
            }
            bundle.putParcelableArrayList("ads", arrayList);
            zzfhq.zzc(hashSet);
            return bundle;
        }
        zzcbk zzcbk = (zzcbk) it.next();
        throw null;
    }
}
