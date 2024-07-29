package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdef {
    /* access modifiers changed from: private */
    public final Set zza = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzb = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzc = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzd = new HashSet();
    /* access modifiers changed from: private */
    public final Set zze = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzf = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzg = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzh = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzi = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzj = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzk = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzl = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzm = new HashSet();
    /* access modifiers changed from: private */
    public final Set zzn = new HashSet();
    /* access modifiers changed from: private */
    public zzfdb zzo;

    public final zzdef zza(zza zza2, Executor executor) {
        this.zzc.add(new zzdgf(zza2, executor));
        return this;
    }

    public final zzdef zzb(zzcyt zzcyt, Executor executor) {
        this.zzi.add(new zzdgf(zzcyt, executor));
        return this;
    }

    public final zzdef zzc(zzczg zzczg, Executor executor) {
        this.zzl.add(new zzdgf(zzczg, executor));
        return this;
    }

    public final zzdef zzd(zzczk zzczk, Executor executor) {
        this.zzf.add(new zzdgf(zzczk, executor));
        return this;
    }

    public final zzdef zze(zzcyq zzcyq, Executor executor) {
        this.zze.add(new zzdgf(zzcyq, executor));
        return this;
    }

    public final zzdef zzf(zzdae zzdae, Executor executor) {
        this.zzh.add(new zzdgf(zzdae, executor));
        return this;
    }

    public final zzdef zzg(zzdap zzdap, Executor executor) {
        this.zzg.add(new zzdgf(zzdap, executor));
        return this;
    }

    public final zzdef zzh(zzp zzp, Executor executor) {
        this.zzn.add(new zzdgf(zzp, executor));
        return this;
    }

    public final zzdef zzi(zzdbb zzdbb, Executor executor) {
        this.zzm.add(new zzdgf(zzdbb, executor));
        return this;
    }

    public final zzdef zzj(zzdbl zzdbl, Executor executor) {
        this.zzb.add(new zzdgf(zzdbl, executor));
        return this;
    }

    public final zzdef zzk(AppEventListener appEventListener, Executor executor) {
        this.zzk.add(new zzdgf(appEventListener, executor));
        return this;
    }

    public final zzdef zzl(zzdgn zzdgn, Executor executor) {
        this.zzd.add(new zzdgf(zzdgn, executor));
        return this;
    }

    public final zzdef zzm(zzfdb zzfdb) {
        this.zzo = zzfdb;
        return this;
    }

    public final zzdeh zzn() {
        return new zzdeh(this, (zzdeg) null);
    }
}
